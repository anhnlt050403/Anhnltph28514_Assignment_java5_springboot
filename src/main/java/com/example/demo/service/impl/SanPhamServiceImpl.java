package com.example.demo.service.impl;

import com.example.demo.model.SanPham;
import com.example.demo.repository.SanPhamRepository;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    SanPhamRepository repository;

    @Override
    public Page<SanPham> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public SanPham getOne(UUID id) {
        return repository.detail(id);
    }

    @Override
    public void add(SanPham sanPham) {
        repository.save(sanPham);
    }

    @Override
    public void delete(UUID sanPham) {
        repository.deleteById(sanPham);
    }

    @Override
    public void update(SanPham sanPham) {
        repository.save(sanPham);
    }

    @Override
    public List<SanPham> search(String ten) {
        return repository.search(ten);
    }

    @Override
    public List<SanPham> getTen() {
        return repository.findAll();
    }

    @Override
    public List<SanPham> getAll1() {
        return repository.findAll();
    }


}
