package com.example.demo.service;

import com.example.demo.model.ChiTietSanPham;
import com.example.demo.model.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface MauSacService {

    public Page<MauSac> getAll(Pageable pageable);
    public MauSac getOne(UUID id);
    public void add(MauSac mauSac);
    public void delete(UUID id);
    public void update(MauSac mauSac);
    public List<MauSac> search(String ten);
    public List<MauSac> getTen();
    public List<MauSac> getAll1();
}
