
package sim.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class manage_users {
     Connection conn=null;
ResultSet rs=null;
PreparedStatement pst=null;
    
    
   public void adduser(){
   
      int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to add record?","Add Record",JOptionPane.YES_NO_OPTION);
        if(p==0){        // TODO add your handling code here:

        try {
            user user= new user();
            String sql ="insert into User (user_name,password) values (?,?) ";

            pst=conn.prepareStatement(sql);
            pst.setString(1,user.TXTuserNAME.getText());
            
            
          

            pst.execute();
            JOptionPane.showMessageDialog(null,"New User Added");

        }
        catch (Exception e)

        {
           e.printStackTrace();
        }
        finally {

            try{
                rs.close();
                pst.close();

            }
            catch(Exception e){
   e.printStackTrace();
            }
        }
        } 
      
   
   
   
   
   } 
 public void updateUSER(){
                                            
        // TODO add your handling code here:
        int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to update record?","Update Record",JOptionPane.YES_NO_OPTION);
        if(p==0){
         try{
            
            
            String value2 = user.TXTuserNAME.getText();
          
            String value4 = user.pass1.getText();
           
            
            String sql= "update Users set  user_name='"+value2+"', password='"+value4+"' ";
            
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Record Updated");
            
        }catch(Exception e){
       JOptionPane.showMessageDialog(null, e);
        }
        finally {
            
            try{
                rs.close();
                pst.close();
                
            }
            catch(Exception e){
                
            }
        }
        }
 
 
 
 
 
 }   
    

    
    
}
