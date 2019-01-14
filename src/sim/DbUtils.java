/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author Hyrex
 */
class DbUtils {
    
        public DefaultListModel retriveModel() {
        DefaultListModel model = new DefaultListModel();
        String sql1 = "SELECT batch FROM batchlist";
        Connection conn = null;
        ResultSet rs = null;
        Statement s = null;
        try {
            conn = connectionDB.connection_DB();

            s = conn.prepareStatement(sql1);
            rs = s.executeQuery(sql1);
            while (rs.next()) {
                String module = rs.getString(1);
                model.addElement(module);
            }

            return model;
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                conn.close();
                s.close();

            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return null;

    }
     public DefaultListModel retriveSchedule() {
        DefaultListModel model = new DefaultListModel();
        String sql1 = "SELECT schedule FROM schedule";
        Connection conn = null;
        ResultSet rs = null;
        Statement s = null;
        try {
            conn = connectionDB.connection_DB();

            s = conn.prepareStatement(sql1);
            rs = s.executeQuery(sql1);
            while (rs.next()) {
                String module = rs.getString(1);
                model.addElement(module);
            }

            return model;
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                conn.close();
                s.close();

            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return null;

    }
    
}


