/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SAM
 */
public class User {

    private int st_id;
    String first_name, last_name, dob, gender, phone, address, email, post_code, label, batch_name, schedule, reg_date;
    byte[] st_image;
    double fees;

//  byte[] person_image;
    public User(int st_id, String first_name, String last_name, String dob, String gender, String phone, String address, String email, String post_code, byte[] st_image,
            String label, String batch_name, double fees, String schedule, String reg_date
    ) {
        this.st_id = st_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.post_code = post_code;
        this.st_image = st_image;
        this.label = label;
        this.batch_name = batch_name;
        this.fees = fees;
        this.schedule = schedule;
        this.reg_date = reg_date;
    }

    public int getst_id() {
        return st_id;

    }

    public String getfirst_name() {
        return first_name;

    }

    public String getlast_name() {
        return last_name;

    }

    public String getdob() {
        return dob;

    }

    public String getgender() {
        return gender;

    }

    public String getphone() {
        return phone;

    }

    public String getaddress() {
        return address;

    }

    public String getemail() {
        return email;

    }

    public String getpost_code() {
        return post_code;

    }

    public byte[] getst_image() {
        return st_image;

    }

    public String getlabel() {
        return label;

    }

    public String getbatch_name() {
        return batch_name;

    }

    public Double getfees() {
        return fees;

    }

    public String getschedule() {
        return schedule;

    }

    public String getreg_date() {
        return reg_date;

    }

}
