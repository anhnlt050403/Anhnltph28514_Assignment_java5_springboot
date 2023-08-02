package com.example.demo.controller;


import com.example.demo.model.ChiTietSanPham;
import com.example.demo.model.GioHang;
import com.example.demo.model.GioHangChiTiet;
import com.example.demo.model.HoaDon;
import com.example.demo.model.HoaDonChiTiet;
import com.example.demo.model.IdChiTietHoaDon;
import com.example.demo.model.idChiTietGioHang;
import com.example.demo.service.ChiTietSpService;
import com.example.demo.service.DongSPService;
import com.example.demo.service.GioHangChiTietService;
import com.example.demo.service.GioHangService;
import com.example.demo.service.HoaDonChiTietService;
import com.example.demo.service.HoaDonService;
import com.example.demo.service.MauSacService;
import com.example.demo.service.NXSService;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private ChiTietSpService chiTietSPService;

    @Autowired
    private NXSService nsxService;


    @Autowired
    private SanPhamService sanPhamService;


    @Autowired
    private MauSacService mauSacService;

    @Autowired
    private DongSPService dongSPService;
    @Autowired
    private GioHangChiTietService gioHangChiTietService;
    @Autowired
    private GioHangService gioHangService;
    @Autowired
    private HoaDonService hoaDonService;
    @Autowired
    private HoaDonChiTietService hoaDonChiTietService;

    @GetMapping("/hien-thi")
    public String hienThi(
            Model model,
//            @ModelAttribute("chucVu") ChucVu chucVu,
            @RequestParam("pageNum") Optional<Integer> pageNum,  // bạn đang chọn trang thứ mấy
            @RequestParam(name = "pageSize", required = false, defaultValue = "8") Integer pageSize  //danh sách list 1 trang (defaultValue = "2")
    ) {

        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize);
        Page<ChiTietSanPham> page = chiTietSPService.getAll(pageable);
        model.addAttribute("tbt", chiTietSPService.getAll1());
        model.addAttribute("dulieu", page.getContent()); //danh sách list trong trang
        model.addAttribute("total", page.getTotalPages()); // tổng số trang(trang đếm từ 0)

        model.addAttribute("noisanxuat", nsxService.getAll1());
        model.addAttribute("sanpham", sanPhamService.getAll1());
        model.addAttribute("mausac", mauSacService.getAll1());
        model.addAttribute("dongsanpham", dongSPService.getAll1());
        return "trang-home";
    }


    @PostMapping ("/xemchitietsanpham")
    public String ctsp(
            Model model,
            @RequestParam("idcthd") UUID id

    ) {


        model.addAttribute("dulieu", chiTietSPService.getOne(id)); //danh sách list trong trang
        // tổng số trang(trang đếm từ 0)


        return "TrangChiTietSP";
    }

    @PostMapping ("/gio-hang")
    public String gh(
            Model model,
            @RequestParam("idctsp") UUID idctsp

    ) {

        UUID idgh=UUID.fromString("fb8dd067-bb5b-475d-9867-38a77ef10b48");

        if (gioHangChiTietService.getOne(idgh, idctsp) == null) {
            GioHangChiTiet hoaDonChiTiet = new GioHangChiTiet();
            GioHang hoaDon = gioHangService.getOne(idgh);
            ChiTietSanPham chiTietSP = chiTietSPService.getOne(idctsp);
            idChiTietGioHang idChiTietHoaDon = new idChiTietGioHang();
            idChiTietHoaDon.setGioHang(hoaDon);
            idChiTietHoaDon.setChiTietSP(chiTietSP);
            hoaDonChiTiet.setId(idChiTietHoaDon);
            hoaDonChiTiet.setSoLuong(1);
            hoaDonChiTiet.setDonGia(chiTietSP.getGiaBan());
            hoaDonChiTiet.setDonGiaKhiGiam(BigDecimal.valueOf(0));
            gioHangChiTietService.ADDvsUPDATE(hoaDonChiTiet);


            ChiTietSanPham ctsp = chiTietSPService.getOne(idctsp);
            Integer sludctsp = ctsp.getSoLuongTon() - 1;
            chiTietSP.setSoLuongTon(sludctsp);
            chiTietSPService.add(chiTietSP);

        } else {

            GioHangChiTiet hdct = gioHangChiTietService.getOne(idgh, idctsp);
            Integer slud = hdct.getSoLuong() + 1;
            hdct.setSoLuong(slud);
            gioHangChiTietService.ADDvsUPDATE(hdct);
            ChiTietSanPham chiTietSP = chiTietSPService.getOne(idctsp);
            Integer sludctsp = chiTietSP.getSoLuongTon() - 1;
            chiTietSP.setSoLuongTon(sludctsp);
            chiTietSPService.add(chiTietSP);
        }


//        HoaDon hoaDon = hoaDonService.getOne(idhd);
//        List<HoaDonChiTiet> listhdct = hoaDonChiTietService.detailall(hoaDon.getId());
//        String mhd = hoaDon.getMa();
//        model.addAttribute("mhd", hoaDon);
//        model.addAttribute("dulieuhdct", listhdct);
//        model.addAttribute("idhd", idhd);
//        model.addAttribute("dulieuctsp", chiTietSPService.getAll1());
//        model.addAttribute("khachhang", khachHangService.getAll1());
//        model.addAttribute("nhanvien", nhanVienService.getAll1());
//
//        model.addAttribute("tongtien", hoaDonChiTietService.tongtien(hoaDon.getId()));


        model.addAttribute("dulieu", gioHangChiTietService.timGioHang(UUID.fromString("fb8dd067-bb5b-475d-9867-38a77ef10b48"))); //danh sách list trong trang
        // tổng số trang(trang đếm từ 0)

        return "redirect:/home/gio-hang";
    }

    @GetMapping ("/gio-hang")
    public String gh1(
            Model model


    ) {
        model.addAttribute("dulieu", gioHangChiTietService.timGioHang(UUID.fromString("fb8dd067-bb5b-475d-9867-38a77ef10b48"))); //danh sách list trong trang
        // tổng số trang(trang đếm từ 0)

        return "TrangGioHang";
    }



    @PostMapping("/updatectgh")
    public String update(Model model,

                         @RequestParam("idctsp") UUID idctsp,
                         @RequestParam("slcud") Integer slcud

    ) {
        UUID idhd=UUID.fromString("fb8dd067-bb5b-475d-9867-38a77ef10b48");

        GioHangChiTiet hdct = gioHangChiTietService.getOne(idhd, idctsp);
        Integer slbandau = hdct.getSoLuong();

        hdct.setSoLuong(slcud);

//  chiTietSPService.getOne(idctsp)
        gioHangChiTietService.ADDvsUPDATE(hdct);

        if (slcud > slbandau) {
            Integer slchuyenvao = chiTietSPService.getOne(idctsp).getSoLuongTon() - (slcud - slbandau);
            chiTietSPService.getOne(idctsp).setSoLuongTon(slchuyenvao);
            chiTietSPService.add(chiTietSPService.getOne(idctsp));
        } else {
            Integer slchuyenvao = chiTietSPService.getOne(idctsp).getSoLuongTon() + (slbandau - slcud);
            chiTietSPService.getOne(idctsp).setSoLuongTon(slchuyenvao);
            chiTietSPService.add(chiTietSPService.getOne(idctsp));
        }


        GioHang hoaDon = gioHangService.getOne(idhd);
//        List<HoaDonChiTiet> listhdct = hoaDonChiTietService.detailall(hoaDon.getId());
//        String mhd = hoaDon.getMa();
//        model.addAttribute("mhd", hoaDon);
//        model.addAttribute("dulieuhdct", listhdct);
//        model.addAttribute("idhd", idhd);
//        model.addAttribute("dulieuctsp", chiTietSPService.getAll1());
//        model.addAttribute("khachhang", khachHangService.getAll1());
//        model.addAttribute("nhanvien", nhanVienService.getAll1());
//        model.addAttribute("tongtien", hoaDonChiTietService.tongtien(hoaDon.getId()));
        return "redirect:/home/gio-hang";
    }



    @PostMapping("/delete")
    public String remove(Model model,

                         @RequestParam("idctsp") UUID idctsp

    ) {
        UUID idhd=UUID.fromString("fb8dd067-bb5b-475d-9867-38a77ef10b48");
        GioHangChiTiet hdct = gioHangChiTietService.getOne(idhd, idctsp);
        Integer slbandau = hdct.getSoLuong();


        gioHangChiTietService.delete(idhd, idctsp);


        Integer slchuyenvao = chiTietSPService.getOne(idctsp).getSoLuongTon() + slbandau;
        chiTietSPService.getOne(idctsp).setSoLuongTon(slchuyenvao);
        chiTietSPService.add(chiTietSPService.getOne(idctsp));

//        HoaDon hoaDon = hoaDonService.getOne(idhd);
//        List<GioHangChiTiet> listhdct = gioHangChiTietService.detailall(hoaDon.getId());
//        String mhd = hoaDon.getMa();
//        model.addAttribute("mhd", hoaDon);
//        model.addAttribute("dulieuhdct", listhdct);
//        model.addAttribute("idhd", idhd);
//        model.addAttribute("dulieuctsp", chiTietSPService.getAll1());
//        model.addAttribute("khachhang", khachHangService.getAll1());
//        model.addAttribute("nhanvien", nhanVienService.getAll1());
//        model.addAttribute("tongtien", hoaDonChiTietService.tongtien(hoaDon.getId()));
        return "redirect:/home/gio-hang";
    }

    @GetMapping("/dat-hang")
    public String taohoadon(
            Model model
//       @RequestParam("pageNum") Optional<Integer> pageNum,  // bạn đang chọn trang thứ mấy
//@RequestParam(name = "pageSize", required = false, defaultValue = "2") Integer pageSize  //danh sách list 1 trang (defaultValue = "2")
    ) {
        UUID idhd=UUID.fromString("fb8dd067-bb5b-475d-9867-38a77ef10b48");
        String mhd = "MHD" + hoaDonService.getAll1().size()+"vv";
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        hoaDonService.ADDvsUPDATE(new HoaDon(mhd, date, 0));

        HoaDon hoaDon = hoaDonService.timMHD(mhd);
System.out.println(1);
        List<GioHangChiTiet> listghct=gioHangChiTietService.timGioHang(idhd);
        System.out.println(2);
        for (GioHangChiTiet dt:listghct){
            ChiTietSanPham chiTietSP=chiTietSPService.getOne(dt.getId().getChiTietSP().getId());
            IdChiTietHoaDon idChiTietHoaDon=new IdChiTietHoaDon();
            idChiTietHoaDon.setHoaDon(hoaDon);
            idChiTietHoaDon.setChiTietSP(chiTietSP);
            hoaDonChiTietService.ADDvsUPDATE(new HoaDonChiTiet(idChiTietHoaDon,dt.getSoLuong(),dt.getDonGia()));
        }
        System.out.println(3);
        gioHangChiTietService.delete1(idhd);
        System.out.println(4);
//        model.addAttribute("mhd", hoaDon);
//        model.addAttribute("idhd", hoaDon.getId());
//        model.addAttribute("dulieuhdct", listhdct);
//
//        model.addAttribute("khachhang", khachHangService.getAll1());
//        model.addAttribute("nhanvien", nhanVienService.getAll1());
//        model.addAttribute("dulieuctsp", chiTietSPService.getAll1());
//        model.addAttribute("tongtien", hoaDonChiTietService.tongtien(hoaDon.getId()));
        return "redirect:/ban-hang/hien-thi";
    }
    }
