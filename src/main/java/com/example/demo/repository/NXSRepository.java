package com.example.demo.repository;


import com.example.demo.model.NhaSanXuat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NXSRepository extends JpaRepository<NhaSanXuat, UUID> {
    @Query("select sp from NhaSanXuat sp where sp.id=?1")
    NhaSanXuat detail(UUID id);
    @Query("select sp from NhaSanXuat  sp where sp.ten like %?1%")
    List<NhaSanXuat> search(String ten);
    @Query("select sp from NhaSanXuat  sp")
    Page<NhaSanXuat> findAll(Pageable pageable);
}

