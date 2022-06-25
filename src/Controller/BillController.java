/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.BillDao;
import JDBCConnect.DataConnect;
import Model.BillOrder.BillOrder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ADMIN
 */
public class BillController {
    //Hiển thị các hoá đơn đã được tạo
    public void showDataEmployee(DefaultTableModel tableModel){
        List<BillOrder> list = new ArrayList<>();
        BillDao billData = new BillDao();
        list = billData.chooseFullData();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        tableModel.setRowCount(0);
        for(int i =0;i<list.size();i++){
            Object[] row = new Object[6];
            row[0] = list.get(i).getMaHD();
            row[1] = dateFormat.format(list.get(i).getNgayTao());
            row[2] = list.get(i).getTenKH();
            row[3] = list.get(i).getSDT();
            row[4] = list.get(i).getTongTien();
            row[5] = list.get(i).getPhuongThucThanhToan();
            tableModel.addRow(row);       
        }
    }
    //Tìm kiếm hoá đơn
     public void findDataEmployee(JTextField txtId,JComboBox cbType, DefaultTableModel tableModel,JPanel panel){
        BillDao manager = new BillDao();
        Pattern p = Pattern.compile("^[0-9]+$");
        if(txtId.getText().equals("")){
//            showDataEmployee(tableModel);
            JOptionPane.showMessageDialog(panel, "Ô Điền Đang Trống!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (cbType.getSelectedIndex() == 1){
            if(!p.matcher(txtId.getText()).find()){
                JOptionPane.showMessageDialog(panel, "SĐT Chỉ Có Kí Tự Số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            List<BillOrder> list = manager.findBySDT(Integer.valueOf(txtId.getText()));
            if(list.isEmpty()){
                JOptionPane.showMessageDialog(panel, "KHÔNG TÌM THẤY HOÁ ĐƠN!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }else{
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                tableModel.setRowCount(0);
                for(int i =0;i<list.size();i++){
                    Object[] row = new Object[6];
                    row[0] = list.get(i).getMaHD();
                    row[1] = dateFormat.format(list.get(i).getNgayTao());
                    row[2] = list.get(i).getTenKH();
                    row[3] = list.get(i).getSDT();
                    row[4] = list.get(i).getTongTien();
                    row[5] = list.get(i).getPhuongThucThanhToan();
                    tableModel.addRow(row);          
                }
            }
        }else{
            if(!p.matcher(txtId.getText()).find()){
                JOptionPane.showMessageDialog(panel, "Mã Hoá Đơn Chỉ Có Kí Tự Số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            List<BillOrder> list = manager.findByID(Integer.valueOf(txtId.getText()));
            if(list.isEmpty()){
                JOptionPane.showMessageDialog(panel, "KHÔNG TÌM THẤY NHÂN VIÊN!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }else{
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                tableModel.setRowCount(0);
                for(int i =0;i<list.size();i++){
                      Object[] row = new Object[6];
                    row[0] = list.get(i).getMaHD();
                    row[1] = dateFormat.format(list.get(i).getNgayTao());
                    row[2] = list.get(i).getTenKH();
                    row[3] = list.get(i).getSDT();
                    row[4] = list.get(i).getTongTien();
                    row[5] = list.get(i).getPhuongThucThanhToan();
                    tableModel.addRow(row);             
                }
            }
        }
    }
}
