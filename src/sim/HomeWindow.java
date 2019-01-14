/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim;

import java.awt.*;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import sim.admin.ADminLoging;
//import students.AddNewStudent;

/**
 *
 * @author r36
 */
public class HomeWindow extends javax.swing.JFrame {

    File file = new File("userID.txt");
    File file2 = new File("userN.txt");
    File file3 = new File("totalStudent.txt");
    File file4 = new File("totalCourse.txt");

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    private ImageIcon format = null;
    //strin filename
    String filename = null;
    byte[] person_image = null;
    public Scanner getid;
    public Scanner x;
    public Scanner y;
    public Scanner z;
    String status = "";
    String status2 = "";
    String status3 = "";
    String userid = "";

    public HomeWindow() {
        initComponents();
        showTime();
        cc.setText("Total Students : " + Integer.toString(MyFunction.countData("students")));
        cs.setText("Available Courses : " + Integer.toString(MyFunction.countData("course")));

        currentDate();
        openFile();
        readFile();
        closeFile();
        lbluser.setText("You are loged as  " + status);
//        cc.setText("Total Students : "+status2);
//        cs.setText("Available Courses : "+status3);
        closeFile();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2,
                size.height / 2 - getHeight() / 2);

    }

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
            getid = new Scanner(file);
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
        while (getid.hasNext()) {
            userid = getid.next();

        }

    }

    public void closeFile() {
        x.close();
        y.close();
        z.close();
        getid.close();

    }

//     void showDate() {
//        Date d = new Date();
//        SimpleDateFormat s = new SimpleDateFormat("yyy-MM-dd");
//        TIMESHOW.setText(s.format(d));
//    }
    void showTime() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
                TIMESHOW.setText(s.format(d));
            }
        }).start();

    }

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

        lblDATE.setText((month + 1) + "/" + day + "/" + year);

        //Time
        int second = cal.get(Calendar.SECOND);
        int minute = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR);

        //lblTIME.setText(hour+":"+(minute)+":"+second);
    }

//    public static void dialougeOpen() {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                AddNewStudwntDialog frame = new AddNewStudwntDialog();
//                frame.setVisible(true);
//            }
//        });
//
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GENDER = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbl_logout = new javax.swing.JLabel();
        lblDATE = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        containermenue = new javax.swing.JPanel();
        Mng_Student = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Student_Status = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        adminMENUE = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        Student_Status3 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        Mng_Student1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cc = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        cs = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        TIMESHOW = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("S t U d E n T    I n f o r M a t I o N    S y s T e M");
        setSize(new java.awt.Dimension(1000, 800));
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jPanel5.setBackground(new java.awt.Color(51, 0, 51));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/homeIcons/menu/icons8_UNHCR_48px_1.png"))); // NOI18N

        lbluser.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        lbluser.setForeground(new java.awt.Color(255, 255, 255));

        lbl_logout.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbl_logout.setForeground(new java.awt.Color(153, 255, 255));
        lbl_logout.setText("logout ?");
        lbl_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_logoutMouseClicked(evt);
            }
        });

        lblDATE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDATE.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("S t U d E n T    I n f o r M a t I o N    S y s T e M");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lbluser, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_logout))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(173, 173, 173)
                        .addComponent(lblDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbluser, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        containermenue.setBackground(new java.awt.Color(0, 0, 0));

        Mng_Student.setBackground(new java.awt.Color(255, 255, 255));
        Mng_Student.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Mng_StudentMouseClicked(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 0, 51));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Manage Registration");
        jLabel10.setOpaque(true);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgMenue/icons8_Database_Administrator_75px_1.png"))); // NOI18N
        jLabel11.setOpaque(true);

        javax.swing.GroupLayout Mng_StudentLayout = new javax.swing.GroupLayout(Mng_Student);
        Mng_Student.setLayout(Mng_StudentLayout);
        Mng_StudentLayout.setHorizontalGroup(
            Mng_StudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Mng_StudentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        Mng_StudentLayout.setVerticalGroup(
            Mng_StudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Mng_StudentLayout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addContainerGap())
        );

        Student_Status.setBackground(new java.awt.Color(255, 255, 255));
        Student_Status.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Student_StatusMouseClicked(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(255, 0, 51));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Manage Course Details ");
        jLabel18.setOpaque(true);

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgMenue/icons8_Business_Building_75px.png"))); // NOI18N
        jLabel19.setOpaque(true);

        javax.swing.GroupLayout Student_StatusLayout = new javax.swing.GroupLayout(Student_Status);
        Student_Status.setLayout(Student_StatusLayout);
        Student_StatusLayout.setHorizontalGroup(
            Student_StatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
            .addGroup(Student_StatusLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Student_StatusLayout.setVerticalGroup(
            Student_StatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Student_StatusLayout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        adminMENUE.setBackground(new java.awt.Color(255, 255, 255));
        adminMENUE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminMENUEMouseClicked(evt);
            }
        });

        jLabel22.setBackground(new java.awt.Color(255, 0, 51));
        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Admin");
        jLabel22.setOpaque(true);

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgMenue/icons8_Admin_Settings_Male_75px.png"))); // NOI18N
        jLabel23.setOpaque(true);

        javax.swing.GroupLayout adminMENUELayout = new javax.swing.GroupLayout(adminMENUE);
        adminMENUE.setLayout(adminMENUELayout);
        adminMENUELayout.setHorizontalGroup(
            adminMENUELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(adminMENUELayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        adminMENUELayout.setVerticalGroup(
            adminMENUELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminMENUELayout.createSequentialGroup()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        Student_Status3.setBackground(new java.awt.Color(255, 255, 255));
        Student_Status3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Student_Status3MouseClicked(evt);
            }
        });

        jLabel26.setBackground(new java.awt.Color(255, 0, 51));
        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("View/Print Details");
        jLabel26.setOpaque(true);

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setIcon(new javax.swing.ImageIcon("E:\\rmake\\SIM_1.00\\img\\57-128.png")); // NOI18N
        jLabel27.setOpaque(true);

        javax.swing.GroupLayout Student_Status3Layout = new javax.swing.GroupLayout(Student_Status3);
        Student_Status3.setLayout(Student_Status3Layout);
        Student_Status3Layout.setHorizontalGroup(
            Student_Status3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Student_Status3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addContainerGap())
        );
        Student_Status3Layout.setVerticalGroup(
            Student_Status3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Student_Status3Layout.createSequentialGroup()
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Mng_Student1.setBackground(new java.awt.Color(255, 255, 255));
        Mng_Student1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Mng_Student1MouseClicked(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(255, 0, 51));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Manage Fees");
        jLabel12.setOpaque(true);

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgMenue/icons8_Database_Administrator_75px_1.png"))); // NOI18N
        jLabel13.setOpaque(true);

        javax.swing.GroupLayout Mng_Student1Layout = new javax.swing.GroupLayout(Mng_Student1);
        Mng_Student1.setLayout(Mng_Student1Layout);
        Mng_Student1Layout.setHorizontalGroup(
            Mng_Student1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Mng_Student1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );
        Mng_Student1Layout.setVerticalGroup(
            Mng_Student1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Mng_Student1Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout containermenueLayout = new javax.swing.GroupLayout(containermenue);
        containermenue.setLayout(containermenueLayout);
        containermenueLayout.setHorizontalGroup(
            containermenueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containermenueLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(adminMENUE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(Mng_Student, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(Student_Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(Mng_Student1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(Student_Status3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        containermenueLayout.setVerticalGroup(
            containermenueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containermenueLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(containermenueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Student_Status3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(containermenueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Mng_Student1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(adminMENUE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Mng_Student, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Student_Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(containermenue);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.darkGray));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        cc.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(cc, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(341, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(cc, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        cs.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cs, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(cs, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(204, 255, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.CardLayout());

        TIMESHOW.setBackground(new java.awt.Color(255, 255, 102));
        TIMESHOW.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        TIMESHOW.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(TIMESHOW, "card2");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(417, 417, 417)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(405, 405, 405))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(46, 46, 46)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/stu (7).png"))); // NOI18N
        jMenu3.setText("Manage");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuItem2.setText("Registration");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem9.setText("Course");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuItem10.setText("Fees");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuBar1.add(jMenu3);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/stu (7).png"))); // NOI18N
        jMenu6.setText("Admin");
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
        });
        jMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu6ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1151, 712));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_logoutMouseClicked

        int confirmLogout = JOptionPane.showConfirmDialog(null, "Do you really want to logout ?", "logout !", JOptionPane.YES_NO_OPTION);

        if (confirmLogout == 0) {

            try {
                Date currentDate = GregorianCalendar.getInstance().getTime();
                DateFormat df = DateFormat.getDateInstance();
                String dateString = df.format(currentDate);

                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String timeString = sdf.format(d);

                String value0 = timeString;
                String values = dateString;
                String logout = "Logged out";
                conn = connectionDB.connection_DB();

//                    Emp e = new Emp();
//                    int userid=Emp.empId;
//                String value = status;   //------------------------------------------------------------------------
//                String value = String.valueOf(Emp.empId);
                String reg = "INSERT into userlog (emp_id,date,status) VALUES (?,?,?)";
                pst = conn.prepareStatement(reg);
                pst.setString(1, userid);
                pst.setString(2, value0 + " / " + values);
                pst.setString(3, logout);
                pst.execute();

            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                loging j = new loging();
                this.dispose();
                j.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(HomeWindow.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

        }


    }//GEN-LAST:event_lbl_logoutMouseClicked


    private void Mng_StudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Mng_StudentMouseClicked
        try {
            manageStudent3 mngMNT = new manageStudent3();
            mngMNT.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            mngMNT.setLocationRelativeTo(null);
            mngMNT.setVisible(true);
            //            this.setExtendedState(ICONIFIED);
            this.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_Mng_StudentMouseClicked


    private void Student_StatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Student_StatusMouseClicked
        try {
            ScoreManagement SCM = new ScoreManagement();
            SCM.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            SCM.setVisible(true);

//            this.setExtendedState(ICONIFIED);
            this.setVisible(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_Student_StatusMouseClicked

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        try {
            FeesView adM = new FeesView();
            adM.setVisible(true);
            adM.setExtendedState(MAXIMIZED_VERT);

            this.setVisible(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            manageStudent3 mngMNT = new manageStudent3();
            mngMNT.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            mngMNT.setLocationRelativeTo(null);
            mngMNT.setVisible(true);
            //            this.setExtendedState(ICONIFIED);
            this.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu6ActionPerformed

    private void adminMENUEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminMENUEMouseClicked

        try {
            ADminLoging adM = new ADminLoging();
            adM.setVisible(true);
            adM.setExtendedState(MAXIMIZED_VERT);

            this.setVisible(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
//        try {
//            AdminPanel adM = new AdminPanel();
//            adM.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//            adM.setVisible(true);
//
////            this.setExtendedState(ICONIFIED);
//            this.setVisible(false);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }//GEN-LAST:event_adminMENUEMouseClicked

    private void Student_Status3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Student_Status3MouseClicked

        try {
            ViewStudents_Status vss = new ViewStudents_Status();
            vss.setVisible(true);
            vss.setExtendedState(MAXIMIZED_VERT);
            this.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_Student_Status3MouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        int confirmLogout = JOptionPane.showConfirmDialog(null, "Do you really want to logout and exit ?", "logout !", JOptionPane.YES_NO_OPTION);

        if (confirmLogout == 0) {

            try {
                Date currentDate = GregorianCalendar.getInstance().getTime();
                DateFormat df = DateFormat.getDateInstance();
                String dateString = df.format(currentDate);

                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String timeString = sdf.format(d);

                String value0 = timeString;
                String values = dateString;
                String logout = "Logged out";
                conn = connectionDB.connection_DB();

//                    Emp e = new Emp();
//                    int userid=Emp.empId;
//                String value = status;   //------------------------------------------------------------------------
//                String value = String.valueOf(Emp.empId);
                String reg = "INSERT into userlog (emp_id,date,status) VALUES (?,?,?)";
                pst = conn.prepareStatement(reg);
                pst.setString(1, userid);
                pst.setString(2, value0 + " / " + values);
                pst.setString(3, logout);
                pst.execute();

            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                loging j = new loging();
                this.dispose();
                j.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(HomeWindow.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

        }


    }//GEN-LAST:event_formWindowClosing

    private void Mng_Student1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Mng_Student1MouseClicked

        //FeesView
        try {
            FeesView adM = new FeesView();
            adM.setVisible(true);
            adM.setExtendedState(MAXIMIZED_VERT);

            this.setVisible(false);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_Mng_Student1MouseClicked

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        cc.setText("Total Students : " + Integer.toString(MyFunction.countData("students")));
        cs.setText("Available Courses : " + Integer.toString(MyFunction.countData("course")));
    }//GEN-LAST:event_formWindowGainedFocus

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        cc.setText("Total Students : " + Integer.toString(MyFunction.countData("students")));
        cs.setText("Available Courses : " + Integer.toString(MyFunction.countData("course")));
    }//GEN-LAST:event_formWindowLostFocus

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
              try {
            FeesView adM = new FeesView();
            adM.setVisible(true);
            adM.setExtendedState(MAXIMIZED_VERT);

            this.setVisible(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
                try {
            ScoreManagement SCM = new ScoreManagement();
            SCM.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            SCM.setVisible(true);

//            this.setExtendedState(ICONIFIED);
            this.setVisible(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
                try {
            ADminLoging adM = new ADminLoging();
            adM.setVisible(true);
            adM.setExtendedState(MAXIMIZED_VERT);

            this.setVisible(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
//        t
    }//GEN-LAST:event_jMenu6MouseClicked

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
                new HomeWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GENDER;
    private javax.swing.JPanel Mng_Student;
    private javax.swing.JPanel Mng_Student1;
    private javax.swing.JPanel Student_Status;
    private javax.swing.JPanel Student_Status3;
    private javax.swing.JLabel TIMESHOW;
    private javax.swing.JPanel adminMENUE;
    public static javax.swing.JLabel cc;
    private javax.swing.JPanel containermenue;
    public static javax.swing.JLabel cs;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDATE;
    private javax.swing.JLabel lbl_logout;
    public final javax.swing.JLabel lbluser = new javax.swing.JLabel();
    // End of variables declaration//GEN-END:variables
}
