/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseproject;

import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class CustomerSignUp extends javax.swing.JFrame {

    //Boolean isVisible = true;
    
    Connection myConn;
    Integer CID = 0;
    JFrame f = new JFrame();

    public CustomerSignUp() {
        initComponents();
        myConn = db_connection.getConnection();
    }
    
    public void email_check() {

        String email_v = email.getText();
        //String pass_v = password.getText();
        //String name_v = name.getText();
        try {
            String Str_Query = "Select CUSTOMER_ID from CUSTOMER where Email=?";
            PreparedStatement ps = myConn.prepareStatement(Str_Query);

            ps.setString(1, email_v);

            ResultSet resultSet = ps.executeQuery();

            CID = 0;
            while (resultSet.next()) {
                CID = resultSet.getInt("CUSTOMER_ID");
            }
        } catch (SQLException ex) {

            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }

        //System.out.println(SID);
    }
   private void Signup_Method() {
        String na = name.getText();
        String em = email.getText();
        String sq = SecurityQuestion.getSelectedItem().toString();
        String sa = SecurityAnswer.getText();
        String ge = Gender.getSelectedItem().toString();
        String pass = cpassword.getText();
        String pn = phoneNo.getText();

        try {
            String Str_Query = "INSERT INTO CUSTOMER (Customer_Name,  Email, Security_Question, Gender, Password, Phone_Number)"
                    + " VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = myConn.prepareStatement(Str_Query);
            ps.setString(1, na);
            ps.setString(2, em);
            ps.setString(3, sq.concat(sa));
            ps.setString(4, ge);
            ps.setString(5, pass);
            ps.setString(6, pn);
            
            int resultSetInt = ps.executeUpdate();

            /*CID = 0;
            while (resultSet.next()) {
                CID = resultSet.getInt("CUSTOMER_ID");
            }*/
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
    /*public void SignUp_Method() {
        
        String email_v = email.getText();
        String pass_v = password.getText();
        String name_v = name.getText();
        
        
        try {
            String Str_Query1 = "SELECT Customer_ID from CUSTOMER where email = ?";
            PreparedStatement ps1 = myConn.prepareStatement(Str_Query1);
            
            ps1.setString(1, email.getText());
            
            ResultSet resultSet = ps1.executeQuery();

            CID = 0;
            while (resultSet.next()) {
                CID = resultSet.getInt("CUSTOMER_ID");
            }
            if (CID==0){
            String Str_Query = "INSERT INTO CUSTOMER (Customer_Name, Password, Email, Gender, Phone_Number, Security_Question)"
                    + " VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = myConn.prepareStatement(Str_Query);
            
            ps.setString(1, name_v);
            ps.setString(2, pass_v);
            ps.setString(3, email_v);
            ps.setString(4, Gender.getSelectedItem().toString());
            ps.setString(5, phoneNo.getText());
            ps.setString(6, SecurityQuestion.getSelectedItem().toString().concat(SecurityAnswer.getText()));
            
            int resultSetInt = ps.executeUpdate();

//            CID = 0;
//            while (resultSet.next()) {
//                CID = resultSet.getInt("CUSTOMER_ID");
//            }
            System.out.println(CID);
            }else{
                JOptionPane.showMessageDialog(f, "Email is already in use. Please use another email.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackgroundPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        admin = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        admin2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        admin1 = new javax.swing.JLabel();
        admin3 = new javax.swing.JLabel();
        admin4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        cpassword = new javax.swing.JPasswordField();
        SignUp = new javax.swing.JButton();
        admin5 = new javax.swing.JLabel();
        phoneNo = new javax.swing.JTextField();
        admin6 = new javax.swing.JLabel();
        admin7 = new javax.swing.JLabel();
        admin8 = new javax.swing.JLabel();
        SecurityAnswer = new javax.swing.JTextField();
        admin9 = new javax.swing.JLabel();
        admin10 = new javax.swing.JLabel();
        admin11 = new javax.swing.JLabel();
        admin12 = new javax.swing.JLabel();
        SecurityQuestion = new javax.swing.JComboBox<>();
        email = new javax.swing.JTextField();
        Gender = new javax.swing.JComboBox<>();
        back = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        admin13 = new javax.swing.JLabel();

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

        admin.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        admin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/customer(80).png"))); // NOI18N
        admin.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        admin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        admin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 10, -1, -1));

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

        admin2.setFont(new java.awt.Font("Nirmala UI", 1, 30)); // NOI18N
        admin2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin2.setText("CUSTOMER");
        admin2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        admin2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        admin2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(admin2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 0, -1, -1));

        BackgroundPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1200, 50));

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 1, 48)); // NOI18N
        jLabel2.setText("SIGN UP");
        BackgroundPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, -1, -1));

        admin1.setFont(new java.awt.Font("Nirmala UI", 1, 35)); // NOI18N
        admin1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin1.setText("CONFIRM PASSWORD");
        admin1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        admin1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        admin1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BackgroundPanel.add(admin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 330, -1, -1));

        admin3.setFont(new java.awt.Font("Nirmala UI", 1, 35)); // NOI18N
        admin3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin3.setText("GENDER");
        admin3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        admin3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        BackgroundPanel.add(admin3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 620, -1, -1));

        admin4.setFont(new java.awt.Font("Nirmala UI", 1, 30)); // NOI18N
        admin4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/name(50).png"))); // NOI18N
        admin4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        admin4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        BackgroundPanel.add(admin4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 60, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/password(50).png"))); // NOI18N
        BackgroundPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 220, -1, -1));

        name.setFont(new java.awt.Font("Nirmala UI", 0, 30)); // NOI18N
        name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        BackgroundPanel.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 510, 50));

        cpassword.setFont(new java.awt.Font("Nirmala UI", 0, 30)); // NOI18N
        cpassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpasswordActionPerformed(evt);
            }
        });
        BackgroundPanel.add(cpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 380, 420, 50));

        SignUp.setBackground(new java.awt.Color(0, 102, 153));
        SignUp.setFont(new java.awt.Font("Nirmala UI", 1, 30)); // NOI18N
        SignUp.setForeground(new java.awt.Color(255, 255, 255));
        SignUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/signup(50).png"))); // NOI18N
        SignUp.setText("SIGN UP");
        SignUp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        SignUp.setContentAreaFilled(false);
        SignUp.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        SignUp.setOpaque(true);
        SignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpActionPerformed(evt);
            }
        });
        BackgroundPanel.add(SignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 610, 190, 70));

        admin5.setFont(new java.awt.Font("Nirmala UI", 1, 35)); // NOI18N
        admin5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin5.setText("EMAIL");
        admin5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        admin5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        BackgroundPanel.add(admin5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        phoneNo.setFont(new java.awt.Font("Nirmala UI", 0, 30)); // NOI18N
        phoneNo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        phoneNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNoActionPerformed(evt);
            }
        });
        BackgroundPanel.add(phoneNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 510, 420, 50));

        admin6.setFont(new java.awt.Font("Nirmala UI", 1, 35)); // NOI18N
        admin6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin6.setText("PHONE NUMBER");
        admin6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        admin6.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        BackgroundPanel.add(admin6, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 460, -1, -1));

        admin7.setFont(new java.awt.Font("Nirmala UI", 1, 35)); // NOI18N
        admin7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin7.setText("NAME");
        admin7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        admin7.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        BackgroundPanel.add(admin7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, -1));

        admin8.setFont(new java.awt.Font("Nirmala UI", 1, 35)); // NOI18N
        admin8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin8.setText("SECURITY QUESTION");
        admin8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        admin8.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        BackgroundPanel.add(admin8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, -1, -1));

        SecurityAnswer.setFont(new java.awt.Font("Nirmala UI", 0, 30)); // NOI18N
        SecurityAnswer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SecurityAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SecurityAnswerActionPerformed(evt);
            }
        });
        BackgroundPanel.add(SecurityAnswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 550, 510, 50));

        admin9.setFont(new java.awt.Font("Nirmala UI", 1, 30)); // NOI18N
        admin9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/phoneNo(50).png"))); // NOI18N
        admin9.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        admin9.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        BackgroundPanel.add(admin9, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 460, 60, 50));

        admin10.setFont(new java.awt.Font("Nirmala UI", 1, 30)); // NOI18N
        admin10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/securityQuestion(50).png"))); // NOI18N
        admin10.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        admin10.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        BackgroundPanel.add(admin10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 60, 50));

        admin11.setFont(new java.awt.Font("Nirmala UI", 1, 30)); // NOI18N
        admin11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/gender(50).png"))); // NOI18N
        admin11.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        admin11.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        BackgroundPanel.add(admin11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 620, 60, 50));

        admin12.setFont(new java.awt.Font("Nirmala UI", 1, 30)); // NOI18N
        admin12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/email(50).png"))); // NOI18N
        admin12.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        admin12.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        BackgroundPanel.add(admin12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 60, 50));

        SecurityQuestion.setFont(new java.awt.Font("Nirmala UI", 0, 30)); // NOI18N
        SecurityQuestion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name of your first pet?", "Elementary school did you attend?", "Name of your birth city?" }));
        SecurityQuestion.setBorder(null);
        SecurityQuestion.setFocusable(false);
        SecurityQuestion.setOpaque(false);
        SecurityQuestion.setBackground(Color.WHITE);
        BackgroundPanel.add(SecurityQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 510, -1));

        email.setFont(new java.awt.Font("Nirmala UI", 0, 30)); // NOI18N
        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        BackgroundPanel.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 510, 50));

        Gender.setFont(new java.awt.Font("Nirmala UI", 0, 30)); // NOI18N
        Gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        Gender.setBorder(null);
        Gender.setFocusable(false);
        Gender.setOpaque(false);
        Gender.setBackground(Color.WHITE);
        BackgroundPanel.add(Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 620, 160, -1));

        back.setBackground(new java.awt.Color(255, 255, 255));
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back(60).png"))); // NOI18N
        back.setContentAreaFilled(false);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        BackgroundPanel.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 610, 130, 90));

        password.setFont(new java.awt.Font("Nirmala UI", 0, 30)); // NOI18N
        password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        BackgroundPanel.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 270, 420, 50));

        admin13.setFont(new java.awt.Font("Nirmala UI", 1, 35)); // NOI18N
        admin13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin13.setText("PASSWORD");
        admin13.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        admin13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        admin13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BackgroundPanel.add(admin13, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, -1, -1));

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

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void cpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpasswordActionPerformed

    private void SignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpActionPerformed
            
        
        if (name.getText().equals("")) {
            JOptionPane.showMessageDialog(f, "Missing Value, Enter Name", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (email.getText().equals("")) {
            JOptionPane.showMessageDialog(f, "Missing Value, Enter Email", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (SecurityAnswer.getText().equals("")) {
            JOptionPane.showMessageDialog(f, "Missing Value, Answer the Security Question", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (Gender.getSelectedItem().toString().equals("")) {
            JOptionPane.showMessageDialog(f, "Missing Value, Enter Gender", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (password.getText().equals("")) {
            JOptionPane.showMessageDialog(f, "Missing Value, Enter Password", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (phoneNo.getText().equals("")) {
            JOptionPane.showMessageDialog(f, "Missing Value, Enter Phone Number", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (phoneNo.getText().length() != 11) {
            JOptionPane.showMessageDialog(f, "Invalid length, Enter 11 digits for the phone number.", "ERROR", JOptionPane.ERROR_MESSAGE);    
        } else if (!password.getText().equals(cpassword.getText())) {
            JOptionPane.showMessageDialog(f, "Both Passwords do not match. Enter password again.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
        email_check(); 
        if (CID != 0) {
                JOptionPane.showMessageDialog(f, "Account already exists. Please enter the credentials again.", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                Signup_Method();

                JOptionPane.showMessageDialog(null, "Sign Up Successful. Your Account has been created.");
                new Customer().setVisible(true);
                this.setVisible(false);
            }

        }
    }//GEN-LAST:event_SignUpActionPerformed

    private void phoneNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNoActionPerformed

    private void SecurityAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SecurityAnswerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SecurityAnswerActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        new Customer().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    
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
            java.util.logging.Logger.getLogger(CustomerSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
 
    
        JFrame newMain = new CustomerSignUp();
        newMain.setTitle("STAM Virtual Mart");
        newMain.setVisible(true);
        newMain.setResizable(false);
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackgroundPanel;
    private javax.swing.JComboBox<String> Gender;
    private javax.swing.JTextField SecurityAnswer;
    private javax.swing.JComboBox<String> SecurityQuestion;
    private javax.swing.JButton SignUp;
    private javax.swing.JLabel admin;
    private javax.swing.JLabel admin1;
    private javax.swing.JLabel admin10;
    private javax.swing.JLabel admin11;
    private javax.swing.JLabel admin12;
    private javax.swing.JLabel admin13;
    private javax.swing.JLabel admin2;
    private javax.swing.JLabel admin3;
    private javax.swing.JLabel admin4;
    private javax.swing.JLabel admin5;
    private javax.swing.JLabel admin6;
    private javax.swing.JLabel admin7;
    private javax.swing.JLabel admin8;
    private javax.swing.JLabel admin9;
    private javax.swing.JButton back;
    private javax.swing.JPasswordField cpassword;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField name;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField phoneNo;
    // End of variables declaration//GEN-END:variables
}
