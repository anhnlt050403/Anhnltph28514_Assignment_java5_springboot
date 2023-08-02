package com.example.demo.service;

import com.example.demo.model.HoaDonChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface HoaDonChiTietService {
   public List<HoaDonChiTiet> getAll1();
//
    public Page<HoaDonChiTiet> getAll(Pageable pageable);

    public HoaDonChiTiet getOne(UUID id, UUID id1);

    public HoaDonChiTiet getOne1(Integer sl);

    public void ADDvsUPDATE(HoaDonChiTiet hoaDonChiTiet);

    public void themsql(UUID id1, UUID id2, Integer sl, BigDecimal dg);

    public void delete(UUID id, UUID id1);

    public List<HoaDonChiTiet> search(String ten);

    public List<HoaDonChiTiet> detailall(UUID id);

    public Integer tongSanPham(UUID id);

    public Integer tongTien(UUID id);
}
