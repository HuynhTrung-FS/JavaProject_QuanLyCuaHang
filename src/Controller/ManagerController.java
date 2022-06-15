/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.EmployeeDao;
import Dao.ManagerDao;
import Dao.SalesmanDao;
import Model.Employee.Employee;
import View.Manager_Salesman.SalesmansCustom;
import View.MessageNotify.MessageNotify;
import com.toedter.calendar.JDateChooser;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class ManagerController {
    //Hiển thị tất cả dữ liệu nhân viên quản lý có trong bảng 
    public void showDataEmployee(DefaultTableModel tableModel){
        List<Employee> list = new ArrayList<>();
        ManagerDao managerData = new ManagerDao();
        list = managerData.chooseDataManager();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        tableModel.setRowCount(0);
        for(int i =0;i<list.size();i++){
            Object[] row = new Object[14];
            row[0] = list.get(i).getMaNV();
            row[1] = list.get(i).getTenNV();
            row[2] = dateFormat.format(list.get(i).getNgaySinh());
            if(list.get(i).getGioiTinh().equals("NAM")){
                row[3] = "Nam";
            }else{
                row[3] = "Nữ";
            }
            
            row[4] = list.get(i).getDiaChi();
            row[5] = list.get(i).getCMND();
            row[6] = list.get(i).getSDT();
            row[7] = list.get(i).getEmail();
            row[8] = dateFormat.format(list.get(i).getNgayVaoLam());
            row[9] = list.get(i).getHinhAnhNV();
            row[10] = list.get(i).getLuongCB();
            row[11] = list.get(i).getTaiKhoan();
            row[12] = list.get(i).getMatKhau();
            row[13] = list.get(i).getChiNhanh();
            tableModel.addRow(row);       
        }
    }
    //reset các ô điền nhân viên quản lý thành ô trống
    public void resetDataEmployee(JTextField txtMaNV,JTextField txtName,JDateChooser dateOfBirth,JComboBox cbGender,JTextField txtAddress,JTextField txtCMND,JTextField txtPhoneNumber,JTextField txtEmail,JDateChooser dateOfWork,JTextField txtLinkImage,JTextField txtSalary,JTextField txtUser,JTextField txtPassword,JTextField txtBranch){
        long millis=System.currentTimeMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateSet = dateFormat.format(millis);
        txtMaNV.setText("");
        txtName.setText("");
        try {
            dateOfBirth.setDate(dateFormat.parse(dateSet));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        cbGender.setSelectedItem("NAM");
        txtAddress.setText("");
        txtCMND.setText("");
        txtPhoneNumber.setText("");
        txtEmail.setText("");
        try {
            dateOfWork.setDate(dateFormat.parse(dateSet));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        txtLinkImage.setText("");
        txtSalary.setText("");
        txtUser.setText("");
        txtPassword.setText("");
        txtBranch.setText("");
    }
    //Thêm dữ liệu nhân viên quản lý
    public void addDataEmployee(JTextField txtMaNV,JTextField txtName,JDateChooser dateOfBirth,JComboBox cbGender,JTextField txtAddress,JTextField txtCMND,JTextField txtPhoneNumber,JTextField txtEmail,JDateChooser dateOfWork,JTextField txtLinkImage,JTextField txtSalary,JTextField txtUser,JTextField txtPassword,JTextField txtBranch,DefaultTableModel tableModel,JFrame frame){
        EmployeeDao employeeData = new EmployeeDao();
        ManagerDao managerData = new ManagerDao();
          if(txtName.getText().equals("")||txtAddress.getText().equals("")||txtCMND.getText().equals("")||txtPhoneNumber.getText().equals("")){
            MessageNotify message = new MessageNotify(frame,MessageNotify.Type.WARNING,MessageNotify.Location.TOP_LEFT,"Dữ liệu trống ?. Thêm nhân viên thất bại!!");
            message.showNotification();
            return;
        }else if(dateOfWork.getDate().getYear() - dateOfBirth.getDate().getYear() < 18){
            MessageNotify message = new MessageNotify(frame,MessageNotify.Type.WARNING,MessageNotify.Location.TOP_LEFT,"Nhân viên chưa đủ 18 tuổi ?. Thêm nhân viên thất bại!!");
            message.showNotification();
            return;
        }
        List<Employee> list = new ArrayList<>();
        list = employeeData.chooseFullData();
        for(int i =0;i<list.size();i++){
            if(txtCMND.getText().equals(list.get(i).getCMND())){
                MessageNotify message = new MessageNotify(frame,MessageNotify.Type.WARNING,MessageNotify.Location.TOP_LEFT,"CMND đã có người sử dụng. Dữ liệu trùng!!");
                message.showNotification();
                return;
            }else if(txtPhoneNumber.getText().equals(list.get(i).getSDT())){
                MessageNotify message = new MessageNotify(frame,MessageNotify.Type.WARNING,MessageNotify.Location.TOP_LEFT,"SĐT đã có người sử dụng. Dữ liệu trùng!!");
                message.showNotification();
                return;
            } else if(txtEmail.getText().equals(list.get(i).getEmail())){
                MessageNotify message = new MessageNotify(frame,MessageNotify.Type.WARNING,MessageNotify.Location.TOP_LEFT,"Email đã có người sử dụng. Dữ liệu trùng!!");
                message.showNotification();
                return;
            }else if(txtLinkImage.getText().equals(list.get(i).getHinhAnhNV())){
                MessageNotify message = new MessageNotify(frame,MessageNotify.Type.WARNING,MessageNotify.Location.TOP_LEFT,"Hình ảnh đã có người sử dụng. Dữ liệu trùng!!");
                message.showNotification();
                return;
            }
            else if(txtPassword.getText().equals(list.get(i).getMatKhau())){
                MessageNotify message = new MessageNotify(frame,MessageNotify.Type.WARNING,MessageNotify.Location.TOP_LEFT,"Mật Khẩu đã có người sử dụng. Dữ liệu trùng!!");
                message.showNotification();
                return;
            }
        }
        Employee employee = new Employee();
        employee.setTenNV(txtName.getText());
        employee.setNgaySinh(dateOfBirth.getDate());
        employee.setGioiTinh(cbGender.getSelectedItem().toString());
        employee.setDiaChi(txtAddress.getText());
        employee.setCMND(txtCMND.getText());
        employee.setSDT(txtPhoneNumber.getText());
        employee.setEmail(txtEmail.getText());
        employee.setNgayVaoLam(dateOfWork.getDate());
        employee.setHinhAnhNV(txtLinkImage.getText());
        employee.setLuongCB(Float.valueOf(txtSalary.getText()));
        employee.setTaiKhoan(txtUser.getText());
        employee.setMatKhau(txtPassword.getText());
        employee.setChiNhanh(Integer.valueOf(txtBranch.getText()));
        managerData.insert(employee);
        showDataEmployee(tableModel);
        resetDataEmployee(txtMaNV,txtName,dateOfBirth,cbGender,txtAddress,txtCMND,txtPhoneNumber,txtEmail,dateOfWork,txtLinkImage,txtSalary,txtUser,txtPassword,txtBranch);
        MessageNotify message = new MessageNotify(frame,MessageNotify.Type.SUCCESS,MessageNotify.Location.TOP_CENTER,"Thêm nhân viên Thành Công!!");
        message.showNotification();
        
    }
    //Nhấn vào dữ liệu trên bảng sẽ hiển thị trên ô điền
    public void clickTableData(JTextField txtMaNV,JTextField txtName,JDateChooser dateOfBirth,JComboBox cbGender,JTextField txtAddress,JTextField txtCMND,JTextField txtPhoneNumber,JTextField txtEmail,JDateChooser dateOfWork,JTextField txtLinkImage,JTextField txtSalary,JTextField txtUser,JTextField txtPassword,JTextField txtBranch,DefaultTableModel tableModel,int selectedRow){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        txtMaNV.setText(tableModel.getValueAt(selectedRow, 0).toString());
        txtName.setText(tableModel.getValueAt(selectedRow, 1).toString());
        try {
            dateOfBirth.setDate(dateFormat.parse(tableModel.getValueAt(selectedRow, 2).toString()));
        } catch (ParseException ex) {
            Logger.getLogger(SalesmansCustom.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(tableModel.getValueAt(selectedRow, 3).toString().equals("Nam")) cbGender.setSelectedItem("NAM");
        else cbGender.setSelectedItem("NU");
        txtAddress.setText(tableModel.getValueAt(selectedRow, 4).toString());
        txtCMND.setText(tableModel.getValueAt(selectedRow, 5).toString());
        txtPhoneNumber.setText(tableModel.getValueAt(selectedRow, 6).toString());
        txtEmail.setText(tableModel.getValueAt(selectedRow, 7).toString());
        try {
            dateOfWork.setDate(dateFormat.parse(tableModel.getValueAt(selectedRow, 8).toString()));
        } catch (ParseException ex) {
            Logger.getLogger(SalesmansCustom.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtLinkImage.setText(tableModel.getValueAt(selectedRow, 9).toString());
        txtSalary.setText(tableModel.getValueAt(selectedRow, 10).toString());
        txtUser.setText(tableModel.getValueAt(selectedRow, 11).toString());
        txtPassword.setText(tableModel.getValueAt(selectedRow, 12).toString());
        txtBranch.setText(tableModel.getValueAt(selectedRow, 13).toString());
    }
    //Xoá dữ liệu nhân viên quản lý
    public void deleteDataEmployee(JTextField txtMaNV,JTextField txtName,JDateChooser dateOfBirth,JComboBox cbGender,JTextField txtAddress,JTextField txtCMND,JTextField txtPhoneNumber,JTextField txtEmail,JDateChooser dateOfWork,JTextField txtLinkImage,JTextField txtSalary,JTextField txtUser,JTextField txtPassword,JTextField txtBranch,DefaultTableModel tableModel,JFrame frame){
        ManagerDao managerData = new ManagerDao();
        if (txtMaNV.getText().equals("")){
            MessageNotify message = new MessageNotify(frame,MessageNotify.Type.WARNING,MessageNotify.Location.TOP_LEFT,"Dữ liệu trống.Xoá nhân viên thất bại!!");
            message.showNotification();
        }else{
            managerData.delete(Integer.valueOf(txtMaNV.getText()));
            showDataEmployee(tableModel);
            resetDataEmployee(txtMaNV,txtName,dateOfBirth,cbGender,txtAddress,txtCMND,txtPhoneNumber,txtEmail,dateOfWork,txtLinkImage,txtSalary,txtUser,txtPassword,txtBranch);
            MessageNotify message = new MessageNotify(frame,MessageNotify.Type.SUCCESS,MessageNotify.Location.TOP_LEFT,"Xoá nhân viên Thành Công!!");
            message.showNotification();
        }
    }
    //Cập nhật dữ liệu nhân viên quản lý 
    public void updateDataEmployee(JTextField txtMaNV,JTextField txtName,JDateChooser dateOfBirth,JComboBox cbGender,JTextField txtAddress,JTextField txtCMND,JTextField txtPhoneNumber,JTextField txtEmail,JDateChooser dateOfWork,JTextField txtLinkImage,JTextField txtSalary,JTextField txtUser,JTextField txtPassword,JTextField txtBranch,DefaultTableModel tableModel,JFrame frame){
        ManagerDao managerData = new ManagerDao();
        if(txtName.getText().equals("")||txtAddress.getText().equals("")||txtCMND.getText().equals("")||txtPhoneNumber.getText().equals("")||txtUser.getText().equals("")||txtPassword.getText().equals("")){
            MessageNotify message = new MessageNotify(frame,MessageNotify.Type.WARNING,MessageNotify.Location.TOP_LEFT,"Dữ liệu trống ?. Cập nhật nhân viên thất bại!!");
            message.showNotification();
            return;
        }else if(dateOfWork.getDate().getYear() - dateOfBirth.getDate().getYear() < 18){
            MessageNotify message = new MessageNotify(frame,MessageNotify.Type.WARNING,MessageNotify.Location.TOP_LEFT,"Nhân viên chưa đủ 18 tuổi ?. Thêm nhân viên thất bại!!");
            message.showNotification();
            return;
        }
        List<Employee> list = new ArrayList<>();
        list = managerData.findEmployeeNotUpdated(Integer.valueOf(txtMaNV.getText()));
        for(int i =0;i<list.size();i++){
            if(txtCMND.getText().equals(list.get(i).getCMND())){
                MessageNotify message = new MessageNotify(frame,MessageNotify.Type.WARNING,MessageNotify.Location.TOP_LEFT,"CMND đã có người sử dụng. Dữ liệu trùng!!");
                message.showNotification();
                return;
            }else if(txtPhoneNumber.getText().equals(list.get(i).getSDT())){
                MessageNotify message = new MessageNotify(frame,MessageNotify.Type.WARNING,MessageNotify.Location.TOP_LEFT,"SĐT đã có người sử dụng. Dữ liệu trùng!!");
                message.showNotification();
                return;
            }else if(txtEmail.getText().equals(list.get(i).getEmail())){
                MessageNotify message = new MessageNotify(frame,MessageNotify.Type.WARNING,MessageNotify.Location.TOP_LEFT,"Email đã có người sử dụng. Dữ liệu trùng!!");
                message.showNotification();
                return;
            } else if(txtLinkImage.getText().equals(list.get(i).getHinhAnhNV())){
                MessageNotify message = new MessageNotify(frame,MessageNotify.Type.WARNING,MessageNotify.Location.TOP_LEFT,"Hình ảnh đã có người sử dụng. Dữ liệu trùng!!");
                message.showNotification();
                return;
            }
            else if(txtPassword.getText().equals(list.get(i).getMatKhau())){
                MessageNotify message = new MessageNotify(frame,MessageNotify.Type.WARNING,MessageNotify.Location.TOP_LEFT,"Mật Khẩu đã có người sử dụng. Dữ liệu trùng!!");
                message.showNotification();
                return;
            }
        }
        Employee employee = new Employee();
        employee.setMaNV(Integer.valueOf(txtMaNV.getText()));
        employee.setTenNV(txtName.getText());
        employee.setNgaySinh(dateOfBirth.getDate());
        employee.setGioiTinh(cbGender.getSelectedItem().toString());
        employee.setDiaChi(txtAddress.getText());
        employee.setCMND(txtCMND.getText());
        employee.setSDT(txtPhoneNumber.getText());
        employee.setEmail(txtEmail.getText());
        employee.setNgayVaoLam(dateOfWork.getDate());
        employee.setHinhAnhNV(txtLinkImage.getText());
        employee.setLuongCB(Float.valueOf(txtSalary.getText()));
        employee.setTaiKhoan(txtUser.getText());
        employee.setMatKhau(txtPassword.getText());
        employee.setChiNhanh(Integer.valueOf(txtBranch.getText()));
        managerData.update(employee);
        showDataEmployee(tableModel);
        resetDataEmployee(txtMaNV,txtName,dateOfBirth,cbGender,txtAddress,txtCMND,txtPhoneNumber,txtEmail,dateOfWork,txtLinkImage,txtSalary,txtUser,txtPassword,txtBranch);
        MessageNotify message = new MessageNotify(frame,MessageNotify.Type.SUCCESS,MessageNotify.Location.TOP_LEFT,"Cập nhập nhân viên thành công!!");
        message.showNotification();
    }
    //Tìm dữ liệu nhân viên quản lý
    public void findDataEmployee(JTextField txtId,JComboBox cbType, DefaultTableModel tableModel,JPanel panel){
        ManagerDao manager = new ManagerDao();
        Pattern p = Pattern.compile("^[0-9]+$");
        if(txtId.getText().equals("")){
//            showDataEmployee(tableModel);
            JOptionPane.showMessageDialog(panel, "Ô Điền Đang Trống!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (cbType.getSelectedIndex() == 1){
            List<Employee> dataList = manager.findByName(txtId.getText());
            if(dataList.isEmpty()){
                JOptionPane.showMessageDialog(panel, "KHÔNG TÌM THẤY NHÂN VIÊN!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }else{
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                tableModel.setRowCount(0);
                for(int i =0;i<dataList.size();i++){
                    Object[] row = new Object[14];
                    row[0] = dataList.get(i).getMaNV();
                    row[1] = dataList.get(i).getTenNV();
                    row[2] = dateFormat.format(dataList.get(i).getNgaySinh());
                    if(dataList.get(i).getGioiTinh().equals("NAM")){
                        row[3] = "Nam";
                    }else{
                        row[3] = "Nữ";
                    }

                    row[4] = dataList.get(i).getDiaChi();
                    row[5] = dataList.get(i).getCMND();
                    row[6] = dataList.get(i).getSDT();
                    row[7] = dataList.get(i).getEmail();
                    row[8] = dateFormat.format(dataList.get(i).getNgayVaoLam());
                    row[9] = dataList.get(i).getHinhAnhNV();
                    row[10] = dataList.get(i).getLuongCB();
                    row[11] = dataList.get(i).getTaiKhoan();
                    row[12] = dataList.get(i).getMatKhau();
                    row[13] = dataList.get(i).getChiNhanh();
                    tableModel.addRow(row);       
                }
            }
        }else{
            if(!p.matcher(txtId.getText()).find()){
                JOptionPane.showMessageDialog(panel, "Mã Nhân Viên Chỉ Có Kí Tự Số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            List<Employee> dataList = manager.findByID(Integer.valueOf(txtId.getText()));
            if(dataList.isEmpty()){
                JOptionPane.showMessageDialog(panel, "KHÔNG TÌM THẤY NHÂN VIÊN!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }else{
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                tableModel.setRowCount(0);
                for(int i =0;i<dataList.size();i++){
                    Object[] row = new Object[14];
                    row[0] = dataList.get(i).getMaNV();
                    row[1] = dataList.get(i).getTenNV();
                    row[2] = dateFormat.format(dataList.get(i).getNgaySinh());
                    if(dataList.get(i).getGioiTinh().equals("NAM")){
                        row[3] = "Nam";
                    }else{
                        row[3] = "Nữ";
                    }

                    row[4] = dataList.get(i).getDiaChi();
                    row[5] = dataList.get(i).getCMND();
                    row[6] = dataList.get(i).getSDT();
                    row[7] = dataList.get(i).getEmail();
                    row[8] = dateFormat.format(dataList.get(i).getNgayVaoLam());
                    row[9] = dataList.get(i).getHinhAnhNV();
                    row[10] = dataList.get(i).getLuongCB();
                    row[11] = dataList.get(i).getTaiKhoan();
                    row[12] = dataList.get(i).getMatKhau();
                    row[13] = dataList.get(i).getChiNhanh();
                    tableModel.addRow(row);             
                }
            }
        }
    }
    //Thay đổi mật khẩu nhân viên quản lý
    public void updatePassword(JTextField txtPassword,JPanel panel,Employee employee){
        ManagerDao managerData = new ManagerDao();
        if(txtPassword.getText().equals("")){
            JOptionPane.showMessageDialog(panel, "Mật khẩu đang để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        List<Employee> list = new ArrayList<>();
        list = managerData.findEmployeeNotUpdated(employee.getMaNV());
        for(int i =0;i<list.size();i++){
            if(txtPassword.getText().equals(list.get(i).getMatKhau())){
                JOptionPane.showMessageDialog(panel, "Mật khẩu đã có người sử dụng", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        managerData.findPasswordToUpdate(employee.getMaNV(),txtPassword.getText());
        JOptionPane.showMessageDialog(panel, "Thay đổi mật khẩu thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
    }
    //Cập nhật ghi chú lịch làm việc
    public void updateCalendar(JTextArea txtCalendar,JPanel panel,Employee employee){
        ManagerDao managerData = new ManagerDao();
        managerData.updateCalendar(employee.getMaNV(),txtCalendar.getText());
        JOptionPane.showMessageDialog(panel, "Cập nhật lịch làm việc thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
    }
    //hiển thị ghi chú lịch làm việc khi vừa nhấn nút lưu
     public void showCalendar(Employee employee,JTextArea txtCalendar){
        ManagerDao managerData = new ManagerDao();
        txtCalendar.setText(managerData.showTextCalendar(employee.getMaNV()));
    }
}
