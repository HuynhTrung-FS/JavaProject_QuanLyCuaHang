/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Notification;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Notification {

    private int maTB;
    private String tieuDe;
    private String noiDung;
    private String ngayTao;
    private int maNguoiTao;
    private String tenQuanLy;

    public String getTenQuanLy() {
        return tenQuanLy;
    }

    public void setTenQuanLy(String tenQuanLy) {
        this.tenQuanLy = tenQuanLy;
    }

    public int getMaNguoiTao() {
        return maNguoiTao;
    }

    public void setMaNguoiTao(int maNguoiTao) {
        this.maNguoiTao = maNguoiTao;
    }

    
    public int getMaTB() {
        return maTB;
    }

    /**
     * @param maTB the maTB to set
     */
    public void setMaTB(int maTB) {
        this.maTB = maTB;
    }

    /**
     * @return the tieuDe
     */
    public String getTieuDe() {
        return tieuDe;
    }

    /**
     * @param tieuDe the tieuDe to set
     */
    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    /**
     * @return the noiDung
     */
    public String getNoiDung() {
        return noiDung;
    }

    /**
     * @param noiDung the noiDung to set
     */
    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    /**
     * @return the ngayTao
     */
    public String getNgayTao() {
        return ngayTao;
    }

    /**
     * @param ngayTao the ngayTao to set
     */
    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }
}
