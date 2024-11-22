/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package unitcategory;

import Connector.MyConnection;
import java.awt.Graphics;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Vector;
import static javax.management.remote.JMXConnectorFactory.connect;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
public class bill extends javax.swing.JFrame {

    private Connection connect;
    public bill() {
        initComponents();
         MyConnection conn = new MyConnection();
         connect = conn.getConnection();
         LoadTenantNo();
         PaymentTable();
    }

    public void LoadTenantNo(){
        
        try {
            
           PreparedStatement pst = connect.prepareStatement("SELECT TenantID FROM tenant");
            ResultSet rs = pst.executeQuery();
            jTenantID.removeAllItems();
            while(rs.next()){
                jTenantID.addItem(rs.getString(1));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void PaymentTable() {
    try {
        PreparedStatement pst = connect.prepareStatement("SELECT * FROM payment");
        ResultSet rs = pst.executeQuery();
        ResultSetMetaData rss = rs.getMetaData();
        int q = rss.getColumnCount();

        DefaultTableModel df = (DefaultTableModel) ptable.getModel();
        df.setRowCount(0);

        while (rs.next()) {
            Vector v2 = new Vector();
            v2.add(rs.getString("PaymentID"));
            v2.add(rs.getString("LastName"));
            v2.add(rs.getString("FirstName"));
            v2.add(rs.getString("UnitID"));
            v2.add(rs.getString("MRate"));
            v2.add(rs.getString("TotalBill"));

            df.addRow(v2);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    
    private void print(double amount) {
    jTextArea1.append("Amount: " + amount);
    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtxtTenantlname = new javax.swing.JTextField();
        jtxtTenantfname = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ptable = new javax.swing.JTable();
        jTenantID = new javax.swing.JComboBox<>();
        jtxtMrate = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnGbill = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jtxtWtrUsage = new javax.swing.JTextField();
        jtxtElecUsage = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtxtRnumber = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnShowRcpt = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jtxtApateu = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setText("BILLING AND PAYMENT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setText("Tenant Name");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setText("Unit ID");

        jtxtTenantlname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtTenantlnameActionPerformed(evt);
            }
        });

        jtxtTenantfname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtTenantfnameActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ptable.setBackground(new java.awt.Color(204, 204, 255));
        ptable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Payment ID", "First Name", "Last Name", "Unit ID", "Monthly Rate", "Total Bill"
            }
        ));
        jScrollPane1.setViewportView(ptable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );

        jTenantID.setBackground(new java.awt.Color(204, 204, 255));
        jTenantID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jtxtMrate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtMrateActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel8.setText("Monthly Rate");

        btnGbill.setBackground(new java.awt.Color(204, 204, 255));
        btnGbill.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnGbill.setText("Generate Bill");
        btnGbill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGbillActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel9.setText("Water Usage ");

        jtxtWtrUsage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtWtrUsageActionPerformed(evt);
            }
        });

        jtxtElecUsage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtElecUsageActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel10.setText("Electricty Usage");

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel11.setText("Receipt No.");

        jtxtRnumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jjtxtRnumberActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel12.setText("Total Bill");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setText("Tenant ID");

        btnShowRcpt.setBackground(new java.awt.Color(204, 204, 255));
        btnShowRcpt.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnShowRcpt.setText("Show Receipt");
        btnShowRcpt.setBorder(null);

        btnSearch.setBackground(new java.awt.Color(204, 204, 255));
        btnSearch.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnSearch.setText("Seach");
        btnSearch.setBorder(null);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jtxtApateu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtApateuActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel4.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
        jLabel4.setText("35 per m3");

        jLabel6.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
        jLabel6.setText("12 per kWh");

        btnSave.setBackground(new java.awt.Color(204, 204, 255));
        btnSave.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnShowRcpt, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8)
                                    .addComponent(jtxtMrate, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4))
                                    .addComponent(jtxtWtrUsage, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6))
                                    .addComponent(jtxtElecUsage, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jtxtRnumber, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtxtTenantlname, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addComponent(jtxtTenantfname, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jtxtApateu))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jTenantID, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(31, 31, 31)
                                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGbill, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(28, 28, 28))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTenantID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtTenantlname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtTenantfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxtApateu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtxtMrate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtxtWtrUsage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10))
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxtElecUsage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxtRnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnGbill, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(btnShowRcpt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        double amount;
    private void jtxtTenantlnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtTenantlnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtTenantlnameActionPerformed

    private void jtxtTenantfnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtTenantfnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtTenantfnameActionPerformed

    private void jtxtMrateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtMrateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtMrateActionPerformed

    private void btnGbillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGbillActionPerformed
    try {                                         
        double charge, elect = 0, water = 0;
        double mrate; // Declare `mrate` as a double for consistency
        double amount; // Declare the `amount` variable

        // Parse electric usage
        int kwh;
        try {
            kwh = Integer.parseInt(jtxtElecUsage.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input for electricity usage!");
            return;
        }

        if (kwh >= 1) {
            charge = 12;
            elect = kwh * charge;
        }

        // Parse water usage
        int cpm;
        try {
            cpm = Integer.parseInt(jtxtWtrUsage.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input for water usage!");
            return;
        }

        if (cpm >= 1) {
            charge = 35;
            water = cpm * charge;
        }

        // Parse monthly rate
        try {
            mrate = Double.parseDouble(jtxtMrate.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input for monthly rate!");
            return;
        }

        // Calculate total amount
        amount = elect + water + mrate;

        // Print or display result (ensure `print()` is defined)
        print(amount);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + ex.getMessage());
    }
    
        
    }//GEN-LAST:event_btnGbillActionPerformed

    private void jtxtWtrUsageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtWtrUsageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtWtrUsageActionPerformed

    private void jtxtElecUsageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtElecUsageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtElecUsageActionPerformed

    private void jjtxtRnumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jjtxtRnumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jjtxtRnumberActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            String tenantid =  jTenantID.getSelectedItem().toString();
            String unitid = jtxtApateu.getText();
            PreparedStatement pst = connect.prepareStatement("SELECT * FROM tenant WHERE TenantID = ?");
            pst.setString(1, tenantid);
            ResultSet rs = pst.executeQuery();

            if (rs.next() == true){
                jtxtTenantlname.setText(rs.getString(2));
                jtxtTenantfname.setText(rs.getString(3));
                jtxtApateu.setText(rs.getString(6));
            }else{
                JOptionPane.showMessageDialog(this,"No record found");

            }
            pst = connect.prepareStatement("SELECT * FROM apartmentunit WHERE ApateuID = ?");
            pst.setString(1, unitid);
            rs = pst.executeQuery();

            if (rs.next() == true){
                jtxtMrate.setText(rs.getString(4));
            }else{
                JOptionPane.showMessageDialog(this,"No record found");

            }
        } catch (SQLException ex) {
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jtxtApateuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtApateuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtApateuActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
      try {
    String lastname = jtxtTenantlname.getText().trim();
    String firstname = jtxtTenantfname.getText().trim();
    String unit = jtxtApateu.getText().trim();
    String mrate = jtxtMrate.getText().trim();
    String totalBillString = jTextArea1.getText().trim();

    
    if (lastname.isEmpty() || firstname.isEmpty() || unit.isEmpty() || mrate.isEmpty() || totalBillString.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all the required fields.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

   
    if (totalBillString.startsWith("Amount:")) {
        totalBillString = totalBillString.replace("Amount:", "").trim();
    }

    
    double totalBill = Double.parseDouble(totalBillString);

    
    PreparedStatement pst = connect.prepareStatement(
        "INSERT INTO payment (LastName, FirstName, UnitID, MRate, TotalBill) VALUES (?, ?, ?, ?, ?)"
    );
    pst.setString(1, lastname);
    pst.setString(2, firstname);
    pst.setString(3, unit);
    pst.setString(4, mrate);
    pst.setDouble(5, totalBill);

    int k = pst.executeUpdate();

    if (k == 1) {
        JOptionPane.showMessageDialog(this, "Saved successfully!");

        // Reset fields
        jtxtTenantlname.setText("");
        jtxtTenantfname.setText("");
        jtxtApateu.setText("");
        jtxtMrate.setText("");
        jTextArea1.setText("");
    } else {
        JOptionPane.showMessageDialog(this, "Save failed.", "Error", JOptionPane.ERROR_MESSAGE);
    }
} catch (NumberFormatException ex) {
    JOptionPane.showMessageDialog(this, "Invalid numeric value: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
} catch (SQLException ex) {
    JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}


    }//GEN-LAST:event_btnSaveActionPerformed

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
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGbill;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnShowRcpt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jTenantID;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jtxtApateu;
    private javax.swing.JTextField jtxtElecUsage;
    private javax.swing.JTextField jtxtMrate;
    private javax.swing.JTextField jtxtRnumber;
    private javax.swing.JTextField jtxtTenantfname;
    private javax.swing.JTextField jtxtTenantlname;
    private javax.swing.JTextField jtxtWtrUsage;
    private javax.swing.JTable ptable;
    // End of variables declaration//GEN-END:variables
}
