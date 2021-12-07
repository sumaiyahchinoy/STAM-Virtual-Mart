package databaseproject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import static databaseproject.AddProduct.isNumeric;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Void
 */
public class Product_PopUp extends javax.swing.JFrame {

    //Boolean isVisible = true;
    public Product_PopUp() {
        initComponents();

    }

    public Product_PopUp(int pid, int a) {
        initComponents();
        SID = a;
        PID = pid;
        con = db_connection.getConnection();
        DisplayYo();
        setEditable();
    }
    int PID;
    int SID;
    JFrame f = new JFrame();
    Connection con;

    public static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    int tq=0;
    int cq=0;

    public void setEditable() {

        price.setEditable(false);
        model.setEditable(false);
        totalquantity.setEditable(false);
        currentInventory.setEditable(false);
        brand.setEditable(false);
        name.setEditable(false);

    }

    public void updateDetails() {
        String Str_Query = "UPDATE ITEM_DETAIL SET DESCRIPTION=? , TOTAL_QUANTITY=?,CURRENT_INVENTORY=?  where ITEM_ID =?";
        PreparedStatement ps;
        int q = Integer.parseInt(addQuantity.getText());
        try {
            ps = con.prepareStatement(Str_Query);

            ps.setString(1, description.getText());
            ps.setInt(2, q+tq);
            ps.setInt(3, q+cq);
            ps.setInt(4, PID);
            ps.execute();
            ps.close();
       

        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DisplayYo() {

        Statement st;
        String v_name = "";
        String v_desc = "";
        String brd = "";
        String str = "";
        int tq = 0;

        int v_price = 0;
        int CTypeID = 0;
        int CI = 0;
        String br = "";

        byte[] img = null;

        try {
            st = con.createStatement();
            String Str_Query = "Select ITEM_NAME, CATEGORY_TYPE_ID, DESCRIPTION, COST_PRICE, ITEM_IMAGE, CURRENT_INVENTORY,TOTAL_QUANTITY from ITEM_DETAIL"
                    + " where ITEM_ID=?";
            PreparedStatement ps = con.prepareStatement(Str_Query);
            ps.setInt(1, PID);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                v_name = rs.getString("ITEM_NAME");
                v_desc = rs.getString("DESCRIPTION");
                v_price = rs.getInt("COST_PRICE");
                img = rs.getBytes("ITEM_IMAGE");
                CTypeID = rs.getInt("CATEGORY_TYPE_ID");
                CI = rs.getInt("CURRENT_INVENTORY");
                tq = rs.getInt("TOTAL_QUANTITY");

                str = "Select CATEGORY_TYPE_NAME, SUB_CATEGORY_ID  from SUB_CATEGORY_TYPE"
                        + " where CATEGORY_TYPE_ID =?";
                PreparedStatement ps_v = con.prepareStatement(str);
                ps_v.setInt(1, CTypeID);
                ResultSet rs_v = ps_v.executeQuery();
                int brand = 0;
                if (rs_v.next()) {
                    brd = rs_v.getString("CATEGORY_TYPE_NAME");
                    brand = rs_v.getInt("SUB_CATEGORY_ID");
                }

                String str1 = "Select SUB_CATEGORY_NAME from SUB_CATEGORY"
                        + " where SUB_CATEGORY_ID =?";
                PreparedStatement ps_v1 = con.prepareStatement(str1);
                ps_v1.setInt(1, brand);
                ResultSet rs_v1 = ps_v1.executeQuery();

                if (rs_v1.next()) {
                    br = rs_v1.getString("SUB_CATEGORY_NAME");
                }
            }
            //int Id, String Name, String brand, int Price, byte[] image, int CatId
        } catch (SQLException ex) {
            Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        ImageIcon image = new ImageIcon(new ImageIcon(img).getImage()
                .getScaledInstance(200, 200, Image.SCALE_SMOOTH));

        selectedPhoto.setIcon(image);
        name.setText(v_name);
        description.setText(v_desc);
        model.setText(brd);
        price.setText(String.valueOf(v_price));
        totalquantity.setText(String.valueOf(tq));
        currentInventory.setText(String.valueOf(CI));
        brand.setText(br);
        this.tq = tq;
        this.cq =CI;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        menuBar2 = new java.awt.MenuBar();
        menu3 = new java.awt.Menu();
        menu4 = new java.awt.Menu();
        menuBar3 = new java.awt.MenuBar();
        menu5 = new java.awt.Menu();
        menu6 = new java.awt.Menu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        addToCart = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        selectedPhoto = new javax.swing.JLabel();
        admin9 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        admin7 = new javax.swing.JLabel();
        admin11 = new javax.swing.JLabel();
        admin6 = new javax.swing.JLabel();
        admin10 = new javax.swing.JLabel();
        addquantity = new javax.swing.JLabel();
        admin12 = new javax.swing.JLabel();
        admin13 = new javax.swing.JLabel();
        brand = new javax.swing.JTextField();
        model = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        currentInventory = new javax.swing.JTextField();
        totalquantity = new javax.swing.JTextField();
        addQuantity = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        menu3.setLabel("File");
        menuBar2.add(menu3);

        menu4.setLabel("Edit");
        menuBar2.add(menu4);

        menu5.setActionCommand("P1\np2\np3");
        menuBar3.add(menu5);

        menu6.setActionCommand("P1\np2\np3");
        menuBar3.add(menu6);

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        addToCart.setBackground(new java.awt.Color(0, 77, 64));
        addToCart.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        addToCart.setForeground(new java.awt.Color(255, 255, 255));
        addToCart.setText("Add to cart");
        addToCart.setBorder(null);
        addToCart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PRODUCT DETAIL");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, -1, 60));

        panel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 60));

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
        panel.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 520, 200, 70));

        selectedPhoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selectedPhoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 77, 64), 1, true));
        selectedPhoto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel.add(selectedPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 230, 210));

        admin9.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        admin9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin9.setText("Description");
        admin9.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        admin9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        admin9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panel.add(admin9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        name.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 420, 50));

        admin7.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        admin7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin7.setText("Product Name");
        admin7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        admin7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        admin7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panel.add(admin7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        admin11.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        admin11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin11.setText("Brand");
        admin11.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        admin11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        admin11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panel.add(admin11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, -1));

        admin6.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        admin6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin6.setText("Model");
        admin6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        admin6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        admin6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panel.add(admin6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, -1, -1));

        admin10.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        admin10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin10.setText("Price");
        admin10.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        admin10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        admin10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panel.add(admin10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, -1, -1));

        addquantity.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        addquantity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addquantity.setText("Quantity to Add");
        addquantity.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        addquantity.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addquantity.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panel.add(addquantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 450, -1, -1));

        admin12.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        admin12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin12.setText("Total Quantity");
        admin12.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        admin12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        admin12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panel.add(admin12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 370, -1, -1));

        admin13.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        admin13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin13.setText("Current Inventory");
        admin13.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        admin13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        admin13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panel.add(admin13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 410, -1, -1));

        brand.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        brand.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel.add(brand, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 250, 30));

        model.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        model.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel.add(model, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 250, 30));

        price.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        price.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 510, 190, 30));

        currentInventory.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        currentInventory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel.add(currentInventory, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 410, 150, 30));

        totalquantity.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        totalquantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel.add(totalquantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 370, 150, 30));

        addQuantity.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        addQuantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel.add(addQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 450, 150, 30));

        back.setBackground(new java.awt.Color(255, 255, 255));
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back(60).png"))); // NOI18N
        back.setContentAreaFilled(false);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        panel.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 520, 130, 90));

        description.setColumns(20);
        description.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        description.setLineWrap(true);
        description.setRows(5);
        description.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jScrollPane1.setViewportView(description);

        panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 420, 150));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCartActionPerformed

    }//GEN-LAST:event_addToCartActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        if (description.getText().equals("")) {
            JOptionPane.showMessageDialog(f, "Missing Value, Enter Description", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (addQuantity.getText().equals("")) {
            JOptionPane.showMessageDialog(f, "Missing Value, Enter Quantity", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (!isNumeric(addQuantity.getText())) {
            JOptionPane.showMessageDialog(f, "Invalid Value, Enter Numeric Quantity Value", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {

            // Changing details into database ecode
            updateDetails();
            JOptionPane.showMessageDialog(f, "Product Details Updated Successfully");
            this.setVisible(false);
            Products abc = new Products(SID);
            abc.setVisible(true);
        }
    }//GEN-LAST:event_updateActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Products abc = new Products(SID);
        abc.setVisible(true);
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
            java.util.logging.Logger.getLogger(Product_PopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Product_PopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Product_PopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Product_PopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        JFrame newMain = new Product_PopUp();
        newMain.setVisible(true);
        newMain.setResizable(false);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addQuantity;
    private javax.swing.JButton addToCart;
    private javax.swing.JLabel addquantity;
    private javax.swing.JLabel admin10;
    private javax.swing.JLabel admin11;
    private javax.swing.JLabel admin12;
    private javax.swing.JLabel admin13;
    private javax.swing.JLabel admin6;
    private javax.swing.JLabel admin7;
    private javax.swing.JLabel admin9;
    private javax.swing.JButton back;
    private javax.swing.JTextField brand;
    private javax.swing.JTextField currentInventory;
    private javax.swing.JTextArea description;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.Menu menu3;
    private java.awt.Menu menu4;
    private java.awt.Menu menu5;
    private java.awt.Menu menu6;
    private java.awt.MenuBar menuBar1;
    private java.awt.MenuBar menuBar2;
    private java.awt.MenuBar menuBar3;
    private javax.swing.JTextField model;
    private javax.swing.JTextField name;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField price;
    private javax.swing.JLabel selectedPhoto;
    private javax.swing.JTextField totalquantity;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
