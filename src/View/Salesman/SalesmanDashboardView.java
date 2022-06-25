/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.Salesman;

import Model.Employee.Employee;
import View.Item.MenuItem;
import View.Login.LoginView;
import View.MessageNotify.MessageNotify;
import View.Notification.NotificationView;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ADMIN
 */
public class SalesmanDashboardView extends javax.swing.JFrame {
    /**
     * Creates new form EmployDashboardView
     */
    Employee employee = new Employee();
//    public SalesmanDashboardView() {
//        initComponents();
//        MessageNotify a = new MessageNotify(this,MessageNotify.Type.SUCCESS,MessageNotify.Location.TOP_CENTER,"Đăng Nhập Thành Công!!");
//        a.showNotification();
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        //excute();
//        setIcon();
//    }
    public static int[] stateTheCho = new int[11];
    
    public SalesmanDashboardView(Employee employee) {
        initComponents();
        MessageNotify a = new MessageNotify(this,MessageNotify.Type.SUCCESS,MessageNotify.Location.TOP_CENTER,"Đăng Nhập Thành Công!!");
        a.showNotification();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        excute(employee);
        this.employee = employee;
        setIcon();
        lbGreeting.setText("Xin Chào, " + employee.getTenNV());
    }
    private void setIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/Dashboard/Image/logoSmall.png")));
    }
    class jPanelGradient extends JPanel {
        @Override
        protected void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D) g;   
            int width = getWidth();
            int height = getHeight();            
            Color color1 = new Color(54,33,89);
            Color color2 = new Color(255,255,255);
            GradientPaint gp = new GradientPaint(0,0,color1,180,height,color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, width, height);
        }
    }
    private void excute(Employee employee){
        ImageIcon iconPersonalInfo = new ImageIcon(getClass().getResource("/Resources/Dashboard/Image/PersonalInfo.png"));
        ImageIcon iconFood = new ImageIcon(getClass().getResource("/Resources/Dashboard/Image/MenuFood.png"));
        ImageIcon iconOrder = new ImageIcon(getClass().getResource("/Resources/Dashboard/Image/Order.png"));
        ImageIcon iconOnlineOrder = new ImageIcon(getClass().getResource("/Resources/Dashboard/Image/Online.png"));
        ImageIcon iconOfflineOrder = new ImageIcon(getClass().getResource("/Resources/Dashboard/Image/Offline.png"));
        ImageIcon iconCard = new ImageIcon(getClass().getResource("/Resources/Dashboard/Image/Table.png"));
        /*ImageIcon iconNext = new ImageIcon(getClass().getResource("/Image/image6.png"));*/
        //Create subMenu Order
        MenuItem menuOnlineOrder = new MenuItem(iconOnlineOrder,"Online",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                panelBody.removeAll();
                panelBody.add(new OnlineOrder());
                panelBody.repaint();
                panelBody.revalidate();
                
            }
        });
        MenuItem menuOfflineOrder = new MenuItem(iconOfflineOrder,"Offline",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                panelBody.removeAll();
                panelBody.add(new OfflineOrder());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        
        
        //Create menusPane
        MenuItem menuPersonalInfo = new MenuItem(iconPersonalInfo,"Thông Tin Cá Nhân",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                panelBody.removeAll();
                panelBody.add(new SalesmanPersonalInfo(employee));
                panelBody.repaint();
                panelBody.revalidate();
                
            }
        });
        MenuItem menuFood = new MenuItem(iconFood,"Menu",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                panelBody.removeAll();
                panelBody.add(new SalesmanMenuFastFood(employee));
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem menuOrder = new MenuItem(iconOrder,"Hoá Đơn",null,menuOnlineOrder,menuOfflineOrder);
        MenuItem menuCard = new MenuItem(iconCard,"Thẻ Chờ",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                panelBody.removeAll();
                
                panelBody.add(new SalesmanFoodCard(stateTheCho));
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        addMenu(menuPersonalInfo,menuFood,menuOrder,menuCard);
    }
     private void addMenu(MenuItem... menu){
        for(int i=0; i<menu.length;i++){
            menusPanel.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
            for(MenuItem a: subMenu){
                addMenu(a);
            }
        }
        menusPanel.revalidate();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        panelMenu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menusPanel = new jPanelGradient();
        panelBody = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbGreeting = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("3T FAST FOOD (Employee)");

        panelHeader.setBackground(new java.awt.Color(54, 33, 89));
        panelHeader.setPreferredSize(new java.awt.Dimension(871, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Dashboard/Image/logoSmall.png"))); // NOI18N
        jLabel1.setToolTipText("");

        jLabel2.setBackground(new java.awt.Color(54, 33, 89));
        jLabel2.setFont(new java.awt.Font("Snap ITC", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("3T FAST FOOD");
        jLabel2.setOpaque(true);

        btnLogOut.setBackground(new java.awt.Color(54, 33, 89));
        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Dashboard/Image/Logout.png"))); // NOI18N
        btnLogOut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 33, 89), 5));
        btnLogOut.setBorderPainted(false);
        btnLogOut.setOpaque(false);
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(54, 33, 89));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Dashboard/Image/bell.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 438, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(29, 29, 29)
                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelHeader, java.awt.BorderLayout.PAGE_START);

        panelMenu.setBackground(new java.awt.Color(51, 255, 51));
        panelMenu.setPreferredSize(new java.awt.Dimension(300, 382));

        jScrollPane1.setBackground(new java.awt.Color(0, 204, 51));
        jScrollPane1.setBorder(null);

        menusPanel.setBackground(new java.awt.Color(0, 102, 255));
        menusPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menusPanel.setRequestFocusEnabled(false);
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
        );

        getContentPane().add(panelMenu, java.awt.BorderLayout.LINE_START);

        panelBody.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        panelBody.setLayout(new java.awt.BorderLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Dashboard/Image/backgrounDashboard.png"))); // NOI18N
        panelBody.add(jLabel3, java.awt.BorderLayout.CENTER);

        lbGreeting.setBackground(new java.awt.Color(255, 153, 153));
        lbGreeting.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        lbGreeting.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbGreeting.setText("Xin Chào");
        lbGreeting.setOpaque(true);
        lbGreeting.setPreferredSize(new java.awt.Dimension(38, 100));
        panelBody.add(lbGreeting, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(panelBody, java.awt.BorderLayout.CENTER);

        setBounds(0, 0, 885, 519);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        LoginView a = new LoginView();
        a.setVisible(true);
        a.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        NotificationView a = new NotificationView(this.employee.getChiNhanh());
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
            java.util.logging.Logger.getLogger(SalesmanDashboardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesmanDashboardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesmanDashboardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesmanDashboardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                SalesmanDashboardView a = new SalesmanDashboardView();
//                a.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbGreeting;
    private javax.swing.JPanel menusPanel;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables
}
