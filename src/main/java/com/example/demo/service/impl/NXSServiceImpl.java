package com.example.demo.service.impl;

import com.example.demo.model.NhaSanXuat;
import com.example.demo.repository.NXSRepository;
import com.example.demo.service.NXSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class NXSServiceImpl implements NXSService {

    @Autowired
    NXSRepository repository;

    @Override
    public Page<NhaSanXuat> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public NhaSanXuat getOne(UUID id) {
        return repository.detail(id);
    }

    @Override
    public void add(NhaSanXuat nha) {
        repository.save(nha);
    }

    @Override
    public void delete(UUID nha) {
        repository.deleteById(nha);
    }

    @Override
    public void update(NhaSanXuat nha) {
        repository.save(nha);
    }

    @Override
    public List<NhaSanXuat> search(String ten) {
        return repository.search(ten);
    }

    @Override
    public List<NhaSanXuat> getTen() {
        return repository.findAll();
    }

    @Override
    public List<NhaSanXuat> getAll1() {
        return repository.findAll();
    }
}
