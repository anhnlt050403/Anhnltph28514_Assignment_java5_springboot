package com.example.demo.service.impl;

import com.example.demo.model.DongSanPham;
import com.example.demo.repository.DongSpRepository;
import com.example.demo.service.DongSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DongSpServiceImpl implements DongSPService {

    @Autowired
    DongSpRepository repository;

    @Override
    public Page<DongSanPham> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public DongSanPham getOne(UUID id) {
        return repository.detail(id);
    }

    @Override
    public void add(DongSanPham dongSanPham) {
        repository.save(dongSanPham);
    }

    @Override
    public void delete(UUID dongSanPham) {
        repository.deleteById(dongSanPham);
    }

    @Override
    public void update(DongSanPham dongSanPham)
    {
        repository.save(dongSanPham);
    }

    @Override
    public List<DongSanPham> search(String ten) {
        return repository.search(ten);
    }

    @Override
    public List<DongSanPham> getTen() {
        return repository.findAll();
    }

    @Override
    public List<DongSanPham> getAll1() {
        return repository.findAll();
    }
}
