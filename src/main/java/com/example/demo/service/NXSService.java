package com.example.demo.service;



import com.example.demo.model.ChiTietSanPham;
import com.example.demo.model.NhaSanXuat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface NXSService {

    public Page<NhaSanXuat> getAll(Pageable pageable);
    public NhaSanXuat getOne(UUID id);
    public void add(NhaSanXuat nhaSanXuat);
    public void delete(UUID id);
    public void update(NhaSanXuat nhaSanXuat);
    public List<NhaSanXuat> search(String ten);
    public List<NhaSanXuat> getTen();
    public List<NhaSanXuat> getAll1();
}
