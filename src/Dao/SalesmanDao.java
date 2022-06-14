/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import JDBCConnect.DataConnect;
import Model.Employee.Employee;
import View.MessageNotify.MessageNotify;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class SalesmanDao {
    //Thêm dữ liệu nhân viên bán hàng 1 chi nhánh
    public void insert(Employee data) {
        String sql = "insert into NHANVIEN(ChucVu,TenNV,CMND,SDT,DiaChi,GioiTinh,Email,NgaySinh,NgayVaoLam,HinhAnhNV,LuongCB,TaiKhoan,MatKhau,ChiNhanh) values (1,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String pattern = "YYYY-MM-DD";
        DateFormat dateFormat = new SimpleDateFormat(pattern); 
        try { 
            Connection conn = DataConnect.openConnect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, data.getTenNV());
            pstmt.setString(2, data.getCMND());
            pstmt.setString(3, data.getSDT());
            pstmt.setString(4, data.getDiaChi());
            pstmt.setString(5, data.getGioiTinh()); 
            pstmt.setString(6, data.getEmail());
            pstmt.setDate(7, new java.sql.Date(data.getNgaySinh().getTime())); 
            pstmt.setDate(8, new java.sql.Date(data.getNgayVaoLam().getTime()));
            pstmt.setString(9, data.getHinhAnhNV());
            pstmt.setFloat(10, data.getLuongCB());
            pstmt.setString(11, data.getTaiKhoan());
            pstmt.setString(12, data.getMatKhau());
            pstmt.setInt(13, data.getChiNhanh());
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    } 
    //hiển thị tất cả nhân viên bán hàng
    public List<Employee> showSalesmansData(){
        List<Employee> dataList = new ArrayList<>();
        String sql = "select MaNV,TenNV,CMND,SDT,DiaChi,GioiTinh,Email,NgaySinh,NgayVaoLam,HinhAnhNV,LuongCB,TaiKhoan,MatKhau,ChiNhanh from NHANVIEN where ChucVu = 1";
        try
        {
            Connection conn = DataConnect.openConnect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet result = pstmt.executeQuery();
            while(result.next()){
                Employee employee = new Employee();
                employee.setMaNV(result.getInt(1));
                employee.setTenNV(result.getString(2));
                employee.setCMND(result.getString(3));
                employee.setSDT(result.getString(4));
                employee.setDiaChi(result.getString(5));
                employee.setGioiTinh(result.getString(6));
                employee.setEmail(result.getString(7));
                java.sql.Date dateBirth = result.getDate(8);
                employee.setNgaySinh(new Date(dateBirth.getTime()));  
                java.sql.Date dateWork = result.getDate(9);
                employee.setNgayVaoLam(new Date(dateWork.getTime()));
                employee.setHinhAnhNV(result.getString(10));
                employee.setLuongCB(result.getFloat(11));
                employee.setTaiKhoan(result.getString(12));
                employee.setMatKhau(result.getString(13));
                employee.setChiNhanh(result.getInt(14));
                dataList.add(employee);
            }
            pstmt.close();
            conn.close();            
        }catch (ClassNotFoundException ex) {  
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dataList;
    } 
    //hiên thị dữ liệu nhân viên bán hàng theo chi nhánh
    public List<Employee> showData(int chiNhanh){
        List<Employee> dataList = new ArrayList<>();
        String sql = "select MaNV,TenNV,CMND,SDT,DiaChi,GioiTinh,Email,NgaySinh,NgayVaoLam,HinhAnhNV,LuongCB,TaiKhoan,MatKhau,ChiNhanh from NHANVIEN where ChucVu = 1 and ChiNhanh = ?";
        try
        {
            Connection conn = DataConnect.openConnect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, chiNhanh);
            ResultSet result = pstmt.executeQuery();
            while(result.next()){
                Employee employee = new Employee();
                employee.setMaNV(result.getInt(1));
                employee.setTenNV(result.getString(2));
                employee.setCMND(result.getString(3));
                employee.setSDT(result.getString(4));
                employee.setDiaChi(result.getString(5));
                employee.setGioiTinh(result.getString(6));
                employee.setEmail(result.getString(7));
                java.sql.Date dateBirth = result.getDate(8);
                employee.setNgaySinh(new Date(dateBirth.getTime()));  
                java.sql.Date dateWork = result.getDate(9);
                employee.setNgayVaoLam(new Date(dateWork.getTime()));
                employee.setHinhAnhNV(result.getString(10));
                employee.setLuongCB(result.getFloat(11));
                employee.setTaiKhoan(result.getString(12));
                employee.setMatKhau(result.getString(13));
                employee.setChiNhanh(result.getInt(14));
                dataList.add(employee);
            }
            pstmt.close();
            conn.close();            
        }catch (ClassNotFoundException ex) {  
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dataList;
    } 
    //Xoá dữ liệu nhân viên bán hàng 1 chi nhánh
    public void delete(int maNV){
        try {
            String sql = "delete from NHANVIEN where MaNV = ? ";
            Connection conn = DataConnect.openConnect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maNV);
            pstmt.executeUpdate();
            pstmt.close();   
            conn.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    } 
    //Cập nhật dữ liệu nhân viên bán hàng tất cả chi nhánh
    public void updateSalesman(Employee data){
        try {
            String sql = "update NHANVIEN set TenNV = ?,CMND = ?,SDT = ?,DiaChi = ?,GioiTinh = ?,Email = ?,NgaySinh = ?,NgayVaoLam = ?,HinhAnhNV = ?,LuongCB = ?,TaiKhoan = ?,MatKhau = ?,ChiNhanh = ? where MaNV = ? ";
            Connection conn = DataConnect.openConnect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, data.getTenNV());
            pstmt.setString(2, data.getCMND());
            pstmt.setString(3, data.getSDT());
            pstmt.setString(4, data.getDiaChi());
            pstmt.setString(5, data.getGioiTinh());
            pstmt.setString(6, data.getEmail());
            pstmt.setDate(7, new java.sql.Date(data.getNgaySinh().getTime())); 
            pstmt.setDate(8, new java.sql.Date(data.getNgayVaoLam().getTime()));
            pstmt.setString(9, data.getHinhAnhNV());
            pstmt.setFloat(10, data.getLuongCB());
            pstmt.setString(11, data.getTaiKhoan());
            pstmt.setString(12, data.getMatKhau());
            pstmt.setInt(13, data.getChiNhanh());
            pstmt.setInt(14, data.getMaNV());
            pstmt.executeUpdate();
            pstmt.close();        
            conn.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }           
    } 
    //Cập nhật dữ liệu nhân viên bán hàng 1 chi nhánh
    public void updateSalesmanByBranch(Employee data){
        try {
            String sql = "update NHANVIEN set TenNV = ?,CMND = ?,SDT = ?,DiaChi = ?,GioiTinh = ?,Email = ?,NgaySinh = ?,NgayVaoLam = ?,HinhAnhNV = ?,LuongCB = ?,TaiKhoan = ?,MatKhau = ? where MaNV = ? ";
            Connection conn = DataConnect.openConnect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, data.getTenNV());
            pstmt.setString(2, data.getCMND());
            pstmt.setString(3, data.getSDT());
            pstmt.setString(4, data.getDiaChi());
            pstmt.setString(5, data.getGioiTinh());
            pstmt.setString(6, data.getEmail());
            pstmt.setDate(7, new java.sql.Date(data.getNgaySinh().getTime())); 
            pstmt.setDate(8, new java.sql.Date(data.getNgayVaoLam().getTime()));
            pstmt.setString(9, data.getHinhAnhNV());
            pstmt.setFloat(10, data.getLuongCB());
            pstmt.setString(11, data.getTaiKhoan());
            pstmt.setString(12, data.getMatKhau());
            pstmt.setInt(13, data.getMaNV());
            pstmt.executeUpdate();
            pstmt.close();        
            conn.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }           
    } 
    //Tìm kiếm nhân viên bán hàng theo ID tât cả chi nhánh
    public List<Employee> findAllID(int maNV){
        List<Employee> dataList = new ArrayList<>();
        ResultSet result = null;
        PreparedStatement pstmt = null;
        String sql = "select MaNV,TenNV,CMND,SDT,DiaChi,GioiTinh,Email,NgaySinh,NgayVaoLam,HinhAnhNV,LuongCB,TaiKhoan,MatKhau from NHANVIEN where MaNV = ? and ChucVu = 1 ";
        try {
            Connection conn = DataConnect.openConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maNV);
            result = pstmt.executeQuery();
            while(result.next()){
                Employee employee = new Employee();
                employee.setMaNV(result.getInt(1));
                employee.setTenNV(result.getString(2));
                employee.setCMND(result.getString(3));
                employee.setSDT(result.getString(4));
                employee.setDiaChi(result.getString(5));
                employee.setGioiTinh(result.getString(6));
                employee.setEmail(result.getString(7));
                java.sql.Date dateBirth = result.getDate(8);
                employee.setNgaySinh(new Date(dateBirth.getTime()));
                java.sql.Date dateWork = result.getDate(9);
                employee.setNgayVaoLam(new Date(dateWork.getTime()));
                employee.setHinhAnhNV(result.getString(10));
                employee.setLuongCB(result.getFloat(11));
                employee.setTaiKhoan(result.getString(12));
                employee.setMatKhau(result.getString(13));
                dataList.add(employee);
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
    //Tìm kiếm nhân viên bán hàng theo tên tât cả chi nhánh
    public List<Employee> findAllName(String name){
        List<Employee> dataList = new ArrayList<>();
        ResultSet result = null;
        Statement stm = null;
        String sql = "select MaNV,TenNV,CMND,SDT,DiaChi,GioiTinh,Email,NgaySinh,NgayVaoLam,HinhAnhNV,LuongCB,TaiKhoan,MatKhau from NHANVIEN where TenNV = N'" + name + "' and ChucVu = 1";
        try {
            Connection conn = DataConnect.openConnect();
            stm = conn.createStatement();
            result = stm.executeQuery(sql);
            while(result.next()){
                Employee employee = new Employee();
                employee.setMaNV(result.getInt(1));
                employee.setTenNV(result.getString(2));
                employee.setCMND(result.getString(3));
                employee.setSDT(result.getString(4));
                employee.setDiaChi(result.getString(5));
                employee.setGioiTinh(result.getString(6));
                employee.setEmail(result.getString(7));
                java.sql.Date dateBirth = result.getDate(8);
                employee.setNgaySinh(new Date(dateBirth.getTime()));
                java.sql.Date dateWork = result.getDate(9);
                employee.setNgayVaoLam(new Date(dateWork.getTime()));
                employee.setHinhAnhNV(result.getString(10));
                employee.setLuongCB(result.getFloat(11));
                employee.setTaiKhoan(result.getString(12));
                employee.setMatKhau(result.getString(13));
                dataList.add(employee);
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
    //Tìm kiếm nhân viên bán hàng theo ID theo 1 chi nhánh
    public List<Employee> findIDByBranch(int maNV,int chiNhanh){
        List<Employee> dataList = new ArrayList<>();
        ResultSet result = null;
        PreparedStatement pstmt = null;
        String sql = "select MaNV,TenNV,CMND,SDT,DiaChi,GioiTinh,Email,NgaySinh,NgayVaoLam,HinhAnhNV,LuongCB,TaiKhoan,MatKhau from NHANVIEN where MaNV = ? and ChucVu = 1 and ChiNhanh = ?";
        try {
            Connection conn = DataConnect.openConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maNV);
            pstmt.setInt(2, chiNhanh);
            result = pstmt.executeQuery();
            while(result.next()){
                Employee employee = new Employee();
                employee.setMaNV(result.getInt(1));
                employee.setTenNV(result.getString(2));
                employee.setCMND(result.getString(3));
                employee.setSDT(result.getString(4));
                employee.setDiaChi(result.getString(5));
                employee.setGioiTinh(result.getString(6));
                employee.setEmail(result.getString(7));
                java.sql.Date dateBirth = result.getDate(8);
                employee.setNgaySinh(new Date(dateBirth.getTime()));
                java.sql.Date dateWork = result.getDate(9);
                employee.setNgayVaoLam(new Date(dateWork.getTime()));
                employee.setHinhAnhNV(result.getString(10));
                employee.setLuongCB(result.getFloat(11));
                employee.setTaiKhoan(result.getString(12));
                employee.setMatKhau(result.getString(13));
                dataList.add(employee);
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
    //Tìm kiếm nhân viên bán hàng theo tên 1 chi nhánh
    public List<Employee> findNameByBranch(String name,int chiNhanh){
        List<Employee> dataList = new ArrayList<>();
        ResultSet result = null;
        Statement stm = null;
        String sql = "select MaNV,TenNV,CMND,SDT,DiaChi,GioiTinh,Email,NgaySinh,NgayVaoLam,HinhAnhNV,LuongCB,TaiKhoan,MatKhau from NHANVIEN where TenNV = N'" + name + "' and ChucVu = 1 and ChiNhanh = '"+ chiNhanh +"'";
        try {
            Connection conn = DataConnect.openConnect();
            stm = conn.createStatement();
            result = stm.executeQuery(sql);
            while(result.next()){
                Employee employee = new Employee();
                employee.setMaNV(result.getInt(1));
                employee.setTenNV(result.getString(2));
                employee.setCMND(result.getString(3));
                employee.setSDT(result.getString(4));
                employee.setDiaChi(result.getString(5));
                employee.setGioiTinh(result.getString(6));
                employee.setEmail(result.getString(7));
                java.sql.Date dateBirth = result.getDate(8);
                employee.setNgaySinh(new Date(dateBirth.getTime()));
                java.sql.Date dateWork = result.getDate(9);
                employee.setNgayVaoLam(new Date(dateWork.getTime()));
                employee.setHinhAnhNV(result.getString(10));
                employee.setLuongCB(result.getFloat(11));
                employee.setTaiKhoan(result.getString(12));
                employee.setMatKhau(result.getString(13));
                dataList.add(employee);
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
    //Tìm kiếm account theo nhân viên bán hàng để check lúc đăng nhập
    public Employee findAccount(String user, String passWord){
        Employee employee = new Employee();
        ResultSet result = null;
        PreparedStatement pstmt = null;
        String sql = "select * from NHANVIEN where TaiKhoan = ? and MatKhau = ? and ChucVu = 1 ";
        try {
            Connection conn = DataConnect.openConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user);
            pstmt.setString(2, passWord);
            result = pstmt.executeQuery();
            if (result.next()) {
                employee.setMaNV(result.getInt(1));
                employee.setChucVu(result.getInt(2));
                employee.setTenNV(result.getString(3));
                employee.setCMND(result.getString(4));
                employee.setSDT(result.getString(5));
                employee.setDiaChi(result.getString(6));
                employee.setGioiTinh(result.getString(7));
                employee.setEmail(result.getString(8));
                java.sql.Date dateBirth = result.getDate(9);
                employee.setNgaySinh(new Date(dateBirth.getTime()));
                java.sql.Date dateWork = result.getDate(10);
                employee.setNgayVaoLam(new Date(dateWork.getTime()));
                employee.setHinhAnhNV(result.getString(11));
                employee.setLuongCB(result.getFloat(12));
                employee.setTaiKhoan(result.getString(13));
                employee.setMatKhau(result.getString(14));
                employee.setLichLamViec(result.getString(15));
                employee.setChiNhanh(result.getInt(16));
                pstmt.close();
                conn.close();
                return employee;   
            }
            else {
                employee.setTaiKhoan("a");
                employee.setMatKhau("a");
                employee.setChucVu(1);
                pstmt.close();
                conn.close();
                return employee;
            }    
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return employee;
    }
    //Tìm dữ liệu còn lại khi đang cập nhật 1 dữ liệu 
    public List<Employee> findEmployeeUpdated(int MaNV){
        List<Employee> dataList = new ArrayList<>();
        ResultSet result = null;
        PreparedStatement pstmt = null;
        String sql = "select * from NHANVIEN where MaNV != ? ";
        try {
            Connection conn = DataConnect.openConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, MaNV);
            result = pstmt.executeQuery();
            while(result.next()){
                Employee employee = new Employee();
                employee.setMaNV(result.getInt(1));
                employee.setChucVu(result.getInt(2));
                employee.setTenNV(result.getString(3));
                employee.setCMND(result.getString(4));
                employee.setSDT(result.getString(5));
                employee.setDiaChi(result.getString(6));
                employee.setGioiTinh(result.getString(7));
                employee.setEmail(result.getString(8));
                java.sql.Date dateBirth = result.getDate(9);
                employee.setNgaySinh(new Date(dateBirth.getTime()));
                java.sql.Date dateWork = result.getDate(10);
                employee.setNgayVaoLam(new Date(dateWork.getTime()));
                employee.setHinhAnhNV(result.getString(11));
                employee.setLuongCB(result.getFloat(12));
                employee.setTaiKhoan(result.getString(13));
                employee.setMatKhau(result.getString(14));
                employee.setLichLamViec(result.getString(15));
                employee.setChiNhanh(result.getInt(16));
                dataList.add(employee);
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
    //Tìm mật khẩu cần cập nhật của nhân viên bán hàng
    public void findPasswordToUpdate(int MaNV,String newPassword ){
        try {
            String sql = "update NHANVIEN set MatKhau = ? where MaNV = ? ";
            Connection conn = DataConnect.openConnect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newPassword);
            pstmt.setInt(2, MaNV);
            pstmt.executeUpdate();
            pstmt.close();        
            conn.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }           
    }
    //Cập nhật Ghi Chú Lịch Làm Việc của nhân viên bán hàng
    public void updateCalendar(int maNV,String calendarArea){
        try {
            String sql = "update NHANVIEN set LichLamViec = ? where MaNV = ? ";
            Connection conn = DataConnect.openConnect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, calendarArea);
            pstmt.setInt(2, maNV);
            pstmt.executeUpdate();
            pstmt.close();        
            conn.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    //Hiển thị lịch làm việc sau khi lưu
     public String showTextCalendar(int maNV){
        String calendar = "";
        try {
            String sql = "select LichLamViec from NHANVIEN Where MaNV = ?";
            Connection conn = DataConnect.openConnect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maNV);
            ResultSet result = pstmt.executeQuery();
            if(result.next()) calendar = result.getString(1);
            pstmt.close();        
            conn.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return calendar;
    }
}
