/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseproject;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.*;
import java.util.logging.Level;
import java.sql.*;
import java.util.logging.Logger;

/**
 *
 * @author Void
 */
public class Account extends javax.swing.JFrame {

    //Boolean isVisible = true;
    public Account() {
        initComponents();
        mycon = db_connection.getConnection();
        PopulateFields();

    }

    public Account(int sid) {
        initComponents();
        SID = sid;
        mycon = db_connection.getConnection();
        PopulateFields();
    }
    JFrame f = f = new JFrame();
    int SID ;
    Connection mycon;
    String Spassword;
    int Sbalance;

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
        int searned = 0;
        String phone = "";
        String sgender = "";
        String semail = "";
        try {
            String Str_Query = "Select  SELLER_NAME, EMAIL,PASSWORD, GENDER, PHONE_NUMBER, TOTAL_EARNED, BALANCE  from SELLER where SELLER_ID =?";
            PreparedStatement ps = mycon.prepareStatement(Str_Query);
            ps.setInt(1, SID);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Sbalance = resultSet.getInt("BALANCE");
                sname = resultSet.getString("SELLER_NAME");
                searned = resultSet.getInt("TOTAL_EARNED");
                phone = resultSet.getString("PHONE_NUMBER");
                Spassword = resultSet.getString("PASSWORD");
                sgender = resultSet.getString("GENDER");
                semail = resultSet.getString("EMAIL");

            }
            email.setText(semail);
            number.setText(phone);
            gender.setText(sgender);
            earned.setText(searned + "");
            balance.setText(Sbalance + "");
            name.setText(sname);

            email.setEditable(false);
            gender.setEditable(false);
            earned.setEditable(false);
            balance.setEditable(false);

        } catch (SQLException ex) {
            Logger.getLogger(Ad_ActiveSeller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateDetails() {
        String Str_Query = "UPDATE SELLER SET SELLER_NAME=? , Phone_Number=?  where SELLER_ID =?";
        PreparedStatement ps;
         
        try {
            ps = mycon.prepareStatement(Str_Query);

            ps.setString(1, name.getText());
            ps.setString(2, number.getText());
            ps.setInt(3, SID);
            ps.execute();
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateBalance() {
        int newbalance = Sbalance - Integer.parseInt(cashout.getText()); 
        String Str_Query = "UPDATE SELLER SET BALANCE=?   where SELLER_ID =?";
        PreparedStatement ps;
         
        try {
            ps = mycon.prepareStatement(Str_Query);

            ps.setInt(1, newbalance);
            ps.setInt(2, SID);
            ps.execute();
            ps.close();
            
            Sbalance = newbalance;
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updatePassword() {
         
        String Str_Query = "UPDATE SELLER SET PASSWORD=?   where SELLER_ID =?";
        PreparedStatement ps;
         
        try {
            ps = mycon.prepareStatement(Str_Query);

            ps.setString(1, newp.getText());
            ps.setInt(2, SID);
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
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        balance = new javax.swing.JTextField();
        number = new javax.swing.JTextField();
        confirmp = new javax.swing.JTextField();
        update = new javax.swing.JButton();
        back = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        oldp = new javax.swing.JTextField();
        newp = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        changepassword = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cashout = new javax.swing.JTextField();
        cashOut = new javax.swing.JButton();
        name = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        gender = new javax.swing.JTextField();
        earned = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        BackgroundPanel.setBackground(new java.awt.Color(255, 255, 255));
        BackgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("STAM VIRTUAL MART");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_seller/seller(80).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(338, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(260, 260, 260)
                .addComponent(jLabel2)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(84, 84, 84))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BackgroundPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 90));

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));

        jLabel3.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Delivering Low-Cost and High-Quality Goods Right at Your Doorstep");

        jLabel5.setFont(new java.awt.Font("Nirmala UI", 1, 30)); // NOI18N
        jLabel5.setText("SELLER");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(227, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(64, 64, 64)
                .addComponent(jLabel5)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addGap(25, 25, 25))
        );

        BackgroundPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1200, 50));

        jLabel9.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel9.setText("Confirm New Password");
        BackgroundPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 360, 200, 30));

        jLabel10.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel10.setText("Enter Amount to Cash Out");
        BackgroundPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 520, 230, -1));

        jLabel11.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel11.setText("Name");
        BackgroundPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 140, -1));

        jLabel12.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel12.setText("Total Earned");
        BackgroundPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 130, -1));

        balance.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        balance.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        balance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balanceActionPerformed(evt);
            }
        });
        BackgroundPanel.add(balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, 190, 30));

        number.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        number.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberActionPerformed(evt);
            }
        });
        BackgroundPanel.add(number, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 290, 30));

        confirmp.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        confirmp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        confirmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmpActionPerformed(evt);
            }
        });
        BackgroundPanel.add(confirmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 360, 230, 30));

        update.setBackground(new java.awt.Color(0, 102, 153));
        update.setFont(new java.awt.Font("Nirmala UI", 1, 30)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_seller/updateAccount.png"))); // NOI18N
        update.setText("UPDATE");
        update.setActionCommand("");
        update.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        update.setContentAreaFilled(false);
        update.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        update.setOpaque(true);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        BackgroundPanel.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 590, 200, 70));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_seller/back(60).png"))); // NOI18N
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        BackgroundPanel.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 580, 80, 80));

        jLabel7.setFont(new java.awt.Font("Nirmala UI", 1, 48)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ACCOUNT DETAILS");
        BackgroundPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 450, 40));

        oldp.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        oldp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BackgroundPanel.add(oldp, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 250, 230, 30));

        newp.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        newp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BackgroundPanel.add(newp, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 303, 230, 30));

        jLabel13.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel13.setText("Old Password");
        BackgroundPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 250, 140, 30));

        jLabel14.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel14.setText("New Password");
        BackgroundPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 310, 130, 30));

        changepassword.setBackground(new java.awt.Color(0, 102, 153));
        changepassword.setFont(new java.awt.Font("Nirmala UI", 1, 30)); // NOI18N
        changepassword.setForeground(new java.awt.Color(255, 255, 255));
        changepassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_seller/cahnge_password.png"))); // NOI18N
        changepassword.setText("CHANGE PASSWORD");
        changepassword.setActionCommand("");
        changepassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        changepassword.setContentAreaFilled(false);
        changepassword.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        changepassword.setOpaque(true);
        changepassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changepasswordActionPerformed(evt);
            }
        });
        BackgroundPanel.add(changepassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 430, 400, 50));

        jLabel15.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel15.setText("Phone Number");
        BackgroundPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 140, -1));

        jLabel16.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel16.setText("Email");
        BackgroundPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 130, -1));

        jLabel17.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel17.setText("Gender");
        BackgroundPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 130, -1));

        cashout.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        cashout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cashout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashoutActionPerformed(evt);
            }
        });
        BackgroundPanel.add(cashout, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 560, 200, 30));

        cashOut.setBackground(new java.awt.Color(0, 102, 153));
        cashOut.setFont(new java.awt.Font("Nirmala UI", 1, 30)); // NOI18N
        cashOut.setForeground(new java.awt.Color(255, 255, 255));
        cashOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons_seller/cash_out.png"))); // NOI18N
        cashOut.setText("CASH OUT");
        cashOut.setActionCommand("");
        cashOut.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        cashOut.setContentAreaFilled(false);
        cashOut.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cashOut.setOpaque(true);
        cashOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashOutActionPerformed(evt);
            }
        });
        BackgroundPanel.add(cashOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 610, 200, 40));

        name.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        BackgroundPanel.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 410, 30));

        email.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        BackgroundPanel.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 410, 30));

        gender.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        gender.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderActionPerformed(evt);
            }
        });
        BackgroundPanel.add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, 190, 30));

        earned.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        earned.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        earned.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                earnedActionPerformed(evt);
            }
        });
        BackgroundPanel.add(earned, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 190, 30));

        jLabel18.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel18.setText("Balance");
        BackgroundPanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 140, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1199, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberActionPerformed

    private void balanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_balanceActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
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
            this.setVisible(false);
            HomeSeller abc = new HomeSeller(SID);
           
            abc.setVisible(true);
        }
    }//GEN-LAST:event_updateActionPerformed

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        HomeSeller abc = new HomeSeller(SID);
        abc.setVisible(true);
    }//GEN-LAST:event_backMouseClicked

    private void confirmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmpActionPerformed

    private void changepasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changepasswordActionPerformed
        // TODO add your handling code here:
        if (oldp.getText().equals("")) {
            JOptionPane.showMessageDialog(f, "Missing Value, Enter Old Password", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (newp.getText().equals("")) {
            JOptionPane.showMessageDialog(f, "Missing Value, Enter New Password", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (confirmp.getText().equals("")) {
            JOptionPane.showMessageDialog(f, "Missing Value, Enter Confirm Password", "ERROR", JOptionPane.ERROR_MESSAGE);
        } 

        else if (!oldp.getText().equals(Spassword)) {
      
            JOptionPane.showMessageDialog(f, "Invalid Value, Old Password is Incorrect", "ERROR", JOptionPane.ERROR_MESSAGE);
            
        }
         else if (!confirmp.getText().equals(newp.getText())) {
            JOptionPane.showMessageDialog(f, "Invalid Value, New Password does not match Confirm Password", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {

            //Change password in database code
            JOptionPane.showMessageDialog(f, "Password Changed Successfully");
            updatePassword();
            confirmp.setText("");
            newp.setText("");
            oldp.setText("");
        }


    }//GEN-LAST:event_changepasswordActionPerformed

    private void cashoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cashoutActionPerformed

    private void cashOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashOutActionPerformed
        // TODO add your handling code here:
        if (cashout.getText().equals("")) {
            JOptionPane.showMessageDialog(f, "Missing Value, Enter Amount To Cash Out", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (!isNumeric(cashout.getText())) {
            JOptionPane.showMessageDialog(f, "Invalid Value, Enter Numeric Amount Value", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (Integer.parseInt(balance.getText()) < Integer.parseInt(cashout.getText())) {
            JOptionPane.showMessageDialog(f, "Invalid Value, Cash Amount is Greater than Balance", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {

            // Change balance in database 
            JOptionPane.showMessageDialog(f, "Amount Successfully Cashed Out");
            String oldBalance = balance.getText();
            Integer newbalance = Integer.parseInt(oldBalance) - Integer.parseInt(cashout.getText());
            balance.setText(Integer.toString(newbalance));
            updateBalance();
            cashout.setText("");
        }

    }//GEN-LAST:event_cashOutActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderActionPerformed

    private void earnedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_earnedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_earnedActionPerformed

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
            java.util.logging.Logger.getLogger(Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MainPage().setVisible(true);
//            }
//        });
        JFrame newMain = new Account();
        newMain.setVisible(true);
        newMain.setResizable(false);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackgroundPanel;
    private javax.swing.JLabel back;
    private javax.swing.JTextField balance;
    private javax.swing.JButton cashOut;
    private javax.swing.JTextField cashout;
    private javax.swing.JButton changepassword;
    private javax.swing.JTextField confirmp;
    private javax.swing.JTextField earned;
    private javax.swing.JTextField email;
    private javax.swing.JTextField gender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField name;
    private javax.swing.JTextField newp;
    private javax.swing.JTextField number;
    private javax.swing.JTextField oldp;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
