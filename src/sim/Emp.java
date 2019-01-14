/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static sim.HomeWindow.cc;
import static sim.HomeWindow.cs;

/**
 *
 * @author AliHyrex
 */
public class Emp {

    public static int empId;
    public static String empUSER;
    public static String T_Course;
    public static String T_Student;
    public static String totalpayment_old;
    public static String totalpayment_new;
    public static String payment_new;
    public static String payment_old;
    
//     File file = new File("D:\\io/B.txt");  

    File file = new File("userID.txt");
    File file2 = new File("userN.txt");
    File file3 = new File("totalStudent.txt");
    File file4 = new File("totalCourse.txt");

    public Scanner x;
    public Scanner y;
    public Scanner z;
    String status = "";
    String status2 = "";
    String status3 = "";

    public void writedata() throws IOException {
        BufferedWriter buf = null;
        BufferedWriter buf2 = null;
        BufferedWriter buf3 = null;
        BufferedWriter buf4 = null;

        try {
            buf = new BufferedWriter(new FileWriter(file));
            buf2 = new BufferedWriter(new FileWriter(file2));
            buf3 = new BufferedWriter(new FileWriter(file3));
            buf4 = new BufferedWriter(new FileWriter(file4));
            buf.write(String.valueOf(Emp.empId));
            buf2.write(String.valueOf(Emp.empUSER));
            buf3.write(String.valueOf(Emp.T_Student));
            buf4.write(String.valueOf(Emp.T_Course));
            buf.newLine();
            buf2.newLine();
            buf3.newLine();
            buf4.newLine();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (buf != null || buf2 != null || buf3 != null || buf4 != null) {
                buf.close();
                buf2.close();
                buf3.close();
                buf4.close();
            }
        }
    }

    public void openFile() {
        try {
            x = new Scanner(file2);//new Scanner(new File("B.txt"));
            y = new Scanner(file3);//new Scanner(new File("B.txt"));
            z = new Scanner(file4);//new Scanner(new File("B.txt"));
        } catch (Exception e) {
            System.out.println(" File not found ");
        }
    }

    public void readFile() {
        while (x.hasNext()) {
            status = x.next();
        }
//          System.out.printf("%s %s %s\n ", status);  
        while (y.hasNext()) {
            status2 = y.next();
        }
        while (z.hasNext()) {
            status3 = z.next();

        }

    }

    public void closeFile() {
        x.close();
        y.close();
        z.close();
    }

    public void collectdata() {

        T_Student = Integer.toString(MyFunction.countData("students"));
        T_Course = Integer.toString(MyFunction.countData("course"));
        try {
            writedata();
        } catch (IOException ex) {
            Logger.getLogger(loging.class.getName()).log(Level.SEVERE, null, ex);
        }

        cc.setText("Total Students : " + Integer.toString(MyFunction.countData("students")));
        cs.setText("Available Courses : " + Integer.toString(MyFunction.countData("course")));

    }

//    private Scanner x;
//
//    public void openFile() {
//        try {
//            x = new Scanner(file);//new Scanner(new File("B.txt"));
//        } catch (Exception e) {
//            System.out.println(" File not found ");
//        }
//    }
//
//    public void readFile() {
//        while (x.hasNext()) {
//            status = x.next();
////          System.out.printf("%s %s %s\n ", status);  
//        }
//
//    }
//
//    public void closeFile() {
//        x.close();
//    }
//    private void writedata() throws IOException {
//        BufferedWriter buf = null;
//        try {
//            buf = new BufferedWriter(new FileWriter(file));
//            buf.write(String.valueOf(Emp.empId));
//            buf.newLine();
//
//            System.out.println(" Congratulation Data Saving Successfull !" + Emp.empId);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (buf != null) {
//                buf.close();
//            }
//        }
//    }
    public void currentDate() {

        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);

//        lblDATE.setText((month + 1) + "/" + day + "/" + year);
        //Time
        int second = cal.get(Calendar.SECOND);
        int minute = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR);

        //lblTIME.setText(hour+":"+(minute)+":"+second);
    }

}
