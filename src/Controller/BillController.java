/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import JDBCConnect.DataConnect;
import java.sql.Connection;
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
public class BillController {
    public List<BillOrder> chooseFullData(){
        List<BillOrder> dataList = new ArrayList<>();
        String sql = "select * from HOADON";
        try
        {
            Connection conn = DataConnect.openConnect();
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery(sql);
            while(result.next()){
                BillOrder bill = BillOrder();
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
            state.close();
            conn.close();            
        }catch (ClassNotFoundException ex) {  
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dataList;
    }
}
