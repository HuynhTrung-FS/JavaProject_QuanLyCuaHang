/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.Item;

import View.Salesman.OrderFoodCustom;
import static View.Salesman.OrderFoodCustom.arr;
import static View.Salesman.OrderFoodCustom.jLabel6;
import static View.Salesman.OrderFoodCustom.lbSumPrice;
import static View.Salesman.OrderFoodCustom.soLuong;
import static View.Salesman.OrderFoodCustom.sum;
import java.awt.Dimension;
import javax.swing.JButton;

/**
 *
 * @author ADMIN
 */
public class OrderFoodItem extends javax.swing.JPanel {

    /**
     * Creates new form OrderFoodItem
     */
    //private String temp;
    private int count = 0;
    private float price = 0 ;
    private float tong = 0;
    private int MaDA = 0;
    public OrderFoodItem(String foodName, float foodPrice, int MaDA) {
        this.MaDA = MaDA;
        initComponents();
        this.setSize(new Dimension(50,50));
        lbFoodName.setText(foodName);
        //temp = String.valueOf(foodPrice);
        price = foodPrice;
    }
    
    public OrderFoodItem(String foodName, float foodPrice, int MaDA, int soLuong) {
        this.MaDA = MaDA;
        initComponents();
        this.setSize(new Dimension(50,50));
        lbFoodName.setText(foodName);
        //temp = String.valueOf(foodPrice);
        price = foodPrice;
        jButton1.setEnabled(false);
        jButton1.setVisible(false);
        jButton2.setEnabled(false);
        jButton2.setVisible(false);
        txtCount.setEditable(false);
        txtCount.setText(String.valueOf(soLuong));
        lbPrice.setText(String.valueOf(soLuong*foodPrice));
        this.setSize(200, 28);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbFoodName = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lbPrice = new javax.swing.JLabel();
        txtCount = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        lbFoodName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbFoodName.setText("FOOD NAME");

        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("-");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lbPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbPrice.setText("0.0");

        txtCount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCount.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbFoodName, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(75, 75, 75)
                .addComponent(txtCount, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(lbPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lbPrice))
                    .addComponent(txtCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lbFoodName))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)))
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
   
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.count += 1;
        txtCount.setText(String.valueOf(this.count));
        lbPrice.setText(String.valueOf(this.count*this.price));
        tong = price * count;
        
        //Update soLuong
        soLuong = 0;
        for(int i = 0; i<arr.size() ; i++){
            if(arr.get(i).getCount()>0){
                soLuong += arr.get(i).getCount();
            }
        }
        jLabel6.setText(String.valueOf(soLuong));
        
        //Update sum
        sum = 0;
        for(int i = 0; i<arr.size() ; i++){
            if(arr.get(i).getTong()>0){
                sum += arr.get(i).getTong();
            }
        }
        lbSumPrice.setText(String.valueOf(sum));
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(this.count>0){
            this.count -=1;
            txtCount.setText(String.valueOf(this.count));
            lbPrice.setText(String.valueOf(this.count*this.price));
            tong = price * count;
        }
        
        //Update soLuong
        soLuong = 0;
        for(int i = 0; i<arr.size() ; i++){
            if(arr.get(i).getCount()>0){
                soLuong += arr.get(i).getCount();
            }
        }
        jLabel6.setText(String.valueOf(soLuong));
        
        //Update sum
        sum = 0;
        for(int i = 0; i<arr.size() ; i++){
            if(arr.get(i).getTong()>0){
                sum += arr.get(i).getTong();
            }
        }
        lbSumPrice.setText(String.valueOf(sum));
        
        
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbFoodName;
    private javax.swing.JLabel lbPrice;
    private javax.swing.JTextField txtCount;
    // End of variables declaration//GEN-END:variables

     
   

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the Tong
     */
    public float getTong() {
        return tong;
    }

    /**
     * @param Tong the Tong to set
     */
    public void setTong(float Tong) {
        this.tong = Tong;
        lbPrice.setText(String.valueOf(this.tong));
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
        txtCount.setText(String.valueOf(this.count));
    }

    /**
     * @return the MaDA
     */
    public int getMaDA() {
        return MaDA;
    }

    /**
     * @param MaDA the MaDA to set
     */
    public void setMaDA(int MaDA) {
        this.MaDA = MaDA;
    }
    
    
    
}
