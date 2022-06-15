/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.Salesman;

import Controller.FoodController;
import Dao.FoodDao;
import Model.Employee.Employee;
import Model.Food.Food;
import View.Item.FastFoodItem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class SalesmanMenuFastFood extends javax.swing.JPanel {

    /**
     * Creates new form MenuFastFood
     */
    private Employee employee;
    public SalesmanMenuFastFood(Employee employee) {
        initComponents();
        excute();
        this.employee = employee;
    }
    FoodController controller = new FoodController();
    private void excute(){
        controller.showMenuByType(menuCombo,menuChicken,menuBread,menuHamburger,menuAnotherFood,menuDrink,"COMBO");
        controller.showMenuByType(menuCombo,menuChicken,menuBread,menuHamburger,menuAnotherFood,menuDrink,"GÀ");
        controller.showMenuByType(menuCombo,menuChicken,menuBread,menuHamburger,menuAnotherFood,menuDrink,"BÁNH MÌ");
        controller.showMenuByType(menuCombo,menuChicken,menuBread,menuHamburger,menuAnotherFood,menuDrink,"HAMBURGER");
        controller.showMenuByType(menuCombo,menuChicken,menuBread,menuHamburger,menuAnotherFood,menuDrink,"ĐỒ ĂN KÈM");
        controller.showMenuByType(menuCombo,menuChicken,menuBread,menuHamburger,menuAnotherFood,menuDrink,"ĐỒ UỐNG");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tabbedMenuPane = new javax.swing.JTabbedPane();
        combo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menuCombo = new javax.swing.JPanel();
        chicken = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        menuChicken = new javax.swing.JPanel();
        bread = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        menuBread = new javax.swing.JPanel();
        hamburger = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        menuHamburger = new javax.swing.JPanel();
        anotherFood = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        menuAnotherFood = new javax.swing.JPanel();
        drink = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        menuDrink = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnCreateBill = new javax.swing.JButton();
        txtFindFood = new javax.swing.JTextField();
        cbType = new javax.swing.JComboBox<>();
        btnFind = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("MENU TẠI 3T");
        jPanel1.add(jLabel1);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        tabbedMenuPane.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tabbedMenuPane.setMinimumSize(new java.awt.Dimension(50, 120));

        menuCombo.setLayout(new java.awt.GridLayout(2, 0));
        jScrollPane1.setViewportView(menuCombo);

        javax.swing.GroupLayout comboLayout = new javax.swing.GroupLayout(combo);
        combo.setLayout(comboLayout);
        comboLayout.setHorizontalGroup(
            comboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        comboLayout.setVerticalGroup(
            comboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );

        tabbedMenuPane.addTab("COMBO", combo);

        menuChicken.setLayout(new java.awt.GridLayout(2, 0));
        jScrollPane2.setViewportView(menuChicken);

        javax.swing.GroupLayout chickenLayout = new javax.swing.GroupLayout(chicken);
        chicken.setLayout(chickenLayout);
        chickenLayout.setHorizontalGroup(
            chickenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        chickenLayout.setVerticalGroup(
            chickenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );

        tabbedMenuPane.addTab("GÀ", chicken);

        menuBread.setLayout(new java.awt.GridLayout(2, 0));
        jScrollPane3.setViewportView(menuBread);

        javax.swing.GroupLayout breadLayout = new javax.swing.GroupLayout(bread);
        bread.setLayout(breadLayout);
        breadLayout.setHorizontalGroup(
            breadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        breadLayout.setVerticalGroup(
            breadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );

        tabbedMenuPane.addTab("BÁNH MÌ", bread);

        menuHamburger.setLayout(new java.awt.GridLayout(2, 0));
        jScrollPane7.setViewportView(menuHamburger);

        javax.swing.GroupLayout hamburgerLayout = new javax.swing.GroupLayout(hamburger);
        hamburger.setLayout(hamburgerLayout);
        hamburgerLayout.setHorizontalGroup(
            hamburgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        hamburgerLayout.setVerticalGroup(
            hamburgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );

        tabbedMenuPane.addTab("HAMBURGER", hamburger);

        menuAnotherFood.setLayout(new java.awt.GridLayout(2, 0));
        jScrollPane4.setViewportView(menuAnotherFood);

        javax.swing.GroupLayout anotherFoodLayout = new javax.swing.GroupLayout(anotherFood);
        anotherFood.setLayout(anotherFoodLayout);
        anotherFoodLayout.setHorizontalGroup(
            anotherFoodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        anotherFoodLayout.setVerticalGroup(
            anotherFoodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );

        tabbedMenuPane.addTab("ĐỒ ĂN KÈM", anotherFood);

        menuDrink.setLayout(new java.awt.GridLayout(2, 0));
        jScrollPane6.setViewportView(menuDrink);

        javax.swing.GroupLayout drinkLayout = new javax.swing.GroupLayout(drink);
        drink.setLayout(drinkLayout);
        drinkLayout.setHorizontalGroup(
            drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        drinkLayout.setVerticalGroup(
            drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );

        tabbedMenuPane.addTab("ĐỒ UỐNG", drink);

        jPanel2.add(tabbedMenuPane, java.awt.BorderLayout.CENTER);

        btnCreateBill.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCreateBill.setText("TẠO HOÁ ĐƠN");
        btnCreateBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateBillActionPerformed(evt);
            }
        });

        txtFindFood.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Tên Món Ăn" }));
        cbType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTypeActionPerformed(evt);
            }
        });

        btnFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Dashboard/Image/Search.png"))); // NOI18N
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFindFood, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                .addComponent(btnCreateBill)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCreateBill, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFindFood, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbType, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateBillActionPerformed
        // TODO add your handling code here:
        OrderFoodCustom a = new OrderFoodCustom(employee);
        a.setVisible(true);
        a.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCreateBillActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        if(txtFindFood.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Ô ĐIỀN TÊN THỨC ĂN TRỐNG !", "Lỗi", JOptionPane.ERROR_MESSAGE);
            excute();
            tabbedMenuPane.setSelectedIndex(0);
            return;
        }
        controller.findFood(txtFindFood, cbType, tabbedMenuPane,this);
    }//GEN-LAST:event_btnFindActionPerformed

    private void cbTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel anotherFood;
    private javax.swing.JPanel bread;
    private javax.swing.JButton btnCreateBill;
    private javax.swing.JButton btnFind;
    private javax.swing.JComboBox<String> cbType;
    private javax.swing.JPanel chicken;
    private javax.swing.JPanel combo;
    private javax.swing.JPanel drink;
    private javax.swing.JPanel hamburger;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JPanel menuAnotherFood;
    private javax.swing.JPanel menuBread;
    private javax.swing.JPanel menuChicken;
    private javax.swing.JPanel menuCombo;
    private javax.swing.JPanel menuDrink;
    private javax.swing.JPanel menuHamburger;
    private javax.swing.JTabbedPane tabbedMenuPane;
    private javax.swing.JTextField txtFindFood;
    // End of variables declaration//GEN-END:variables
}
