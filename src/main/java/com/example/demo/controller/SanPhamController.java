package com.example.demo.controller;

import com.example.demo.model.SanPham;
import com.example.demo.repository.SanPhamRepository;
import com.example.demo.service.SanPhamService;
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
@RequestMapping("/san-pham")
public class SanPhamController {


    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @ModelAttribute("sanPham") SanPham sanPham,
                          @RequestParam("pageNum") Optional<Integer> pageNum,
                          @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {

        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<SanPham> page = sanPhamService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "trang-home-sanpham";
    }

    @PostMapping("add-san-pham")
    public String addSanPham(Model model, @ModelAttribute("sanPham") SanPham sanPham, @RequestParam("pageNum") Optional<Integer> pageNum,
                             @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        sanPhamService.add(sanPham);
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<SanPham> page = sanPhamService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "redirect:/san-pham/hien-thi";
    }

    @PostMapping("/update-san-pham/{id}")
    public String updateSanPham(Model model, @PathVariable("id") UUID id, @ModelAttribute("sanPham") SanPham sanPham, @RequestParam("pageNum") Optional<Integer> pageNum,
                                @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        SanPham sp = sanPhamService.getOne(id);
        sp.setMa(sanPham.getMa());
        sp.setTen(sanPham.getTen());
        sanPhamService.update(sp);
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<SanPham> page = sanPhamService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("/remove-san-pham/{id}")
    public String delete(Model model, @PathVariable("id") UUID id, @RequestParam("pageNum") Optional<Integer> pageNum,
                         @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize, @ModelAttribute("sanPham") SanPham sanPham) {
        sanPhamService.delete(id);
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<SanPham> page = sanPhamService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("/detail-san-pham/{id}")
    public String detail(Model model, @PathVariable("id") UUID id, @RequestParam("pageNum") Optional<Integer> pageNum,
                         @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        SanPham sp = sanPhamService.getOne(id);
        model.addAttribute("sanPham", sp);
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<SanPham> page = sanPhamService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "trang-home-sanpham";
    }

    @GetMapping("/view-update-san-pham/{id}")
    public String viewUpdate(Model model, @PathVariable("id") UUID id) {
        SanPham sp = sanPhamService.getOne(id);
        model.addAttribute("sanPham", sp);
        return "updatesanpham";
    }

    @PostMapping("/search-san-pham")
    public String search(Model model, @RequestParam("tenTk") String ten, @ModelAttribute("sanPham") SanPham sanPham, @RequestParam("pageNum") Optional<Integer> pageNum,
                         @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        List<SanPham> listTk = new ArrayList<>();
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<SanPham> page = sanPhamService.getAll(pageable);
        for (SanPham sp : page
        ) {
            if (sp.getTen().contains(ten)) {
                listTk = sanPhamService.search(ten);
            }
        }
        model.addAttribute("list", listTk);
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "trang-home-sanpham";
    }
}
