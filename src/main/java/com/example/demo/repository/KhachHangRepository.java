package com.example.demo.repository;

import com.example.demo.model.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, UUID> {
    @Query("select sp from KhachHang sp where sp.id=?1")
    KhachHang detail(UUID id);
    @Query("select sp from KhachHang  sp where sp.ten like %?1%")
    List<KhachHang> search(String ten);
    @Query("select sp from KhachHang  sp")
    Page<KhachHang> findAll(Pageable pageable);
}

