
package UI;

import MyConnection.MyConnection;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;


public class Payment extends javax.swing.JInternalFrame {

    private Connection connect;
    public Payment() {
        initComponents();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
        MyConnection conn = new MyConnection();
        connect = conn.getConnection();
        
        LoadTenantNo();
        PaymentTable();
    }
    
    public void LoadTenantNo(){
        
        try {
            
           PreparedStatement pst = connect.prepareStatement("SELECT BillingID FROM billing");
            ResultSet rs = pst.executeQuery();
            BillID.removeAllItems();
            while(rs.next()){
                BillID.addItem(rs.getString(1));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void PaymentTable() {
    try {
        PreparedStatement pst = connect.prepareStatement("SELECT * FROM payment");
        ResultSet rs = pst.executeQuery();
        ResultSetMetaData rss = rs.getMetaData();
        int q = rss.getColumnCount();

        DefaultTableModel df = (DefaultTableModel) pTable.getModel();
        df.setRowCount(0);

        while (rs.next()) {
            Vector v2 = new Vector();
            v2.add(rs.getString("PaymentID"));
            v2.add(rs.getString("BillingID"));
            v2.add(rs.getString("LastName"));
            v2.add(rs.getString("FirstName"));
            v2.add(rs.getString("DateRegistered"));
            v2.add(rs.getString("TotalRentBill"));
            v2.add(rs.getString("AmountPaid"));
            v2.add(rs.getString("Sukli"));
            v2.add(rs.getString("PaymentDate"));
            v2.add(rs.getString("ReceiptNo"));
            

            df.addRow(v2);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pTable = new javax.swing.JTable();
        DateRegistered = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TotalRent = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Search = new javax.swing.JButton();
        BillID = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        LastName = new javax.swing.JTextField();
        FirstName = new javax.swing.JTextField();
        Receiptbtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Amount = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        PaymentDate = new com.toedter.calendar.JDateChooser();
        change = new javax.swing.JLabel();
        jtxtchange = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setText("PAYMENT");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 2, 400, 40));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        pTable.setBackground(new java.awt.Color(204, 204, 255));
        pTable.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), null));
        pTable.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        pTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PaymentID", "BillingID", "LastName", "FirstName", "DateRegistered", "TotalBill", "AmountPaid", "Change", "PaymentDate", "Receipt No"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(pTable);

        DateRegistered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateRegisteredActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setText("Date Registered");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel5.setText("Total Rent Bill");

        TotalRent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalRentActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setText("Billing ID");

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel10.setText("Payment Date");

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

        BillID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        BillID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BillIDActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(204, 204, 255));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setText("Tenant Name");

        LastName.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        LastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastNameActionPerformed(evt);
            }
        });

        FirstName.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        FirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstNameActionPerformed(evt);
            }
        });

        Receiptbtn.setBackground(new java.awt.Color(204, 204, 255));
        Receiptbtn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Receiptbtn.setText("Show Receipt");
        Receiptbtn.setBorder(null);
        Receiptbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReceiptbtnActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 255));
        jLabel7.setText("Time for Payment!");

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel8.setText("Amount Paid");

        Amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmountActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(204, 204, 255));
        btnSave.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        change.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        change.setText("Change");

        jtxtchange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtchangeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(change, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Receiptbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(BillID, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(LastName, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(DateRegistered, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TotalRent, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Amount, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(PaymentDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jtxtchange, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addContainerGap()))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(BillID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(Search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DateRegistered, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TotalRent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(change)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtchange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(8, 8, 8)
                        .addComponent(PaymentDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Receiptbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 940, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DateRegisteredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateRegisteredActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateRegisteredActionPerformed

    private void TotalRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalRentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalRentActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        try {
            String billid = BillID.getSelectedItem().toString().trim();

            if (billid.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please select a Billing ID from the dropdown.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            PreparedStatement pst = connect.prepareStatement("SELECT * FROM billing WHERE billingID = ?");
            pst.setString(1, billid);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String foundLastName = rs.getString("LastName");
                String foundFirstName = rs.getString("FirstName");
                double totalBill = rs.getDouble("TotalBill");
                String registerDate = rs.getString("DateRegistered");

                LastName.setText(foundLastName);
                FirstName.setText(foundFirstName);
                TotalRent.setText(String.valueOf(totalBill));
                DateRegistered.setText(registerDate);
                
            }
          
            else {
                JOptionPane.showMessageDialog(this, "No record found for the selected Tenant ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SearchActionPerformed

    private void BillIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BillIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BillIDActionPerformed

    private void LastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LastNameActionPerformed

    private void FirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FirstNameActionPerformed

    private void ReceiptbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReceiptbtnActionPerformed
        Receipt pay = new Receipt();
        pay.setVisible(true);
        pay.pack();
        pay.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_ReceiptbtnActionPerformed

    private void AmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AmountActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
    try {
    String billid = BillID.getSelectedItem().toString().trim();
    String dateRegistered = DateRegistered.getText().trim();
    String totalRent = TotalRent.getText().trim();
    String amountPaidString = Amount.getText().trim();

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String date = (PaymentDate.getDate() != null) ? sdf.format(PaymentDate.getDate()) : null;

    if (date == null) {
        JOptionPane.showMessageDialog(this, "Please select a payment date.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (billid.isEmpty() || dateRegistered.isEmpty() || totalRent.isEmpty() || amountPaidString.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all the required fields.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    double totalBill = Double.parseDouble(totalRent);
    double amountPaid = Double.parseDouble(amountPaidString);
    double change = 0;

    if (amountPaid < totalBill) {
        JOptionPane.showMessageDialog(this, "The Amount Paid is less than the Total Bill. Please enter a new Amount Paid.", "Warning", JOptionPane.WARNING_MESSAGE);
        Amount.requestFocus();
        return;
    }

    if (amountPaid > totalBill) {
        change = amountPaid - totalBill;
        jtxtchange.setText(String.format("%.2f", change)); 
    } else {
        jtxtchange.setText("0.00");
    }

    // Step 1: Retrieve tenant's first and last name based on BillingID
    String tenantFirstName = "";
    String tenantLastName = "";
    String tenantQuery = "SELECT b.TenantID, t.LastName, t.FirstName " +
                         "FROM billing b " +
                         "JOIN tenant t ON b.TenantID = t.TenantID " +
                         "WHERE b.BillingID = ?";

    PreparedStatement pstTenant = connect.prepareStatement(tenantQuery);
    pstTenant.setString(1, billid);
    ResultSet rsTenant = pstTenant.executeQuery();

    if (rsTenant.next()) {
        tenantFirstName = rsTenant.getString("FirstName");
        tenantLastName = rsTenant.getString("LastName");
    } else {
        JOptionPane.showMessageDialog(this, "No tenant found for the selected BillingID.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

   
    String receiptNo = "R-001"; 
    String latestReceiptNoQuery = "SELECT ReceiptNo FROM payment ORDER BY PaymentID DESC LIMIT 1";
    PreparedStatement pstReceipt = connect.prepareStatement(latestReceiptNoQuery);
    ResultSet rsReceipt = pstReceipt.executeQuery();

    if (rsReceipt.next()) {
        String latestReceiptNo = rsReceipt.getString("ReceiptNo");
        int latestNo = Integer.parseInt(latestReceiptNo.substring(2)); 
        receiptNo = String.format("R-%03d", latestNo + 1); 
    }
    rsReceipt.close();
    pstReceipt.close();

    // Step 3: Insert payment details along with tenant's first and last name
    String sql = "INSERT INTO payment (BillingID, LastName, FirstName, DateRegistered, TotalRentBill, AmountPaid, Sukli, PaymentDate, ReceiptNo) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    PreparedStatement pstPayment = connect.prepareStatement(sql);
    pstPayment.setString(1, billid);
    pstPayment.setString(2, tenantLastName);
    pstPayment.setString(3, tenantFirstName);
    pstPayment.setString(4, dateRegistered);
    pstPayment.setDouble(5, totalBill);
    pstPayment.setDouble(6, amountPaid);
    pstPayment.setDouble(7, change);
    pstPayment.setString(8, date);
    pstPayment.setString(9, receiptNo);

    int k = pstPayment.executeUpdate();

    if (k == 1) {
        JOptionPane.showMessageDialog(this, "Payment has been done and saved successfully!");

        // Clear the fields
        BillID.setSelectedIndex(0);
        DateRegistered.setText("");
        TotalRent.setText("");
      
        Amount.setText("");
        jtxtchange.setText("");
        PaymentDate.setDate(null);

        PaymentTable(); // Assuming this updates the table view
    } else {
        JOptionPane.showMessageDialog(this, "Save failed.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Close resources
    rsTenant.close();
    pstTenant.close();
    pstPayment.close();

} catch (NumberFormatException ex) {
    JOptionPane.showMessageDialog(this, "Invalid numeric value: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
} catch (SQLException ex) {
    JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
 
       
    }//GEN-LAST:event_btnSaveActionPerformed

    private void jtxtchangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtchangeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtchangeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Amount;
    private javax.swing.JComboBox<String> BillID;
    private javax.swing.JTextField DateRegistered;
    private javax.swing.JTextField FirstName;
    private javax.swing.JTextField LastName;
    private com.toedter.calendar.JDateChooser PaymentDate;
    private javax.swing.JButton Receiptbtn;
    private javax.swing.JButton Search;
    private javax.swing.JTextField TotalRent;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel change;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jtxtchange;
    private javax.swing.JTable pTable;
    // End of variables declaration//GEN-END:variables
}
