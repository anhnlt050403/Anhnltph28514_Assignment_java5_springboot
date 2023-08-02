package com.example.demo.controller;

import com.example.demo.model.HoaDon;

import com.example.demo.service.HoaDonService;
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

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import java.sql.Date;
@Controller
@RequestMapping("/hoa-don")
public class HoaDonController {
    @Autowired
    private HoaDonService service;
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private KhachHangService khachHangService;



    @GetMapping("/hien-thi")
    public String hienThi(

            Model model,
            @ModelAttribute("hoaDon") HoaDon hoaDon,
            @RequestParam("pageNum") Optional<Integer> pageNum,  // bạn đang chọn trang thứ mấy
            @RequestParam(name = "pageSize", required = false, defaultValue = "2") Integer pageSize  //danh sách list 1 trang (defaultValue = "2")
    ) {
        hoaDon.setTinhTrang(0);
        model.addAttribute("khachHang", khachHangService.getAll1());
        model.addAttribute("nhanVien", nhanVienService.getAll1());
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize);
        Page<HoaDon> page = service.getAll(pageable);

        model.addAttribute("dulieu", page.getContent()); //danh sách list trong trang
        model.addAttribute("total", page.getTotalPages()); // tổng số trang(trang đếm từ 0)
        return "trang-home-HoaDon";
    }

    @GetMapping("/detail/{id}")

    public String detail(Model model,
                         @PathVariable("id") UUID id,
                         @RequestParam("pageNum") Optional<Integer> pageNum,  // bạn đang chọn trang thứ mấy
                         @RequestParam(name = "pageSize", required = false, defaultValue = "2") Integer pageSize

    ) {
        HoaDon hd = service.getOne(id);
        model.addAttribute("hoaDon", hd);
        model.addAttribute("nhanVien", nhanVienService.getAll1());
        model.addAttribute("khachHang", khachHangService.getAll1());

        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize);
        Page<HoaDon> page = service.getAll(pageable);
        model.addAttribute("dulieu", page.getContent()); //danh sách list trong trang
        model.addAttribute("total", page.getTotalPages());
        return "trang-home-HoaDon";
    }


    @PostMapping("/update/{id}")
    public String updateChucVu(
            @PathVariable("id") UUID id,
            @ModelAttribute("hoaDon") HoaDon hoaDon  // dùng form string
    ) {
        HoaDon sp = service.getOne(id);

        sp.setMa(hoaDon.getMa());
        sp.setKhachHang(hoaDon.getKhachHang());
        sp.setNhanVien(hoaDon.getNhanVien());
        sp.setMa(hoaDon.getMa());
        sp.setNgayTao(hoaDon.getNgayTao());
        sp.setNgayThanhToan(hoaDon.getNgayThanhToan());

        sp.setNgayShip(hoaDon.getNgayShip());
        sp.setNgayNhan(hoaDon.getNgayNhan());

        sp.setTinhTrang(hoaDon.getTinhTrang());
        sp.setTenNguoiNhan(hoaDon.getTenNguoiNhan());

        sp.setDiaChi(hoaDon.getDiaChi());
        sp.setSdt(hoaDon.getSdt());


        service.ADDvsUPDATE(sp);
        return "redirect:/hoa-don/hien-thi";
    }


    @GetMapping("/view-add")

    public String viewadd(Model model,

                          @ModelAttribute("hoaDon") HoaDon hoaDon


    ) {
        hoaDon.setTinhTrang(0);
        model.addAttribute("nhanVien", nhanVienService.getAll1());
        model.addAttribute("khachHang", khachHangService.getAll1());

        return "trang-add-HoaDon";
    }


    @PostMapping("/add")
    public String add(

            @ModelAttribute("hoaDon") HoaDon hoaDon  // dùng form string
    ) {


        service.ADDvsUPDATE(hoaDon);
        return "redirect:/hoa-don/hien-thi";
    }


    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable("id") UUID id
            // dùng form string
    ) {


        service.delete(id);
        return "redirect:/hoa-don/hien-thi";
    }
}
