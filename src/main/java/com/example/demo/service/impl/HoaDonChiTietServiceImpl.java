package com.example.demo.service.impl;

import com.example.demo.model.HoaDonChiTiet;
import com.example.demo.repository.HoaDonChiTietRepository;
import com.example.demo.service.HoaDonChiTietService;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {

@Autowired
HoaDonChiTietRepository hoaDonChiTietRepository;
//
//
    @Override
    public List<HoaDonChiTiet> getAll1() {

        return (List<HoaDonChiTiet>)  hoaDonChiTietRepository.findAll();
    }

    @Override
    public Page<HoaDonChiTiet> getAll(Pageable pageable)
    {
        return hoaDonChiTietRepository.findAll(pageable);

    }

    @Override
    public HoaDonChiTiet getOne(UUID idHD, UUID idCTSP) {
        return hoaDonChiTietRepository.detail(idHD, idCTSP);

    }

    @Override
    public HoaDonChiTiet getOne1(Integer sl) {
        return hoaDonChiTietRepository.detail1(sl);

    }

    @Override
    public void ADDvsUPDATE(HoaDonChiTiet hoaDonChiTiet) {
        hoaDonChiTietRepository.save(hoaDonChiTiet);

    }

    @Override
    public void themsql(UUID id1, UUID id2, Integer sl, BigDecimal dg) {

    }

    @Override
    public void delete(UUID id, UUID id1) {
        hoaDonChiTietRepository.xoa(id, id1);

    }

    @Override
    public List<HoaDonChiTiet> search(String ten) {
        return null;
    }

    @Override
    public List<HoaDonChiTiet> detailall(UUID id) {
        return hoaDonChiTietRepository.detailall(id);
    }

    @Override
    public Integer tongSanPham(UUID id) {
        Integer tongSP = 0;


        for (HoaDonChiTiet hdCT : hoaDonChiTietRepository.detailall(id)) {


            tongSP = hdCT.getSoLuong() + tongSP;


        }

        return tongSP;
    }

    @Override
    public Integer tongTien(UUID id) {
        Integer tongTien = 0;
        for (HoaDonChiTiet hoaDonChiTiet : hoaDonChiTietRepository.detailall(id)) {
            tongTien = tongTien + hoaDonChiTiet.getSoLuong() * hoaDonChiTiet.chuyenDoiDL();

        }
        return tongTien;
    }
}
