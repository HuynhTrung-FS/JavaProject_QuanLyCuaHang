/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import JDBCConnect.DataConnect;
import Model.Employee.Employee;
import Model.Food.Food;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class FoodDao {
    //Thêm dữ liệu đồ ăn nhanh
    public void insert(Food data) {
        String sql = "insert into MENU(TenThucAn,GiaThucAn,LoaiThucAn,HinhAnhDA) values (?,?,?,?)";
        try { 
            Connection conn = DataConnect.openConnect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, data.getTenThucAn());
            pstmt.setFloat(2, data.getGiaThucAn());
            pstmt.setString(3, data.getLoaiThucAn());
            pstmt.setString(4, data.getHinhAnhThucAn());
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }   
    } 
    //Chọn tất cả dữ liệu đồ ăn nhanh
    public List<Food> chooseFullData(){
        List<Food> dataList = new ArrayList<>();
        String sql = "select * from MENU";
        try
        {
            Connection conn = DataConnect.openConnect();
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery(sql);
            while(result.next()){
                Food foodData = new Food();
                foodData.setMaDA(result.getInt(1));
                foodData.setTenThucAn(result.getString(2));
                foodData.setGiaThucAn(result.getFloat(3));
                foodData.setLoaiThucAn(result.getString(4));
                foodData.setHinhAnhThucAn(result.getString(5));
                dataList.add(foodData);
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
    //Xoá dữ liệu đồ ăn
    public void delete(int maDA){
        try {
            String sql = "delete from MENU where MaDA = ? ";
            Connection conn = DataConnect.openConnect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maDA);
            pstmt.executeUpdate();
            pstmt.close();   
            conn.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    } 
    //cập nhật đồ ăn
    public void update(Food data){
        try {
            String sql = "update MENU set TenThucAn = ?, GiaThucAn = ?,LoaiThucAn = ?,HinhAnhDA =?  where MaDA = ? ";
            Connection conn = DataConnect.openConnect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, data.getTenThucAn());
            pstmt.setFloat(2, data.getGiaThucAn());
            pstmt.setString(3, data.getLoaiThucAn());
            pstmt.setString(4, data.getHinhAnhThucAn());
            pstmt.setInt(5, data.getMaDA());
            pstmt.executeUpdate();
            pstmt.close();        
            conn.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }           
    } 
    //Tìm dữ liệu món ăn còn lại khi đang cập nhật dữ liệu
    public List<Food> findFoodNotUpdated(int maDA){
        List<Food> dataList = new ArrayList<>();
        ResultSet result = null;
        PreparedStatement pstmt = null;
        String sql = "select * from MENU where MaDA != ? ";
        try {
            Connection conn = DataConnect.openConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maDA);
            result = pstmt.executeQuery();
            while(result.next()){
                Food food = new Food();
                food.setMaDA(result.getInt(1));
                food.setTenThucAn(result.getString(2));
                food.setGiaThucAn(result.getFloat(3));
                food.setLoaiThucAn(result.getString(4));
                food.setHinhAnhThucAn(result.getString(5));
                dataList.add(food);
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
    //lọc những món ăn theo mục
    public List<Food> chooseMenuByType(String type){
        List<Food> dataList = new ArrayList<>();
        String sql = "select * from MENU where LoaiThucAn = N'"+ type +"'";
        try
        {
            Connection conn = DataConnect.openConnect();
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery(sql);
            while(result.next()){
                Food foodData = new Food();
                foodData.setMaDA(result.getInt(1));
                foodData.setTenThucAn(result.getString(2));
                foodData.setGiaThucAn(result.getFloat(3));
                foodData.setLoaiThucAn(result.getString(4));
                foodData.setHinhAnhThucAn(result.getString(5));
                dataList.add(foodData);
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
    //Tìm kiếm nhân viên quản lý theo ID
    public Food findByID(int maDA){
        Food dataFood = new Food();
        ResultSet result = null;
        PreparedStatement pstmt = null;
        String sql = "select * from MENU where MaDA = ?";
        try {
            Connection conn = DataConnect.openConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maDA);
            result = pstmt.executeQuery();
            if(result.next()){
                dataFood.setMaDA(result.getInt(1));
                dataFood.setTenThucAn(result.getString(2));
                dataFood.setGiaThucAn(result.getFloat(3));
                dataFood.setLoaiThucAn(result.getString(4));
                dataFood.setHinhAnhThucAn(result.getString(5));
            }
            pstmt.close();
            conn.close();     
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dataFood;
    }
    //Tìm kiếm nhân viên quản lý theo tên
    public Food findByName(String name){
        Food dataFood = new Food();
        ResultSet result = null;
        Statement stm = null;
        String sql = "select * from MENU where TenThucAn = N'" + name + "'";
        try {
            Connection conn = DataConnect.openConnect();
            stm = conn.createStatement();
            result = stm.executeQuery(sql);
            if(result.next()){
                dataFood.setMaDA(result.getInt(1));
                dataFood.setTenThucAn(result.getString(2));
                dataFood.setGiaThucAn(result.getFloat(3));
                dataFood.setLoaiThucAn(result.getString(4));
                dataFood.setHinhAnhThucAn(result.getString(5));
            }
            stm.close();
            conn.close();     
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dataFood;
    }
    
}
