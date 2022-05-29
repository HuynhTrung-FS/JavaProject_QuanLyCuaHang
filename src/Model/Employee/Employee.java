/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Employee;

import java.util.Date;


/**
 *
 * @author ADMIN
 */
public class Employee {

    /**
     * @return the chiNhanh
     */
    public int getChiNhanh() {
        return chiNhanh;
    }

    /**
     * @param chiNhanh the chiNhanh to set
     */
    public void setChiNhanh(int chiNhanh) {
        this.chiNhanh = chiNhanh;
    }

    /**
     * @return the lichLamViec
     */
    public String getLichLamViec() {
        return lichLamViec;
    }

    /**
     * @param lichLamViec the lichLamViec to set
     */
    public void setLichLamViec(String lichLamViec) {
        this.lichLamViec = lichLamViec;
    }

    /**
     * @return the chucVu
     */
    public int getChucVu() {
        return chucVu;
    }

    /**
     * @param chucVu the chucVu to set
     */
    public void setChucVu(int chucVu) {
        this.chucVu = chucVu;
    }

    private int maNV;
    private String tenNV;
    private int chucVu;
    private String SDT;
    private String diaChi;
    private String gioiTinh;
    private String soCMND;
    private Date ngaySinh;
    private Date ngayVaoLam;
    private String hinhAnhNV;
    private float luongCB;
    private String taiKhoan;
    private String matKhau;
    private String lichLamViec;
    private int chiNhanh;

    public Employee(int maNV, String tenNV, String SDT, String diaChi, String gioiTinh, String CMND, Date ngaySinh, Date ngayVaoLam, String hinhAnhNV, float luongCB, String taiKhoan, String matKhau) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.SDT = SDT;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.soCMND = CMND;
        this.ngaySinh = ngaySinh;
        this.ngayVaoLam = ngayVaoLam;
        this.hinhAnhNV = hinhAnhNV;
        this.luongCB = luongCB;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public Employee() {
        
    }
    
    
     public int getMaNV() {
        return maNV;
    }
    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }
    
    public String getTenNV() {
        return tenNV;
    }

    /**
     * @param tenNV the tenNV to set
     */
    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    /**
     * @return the SDT
     */
    public String getSDT() {
        return SDT;
    }

    /**
     * @param SDT the SDT to set
     */
    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    /**
     * @return the diaChi
     */
    public String getDiaChi() {
        return diaChi;
    }

    /**
     * @param diaChi the diaChi to set
     */
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    /**
     * @return the gioiTinh
     */
    public String getGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    /**
     * @return the CMND
     */
    public String getCMND() {
        return soCMND;
    }

    /**
     * @param CMND the CMND to set
     */
    public void setCMND(String CMND) {
        this.soCMND = CMND;
    }

    /**
     * @return the ngaySinh
     */
    public Date getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    /**
     * @return the ngayVaoLam
     */
    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }

    /**
     * @param ngayVaoLam the ngayVaoLam to set
     */
    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    /**
     * @return the hinhAnhNV
     */
    public String getHinhAnhNV() {
        return hinhAnhNV;
    }

    /**
     * @param hinhAnhNV the hinhAnhNV to set
     */
    public void setHinhAnhNV(String hinhAnhNV) {
        this.hinhAnhNV = hinhAnhNV;
    }

    /**
     * @return the luongCB
     */
    public float getLuongCB() {
        return luongCB;
    }

    /**
     * @param luongCB the luongCB to set
     */
    public void setLuongCB(float luongCB) {
        this.luongCB = luongCB;
    }

    /**
     * @return the taiKhoan
     */
    public String getTaiKhoan() {
        return taiKhoan;
    }

    /**
     * @param taiKhoan the taiKhoan to set
     */
    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    /**
     * @return the matKhau
     */
    public String getMatKhau() {
        return matKhau;
    }

    /**
     * @param matKhau the matKhau to set
     */
    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    } 
}
