package com.example.demo.controller;

import com.example.demo.model.MauSac;
import com.example.demo.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/mau-sac")
public class MauSacController {

    @Autowired
    private MauSacService mauSacService;
    @GetMapping("/hien-thi")
    public String hienThi(Model model, @ModelAttribute("mauSac") MauSac mauSac,
                          @RequestParam("pageNum") Optional<Integer> pageNum,
                          @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {

        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<MauSac> page = mauSacService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "trang-home-mausac";
    }

    @PostMapping("add-mau-sac")
    public String addMauSac(Model model, @ModelAttribute("mauSac") MauSac mauSac, @RequestParam("pageNum") Optional<Integer> pageNum,
                             @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        mauSacService.add(mauSac);
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<MauSac> page = mauSacService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "redirect:/mau-sac/hien-thi";
    }

    @PostMapping("/update-mau-sac/{id}")
    public String updateMauSac(Model model, @PathVariable("id") UUID id, @ModelAttribute("mauSac") MauSac mauSac, @RequestParam("pageNum") Optional<Integer> pageNum,
                                @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        MauSac sp = mauSacService.getOne(id);
        sp.setMa(mauSac.getMa());
        sp.setTen(mauSac.getTen());
        mauSacService.update(sp);
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<MauSac> page = mauSacService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("/remove-mau-sac/{id}")
    public String delete(Model model, @PathVariable("id") UUID id, @RequestParam("pageNum") Optional<Integer> pageNum,
                         @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize, @ModelAttribute("mauSac") MauSac mauSac) {
        mauSacService.delete(id);
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<MauSac> page = mauSacService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("/detail-mau-sac/{id}")
    public String detail(Model model, @PathVariable("id") UUID id, @RequestParam("pageNum") Optional<Integer> pageNum,
                         @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        MauSac sp = mauSacService.getOne(id);
        model.addAttribute("mauSac", sp);
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<MauSac> page = mauSacService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "trang-home-mausac";
    }

    @GetMapping("/view-update-mau-sac/{id}")
    public String viewUpdate(Model model, @PathVariable("id") UUID id) {
        MauSac sp = mauSacService.getOne(id);
        model.addAttribute("mauSac", sp);
        return "updatemausac";
    }

    @PostMapping("/search-mau-sac")
    public String search(Model model, @RequestParam("tenTk") String ten, @ModelAttribute("mauSac") MauSac mauSac, @RequestParam("pageNum") Optional<Integer> pageNum,
                         @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        List<MauSac> listTk = new ArrayList<>();
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<MauSac> page = mauSacService.getAll(pageable);
        for (MauSac sp : page
        ) {
            if (sp.getTen().contains(ten)) {
                listTk = mauSacService.search(ten);
            }
        }
        model.addAttribute("list", listTk);
        model.addAttribute("page",page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "trang-home-mausac";
    }
}
