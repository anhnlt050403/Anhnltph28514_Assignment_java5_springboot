package com.example.demo.controller;


import com.example.demo.model.ChiTietSanPham;
import com.example.demo.model.DongSanPham;
import com.example.demo.model.MauSac;
import com.example.demo.model.NhaSanXuat;
import com.example.demo.model.SanPham;
import com.example.demo.service.ChiTietSpService;
import com.example.demo.service.DongSPService;
import com.example.demo.service.MauSacService;
import com.example.demo.service.NXSService;
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
@RequestMapping("/chi-tiet-sp")
public class ChiTietSpController {

    @Autowired
    private ChiTietSpService chiTietSpService;

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private NXSService nxsService;

    @Autowired
    private DongSPService dongSPService;

    @Autowired
    private MauSacService mauSacService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @ModelAttribute("chiTiet") ChiTietSanPham chiTiet,
                          @RequestParam("pageNum") Optional<Integer> pageNum,
                          @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {

//        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize);
        Page<ChiTietSanPham> page = chiTietSpService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "trang-home-chitietsanpham";
    }

    @PostMapping("add-chi-tiet-sp")
    public String addChiTietSanPham(Model model, @ModelAttribute("chiTiet") ChiTietSanPham chiTiet, @RequestParam("pageNum") Optional<Integer> pageNum,
                             @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        chiTietSpService.add(chiTiet);
//        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize);
        Page<ChiTietSanPham> page = chiTietSpService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "redirect:/chi-tiet-sp/hien-thi";
    }

    @PostMapping("update-chi-tiet-sp/{id}")
    public String updateChiTietSanPham(Model model, @PathVariable("id") UUID id, @ModelAttribute("chiTiet") ChiTietSanPham chiTiet, @RequestParam("pageNum") Optional<Integer> pageNum,
                                @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        ChiTietSanPham sp = chiTietSpService.getOne(id);
        sp.setDongSanPham(chiTiet.getDongSanPham());
        sp.setSanPham(chiTiet.getSanPham());
        sp.setGiaBan(chiTiet.getGiaBan());
        sp.setGiaNhap(chiTiet.getGiaNhap());
        sp.setMauSac(chiTiet.getMauSac());
        sp.setNhaSanXuat(chiTiet.getNhaSanXuat());
        sp.setNamBaoHanh(chiTiet.getNamBaoHanh());
        sp.setMoTa(chiTiet.getMoTa());
        sp.setSoLuongTon(chiTiet.getSoLuongTon());
        chiTietSpService.update(sp);
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize);
        Page<ChiTietSanPham> page = chiTietSpService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "redirect:/chi-tiet-sp/hien-thi";
    }

    @GetMapping("/remove-chi-tiet-sp/{id}")
    public String delete(Model model, @PathVariable("id") UUID id, @RequestParam("pageNum") Optional<Integer> pageNum,
                         @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize, @ModelAttribute("chiTiet") ChiTietSanPham chiTiet) {
        chiTietSpService.delete(id);
//        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize);
        Page<ChiTietSanPham> page = chiTietSpService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "redirect:/chi-tiet-sp/hien-thi";
    }

    @GetMapping("/detail-chi-tiet-sp/{id}")
    public String detail(Model model, @PathVariable("id") UUID id, @RequestParam("pageNum") Optional<Integer> pageNum,
                         @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        ChiTietSanPham sp = chiTietSpService.getOne(id);
        model.addAttribute("chiTiet", sp);
//        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize);
        Page<ChiTietSanPham> page = chiTietSpService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "trang-home-chitietsanpham";
    }

    @GetMapping("/view-update-chi-tiet-sp/{id}")
    public String viewUpdate(Model model, @PathVariable("id") UUID id) {
        ChiTietSanPham sp = chiTietSpService.getOne(id);
        model.addAttribute("chiTiet", sp);
        return "updatechitiet";
    }

    @ModelAttribute("sanPham")
    public List<SanPham> hienThiSp() {
        return sanPhamService.getTen();
    }

    @ModelAttribute("mauSac")
    public List<MauSac> hienThiMs() {
        return mauSacService.getTen();
    }

    @ModelAttribute("dongSanPham")
    public List<DongSanPham> hienThiDsp() {
        return dongSPService.getTen();
    }

    @ModelAttribute("nhaSanXuat")
    public List<NhaSanXuat> hienThiNsx() {
        return nxsService.getTen();
    }
}
