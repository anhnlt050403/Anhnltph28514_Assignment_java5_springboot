package com.example.demo.service.impl;

import com.example.demo.model.MauSac;
import com.example.demo.repository.MauSacRepository;
import com.example.demo.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MauSacServiceImpl implements MauSacService {

    @Autowired
    MauSacRepository repository;

    @Override
    public Page<MauSac> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public MauSac getOne(UUID id) {
        return repository.detail(id);
    }

    @Override
    public void add(MauSac mauSac) {
        repository.save(mauSac);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public void update(MauSac mauSac) {
        repository.save(mauSac);
    }

    @Override
    public List<MauSac> search(String ten) {
        return repository.search(ten);
    }

    @Override
    public List<MauSac> getTen() {
        return repository.findAll();
    }

    @Override
    public List<MauSac> getAll1() {
        return repository.findAll();
    }
}
