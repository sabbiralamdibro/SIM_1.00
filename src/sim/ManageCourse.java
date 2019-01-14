package sim;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.io.IOException;
import static java.nio.file.Files.list;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.util.Duration.hours;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import static sim.manageStudent3.jTable_Display_User;

public class ManageCourse extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    course c = new course();
    AddModule ac = new AddModule();

    public ManageCourse() {
        initComponents();
        Update_table3();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2,
                size.height / 2 - getHeight() / 2);
        CourseID.setVisible(false);
        c.displayCourseTable(jTable_Course);
        loadScheduleList(SCHEDULE);
        loadModuleList(batch_nameC);
        loadComboLABEL(searchLabel);
        jTable_Course.setBackground(new Color(0, 0, 0, 0));
        ((DefaultTableCellRenderer) jTable_Course.getDefaultRenderer(Object.class)).setBackground(new Color(0, 0, 0, 0));

        jTable_Course.setGridColor(Color.RED);
        jTable_Course.setForeground(Color.BLACK);
        jTable_Course.setOpaque(false);
        jTable_Course.setOpaque(false);
        ((DefaultTableCellRenderer) jTable_Course.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);

    }

    private void Update_table3() {
        try {

            conn = connectionDB.connection_DB();
            String sql = "select * from course";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable_Course.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));

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

    private void SearchCOURCElabel() {
        String getlabel = searchLabel.getSelectedItem().toString();
        try {

            conn = connectionDB.connection_DB();
            String sql = "SELECT * FROM course where label='" + getlabel + "'";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable_Course.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));

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
            String sql = "SELECT * FROM course";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable_Course.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));

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
        jPanel2 = new javax.swing.JPanel();
        CourseID = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jSpinnerHours = new javax.swing.JSpinner();
        btnREMOVEcourseData = new javax.swing.JButton();
        BTN_addStU1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Course = new javax.swing.JTable();
        BTN_UpdateCourse = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        CourseLabel = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        FEES = new javax.swing.JTextField();
        SCHEDULE = new javax.swing.JComboBox<>();
        BTNreset = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        MODULE = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        batch_nameC = new javax.swing.JComboBox<>();
        searchLabel = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btn_backHome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
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

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));

        CourseID.setEditable(false);
        CourseID.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        CourseID.setToolTipText("enter first name");
        CourseID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CourseIDActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Hours");

        jSpinnerHours.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jSpinnerHours.setModel(new javax.swing.SpinnerNumberModel(200, 200, 1500, 10));

        btnREMOVEcourseData.setBackground(new java.awt.Color(255, 0, 51));
        btnREMOVEcourseData.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnREMOVEcourseData.setText("Remove");
        btnREMOVEcourseData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnREMOVEcourseDataActionPerformed(evt);
            }
        });

        BTN_addStU1.setBackground(new java.awt.Color(51, 176, 50));
        BTN_addStU1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        BTN_addStU1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/20px/icons8_Add_20px_1.png"))); // NOI18N
        BTN_addStU1.setText("Add");
        BTN_addStU1.setToolTipText("click here to add new student");
        BTN_addStU1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_addStU1ActionPerformed(evt);
            }
        });

        jTable_Course.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable_Course.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_Course.setRowHeight(40);
        jTable_Course.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jTable_Course.setSelectionForeground(new java.awt.Color(255, 0, 51));
        jTable_Course.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_CourseMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Course);

        BTN_UpdateCourse.setBackground(new java.awt.Color(204, 255, 204));
        BTN_UpdateCourse.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        BTN_UpdateCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/20px/icons8_Add_20px_1.png"))); // NOI18N
        BTN_UpdateCourse.setText("Update");
        BTN_UpdateCourse.setToolTipText("click here to add new student");
        BTN_UpdateCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_UpdateCourseActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Label");

        CourseLabel.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        CourseLabel.setToolTipText("");
        CourseLabel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CourseLabelKeyReleased(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Fees");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Batch Name");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Total Module");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Schedule");

        FEES.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        FEES.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FEESKeyTyped(evt);
            }
        });

        SCHEDULE.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SCHEDULE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "item 1", "item 2" }));
        SCHEDULE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SCHEDULEMouseClicked(evt);
            }
        });
        SCHEDULE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SCHEDULEActionPerformed(evt);
            }
        });

        BTNreset.setBackground(new java.awt.Color(153, 255, 204));
        BTNreset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BTNreset.setText("Reset");
        BTNreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNresetActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 102, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_FINAL/icons8_Edit_12px.png"))); // NOI18N
        jLabel2.setOpaque(true);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.orange, java.awt.Color.orange, java.awt.Color.orange, java.awt.Color.orange));

        jLabel1.setIcon(new javax.swing.ImageIcon("E:\\img\\Course-Information-Carousel.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        MODULE.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel3.setBackground(new java.awt.Color(0, 102, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_FINAL/icons8_Edit_12px.png"))); // NOI18N
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        batch_nameC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        batch_nameC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        batch_nameC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                batch_nameCMouseClicked(evt);
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

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Search Cource");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CourseLabel)
                                    .addComponent(FEES)
                                    .addComponent(SCHEDULE, 0, 258, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jSpinnerHours, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(CourseID, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(MODULE)
                                    .addComponent(batch_nameC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(BTN_addStU1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BTN_UpdateCourse)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnREMOVEcourseData)
                                .addGap(28, 28, 28)
                                .addComponent(BTNreset, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CourseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerHours, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CourseID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FEES, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batch_nameC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(MODULE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SCHEDULE, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_addStU1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_UpdateCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnREMOVEcourseData, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNreset, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1))
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setFont(new java.awt.Font("Snap ITC", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("M a n a g e   C o u r s e   D e t a i l s");
        jLabel5.setOpaque(true);

        btn_backHome.setBackground(new java.awt.Color(255, 255, 255));
        btn_backHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/navigateIMG/icons8_Rewind_64px.png"))); // NOI18N
        btn_backHome.setToolTipText("back to home page ");
        btn_backHome.setOpaque(true);
        btn_backHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_backHomeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_backHomeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_backHomeMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btn_backHome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btn_backHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btn_backHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backHomeMouseClicked
        AdminHome hw = new AdminHome();
        this.dispose();
        hw.setVisible(true);


    }//GEN-LAST:event_btn_backHomeMouseClicked

    private void btn_backHomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backHomeMousePressed
        btn_backHome.setBackground(new Color(139, 238, 178));
    }//GEN-LAST:event_btn_backHomeMousePressed

    private void btn_backHomeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backHomeMouseReleased
        btn_backHome.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btn_backHomeMouseReleased

    private void btnREMOVEcourseDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnREMOVEcourseDataActionPerformed
        int confrm = JOptionPane.showConfirmDialog(null, "Are you sure to delete ?", "Delete", JOptionPane.YES_NO_OPTION);
        if (confrm == 0) {
            try {

                int id = Integer.valueOf(CourseID.getText());
                double fees = Double.valueOf(FEES.getText().toString());
                fees = Double.NaN;
                c.insertUpdateDeleteCourse('d', id, null, null, fees, null, null, null);
//                ManageCourse.jTable_Course.setModel(new DefaultTableModel(null, new Object[]{"id", "label", "hours_number", "fees", "batch_name", "module", "schedule"}));
//                c.displayCourseTable(ManageCourse.jTable_Course);
//                cleanField();
                Update_table3();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Select one to Delete data");
                System.out.println(e.getMessage());
            }

        }

    }//GEN-LAST:event_btnREMOVEcourseDataActionPerformed
    private void getdata() {
        double fees = 0.00;
//        boolean isnewM = MODULE.getSelectedIndex() < 0;
        boolean isnewS = SCHEDULE.getSelectedIndex() < 0;
        String label = CourseLabel.getText();
        int hours_number = Integer.valueOf(jSpinnerHours.getValue().toString());
        try {
            fees = Double.parseDouble(FEES.getText());
        } catch (NumberFormatException e) {
            e.getMessage();
        }

        String batch_name = batch_nameC.getSelectedItem().toString();

        String module = MODULE.getText();
        String schedule = SCHEDULE.getSelectedItem().toString();
//        if (isnewM) {
//            module = MODULE.getSelectedItem().toString();
//
//        }
        if (isnewS) {
            schedule = SCHEDULE.getSelectedItem().toString();
//            saveModule(MODULE.getSelectedItem().toString());

        }

    }


    private void BTN_addStU1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_addStU1ActionPerformed
//id, label, hours_number, fees, batch_name, module, schedule
        double fees = 0.00;
//        boolean isnewM = MODULE.getSelectedIndex() < 0;
        boolean isnewS = SCHEDULE.getSelectedIndex() < 0;
        String label = CourseLabel.getText();

//        if (isnewM) {
//            getdata();
//            saveModule(MODULE.getSelectedItem().toString());
//        }
        if (!c.isBatchExist(batch_nameC.getSelectedItem().toString())) {

            int hours_number = Integer.valueOf(jSpinnerHours.getValue().toString());
            try {
                fees = Double.parseDouble(FEES.getText());
            } catch (NumberFormatException e) {
                e.getMessage();
            }

            String batch_name = batch_nameC.getSelectedItem().toString();

            String module = MODULE.getText();
            String schedule = SCHEDULE.getSelectedItem().toString();
//            if (isnewM) {
////                module = MODULE.getSelectedItem().toString();
////
//            }
            if (isnewS) {
                schedule = SCHEDULE.getSelectedItem().toString();
//                saveModule(MODULE.getSelectedItem().toString());

            }

            if (courseVerifier()) {
//                saveModule(MODULE.getSelectedItem().toString());
                c.insertUpdateDeleteCourse('i', null, label, hours_number, fees, batch_name, module, schedule);

                HomeWindow hw = new HomeWindow();
                hw.cc.setText("Available Courses : " + Integer.toString(MyFunction.countData("course")));
                saveMod(MODULE.getText());
//                ManageCourse.jTable_Course.setModel(new DefaultTableModel(null, new Object[]{"id", "label", "hours_number", "fees", "batch_name", "module", "schedule"}));
//                c.displayCourseTable(ManageCourse.jTable_Course);
                Update_table3();
                cleanField();
            }

        } else {
            JOptionPane.showMessageDialog(null, " Batch name already Exist");

        }

//        try {
//            AddCourse1 addCrs = new AddCourse1();
//            addCrs.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//            addCrs.setVisible(true);
//            
////            this.setExtendedState(ICONIFIED);
//               this.setVisible(false);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } 

    }//GEN-LAST:event_BTN_addStU1ActionPerformed

    private void BTN_UpdateCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_UpdateCourseActionPerformed
        double fees = 0.00;
        int confrm = JOptionPane.showConfirmDialog(null, "Are you sure to Update ?", "Update", JOptionPane.YES_NO_OPTION);
        if (confrm == 0) {
//            try {
//
////                if (!c.isCourseExist(CourseLabel.getText())) {
//                int hours_number = Integer.valueOf(jSpinnerHours.getValue().toString());
//                try {
//                    fees = Double.parseDouble(FEES.getText());
//                } catch (NumberFormatException e) {
//                    e.getMessage();
//                }
//
//                String batch_name = batch_nameC.getSelectedItem().toString();
//
//                String module = MODULE.getText();
//                String schedule = SCHEDULE.getSelectedItem().toString();
//                System.out.println(schedule);
//                int id = Integer.valueOf(CourseID.getText());
//                String label = CourseLabel.getText();
//                int hours = Integer.valueOf(jSpinnerHours.getValue().toString());
////id, label, hours_number, fees, batch_name, module, schedule
//                   String querrySC = "UPDATE student_ms.course set label ='" + label + "', hours_number ='" + hours_number + "', fees ='" + fees + "', batch_name ='" + batch_name + "', module ='" + module + "', schedule ='" + schedule + "' WHERE id='" + id + "'  ";
//                    Connection con = connectionDB.connection_DB();
//                   PreparedStatement pst = con.prepareStatement(querrySC);
//                   if (pst.executeUpdate() > 0) {
//
//                    JOptionPane.showMessageDialog(null, "Data updated");
//                }
////                c.insertUpdateDeleteCourse('u', id, label, hours_number, fees, batch_name, module, schedule);
////                HomeWindow hw = new HomeWindow();
////                hw.cc.setText("Available Courses : " + Integer.toString(MyFunction.countData("course")));
//                ManageCourse.jTable_Course.setModel(new DefaultTableModel(null, new Object[]{"id", "label", "hours_number", "fees", "batch_name", "module", "schedule"}));
//                c.displayCourseTable(ManageCourse.jTable_Course);
//                cleanField();
////                  JOptionPane.showMessageDialog(null, "Course data Updated");
//
////                }
////                else {
////                    JOptionPane.showMessageDialog(null, "Course already Exist");
////
////                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }

//            try {
//              if (courseVerifier()) {
//
//                    int id = Integer.valueOf(CourseID.getText());
//                    String label = CourseLabel.getText();
//                    int hours_number = Integer.valueOf(jSpinnerHours.getValue().toString());
//                    double fees = Double.parseDouble(FEES.getText());
//                    String batch_name = BATCHNAME.getText();
//                    String module = MODULE.getText();
//                    String schedule = SCHEDULE.getSelectedItem().toString();
//
//                    String querrySC = "UPDATE course SET label='" + label + "', hours_number='" + hours_number + "',fees='" + fees + "', batch_name='" + batch_name + "', module='" + module + "', schedule='" + schedule + "' WHERE id ='" + id + "' ";
//                    Connection con = connectionDB.connection_DB();
//                    PreparedStatement pst = con.prepareStatement(querrySC);
//                    pst.executeUpdate();
//                 if (pst.executeUpdate() > 0) {
//
//                    JOptionPane.showMessageDialog(null, "Course data Updated");
//                } 
//                    
//                    
//                    
//                    
//                    HomeWindow hw = new HomeWindow();
//                    hw.cc.setText("Available Courses : " + Integer.toString(MyFunction.countData("course")));
//
//                    
//                    ManageCourse.jTable_Course.setModel(new DefaultTableModel(null, new Object[]{"id", "label", "hours_number", "fees", "batch_name", "module", "schedule"}));
//                    c.displayCourseTable(ManageCourse.jTable_Course);
//                    cleanField();
//                
//
//            }
//
//            } catch (Exception e) {
//            }
            try {
                //id, label, hours_number, fees, batch_name, module, schedule

                int id = Integer.valueOf(CourseID.getText());

//        boolean isnewM = MODULE.getSelectedIndex() < 0;
                boolean isnewS = SCHEDULE.getSelectedIndex() < 0;
                String label = CourseLabel.getText();

//        if (isnewM) {
//            getdata();
//            saveModule(MODULE.getSelectedItem().toString());
//        }
//        if (!c.isBatchExist(batch_nameC.getSelectedItem().toString())) {
                int hours_number = Integer.valueOf(jSpinnerHours.getValue().toString());
                try {
                    fees = Double.parseDouble(FEES.getText());
                } catch (NumberFormatException e) {
                    e.getMessage();
                }

                String batch_name = batch_nameC.getSelectedItem().toString();

                String module = MODULE.getText();
                String schedule = SCHEDULE.getSelectedItem().toString();
//            if (isnewM) {
////                module = MODULE.getSelectedItem().toString();
////
//            }
                if (isnewS) {
                    schedule = SCHEDULE.getSelectedItem().toString();
//                saveModule(MODULE.getSelectedItem().toString());

                }

                if (courseVerifier()) {
//                saveModule(MODULE.getSelectedItem().toString());
//                c.insertUpdateDeleteCourse('i', null, label, hours_number, fees, batch_name, module, schedule);
                    String querrySC = "UPDATE course SET label='" + label + "', hours_number='" + hours_number + "',fees='" + fees + "', batch_name='" + batch_name + "', module='" + module + "', schedule='" + schedule + "' WHERE id ='" + id + "' ";
                    Connection con = connectionDB.connection_DB();
                    PreparedStatement pst = con.prepareStatement(querrySC);
                    pst.executeUpdate();
                    if (pst.executeUpdate() > 0) {

                        JOptionPane.showMessageDialog(null, "Course data Updated");
                    }
                    HomeWindow hw = new HomeWindow();
                    hw.cc.setText("Available Courses : " + Integer.toString(MyFunction.countData("course")));
                    saveMod(MODULE.getText());
                    Update_table3();
//                    ManageCourse.jTable_Course.setModel(new DefaultTableModel(null, new Object[]{"id", "label", "hours_number", "fees", "batch_name", "module", "schedule"}));
//                    c.displayCourseTable(ManageCourse.jTable_Course);
                    cleanField();
                }

//        } else {
//            JOptionPane.showMessageDialog(null, " Batch name already Exist");
//
//        }
            } catch (SQLException e) {
            }

        }


    }//GEN-LAST:event_BTN_UpdateCourseActionPerformed
    boolean courseVerifier() {
        //id, label, hours_number, fees, batch_name, module, schedule

        String time = jSpinnerHours.getValue().toString();
        int Ctime = Integer.valueOf(time);

        if (CourseLabel.getText().isEmpty() || Ctime == 0 || FEES.getText().isEmpty() || batch_nameC.getSelectedIndex() == 0 || MODULE.getText().isEmpty() || SCHEDULE.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "One ore more fields are empty");
            return false;

        } else {

            return true;
        }

    }


    private void CourseIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CourseIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CourseIDActionPerformed
    private void cleanField() {
        CourseID.setText("");
        FEES.setText("");
        CourseLabel.setText("");
        batch_nameC.setSelectedIndex(0);
        jSpinnerHours.setValue(0);
        MODULE.setText("");
        SCHEDULE.setSelectedIndex(0);

    }
    private void FEESKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FEESKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_FEESKeyTyped

    private void BTNresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNresetActionPerformed
        cleanField();
    }//GEN-LAST:event_BTNresetActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        AddSchedule am = new AddSchedule();
        am.setVisible(true);
        am.setLocationRelativeTo(null);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus

loadComboLABEL(searchLabel);


//        loadScheduleList(SCHEDULE);
//        loadModuleList(batch_nameC);

    }//GEN-LAST:event_formWindowGainedFocus

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
//        loadScheduleList(SCHEDULE);
//        loadModuleList(batch_nameC);
    }//GEN-LAST:event_formWindowLostFocus

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

         AdminHome ap = new AdminHome();
                ap.setVisible(true);
                ap.pack();
                this.setVisible(false);


    }//GEN-LAST:event_formWindowClosing

    private void SCHEDULEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SCHEDULEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SCHEDULEActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        AddModule batch = new AddModule();
        batch.setVisible(true);
        batch.setLocationRelativeTo(null);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void batch_nameCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_batch_nameCMouseClicked

        loadScheduleList(SCHEDULE);
        loadModuleList(batch_nameC);

    }//GEN-LAST:event_batch_nameCMouseClicked

    private void SCHEDULEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SCHEDULEMouseClicked
        loadScheduleList(SCHEDULE);
        loadModuleList(batch_nameC);
    }//GEN-LAST:event_SCHEDULEMouseClicked

    private void searchLabelPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_searchLabelPopupMenuWillBecomeInvisible
        if (searchLabel.getSelectedIndex() == 0) {
            DETAILS1();
             cleanField();

        } else {
            SearchCOURCElabel();
        }
    }//GEN-LAST:event_searchLabelPopupMenuWillBecomeInvisible

    private void jTable_CourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_CourseMouseClicked

        int index = jTable_Course.getSelectedRow();
        CourseID.setText(jTable_Course.getValueAt(index, 0).toString());
        CourseLabel.setText(jTable_Course.getValueAt(index, 1).toString());
        jSpinnerHours.setValue(Integer.valueOf(jTable_Course.getValueAt(index, 2).toString()));
        FEES.setText(jTable_Course.getValueAt(index, 3).toString());
        batch_nameC.setSelectedItem(jTable_Course.getValueAt(index, 4).toString());

        MODULE.setText(jTable_Course.getValueAt(index, 5).toString());
        SCHEDULE.setSelectedItem(jTable_Course.getValueAt(index, 6).toString());

    }//GEN-LAST:event_jTable_CourseMouseClicked

    private void CourseLabelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CourseLabelKeyReleased
        if (CourseLabel.getText().isEmpty()) {
             cleanField();
        }
    }//GEN-LAST:event_CourseLabelKeyReleased

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
            java.util.logging.Logger.getLogger(ManageCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageCourse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_UpdateCourse;
    private javax.swing.JButton BTN_addStU1;
    private javax.swing.JButton BTNreset;
    private javax.swing.JTextField CourseID;
    private javax.swing.JTextField CourseLabel;
    private javax.swing.JTextField FEES;
    private javax.swing.JTextField MODULE;
    private javax.swing.JComboBox<String> SCHEDULE;
    private javax.swing.JComboBox<String> batch_nameC;
    private javax.swing.JButton btnREMOVEcourseData;
    private javax.swing.JLabel btn_backHome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerHours;
    public static javax.swing.JTable jTable_Course;
    private javax.swing.JComboBox<String> searchLabel;
    // End of variables declaration//GEN-END:variables
    public void loadModuleList(JComboBox combo) {

        Connection conn = null;
        ResultSet rs = null;
        CallableStatement cst = null;

        try {
            conn = connectionDB.connection_DB();

            cst = conn.prepareCall("{CALL listBatchName()}");
            cst.execute();
            rs = cst.getResultSet();
            List MList = new ArrayList();

            while (rs.next()) {
                MList.add(rs.getString(1));

            }

            combo.setModel(new DefaultComboBoxModel(MList.toArray()));
            combo.insertItemAt("--Choose One--", 0);
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

    public void loadScheduleList(JComboBox combo) {

        Connection conn = null;
        ResultSet rs = null;
        CallableStatement cst = null;

        try {
            conn = connectionDB.connection_DB();

            cst = conn.prepareCall("{CALL listSCHEDULE()}");
            cst.execute();
            rs = cst.getResultSet();
            List sch_lList = new ArrayList();

            while (rs.next()) {
                sch_lList.add(rs.getString(1));

            }

            combo.setModel(new DefaultComboBoxModel(sch_lList.toArray()));
            combo.insertItemAt("--Choose One--", 0);
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

    public static void saveMod(String mod) {

        Connection con = null;
        CallableStatement csmt = null;

        try {
            con = connectionDB.connection_DB();
            csmt = con.prepareCall("{CALL saveModule(?)}");
            csmt.setString(1, mod);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                csmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ManageCourse.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public static boolean saveModule(String mod) {
        Connection con = null;
        CallableStatement csmt = null;
        boolean t = true;
        try {
            con = connectionDB.connection_DB();
            csmt = con.prepareCall("{CALL saveModule(?)}");
            csmt.setString(1, mod);
            t = csmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                csmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ManageCourse.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return t;

    }

//    @Override
//    public void windowGainedFocus(WindowEvent e) {
//
//        loadModuleList(MODULE);
//    }
//
//    @Override
//    public void windowLostFocus(WindowEvent e) {
//        loadModuleList(MODULE);
//    }
//
//    @Override
//    public void windowOpened(WindowEvent e) {
//        loadModuleList(MODULE);
//    }
//
//    @Override
//    public void windowClosing(WindowEvent e) {
//        loadModuleList(MODULE);
//    }
//
//    @Override
//    public void windowClosed(WindowEvent e) {
//        loadModuleList(MODULE);
//    }
//
//    @Override
//    public void windowIconified(WindowEvent e) {
//        loadModuleList(MODULE);
//    }
//
//    @Override
//    public void windowDeiconified(WindowEvent e) {
//        loadModuleList(MODULE);
//    }
//
//    @Override
//    public void windowActivated(WindowEvent e) {
//        loadModuleList(MODULE);
//    }
//
//    @Override
//    public void windowDeactivated(WindowEvent e) {
//        loadModuleList(MODULE);
//    }
//
//    @Override
//    public void windowStateChanged(WindowEvent e) {
//        loadModuleList(MODULE);
//    }
    //JComboBox combo
}
