package com.example.demo.repository;

import com.example.demo.model.MauSac;
import com.example.demo.model.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac, UUID> {
    @Query("select sp from MauSac sp where sp.id=?1")
    MauSac detail(UUID id);
    @Query("select sp from MauSac  sp where sp.ten like %?1%")
    List<MauSac> search(String ten);
    @Query("select sp from MauSac  sp")
    Page<MauSac> findAll(Pageable pageable);
}
