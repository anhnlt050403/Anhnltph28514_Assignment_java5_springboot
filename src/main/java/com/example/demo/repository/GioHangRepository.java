package com.example.demo.repository;

import com.example.demo.model.GioHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GioHangRepository extends JpaRepository<GioHang, UUID> {
    @Query("select sp from GioHang sp where sp.id=?1")
    GioHang detail(UUID id);
    @Query("select sp from GioHang  sp")
    Page<GioHang> findAll(Pageable pageable);
}
