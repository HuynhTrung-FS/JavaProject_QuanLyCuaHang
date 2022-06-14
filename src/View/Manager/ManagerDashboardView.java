/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.Manager;

import Model.Employee.Employee;
import View.Statistics.SalesStatistics;
import View.Manager_Salesman.ManagerSalesmans;
import View.Item.MenuItem;
import View.Login.LoginView;
import View.MessageNotify.MessageNotify;
import View.Notification.NotificationManagers;
import View.Notification.NotificationView;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */
public class ManagerDashboardView extends javax.swing.JFrame {

    JPanel panel1 = this.panelBody;
    Employee employee = new Employee();
//    public ManagerDashboardView() {
//        initComponents();
//        MessageNotify a = new MessageNotify(this,MessageNotify.Type.SUCCESS,MessageNotify.Location.TOP_CENTER,"Đăng Nhập Thành Công");
//        a.showNotification();
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        excute(null);
//        setIcon();
//        
//    }
     public ManagerDashboardView(Employee employee) {
        initComponents();
        MessageNotify a = new MessageNotify(this,MessageNotify.Type.SUCCESS,MessageNotify.Location.TOP_CENTER,"Đăng Nhập Thành Công");
        a.showNotification();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.employee = employee;
        excute(employee);
        setIcon();
        txtGreeting.setText("Xin Chào, " + employee.getTenNV());
    }
    private void setIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/Dashboard/Image/logoSmall.png")));
    }
    private void excute(Employee employee){
        //Create Icon for MenuDashboard
        ImageIcon iconPersonalInfo = new ImageIcon(getClass().getResource("/Resources/Dashboard/Image/PersonalInfo.png"));
        ImageIcon iconManagerEmployees = new ImageIcon(getClass().getResource("/Resources/Dashboard/Image/ManagerEmployee.png"));
        ImageIcon iconMenuFastFood = new ImageIcon(getClass().getResource("/Resources/Dashboard/Image/MenuFood.png"));
        ImageIcon iconSalesStatistics = new ImageIcon(getClass().getResource("/Resources/Dashboard/Image/Statistics.png"));
        ImageIcon iconNotification = new ImageIcon(getClass().getResource("/Resources/Dashboard/Image/iconNotification.png"));
        //Create menuDashboard
        MenuItem menuPersonalInfo = new MenuItem(iconPersonalInfo,"Thông Tin Cá Nhân",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                
                panelBody.removeAll();
                panelBody.add(new ManagerPersonalInfo(employee));
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem menuEmployees = new MenuItem(iconManagerEmployees,"Quản Lý Nhân Viên",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                panelBody.removeAll();
                panelBody.add(new ManagerSalesmans(employee));
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem menuNotification= new MenuItem(iconNotification,"Quản Lý Thông Báo",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                panelBody.removeAll();
                panelBody.add(new NotificationManagers(employee.getChiNhanh()));
                panelBody.repaint();
                panelBody.revalidate();
                
            }
        });
        MenuItem menuFood = new MenuItem(iconMenuFastFood,"Menu",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                panelBody.removeAll();
                panelBody.add(new ManagerMenuFastFood());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem menuSalesStatistics = new MenuItem(iconSalesStatistics,"Thống Kê",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                panelBody.removeAll();
                panelBody.add(new SalesStatistics());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        addMenu(menuPersonalInfo,menuEmployees,menuFood,menuNotification,menuSalesStatistics);
    }
    private void addMenu(MenuItem... menu){
        for(int i=0; i<menu.length ;i++){
            menusPanel.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
            for(MenuItem a: subMenu){
                addMenu(a);
            }
        }
        menusPanel.revalidate();
    }
    class jPanelGradient extends JPanel{
        @Override
        protected void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();
            Color color1 = new Color(54,33,89);
            Color color2 = new Color(255,255,255);
            GradientPaint gp = new GradientPaint(0,0,color1,180,height,color2);
            g2d.setPaint(gp);
            g2d.fillRect(0,0,width, height);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHeader = new javax.swing.JPanel();
        lbImage = new javax.swing.JLabel();
        lbNameStore = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        panelMenu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menusPanel = new jPanelGradient();
        panelBody = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtGreeting = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("3T FAST FOOD (Manager)");

        panelHeader.setBackground(new java.awt.Color(54, 33, 89));
        panelHeader.setPreferredSize(new java.awt.Dimension(871, 100));

        lbImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Dashboard/Image/logoSmall.png"))); // NOI18N

        lbNameStore.setFont(new java.awt.Font("Snap ITC", 1, 24)); // NOI18N
        lbNameStore.setForeground(new java.awt.Color(255, 255, 255));
        lbNameStore.setText("3T FAST FOOD");
        lbNameStore.setPreferredSize(new java.awt.Dimension(219, 32));

        jButton1.setBackground(new java.awt.Color(54, 33, 89));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Dashboard/Image/bell.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnLogout.setBackground(new java.awt.Color(54, 33, 89));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Dashboard/Image/Logout.png"))); // NOI18N
        btnLogout.setBorder(null);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lbImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNameStore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1002, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNameStore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        getContentPane().add(panelHeader, java.awt.BorderLayout.PAGE_START);

        panelMenu.setPreferredSize(new java.awt.Dimension(300, 407));

        jScrollPane1.setBackground(new java.awt.Color(51, 102, 255));
        jScrollPane1.setBorder(null);

        menusPanel.setBackground(new java.awt.Color(0, 102, 255));
        menusPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menusPanel.setLayout(new javax.swing.BoxLayout(menusPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(menusPanel);

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
        );

        getContentPane().add(panelMenu, java.awt.BorderLayout.LINE_START);

        panelBody.setToolTipText("");
        panelBody.setLayout(new java.awt.BorderLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Dashboard/Image/backgrounDashboard.png"))); // NOI18N
        jLabel3.setOpaque(true);
        panelBody.add(jLabel3, java.awt.BorderLayout.CENTER);

        txtGreeting.setBackground(new java.awt.Color(255, 153, 153));
        txtGreeting.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        txtGreeting.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGreeting.setText("Xin Chào,");
        txtGreeting.setOpaque(true);
        txtGreeting.setPreferredSize(new java.awt.Dimension(38, 100));
        panelBody.add(txtGreeting, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(panelBody, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        LoginView a = new LoginView();
        a.setVisible(true);
        a.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        NotificationView a = new NotificationView();
        a.setVisible(true);
        a.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManagerDashboardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerDashboardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerDashboardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerDashboardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new ManagerDashboardView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbImage;
    private javax.swing.JLabel lbNameStore;
    private javax.swing.JPanel menusPanel;
    public javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JLabel txtGreeting;
    // End of variables declaration//GEN-END:variables
}
