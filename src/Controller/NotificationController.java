/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class NotificationController {
     public void showDataFood(DefaultTableModel a,int check){
        List<Notification> list = new ArrayList<>();
        NotificationDao notificationData = new NotificationDao();
        list = notificationData.chooseData(check);
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
    public void addDataEmployee(JTextField txtTieuDe,JTextField txtNoiDung,JLabel lbDate,int chucVu,JFrame frame){
        NotificationDao notificationData = new NotificationDao();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        if(txtTieuDe.getText().equals("")||txtNoiDung.getText().equals("")){
            MessageNotify message = new MessageNotify(frame,MessageNotify.Type.WARNING,MessageNotify.Location.TOP_LEFT,"Dữ liệu trống ?. Tạo thông báo lỗi!!");
            return;
        }
        List<Notification> list = new ArrayList<>();
        list = notificationData.chooseData(chucVu);
        Notification notification = new Notification();
        notification.setTieuDe(txtTieuDe.getText());
        notification.setNoiDung(txtNoiDung.getText());
        
         try {
             notification.setNgayTao(dateFormat.parse(lbDate.getText().toString()));
         } catch (ParseException ex) {
             java.util.logging.Logger.getLogger(NotificationController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
        notification.setChucVu(chucVu);
        notificationData.insertNotificationSalesman(notification, chucVu);
        resetDataNotification(txtTieuDe,txtNoiDung,lbDate);
        MessageNotify message = new MessageNotify(frame,MessageNotify.Type.SUCCESS,MessageNotify.Location.TOP_CENTER,"Thêm nhân viên Thành Công!!");
        message.showNotification();
        
    }
    public void resetDataNotification(JTextField txtTieuDe,JTextField txtNoiDung,JLabel lbDate){       
        txtTieuDe.setText("");
        txtNoiDung.setText("");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date current = new Date();
        lbDate.setText(formatter.format(current).toString());
    }
//    public void excute(Notification notification){
//        //Date hiện tại 
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
//        Date current = new Date();
//        
//        NotificationItem a = new NotificationItem("Tieu de la 1 thu quai quy","Cuộc sống là bể khroor",formatter.format(current).toString());
//        addMenu(a);
//        NotificationItem b = new NotificationItem("thong bao nay khong danh cho nguoi khong biet chu","cuôc dời là nhưng niềm dâu",formatter.format(current).toString());
//        addMenu(b);
//        NotificationItem c = new NotificationItem("Tieu de la 1 thu quai quy","Vâng ádas dá dá ",formatter.format(current).toString());
//        addMenu(c);
//        NotificationItem d = new NotificationItem("Tieu de la 1 thu quai quy","vdfdsfdsfsdfsdf njj",formatter.format(current).toString());
//        addMenu(d);
//    }
//    private void addListNotification(NotificationItem... menuNotification){
//        for(int i =0;i<menuNotification.length;i++){
//            menusNotification.add(menuNotification[i]);
//        }
//        menusNotification.revalidate();
//    }
}
