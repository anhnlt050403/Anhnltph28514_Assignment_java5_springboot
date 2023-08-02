package com.example.demo.service.impl;

import com.example.demo.model.HoaDon;
import com.example.demo.repository.HoaDonRepository;
import com.example.demo.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class HoaDonServiceImpl implements HoaDonService {

    @Autowired
    HoaDonRepository repository;

    @Override
    public List<HoaDon> getAll1() {
        return (List<HoaDon>) repository.findAll();
    }

    @Override
    public Page<HoaDon> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public HoaDon getOne(UUID id) {
        return repository.findById(id).orElse(null);

    }


    @Override
    public void ADDvsUPDATE(HoaDon hd) {
        repository.save(hd);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<HoaDon> search(String ten) {
        return null;
    }

    @Override
    public HoaDon timMHD(String mhd) {
        return repository.timMHD(mhd);
    }
}
