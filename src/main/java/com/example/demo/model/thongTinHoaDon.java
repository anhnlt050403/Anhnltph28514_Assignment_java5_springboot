package com.example.demo.model;

import com.example.demo.model.HoaDon;
import com.example.demo.model.HoaDonChiTiet;
import com.example.demo.service.HoaDonChiTietService;
import com.example.demo.service.impl.HoaDonChiTietServiceImpl;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class thongTinHoaDon {
    private UUID id;
    private String ma;
    private Integer tongSanPham;
    private Integer tongTien;
    private Date ngayTao;
    private String tinhTrang;

}

