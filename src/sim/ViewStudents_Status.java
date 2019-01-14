/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim;

import java.awt.Color;
import static java.awt.Color.red;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import static sim.Studentview.TIMESHOW2;
import static sim.Studentview.lblDATE2;
import static sim.Studentview.lbl_img;
import static sim.Studentview.rbn;
import static sim.Studentview.redate;
import static sim.Studentview.rei;
import static sim.Studentview.rfm;
import static sim.Studentview.rfn;
import static sim.Studentview.rid;
import static sim.Studentview.rl;
import static sim.Studentview.rln;
import static sim.Studentview.rp;
import static sim.Studentview.rr;
import static sim.Studentview.rrd;
import static sim.Studentview.rsi;
import static sim.Studentview.rsudl;
import static sim.Studentview.rsw;
import static sim.Studentview.rsev;
import static sim.Studentview.rts;
import static sim.manageStudent3.jTable_Display_User;

/**
 *
 * @author SAM
 */
public class ViewStudents_Status extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    public byte[] person_image;
    public ViewStudents_Status() {
        initComponents();
        DETAILS1();
        loadComboBatch(comboBatch);
        loadComboLABEL(searchLabel);
        this.person_image = null;
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2,
                size.height / 2 - getHeight() / 2);
        table_details.setBackground(new Color(0, 0, 0, 0));
        ((DefaultTableCellRenderer) table_details.getDefaultRenderer(Object.class)).setBackground(new Color(0, 0, 0, 0));

        table_details.setGridColor(Color.RED);
        table_details.setForeground(Color.BLACK);
        jScrollPane1.setOpaque(false);
        table_details.setOpaque(false);
        ((DefaultTableCellRenderer) table_details.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);

    }

    public void SearchByID() {
        String stID = idsearch.getText();
        try {

            conn = connectionDB.connection_DB();
            String sql = "SELECT st_id, first_name, last_name,st_image, label,\n"
                    + " batch_name, schedule, reg_date, scoreId, ex_id,\n"
                    + " ex_date, full_marks, score_written,\n"
                    + "  score_evedence, Score_Total, parcentage,\n"
                    + "  remarks FROM report r where st_id='" + stID + "'";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table_details.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {

            try {
                rs.close();
                pst.close();

            } catch (Exception e) {

            }
        }
    }
    private void SearchByBatchName() {
        String getBatch = comboBatch.getSelectedItem().toString();
        try {

            conn = connectionDB.connection_DB();
            String sql = "SELECT st_id, first_name, last_name,st_image, label,\n"
                    + " batch_name, schedule, reg_date, scoreId, ex_id,\n"
                    + " ex_date, full_marks, score_written,\n"
                    + "  score_evedence, Score_Total, parcentage,\n"
                    + "  remarks FROM report r where batch_name='" + getBatch + "'";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table_details.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {

            try {
                rs.close();
                pst.close();

            } catch (Exception e) {

            }
        }
    }
    private void SearchCOURCElabel() {
        String getlabel = searchLabel.getSelectedItem().toString();
        try {

            conn = connectionDB.connection_DB();
            String sql = "SELECT st_id, first_name, last_name,st_image, label,\n"
                    + " batch_name, schedule, reg_date, scoreId, ex_id,\n"
                    + " ex_date, full_marks, score_written,\n"
                    + "  score_evedence, Score_Total, parcentage,\n"
                    + "  remarks FROM report r where label='" + getlabel + "'";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table_details.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {

            try {
                rs.close();
                pst.close();

            } catch (Exception e) {

            }
        }
    }

    private void DETAILS1() {
        try {

            conn = connectionDB.connection_DB();
            String sql = "SELECT st_id, first_name, last_name,st_image,label,\n"
                    + " batch_name, schedule, reg_date, scoreId, ex_id,\n"
                    + " ex_date, full_marks, score_written,\n"
                    + "  score_evedence, Score_Total, parcentage,\n"
                    + "  remarks FROM report";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table_details.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {

            try {
                rs.close();
                pst.close();

            } catch (Exception e) {

            }
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

        jPanel1 = new javax.swing.JPanel();
        idsearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_details = new javax.swing.JTable();
        comboBatch = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        searchLabel = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        idsearch.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        idsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idsearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idsearchKeyTyped(evt);
            }
        });

        table_details.setBackground(new java.awt.Color(0, 0, 255));
        table_details.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        table_details.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        table_details.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_details.setRowHeight(40);
        table_details.setSelectionBackground(new java.awt.Color(255, 255, 255));
        table_details.setSelectionForeground(new java.awt.Color(0, 102, 255));
        table_details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_detailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_details);

        comboBatch.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        comboBatch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBatch.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comboBatchPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Search Batch");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Search Id");
        jLabel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jLabel2KeyReleased(evt);
            }
        });

        searchLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        searchLabel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        searchLabel.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                searchLabelPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Search Batch");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Select   Student  To  Print Details");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 389, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(searchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(idsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBatch)
                    .addComponent(searchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

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

    private void idsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idsearchKeyReleased

        if (idsearch.getText().isEmpty()) {
            DETAILS1();
            
            comboBatch.setSelectedIndex(0);
            searchLabel.setSelectedIndex(0);

        } else {
            SearchByID();

        }


    }//GEN-LAST:event_idsearchKeyReleased

    private void comboBatchPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comboBatchPopupMenuWillBecomeInvisible
        if (comboBatch.getSelectedIndex()==0) {
            DETAILS1();
            idsearch.setText("");
        } else {
            SearchByBatchName();
        }

    }//GEN-LAST:event_comboBatchPopupMenuWillBecomeInvisible

    private void searchLabelPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_searchLabelPopupMenuWillBecomeInvisible
               if (comboBatch.getSelectedIndex()==0) {
            DETAILS1();
            idsearch.setText("");
        } else {
            SearchCOURCElabel();
        }
    }//GEN-LAST:event_searchLabelPopupMenuWillBecomeInvisible

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
               HomeWindow hw = new HomeWindow();
        this.dispose();

        hw.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void table_detailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_detailsMouseClicked
      manageStudent3 ms= new manageStudent3();
        
        int i = table_details.getSelectedRow();
      
      Studentview sv= new Studentview();
      sv.setVisible(true);
       TableModel model = table_details.getModel();
    String click=((model.getValueAt(i, 0)).toString());
        try {
            String sql  ="SELECT * FROM report WHERE st_id='"+click+"'";
       pst=conn.prepareStatement(sql);
       rs=pst.executeQuery();
         rid.setText(model.getValueAt(i, 0).toString());
         rfn.setText(model.getValueAt(i, 1).toString());
         rln.setText(model.getValueAt(i, 2).toString());

            byte[] img = (ms.userList().get(i).getst_image());
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(), Image.SCALE_DEFAULT));
            lbl_img.setIcon(imageIcon);
            person_image = img;;
            rl.setText(model.getValueAt(i, 4).toString());
             rbn.setText(model.getValueAt(i, 5).toString());
            rsudl.setText(model.getValueAt(i, 6).toString());
            rrd.setText(model.getValueAt(i, 7).toString());
             rsi.setText(model.getValueAt(i, 8).toString());
            rei.setText(model.getValueAt(i, 9).toString());
            redate.setText(model.getValueAt(i, 10).toString());
            rfm.setText(model.getValueAt(i, 11).toString());
            rsw.setText(model.getValueAt(i, 12).toString());
            rsev.setText(model.getValueAt(i, 13).toString());
            rts.setText(model.getValueAt(i, 14).toString());
            rp.setText(model.getValueAt(i, 15).toString());
            rr.setText(model.getValueAt(i, 16).toString());
     
            
        } catch (Exception e) {
            e.printStackTrace();
        }
  
       currentDate();
         showTime();  
        
    }//GEN-LAST:event_table_detailsMouseClicked

    private void jLabel2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2KeyReleased

    private void idsearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idsearchKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_idsearchKeyTyped

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
            java.util.logging.Logger.getLogger(ViewStudents_Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewStudents_Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewStudents_Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewStudents_Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewStudents_Status().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBatch;
    private javax.swing.JTextField idsearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> searchLabel;
    private javax.swing.JTable table_details;
    // End of variables declaration//GEN-END:variables
    public void loadComboBatch(JComboBox combo) {

        Connection conn = null;
        ResultSet rs = null;
        CallableStatement cst = null;

        try {
            conn = connectionDB.connection_DB();
            cst = conn.prepareCall("{CALL listBatchName()}");
            cst.execute();
            rs = cst.getResultSet();
            List BatchlList = new ArrayList();
            while (rs.next()) {
                BatchlList.add(rs.getString(1));

            }
            combo.setModel(new DefaultComboBoxModel(BatchlList.toArray()));
            combo.insertItemAt("--ALL--", 0);
            combo.setSelectedIndex(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                cst.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
       public void loadComboLABEL(JComboBox combo) {

        Connection conn = null;
        ResultSet rs = null;
        CallableStatement cst = null;
    
        

        try {
            conn = connectionDB.connection_DB();

            
            cst = conn.prepareCall("{CALL listlabel()}");
            cst.execute();
            rs = cst.getResultSet();
            List labelList = new ArrayList();
            List FeesList = new ArrayList();
            while (rs.next()) {
                labelList.add(rs.getString(1));
                

            }
            combo.setModel(new DefaultComboBoxModel(labelList.toArray()));
            combo.insertItemAt("--ALL--", 0);
            combo.setSelectedIndex(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                cst.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    } 
    
    
   public void currentDate() {

        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        lblDATE2.setText((month + 1) + "/" + day + "/" + year);

        //Time
        int second = cal.get(Calendar.SECOND);
        int minute = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR);

        //lblTIME.setText(hour+":"+(minute)+":"+second);
    }
        void showTime() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss");
                TIMESHOW2.setText(s.format(d));
            }
        }).start();

    }    

}
