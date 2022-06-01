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
    //Thêm dữ liệu thông báo cho nhân viên bán hàng nếu chucvu là 1, nhân viên quản lý nếu chucvu là 2
    public void insertNotificationSalesman(Notification data,int chucVu) {
        String sql = "insert into MENU(TieuDe,NoiDung,NgayTao,ChucVu) values (?,?,?,?)";
        try { 
            Connection conn = DataConnect.openConnect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, data.getTieuDe());
            pstmt.setString(2, data.getNoiDung());
            pstmt.setDate(3, new java.sql.Date(data.getNgayTao().getTime()));
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }   
    } 
    //hiển thị dữ liệu thông báo
    public List<Notification> chooseData(int chucVu){
        List<Notification> dataList = new ArrayList<>();
        String sql = "select TieuDe,NoiDung,NgayTao,ChucVu from BANGTHONGBAO Where ChucVu = '"+ chucVu +"'";
        try
        {
            Connection conn = DataConnect.openConnect();
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery(sql);
            while(result.next()){
                Notification notification = new Notification();
                notification.setTieuDe(result.getString(1));
                notification.setNoiDung(result.getString(2));
                java.sql.Date dateCreate = result.getDate(3);
                notification.setNgayTao(new Date(dateCreate.getTime())); 
                notification.setChucVu(result.getInt(4));
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
    //Xoá dữ liệu thông báo
    public void delete(int maTB,int chucVu){
        try {
            String sql = "delete from BANGTHONGBAO where MaTB = ? and ChucVu = ?";
            Connection conn = DataConnect.openConnect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maTB);
            pstmt.setInt(2, chucVu);
            pstmt.executeUpdate();
            pstmt.close();   
            conn.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    } 
    //
    public void updateNotificationManager(Notification data,int check){
        try {
            String sql = "update BANGTHONGBAO set TieuDe = ?,NoiDung = ?,NgayTao = ? where MaTB = ? and ChucVu = ?";
            Connection conn = DataConnect.openConnect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, data.getTieuDe());
            pstmt.setString(2, data.getNoiDung());
            pstmt.setDate(3, new java.sql.Date(data.getNgayTao().getTime()));
            pstmt.setInt(4, data.getMaTB());
            pstmt.setInt(5, check);
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
