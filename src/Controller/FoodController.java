/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.FoodDao;
import Dao.ManagerDao;
import Model.Employee.Employee;
import Model.Food.Food;
import View.Item.FastFoodItem;
import View.MessageNotify.MessageNotify;
import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import java.awt.TextField;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class FoodController {
    //Hiển thị danh sách thức ăn trên table
    public void showDataFood(DefaultTableModel a){
        List<Food> list = new ArrayList<>();
        FoodDao foodData = new FoodDao();
        list = foodData.chooseFullData();
        a.setRowCount(0);
        for(int i =0;i<list.size();i++){
            Object[] row = new Object[5];
            row[0] = list.get(i).getMaDA();
            row[1] = list.get(i).getTenThucAn();
            row[2] = list.get(i).getGiaThucAn();
            row[3] = list.get(i).getLoaiThucAn();
            row[4] = list.get(i).getHinhAnhThucAn();
            a.addRow(row);       
        }
    }
    public void updateLabelImage(String path,JLabel lbImage) {
        ImageIcon icon = new ImageIcon(path);
        if(icon != null){
            Image img = icon.getImage(); 
            Image newimg = img.getScaledInstance(160, 160,  java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(newimg);
            lbImage.setIcon(icon);
            lbImage.setText(null);
        }
        else{
            lbImage.setText("Image not found");
            lbImage.setIcon(null);
        }
    }
    public void clickTableData(JTextField txtMaDA,JTextField txtNameFood,JTextField txtPrice,JComboBox cbType,JTextField txtLinkImage,JLabel lbImage,DefaultTableModel tableModel,int selectedRow){
        txtMaDA.setText(tableModel.getValueAt(selectedRow, 0).toString());
        txtNameFood.setText(tableModel.getValueAt(selectedRow, 1).toString());
        txtPrice.setText(tableModel.getValueAt(selectedRow, 2).toString());
        if(tableModel.getValueAt(selectedRow, 3).toString().equals("COMBO")) cbType.setSelectedIndex(0);
        else if (tableModel.getValueAt(selectedRow, 3).toString().equals("GÀ")) cbType.setSelectedIndex(1);
        else if  (tableModel.getValueAt(selectedRow, 3).toString().equals("BÁNH MÌ")) cbType.setSelectedIndex(2);
        else if (tableModel.getValueAt(selectedRow, 3).toString().equals("HAMBURGER")) cbType.setSelectedIndex(3);
        else if (tableModel.getValueAt(selectedRow, 3).toString().equals("ĐỒ ĂN KÈM")) cbType.setSelectedIndex(4);
        else cbType.setSelectedIndex(5);
        
        txtLinkImage.setText(tableModel.getValueAt(selectedRow, 4).toString());
        updateLabelImage(txtLinkImage.getText(),lbImage);
    }
    public void resetDataFood(JTextField txtMaNV,JTextField txtFoodName,JTextField txtPrice,JComboBox cbType,JTextField txtLinkImage,JLabel lbImage){       
        txtMaNV.setText("");
        txtFoodName.setText("");
        txtPrice.setText("");
        cbType.setSelectedItem("COMBO");
        txtLinkImage.setText("");
        updateLabelImage(txtLinkImage.getText(),lbImage);
    }
    public void addDataFood(JTextField txtMaDA,JTextField txtFoodName,JTextField txtPrice,JComboBox cbType,JTextField txtLinkImage,JLabel lbImage,DefaultTableModel tableModel,JFrame frame){
        FoodDao foodData = new FoodDao();
        if(txtFoodName.getText().equals("")||txtPrice.getText().equals("")||txtLinkImage.getText().equals("")){
            MessageNotify message = new MessageNotify(frame,MessageNotify.Type.WARNING,MessageNotify.Location.TOP_LEFT,"Dữ liệu trống ?. Thêm Món Ăn thất bại!!");
            message.showNotification();
            return;
        }
        List<Food> list = new ArrayList<>();
        list = foodData.chooseFullData();
        for(int i =0;i<list.size();i++){
            if(txtFoodName.getText().equals(list.get(i).getTenThucAn())){
                MessageNotify message = new MessageNotify(frame,MessageNotify.Type.WARNING,MessageNotify.Location.TOP_LEFT,"Tên Món ăn đã được sử dụng. Dữ liệu trùng!!");
                message.showNotification();
                return;
            }
        }
        Food food = new Food();
        food.setTenThucAn(txtFoodName.getText());
        food.setGiaThucAn(Float.valueOf(txtPrice.getText()));
        food.setLoaiThucAn(cbType.getSelectedItem().toString());
        food.setHinhAnhThucAn(txtLinkImage.getText());
        foodData.insert(food);
        showDataFood(tableModel);
        resetDataFood(txtMaDA,txtFoodName,txtPrice,cbType,txtLinkImage,lbImage);
        MessageNotify message = new MessageNotify(frame,MessageNotify.Type.SUCCESS,MessageNotify.Location.TOP_CENTER,"Thêm Món Ăn Thành Công!!");
        message.showNotification();
    }
    public void deleteDataFood(JTextField txtMaDA,JTextField txtFoodName,JTextField txtPrice,JComboBox cbType,JTextField txtLinkImage,JLabel lbImage,DefaultTableModel tableModel,JFrame frame){
        FoodDao foodData = new FoodDao();
        if (txtMaDA.getText().equals("")){
            MessageNotify message = new MessageNotify(frame,MessageNotify.Type.WARNING,MessageNotify.Location.TOP_CENTER,"Dữ liệu trống.Xoá Món Ăn Thất Bại!!");
            message.showNotification();
        }else{
            foodData.delete(Integer.valueOf(txtMaDA.getText()));
            showDataFood(tableModel);
            resetDataFood(txtMaDA,txtFoodName,txtPrice,cbType,txtLinkImage,lbImage);
            MessageNotify message = new MessageNotify(frame,MessageNotify.Type.SUCCESS,MessageNotify.Location.TOP_CENTER,"Xoá Món Ăn Thành Công!!");
            message.showNotification();
        }
    }
    public void updateDataFood(JTextField txtMaDA,JTextField txtFoodName,JTextField txtPrice,JComboBox cbType,JTextField txtLinkImage,JLabel lbImage,DefaultTableModel tableModel,JFrame frame){
        
        if(txtFoodName.getText().equals("")||txtPrice.getText().equals("")||txtLinkImage.getText().equals("")){
            MessageNotify message = new MessageNotify(frame,MessageNotify.Type.WARNING,MessageNotify.Location.TOP_CENTER,"Dữ liệu trống ?. Cập nhập món ăn thất bại!!");
            message.showNotification();
            return;
        }
        FoodDao foodData = new FoodDao();
        List<Food> list = new ArrayList<>();
        list = foodData.findFoodNotUpdated(Integer.valueOf(txtMaDA.getText()));
        for(int i =0;i<list.size();i++){
            if(txtFoodName.getText().equals(list.get(i).getTenThucAn())){
                MessageNotify message = new MessageNotify(frame,MessageNotify.Type.WARNING,MessageNotify.Location.TOP_LEFT,"Tên món ăn đã được sử dụng. Dữ liệu trùng!!");
                message.showNotification();
                return;
            }
        }
        Food food = new Food();
        food.setMaDA(Integer.valueOf(txtMaDA.getText()));
        food.setTenThucAn(txtFoodName.getText());
        food.setGiaThucAn(Float.valueOf(txtPrice.getText()));
        food.setLoaiThucAn(cbType.getSelectedItem().toString());
        food.setHinhAnhThucAn(txtLinkImage.getText());
        foodData.update(food);
        showDataFood(tableModel);
        resetDataFood(txtMaDA,txtFoodName,txtPrice,cbType,txtLinkImage,lbImage);
        MessageNotify message = new MessageNotify(frame,MessageNotify.Type.SUCCESS,MessageNotify.Location.TOP_CENTER,"Cập nhập món ăn thành công!!");
        message.showNotification();
    }
    public void addMenuFood(JPanel menuCombo,JPanel menuChicken,JPanel menuBread,JPanel menuHamburger,JPanel menuAnotherFood,JPanel menuDrink,List<FastFoodItem> menuFood,String item){
        if(item.equals("COMBO")){ 
            for(int i = 0;i<menuFood.size();i++){
                menuCombo.add(menuFood.get(i));
            }
            menuCombo.revalidate();
        } else if(item.equals("GÀ")){
            for(int i = 0;i<menuFood.size();i++){
                menuChicken.add(menuFood.get(i));
            }
            menuChicken.revalidate();
        } else if(item.equals("BÁNH MÌ")){
            for(int i = 0;i<menuFood.size();i++){
                menuBread.add(menuFood.get(i));
            }
            menuBread.revalidate();
        } else if(item.equals("HAMBURGER")){
            for(int i = 0;i<menuFood.size();i++){
                menuHamburger.add(menuFood.get(i));
            }
            menuHamburger.revalidate();
        }else if(item.equals("ĐỒ ĂN KÈM")){
            for(int i = 0;i<menuFood.size();i++){
                menuAnotherFood.add(menuFood.get(i));
            }
            menuAnotherFood.revalidate();
        }else {
            for(int i = 0;i<menuFood.size();i++){
                menuDrink.add(menuFood.get(i));
            }
            menuDrink.revalidate();
        }
    }
    public void showMenuByType(JPanel menuCombo,JPanel menuChicken,JPanel menuBread,JPanel menuHamburger,JPanel menuAnotherFood,JPanel menuDrink,String type){
        FoodDao foodData = new FoodDao();
        List<Food> foodArray = new ArrayList<>();
        foodArray = foodData.chooseMenuByType(type);
        List<FastFoodItem> itemArray = new ArrayList<>();
        for(int i =0;i<foodArray.size();i++){
            itemArray.add(new FastFoodItem(foodArray.get(i)));
        }
        addMenuFood(menuCombo,menuChicken,menuBread,menuHamburger,menuAnotherFood,menuDrink,itemArray,type);
    }
    public void findFood(JTextField txtFindFood,JComboBox cbType,JTabbedPane tabbedMenuPane,JPanel panel){
        FoodDao foodData = new FoodDao();
        Pattern p = Pattern.compile("^[0-9]+$");
        if (cbType.getSelectedIndex() == 1){
            Food food = foodData.findByName(txtFindFood.getText());
            if(food.getTenThucAn().equals("")){
                JOptionPane.showMessageDialog(panel, "KHÔNG TÌM THẤY MÓN ĂN!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(food.getLoaiThucAn().equals("COMBO")){
                tabbedMenuPane.setSelectedIndex(0);
            }
            else if(food.getLoaiThucAn().equals("GÀ")){
                tabbedMenuPane.setSelectedIndex(1);
            }else if(food.getLoaiThucAn().equals("BÁNH MÌ")){
                tabbedMenuPane.setSelectedIndex(2);
            }else if(food.getLoaiThucAn().equals("HAMBURGER")){
                tabbedMenuPane.setSelectedIndex(3);
            }else if(food.getLoaiThucAn().equals("ĐỒ ĂN KÈM")){
                tabbedMenuPane.setSelectedIndex(4);
            }else{
                tabbedMenuPane.setSelectedIndex(5);
            }
            JOptionPane.showMessageDialog(panel, "Món ăn " + food.getTenThucAn() + " đã được tìm thấy!", "Thành Công", JOptionPane.INFORMATION_MESSAGE);
        }else{
            if(!p.matcher(txtFindFood.getText()).find()){
                JOptionPane.showMessageDialog(panel, "Mã Thức Ăn Chí Có Kí Tự Số!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Food food = foodData.findByID(Integer.valueOf(txtFindFood.getText()));
            if(food.getTenThucAn().equals("")){
                JOptionPane.showMessageDialog(panel, "KHÔNG TÌM THẤY MÓN ĂN!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(food.getLoaiThucAn().equals("COMBO")){
                tabbedMenuPane.setSelectedIndex(0);
            }else if(food.getLoaiThucAn().equals("GÀ")){
                tabbedMenuPane.setSelectedIndex(1);
            }else if(food.getLoaiThucAn().equals("BÁNH MÌ")){
                tabbedMenuPane.setSelectedIndex(2);
            }else if(food.getLoaiThucAn().equals("HAMBURGER")){
                tabbedMenuPane.setSelectedIndex(3);
            }else if(food.getLoaiThucAn().equals("ĐỒ ĂN KÈM")){
                tabbedMenuPane.setSelectedIndex(4);
            }else{
                tabbedMenuPane.setSelectedIndex(5);
            }
            JOptionPane.showMessageDialog(panel, "Món ăn " + food.getTenThucAn() + " đã được tìm thấy!", "Thành Công", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
