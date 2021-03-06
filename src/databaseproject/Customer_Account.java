/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseproject;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Void
 */
public class Customer_Account extends javax.swing.JFrame {

    JFrame f = f = new JFrame();
    int CID;
    Connection mycon;
    String Spassword;

    //Boolean isVisible = true;

    public Customer_Account() {
        initComponents();
        mycon = db_connection.getConnection();
        PopulateFields();
    }

    public Customer_Account(int cid) {
        initComponents();
        mycon = db_connection.getConnection();
        CID = cid;
        PopulateFields();
    }

    public static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public void PopulateFields() {
        String sname = "";
        String phone = "";
        String semail = "";
        String sgender = "";
        try {
            String Str_Query = "Select CUSTOMER_NAME, EMAIL,PASSWORD, PHONE_NUMBER,GENDER  from CUSTOMER where CUSTOMER_ID =?";
            PreparedStatement ps = mycon.prepareStatement(Str_Query);
            ps.setInt(1, CID);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                sname = resultSet.getString("CUSTOMER_NAME");
                phone = resultSet.getString("PHONE_NUMBER");
                Spassword = resultSet.getString("PASSWORD");
                semail = resultSet.getString("EMAIL");
                sgender = resultSet.getString("GENDER");

            }
            email.setText(semail);
            gender.setText(sgender);
            name.setText(sname);
            number.setText(phone);

            email.setEditable(false);
            gender.setEditable(false);

        } catch (SQLException ex) {
            Logger.getLogger(Ad_ActiveSeller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateDetails() {
        String Str_Query = "UPDATE CUSTOMER SET CUSTOMER_NAME=? , Phone_Number=?  where CUSTOMER_ID =?";
        PreparedStatement ps;

        try {
            ps = mycon.prepareStatement(Str_Query);

            ps.setString(1, name.getText());
            ps.setString(2, number.getText());
            ps.setInt(3, CID);
            ps.execute();
            ps.close();
            name.setText(name.getText());
            number.setText(number.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updatePassword() {

        String Str_Query = "UPDATE CUSTOMER SET PASSWORD=?   where CUSTOMER_ID =?";
        PreparedStatement ps;

        try {
            ps = mycon.prepareStatement(Str_Query);

            ps.setString(1, newp.getText());
            ps.setInt(2, CID);
            ps.execute();
            ps.close();

            Spassword = newp.getText();
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackgroundPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Update = new javax.swing.JButton();
        back = new javax.swing.JButton();
        admin3 = new javax.swing.JLabel();
        admin4 = new javax.swing.JLabel();
        admin5 = new javax.swing.JLabel();
        admin6 = new javax.swing.JLabel();
        admin7 = new javax.swing.JLabel();
        admin8 = new javax.swing.JLabel();
        ViewShoppingHistory = new javax.swing.JButton();
        ChangePassword = new javax.swing.JButton();
        ViewAddresses = new javax.swing.JButton();
        gender = new javax.swing.JTextField();
        oldp = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        admin9 = new javax.swing.JLabel();
        number = new javax.swing.JTextField();
        cp = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        newp = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        BackgroundPanel.setBackground(new java.awt.Color(255, 255, 255));
        BackgroundPanel.setFocusable(false);
        BackgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("STAM VIRTUAL MART");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 13, -1, -1));

        BackgroundPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 90));

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Welcome to your most trusted online market place");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 113, -1, -1));

        jLabel4.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Delivering Low-Cost and High-Quality Goods Right at Your Doorstep");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        BackgroundPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1200, 50));

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 1, 48)); // NOI18N
        jLabel2.setText("ACCOUNT DETAILS");
        BackgroundPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, -1, -1));

        Update.setBackground(new java.awt.Color(0, 102, 153));
        Update.setFont(new java.awt.Font("Nirmala UI", 1, 30)); // NOI18N
        Update.setForeground(new java.awt.Color(255, 255, 255));
        Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_seller/updateAccount.png"))); // NOI18N
        Update.setText("UPDATE ");
        Update.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        Update.setContentAreaFilled(false);
        Update.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        Update.setOpaque(true);
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        BackgroundPanel.add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 500, 270, -1));

        back.setBackground(new java.awt.Color(255, 255, 255));
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back(60).png"))); // NOI18N
        back.setContentAreaFilled(false);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        BackgroundPanel.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 610, 130, 90));

        admin3.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        admin3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin3.setText("Confirm New Password");
        admin3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        admin3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        admin3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BackgroundPanel.add(admin3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 390, -1, -1));

        admin4.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        admin4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin4.setText("Gender");
        admin4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        admin4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        admin4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BackgroundPanel.add(admin4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, -1, -1));

        admin5.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        admin5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin5.setText("New Password");
        admin5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        admin5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        admin5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BackgroundPanel.add(admin5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 330, -1, -1));

        admin6.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        admin6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin6.setText("Old Password");
        admin6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        admin6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        admin6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BackgroundPanel.add(admin6, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 270, -1, -1));

        admin7.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        admin7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin7.setText("Name");
        admin7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        admin7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        admin7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BackgroundPanel.add(admin7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, -1, -1));

        admin8.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        admin8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin8.setText("Email");
        admin8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        admin8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        admin8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BackgroundPanel.add(admin8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, -1, -1));

        ViewShoppingHistory.setBackground(new java.awt.Color(0, 102, 153));
        ViewShoppingHistory.setFont(new java.awt.Font("Nirmala UI", 1, 30)); // NOI18N
        ViewShoppingHistory.setForeground(new java.awt.Color(255, 255, 255));
        ViewShoppingHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cart(30).png"))); // NOI18N
        ViewShoppingHistory.setText("VIEW SHOPPING HISTORY");
        ViewShoppingHistory.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        ViewShoppingHistory.setContentAreaFilled(false);
        ViewShoppingHistory.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ViewShoppingHistory.setOpaque(true);
        ViewShoppingHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewShoppingHistoryActionPerformed(evt);
            }
        });
        BackgroundPanel.add(ViewShoppingHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 580, 430, -1));

        ChangePassword.setBackground(new java.awt.Color(0, 102, 153));
        ChangePassword.setFont(new java.awt.Font("Nirmala UI", 1, 30)); // NOI18N
        ChangePassword.setForeground(new java.awt.Color(255, 255, 255));
        ChangePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_seller/cahnge_password.png"))); // NOI18N
        ChangePassword.setText("CHANGE PASSWORD");
        ChangePassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        ChangePassword.setContentAreaFilled(false);
        ChangePassword.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ChangePassword.setOpaque(true);
        ChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangePasswordActionPerformed(evt);
            }
        });
        BackgroundPanel.add(ChangePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 460, 370, -1));

        ViewAddresses.setBackground(new java.awt.Color(0, 102, 153));
        ViewAddresses.setFont(new java.awt.Font("Nirmala UI", 1, 30)); // NOI18N
        ViewAddresses.setForeground(new java.awt.Color(255, 255, 255));
        ViewAddresses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/address(30).png"))); // NOI18N
        ViewAddresses.setText("VIEW ADDRESSES");
        ViewAddresses.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        ViewAddresses.setContentAreaFilled(false);
        ViewAddresses.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ViewAddresses.setOpaque(true);
        ViewAddresses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewAddressesActionPerformed(evt);
            }
        });
        BackgroundPanel.add(ViewAddresses, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 580, 320, -1));

        gender.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        gender.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BackgroundPanel.add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 450, 250, 30));

        oldp.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        oldp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        oldp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldpActionPerformed(evt);
            }
        });
        BackgroundPanel.add(oldp, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 270, 250, 30));

        email.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BackgroundPanel.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 250, 30));

        admin9.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        admin9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin9.setText("Phone Number");
        admin9.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        admin9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        admin9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BackgroundPanel.add(admin9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, -1));

        number.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        number.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberActionPerformed(evt);
            }
        });
        BackgroundPanel.add(number, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 250, 30));

        cp.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        cp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpActionPerformed(evt);
            }
        });
        BackgroundPanel.add(cp, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 390, 250, 30));

        name.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        BackgroundPanel.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 250, 30));

        newp.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        newp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        newp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newpActionPerformed(evt);
            }
        });
        BackgroundPanel.add(newp, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 330, 250, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1199, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:
        if (name.getText().equals("")) {
            JOptionPane.showMessageDialog(f, "Missing Value, Enter Name", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (number.getText().equals("")) {
            JOptionPane.showMessageDialog(f, "Missing Value, Enter Phone Number", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (number.getText().length() != 11) {
            JOptionPane.showMessageDialog(f, "Invalid Value, Enter 11 digit Phone Number Value", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {

            // Changing details into database code
            updateDetails();
            JOptionPane.showMessageDialog(f, "Details Updated Successfully");

        }
    }//GEN-LAST:event_UpdateActionPerformed

    private void ViewShoppingHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewShoppingHistoryActionPerformed
        // TODO add your handling code here:
        new Customer_PurchaseHistory(CID).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ViewShoppingHistoryActionPerformed

    private void ChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangePasswordActionPerformed
        // TODO add your handling code here:
        if (oldp.getText().equals("")) {
            JOptionPane.showMessageDialog(f, "Missing Value, Enter Old Password", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (newp.getText().equals("")) {
            JOptionPane.showMessageDialog(f, "Missing Value, Enter New Password", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (cp.getText().equals("")) {
            JOptionPane.showMessageDialog(f, "Missing Value, Enter Confirm Password", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (!oldp.getText().equals(Spassword)) {

            JOptionPane.showMessageDialog(f, "Invalid Value, Old Password is Incorrect", "ERROR", JOptionPane.ERROR_MESSAGE);

        } else if (!cp.getText().equals(newp.getText())) {
            JOptionPane.showMessageDialog(f, "Invalid Value, New Password does not match Confirm Password", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {

            //Change password in database code
            JOptionPane.showMessageDialog(f, "Password Changed Successfully");
            updatePassword();
            cp.setText("");
            newp.setText("");
            oldp.setText("");
        }
    }//GEN-LAST:event_ChangePasswordActionPerformed

    private void ViewAddressesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewAddressesActionPerformed
        // TODO add your handling code here:
        new Customer_Addresses(CID).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ViewAddressesActionPerformed

    private void oldpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oldpActionPerformed

    private void numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberActionPerformed

    private void cpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void newpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newpActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        new Customer_Main(CID).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(Customer_Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer_Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer_Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer_Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>



        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MainPage().setVisible(true);
//            }
//        });
        JFrame newMain = new Customer_Account();
        newMain.setTitle("STAM Virtual Mart");
        newMain.setVisible(true);
        newMain.setResizable(false);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackgroundPanel;
    private javax.swing.JButton ChangePassword;
    private javax.swing.JButton Update;
    private javax.swing.JButton ViewAddresses;
    private javax.swing.JButton ViewShoppingHistory;
    private javax.swing.JLabel admin3;
    private javax.swing.JLabel admin4;
    private javax.swing.JLabel admin5;
    private javax.swing.JLabel admin6;
    private javax.swing.JLabel admin7;
    private javax.swing.JLabel admin8;
    private javax.swing.JLabel admin9;
    private javax.swing.JButton back;
    private javax.swing.JTextField cp;
    private javax.swing.JTextField email;
    private javax.swing.JTextField gender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField name;
    private javax.swing.JTextField newp;
    private javax.swing.JTextField number;
    private javax.swing.JTextField oldp;
    // End of variables declaration//GEN-END:variables
}
