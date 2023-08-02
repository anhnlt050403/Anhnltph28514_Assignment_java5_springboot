package com.example.demo.repository;

import com.example.demo.model.NhanVien;
import com.example.demo.model.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {

    @Query("select sp from NhanVien sp where sp.id=?1")
    NhanVien detail(UUID id);
    @Query("select sp from NhanVien  sp where sp.ten like %?1%")
    List<NhanVien> search(String ten);
    @Query("select sp from NhanVien  sp")
    Page<NhanVien> findAll(Pageable pageable);
}
