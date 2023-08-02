package com.example.demo.controller;


import com.example.demo.model.GioHangChiTiet;
import com.example.demo.model.HoaDon;
import com.example.demo.model.HoaDonChiTiet;
import com.example.demo.repository.HoaDonChiTietRepository;
import com.example.demo.service.ChiTietSpService;
import com.example.demo.service.HoaDonChiTietService;
import com.example.demo.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
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

@Controller
@RequestMapping("/hoa-don-chi-tiet")
public class HoaDonChiTietController {

    @Autowired
    private HoaDonChiTietService hoaDonChiTietService;
    @Autowired
    private ChiTietSpService chiTietSPService;
    @Autowired
    private HoaDonService hoaDonService;




    @GetMapping("/hien-thi")
    public String hienThi(Model model,
//            @ModelAttribute("chucVu") ChucVu chucVu,
                          @RequestParam("pageNum") Optional<Integer> pageNum,  // bạn đang chọn trang thứ mấy
                          @RequestParam(name = "pageSize", required = false, defaultValue = "2") Integer pageSize  //danh sách list 1 trang (defaultValue = "2")
    ) {
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize);
        Page<HoaDonChiTiet> page = hoaDonChiTietService.getAll(pageable);
        model.addAttribute("tbt", hoaDonChiTietService.getAll1());
        model.addAttribute("dulieu", page.getContent()); //danh sách list trong trang
        model.addAttribute("total", page.getTotalPages()); // tổng số trang(trang đếm từ 0)
        return "trang-HoaDonCT";
    }
    @GetMapping("/view-add")

    public String viewadd(Model model,
                          @ModelAttribute("dulieuxem") HoaDonChiTiet hoaDonChiTiet


    ) {


        model.addAttribute("dulieuxem", hoaDonChiTiet);
        model.addAttribute("chitietsanpham", chiTietSPService.getAll1());
        model.addAttribute("hoadon", hoaDonService.getAll1());
        model.addAttribute("tbt", hoaDonChiTietService.getAll1());
        return "trang-add-HoaDonChiTiet";
    }
    @GetMapping("/view-update/{idhd}/{idctsp}")

    public String viewUpdate(Model model,
                             @ModelAttribute("dulieuxem") HoaDonChiTiet hoaDonChiTiet,
                             @PathVariable("idhd") UUID idhd,
                             @PathVariable("idctsp") UUID idctsp

    ) {
        hoaDonChiTiet = hoaDonChiTietService.getOne(idhd, idctsp);
        model.addAttribute("dulieuxem", hoaDonChiTiet);
        model.addAttribute("chitietsanpham", chiTietSPService.getAll1());
        model.addAttribute("hoadon", hoaDonService.getAll1());
        model.addAttribute("tbt", hoaDonChiTietService.getAll1());
        return "trang-update-HoaDonCT";
    }

    @PostMapping("/update/{idhd}/{idctsp}")
    public String update(
            @PathVariable("idhd") UUID idhd,
            @PathVariable("idctsp") UUID idctsp,
            @ModelAttribute("dulieuxem") HoaDonChiTiet hoaDonChiTiet  // dùng form string
    ) {
        HoaDonChiTiet hdct = hoaDonChiTietService.getOne(idhd, idctsp);
        hdct.setDonGia(hoaDonChiTiet.getDonGia());
        hdct.setSoLuong(hoaDonChiTiet.getSoLuong());
        hoaDonChiTietService.ADDvsUPDATE(hdct);

        return "redirect:/hoa-don-chi-tiet/hien-thi";


    }
    @GetMapping("/remove/{idhd}/{idctsp}")
    public String remove(
            @PathVariable("idhd") UUID idhd,
            @PathVariable("idctsp") UUID idctsp
    ) {
       hoaDonChiTietService.delete(idhd, idctsp);


        return "redirect:/hoa-don-chi-tiet/hien-thi";
    }
}
