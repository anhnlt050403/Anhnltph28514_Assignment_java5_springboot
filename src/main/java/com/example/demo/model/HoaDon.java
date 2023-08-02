package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "hoa_don")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kh")
    private KhachHang khachHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nv")
    private NhanVien nhanVien;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Column(name = "ngay_ship")
    private Date ngayShip;

    @Column(name = "ngay_nhan")
    private Date ngayNhan;

    @Column(name = "ngay_thanh_toan")
    private Date ngayThanhToan;

    @Column(name = "ten_nguoi_nhan")
    private String tenNguoiNhan;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "tinh_trang")
    private int tinhTrang;

    public HoaDon(String ma, Date ngayTao, Integer tinhTrang) {
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.tinhTrang = tinhTrang;

    }

    public HoaDon(KhachHang khachHang, NhanVien nhanVien, Date ngayThanhToan) {
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;

        this.ngayThanhToan = ngayThanhToan;
    }

    public HoaDon(NhanVien nhanVien, Date ngayThanhToan) {

        this.nhanVien = nhanVien;

        this.ngayThanhToan = ngayThanhToan;
    }


    public String tinhTrang() {
        if (tinhTrang == 0) {
            return "CHỜ THANH TOÁN";
        } else if (tinhTrang == 1) {
            return "ĐÃ THANH TOÁN";
        } else {
            return "ĐÃ HỦY";
        }
    }
}
