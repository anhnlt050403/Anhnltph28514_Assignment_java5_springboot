package com.example.demo.repository;

import com.example.demo.model.GioHangChiTiet;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, UUID> {
    @Query("select  sp from GioHangChiTiet sp where sp.id.gioHang.id=?1 and sp.id.chiTietSP.id=?2")
    GioHangChiTiet detail(UUID id, UUID id1);

    @Transactional
    @Modifying
    @Query("DELETE FROM GioHangChiTiet sp WHERE sp.id.gioHang.id = ?1 AND sp.id.chiTietSP.id = ?2")
    void xoa(UUID id1, UUID id2);


    @Transactional
    @Modifying
    @Query("DELETE FROM GioHangChiTiet sp WHERE sp.id.gioHang.id = ?1 ")
    void xoaful(UUID id1);

    @Query("select  sp from GioHangChiTiet sp where sp.soLuong=?1")
    GioHangChiTiet detail1(Integer sl);

    @Query("select  sp from GioHangChiTiet sp where sp.id.gioHang.id=?1 ")
    List<GioHangChiTiet> timGioHang(UUID id);

}
