package com.example.demo.controller;

import com.example.demo.model.CuaHang;
import com.example.demo.service.CuaHangService;
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
@RequestMapping("/cua-hang")
public class CuaHangController {

    @Autowired
    private CuaHangService cuaHangService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @ModelAttribute("cuaHang") CuaHang cuaHang,
                          @RequestParam("pageNum") Optional<Integer> pageNum,
                          @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {

        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<CuaHang> page = cuaHangService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "trang-home-cuahang";
    }

    @PostMapping("add-cua-hang")
    public String addCuaHang(Model model, @ModelAttribute("cuaHang") CuaHang cuaHang, @RequestParam("pageNum") Optional<Integer> pageNum,
                             @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        cuaHangService.add(cuaHang);
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<CuaHang> page = cuaHangService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "redirect:/cua-hang/hien-thi";
    }

    @PostMapping("/update-cua-hang/{id}")
    public String updateCuaHang(Model model, @PathVariable("id") UUID id, @ModelAttribute("cuaHang") CuaHang cuaHang, @RequestParam("pageNum") Optional<Integer> pageNum,
                                @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        CuaHang sp = cuaHangService.getOne(id);
        sp.setMa(cuaHang.getMa());
        sp.setTen(cuaHang.getTen());
        sp.setDiaChi(cuaHang.getDiaChi());
        sp.setThanhPho(cuaHang.getThanhPho());
        sp.setQuocGia(cuaHang.getQuocGia());
        cuaHangService.update(sp);
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<CuaHang> page = cuaHangService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "redirect:/cua-hang/hien-thi";
    }

    @GetMapping("/remove-cua-hang/{id}")
    public String delete(Model model, @PathVariable("id") UUID id, @RequestParam("pageNum") Optional<Integer> pageNum,
                         @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize, @ModelAttribute("cuaHang") CuaHang cuaHang) {
        cuaHangService.delete(id);
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<CuaHang> page = cuaHangService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "redirect:/cua-hang/hien-thi";
    }

    @GetMapping("/detail-cua-hang/{id}")
    public String detail(Model model, @PathVariable("id") UUID id, @RequestParam("pageNum") Optional<Integer> pageNum,
                         @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        CuaHang sp = cuaHangService.getOne(id);
        model.addAttribute("cuaHang", sp);
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<CuaHang> page = cuaHangService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "trang-home-cuahang";
    }

    @GetMapping("/view-update-cua-hang/{id}")
    public String viewUpdate(Model model, @PathVariable("id") UUID id) {
        CuaHang sp = cuaHangService.getOne(id);
        model.addAttribute("cuaHang", sp);
        return "updatecuahang";
    }

    @PostMapping("/search-cua-hang")
    public String search(Model model, @RequestParam("tenTk") String ten, @ModelAttribute("cuaHang") CuaHang cuaHang, @RequestParam("pageNum") Optional<Integer> pageNum,
                         @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        List<CuaHang> listTk = new ArrayList<>();
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<CuaHang> page = cuaHangService.getAll(pageable);
        for (CuaHang sp : page
        ) {
            if (sp.getTen().contains(ten)) {
                listTk =  cuaHangService.search(ten);
            }
        }
        model.addAttribute("list", listTk);
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "trang-home-cuahang";
    }
}
