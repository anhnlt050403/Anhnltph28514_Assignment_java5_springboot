package com.example.demo.service.impl;

import com.example.demo.model.ChucVu;
import com.example.demo.repository.ChucVuRepository;
import com.example.demo.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ChucVuServiceImpl implements ChucVuService {

    @Autowired
    ChucVuRepository repository;
    @Override
    public Page<ChucVu> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ArrayList<ChucVu> getTen() {
        return (ArrayList<ChucVu>) repository.findAll();
    }

    @Override
    public ChucVu getOne(UUID id) {
        return repository.detail(id);
    }

    @Override
    public void add(ChucVu chucVu) {
        repository.save(chucVu);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public void update(ChucVu chucVu) {
        repository.save(chucVu);
    }

    @Override
    public List<ChucVu> search(String ten) {
        return repository.search(ten);
    }

    @Override
    public List<ChucVu> getAll1() {
        return repository.findAll();
    }

}
