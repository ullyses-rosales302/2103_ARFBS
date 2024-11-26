
package UI;
import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;

public class Home extends javax.swing.JFrame {

    Color DefaultColor, ClickedColor;
    public Home() {
        initComponents();
        DefaultColor = new Color(242,242,242);
        ClickedColor = new Color(204,204,255);
        
        Menu1.setBackground(DefaultColor);
        Menu2.setBackground(DefaultColor);
        Menu3.setBackground(DefaultColor);
        Menu4.setBackground(DefaultColor);
        Menu5.setBackground(DefaultColor);
        Menu5.setBackground(DefaultColor);
        Menu6.setBackground(DefaultColor);
        Menu7.setBackground(DefaultColor);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Xbtn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Logout = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Menu1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Menu2 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Menu3 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Menu4 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Menu5 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Menu6 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        Menu7 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        Desktop = new javax.swing.JDesktopPane();
        welcomeback = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HOME");

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        Xbtn.setBackground(new java.awt.Color(255, 255, 255));
        Xbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/x_button.png"))); // NOI18N
        Xbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XbtnMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("APARTMENT RENTAL");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logo.png"))); // NOI18N

        Logout.setBackground(new java.awt.Color(204, 204, 255));
        Logout.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        Logout.setText("LOGOUT");
        Logout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102), new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255)));
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 771, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Xbtn, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Logout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Xbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Logout, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3)))
                .addGap(9, 9, 9))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 80));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        Menu1.setBackground(new java.awt.Color(204, 204, 204));
        Menu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Menu1MousePressed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel2.setText("DASHBOARD");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 116, 27));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/option.png"))); // NOI18N
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        javax.swing.GroupLayout Menu1Layout = new javax.swing.GroupLayout(Menu1);
        Menu1.setLayout(Menu1Layout);
        Menu1Layout.setHorizontalGroup(
            Menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Menu1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Menu1Layout.setVerticalGroup(
            Menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Menu1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Menu2.setBackground(new java.awt.Color(204, 204, 204));
        Menu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Menu2MousePressed(evt);
            }
        });

        jPanel21.setBackground(new java.awt.Color(204, 204, 255));

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel10.setText("TENANTS");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/tenantslogo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Menu2Layout = new javax.swing.GroupLayout(Menu2);
        Menu2.setLayout(Menu2Layout);
        Menu2Layout.setHorizontalGroup(
            Menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Menu2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Menu2Layout.setVerticalGroup(
            Menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Menu2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Menu3.setBackground(new java.awt.Color(204, 204, 204));
        Menu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Menu3MousePressed(evt);
            }
        });

        jPanel23.setBackground(new java.awt.Color(204, 204, 255));

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel11.setText("UNIT TYPE");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/unittypelogo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addComponent(jLabel6))
        );

        javax.swing.GroupLayout Menu3Layout = new javax.swing.GroupLayout(Menu3);
        Menu3.setLayout(Menu3Layout);
        Menu3Layout.setHorizontalGroup(
            Menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Menu3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Menu3Layout.setVerticalGroup(
            Menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Menu3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Menu4.setBackground(new java.awt.Color(204, 204, 204));
        Menu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu4MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Menu4MousePressed(evt);
            }
        });

        jPanel25.setBackground(new java.awt.Color(204, 204, 255));

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel12.setText("UNITS");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/unitlogo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8)
            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout Menu4Layout = new javax.swing.GroupLayout(Menu4);
        Menu4.setLayout(Menu4Layout);
        Menu4Layout.setHorizontalGroup(
            Menu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Menu4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Menu4Layout.setVerticalGroup(
            Menu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Menu4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Menu5.setBackground(new java.awt.Color(204, 204, 204));
        Menu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu5MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Menu5MousePressed(evt);
            }
        });

        jPanel29.setBackground(new java.awt.Color(204, 204, 255));

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel14.setText("BILLING");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/billinglogo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel9)
        );

        javax.swing.GroupLayout Menu5Layout = new javax.swing.GroupLayout(Menu5);
        Menu5.setLayout(Menu5Layout);
        Menu5Layout.setHorizontalGroup(
            Menu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Menu5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Menu5Layout.setVerticalGroup(
            Menu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Menu5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Menu6.setBackground(new java.awt.Color(204, 204, 204));
        Menu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu6MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Menu6MousePressed(evt);
            }
        });

        jPanel31.setBackground(new java.awt.Color(204, 204, 255));

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel15.setText("PAYMENT");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/paymentlogo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel17)
        );

        javax.swing.GroupLayout Menu6Layout = new javax.swing.GroupLayout(Menu6);
        Menu6.setLayout(Menu6Layout);
        Menu6Layout.setHorizontalGroup(
            Menu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Menu6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Menu6Layout.setVerticalGroup(
            Menu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Menu6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Menu7.setBackground(new java.awt.Color(204, 204, 204));
        Menu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu7MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Menu7MousePressed(evt);
            }
        });

        jPanel33.setBackground(new java.awt.Color(204, 204, 255));

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel20.setText("USERS");

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/paymentlogo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout Menu7Layout = new javax.swing.GroupLayout(Menu7);
        Menu7.setLayout(Menu7Layout);
        Menu7Layout.setHorizontalGroup(
            Menu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Menu7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Menu7Layout.setVerticalGroup(
            Menu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Menu7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Menu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Menu1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Menu3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Menu4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Menu5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Menu6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Menu7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Menu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Menu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Menu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Menu5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Menu6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Menu7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(406, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 240, 720));

        welcomeback.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        welcomeback.setForeground(new java.awt.Color(102, 102, 255));
        welcomeback.setText("Welcome back, Administrator!");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/image-removebg-preview (11).png"))); // NOI18N

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/image-removebg-preview (9).png"))); // NOI18N

        Desktop.setLayer(welcomeback, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Desktop.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Desktop.setLayer(jLabel19, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(welcomeback)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(DesktopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(welcomeback)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addGroup(DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DesktopLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(86, 86, 86))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DesktopLayout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))))
        );

        jPanel2.add(Desktop, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 960, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void XbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XbtnMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_XbtnMouseClicked

    private void Menu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu1MousePressed
        // TODO add your handling code here:
        Menu1.setBackground(ClickedColor);
        Menu2.setBackground(DefaultColor);
        Menu3.setBackground(DefaultColor);
        Menu4.setBackground(DefaultColor);
        Menu5.setBackground(DefaultColor);
        Menu5.setBackground(DefaultColor);
        Menu6.setBackground(DefaultColor);
        Menu7.setBackground(DefaultColor);
    }//GEN-LAST:event_Menu1MousePressed

    private void Menu2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu2MousePressed
        // TODO add your handling code here:
        Menu1.setBackground(DefaultColor);
        Menu2.setBackground(ClickedColor);
        Menu3.setBackground(DefaultColor);
        Menu4.setBackground(DefaultColor);
        Menu5.setBackground(DefaultColor);
        Menu5.setBackground(DefaultColor);
        Menu6.setBackground(DefaultColor);
        Menu7.setBackground(DefaultColor);
    }//GEN-LAST:event_Menu2MousePressed

    private void Menu3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu3MousePressed
        // TODO add your handling code here:
        Menu1.setBackground(DefaultColor);
        Menu2.setBackground(DefaultColor);
        Menu3.setBackground(ClickedColor);
        Menu4.setBackground(DefaultColor);
        Menu5.setBackground(DefaultColor);
        Menu5.setBackground(DefaultColor);
        Menu6.setBackground(DefaultColor);
        Menu7.setBackground(DefaultColor);
    }//GEN-LAST:event_Menu3MousePressed

    private void Menu4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu4MousePressed
        // TODO add your handling code here:
        Menu1.setBackground(DefaultColor);
        Menu2.setBackground(DefaultColor);
        Menu3.setBackground(DefaultColor);
        Menu4.setBackground(ClickedColor);
        Menu5.setBackground(DefaultColor);
        Menu5.setBackground(DefaultColor);
        Menu6.setBackground(DefaultColor);
        Menu7.setBackground(DefaultColor);
    }//GEN-LAST:event_Menu4MousePressed

    private void Menu5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu5MousePressed
        // TODO add your handling code here:
        Menu1.setBackground(DefaultColor);
        Menu2.setBackground(DefaultColor);
        Menu3.setBackground(DefaultColor);
        Menu4.setBackground(DefaultColor);
        Menu5.setBackground(DefaultColor);
        Menu5.setBackground(ClickedColor);
        Menu6.setBackground(DefaultColor);
        Menu7.setBackground(DefaultColor);
    }//GEN-LAST:event_Menu5MousePressed

    private void Menu6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu6MousePressed
        // TODO add your handling code here:
        Menu1.setBackground(DefaultColor);
        Menu2.setBackground(DefaultColor);
        Menu3.setBackground(DefaultColor);
        Menu4.setBackground(DefaultColor);
        Menu5.setBackground(DefaultColor);
        Menu5.setBackground(DefaultColor);
        Menu6.setBackground(ClickedColor);
        Menu7.setBackground(DefaultColor);
    }//GEN-LAST:event_Menu6MousePressed

    private void Menu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu2MouseClicked
        // TODO add your handling code here:
        Tenant menu2 = new Tenant();
        Desktop.removeAll();
        Desktop.add(menu2).setVisible(true);
    }//GEN-LAST:event_Menu2MouseClicked

    private void Menu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu1MouseClicked
        // TODO add your handling code here:
        Dashboard menu1 = new Dashboard();
        Desktop.removeAll();
        Desktop.add(menu1).setVisible(true);
        
    }//GEN-LAST:event_Menu1MouseClicked

    private void Menu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu3MouseClicked
        UnitCategories menu3 = new UnitCategories();
        Desktop.removeAll();
        Desktop.add(menu3).setVisible(true);
    }//GEN-LAST:event_Menu3MouseClicked

    private void Menu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu4MouseClicked
        // TODO add your handling code here:
        ApartmentUnit menu4 = new ApartmentUnit();
        Desktop.removeAll();
        Desktop.add(menu4).setVisible(true);
    }//GEN-LAST:event_Menu4MouseClicked

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        int option = JOptionPane.showConfirmDialog(
        this, 
        "Are you sure you want to log out?", 
        "Logout Confirmation", 
        JOptionPane.YES_NO_OPTION, 
        JOptionPane.QUESTION_MESSAGE
    );

    if (option == JOptionPane.YES_OPTION) {
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();  
    }
    }//GEN-LAST:event_LogoutActionPerformed

    private void Menu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu5MouseClicked
        Billing menu5 = new Billing();
        Desktop.removeAll();
        Desktop.add(menu5).setVisible(true);
    }//GEN-LAST:event_Menu5MouseClicked

    private void Menu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu6MouseClicked
        Payment menu6 = new Payment();
        Desktop.removeAll();
        Desktop.add(menu6).setVisible(true);
    }//GEN-LAST:event_Menu6MouseClicked

    private void Menu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu7MouseClicked
        Users menu7 = new Users();
        Desktop.removeAll();
        Desktop.add(menu7).setVisible(true);
    }//GEN-LAST:event_Menu7MouseClicked

    private void Menu7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu7MousePressed
        Menu1.setBackground(DefaultColor);
        Menu2.setBackground(DefaultColor);
        Menu3.setBackground(DefaultColor);
        Menu4.setBackground(DefaultColor);
        Menu5.setBackground(DefaultColor);
        Menu5.setBackground(DefaultColor);
        Menu6.setBackground(DefaultColor);
        Menu7.setBackground(ClickedColor);
    }//GEN-LAST:event_Menu7MousePressed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JButton Logout;
    private javax.swing.JPanel Menu1;
    private javax.swing.JPanel Menu2;
    private javax.swing.JPanel Menu3;
    private javax.swing.JPanel Menu4;
    private javax.swing.JPanel Menu5;
    private javax.swing.JPanel Menu6;
    private javax.swing.JPanel Menu7;
    private javax.swing.JLabel Xbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel welcomeback;
    // End of variables declaration//GEN-END:variables
}
