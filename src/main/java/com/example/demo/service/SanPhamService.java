package com.example.demo.service;

import com.example.demo.model.ChiTietSanPham;
import com.example.demo.model.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface SanPhamService {

    public Page<SanPham> getAll(Pageable pageable);
    public SanPham getOne(UUID id);
    public void add(SanPham sanPham);
    public void delete(UUID id);
    public void update(SanPham sanPham);
    public List<SanPham> search(String ten);
    public List<SanPham> getTen();
    public List<SanPham> getAll1();
}
