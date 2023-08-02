package com.example.demo.service.impl;

import com.example.demo.model.CuaHang;
import com.example.demo.model.SanPham;
import com.example.demo.repository.CuaHangRepository;
import com.example.demo.service.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CuaHangServiceImpl implements CuaHangService {

    @Autowired
    CuaHangRepository repository;

    @Override
    public Page<CuaHang> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ArrayList<CuaHang> getTen() {
        return (ArrayList<CuaHang>) repository.findAll();
    }

    @Override
    public CuaHang getOne(UUID id) {
        return repository.detail(id);
    }

    @Override
    public void add(CuaHang cuaHang) {
        repository.save(cuaHang);
    }

    @Override
    public void delete(UUID cuaHang) {
        repository.deleteById(cuaHang);
    }

    @Override
    public void update(CuaHang cuaHang) {
        repository.save(cuaHang);
    }

    @Override
    public List<CuaHang> search(String ten) {
        return repository.search(ten);
    }

    @Override
    public List<CuaHang> getAll1() {
        return repository.findAll();
    }
}
