package sim;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class course {

    public void insertUpdateDeleteCourse(char operation, Integer id , String label , Integer hours_number ,double fees,String batch_name,String module,String schedule) {

        Connection con = connectionDB.connection_DB();
        PreparedStatement pst;
        //i for insert
        if (operation == 'i') {
            try {
                pst = con.prepareStatement("insert into course(label, hours_number, fees, batch_name, module, schedule) values(?,?,?,?,?,?)");
                pst.setString(1, label);
                pst.setInt(2, hours_number);
                pst.setDouble(3, fees);
                pst.setString(4, batch_name);
                pst.setString(5, module);
                pst.setString(6, schedule);


                if (pst.executeUpdate() > 0) {

                    JOptionPane.showMessageDialog(null, "New Course added");
                }

            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (operation == 'u') {
            try {
                pst = con.prepareStatement("UPDATE course SET label= ?, hours_number= ?,fees= ?, batch_name= ?, module= ?, schedule= ? WHERE id = ?");
                pst.setString(1, label);
                pst.setInt(2, hours_number);
               pst.setDouble(3, fees);
               pst.setString(4, batch_name);
               pst.setString(5, module);
               pst.setString(6, schedule);
                 pst.setInt(7, id);

                if (pst.executeUpdate() > 0) {

                    JOptionPane.showMessageDialog(null, "Course data Updated");
                }

            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (operation == 'd') {
            try {
                pst = con.prepareStatement("DELETE FROM course WHERE id=? ");
                pst.setInt(1, id);

                if (pst.executeUpdate() > 0) {

                    JOptionPane.showMessageDialog(null, "Course data Deleted");
                }

            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
    public boolean isCourseExist(String courseName)
    {
        boolean isExist=false;
       Connection con=connectionDB.connection_DB();
 PreparedStatement pst;
      try {
          pst=con.prepareStatement("SELECT * FROM course WHERE label= ?");
          pst.setString(1, courseName);
          ResultSet rs =pst.executeQuery();
        
         if(rs.next()){
            isExist= true;
         }else{
         
         }
          
                  
                  } catch (SQLException ex) {
          Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
      }
    
    
     return isExist;
    }
    public boolean isBatchExist(String batchName)
    {
        boolean isExist=false;
       Connection con=connectionDB.connection_DB();
 PreparedStatement pst;
      try {
          pst=con.prepareStatement("SELECT * FROM course WHERE batch_name= ?");
          pst.setString(1, batchName);
          ResultSet rs =pst.executeQuery();
        
         if(rs.next()){
            isExist= true;
         }else{
         
         }
          
                  
                  } catch (SQLException ex) {
          Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
      }
    
    
     return isExist;
    }
    
     public void displayCourseTable(JTable table)
 {
 
 Connection con=connectionDB.connection_DB();
 PreparedStatement pst;
      try {
          pst=con.prepareStatement("SELECT * FROM course");
          
          ResultSet rs =pst.executeQuery();
         DefaultTableModel model= (DefaultTableModel) table.getModel();
         Object[] row;
         while(rs.next()){
         row=new Object[7];
         row[0]=rs.getInt(1);
         row[1]=rs.getString(2);
         row[2]=rs.getInt(3);
         row[3]=rs.getDouble(4);
         row[4]=rs.getString(5);
         row[5]=rs.getString(6);
         row[6]=rs.getString(7);
      
         model.addRow(row);
         }
          
                  
                  } catch (SQLException ex) {
          Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
      }
 
 }
    

}
