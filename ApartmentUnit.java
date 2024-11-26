
package UI;

import MyConnection.MyConnection;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;


public class ApartmentUnit extends javax.swing.JInternalFrame {

    private Connection connect;
    public ApartmentUnit() {
        initComponents();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
         MyConnection conn = new MyConnection();
        connect = conn.getConnection();
        
        reloadUnitData();
        populateUnitTypeComboBox();
        populateUnitIDComboBox();
        
    }
    
    private void reloadUnitData() {
    try {
        String selectQuery = "SELECT au.ApateuID, au.UnitNo, au.MRate, uc.UnitType, uc.Description, au.UnitStatus " +
                             "FROM apartmentunit au " +
                             "JOIN unitcategories uc ON au.UnitID = uc.UnitID";

        Statement st = connect.createStatement();
        ResultSet rs = st.executeQuery(selectQuery);

        DefaultTableModel model = (DefaultTableModel) UnitTable.getModel();
        model.setRowCount(0);

        while (rs.next()) {
            Object[] row = new Object[]{
                rs.getInt("ApateuID"), 
                rs.getString("UnitNo"),       
                rs.getString("UnitType"),     
                rs.getString("Description"),            
                rs.getString("MRate"),
                rs.getString("UnitStatus")
            };
            model.addRow(row);  
        }
        
        
    } catch (SQLException e) {
        System.out.println("Error while reloading unit data: " + e.getMessage());
    }
}
    
    private void populateUnitTypeComboBox() {
    try {
        
        Statement st = connect.createStatement();
        String query = "SELECT UnitType FROM unitcategories"; 
        ResultSet rs = st.executeQuery(query);

        UnitType.removeAllItems();

        while (rs.next()) {
            UnitType.addItem(rs.getString("UnitType"));
        }

    } catch (SQLException ex) {
        Logger.getLogger(UnitCategories.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error occurred while populating Unit Types.");
    }
}
    
    private void populateUnitIDComboBox() {
    try {
        Statement st = connect.createStatement();
        String query = "SELECT ApateuID FROM apartmentunit"; 
        ResultSet rs = st.executeQuery(query);

        jAUnitID.removeAllItems();

        while (rs.next()) {
            jAUnitID.addItem(rs.getString("ApateuID"));
        }
    } catch (SQLException ex) {
        Logger.getLogger(UnitCategories.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error occurred while populating Unit IDs.");
    }
}

    public boolean isUnitAvailable(String unitNo) throws SQLException {
        PreparedStatement pst = connect.prepareStatement(
            "SELECT COUNT(*) AS tenantCount FROM tenant WHERE UnitNo = ?");
        pst.setString(1, unitNo);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            int tenantCount = rs.getInt("tenantCount");
            JOptionPane.showMessageDialog(null, "Tenant Count for unit " + unitNo + ": " + tenantCount);

            PreparedStatement statusStmt = connect.prepareStatement(
                "SELECT UnitStatus FROM apartmentunit WHERE UnitNo = ?");
            statusStmt.setString(1, unitNo);
            ResultSet rsStatus = statusStmt.executeQuery();

            if (rsStatus.next()) {
                String unitStatus = rsStatus.getString("UnitStatus");
                JOptionPane.showMessageDialog(null, "Unit Status: " + unitStatus);

                if (unitStatus.equals("Occupied") || tenantCount > 0) {
                    return false;
                }
            }
        }
        return true; 
    }

public void updateUnitStatus(String unitNo) throws SQLException {
    String countQuery = "SELECT COUNT(*) AS tenantCount FROM tenant WHERE UnitNo = ?";
    try (PreparedStatement pst = connect.prepareStatement(countQuery)) {
        pst.setString(1, unitNo);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            int tenantCount = rs.getInt("tenantCount");
            JOptionPane.showMessageDialog(null, "Tenant Count for unit " + unitNo + ": " + tenantCount);

            String statusQuery = "SELECT UnitStatus FROM apartmentunit WHERE UnitNo = ?";
            try (PreparedStatement statusStmt = connect.prepareStatement(statusQuery)) {
                statusStmt.setString(1, unitNo);
                ResultSet rsStatus = statusStmt.executeQuery();

                if (rsStatus.next()) {
                    String unitStatus = rsStatus.getString("UnitStatus");
                    JOptionPane.showMessageDialog(null, "Unit Status before update: " + unitStatus);

                    if (tenantCount > 0 && unitStatus != null && unitStatus.equals("Available")) {
                        String updateStatusQuery = "UPDATE apartmentunit SET UnitStatus = 'Occupied' WHERE UnitNo = ?";
                        try (PreparedStatement updateStmt = connect.prepareStatement(updateStatusQuery)) {
                            updateStmt.setString(1, unitNo);
                            int rowsUpdated = updateStmt.executeUpdate();
                            if (rowsUpdated > 0) {
                                JOptionPane.showMessageDialog(null, "Unit status updated to Occupied.");
                            } else {
                                JOptionPane.showMessageDialog(null, "Error updating unit status.");
                            }
                        }
                        reloadUnitData();
                        UnitTable.repaint(); 
                    }

                    else if (tenantCount == 0 && unitStatus != null && unitStatus.equals("Occupied")) {
                        String updateStatusQuery = "UPDATE apartmentunit SET UnitStatus = 'Available' WHERE UnitNo = ?";
                        try (PreparedStatement updateStmt = connect.prepareStatement(updateStatusQuery)) {
                            updateStmt.setString(1, unitNo);
                            int rowsUpdated = updateStmt.executeUpdate();
                            if (rowsUpdated > 0) {
                                JOptionPane.showMessageDialog(null, "Unit status updated to Available.");
                            } else {
                                JOptionPane.showMessageDialog(null, "Error updating unit status.");
                            }
                        }

                        reloadUnitData();
                        UnitTable.repaint();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Unit not found in apartmentunit table.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No tenants found for the unit.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "An error occurred while updating unit status: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        System.out.println("SQL Error: " + e.getMessage());
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jAUnitID = new javax.swing.JComboBox<>();
        UnitSearch = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Description = new javax.swing.JTextArea();
        jbtnAdd = new javax.swing.JButton();
        jbtnUpdate = new javax.swing.JButton();
        jbtnDelete = new javax.swing.JButton();
        UnitType = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        UnitNo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        MonthlyRate = new javax.swing.JTextField();
        Select = new javax.swing.JButton();
        Refresh = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        UnitTable = new javax.swing.JTable();

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel12.setText("UNIT ID");

        jAUnitID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jAUnitID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAUnitIDActionPerformed(evt);
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

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setText("DESCRIPTION");

        Description.setColumns(20);
        Description.setRows(5);
        Description.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane3.setViewportView(Description);

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

        UnitType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel13.setText("UNIT NO");

        UnitNo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        UnitNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UnitNoActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel15.setText("MONTHLY RATE");

        MonthlyRate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        MonthlyRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthlyRateActionPerformed(evt);
            }
        });

        Select.setBackground(new java.awt.Color(204, 204, 255));
        Select.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        Select.setText("Select");
        Select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectActionPerformed(evt);
            }
        });

        Refresh.setBackground(new java.awt.Color(204, 204, 255));
        Refresh.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        Refresh.setText("Refresh");
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel12)
                .addGap(26, 26, 26)
                .addComponent(jAUnitID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(42, 42, 42)
                .addComponent(UnitSearch)
                .addGap(305, 305, 305))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(UnitType, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Select))
                    .addComponent(jScrollPane3))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Refresh)
                        .addGap(160, 160, 160))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel15))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(jLabel13)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(UnitNo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(MonthlyRate, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jAUnitID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UnitSearch))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(UnitType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Select)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UnitNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MonthlyRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnUpdate)
                            .addComponent(jbtnDelete)
                            .addComponent(Refresh))))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 950, 230));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/unitlogo.png"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 30));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel8.setText("APARTMENT UNIT");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 240, -1));

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UnitTable.setBackground(new java.awt.Color(204, 204, 204));
        UnitTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "UnitID", "Aprtment Unit No", "Unit Type", "Description", "Monthly Rate", "Unit Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(UnitTable);

        jPanel4.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 870, 330));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 950, 340));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAUnitIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAUnitIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jAUnitIDActionPerformed

    private void UnitSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UnitSearchActionPerformed
        try {
        String unitid = jAUnitID.getSelectedItem().toString();

        if (unitid.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a valid Unit ID", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PreparedStatement pst = connect.prepareStatement("SELECT * FROM apartmentunit WHERE ApateuID = ?");
        pst.setString(1, unitid);

        ResultSet rs = pst.executeQuery();
        
    
        if (rs.next()) {
            UnitNo.setText(rs.getString("UnitNo"));
            MonthlyRate.setText(rs.getString("MRate"));
            
            String unitType = rs.getString("UnitType"); 
            String description = rs.getString("Description");

            UnitType.setSelectedItem(unitType); 
            Description.setText(description);
        } else {
            JOptionPane.showMessageDialog(this, "No record found for the selected unit ID", "Error", JOptionPane.ERROR_MESSAGE);
            
            UnitNo.setText("");
            MonthlyRate.setText("");
            UnitType.setSelectedIndex(0);
            Description.setText("");
        }

    } catch (SQLException ex) {
        Logger.getLogger(UnitCategories.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_UnitSearchActionPerformed

    private void jbtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddActionPerformed
        try {
        String unitno = UnitNo.getText();
        String mrate = MonthlyRate.getText();
        String unitType = UnitType.getSelectedItem().toString(); 

        if (unitno.isEmpty() || mrate.isEmpty() || unitType.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all the required fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            PreparedStatement pst = connect.prepareStatement("SELECT UnitID, Description FROM unitcategories WHERE UnitType = ?");
            pst.setString(1, unitType); 
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String unitID = rs.getString("UnitID"); 
                String description = rs.getString("Description"); 

                PreparedStatement insertStmt = connect.prepareStatement(
                    "INSERT INTO apartmentunit (`UnitNo`, `MRate`, `UnitID`, `UnitType`, `Description`, `UnitStatus`) VALUES (?, ?, ?, ?, ?, ?)");

                insertStmt.setString(1, unitno);            
                insertStmt.setString(2, mrate);       
                insertStmt.setString(3, unitID); 
                insertStmt.setString(4, unitType);
                insertStmt.setString(5, description);
                insertStmt.setString(6, "Available");

                int k = insertStmt.executeUpdate();

                UnitNo.setText("");
                MonthlyRate.setText("");
                UnitType.setSelectedIndex(0); 

                JOptionPane.showMessageDialog(this, "Added Successfully");

                reloadUnitData();
            } else {
                JOptionPane.showMessageDialog(this, "Selected unit type does not exist in the database.");
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(UnitCategories.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage());
    }

    }//GEN-LAST:event_jbtnAddActionPerformed

    private void jbtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUpdateActionPerformed

        try {
            String unitno = UnitNo.getText();
            String mrate = MonthlyRate.getText();
            String unittypeid =  jAUnitID.getSelectedItem().toString();

            if (unitno.isEmpty() || mrate.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all the required fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            PreparedStatement pst = connect.prepareStatement("UPDATE apartmentunit SET UnitNo = ?, MRate = ? WHERE ApateuID = ?");

            pst.setString(1, unitno);  
            pst.setString(2, mrate);    
            pst.setString(3, unittypeid); 

            int k = pst.executeUpdate();

            if (k == 1){
                JOptionPane.showMessageDialog(this,"Record has been successfully updated");
                UnitNo.setText("");
                MonthlyRate.setText("");
                UnitNo.requestFocus();
                reloadUnitData();

            }

            jAUnitID.setSelectedItem(0);

        }catch (SQLException ex) {
            Logger.getLogger(UnitCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnUpdateActionPerformed

    private void jbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteActionPerformed
        try {

            String unitid =  jAUnitID.getSelectedItem().toString();
            
            int confirmation = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to delete this record?", 
            "Confirm Deletion", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.WARNING_MESSAGE);
        
        if (confirmation == JOptionPane.YES_OPTION) {

            PreparedStatement pst = connect.prepareStatement("DELETE FROM apartmentunit WHERE ApateuID = ?");
            pst.setString(1, unitid);

            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Record has been successfully deleted");
                UnitNo.setText("");
                MonthlyRate.setText("");
                UnitNo.requestFocus(); 
                reloadUnitData(); 
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete the record");
            }

            jAUnitID.setSelectedItem(0);
        } else {
            JOptionPane.showMessageDialog(this, "Deletion canceled");
        }

        } catch (SQLException ex) {
            Logger.getLogger(UnitCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnDeleteActionPerformed

    private void UnitNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UnitNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UnitNoActionPerformed

    private void MonthlyRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonthlyRateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MonthlyRateActionPerformed

    private void SelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectActionPerformed
        // TODO add your handling code here:
        Description.setText("");
        
        try {        
        String unittype = UnitType.getSelectedItem().toString();
        PreparedStatement pst = connect.prepareStatement("SELECT * FROM unitcategories WHERE UnitType = ?");
        pst.setString(1, unittype); 
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            String unitID = rs.getString("UnitID");  
            String description = rs.getString("Description");

            Description.setText(description); 
        } else {
            JOptionPane.showMessageDialog(this, "No record found for the selected unit.");
            Description.setText("");  
        }
        
        
        
    } catch (SQLException ex) {
        Logger.getLogger(UnitCategories.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error occurred while retrieving the unit details.");
    }
    }//GEN-LAST:event_SelectActionPerformed

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        // TODO add your handling code here:
        UnitNo.setText("");                    
        MonthlyRate.setText("");      
        Description.setText("");      
        UnitType.setSelectedIndex(0); 
        jAUnitID.setSelectedIndex(0); 

        populateUnitTypeComboBox();   
        reloadUnitData();
    }//GEN-LAST:event_RefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Description;
    private javax.swing.JTextField MonthlyRate;
    private javax.swing.JButton Refresh;
    private javax.swing.JButton Select;
    private javax.swing.JTextField UnitNo;
    private javax.swing.JButton UnitSearch;
    private javax.swing.JTable UnitTable;
    private javax.swing.JComboBox<String> UnitType;
    private javax.swing.JComboBox<String> jAUnitID;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton jbtnAdd;
    private javax.swing.JButton jbtnDelete;
    private javax.swing.JButton jbtnUpdate;
    // End of variables declaration//GEN-END:variables
}
