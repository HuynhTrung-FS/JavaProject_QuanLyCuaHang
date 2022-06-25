/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.StatisticsDao;
import java.math.BigDecimal;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class StatisticsController {
    public void tinhTongTungThang(JTextField txtYear, DefaultTableModel tableModel){
        StatisticsDao statistics = new StatisticsDao();
        tableModel.setRowCount(0);
        for(int i =1;i<13;i++){
            Object[] row = new Object[2];
            row[0] = "Tháng " + i;
            row[1] = String.valueOf(new BigDecimal(statistics.tinhTong(i, Integer.valueOf(txtYear.getText()))));
            tableModel.addRow(row);       
        }
    }
    public void tinhTongNam(JTextField txtYear,JLabel sumYear){
        StatisticsDao statistics = new StatisticsDao();
        sumYear.setText(String.valueOf(new BigDecimal(statistics.tinhTongTienNam(Integer.valueOf(txtYear.getText())))));
    }
}
