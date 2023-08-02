package com.example.demo.service;

import com.example.demo.model.ChiTietSanPham;
import com.example.demo.model.NhanVien;
import com.example.demo.model.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface NhanVienService {

    public List<NhanVien> getAll1();


    public Page<NhanVien> getAll(Pageable pageable);
    public NhanVien getOne(UUID id);
    public void add(NhanVien nhanVien);
    public void delete(UUID id);
    public void update(NhanVien nhanVien);
    public List<NhanVien> search(String ten);

   public List<NhanVien> getTen();

}
