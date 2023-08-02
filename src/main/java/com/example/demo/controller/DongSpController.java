package com.example.demo.controller;

import com.example.demo.model.ChucVu;
import com.example.demo.model.DongSanPham;
import com.example.demo.model.SanPham;
import com.example.demo.repository.DongSpRepository;
import com.example.demo.service.DongSPService;
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
@RequestMapping("/dong-san-pham")
public class DongSpController {

    @Autowired
    private DongSPService DongspService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @ModelAttribute("dongSanPham") DongSanPham dongSanPham,
                          @RequestParam("pageNum") Optional<Integer> pageNum,
                          @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {

        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<DongSanPham> page = DongspService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "trang-home-dongsanpham";
    }

    @PostMapping("add-dong-san-pham")
    public String addDongSanPham(Model model, @ModelAttribute("dongSanPham") DongSanPham dongSanPham, @RequestParam("pageNum") Optional<Integer> pageNum,
                                 @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        DongspService.add(dongSanPham);
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<DongSanPham> page = DongspService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "redirect:/dong-san-pham/hien-thi";
    }

    @PostMapping("/update-dong-san-pham/{id}")
    public String updateDongSanPham(Model model, @PathVariable("id") UUID id, @ModelAttribute("dongSanPham") DongSanPham dongSanPham, @RequestParam("pageNum") Optional<Integer> pageNum,
                                    @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        DongSanPham sp = DongspService.getOne(id);
        sp.setMa(dongSanPham.getMa());
        sp.setTen(dongSanPham.getTen());
        DongspService.update(sp);
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<DongSanPham> page = DongspService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "redirect:/dong-san-pham/hien-thi";
    }

    @GetMapping("/remove-dong-san-pham/{id}")
    public String delete(Model model, @PathVariable("id") UUID id, @RequestParam("pageNum") Optional<Integer> pageNum,
                         @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize, @ModelAttribute("dongSanPham") DongSanPham dongSanPham) {
        DongspService.delete(id);
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<DongSanPham> page = DongspService.getAll(pageable);

        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "redirect:/dong-san-pham/hien-thi";
    }

    @GetMapping("/detail-dong-san-pham/{id}")
    public String detail(Model model, @PathVariable("id") UUID id, @RequestParam("pageNum") Optional<Integer> pageNum,
                         @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        DongSanPham sp = DongspService.getOne(id);
        model.addAttribute("dongSanPham", sp);
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<DongSanPham> page = DongspService.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "trang-home-dongsanpham";
    }

    @GetMapping("/view-update-dong-san-pham/{id}")
    public String viewUpdate(Model model, @PathVariable("id") UUID id) {
        DongSanPham sp = DongspService.getOne(id);
        model.addAttribute("dongSanPham", sp);
        return "updatedongsanpham";
    }

    @PostMapping("/search-dong-san-pham")
    public String search(Model model, @RequestParam("tenTk") String ten, @ModelAttribute("dongSanPham") DongSanPham dongSanPham, @RequestParam("pageNum") Optional<Integer> pageNum,
                         @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        List<DongSanPham> listTk = new ArrayList<>();
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<DongSanPham> page = DongspService.getAll(pageable);
        for (DongSanPham sp : page
        ) {
            if (sp.getTen().contains(ten)) {
                listTk = DongspService.search(ten);
            }
        }
        model.addAttribute("list", listTk);
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "trang-home-dongsanpham";
    }
}
