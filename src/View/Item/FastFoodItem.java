/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package View.Item;

import Model.Food.Food;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author ADMIN
 */
public class FastFoodItem extends javax.swing.JPanel {
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
    /** Creates new form FastFoodItem */
    public FastFoodItem(Food food) {
        initComponents();
        lbNameFood.setText(food.getTenThucAn());
        lbPrice.setText(String.valueOf(food.getGiaThucAn()));
        updateLabelImage(food.getHinhAnhThucAn(),lbIconFood);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIconFood = new javax.swing.JLabel();
        lbNameFood = new javax.swing.JLabel();
        lbPrice = new javax.swing.JLabel();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        lbIconFood.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbNameFood.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbNameFood.setForeground(new java.awt.Color(255, 51, 51));
        lbNameFood.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNameFood.setText("ĐỒ ĂN ....");

        lbPrice.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbPrice.setForeground(new java.awt.Color(51, 51, 255));
        lbPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPrice.setText("SỐ LƯỢNG ....");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbNameFood, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbIconFood, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lbNameFood, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbIconFood, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbIconFood;
    private javax.swing.JLabel lbNameFood;
    private javax.swing.JLabel lbPrice;
    // End of variables declaration//GEN-END:variables

}
