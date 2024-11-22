
package UI;

import MyConnection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class Tenant extends javax.swing.JInternalFrame {

   private Connection connect;
    public Tenant() {
        initComponents();
        initComponents();

        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
        MyConnection conn = new MyConnection();
        connect = conn.getConnection();
        
        reloadTenantData();
        populateTenantComboBox();
    }
    boolean searchPerformed = false; 

    private void populateTenantComboBox() {
    try {
        PreparedStatement pst = connect.prepareStatement("SELECT TenantID FROM tenant");
        ResultSet rs = pst.executeQuery();
        
        TenantID.removeAllItems(); // Remove existing items to avoid duplication
        
        while (rs.next()) {
            String tenantID = rs.getString("TenantID");  // Assuming TenantID is a column in your table
            TenantID.addItem(tenantID);  // Add tenant ID to ComboBox
        }
        
        
    } catch (SQLException ex) {
        Logger.getLogger(Tenant.class.getName()).log(Level.SEVERE, null, ex);
    }
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TenantTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        LastName = new javax.swing.JTextField();
        FirstName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ContactNo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        UnitType = new javax.swing.JComboBox<>();
        UnitNo = new javax.swing.JComboBox<>();
        AddTenant = new javax.swing.JButton();
        UpdateTenant = new javax.swing.JButton();
        DeleteTenant = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Search = new javax.swing.JButton();
        TenantID = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setText("List of Tenant");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 280, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        TenantTable.setBackground(new java.awt.Color(204, 204, 255));
        TenantTable.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), null));
        TenantTable.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        TenantTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TenantID", "Last Name", "First Name", "ContactInfo", "Email", "Unit ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TenantTable);

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setText("Last Name");

        LastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastNameActionPerformed(evt);
            }
        });

        FirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstNameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setText("First Name");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel5.setText("Contact Info");

        ContactNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContactNoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel6.setText("Email");

        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel7.setText("Unit Type");

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel8.setText("Unit No.");

        UnitType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        UnitType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UnitTypeActionPerformed(evt);
            }
        });

        UnitNo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        UnitNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UnitNoActionPerformed(evt);
            }
        });

        AddTenant.setBackground(new java.awt.Color(102, 102, 102));
        AddTenant.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddTenant.setForeground(new java.awt.Color(204, 204, 204));
        AddTenant.setText("Add");
        AddTenant.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 51), new java.awt.Color(255, 255, 204)));
        AddTenant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTenantActionPerformed(evt);
            }
        });

        UpdateTenant.setBackground(new java.awt.Color(102, 102, 102));
        UpdateTenant.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        UpdateTenant.setForeground(new java.awt.Color(204, 204, 204));
        UpdateTenant.setText("Update");
        UpdateTenant.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 51), new java.awt.Color(255, 255, 204)));
        UpdateTenant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateTenantActionPerformed(evt);
            }
        });

        DeleteTenant.setBackground(new java.awt.Color(102, 102, 102));
        DeleteTenant.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DeleteTenant.setForeground(new java.awt.Color(204, 204, 204));
        DeleteTenant.setText("Delete");
        DeleteTenant.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 51), new java.awt.Color(255, 255, 204)));
        DeleteTenant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteTenantActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setText("Tenant ID");

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel10.setText("Date Registered");

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel11.setText("New Tenant");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        Search.setBackground(new java.awt.Color(102, 102, 102));
        Search.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Search.setForeground(new java.awt.Color(204, 204, 204));
        Search.setText("Search");
        Search.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 51), new java.awt.Color(255, 255, 204)));
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        TenantID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        TenantID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TenantIDActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(204, 204, 255));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(UnitType, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(UnitNo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(AddTenant, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(UpdateTenant, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DeleteTenant, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11)
                                        .addComponent(TenantID, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel2)
                            .addComponent(LastName, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(ContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(TenantID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(Search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UnitType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UnitNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(66, 66, 66)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddTenant)
                            .addComponent(UpdateTenant)
                            .addComponent(DeleteTenant)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 940, 620));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/tenantslogo.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LastNameActionPerformed

    private void FirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FirstNameActionPerformed

    private void ContactNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContactNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContactNoActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    private void AddTenantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTenantActionPerformed
        String lastname = LastName.getText().trim();
        String firstname = FirstName.getText().trim();
        String contact = ContactNo.getText().trim();
        String email = Email.getText().trim();

        
    if (lastname.isEmpty() || firstname.isEmpty() || contact.isEmpty() || email.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please fill in all the required fields.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    String query = "INSERT INTO tenant (LastName, FirstName, ContactInfo, Email) VALUES (?, ?, ?, ?)";
    
    try (PreparedStatement pst = connect.prepareStatement(query)) {
        pst.setString(1, lastname);
        pst.setString(2, firstname);
        pst.setString(3, contact);
        pst.setString(4, email);

        pst.executeUpdate();

        LastName.setText("");
        FirstName.setText("");
        ContactNo.setText("");
        Email.setText("");            

        reloadTenantData();

        JOptionPane.showMessageDialog(null, "New tenant added successfully!");
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error while adding tenant: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        System.out.println("Database error: " + e.getMessage()); 
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Unexpected error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        System.out.println("Unexpected error: " + e.getMessage()); 
    }
}

private void reloadTenantData() {
    try {
        String selectQuery = "SELECT * FROM tenant";
        Statement st = connect.createStatement();
        ResultSet rs = st.executeQuery(selectQuery);

        DefaultTableModel model = (DefaultTableModel) TenantTable.getModel();
        model.setRowCount(0); 

        while (rs.next()) {
            Object[] row = new Object[]{
                rs.getInt("tenantId"),
                rs.getString("LastName"),
                rs.getString("FirstName"),
                rs.getString("ContactInfo"),
                rs.getString("Email")
            };
            model.addRow(row); 
        }
        
    } catch (SQLException e) {
        System.out.println("Error while reloading tenant data: " + e.getMessage());
    }
    }//GEN-LAST:event_AddTenantActionPerformed

    private void UpdateTenantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateTenantActionPerformed

    if (!searchPerformed) {
        JOptionPane.showMessageDialog(null, "Please perform a search first by selecting a Tenant ID.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    String tenantid = TenantID.getSelectedItem().toString();  

    if (tenantid == null || tenantid.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please select a valid Tenant ID", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String lastName = LastName.getText().trim();
    String firstName = FirstName.getText().trim();
    String contactNo = ContactNo.getText().trim();
    String email = Email.getText().trim();

    if (lastName.isEmpty() || firstName.isEmpty() || contactNo.isEmpty() || email.isEmpty()) {
        JOptionPane.showMessageDialog(null, "All fields must be filled", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String query = "UPDATE tenant SET LastName = ?, FirstName = ?, ContactInfo = ?, Email = ? WHERE TenantID = ?";

    try (PreparedStatement ps = connect.prepareStatement(query)) {
        // Parameters for the query
        ps.setString(1, lastName);
        ps.setString(2, firstName);
        ps.setString(3, contactNo);
        ps.setString(4, email);
        ps.setString(5, tenantid);  

        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Tenant updated successfully!");
            LastName.setText("");
            FirstName.setText("");
            ContactNo.setText("");
            Email.setText("");
            reloadTenantData(); 
        } else {
            JOptionPane.showMessageDialog(null, "No tenant found with the provided ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        TenantID.setSelectedItem(null); 

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "An error occurred while updating the tenant: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        System.out.println("SQL Error: " + e.getMessage());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        System.out.println("Unexpected Error: " + e.getMessage());
    }
    }//GEN-LAST:event_UpdateTenantActionPerformed

    private void DeleteTenantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteTenantActionPerformed
        
        
        if (!searchPerformed) {
                JOptionPane.showMessageDialog(null, "Please perform a search first by selecting a Tenant ID.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
         String tenantid = TenantID.getSelectedItem().toString(); 

    
    if (tenantid == null || tenantid.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please select a valid Tenant ID", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String query = "DELETE FROM tenant WHERE TenantID = ?";

    try (PreparedStatement ps = connect.prepareStatement(query)) {
        ps.setString(1, tenantid);  

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            
            TenantID.removeItem(tenantid);

            
            LastName.setText("");
            FirstName.setText("");
            ContactNo.setText("");
            Email.setText("");

            JOptionPane.showMessageDialog(null, "Tenant deleted successfully!");
            reloadTenantData();
            
        } else {
            JOptionPane.showMessageDialog(null, "No tenant found with the provided ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        TenantID.setSelectedItem(null); 

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "An error occurred while deleting the tenant: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        System.out.println("SQL Error: " + e.getMessage());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        System.out.println("Unexpected Error: " + e.getMessage());
    }

    }//GEN-LAST:event_DeleteTenantActionPerformed

    private void UnitNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UnitNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UnitNoActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed


        try {
            String tenantid =  TenantID.getSelectedItem().toString();
            if (tenantid == null || tenantid.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a valid Tenant ID");
            return;
        }
        searchPerformed = true;
        UpdateTenant.setEnabled(true);

            PreparedStatement pst = connect.prepareStatement("SELECT * FROM tenant WHERE TenantID = ?");
            pst.setString(1, tenantid);
            ResultSet rs = pst.executeQuery();

            if (rs.next() == true){
                LastName.setText(rs.getString(2));
                FirstName.setText(rs.getString(3));
                ContactNo.setText(rs.getString(4));
                Email.setText(rs.getString(5));
            }else{
                JOptionPane.showMessageDialog(this,"No record found");

            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Tenant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SearchActionPerformed

    private void TenantIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TenantIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TenantIDActionPerformed

    private void UnitTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UnitTypeActionPerformed
        // TODO add your handling code here:
        

    }//GEN-LAST:event_UnitTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddTenant;
    private javax.swing.JTextField ContactNo;
    private javax.swing.JButton DeleteTenant;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField FirstName;
    private javax.swing.JTextField LastName;
    private javax.swing.JButton Search;
    private javax.swing.JComboBox<String> TenantID;
    private javax.swing.JTable TenantTable;
    private javax.swing.JComboBox<String> UnitNo;
    private javax.swing.JComboBox<String> UnitType;
    private javax.swing.JButton UpdateTenant;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
