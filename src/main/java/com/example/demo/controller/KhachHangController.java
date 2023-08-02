package com.example.demo.controller;

import com.example.demo.model.KhachHang;
import com.example.demo.service.KhachHangService;
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
@RequestMapping("/khach-hang")
public class KhachHangController {

    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @ModelAttribute("khachHang") KhachHang khachHang,
                          @RequestParam("pageNum") Optional<Integer> pageNum,
                          @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {

        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<KhachHang> page = khachHangService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "trang-home-khachhang";
    }

    @PostMapping("add-khach-hang")
    public String addKhachHang(Model model, @ModelAttribute("khachHang") KhachHang khachHang, @RequestParam("pageNum") Optional<Integer> pageNum,
                             @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        khachHangService.add(khachHang);
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<KhachHang> page = khachHangService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "redirect:/khach-hang/hien-thi";
    }

    @PostMapping("/update-khach-hang/{id}")
    public String updateKhachHang(Model model, @PathVariable("id") UUID id, @ModelAttribute("khachHang") KhachHang khachHang, @RequestParam("pageNum") Optional<Integer> pageNum,
                                @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        KhachHang sp = khachHangService.getOne(id);
        sp.setMa(khachHang.getMa());
        sp.setTen(khachHang.getTen());
        sp.setDiaChi(khachHang.getDiaChi());
        sp.setMatKhau(khachHang.getMatKhau());
        sp.setNgaySinh(khachHang.getNgaySinh());
        sp.setQuocGia(khachHang.getQuocGia());
        sp.setSdt(khachHang.getSdt());
        sp.setTenDem(khachHang.getTenDem());
        sp.setThanhPho(khachHang.getThanhPho());
        sp.setHo(khachHang.getHo());
        khachHangService.update(sp);
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<KhachHang> page = khachHangService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("/remove-khach-hang/{id}")
    public String delete(Model model, @PathVariable("id") UUID id, @RequestParam("pageNum") Optional<Integer> pageNum,
                         @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize, @ModelAttribute("khachHang") KhachHang khachHang) {
        khachHangService.delete(id);
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<KhachHang> page = khachHangService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("/detail-khach-hang/{id}")
    public String detail(Model model, @PathVariable("id") UUID id, @RequestParam("pageNum") Optional<Integer> pageNum,
                         @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        KhachHang sp = khachHangService.getOne(id);
        model.addAttribute("khachHang", sp);
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<KhachHang> page = khachHangService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "trang-home-khachhang";
    }

    @GetMapping("/view-update-khach-hang/{id}")
    public String viewUpdate(Model model, @PathVariable("id") UUID id) {
        KhachHang sp = khachHangService.getOne(id);
        model.addAttribute("khachHang", sp);
        return "updatekhachhang";
    }

    @PostMapping("/search-khach-hang")
    public String search(Model model, @RequestParam("tenTk") String ten, @ModelAttribute("khachHang") KhachHang khachHang, @RequestParam("pageNum") Optional<Integer> pageNum,
                         @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        List<KhachHang> listTk = new ArrayList<>();
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<KhachHang> page = khachHangService.getAll(pageable);
        for (KhachHang sp : page
        ) {
            if (sp.getTen().contains(ten)) {
                listTk = khachHangService.search(ten);
            }
        }
        model.addAttribute("list", listTk);
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "trang-home-khachhang";
    }
}
