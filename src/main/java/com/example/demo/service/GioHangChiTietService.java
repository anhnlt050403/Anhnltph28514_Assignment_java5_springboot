package com.example.demo.service;

import com.example.demo.model.GioHangChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface GioHangChiTietService {

    public List<GioHangChiTiet> getAll1();

    public Page<GioHangChiTiet> getAll(Pageable pageable);

    public GioHangChiTiet getOne(UUID id, UUID id1);

    public GioHangChiTiet getOne1(Integer sl);

    public void ADDvsUPDATE(GioHangChiTiet gioHangChiTiet);

    public void delete(UUID id, UUID id1);

    public void delete1(UUID id);
    public List<GioHangChiTiet> search(String ten);
    public List<GioHangChiTiet> timGioHang(UUID ten);

}