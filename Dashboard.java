
package UI;

import MyConnection.MyConnection;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


public class Dashboard extends javax.swing.JInternalFrame {

    private Connection connect;
    public Dashboard() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
        MyConnection conn = new MyConnection();
        connect = conn.getConnection();
        
        updateDashboardCounts();
    }

    private void updateDashboardCounts() {
    // Queries for counts
    String userCountQuery = "SELECT COUNT(*) AS userCount FROM appusers"; 
    String unitCountQuery = "SELECT COUNT(*) AS unitCount FROM apartmentunit"; 
    String tenantCountQuery = "SELECT COUNT(*) AS tenantCount FROM tenant"; 
    String paymentCountQuery = "SELECT COUNT(*) AS paymentCount FROM payment"; 
    
    try {
        Statement stmt = connect.createStatement();
        ResultSet rs = stmt.executeQuery(userCountQuery);
        if (rs.next()) {
            int userCount = rs.getInt("userCount");
            txtUserCount.setText(String.valueOf(userCount));
        }

        rs = stmt.executeQuery(unitCountQuery);
        if (rs.next()) {
            int unitCount = rs.getInt("unitCount");
            txtUnitCount.setText(String.valueOf(unitCount)); 
        }

        rs = stmt.executeQuery(tenantCountQuery);
        if (rs.next()) {
            int tenantCount = rs.getInt("tenantCount");
            txtTenantCount.setText(String.valueOf(tenantCount)); 
        }

        rs = stmt.executeQuery(paymentCountQuery);
        if (rs.next()) {
            int paymentCount = rs.getInt("paymentCount");
            txtPaymentCount.setText(String.valueOf(paymentCount));
        }
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error retrieving data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        System.out.println("Error: " + e.getMessage());
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtTenantCount = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtUserCount = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtPaymentCount = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtUnitCount = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel8.setText("DASHBOARD");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/option.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(640, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel1))
                .addGap(13, 13, 13))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 60));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setText("TENANTS");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 7, -1, -1));

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, -1, 128));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/tenantslogobigger.png"))); // NOI18N
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 60, 60));

        txtTenantCount.setBackground(new java.awt.Color(204, 204, 255));
        txtTenantCount.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        txtTenantCount.setForeground(new java.awt.Color(102, 102, 255));
        txtTenantCount.setBorder(null);
        jPanel3.add(txtTenantCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 120, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 380, 130));

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setText("REGISTERED USER ");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 7, -1, -1));

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, -1, 128));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/tenantslogobigger.png"))); // NOI18N
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 60, 60));

        txtUserCount.setBackground(new java.awt.Color(204, 204, 255));
        txtUserCount.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        txtUserCount.setForeground(new java.awt.Color(102, 102, 255));
        txtUserCount.setBorder(null);
        txtUserCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserCountActionPerformed(evt);
            }
        });
        jPanel5.add(txtUserCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 120, 40));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 380, 130));

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel4.setText("PAYMENTS");
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 7, -1, -1));

        jPanel8.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, -1, 128));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/paymentlogobigger.png"))); // NOI18N
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 60, 60));

        txtPaymentCount.setBackground(new java.awt.Color(204, 204, 255));
        txtPaymentCount.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        txtPaymentCount.setForeground(new java.awt.Color(102, 102, 255));
        txtPaymentCount.setBorder(null);
        txtPaymentCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaymentCountActionPerformed(evt);
            }
        });
        jPanel7.add(txtPaymentCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 120, 40));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 380, 130));

        jPanel9.setBackground(new java.awt.Color(204, 204, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel5.setText("APARTMENT UNITS");
        jPanel9.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 7, -1, -1));

        jPanel10.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, -1, 128));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/unittypelogobigger.png"))); // NOI18N
        jPanel9.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 60, 60));

        txtUnitCount.setBackground(new java.awt.Color(204, 204, 255));
        txtUnitCount.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        txtUnitCount.setForeground(new java.awt.Color(102, 102, 255));
        txtUnitCount.setBorder(null);
        txtUnitCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnitCountActionPerformed(evt);
            }
        });
        jPanel9.add(txtUnitCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 120, 40));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 380, 130));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserCountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserCountActionPerformed

    private void txtPaymentCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaymentCountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaymentCountActionPerformed

    private void txtUnitCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnitCountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnitCountActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField txtPaymentCount;
    private javax.swing.JTextField txtTenantCount;
    private javax.swing.JTextField txtUnitCount;
    private javax.swing.JTextField txtUserCount;
    // End of variables declaration//GEN-END:variables
}
