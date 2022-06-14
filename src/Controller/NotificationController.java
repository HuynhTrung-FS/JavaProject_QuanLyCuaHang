/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Dao.FoodDao;
import Dao.NotificationDao;
import Model.Employee.Employee;
import Model.Notification.Notification;
import View.Item.NotificationItem;
import View.MessageNotify.MessageNotify;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class NotificationController {
    //Hiển thị thông báo theo chuc vu
     public void showDataFood(DefaultTableModel a,int branch){
        List<Notification> list = new ArrayList<>();
        NotificationDao notificationData = new NotificationDao();
        list = notificationData.chooseNotificationForEmployee(branch);
        a.setRowCount(0);
        for(int i =0;i<list.size();i++){
            Object[] row = new Object[5];
            row[0] = list.get(i).getMaTB();
            row[1] = list.get(i).getTieuDe();
            row[2] = list.get(i).getNoiDung();
            row[3] = list.get(i).getNgayTao();
            a.addRow(row);       
        }
    }
     //Thêm dữ liệu thông báo theo chưc vụ 
    public void addDataNotification(JTextField txtTieuDe,JTextArea txtNoiDung,JLabel lbDate,int maNV,JFrame frame){
        NotificationDao notificationData = new NotificationDao();
        
        if(txtTieuDe.getText().equals("")||txtNoiDung.getText().equals("")){
            MessageNotify message = new MessageNotify(frame,MessageNotify.Type.WARNING,MessageNotify.Location.TOP_LEFT,"Dữ liệu trống ?. Tạo thông báo lỗi!!");
            return;
        }
        Notification notification = new Notification();
        notification.setTieuDe(txtTieuDe.getText());
        notification.setNoiDung(txtNoiDung.getText());
        notification.setNgayTao(lbDate.getText().toString());
        notification.setMaNguoiTao(maNV);
        notificationData.insertNotification(notification,maNV);
        resetDataNotification(txtTieuDe,txtNoiDung,lbDate);
        MessageNotify message = new MessageNotify(frame,MessageNotify.Type.SUCCESS,MessageNotify.Location.TOP_CENTER,"Tạo thông báo Thành Công!!");
        message.showNotification();
        
    }
    public void resetDataNotification(JTextField txtTieuDe,JTextArea txtNoiDung,JLabel lbDate){       
        txtTieuDe.setText("");
        txtNoiDung.setText("");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date current = new Date();
        lbDate.setText(formatter.format(current).toString());
    }
    public void addNotification(JPanel panelNotification,List<NotificationItem> listNotification){
        for(int i = 0;i<listNotification.size();i++){
            panelNotification.add(listNotification.get(i));
        }
        panelNotification.revalidate();
    }
    //Hiển thi danh sach thong bao để xem theo nhân viên quản lý
    public void showListNotificationForManager(JPanel panelNotification){
        NotificationDao notificationData = new NotificationDao();
        List<Notification> notificationArray = new ArrayList<>();
        notificationArray = notificationData.chooseNotificationForManager();
        List<NotificationItem> itemArray = new ArrayList<>();
        for(int i =0;i<notificationArray.size();i++){
            itemArray.add(new NotificationItem(notificationArray.get(i)));
        }
        addNotification(panelNotification,itemArray);
    }
    //hieern thi danh sach thong bao để xem theo nhân viên ban hang theo chi nhánh
    public void showListNotificationForSalesman(JPanel panelNotification,int branch){
        NotificationDao notificationData = new NotificationDao();
        List<Notification> notificationArray = new ArrayList<>();
        notificationArray = notificationData.chooseNotificationForEmployee(branch);
        List<NotificationItem> itemArray = new ArrayList<>();
        for(int i =0;i<notificationArray.size();i++){
            itemArray.add(new NotificationItem(notificationArray.get(i)));
        }
        addNotification(panelNotification,itemArray);
    }
    //Hiển thi danh sach thong bao để chỉnh của admin
     public void showListNotificationForAdminToCustom(JPanel panelNotification){
        NotificationDao notificationData = new NotificationDao();
        List<Notification> notificationArray = new ArrayList<>();
        notificationArray = notificationData.chooseNotificationForManager();
        List<NotificationItem> itemArray = new ArrayList<>();
        for(int i =0;i<notificationArray.size();i++){
            itemArray.add(new NotificationItem(notificationArray.get(i),notificationArray.get(i).getMaTB()));
        }
        addNotification(panelNotification,itemArray);
    }
    //Hiển thi danh sach thong bao để chỉnh của nhân viên quản lý
      public void showListNotificationForManagerToCustom(JPanel panelNotification,int branch){
        NotificationDao notificationData = new NotificationDao();
        List<Notification> notificationArray = new ArrayList<>();
        notificationArray = notificationData.chooseNotificationForEmployee(branch);
        List<NotificationItem> itemArray = new ArrayList<>();
        for(int i =0;i<notificationArray.size();i++){
            itemArray.add(new NotificationItem(notificationArray.get(i),notificationArray.get(i).getMaTB()));
        }
        addNotification(panelNotification,itemArray);
    }
    //Xoá thông báo (quyền của admin và nhân viên quản lý)
    public void deleteDataNotification(int maTB, JPanel panel){
        NotificationDao notificationData = new NotificationDao();
        notificationData.deleteNotification(maTB);
        JOptionPane.showMessageDialog(panel, "Xoá Thông Báo Thành Công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
        panel.setVisible(false);
    }
    public void updateDataNotification(JTextField txtTieuDe,JTextArea txtNoiDung,JLabel lbDate1,JLabel lbTitle,JLabel lbContent,JLabel lbDate,int maTB, JDialog dialog){
        NotificationDao notificationData = new NotificationDao();
        if(txtTieuDe.getText().equals("")||txtNoiDung.getText().equals("")){
            JOptionPane.showMessageDialog(dialog, "Dữ liệu để trống", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Notification notification = new Notification();
        notification.setTieuDe(txtTieuDe.getText());
        notification.setNoiDung(txtNoiDung.getText());
        notification.setNgayTao(lbDate1.getText().toString());
        notification.setMaTB(maTB);
        notificationData.updateNotification(notification);
        lbTitle.setText(txtTieuDe.getText());
        lbContent.setText(txtNoiDung.getText());
        lbDate.setText(lbDate1.getText());
        JOptionPane.showMessageDialog(dialog, "Sửa Thông Báo Thành Công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
        dialog.setVisible(false);
    }
}
