/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.admin;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import sim.HomeWindow;
import sim.ManageCourse;
import sim.MyFunction;
import sim.connectionDB;
import static sim.manageStudent3.jTable_Display_User;
import sim.student;

/**
 *
 * @author SAM
 */
public class user extends javax.swing.JPanel {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    String message = "";

    public user() {
        initComponents();
        show_user();
    }

    public boolean isUserExist(String username) {
        boolean isExist = false;
        Connection con = connectionDB.connection_DB();
        PreparedStatement pst;
        try {
            pst = con.prepareStatement("SELECT * FROM user WHERE user_name= ?");
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                isExist = true;
            } else {

            }

        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }

        return isExist;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LABEL_output = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        pass1 = new javax.swing.JPasswordField();
        TXTuserNAME = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TXTuserID = new javax.swing.JTextField();
        btnDELETE = new javax.swing.JButton();
        btnUPDATE = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Display_User = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 102));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        setPreferredSize(new java.awt.Dimension(800, 487));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");

        LABEL_output.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LABEL_output.setForeground(new java.awt.Color(0, 51, 204));
        LABEL_output.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("CREATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        pass1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pass1KeyReleased(evt);
            }
        });

        TXTuserNAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTuserNAMEActionPerformed(evt);
            }
        });
        TXTuserNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXTuserNAMEKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ID");

        TXTuserID.setEditable(false);
        TXTuserID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTuserIDActionPerformed(evt);
            }
        });
        TXTuserID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXTuserIDKeyReleased(evt);
            }
        });

        btnDELETE.setBackground(new java.awt.Color(240, 19, 43));
        btnDELETE.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDELETE.setForeground(new java.awt.Color(255, 255, 255));
        btnDELETE.setText("DELETE");
        btnDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDELETEActionPerformed(evt);
            }
        });

        btnUPDATE.setBackground(new java.awt.Color(0, 141, 255));
        btnUPDATE.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUPDATE.setForeground(new java.awt.Color(255, 255, 255));
        btnUPDATE.setText("UPDATE");
        btnUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUPDATEActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgMenue/output-onlinepngtools.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pass1)
                            .addComponent(TXTuserNAME, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(TXTuserID, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(LABEL_output, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(54, 54, 54))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(28, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXTuserID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TXTuserNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pass1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LABEL_output, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDELETE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUPDATE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTable_Display_User.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "USER NAME", "PASSWORD"
            }
        ));
        jTable_Display_User.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Display_UserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Display_User);

        jLabel4.setFont(new java.awt.Font("Simplified Arabic", 1, 24)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Existing User");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(154, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TXTuserNAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTuserNAMEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTuserNAMEActionPerformed
    public boolean verify2() {
        char[] p1 = pass1.getPassword();
        
        String pa1 = new String(p1);
      
       

        if (TXTuserNAME.getText().isEmpty() || pass1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "One or more fields are empty !");
            return false;
        } else if (pass1.getText().length() < 8 || pass1.getText().length() > 20) {
            JOptionPane.showMessageDialog(null, "password must contains 8 to 20 character long!");
            return false;
        } //        else if (!x) {
        //            return false;
        //            
        //        }  
        //           else  if(isUserExist(TXTuserNAME.getText())){
        //        LABEL_output.setText(message+"user already exist !");
        //         JOptionPane.showMessageDialog(null, "try another user name");     
        //       TXTuserNAME.requestFocus();
        //        return false;
        //        
        //        }
        else {
            LABEL_output.setText(" ");
            return true;
        }

    }

    public boolean verify() {
        char[] p1 = pass1.getPassword();
        
        String pa1 = new String(p1);
  

        if (TXTuserNAME.getText().isEmpty() || pass1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "One or more fields are empty !");
            return false;
        } else if (pass1.getText().length() < 8 || pass1.getText().length() > 20) {
            JOptionPane.showMessageDialog(null, "password must contains 8 to 20 character long!");
            return false;
        } 
        if (isUserExist(TXTuserNAME.getText())) {
            LABEL_output.setText(message + "user already exist !");
            JOptionPane.showMessageDialog(null, "try another user name");
            TXTuserNAME.requestFocus();
            return false;

        } else {
            LABEL_output.setText(" ");
            return true;
        }

    }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String user_namE = TXTuserNAME.getText();

        String passW1 = pass1.getText();
        

        if (verify()) {

            insertUpdateDeleteUser('i', null, user_namE, passW1);
        }
        DefaultTableModel model = (DefaultTableModel) jTable_Display_User.getModel();
        model.setRowCount(0);
        show_user();
        clearfield();


    }//GEN-LAST:event_jButton1ActionPerformed
    public void insertUpdateDeleteUser(char operation, Integer user_id, String user_name, String password) {

        Connection con = connectionDB.connection_DB();
        PreparedStatement pst;
        //i for insert
        if (operation == 'i') {
            try {
                pst = con.prepareStatement("insert into user(user_name, password) values(?,?)");
                pst.setString(1, user_name);
                pst.setString(2, password);

                if (pst.executeUpdate() > 0) {

                    JOptionPane.showMessageDialog(null, "New user added");
                }

            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (operation == 'u') {
            try {
                pst = con.prepareStatement("UPDATE user SET user_name= ?, password= ? WHERE user_id= ?");
                pst.setString(1, user_name);
                pst.setString(2, password);

                pst.setInt(3, user_id);

                if (pst.executeUpdate() > 0) {

                    JOptionPane.showMessageDialog(null, "User Updated");
                }

            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (operation == 'd') {
            try {
                pst = con.prepareStatement("DELETE FROM user WHERE user_id=? ");
                pst.setInt(1, user_id);

                if (pst.executeUpdate() > 0) {

                    JOptionPane.showMessageDialog(null, "User Deleted");
                }

            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public ArrayList<UserHelper> userList() {

        ArrayList<UserHelper> userList = new ArrayList<>();

        try {
            Connection con = connectionDB.connection_DB();
            String query1 = "SELECT * from user ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            UserHelper user;
            while (rs.next()) {
                user = new UserHelper(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("password"));
                userList.add(user);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return userList;
    }

    public void show_user() {
        ArrayList<UserHelper> list = userList();
        DefaultTableModel model = (DefaultTableModel) jTable_Display_User.getModel();
        Object[] row = new Object[3];
        for (int i = 0; i < list.size(); i++) {
//            Object object = row[i];
            row[0] = list.get(i).getU_id();
            row[1] = list.get(i).getfiU_name();
            row[2] = list.get(i).getU_PASS();

            model.addRow(row);
        }

    }

    public void clearfield() {

        TXTuserID.setText("");
        TXTuserNAME.setText("");
        pass1.setText("");
      
        LABEL_output.setText("");

    }


    private void btnDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDELETEActionPerformed
        int confrm = JOptionPane.showConfirmDialog(null, "Are you sure to delete ?", "Delete", JOptionPane.YES_NO_OPTION);
        if (confrm == 0) {
            try {
                Connection con = connectionDB.connection_DB();
                int row = jTable_Display_User.getSelectedRow();
                String value = (jTable_Display_User.getModel().getValueAt(row, 0).toString());
                String querry4 = "DELETE FROM user WHERE user_id=" + value;
                PreparedStatement pst = con.prepareStatement(querry4);
                pst.executeUpdate();
                DefaultTableModel model = (DefaultTableModel) jTable_Display_User.getModel();
                HomeWindow hw = new HomeWindow();
                hw.cs.setText("Total Students : " + Integer.toString(MyFunction.countData("students")));
                model.setRowCount(0);

                JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
                show_user();

//                   hw.cs.setText(Integer.toString(MyFunction.countData("student")));
                clearfield();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Select one to Delete User");
                System.out.println(e.getMessage());
            }

        }


    }//GEN-LAST:event_btnDELETEActionPerformed

    private void TXTuserNAMEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXTuserNAMEKeyReleased
        if (isUserExist(TXTuserNAME.getText())) {
            LABEL_output.setText(message + "user already exist !");
            JOptionPane.showMessageDialog(null, "try another user name");
            TXTuserNAME.requestFocus();

        } else {
            LABEL_output.setText(" ");
        }


    }//GEN-LAST:event_TXTuserNAMEKeyReleased

 
    private void pass1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass1KeyReleased

        if (pass1.getText().length() < 8 || pass1.getText().length() > 20) {
            LABEL_output.setText(message +"invalid password");
            pass1.requestFocus();
        } else {

            LABEL_output.setText(message);
        }


    }//GEN-LAST:event_pass1KeyReleased

    private void btnUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUPDATEActionPerformed

        int confrm = JOptionPane.showConfirmDialog(null, "Are you sure to Update ?", "Update", JOptionPane.YES_NO_OPTION);
        if (confrm == 0) {
            try {
                int idx = Integer.valueOf(TXTuserID.getText());
                String UUname = TXTuserNAME.getText();
                String UUpass1 = pass1.getText();
               
                if (verify2()) {

                    insertUpdateDeleteUser('u', idx, UUname, UUpass1);
                    DefaultTableModel model = (DefaultTableModel) jTable_Display_User.getModel();
                    model.setRowCount(0);
                    show_user();
                    clearfield();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "select one to update");
                System.out.println(e.getMessage());
            }

        }

    }//GEN-LAST:event_btnUPDATEActionPerformed

    private void TXTuserIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTuserIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTuserIDActionPerformed

    private void TXTuserIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXTuserIDKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTuserIDKeyReleased

    private void jTable_Display_UserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Display_UserMouseClicked

        int i = jTable_Display_User.getSelectedRow();
        TableModel model = jTable_Display_User.getModel();
        TXTuserID.setText(model.getValueAt(i, 0).toString());
        TXTuserNAME.setText(model.getValueAt(i, 1).toString());
        pass1.setText(model.getValueAt(i, 2).toString());
//        pass2.setText(model.getValueAt(i, 2).toString());


    }//GEN-LAST:event_jTable_Display_UserMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        clearfield();;


    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
                UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LABEL_output;
    public static javax.swing.JTextField TXTuserID;
    public static javax.swing.JTextField TXTuserNAME;
    private javax.swing.JButton btnDELETE;
    private javax.swing.JButton btnUPDATE;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Display_User;
    public static javax.swing.JPasswordField pass1;
    // End of variables declaration//GEN-END:variables
}
