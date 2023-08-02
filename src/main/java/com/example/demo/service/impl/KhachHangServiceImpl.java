package com.example.demo.service.impl;

import com.example.demo.model.KhachHang;
import com.example.demo.repository.KhachHangRepository;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    KhachHangRepository repository;

    @Override
    public ArrayList<KhachHang> getAll1() {
        return (ArrayList<KhachHang>) repository.findAll();

    }

    @Override
    public Page<KhachHang> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public KhachHang getOne(UUID id) {
        return repository.detail(id);
    }

    @Override
    public void add(KhachHang khachHang) {
        repository.save(khachHang);
    }

    @Override
    public void delete(UUID khachHang) {
        repository.deleteById(khachHang);
    }

    @Override
    public void update(KhachHang khachHang) {
        repository.save(khachHang);
    }

    @Override
    public List<KhachHang> search(String ten) {
        return repository.search(ten);
    }

    @Override
    public List<KhachHang> getTen() {
        return repository.findAll();
    }
}
