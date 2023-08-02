package com.example.demo.service.impl;


import com.example.demo.model.ChiTietSanPham;
import com.example.demo.model.SanPham;
import com.example.demo.repository.ChiTietSpRepository;
import com.example.demo.service.ChiTietSpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ChiTietSpServiceImpl implements ChiTietSpService {

    @Autowired
    ChiTietSpRepository repository;

    @Override
    public List<ChiTietSanPham> getAll1() {
        return repository.findAll();
    }

    @Override
    public Page<ChiTietSanPham> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ChiTietSanPham getOne(UUID id) {
        return repository.detail(id);
    }

    @Override
    public void add(ChiTietSanPham chiTiet) {
        repository.save(chiTiet);
    }

    @Override
    public void delete(UUID chiTiet) {
        repository.deleteById(chiTiet);
    }

    @Override
    public void update(ChiTietSanPham chiTiet) {
        repository.save(chiTiet);
    }
}
