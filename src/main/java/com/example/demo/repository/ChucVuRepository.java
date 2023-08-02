package com.example.demo.repository;

import com.example.demo.model.ChucVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu, UUID> {
    @Query("select sp from ChucVu sp where sp.id=?1")
    ChucVu detail(UUID id);
    @Query("select sp from ChucVu  sp where sp.ten like %?1%")
    List<ChucVu> search(String ten);
    @Query("select sp from ChucVu  sp")
    Page<ChucVu> findAll(Pageable pageable);
}
