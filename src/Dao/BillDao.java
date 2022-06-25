/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import JDBCConnect.DataConnect;
import Model.BillOrder.BillOrder;
import Model.Employee.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class BillDao {
     public List<BillOrder> chooseFullData(){
        List<BillOrder> dataList = new ArrayList<>();
        String sql = "select * from (HOADON as HD join HOADON_KHACHHANG as HD_KH on HD.MaHD = HD_KH.MaHD) join KHACHHANG as KH on HD_KH.MaKH = KH.MaKH";
        try
        {
            Connection conn = DataConnect.openConnect();
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery(sql);
            while(result.next()){
                BillOrder bill = new BillOrder();
                bill.setMaHD(result.getInt(1));
                java.sql.Date dateBirth = result.getDate(2);
                bill.setNgayTao(new Date(dateBirth.getTime()));
                bill.setTongTien(result.getFloat(3));
                bill.setPhuongThucThanhToan(result.getString(4));
                bill.setGhiChu(result.getString(6));
                bill.setSDT(result.getString(10));
                bill.setTenKH(result.getString(11));
                dataList.add(bill);
            }
            state.close();
            conn.close();            
        }catch (ClassNotFoundException ex) {  
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dataList;
    }
    //Tìm kiếm hoá đơn theo mã hoá đơn
     public List<BillOrder> findByID(int id){
        List<BillOrder> dataList = new ArrayList<>();
        ResultSet result = null;
        PreparedStatement pstmt = null;
        String sql = "select * from (HOADON as HD join HOADON_KHACHHANG as HD_KH on HD.MaHD = HD_KH.MaHD) join KHACHHANG as KH on HD_KH.MaKH = KH.MaKH where HD.MaHD = ?";
        try {
            Connection conn = DataConnect.openConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            result = pstmt.executeQuery();
            while(result.next()){
                BillOrder bill = new BillOrder();
                bill.setMaHD(result.getInt(1));
                java.sql.Date dateBirth = result.getDate(2);
                bill.setNgayTao(new Date(dateBirth.getTime()));
                bill.setTongTien(result.getFloat(3));
                bill.setPhuongThucThanhToan(result.getString(4));
                bill.setGhiChu(result.getString(6));
                bill.setSDT(result.getString(10));
                bill.setTenKH(result.getString(11));
                dataList.add(bill);
            }
            pstmt.close();
            conn.close();     
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dataList;
    }
    //Tìm kiếm hoá đơn theo sđt
    public List<BillOrder> findBySDT(int maKH){
        List<BillOrder> dataList = new ArrayList<>();
        ResultSet result = null;
        Statement stm = null;
        String sql = "select * from (HOADON as HD join HOADON_KHACHHANG as HD_KH on HD.MaHD = HD_KH.MaHD) join KHACHHANG as KH on HD_KH.MaKH = KH.MaKH where KH.MaKH = " + maKH;
        try {
            Connection conn = DataConnect.openConnect();
            stm = conn.createStatement();
            result = stm.executeQuery(sql);
            while(result.next()){
                BillOrder bill = new BillOrder();
                bill.setMaHD(result.getInt(1));
                java.sql.Date dateBirth = result.getDate(2);
                bill.setNgayTao(new Date(dateBirth.getTime()));
                bill.setTongTien(result.getFloat(3));
                bill.setPhuongThucThanhToan(result.getString(4));
                bill.setGhiChu(result.getString(6));
                bill.setSDT(result.getString(10));
                bill.setTenKH(result.getString(11));
                dataList.add(bill);
            }
            stm.close();
            conn.close();     
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dataList;
    }
}
