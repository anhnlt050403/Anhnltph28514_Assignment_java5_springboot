package com.example.demo.repository;

import com.example.demo.model.DongSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DongSpRepository extends JpaRepository<DongSanPham, UUID> {
    @Query("select sp from DongSanPham sp where sp.id=?1")
    DongSanPham detail(UUID id);
    @Query("select sp from DongSanPham  sp where sp.ten like %?1%")
    List<DongSanPham> search(String ten);
    @Query("select sp from DongSanPham  sp")
    Page<DongSanPham> findAll(Pageable pageable);
}
