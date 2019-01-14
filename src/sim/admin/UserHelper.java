/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sim.connectionDB;
import sim.student;

/**
 *
 * @author SAM
 */
public class UserHelper {
    private int  user_id;
  String user_name, password;
  
      public UserHelper(int user_id, String user_name, String password) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.password = password;

    }


  public int getU_id(){
        return user_id;
    
    
    }
    public String getfiU_name(){
        return user_name;
    
    }
    public String getU_PASS(){
        return password;
    
    }
 
 
  
}
