package com.example.demo.service;

import com.example.demo.model.ChiTietSanPham;
import com.example.demo.model.DongSanPham;
import com.example.demo.model.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface DongSPService {

    public Page<DongSanPham> getAll(Pageable pageable);
    public DongSanPham getOne(UUID id);
    public void add(DongSanPham dongSanPham);
    public void delete(UUID id);
    public void update(DongSanPham dongSanPham);
    public List<DongSanPham> search(String ten);
    public List<DongSanPham> getTen();
    public List<DongSanPham> getAll1();
}
