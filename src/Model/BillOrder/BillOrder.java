/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.BillOrder;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class BillOrder {
    int maHD;
    int gia;
    int soLuong;
    Date ngayTao;
    String phuongThucThanhToan;
    float tongTien;
    String ghiChu;
    String tenKH;
    String SDT;

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    
    public String getTenKH() {
        return tenKH;
    }

    public String getSDT() {
        return SDT;
    }
    

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getGhiChu() {
        return ghiChu;
    }
    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public int getGia() {
        return gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public String getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public float getTongTien() {
        return tongTien;
    }
    
}
