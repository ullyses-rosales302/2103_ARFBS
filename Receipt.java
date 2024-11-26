
package UI;

import MyConnection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Receipt extends javax.swing.JFrame {

    private Connection connect;
    public Receipt() {
        initComponents();
        
        MyConnection conn = new MyConnection();
        connect = conn.getConnection();
        
        LoadPaymentNo();
        populatePaymentIDComboBox();
    }

    public void LoadPaymentNo(){
        
        try {
            
           PreparedStatement pst = connect.prepareStatement("SELECT PaymentID FROM payment");
            ResultSet rs = pst.executeQuery();
            jtxtBillingID.removeAllItems();
            while(rs.next()){
                jtxtBillingID.addItem(rs.getString(1));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Receipt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void print() {
    	    String billingid =  jtxtBillingID.getSelectedItem().toString();
            //String payid =  jtxtPid.getText();
            String lname = jtxtln.getText();
	    String fname = jtxtfn.getText();
	    String unit = jtxtbillingid.getText();
	    //String rate = jtxtmrate.getText();
	    String rep = jtxtreceipt.getText();
	    String tbill = jtxtbill.getText();
            String amount = jtxtpaid.getText();
            String sukli = jtxtchange.getText();
            String pdate = jtxtPaymentDate.getText();
            Date dt = new Date();
            String date = dt.toString();
            
            
        if (billingid.isEmpty() || lname.isEmpty() || fname.isEmpty() || unit.isEmpty() || 
             rep.isEmpty() || tbill.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields must be filled out!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    jTextArea1.append("\n");
    jTextArea1.append("======================================"); 
    jTextArea1.append("\n");
    jTextArea1.append("\t    Utilities Billing\n");
    jTextArea1.append("======================================"); 
    jTextArea1.append("\n");
    jTextArea1.append("\n" + date + "\n \n");
    jTextArea1.append("\n");
    //jTextArea1.append("Payment ID: " + payid + "\n");
   // jTextArea1.append("\n");
    jTextArea1.append("Tenant Name: " + fname + " " + lname + "\n");
    jTextArea1.append("\n");
    //jTextArea1.append("Unit ID: " + unit + "\n");
    //jTextArea1.append("\n");
    //jTextArea1.append("Monthly Rate: " + rate + "\n");
    //jTextArea1.append("\n");
    jTextArea1.append("Receipt No.: " + rep + "\n");
    jTextArea1.append("\n");
    jTextArea1.append("Total bill Amount: " + tbill + "\n");
    jTextArea1.append("\n");
    jTextArea1.append("Total Amount Paid: " + amount + "\n");
    jTextArea1.append("\n");
    jTextArea1.append("Payment Change: " + sukli + "\n");
    jTextArea1.append("\n");
    jTextArea1.append("Payment Date: " + pdate + "\n");
    jTextArea1.append("\n");
    jTextArea1.append("\n");
    jTextArea1.append("   THANK YOU!!!\n");
}
    
    private void populatePaymentIDComboBox() {
    try {
        // SQL query to get PaymentID values from the payment table
        String query = "SELECT PaymentID FROM payment";

        // Prepare the statement to execute the query
        PreparedStatement pst = connect.prepareStatement(query);
        ResultSet rs = pst.executeQuery();

        // Clear any existing items in the ComboBox
        jtxtBillingID.removeAllItems();

        // Add the PaymentID values to the ComboBox
        while (rs.next()) {
            String paymentID = rs.getString("PaymentID");
            jtxtBillingID.addItem(paymentID); // Add each PaymentID to ComboBox
        }

        // Close resources
        rs.close();
        pst.close();
    } catch (SQLException ex) {
        Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error loading PaymentID values.", "Database Error", JOptionPane.ERROR_MESSAGE);
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jGenrep = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtxtreceipt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtxtln = new javax.swing.JTextField();
        jtxtbill = new javax.swing.JTextField();
        jtxtfn = new javax.swing.JTextField();
        jtxtbillingid = new javax.swing.JTextField();
        jtxtBillingID = new javax.swing.JComboBox<>();
        jbtnsearch = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jtxtpaid = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jtxtPaymentDate = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtxtchange = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBackground(new java.awt.Color(204, 204, 255));
        jDesktopPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        jLabel1.setText("P A Y M E N T  R E C E I P T");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(165, 165, 165))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setMinimumSize(new java.awt.Dimension(13, 30));
        jScrollPane1.setViewportView(jTextArea1);

        jGenrep.setBackground(new java.awt.Color(204, 204, 255));
        jGenrep.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jGenrep.setText("Generate Receipt");
        jGenrep.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jGenrep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGenrepActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 3, 24)); // NOI18N
        jLabel2.setText("Receipt No.");

        jtxtreceipt.setBackground(new java.awt.Color(204, 204, 255));
        jtxtreceipt.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel3.setText("Payment ID ");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setText("Tenant Name ");

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel8.setText("Total Bill ");

        jtxtln.setBackground(new java.awt.Color(204, 204, 255));
        jtxtln.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jtxtbill.setBackground(new java.awt.Color(204, 204, 255));
        jtxtbill.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jtxtfn.setBackground(new java.awt.Color(204, 204, 255));
        jtxtfn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jtxtbillingid.setBackground(new java.awt.Color(204, 204, 255));
        jtxtbillingid.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jtxtBillingID.setBackground(new java.awt.Color(204, 204, 204));
        jtxtBillingID.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jtxtBillingID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jbtnsearch.setBackground(new java.awt.Color(204, 204, 255));
        jbtnsearch.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jbtnsearch.setText("Search");
        jbtnsearch.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnsearchActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel9.setText("Amount Paid");

        jtxtpaid.setBackground(new java.awt.Color(204, 204, 255));
        jtxtpaid.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jtxtpaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtpaidActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel10.setText("Billing ID");

        btnBack.setBackground(new java.awt.Color(102, 102, 102));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 51), new java.awt.Color(255, 255, 204)));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel11.setText("Payment Date");

        jtxtPaymentDate.setBackground(new java.awt.Color(204, 204, 255));
        jtxtPaymentDate.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel12.setText("Payment Change");

        jtxtchange.setBackground(new java.awt.Color(204, 204, 255));
        jtxtchange.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jtxtchange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtchangeActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jGenrep, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtxtreceipt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtxtln, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtxtbill, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtxtfn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtxtbillingid, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtxtBillingID, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbtnsearch, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtxtpaid, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnBack, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtxtPaymentDate, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtxtchange, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtxtBillingID, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                                .addComponent(jbtnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtxtreceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(37, 37, 37))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtbill)
                            .addComponent(jtxtpaid)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jtxtbillingid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                                        .addComponent(jtxtln, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addComponent(jtxtfn)
                                        .addGap(12, 12, 12))
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtxtPaymentDate, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                                            .addComponent(jLabel11)))))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addGap(0, 394, Short.MAX_VALUE))
                            .addComponent(jtxtchange))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jGenrep, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119))))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jGenrep, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtxtBillingID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtxtreceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtxtln, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtxtfn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtbillingid, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtPaymentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jtxtbill, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jtxtpaid, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jtxtchange, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jGenrepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGenrepActionPerformed

        print();
    }//GEN-LAST:event_jGenrepActionPerformed

    private void jbtnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnsearchActionPerformed
         try {
        // Retrieve the selected PaymentID from the ComboBox
        String PaymentID = jtxtBillingID.getSelectedItem().toString();
        //System.out.println("Selected PaymentID: " + PaymentID);  // Debugging log

        // Check if PaymentID is empty
        if (PaymentID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a valid PaymentID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // SQL query to retrieve data from the Payment table (now including LastName and FirstName)
        String query = "SELECT PaymentID, BillingID, LastName, FirstName, TotalRentBill, ReceiptNo, AmountPaid, Sukli, PaymentDate " +
                       "FROM payment " +
                       "WHERE PaymentID = ?"; // Search by PaymentID in the payment table

        // Prepare the statement to execute the query
        PreparedStatement pst = connect.prepareStatement(query);

        // Set the PaymentID parameter to the prepared statement
        pst.setString(1, PaymentID);  // Use this if PaymentID is a string in the DB

        // Execute the query
        ResultSet rs = pst.executeQuery();

        // If a result is found, set the data to the corresponding fields
        if (rs.next()) {
            // Set the data retrieved from the Payment table
            jtxtbillingid.setText(rs.getString("BillingID"));  // Set BillingID
            jtxtreceipt.setText(rs.getString("ReceiptNo"));    // Set ReceiptNo
            jtxtpaid.setText(rs.getString("AmountPaid"));      // Set AmountPaid
            jtxtchange.setText(rs.getString("Sukli"));      // 
            jtxtPaymentDate.setText(rs.getString("PaymentDate"));  // Set PaymentDate
            //jtxtmrate.setText(rs.getString("MonthlyRate")); 
            // Set the tenant information from the Payment table
            jtxtbill.setText(rs.getString("TotalRentBill")); 
            jtxtln.setText(rs.getString("LastName"));   // Set LastName
            jtxtfn.setText(rs.getString("FirstName"));  // Set FirstName
        } else {
            // If no record is found for the selected PaymentID
            JOptionPane.showMessageDialog(this, "No record found for the entered PaymentID.", "Not Found", JOptionPane.INFORMATION_MESSAGE);
        }

        // Close the result set and prepared statement to release resources
        rs.close();
        pst.close();
    } catch (SQLException ex) {
        // Log the exception and show an error message
        Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error accessing the database: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jbtnsearchActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void jtxtpaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtpaidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtpaidActionPerformed

    private void jtxtchangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtchangeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtchangeActionPerformed

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
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Receipt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JButton jGenrep;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jbtnsearch;
    private javax.swing.JComboBox<String> jtxtBillingID;
    private javax.swing.JTextField jtxtPaymentDate;
    private javax.swing.JTextField jtxtbill;
    private javax.swing.JTextField jtxtbillingid;
    private javax.swing.JTextField jtxtchange;
    private javax.swing.JTextField jtxtfn;
    private javax.swing.JTextField jtxtln;
    private javax.swing.JTextField jtxtpaid;
    private javax.swing.JTextField jtxtreceipt;
    // End of variables declaration//GEN-END:variables
}
