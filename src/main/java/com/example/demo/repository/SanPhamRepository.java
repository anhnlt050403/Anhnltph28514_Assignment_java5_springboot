package com.example.demo.repository;

import com.example.demo.model.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.UUID;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, UUID> {
    @Query("select sp from SanPham sp where sp.id=?1")
    SanPham detail(UUID id);
    @Query("select sp from SanPham  sp where sp.ten like %?1%")
    List<SanPham> search(String ten);
    @Query("select sp from SanPham  sp")
    Page<SanPham> findAll(Pageable pageable);
}
