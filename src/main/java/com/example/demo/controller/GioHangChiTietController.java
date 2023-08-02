package com.example.demo.controller;


import com.example.demo.model.GioHangChiTiet;
import com.example.demo.repository.GioHangChiTietRepository;
import com.example.demo.service.ChiTietSpService;
import com.example.demo.service.GioHangChiTietService;
import com.example.demo.service.GioHangService;
import jakarta.persistence.criteria.CriteriaBuilder;
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

@Controller
@RequestMapping("/gio-hang-chi-tiet")
public class GioHangChiTietController {

    @Autowired
    private GioHangService gioHangService;

    @Autowired
    private GioHangChiTietService gioHangChiTietService;

    @Autowired
    private ChiTietSpService chiTietSpService;




    @GetMapping("/hien-thi")
    public String hienThi(
            Model model,
            @ModelAttribute("dulieuxem") GioHangChiTiet gioHangChiTiet,
            @RequestParam("pageNum") Optional<Integer> pageNum,  // bạn đang chọn trang thứ mấy
            @RequestParam(name = "pageSize", required = false, defaultValue = "2") Integer pageSize  //danh sách list 1 trang (defaultValue = "2")
    ) {

        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize);
        Page<GioHangChiTiet> page = gioHangChiTietService.getAll(pageable);
        model.addAttribute("tbt", gioHangChiTietService.getAll1());
        model.addAttribute("dulieu", page.getContent()); //danh sách list trong trang
        model.addAttribute("total", page.getTotalPages()); // tổng số trang(trang đếm từ 0)
        return "trang-GioHangCT";
    }


    @GetMapping("/view-update/{idhd}/{idctsp}")

    public String viewUpdate(Model model,
                             @ModelAttribute("dulieuxem") GioHangChiTiet hoaDonChiTiet,
                             @PathVariable("idhd") UUID idhd,
                             @PathVariable("idctsp") UUID idctsp

    ) {

        hoaDonChiTiet = gioHangChiTietService.getOne(idhd, idctsp);

        System.out.println("tacocooc" + gioHangChiTietService.getOne(idhd, idctsp));

        model.addAttribute("dulieuxem", hoaDonChiTiet);
        model.addAttribute("chiTiet", chiTietSpService.getAll1());
        model.addAttribute("gioHang", gioHangService.getAll1());
        model.addAttribute("tbt", gioHangChiTietService.getAll1());
        return "trang-update-GioHangChiTiet";
    }

    @PostMapping("/update/{idgh}/{idctsp}")
    public String updateChucVu(
            @PathVariable("idgh") UUID idhd,
            @PathVariable("idctsp") UUID idctsp,
            @ModelAttribute("dulieuxem") GioHangChiTiet hoaDonChiTiet  // dùng form string
    ) {
        GioHangChiTiet hdct = gioHangChiTietService.getOne(idhd, idctsp);
        hdct.setDonGia(hoaDonChiTiet.getDonGia());
        hdct.setSoLuong(hoaDonChiTiet.getSoLuong());
      gioHangChiTietService.ADDvsUPDATE(hdct);

        return "redirect:/gio-hang-chi-tiet/hien-thi";


    }


    @GetMapping("/view-add")

    public String viewadd(Model model,
                          @ModelAttribute("dulieuxem") GioHangChiTiet gioHangChiTiet


    ) {


        model.addAttribute("dulieuxem", gioHangChiTiet);
        model.addAttribute("chiTiet", chiTietSpService.getAll1());
        model.addAttribute("gioHang", gioHangService.getAll1());
        model.addAttribute("tbt",gioHangChiTietService.getAll1());
        return "trang-add-GioHangChiTiet";
    }

    @PostMapping("/add")
    public String add(
            @ModelAttribute("dulieuxem") GioHangChiTiet hoaDonChiTiet  // dùng form string
    ) {

        gioHangChiTietService.ADDvsUPDATE(hoaDonChiTiet);
        return "redirect:/gio-hang-chi-tiet/hien-thi";
    }

    @GetMapping("/remove/{idhd}/{idctsp}")
    public String remove(
            @PathVariable("idhd") UUID idhd,
            @PathVariable("idctsp") UUID idctsp
    ) {
        System.out.println("vvvvvvvv--" + idhd + "---" + idctsp);
        gioHangChiTietService.delete(idhd, idctsp);

        return "redirect:/gio-hang-chi-tiet/hien-thi";
    }

}
