package com.example.demo.service.impl;

import com.example.demo.model.GioHang;
import com.example.demo.repository.GioHangRepository;
import com.example.demo.service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class GioHangServiceImpl implements GioHangService {

    @Autowired
    GioHangRepository gioHangRepository;


    @Override
    public List<GioHang> getAll1() {
        return gioHangRepository.findAll();
    }

    @Override
    public Page<GioHang> getAll(Pageable pageable) {
        return gioHangRepository.findAll(pageable);
    }

    @Override
    public GioHang getOne(UUID id) {

        return gioHangRepository.detail(id);
    }

    @Override
    public void add(GioHang gioHang) {
gioHangRepository.save(gioHang);
    }

    @Override
    public void delete(UUID id) {
gioHangRepository.deleteById(id);
    }

    @Override
    public void update(GioHang gioHang) {
        gioHangRepository.save(gioHang);

    }

    @Override
    public List<GioHang> getTen() {
        return gioHangRepository.findAll();
    }
}
