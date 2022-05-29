/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Food;

/**
 *
 * @author ADMIN
 */
public class Food {

    public Food() {
        maDA = 0;
        tenThucAn = "";
        giaThucAn = 0;
        loaiThucAn = "";
        hinhAnhThucAn = "";
    }

    private int maDA;
    private String tenThucAn;
    private float giaThucAn;
    private String loaiThucAn;
    private String hinhAnhThucAn;
    public int getMaDA() {
        return maDA;
    }

    /**
     * @param maDA the maDA to set
     */
    public void setMaDA(int maDA) {
        this.maDA = maDA;
    }

    /**
     * @return the tenThucAn
     */
    public String getTenThucAn() {
        return tenThucAn;
    }

    /**
     * @param tenThucAn the tenThucAn to set
     */
    public void setTenThucAn(String tenThucAn) {
        this.tenThucAn = tenThucAn;
    }

    /**
     * @return the giaThucAn
     */
    public float getGiaThucAn() {
        return giaThucAn;
    }

    /**
     * @param giaThucAn the giaThucAn to set
     */
    public void setGiaThucAn(float giaThucAn) {
        this.giaThucAn = giaThucAn;
    }

    /**
     * @return the loaiThucAn
     */
    public String getLoaiThucAn() {
        return loaiThucAn;
    }

    /**
     * @param loaiThucAn the loaiThucAn to set
     */
    public void setLoaiThucAn(String loaiThucAn) {
        this.loaiThucAn = loaiThucAn;
    }

    /**
     * @return the hinhAnhThucAn
     */
    public String getHinhAnhThucAn() {
        return hinhAnhThucAn;
    }

    /**
     * @param hinhAnhThucAn the hinhAnhThucAn to set
     */
    public void setHinhAnhThucAn(String hinhAnhThucAn) {
        this.hinhAnhThucAn = hinhAnhThucAn;
    }
}
