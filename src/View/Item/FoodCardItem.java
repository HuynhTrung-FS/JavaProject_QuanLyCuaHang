/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.Item;

import JDBCConnect.DataConnect;
import static View.Salesman.SalesmanDashboardView.stateTheCho;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author ADMIN
 */
public class FoodCardItem extends javax.swing.JPanel {

    /**
     * Creates new form CardItem
     */
    private int stt;
    private int state;
    private boolean check = true;
    
    public FoodCardItem(int stt, int state) {
        this.stt = stt;
        this.state = state;
        initComponents();
        if(state==0){
            
        } else {
            lbIcon.setIcon(new ImageIcon(getClass().getResource("/Resources/Dashboard/Image/TableList.png")));
            this.check = false;
        }
        lbCard.setText("THẺ " + String.valueOf(stt));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        lbIcon = new javax.swing.JLabel();
        lbCard = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jPanel1.setMinimumSize(new java.awt.Dimension(200, 150));
        jPanel1.setPreferredSize(new java.awt.Dimension(599, 150));

        jLabel1.setText("Mã hoá đơn");

        txtMaHD.setEditable(false);

        jLabel2.setText("Ghi chú");

        txtGhiChu.setEditable(false);
        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaHD)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jFrame1.getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane2.setViewportView(jPanel3);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jFrame1.getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Chi Tiết");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Dashboard/Image/TableListNone.png"))); // NOI18N

        lbCard.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbCard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCard.setText("THẺ ...");

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Cập Nhật");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(lbCard, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(0, 22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        //Change stateTheCho
        if (!isCheck()) {
            lbIcon.setIcon(new ImageIcon(getClass().getResource("/Resources/Dashboard/Image/TableListNone.png")));
            setCheck(true);
            stateTheCho[this.stt-1] = 0;
        }
        else{
            lbIcon.setIcon(new ImageIcon(getClass().getResource("/Resources/Dashboard/Image/TableList.png")));
            setCheck(false);
            stateTheCho[this.stt-1] = 1;
        }
        
        //Change stateTheCho in database
        try {
            Connection conn = DataConnect.openConnect();
            //Create statement
            Statement st = conn.createStatement();
            
            //Create query
            String updateTheCho = "UPDATE HOADON SET TheCho = NULL WHERE TheCho =" + this.stt;
            
            //Execute query
            st.execute(updateTheCho);
            
            //Close statement and connection
            st.close();
            conn.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FoodCardItem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FoodCardItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        try {
            Connection conn = DataConnect.openConnect();
            //Create statement
            Statement st = conn.createStatement();
            
            //Create query
            String queryCTHD = "select * from (HOADON as HD join HOADON_DOAN_NHANVIEN as HD1 on HD.MaHD = HD1.MaHD) join MENU as MN on HD1.MaDA = MN.MaDA where TheCho=" + this.stt;
            
            //Excute query
            ResultSet rs = st.executeQuery(queryCTHD);
            
            //Show result
            if(rs.next()==false){
                System.out.println("Empty");
            } else {
                txtMaHD.setText(String.valueOf(rs.getInt(1)));
                txtGhiChu.setText(rs.getString(6));
                
                jPanel3.removeAll();
                do{
                    OrderFoodItem orderItem = new OrderFoodItem(rs.getString(12), rs.getFloat(13), rs.getInt(8), rs.getInt(10));
                    jPanel3.add(orderItem);
                }while(rs.next());
                
                jFrame1.setLocationRelativeTo(null);
                jFrame1.setSize(520, 400);
                jFrame1.setVisible(true);
            }
            
            //Close statement and connection
            st.close();
            conn.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FoodCardItem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FoodCardItem.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }//GEN-LAST:event_jButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbCard;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtMaHD;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the check
     */
    public boolean isCheck() {
        return check;
    }

    /**
     * @param check the check to set
     */
    public void setCheck(boolean check) {
        this.check = check;
    }
}
