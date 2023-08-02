package com.example.demo.repository;

import com.example.demo.model.CuaHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CuaHangRepository extends JpaRepository<CuaHang, UUID> {
    @Query("select sp from CuaHang sp where sp.id=?1")
    CuaHang detail(UUID id);
    @Query("select sp from CuaHang  sp where sp.ten like %?1%")
    List<CuaHang> search(String ten);
    @Query("select sp from CuaHang  sp")
    Page<CuaHang> findAll(Pageable pageable);
}
