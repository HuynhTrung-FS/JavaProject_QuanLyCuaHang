/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import JDBCConnect.DataConnect;
import Model.Statistics.Statistics;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author ADMIN
 */
public class StatisticsDao {
    //tính sum của 1 tháng
    public float tinhTong(int month,int year){
        String sql = "  select sum(TongTien) from HOADON where Year(NgayBan) = ? and Month(NgayBan) = ? ";
        String pattern = "YYYY-MM-DD";
        float a = -1 ;
        DateFormat dateFormat = new SimpleDateFormat(pattern); 
        try { 
            Connection conn = DataConnect.openConnect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, year);
            pstmt.setInt(2, month);
            ResultSet result = pstmt.executeQuery();
            if(result.next()){
                a = result.getFloat(1);
            }else{
                a = 0 ;
            }
            pstmt.close();
            conn.close();            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }
     public float tinhTongTienNam(int year){
        String sql = "  select sum(TongTien) from HOADON where Year(NgayBan) = ? ";
        String pattern = "YYYY-MM-DD";
        float a = -1 ;
        DateFormat dateFormat = new SimpleDateFormat(pattern); 
        try { 
            Connection conn = DataConnect.openConnect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, year);
            ResultSet result = pstmt.executeQuery();
            if(result.next()){
                a = result.getFloat(1);
            }else{
                a = -1 ;
            }
            pstmt.close();
            conn.close();            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }
}
