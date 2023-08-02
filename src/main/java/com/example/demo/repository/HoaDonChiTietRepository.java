package com.example.demo.repository;

import com.example.demo.model.HoaDonChiTiet;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, UUID> {
    @Query("select  sp from HoaDonChiTiet sp where sp.id.hoaDon.id=?1 and sp.id.chiTietSP.id=?2")
    HoaDonChiTiet detail(UUID id, UUID id1);

    @Transactional
    @Modifying
    @Query("DELETE FROM HoaDonChiTiet sp WHERE sp.id.hoaDon.id = ?1 AND sp.id.chiTietSP.id = ?2")
    void xoa(UUID id1, UUID id2);

    @Query("select  sp from HoaDonChiTiet sp where sp.soLuong=?1")
    HoaDonChiTiet detail1(Integer sl);

    @Query("select  sp from HoaDonChiTiet sp where sp.id.hoaDon.id=?1 ")
    List<HoaDonChiTiet> detailall(UUID id);

}
