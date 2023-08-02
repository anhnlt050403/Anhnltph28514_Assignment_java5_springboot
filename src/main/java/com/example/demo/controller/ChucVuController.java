package com.example.demo.controller;

import com.example.demo.model.ChucVu;
import com.example.demo.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.expression.spel.ast.OpPlus;
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
@RequestMapping("/chuc-vu")
public class  ChucVuController {

    @Autowired
    private ChucVuService chucVuservice;

        Optional<Integer> viTri;
    @GetMapping("/hien-thi")
    public String hienThi(Model model, @ModelAttribute("chucVu") ChucVu chucVu,
                          @RequestParam("pageNum") Optional<Integer> pageNum,
                          @RequestParam(name = "pageSize", required = false, defaultValue = "2") Integer pageSize) {

        Sort sort = Sort.by("ma").ascending();
        viTri = pageNum;
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<ChucVu> page = chucVuservice.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "trang-home-chucvu";
    }

    @PostMapping("add-chuc-vu")
    public String addChucVu(Model model, @ModelAttribute("chucVu") ChucVu chucVu, @RequestParam("pageNum") Optional<Integer> pageNum,
                            @RequestParam(name = "pageSize", required = false, defaultValue = "2") Integer pageSize) {
//        chucVuservice.add(chucVu);
//        Sort sort = Sort.by("ma").ascending();
//        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
//        Page<ChucVu> page =  chucVuservice.getAll(pageable);
//        model.addAttribute("list", page.getContent());
//        model.addAttribute("page", page.getNumber());
//        model.addAttribute("total", page.getTotalPages());
       return "redirect:/chuc-vu/hien-thi";
    }

    @PostMapping("/update-chuc-vu/{id}")
    public String updateChucVu(Model model, @PathVariable("id") UUID id, @ModelAttribute("chucVu") ChucVu chucVu, @RequestParam("pageNum") Optional<Integer> pageNum,
                               @RequestParam(name = "pageSize", required = false, defaultValue = "2") Integer pageSize) {
        ChucVu sp =  chucVuservice.getOne(id);
        sp.setMa(chucVu.getMa());
        sp.setTen(chucVu.getTen());
        chucVuservice.update(sp);
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<ChucVu> page =  chucVuservice.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "redirect:/chuc-vu/hien-thi";
    }

    @GetMapping("/remove-chuc-vu/{id}")
    public String delete(Model model, @PathVariable("id") UUID id, @RequestParam("pageNum") Optional<Integer> pageNum,
                         @RequestParam(name = "pageSize", required = false, defaultValue = "2") Integer pageSize, @ModelAttribute("chucVu") ChucVu chucVu) {
        chucVuservice.delete(id);
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<ChucVu> page =  chucVuservice.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "redirect:/chuc-vu/hien-thi";
    }

    @GetMapping("/detail-chuc-vu/{id}")
    public String detail(Model model, @PathVariable("id") UUID id, @RequestParam("pageNum") Optional<Integer> pageNum,
                         @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        ChucVu sp =  chucVuservice.getOne(id);
        model.addAttribute("chucVu", sp);
        Sort sort = Sort.by("ma").ascending();
//        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
      Pageable pageable = PageRequest.of(viTri.orElse(0),pageSize);
        Page<ChucVu> page =  chucVuservice.getAll(pageable);
        model.addAttribute("list", page.getContent());
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());


        return "trang-home-chucvu";
    }

    @GetMapping("/view-update-chuc-vu/{id}")
    public String viewUpdate(Model model, @PathVariable("id") UUID id) {
        ChucVu sp =  chucVuservice.getOne(id);
        model.addAttribute("chucVu", sp);
        return "updatechucvu";
    }

    @PostMapping("/search-chuc-vu")
    public String search(Model model, @RequestParam("tenTk") String ten, @ModelAttribute("chucVu") ChucVu chucVu, @RequestParam("pageNum") Optional<Integer> pageNum,
                         @RequestParam(name = "pageSize", required = false, defaultValue = "2") Integer pageSize) {
        List<ChucVu> listTk = new ArrayList<>();
        Sort sort = Sort.by("ma").ascending();
        Pageable pageable = PageRequest.of(pageNum.orElse(0), pageSize, sort);
        Page<ChucVu> page =  chucVuservice.getAll(pageable);
        for (ChucVu sp : page
        ) {
            if (sp.getTen().contains(ten)) {
                listTk =  chucVuservice.search(ten);
            }
        }
        model.addAttribute("list", listTk);
        model.addAttribute("page", page.getNumber());
        model.addAttribute("total", page.getTotalPages());
        return "trang-home-chucvu";
    }
}
