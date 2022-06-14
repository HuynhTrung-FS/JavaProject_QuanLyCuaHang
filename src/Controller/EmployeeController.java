/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.EmployeeDao;
import Model.Employee.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ADMIN
 */
public class EmployeeController {
     public void updateAndSendPassword(JTextField txtEmail,String newPassword,JDialog dialog){
        EmployeeDao employeeData = new EmployeeDao();
        if(txtEmail.getText().equals("")){
            JOptionPane.showMessageDialog(dialog, "Email đang để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!checkEmail(txtEmail)){
            JOptionPane.showMessageDialog(dialog, "Email không trùng khớp", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        employeeData.findPasswordToSendAndUpdate(txtEmail.getText(),newPassword);
        JOptionPane.showMessageDialog(dialog, "Gửi mật khẩu thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
    }
     public boolean checkEmail(JTextField txtEmail){
        EmployeeDao employeeData = new EmployeeDao();
        List<Employee> list = new ArrayList<>();
        list = employeeData.chooseFullData();
        for(int i =0;i<list.size();i++){
            if(txtEmail.getText().equals(list.get(i).getEmail())){
                return true;
            }
        }
        return false;
     }
}
