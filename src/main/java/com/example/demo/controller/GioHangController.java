package com.example.demo.controller;

import com.example.demo.model.GioHang;
import com.example.demo.model.KhachHang;
import com.example.demo.model.NhanVien;
import com.example.demo.service.GioHangService;
import com.example.demo.service.KhachHangService;
import com.example.demo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/gio-hang")
public class GioHangController {

    @Autowired
    private GioHangService gioHangService;
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private NhanVienService nhanVienService;
    @GetMapping("/hien-thi")
    public String hienThi(Model model, @ModelAttribute("gioHang") GioHang gioHang,
                          @RequestParam("pageNum") Optional<Integer> pageNum,
                          @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {

//        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize);
        Page<GioHang> page = gioHangService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "giohang";
    }

    @PostMapping("add-gio-hang")
    public String addGioHang(Model model, @ModelAttribute("gioHang") GioHang gioHang, @RequestParam("pageNum") Optional<Integer> pageNum,
                             @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        gioHangService.add(gioHang);
//        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize);

        Page<GioHang> page = gioHangService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "redirect:/gio-hang/hien-thi";
    }

    @PostMapping("/updategiohang/{id}")
    public String updateGioHang(Model model, @PathVariable("id") UUID id, @ModelAttribute("gioHang") GioHang gioHang, @RequestParam("pageNum") Optional<Integer> pageNum,
                                @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        GioHang sp = gioHangService.getOne(id);
        sp.setKhachHang(gioHang.getKhachHang());
        sp.setNgayTao(gioHang.getNgayTao());
        sp.setNgayThanhToan(gioHang.getNgayThanhToan());
        sp.setNhanVien(gioHang.getNhanVien());
        sp.setTenNguoiNhan(gioHang.getTenNguoiNhan());
        sp.setDiaChi(gioHang.getDiaChi());
        sp.setMa(gioHang.getMa());
        sp.setSdt(gioHang.getSdt());
        sp.setTinhTrang(gioHang.getTinhTrang());
        gioHangService.update(sp);
//        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize);
        Page<GioHang> page = gioHangService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "redirect:/gio-hang/hien-thi";
    }

    @GetMapping("/remove-gio-hang/{id}")
    public String delete(Model model, @PathVariable("id") UUID id, @RequestParam("pageNum") Optional<Integer> pageNum,
                         @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize, @ModelAttribute("gioHang") GioHang gioHang) {
        gioHangService.delete(id);
//        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize);
        Page<GioHang> page = gioHangService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "redirect:/gio-hang/hien-thi";
    }



    @GetMapping("/detail-gio-hang/{id}")
    public String detail(Model model, @PathVariable("id") UUID id, @RequestParam("pageNum") Optional<Integer> pageNum,
                         @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        GioHang sp = gioHangService.getOne(id);
        model.addAttribute("gioHang", sp);
//        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize);
        Page<GioHang> page = gioHangService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "giohang";
    }

    @GetMapping("/view-update-gio-hang/{id}")
    public String viewUpdate(Model model, @PathVariable("id") UUID id) {
        GioHang sp = gioHangService.getOne(id);
        model.addAttribute("gioHang", sp);
        return "update_giohang";
    }
    @ModelAttribute("nhanVien")
    public List<NhanVien> hienThiNv() {
        return nhanVienService.getTen();
    }

    @ModelAttribute("khachHang")
    public List<KhachHang> hienThiKh() {
        return khachHangService.getTen();
    }

}
