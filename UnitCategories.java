
package UI;

import MyConnection.MyConnection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class UnitCategories extends javax.swing.JInternalFrame {

    private Connection connect;
    public UnitCategories() {
        initComponents();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
         MyConnection conn = new MyConnection();
        connect = conn.getConnection();
        
        LoadUnitNo();
        Fetch();
    }

    public void LoadUnitNo(){
        
        try {
            
           PreparedStatement pst = connect.prepareStatement("SELECT UnitID FROM unitcategories");
            ResultSet rs = pst.executeQuery();
            jUnitID.removeAllItems();
            while(rs.next()){
                jUnitID.addItem(rs.getString(1));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UnitCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void Fetch(){
        
        try {
            int q; 
            PreparedStatement pst = connect.prepareStatement("SELECT * FROM unitcategories");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rss= rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)CategoriesTable.getModel();
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
            Logger.getLogger(UnitCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jUnitID = new javax.swing.JComboBox<>();
        UnitSearch = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTextUnitType = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextDescription = new javax.swing.JTextArea();
        jbtnAdd = new javax.swing.JButton();
        jbtnUpdate = new javax.swing.JButton();
        jbtnDelete = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        CategoriesTable = new javax.swing.JTable();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel12.setText("UNIT  TYPE ID");

        jUnitID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jUnitID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUnitIDActionPerformed(evt);
            }
        });

        UnitSearch.setBackground(new java.awt.Color(204, 204, 255));
        UnitSearch.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        UnitSearch.setText("Search");
        UnitSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UnitSearchActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel11.setText("UNIT TYPE");

        jTextUnitType.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextUnitType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextUnitTypeActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setText("DESCRIPTION");

        jTextDescription.setColumns(20);
        jTextDescription.setRows(5);
        jTextDescription.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane3.setViewportView(jTextDescription);

        jbtnAdd.setBackground(new java.awt.Color(204, 204, 255));
        jbtnAdd.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jbtnAdd.setText("Add");
        jbtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddActionPerformed(evt);
            }
        });

        jbtnUpdate.setBackground(new java.awt.Color(204, 204, 255));
        jbtnUpdate.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jbtnUpdate.setText("Update");
        jbtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUpdateActionPerformed(evt);
            }
        });

        jbtnDelete.setBackground(new java.awt.Color(204, 204, 255));
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addComponent(jbtnAdd)
                        .addGap(35, 35, 35)
                        .addComponent(jbtnUpdate)
                        .addGap(37, 37, 37)
                        .addComponent(jbtnDelete))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(45, 45, 45)
                                .addComponent(jUnitID, 0, 393, Short.MAX_VALUE)
                                .addGap(44, 44, 44)
                                .addComponent(UnitSearch)
                                .addGap(229, 229, 229))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(jTextUnitType, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jUnitID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UnitSearch))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jTextUnitType, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnUpdate)
                    .addComponent(jbtnDelete))
                .addGap(31, 31, 31))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 950, 230));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/unittypelogo.png"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 30));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel8.setText("UNIT CATEGORY");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CategoriesTable.setBackground(new java.awt.Color(204, 204, 204));
        CategoriesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "UnitTypeID", "UnitType", "Description"
            }
        ));
        jScrollPane4.setViewportView(CategoriesTable);

        jPanel4.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 870, 330));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 950, 340));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(973, 973, 973))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jUnitIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUnitIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jUnitIDActionPerformed

    private void UnitSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UnitSearchActionPerformed
        try {
            String unitid =  jUnitID.getSelectedItem().toString();

            PreparedStatement pst = connect.prepareStatement("SELECT * FROM unitcategories WHERE UnitID = ?");
            pst.setString(1, unitid);
            ResultSet rs = pst.executeQuery();

            if (rs.next() == true){
                jTextUnitType.setText(rs.getString(2));
                jTextDescription.setText(rs.getString(3));
            }else{
                JOptionPane.showMessageDialog(this,"No record found");

            }
        } catch (SQLException ex) {
            Logger.getLogger(UnitCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_UnitSearchActionPerformed

    private void jTextUnitTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextUnitTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextUnitTypeActionPerformed

    private void jbtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddActionPerformed
        try {
            String unit = jTextUnitType.getText();
            String des = jTextDescription.getText();
            
            if (unit.isEmpty() || des.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all the required fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
            else{
                unit = jTextUnitType.getText();
                des = jTextDescription.getText();
                
            PreparedStatement pst = connect.prepareStatement("INSERT INTO unitcategories (`UnitType`, `Description`) VALUES (?,?)");
            pst.setString(1, unit);
            pst.setString(2, des);

            int k = pst.executeUpdate();

             jTextUnitType.setText("");
             jTextDescription.setText("");

             LoadUnitNo();
             Fetch();
             JOptionPane.showMessageDialog(this,"Added Successfully");
                   

                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UnitCategories.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage());
        }
        
        
    }//GEN-LAST:event_jbtnAddActionPerformed

    private void jbtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUpdateActionPerformed
       
        try {
            String unit = jTextUnitType.getText();
            String des = jTextDescription.getText();
            String unitid =  jUnitID.getSelectedItem().toString();

            if (unit.isEmpty() || des.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all the required fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
            }

            PreparedStatement pst = connect.prepareStatement("UPDATE unitcategories SET UnitType = ?, Description = ? WHERE UnitID = ?");
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
                Fetch();

            }
            
            jUnitID.setSelectedItem(null);

        }catch (SQLException ex) {
            Logger.getLogger(UnitCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnUpdateActionPerformed

    private void jbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteActionPerformed
         try {
            String unit = jTextUnitType.getText();
            String des = jTextDescription.getText();
            String unitid =  jUnitID.getSelectedItem().toString();

            if (unit.isEmpty() || des.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all the required fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
            }
            
            if (unitid == null || unitid.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please select a valid Tenant ID", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int confirmation = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to delete this unit record?", 
            "Confirm Deletion", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.WARNING_MESSAGE);

        if (confirmation == JOptionPane.YES_OPTION) {
            PreparedStatement pst = connect.prepareStatement("DELETE FROM unitcategories WHERE UnitID = ?");
            pst.setString(1, unitid);

            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Record has been successfully deleted");

                jTextUnitType.setText("");
                jTextDescription.setText("");
                jTextUnitType.requestFocus(); 
                LoadUnitNo();
                Fetch();
            } else {
                JOptionPane.showMessageDialog(this, "Record failed to delete");
            }

            jUnitID.setSelectedItem(null);
        } else {
            JOptionPane.showMessageDialog(this, "Deletion canceled");
        }
                
        } catch (SQLException ex) {
            Logger.getLogger(UnitCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CategoriesTable;
    private javax.swing.JButton UnitSearch;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextDescription;
    private javax.swing.JTextField jTextUnitType;
    private javax.swing.JComboBox<String> jUnitID;
    private javax.swing.JButton jbtnAdd;
    private javax.swing.JButton jbtnDelete;
    private javax.swing.JButton jbtnUpdate;
    // End of variables declaration//GEN-END:variables
}
