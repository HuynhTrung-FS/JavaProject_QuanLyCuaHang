/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import JDBCConnect.DataConnect;
import Model.Notification.Notification;
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
public class NotificationDao {
    //Thêm dữ liệu thông báo của mã người tạo,manv là 0 nếu là admin, nhân viên quản lý sẽ là maNV 
    public void insertNotification(Notification data,int maNV) {
        String sql = "insert into BANGTHONGBAO(TieuDe,NoiDung,NgayTao,MaNguoiTao) values (?,?,?,?)";
        try { 
            Connection conn = DataConnect.openConnect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, data.getTieuDe());
            pstmt.setString(2, data.getNoiDung());
            pstmt.setString(3, data.getNgayTao());
            pstmt.setInt(4, maNV);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }   
    } 
    //chọn dữ liệu thông báo đã tạo của admin 
    public List<Notification> chooseNotificationForManager(){
        List<Notification> dataList = new ArrayList<>();
        String sql = "select MaTB,TieuDe,NoiDung,NgayTao,MaNguoiTao from BANGTHONGBAO where MaNguoiTao = 0";
        try
        {
            Connection conn = DataConnect.openConnect();
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery(sql);
            while(result.next()){
                Notification notification = new Notification();
                notification.setMaTB(result.getInt(1));
                notification.setTieuDe(result.getString(2));
                notification.setNoiDung(result.getString(3));
                notification.setNgayTao(result.getString(4)); 
                notification.setMaNguoiTao(result.getInt(5));
                dataList.add(notification);
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
    //chọn dữ liệu thông báo đã tạo của nhân viên quản lý 
    public List<Notification> chooseNotificationForEmployee(int chiNhanh){
        List<Notification> dataList = new ArrayList<>();
        String sql = "select MaTB,TieuDe,NoiDung,NgayTao,MaNguoiTao,TenNV from BANGTHONGBAO join NHANVIEN on BANGTHONGBAO.MaNguoiTao = NHANVIEN.MaNV Where  ChiNhanh = "+ chiNhanh+"";
        try
        {
            Connection conn = DataConnect.openConnect();
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery(sql);
            while(result.next()){
                Notification notification = new Notification();
                notification.setMaTB(result.getInt(1));
                notification.setTieuDe(result.getString(2));
                notification.setNoiDung(result.getString(3));
                notification.setNgayTao(result.getString(4)); 
                notification.setMaNguoiTao(result.getInt(5));
                notification.setTenQuanLy(result.getString(6));
                dataList.add(notification);
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
    //Xoá dữ liệu thông báo ( quyền của admin, quyền cua nhân viên quản lý)
    public void deleteNotification(int maTB){
        try {
            String sql = "delete from BANGTHONGBAO where MaTB = ?";
            Connection conn = DataConnect.openConnect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maTB);
            pstmt.executeUpdate();
            pstmt.close();   
            conn.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    } 
    //Cập nhật dữ liệu thông báo
    public void updateNotification(Notification data){
        try {
            String sql = "update BANGTHONGBAO set TieuDe = ?,NoiDung = ?,NgayTao = ? where MaTB = ?";
            Connection conn = DataConnect.openConnect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, data.getTieuDe());
            pstmt.setString(2, data.getNoiDung());
            pstmt.setString(3, data.getNgayTao());
            pstmt.setInt(4, data.getMaTB());
            pstmt.executeUpdate();
            pstmt.close();        
            conn.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }           
    } 
}
