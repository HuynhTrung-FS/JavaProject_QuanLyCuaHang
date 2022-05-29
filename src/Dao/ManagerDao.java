/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import JDBCConnect.DataConnect;
import Model.Employee.Employee;
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
public class ManagerDao {
    //Thêm dữ liệu nhân viên quản lý
    public void insert(Employee data) {
        String sql = "insert into NHANVIEN(ChucVu,TenNV,CMND,SDT,DiaChi,GioiTinh,NgaySinh,NgayVaoLam,HinhAnhNV,LuongCB,TaiKhoan,MatKhau,ChiNhanh) values (2,?,?,?,?,?,?,?,?,?,?,?,?)";
        try { 
            Connection conn = DataConnect.openConnect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, data.getTenNV());
            pstmt.setString(2, data.getCMND());
            pstmt.setString(3, data.getSDT());
            pstmt.setString(4, data.getDiaChi());
            pstmt.setString(5, data.getGioiTinh()); 
            pstmt.setDate(6, new java.sql.Date(data.getNgaySinh().getTime())); 
            pstmt.setDate(7, new java.sql.Date(data.getNgayVaoLam().getTime()));
            pstmt.setString(8, data.getHinhAnhNV());
            pstmt.setFloat(9, data.getLuongCB());
            pstmt.setString(10, data.getTaiKhoan());
            pstmt.setString(11, data.getMatKhau());
            pstmt.setInt(12,data.getChiNhanh());
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    } 
    //Chọn tất cả dữ liệu trong nhân viên
    public List<Employee> chooseFullData(){
        List<Employee> dataList = new ArrayList<>();
        String sql = "select MaNV,TenNV,CMND,SDT,DiaChi,GioiTinh,NgaySinh,NgayVaoLam,HinhAnhNV,LuongCB,TaiKhoan,MatKhau,ChiNhanh from NHANVIEN";
        try
        {
            Connection conn = DataConnect.openConnect();
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery(sql);
            while(result.next()){
                Employee employee = new Employee();
                employee.setMaNV(result.getInt(1));
                employee.setTenNV(result.getString(2));
                employee.setCMND(result.getString(3));
                employee.setSDT(result.getString(4));
                employee.setDiaChi(result.getString(5));
                employee.setGioiTinh(result.getString(6));
                java.sql.Date dateBirth = result.getDate(7);
                employee.setNgaySinh(new Date(dateBirth.getTime()));  
                java.sql.Date dateWork = result.getDate(8);
                employee.setNgayVaoLam(new Date(dateWork.getTime()));
                employee.setHinhAnhNV(result.getString(9));
                employee.setLuongCB(result.getFloat(10));
                employee.setTaiKhoan(result.getString(11));
                employee.setMatKhau(result.getString(12));
                employee.setChiNhanh(result.getInt(13));
                dataList.add(employee);
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
    //hiên thị dữ liệu nhân viên quản lý
    public List<Employee> showData(){
        List<Employee> dataList = new ArrayList<>();
        String sql = "select MaNV,TenNV,CMND,SDT,DiaChi,GioiTinh,NgaySinh,NgayVaoLam,HinhAnhNV,LuongCB,TaiKhoan,MatKhau,ChiNhanh from NHANVIEN Where ChucVu = 2";
        try
        {
            Connection conn = DataConnect.openConnect();
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery(sql);
            while(result.next()){
                Employee employee = new Employee();
                employee.setMaNV(result.getInt(1));
                employee.setTenNV(result.getString(2));
                employee.setCMND(result.getString(3));
                employee.setSDT(result.getString(4));
                employee.setDiaChi(result.getString(5));
                employee.setGioiTinh(result.getString(6));
                java.sql.Date dateBirth = result.getDate(7);
                employee.setNgaySinh(new Date(dateBirth.getTime()));  
                java.sql.Date dateWork = result.getDate(8);
                employee.setNgayVaoLam(new Date(dateWork.getTime()));
                employee.setHinhAnhNV(result.getString(9));
                employee.setLuongCB(result.getFloat(10));
                employee.setTaiKhoan(result.getString(11));
                employee.setMatKhau(result.getString(12));
                employee.setChiNhanh(result.getInt(13));
                dataList.add(employee);
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
    //Xoá dữ liệu nhân viên quản lý
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
    //Cập nhật dữ liệu nhân viên quản lý
    public void update(Employee data){
        try {
            String sql = "update NHANVIEN set TenNV = ?,CMND = ?,SDT = ?,DiaChi = ?,GioiTinh = ?,NgaySinh = ?,NgayVaoLam = ?,HinhAnhNV = ?,LuongCB = ?,TaiKhoan = ?,MatKhau = ?,ChiNhanh =? where MaNV = ? ";
            Connection conn = DataConnect.openConnect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, data.getTenNV());
            pstmt.setString(2, data.getCMND());
            pstmt.setString(3, data.getSDT());
            pstmt.setString(4, data.getDiaChi());
            pstmt.setString(5, data.getGioiTinh());
            pstmt.setDate(6, new java.sql.Date(data.getNgaySinh().getTime())); 
            pstmt.setDate(7, new java.sql.Date(data.getNgayVaoLam().getTime()));
            pstmt.setString(8, data.getHinhAnhNV());
            pstmt.setFloat(9, data.getLuongCB());
            pstmt.setString(10, data.getTaiKhoan());
            pstmt.setString(11, data.getMatKhau());
            pstmt.setInt(12, data.getChiNhanh());
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
    //Tìm kiếm nhân viên quản lý theo ID
    public List<Employee> findByID(int maNV){
        List<Employee> dataList = new ArrayList<>();
        ResultSet result = null;
        PreparedStatement pstmt = null;
        String sql = "select MaNV,TenNV,CMND,SDT,DiaChi,GioiTinh,NgaySinh,NgayVaoLam,HinhAnhNV,LuongCB,TaiKhoan,MatKhau,ChiNhanh from NHANVIEN where MaNV = ? and ChucVu = 2";
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
                java.sql.Date dateBirth = result.getDate(7);
                employee.setNgaySinh(new Date(dateBirth.getTime()));
                java.sql.Date dateWork = result.getDate(8);
                employee.setNgayVaoLam(new Date(dateWork.getTime()));
                employee.setHinhAnhNV(result.getString(9));
                employee.setLuongCB(result.getFloat(10));
                employee.setTaiKhoan(result.getString(11));
                employee.setMatKhau(result.getString(12));
                employee.setChiNhanh(result.getInt(13));
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
    //Tìm kiếm nhân viên quản lý theo tên
    public List<Employee> findByName(String name){
        List<Employee> dataList = new ArrayList<>();
        ResultSet result = null;
        Statement stm = null;
        String sql = "select MaNV,TenNV,CMND,SDT,DiaChi,GioiTinh,NgaySinh,NgayVaoLam,HinhAnhNV,LuongCB,TaiKhoan,MatKhau,ChiNhanh from NHANVIEN where TenNV = N'" + name + "' and ChucVu = 2";
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
                java.sql.Date dateBirth = result.getDate(7);
                employee.setNgaySinh(new Date(dateBirth.getTime()));
                java.sql.Date dateWork = result.getDate(8);
                employee.setNgayVaoLam(new Date(dateWork.getTime()));
                employee.setHinhAnhNV(result.getString(9));
                employee.setLuongCB(result.getFloat(10));
                employee.setTaiKhoan(result.getString(11));
                employee.setMatKhau(result.getString(12));
                employee.setChiNhanh(result.getInt(13));
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
    //Tìm kiếm account theo nhân viên quản lý để check lúc đăng nhập
    public Employee findAccount(String user, String passWord){
        Employee employee = new Employee();
        ResultSet result = null;
        PreparedStatement pstmt = null;
        String sql = "select * from NHANVIEN where TaiKhoan = ? and MatKhau = ? and ChucVu = 2 ";
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
                java.sql.Date dateBirth = result.getDate(8);
                employee.setNgaySinh(new Date(dateBirth.getTime()));
                java.sql.Date dateWork = result.getDate(9);
                employee.setNgayVaoLam(new Date(dateWork.getTime()));
                employee.setHinhAnhNV(result.getString(10));
                employee.setLuongCB(result.getFloat(11));
                employee.setTaiKhoan(result.getString(12));
                employee.setMatKhau(result.getString(13));
                employee.setLichLamViec(result.getString(14));
                employee.setChiNhanh(result.getInt(15));
                pstmt.close();
                conn.close();
                return employee;   
            }
            else {
                employee.setTaiKhoan("a");
                employee.setMatKhau("a");
                employee.setChucVu(2);
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
    public List<Employee> findEmployeeNotUpdated(int maNV){
        List<Employee> dataList = new ArrayList<>();
        ResultSet result = null;
        PreparedStatement pstmt = null;
        String sql = "select * from NHANVIEN where MaNV != ? ";
        try {
            Connection conn = DataConnect.openConnect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maNV);
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
                java.sql.Date dateBirth = result.getDate(8);
                employee.setNgaySinh(new Date(dateBirth.getTime()));
                java.sql.Date dateWork = result.getDate(9);
                employee.setNgayVaoLam(new Date(dateWork.getTime()));
                employee.setHinhAnhNV(result.getString(10));
                employee.setLuongCB(result.getFloat(11));
                employee.setTaiKhoan(result.getString(12));
                employee.setMatKhau(result.getString(13));
                employee.setLichLamViec(result.getString(14));
                employee.setChiNhanh(result.getInt(15));
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
    ////Tìm mật khẩu cần cập nhật của nhân viên quản lý
     public void findPasswordToUpdate(int maNV,String newPassword ){
         try {
            String sql = "update NHANVIEN set MatKhau = ? where MaNV = ? ";
            Connection conn = DataConnect.openConnect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newPassword);
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
     //Cập nhật ghi chú lịch làm việc của nhân viên quản lý
     public void updateCalendar(int MaNV,String calendarArea){
        try {
            String sql = "update NHANVIEN set LichLamViec = ? where MaNV = ? ";
            Connection conn = DataConnect.openConnect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, calendarArea);
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
