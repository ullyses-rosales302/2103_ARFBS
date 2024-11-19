/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package unitcategory;

import Connector.MyConnection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;


public class Categories extends javax.swing.JFrame {

    private Connection connect;
    public Categories() {
        initComponents();
       MyConnection conn = new MyConnection();
       connect = conn.getConnection();
        LoadUnitNo();
        Fetch();
    

    }
    
    public void LoadUnitNo(){
        
        try {
            
           PreparedStatement pst = connect.prepareStatement("SELECT UnitID FROM unitcategory");
            ResultSet rs = pst.executeQuery();
            jUnitID.removeAllItems();
            while(rs.next()){
                jUnitID.addItem(rs.getString(1));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void Fetch(){
        
        try {
            int q; 
            PreparedStatement pst = connect.prepareStatement("SELECT * FROM unitcategory");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rss= rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)TenantTable.getModel();
            df.setRowCount(0);
            
            while (rs.next()){
                Vector v2 = new Vector();
                for (int a= 1; a <= q; a ++){
                    v2.add(rs.getString("UnitID"));
                    v2.add(rs.getString("UnitType"));
                    v2.add(rs.getString("Description"));
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextDescription = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jbtnAdd = new javax.swing.JButton();
        jbtnUpdate = new javax.swing.JButton();
        jbtnDelete = new javax.swing.JButton();
        jTextUnitType = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jUnitID = new javax.swing.JComboBox<>();
        jbtnSearch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TenantTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 450));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(680, 460));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setText("UNIT CATEGORY");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setText("DESCRIPTION");

        jTextDescription.setColumns(20);
        jTextDescription.setRows(5);
        jTextDescription.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(jTextDescription);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        jbtnAdd.setBackground(new java.awt.Color(153, 153, 153));
        jbtnAdd.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jbtnAdd.setText("Add");
        jbtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddActionPerformed(evt);
            }
        });

        jbtnUpdate.setBackground(new java.awt.Color(153, 153, 153));
        jbtnUpdate.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jbtnUpdate.setText("Update");
        jbtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUpdateActionPerformed(evt);
            }
        });

        jbtnDelete.setBackground(new java.awt.Color(153, 153, 153));
        jbtnDelete.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jbtnDelete.setText("Delete");
        jbtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jbtnAdd)
                .addGap(39, 39, 39)
                .addComponent(jbtnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jbtnDelete)
                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnAdd)
                    .addComponent(jbtnUpdate)
                    .addComponent(jbtnDelete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextUnitType.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setText("UNIT TYPE");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setText("UNIT ID");

        jUnitID.setBackground(new java.awt.Color(153, 153, 153));
        jUnitID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jUnitID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUnitIDActionPerformed(evt);
            }
        });

        jbtnSearch.setBackground(new java.awt.Color(153, 153, 153));
        jbtnSearch.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jbtnSearch.setText("Search");
        jbtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jTextUnitType))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jUnitID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnSearch)))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextUnitType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jUnitID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnSearch))
                .addGap(27, 27, 27)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        TenantTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "UnitID", "UnitType", "Description"
            }
        ));
        jScrollPane2.setViewportView(TenantTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteActionPerformed
       try {
          
            String unitid =  jUnitID.getSelectedItem().toString();
            
            PreparedStatement pst = connect.prepareStatement("DELETE FROM unitcategory WHERE UnitID = ?");
            pst.setString(1, unitid);
            
            int k = pst.executeUpdate();
            
            if("".equals(jTextUnitType.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Unit Type is require", "Error", JOptionPane.ERROR_MESSAGE);
                
            }
            else if("".equals(jTextDescription.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Description about your Unit is require", "Error", JOptionPane.ERROR_MESSAGE);
                
            }
            else{
                String unit = jTextUnitType.getText();
                String des = jTextDescription.getText();
            
            if (k == 1){
                JOptionPane.showMessageDialog(this,"Record has been successfully deleted");
                jTextUnitType.setText("");
                jTextDescription.setText("");
                jTextUnitType.requestFocus();
                LoadUnitNo();
                
            } else{
                JOptionPane.showMessageDialog(this,"Record failed to deleted");
            }
            }   
        } catch (SQLException ex) {
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnDeleteActionPerformed

    private void jbtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddActionPerformed
        try {
            String unit = jTextUnitType.getText();
            String des = jTextDescription.getText();
            
            PreparedStatement pst = connect.prepareStatement("INSERT INTO unitcategory (`UnitType`, `Description`) VALUES (?,?)");
            pst.setString(1, unit);
            pst.setString(2, des);
            
            int k = pst.executeUpdate();
            
            if("".equals(jTextUnitType.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Unit Type is require", "Error", JOptionPane.ERROR_MESSAGE);
                
            }
            else if("".equals(jTextDescription.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Description about your Unit is require", "Error", JOptionPane.ERROR_MESSAGE);
                
            }
            else{
                unit = jTextUnitType.getText();
                des = jTextDescription.getText();
                
                
            if (k == 1){
                JOptionPane.showMessageDialog(this,"Added Successfully");
                jTextUnitType.setText("");
                jTextDescription.setText("");
                
            }else{
                JOptionPane.showMessageDialog(this,"Insert Failed");
                
            }
        }
        } catch (SQLException ex) {
             Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage());
        }
            
    }//GEN-LAST:event_jbtnAddActionPerformed

    private void jbtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSearchActionPerformed
        try {
            String unitid =  jUnitID.getSelectedItem().toString();
            
             PreparedStatement pst = connect.prepareStatement("SELECT * FROM unitcategory WHERE UnitID = ?");
            pst.setString(1, unitid);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next() == true){
                jTextUnitType.setText(rs.getString(2));
                jTextDescription.setText(rs.getString(3));
            }else{
                   JOptionPane.showMessageDialog(this,"No record found");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnSearchActionPerformed

    private void jUnitIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUnitIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jUnitIDActionPerformed

    private void jbtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUpdateActionPerformed
        try {
            String unit = jTextUnitType.getText();
            String des = jTextDescription.getText();
            String unitid =  jUnitID.getSelectedItem().toString();
            
             
            
            
            if("".equals(unit)){
                JOptionPane.showMessageDialog(new JFrame(), "Unit Type is require", "Error", JOptionPane.ERROR_MESSAGE);
                return;
                
            }
            if("".equals(des)){
                JOptionPane.showMessageDialog(new JFrame(), "Description about your Unit is require", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            PreparedStatement pst = connect.prepareStatement("UPDATE unitcategory SET UnitType = ?, Description = ? WHERE UnitID = ?");
            pst.setString(1, unit);
            pst.setString(2, des);
            pst.setString(3, unitid);
            
            int k = pst.executeUpdate();
            
            if (k == 1){
                JOptionPane.showMessageDialog(this,"Record has been successfully updated");
                jTextUnitType.setText("");
                jTextDescription.setText("");
                jTextUnitType.requestFocus();
                LoadUnitNo();
                
            }
            
        
        }catch (SQLException ex) {
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(Categories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Categories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Categories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Categories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Categories().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TenantTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextDescription;
    private javax.swing.JTextField jTextUnitType;
    private javax.swing.JComboBox<String> jUnitID;
    private javax.swing.JButton jbtnAdd;
    private javax.swing.JButton jbtnDelete;
    private javax.swing.JButton jbtnSearch;
    private javax.swing.JButton jbtnUpdate;
    // End of variables declaration//GEN-END:variables
}
