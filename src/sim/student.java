package sim;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.UIManager.getInt;
import javax.swing.table.DefaultTableModel;

public class student {
//    byte[] person_image = null;

    public void insertUpdateDeleteStudent(char operation, Integer st_id, String first_name, String last_name,
            String dob, String gender, String phone, String address, String email,
            String post_code, byte[] st_image,String label,String batch_name,double fees,String schedule,String reg_date) {

        Connection con = connectionDB.connection_DB();
        PreparedStatement pst;
        //i for insert
        if (operation == 'i') {
            try {
                pst = con.prepareStatement("insert into students(first_name, last_name, dob, gender, phone, address, email, post_code,st_image, label, batch_name, fees, schedule, reg_date) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                pst.setString(1, first_name);
                pst.setString(2, last_name);
                pst.setString(3, dob);
                pst.setString(4, gender);
                pst.setString(5, phone);
                pst.setString(6, address);
                pst.setString(7, email);
                pst.setString(8, post_code);

//         AddStudent1 addSTD= new AddStudent1();
                pst.setBytes(9, st_image);
                pst.setString(10, label);
                pst.setString(11, batch_name);
                pst.setDouble(12, fees);
                pst.setString(13, schedule);
                pst.setString(14, reg_date);

                if (pst.executeUpdate() > 0) {

                    JOptionPane.showMessageDialog(null, "New student added");
                }

            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (operation == 'u') {
            try {
                pst = con.prepareStatement("UPDATE students SET first_name= ?, last_name= ?, dob= ?, gender= ?, phone= ?, address= ?, email= ?, post_code= ?, st_image= ?, label = ?, batch_name= ?, fees= ?, schedule= ?, reg_date= ? WHERE st_id= ?");
                pst.setString(1, first_name);
                pst.setString(2, last_name);
                pst.setString(3, dob);
                pst.setString(4, gender);
                pst.setString(5, phone);
                pst.setString(6, address);
                pst.setString(7, email);
                pst.setString(8, post_code);
                pst.setBytes(9, st_image);
                pst.setString(10, label);
                pst.setString(11, batch_name);
                pst.setDouble(12, fees);
                pst.setString(13, schedule);
                pst.setString(14, reg_date);
               
                pst.setInt(15, st_id);
                

                if (pst.executeUpdate() > 0) {

                    JOptionPane.showMessageDialog(null, "Student Updated");
                }

            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (operation == 'd') {
            try {
                pst = con.prepareStatement("DELETE FROM students WHERE st_id=? ");
                pst.setInt(1, st_id);

                if (pst.executeUpdate() > 0) {

                    JOptionPane.showMessageDialog(null, "Student Deleted");
                }

            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void displayTable(JTable table, String valueTosearch) {

        Connection con = connectionDB.connection_DB();
        PreparedStatement pst;
        try {
            pst = con.prepareStatement("SELECT * FROM students where CONCAT (first_name, last_name, dob, gender, phone, address, email, post_code) LIKE ? ");
            pst.setString(1, "%" + valueTosearch + "%");
            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            while (rs.next()) {
                row = new Object[10];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                row[7] = rs.getString(8);
                row[8] = rs.getString(9);
                row[9] = rs.getBytes(10);
                model.addRow(row);
            }

        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
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
            combo.insertItemAt("--Select One--", 0);
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
    public void loadComboLABEL(JComboBox combo,JTextField fees) {

        Connection conn = null;
        ResultSet rs = null;
        CallableStatement cst = null;
        Connection conn2 = null;
        ResultSet rs2 = null;
        PreparedStatement pst = null;
        

        try {
            conn = connectionDB.connection_DB();
            conn2 = connectionDB.connection_DB();
          pst=conn2.prepareStatement("SELECT * FROM course WHERE fees= ?");
          pst.setString(1, String.valueOf(fees));
          rs2 =pst.executeQuery();
            
            
            cst = conn.prepareCall("{CALL listlabel()}");
            cst.execute();
            rs = cst.getResultSet();
            List labelList = new ArrayList();
            List FeesList = new ArrayList();
            while (rs.next()) {
                labelList.add(rs.getString(1));
                

            }
            while(rs2.next()){
            FeesList.add(rs2.getString(1));
            String setFEES = rs2.getString("fees");
//            FEES.setText(setFEES);
            
            }
            combo.setModel(new DefaultComboBoxModel(labelList.toArray()));
            combo.insertItemAt("--Select One--", 0);
            combo.setSelectedIndex(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                conn2.close();
                 cst.close();
                 pst.close();
                rs.close();
                rs2.close();
            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public int getcourseID(String courseLabel) {
        int courseID = 0;
        Connection conn = connectionDB.connection_DB();
        PreparedStatement pst;
        ResultSet rs;
        try {
            pst = conn.prepareStatement("SELECT * FROM course WHERE label=? ");
            pst.setString(1, courseLabel);
            rs = pst.executeQuery();
            while (rs.next()) {
                courseID = getInt("id");

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return courseID;
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

            while (rs.next()) {
                labelList.add(rs.getString(1));

            }

            combo.setModel(new DefaultComboBoxModel(labelList.toArray()));
            combo.insertItemAt("--Select One--", 0);
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
//    public void loadModuleList(JComboBox combo) {
//
//        Connection conn = null;
//        ResultSet rs = null;
//        CallableStatement cst = null;
//
//        try {
//            conn = connectionDB.connection_DB();
//
//            cst = conn.prepareCall("{CALL listModule()}");
//            cst.execute();
//            rs = cst.getResultSet();
//            List MList = new ArrayList();
//
//            while (rs.next()) {
//                
//                MList.add(rs.getString(1));
//
//            }
//
//            combo.setModel(new DefaultComboBoxModel(MList.toArray()));
//            combo.insertItemAt("--Choose One--", 0);
//            combo.setSelectedIndex(0);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                conn.close();
//                cst.close();
//                rs.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        }
//
//    }
 
}
