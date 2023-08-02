package com.example.demo.service;

import com.example.demo.model.GioHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface GioHangService {
    public List<GioHang> getAll1();
    public Page<GioHang> getAll(Pageable pageable);
    public GioHang getOne(UUID id);
    public void add(GioHang gioHang);
    public void delete(UUID id);
    public void update(GioHang gioHang);
    public List<GioHang> getTen();
}
