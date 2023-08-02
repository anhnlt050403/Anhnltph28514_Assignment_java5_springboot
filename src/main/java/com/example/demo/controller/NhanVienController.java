package com.example.demo.controller;

import com.example.demo.model.ChucVu;
import com.example.demo.model.CuaHang;
import com.example.demo.model.NhanVien;
import com.example.demo.service.ChucVuService;
import com.example.demo.service.CuaHangService;
import com.example.demo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
@RequestMapping("/nhan-vien")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private ChucVuService chucVuService;
    @Autowired
    private CuaHangService cuaHangService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @ModelAttribute("nhanVien") NhanVien nhanVien,
                          @RequestParam("pageNum") Optional<Integer> pageNum,
                          @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {

        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<NhanVien> page = nhanVienService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "trang-home-nhanvien";
    }

    @PostMapping("add-nhan-vien")
    public String addNhanVien(Model model, @ModelAttribute("nhanVien") NhanVien nhanVien, @RequestParam("pageNum") Optional<Integer> pageNum,
                              @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize, BindingResult result) {
        nhanVienService.add(nhanVien);
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<NhanVien> page = nhanVienService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "redirect:/nhan-vien/hien-thi";
    }

    @PostMapping("/update-nhan-vien/{id}")
    public String updateNhanVien(Model model, @PathVariable("id") UUID id, @ModelAttribute("nhanVien") NhanVien nhanVien, @RequestParam("pageNum") Optional<Integer> pageNum
                                 ,@RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        NhanVien sp = nhanVienService.getOne(id);
        sp.setMa(nhanVien.getMa());
        sp.setTen(nhanVien.getTen());
        sp.setDiaChi(nhanVien.getDiaChi());
        sp.setMatKhau(nhanVien.getMatKhau());
        sp.setNgaySinh(nhanVien.getNgaySinh());
        sp.setSdt(nhanVien.getSdt());
        sp.setTenDem(nhanVien.getTenDem());
        sp.setChucVu(nhanVien.getChucVu());
        sp.setCuaHang(nhanVien.getCuaHang());
        sp.setTrangThai(nhanVien.getTrangThai());
        sp.setHo(nhanVien.getHo());
        sp.setGioiTinh(nhanVien.getGioiTinh());
        nhanVienService.update(sp);
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<NhanVien> page = nhanVienService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("/remove-nhan-vien/{id}")
    public String delete(Model model, @PathVariable("id") UUID id, @RequestParam("pageNum") Optional<Integer> pageNum,
                         @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize, @ModelAttribute("nhanVien") NhanVien nhanVien) {
        nhanVienService.delete(id);
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<NhanVien> page = nhanVienService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("/detail-nhan-vien/{id}")
    public String detail(Model model, @PathVariable("id") UUID id, @RequestParam("pageNum") Optional<Integer> pageNum,
                         @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        NhanVien sp = nhanVienService.getOne(id);
        model.addAttribute("nhanVien", sp);
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<NhanVien> page = nhanVienService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "trang-home-nhanvien";
    }

    @GetMapping("/view-update-nhan-vien/{id}")
    public String viewUpdate(Model model, @PathVariable("id") UUID id) {
        NhanVien sp = nhanVienService.getOne(id);
        model.addAttribute("nhanVien", sp);
        return "updatenhanvien";
    }

    @PostMapping("/search-nhan-vien")
    public String search(Model model, @RequestParam("tenTk") String ten, @ModelAttribute("nhanVien") NhanVien nhanVien, @RequestParam("pageNum") Optional<Integer> pageNum,
                         @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        List<NhanVien> listTk = new ArrayList<>();
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<NhanVien> page = nhanVienService.getAll(pageable);
        for (NhanVien sp : page
        ) {
            if (sp.getTen().contains(ten)) {
                listTk = nhanVienService.search(ten);
            }
        }
        model.addAttribute("list", listTk);
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "trang-home-nhanvien";
    }

    @ModelAttribute("cuaHang")
    public ArrayList<CuaHang> hienThiCh() {
        return cuaHangService.getTen();
    }

    @ModelAttribute("chucVu")
    public ArrayList<ChucVu> hienThiCv() {
        return chucVuService.getTen();
    }
}
