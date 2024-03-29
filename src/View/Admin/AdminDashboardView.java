/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.Admin;


import Model.Employee.Employee;
import View.Admin_Managers.AdminManagers;
import View.Salesman.SalesmanFoodCard;
import View.Salesman.SalesmanMenuFastFood;
import View.Salesman.SalesmanPersonalInfo;
import View.Salesman.OfflineOrder;
import View.Salesman.OnlineOrder;
import View.Item.MenuItem;
import View.Login.LoginView;
import View.Manager.ManagerMenuFastFood;
import View.Manager_Salesman.ManagerSalesmans;
import View.MessageNotify.MessageNotify;
import View.Notification.NotificationManagers;
import View.Statistics.SalesStatistics;
import java.awt.Color;
import java.awt.Component;
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
public class AdminDashboardView extends javax.swing.JFrame {

    Employee employee = new Employee();
    public AdminDashboardView() {
        initComponents();
        MessageNotify a = new MessageNotify(this,MessageNotify.Type.SUCCESS,MessageNotify.Location.TOP_CENTER,"Đăng Nhập Thành Công");
        a.showNotification();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        excute();
        setIcon();
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
    private void excute(){
        ImageIcon iconHuman = new ImageIcon(getClass().getResource("/Resources/Dashboard/Image/ManagerEmployee.png"));
        ImageIcon iconEmployee = new ImageIcon(getClass().getResource("/Resources/Dashboard/Image/Employees.png"));
        ImageIcon iconManager = new ImageIcon(getClass().getResource("/Resources/Dashboard/Image/Managers.png"));
        ImageIcon iconStatistics = new ImageIcon(getClass().getResource("/Resources/Dashboard/Image/Statistics.png"));
        ImageIcon iconMenuFastFood = new ImageIcon(getClass().getResource("/Resources/Dashboard/Image/MenuFood.png"));
        /*ImageIcon iconNext = new ImageIcon(getClass().getResource("/Image/image6.png"));*/
        ImageIcon iconNotification = new ImageIcon(getClass().getResource("/Resources/Dashboard/Image/iconNotification.png"));
        //Create subMenu Order
        MenuItem menuEmployee = new MenuItem(iconEmployee,"Nhân Viên Bán Hàng",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                panelBody.removeAll();
                panelBody.add(new ManagerSalesmans());
                panelBody.repaint();
                panelBody.revalidate();
                
            }
        });
        
        MenuItem menuManager = new MenuItem(iconManager,"Nhân Viên Quản Lý",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                panelBody.removeAll();
                panelBody.add(new AdminManagers());
                panelBody.repaint();
                panelBody.revalidate();
                
            }
        });
        MenuItem menuNotification= new MenuItem(iconNotification,"Quản Lý Thông Báo",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                panelBody.removeAll();
                panelBody.add(new NotificationManagers());
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
        MenuItem menuHuman = new MenuItem(iconHuman,"Quản Lý Nhân Sự",null,menuEmployee,menuManager);
        MenuItem menuStatistics= new MenuItem(iconStatistics,"Thống Kê",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                panelBody.removeAll();
                panelBody.add(new SalesStatistics());
                panelBody.repaint();
                panelBody.revalidate();
                
            }
        });
        addMenu(menuHuman,menuFood,menuNotification,menuStatistics);
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
        jButton2 = new javax.swing.JButton();
        panelMenu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menusPanel = new jPanelGradient();
        panelBody = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("3T FAST FOOD (ADMIN)");

        panelHeader.setBackground(new java.awt.Color(54, 33, 89));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Dashboard/Image/logoSmall.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(54, 33, 89));
        jLabel2.setFont(new java.awt.Font("Snap ITC", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("3T FAST FOOD");

        jButton2.setBackground(new java.awt.Color(54, 33, 89));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Dashboard/Image/Logout.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1066, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(40, 40, 40))
        );

        getContentPane().add(panelHeader, java.awt.BorderLayout.PAGE_START);

        panelMenu.setBackground(new java.awt.Color(0, 102, 255));
        panelMenu.setPreferredSize(new java.awt.Dimension(300, 356));

        jScrollPane1.setBackground(new java.awt.Color(0, 102, 255));

        menusPanel.setBackground(new java.awt.Color(0, 102, 255));
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
        );

        getContentPane().add(panelMenu, java.awt.BorderLayout.LINE_START);

        panelBody.setLayout(new java.awt.BorderLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Dashboard/Image/backgrounDashboard.png"))); // NOI18N
        panelBody.add(jLabel3, java.awt.BorderLayout.CENTER);

        jLabel4.setBackground(new java.awt.Color(255, 153, 153));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Xin Chào, ADMIN");
        jLabel4.setOpaque(true);
        jLabel4.setPreferredSize(new java.awt.Dimension(38, 100));
        panelBody.add(jLabel4, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(panelBody, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        LoginView a = new LoginView();
        a.setVisible(true);
        a.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(AdminDashboardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AdminDashboardView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel menusPanel;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables
}
