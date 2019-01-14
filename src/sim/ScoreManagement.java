package sim;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import static sim.manageStudent3.FEES;

public class ScoreManagement extends javax.swing.JFrame {

    int y[];
    course c = new course();

    double parcentage = 0.00;
    int EMARK = 0;
    int WMARK = 0;

    public ScoreManagement() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2,
                size.height / 2 - getHeight() / 2);
        show_Score();
        student std = new student();
        std.loadComboBatch(BATCHNAME);
        idx.setVisible(false);
        std.loadComboLABEL(COURSELABEL);
//        c.displayCourseTable(jTable_Course);  loadComboLABEL(COURSELABEL);
        sum();

        jCombo_EXAM_IDX.insertItemAt("--Choose One--", 0);
        jCombo_EXAM_IDX.setSelectedIndex(0);
        jTable_Display_User.setBackground(new Color(0, 0, 0, 0));
        ((DefaultTableCellRenderer) jTable_Display_User.getDefaultRenderer(Object.class)).setBackground(new Color(0, 0, 0, 0));

        jTable_Display_User.setGridColor(Color.WHITE);
        jTable_Display_User.setForeground(Color.WHITE);
        jScrollPane1.setOpaque(false);
        jTable_Display_User.setOpaque(false);
        ((DefaultTableCellRenderer) jTable_Display_User.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);

    }

    //JComboBox combo
    public void resetMOduleCOMBo() {
        DefaultComboBoxModel mod = new DefaultComboBoxModel();
        jCombo_EXAM_IDX.setModel(mod);
        jCombo_EXAM_IDX.insertItemAt("--Choose One--", 0);
        jCombo_EXAM_IDX.setSelectedIndex(0);
    }

    public void loadModuleList() {

//        String batchName = (String) BATCHNAME.getSelectedItem();
        String crsid = crsID.getText();

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        int module = 0;
        DefaultComboBoxModel mod = new DefaultComboBoxModel();
        try {
            conn = connectionDB.connection_DB();
            String sql = "select module from course where id='" + crsid + "'";
            System.out.println(sql);
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {

                module = rs.getInt("module");

            }
            for (int i = 1; i <= module; i++) {

                jCombo_EXAM_IDX.insertItemAt(i + "", i);

            }

//            combo.setModel(new DefaultComboBoxModel(MList.toArray()));
//            jCombo_EXAM_IDX.insertItemAt("--Choose One--", 0);
//            jCombo_EXAM_IDX.setSelectedIndex(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                pst.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    boolean calcu() {
        boolean bool = true;
        if (!(emark.getText().isEmpty() || wmark.getText().isEmpty())) {
            sum();
            return bool;

        } else {

            bool = false;
        }

        return bool;
    }

    private void parcentageC() {
        double p = 0.00;
        try {
            int wM = Integer.valueOf(wmark.getText());
            int eM = Integer.valueOf(emark.getText());
            int sum = Integer.sum(wM, eM);
            int fm = Integer.valueOf(fmark.getText());

            p = (double) sum / fm * 100;
            p = Math.round(p * 100) / 100.0d;

            parcentageM.setText(String.valueOf(p));

        } catch (Exception e) {
            e.getMessage();
        }

    }

    private int sum() {
        int sum = 00;
        try {
            int wM = Integer.valueOf(wmark.getText());
            int eM = Integer.valueOf(emark.getText());
            sum = Integer.sum(wM, eM);

            tmark.setText(String.valueOf(sum));

        } catch (NumberFormatException e) {
            e.getMessage();
        }
        return sum;

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
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btn_backHome = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Display_User = new javax.swing.JTable();
        txtID = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        searchID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        BATCHNAME = new javax.swing.JComboBox<>();
        COURSELABEL = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jCombo_EXAM_IDX = new javax.swing.JComboBox<>();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        wmark = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        emark = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        fmark = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        tmark = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        parcentageM = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TXTremark = new javax.swing.JTextArea();
        CHECK = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        BTN_addStU1 = new javax.swing.JButton();
        btnUPDATE = new javax.swing.JButton();
        btnDELETE = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        crsID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        idx = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Manage Course  Details");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

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
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btn_backHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Student ID");

        jTable_Display_User.setBackground(new java.awt.Color(204, 255, 204));
        jTable_Display_User.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jTable_Display_User.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTable_Display_User.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Score Id", "Student Id", "Course ID", "Course Label", "Batch Name", "Exam Id", "Exam Date", "Full Marks", "Score(Written)", "Score(Evedence)", "Score(Total)", "Parcentage", "REMARKS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Display_User.setGridColor(new java.awt.Color(255, 255, 51));
        jTable_Display_User.setInheritsPopupMenu(true);
        jTable_Display_User.setRowHeight(40);
        jTable_Display_User.setSelectionBackground(new java.awt.Color(102, 255, 204));
        jTable_Display_User.setSelectionForeground(new java.awt.Color(0, 255, 255));
        jTable_Display_User.getTableHeader().setReorderingAllowed(false);
        jTable_Display_User.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Display_UserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Display_User);

        txtID.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        txtID.setToolTipText("");
        txtID.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtIDInputMethodTextChanged(evt);
            }
        });
        txtID.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtIDPropertyChange(evt);
            }
        });
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDKeyTyped(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 102));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search Student", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        searchID.setBackground(new java.awt.Color(255, 255, 204));
        searchID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        searchID.setForeground(new java.awt.Color(0, 0, 255));
        searchID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchIDKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchID, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(searchID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Course Label");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Batch Name");

        BATCHNAME.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BATCHNAME.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        BATCHNAME.setEnabled(false);
        BATCHNAME.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                BATCHNAMEItemStateChanged(evt);
            }
        });
        BATCHNAME.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                BATCHNAMEPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        COURSELABEL.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        COURSELABEL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        COURSELABEL.setEnabled(false);
        COURSELABEL.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                COURSELABELItemStateChanged(evt);
            }
        });
        COURSELABEL.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                COURSELABELPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        jLabel28.setBackground(new java.awt.Color(255, 255, 0));
        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Manage Student's Scores Details");
        jLabel28.setOpaque(true);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Exam ID(Module)");

        jLabel10.setBackground(new java.awt.Color(255, 255, 102));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Add Score ");
        jLabel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jLabel10.setOpaque(true);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Exam Date");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Remarks");

        jDateChooser2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        wmark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wmarkActionPerformed(evt);
            }
        });
        wmark.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                wmarkKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                wmarkKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Written :");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Evedence :");

        emark.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emarkKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emarkKeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Full  Marks");

        fmark.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fmarkKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fmarkKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Total Marks :");

        tmark.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tmarkComponentAdded(evt);
            }
        });
        tmark.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tmarkKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tmarkKeyTyped(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 51, 255));
        jLabel17.setText("%");

        parcentageM.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                parcentageMComponentAdded(evt);
            }
        });
        parcentageM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parcentageMKeyTyped(evt);
            }
        });

        TXTremark.setColumns(20);
        TXTremark.setRows(5);
        jScrollPane2.setViewportView(TXTremark);

        CHECK.setBackground(new java.awt.Color(204, 255, 204));
        CHECK.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CHECK.setText("Load Exam ID");
        CHECK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CHECKActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText(">> Load each time at modification ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2)
                                .addGap(351, 351, 351))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fmark, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jCombo_EXAM_IDX, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                                        .addGap(29, 29, 29)
                                        .addComponent(CHECK)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(wmark, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(emark, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tmark, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(parcentageM, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCombo_EXAM_IDX, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CHECK)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fmark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wmark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tmark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(parcentageM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButton1.setBackground(new java.awt.Color(139, 238, 178));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/20px/icons8_Available_Updates_20px.png"))); // NOI18N
        jButton1.setText("Reset");
        jButton1.setToolTipText("click here to reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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

        btnUPDATE.setText("Update");
        btnUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUPDATEActionPerformed(evt);
            }
        });

        btnDELETE.setText("Delete");
        btnDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDELETEActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Course ID :");

        crsID.setEditable(false);
        crsID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        crsID.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                crsIDInputMethodTextChanged(evt);
            }
        });
        crsID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crsIDActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("<< Search Here>>");
        jLabel6.setOpaque(true);

        idx.setEditable(false);
        idx.setToolTipText("not editable");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(10, 10, 10)
                                                .addComponent(COURSELABEL, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(22, 22, 22)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(crsID, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(BATCHNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(jButton1)
                                            .addGap(18, 18, 18)
                                            .addComponent(BTN_addStU1)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnUPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnDELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(idx, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(idx, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(crsID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(COURSELABEL, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BATCHNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BTN_addStU1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(btnUPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(btnDELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        HomeWindow hw = new HomeWindow();
        this.dispose();
        int state = hw.getExtendedState();
        //        hw.setEnabled(true);
        hw.setVisible(true);

    }//GEN-LAST:event_btn_backHomeMouseClicked

    private void btn_backHomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backHomeMousePressed
        btn_backHome.setBackground(new Color(139, 238, 178));
    }//GEN-LAST:event_btn_backHomeMousePressed

    private void btn_backHomeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backHomeMouseReleased
        btn_backHome.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btn_backHomeMouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        clearfield();
//        show_Score();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable_Display_UserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Display_UserMouseClicked

        loadcrsId();

        int i = jTable_Display_User.getSelectedRow();
        TableModel model = jTable_Display_User.getModel();

        idx.setText(model.getValueAt(i, 0).toString());

        txtID.setText(model.getValueAt(i, 1).toString());

        TXTremark.setText(model.getValueAt(i, 2).toString());
        try {
            COURSELABEL.setSelectedItem(jTable_Display_User.getValueAt(i, 3).toString());
            BATCHNAME.setSelectedItem(jTable_Display_User.getValueAt(i, 4).toString());
            resetMOduleCOMBo();
            loadModuleList();
            jCombo_EXAM_IDX.setSelectedItem(jTable_Display_User.getValueAt(i, 5).toString());
            try {
                Date date2 = new SimpleDateFormat("yyy-MM-dd").parse((String) model.getValueAt(i, 6));
                jDateChooser2.setDate(date2);
            } catch (Exception e) {

                e.printStackTrace();

            }
//            Date date2 = new SimpleDateFormat("yyy-MM-dd").parse((String) model.getValueAt(i, 5));
//            jDateChooser2.setDate(date2);
            fmark.setText(jTable_Display_User.getValueAt(i, 7).toString());
            wmark.setText(jTable_Display_User.getValueAt(i, 8).toString());
            emark.setText(jTable_Display_User.getValueAt(i, 9).toString());
            tmark.setText(jTable_Display_User.getValueAt(i, 10).toString());
            parcentageM.setText(jTable_Display_User.getValueAt(i, 11).toString());

            TXTremark.setText(model.getValueAt(i, 12).toString());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_jTable_Display_UserMouseClicked
    public boolean isExamIDExist(String exID) {
        boolean isExist = false;
        Connection con = connectionDB.connection_DB();
        PreparedStatement pst;
        try {
            pst = con.prepareStatement("SELECT * FROM score WHERE ex_id= ?");
            pst.setString(1, exID);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                isExist = true;
            } else {

            }

        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }

        return isExist;
    }

    private void updaterScore() {
        //scoreId, st_id, c_label, batch_N, ex_id, ex_date, full_marks, score_written, score_evedence, Score_Total, parcentage, remarks
        try {
            int sc_id = Integer.parseInt(idx.getText());
            int st_id = Integer.parseInt(txtID.getText());
            String label = COURSELABEL.getSelectedItem().toString();
            String batch_name = BATCHNAME.getSelectedItem().toString();
            String ExmId = jCombo_EXAM_IDX.getSelectedItem().toString();
            int FullMarks = Integer.parseInt(fmark.getText());
            int written = Integer.parseInt(wmark.getText());
            int evedence = Integer.parseInt(emark.getText());
            int total = Integer.parseInt(tmark.getText());
            parcentage = Double.parseDouble(parcentageM.getText());
            String remarks = TXTremark.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
            String ExamDate = sdf.format(jDateChooser2.getDate());
//               try {
//            parcentage = Double.parseDouble(parcentageM.getText());
//        } catch (NumberFormatException e) {
//            e.getMessage();
//        }
            String querrySC = "UPDATE student_ms.score set st_id ='" + st_id + "', c_label ='" + label + "', batch_N ='" + batch_name + "', ex_id ='" + ExmId + "', ex_date ='" + ExamDate + "', full_marks ='" + FullMarks + "', score_written ='" + written + "', score_evedence ='" + evedence + "', Score_Total ='" + total + "', parcentage ='" + parcentage + "', remarks ='" + remarks + "' WHERE scoreId='" + sc_id + "'  ";
            Connection con = connectionDB.connection_DB();
            PreparedStatement pst = con.prepareStatement(querrySC);
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private void btnUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUPDATEActionPerformed

//        updaterScore();
        int confrm = JOptionPane.showConfirmDialog(null, "Are you sure to Update ?", "Update", JOptionPane.YES_NO_OPTION);
        if (confrm == 0) {
            try {
                int sc_id = Integer.parseInt(idx.getText());
                int st_id = Integer.parseInt(txtID.getText());
                String crsid = crsID.getText();
                String label = COURSELABEL.getSelectedItem().toString();
                String batch_name = BATCHNAME.getSelectedItem().toString();
                String ExmId = jCombo_EXAM_IDX.getSelectedItem().toString();
                int FullMarks = Integer.parseInt(fmark.getText());
                int written = Integer.parseInt(wmark.getText());
                int evedence = Integer.parseInt(emark.getText());
                int total = Integer.parseInt(tmark.getText());
                parcentage = Double.parseDouble(parcentageM.getText());
                String remarks = TXTremark.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
                String ExamDate = sdf.format(jDateChooser2.getDate());

                if (verify2()) {
                    String querrySC = "UPDATE student_ms.score set st_id ='" + st_id + "', course_ID ='" + crsid + "', c_label ='" + label + "', batch_N ='" + batch_name + "', ex_id ='" + ExmId + "', ex_date ='" + ExamDate + "', full_marks ='" + FullMarks + "', score_written ='" + written + "', score_evedence ='" + evedence + "', Score_Total ='" + total + "', parcentage ='" + parcentage + "', remarks ='" + remarks + "' WHERE scoreId='" + sc_id + "'  ";
                    Connection con = connectionDB.connection_DB();
                    PreparedStatement pst = con.prepareStatement(querrySC);
                    pst.executeUpdate();

                    DefaultTableModel model = (DefaultTableModel) jTable_Display_User.getModel();
                    model.setRowCount(0);
                    show_Score();
                    clearfield();

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Select one to Update data");

            }

        } else {

        }

    }//GEN-LAST:event_btnUPDATEActionPerformed

    private void btnDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDELETEActionPerformed

        int confrm = JOptionPane.showConfirmDialog(null, "Are you sure to delete ?", "Delete", JOptionPane.YES_NO_OPTION);
        if (confrm == 0) {
            try {
                Connection con = connectionDB.connection_DB();
                int row = jTable_Display_User.getSelectedRow();
                String value = (jTable_Display_User.getModel().getValueAt(row, 0).toString());
                String querry4 = "DELETE FROM score WHERE scoreId=" + value;
                PreparedStatement pst = con.prepareStatement(querry4);
                pst.executeUpdate();
                DefaultTableModel model = (DefaultTableModel) jTable_Display_User.getModel();

                model.setRowCount(0);

                JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
                show_Score();

                //                   hw.cs.setText(Integer.toString(MyFunction.countData("student")));
                clearfield();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Select one to Delete data");
                System.out.println(e.getMessage());
            }

        }

    }//GEN-LAST:event_btnDELETEActionPerformed

    public boolean verify() {

//txtFN.getText().isEmpty() || txtLN.getText().isEmpty() ||
        if (txtID.getText().isEmpty() || fmark.getText().isEmpty() || wmark.getText().isEmpty() || emark.getText().isEmpty()
                || tmark.getText().isEmpty() || parcentageM.getText().isEmpty() || TXTremark.getText().isEmpty() || jDateChooser2.getCalendar() == null || COURSELABEL.getSelectedIndex() == 0 || BATCHNAME.getSelectedIndex() == 0 || jCombo_EXAM_IDX.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "One or more fields are empty / not selected");
            return false;
        } else if (jDateChooser2.getDate().compareTo(new Date()) > 0) {
            JOptionPane.showMessageDialog(rootPane, "No  future date is allowed");
            return false;
        } else {
            return true;
        }

    }

    public boolean verify2() {

//txtFN.getText().isEmpty() || txtLN.getText().isEmpty() ||
        if (txtID.getText().isEmpty() || fmark.getText().isEmpty() || wmark.getText().isEmpty() || emark.getText().isEmpty()
                || tmark.getText().isEmpty() || parcentageM.getText().isEmpty() || TXTremark.getText().isEmpty() || jDateChooser2.getCalendar() == null || COURSELABEL.getSelectedIndex() == 0 || BATCHNAME.getSelectedIndex() == 0 || jCombo_EXAM_IDX.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "One or more fields are empty / not selected");
            return false;
        } else if (jDateChooser2.getDate().compareTo(new Date()) > 0) {
            JOptionPane.showMessageDialog(rootPane, "No  future date is allowed");
            return false;
        } else {
            return true;
        }

    }

    public void insertUpdateDeleteScore(char operation, Integer scoreId, int st_id, String course_ID,
            String c_label, String batch_N, String ex_id,
            String ex_date, int full_marks,
            int score_written, int score_evedence,
            int Score_Total, double parcentage, String remarks) {
//String f_name,String l_name,
        Connection con = connectionDB.connection_DB();
        PreparedStatement pst;
        //i for insert
        if (operation == 'i') {
            try {
                // f_name, l_name,
                pst = con.prepareStatement("insert into score( st_id,course_ID, c_label, batch_N, ex_id, ex_date, full_marks, score_written, score_evedence, Score_Total, parcentage, remarks) values(?,?,?,?,?,?,?,?,?,?,?,?)");

                pst.setInt(1, st_id);
                pst.setString(2, course_ID);
//                pst.setString(3, l_name);
                pst.setString(3, c_label);
                pst.setString(4, batch_N);
                pst.setString(5, ex_id);
                pst.setString(6, ex_date);
                pst.setInt(7, full_marks);
                pst.setInt(8, score_written);
                pst.setInt(9, score_evedence);
                pst.setInt(10, Score_Total);
                pst.setDouble(11, parcentage);
                pst.setString(12, remarks);

                if (pst.executeUpdate() > 0) {

                    JOptionPane.showMessageDialog(null, "Data Added");
                }

            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (operation == 'u') {
            try {
                //, f_name= ?, l_name= ?
                pst = con.prepareStatement("UPDATE score SET st_id= ?,course_ID= ?, c_label= ?, batch_N= ?, ex_id= ?, ex_date= ?, full_marks= ?, score_written= ?, score_evedence = ?, Score_Total= ?, parcentage= ?, remarks= ? WHERE scoreId= ?");
                pst.setInt(1, st_id);
                pst.setString(2, course_ID);
//                pst.setString(3, l_name);
                pst.setString(3, c_label);
                pst.setString(4, batch_N);
                pst.setString(5, ex_id);
                pst.setString(6, ex_date);
                pst.setInt(7, full_marks);
                pst.setInt(8, score_written);
                pst.setInt(9, score_evedence);
                pst.setInt(10, Score_Total);
                pst.setDouble(11, parcentage);
                pst.setString(12, remarks);

                pst.setInt(13, scoreId);

                if (pst.executeUpdate() > 0) {

                    JOptionPane.showMessageDialog(null, "Data Updated");
                }

            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (operation == 'd') {
            try {
                pst = con.prepareStatement("DELETE FROM score WHERE ScoreId=? ");
                pst.setInt(1, scoreId);

                if (pst.executeUpdate() > 0) {

                    JOptionPane.showMessageDialog(null, "Data Deleted");
                }

            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public ArrayList<Score> ScorerList() {

        ArrayList<Score> scorerList = new ArrayList<>();

        try {
            Connection con = connectionDB.connection_DB();
            String query1 = "SELECT * from score ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            Score score;
            while (rs.next()) {
                // rs.getString("f_name"), rs.getString("l_name"),
                score = new Score(rs.getInt("scoreId"), rs.getInt("st_id"), rs.getString("c_label"), rs.getString("batch_N"), rs.getString("ex_id"), rs.getString("ex_date"), rs.getInt("full_marks"), rs.getInt("score_written"), rs.getInt("score_evedence"), rs.getInt("Score_Total"), rs.getDouble("parcentage"), rs.getString("remarks"), rs.getString("course_ID")
                );
                scorerList.add(score);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return scorerList;
    }

    public void show_Score() {
        ArrayList<Score> list = ScorerList();
        DefaultTableModel model = (DefaultTableModel) jTable_Display_User.getModel();
        Object[] row = new Object[13];
        for (int i = 0; i < list.size(); i++) {
            Object object = row[i];
            row[0] = list.get(i).getScoreId();
            row[1] = list.get(i).getst_id();
            row[2] = list.get(i).getcourse_ID();
//            row[2] = list.get(i).getf_name();
//            row[3] = list.get(i).getl_name();
            row[3] = list.get(i).getc_label();
            row[4] = list.get(i).getbatch_N();
            row[5] = list.get(i).getex_id();
            row[6] = list.get(i).getex_date();
            row[7] = list.get(i).getfull_marks();
            row[8] = list.get(i).getscore_written();
            row[9] = list.get(i).getscore_evedence();
            row[10] = list.get(i).getScore_Total();
            row[11] = list.get(i).getparcentage();
            row[12] = list.get(i).getremarks();

            model.addRow(row);
        }

    }

    public boolean isExamModuleExist(String exmodule, String studentid) {
        boolean isExist = false;
        Connection con = connectionDB.connection_DB();
        PreparedStatement pst;
        try {
            pst = con.prepareStatement("SELECT * FROM score WHERE ex_id= ? and st_id=?");
            pst.setString(1, exmodule);
            pst.setString(2, studentid);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                isExist = true;
            } else {

            }

        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }

        return isExist;
    }
    private void BTN_addStU1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_addStU1ActionPerformed

        double parcentage = 0.00;
        String ExmId = jCombo_EXAM_IDX.getSelectedItem().toString();
        int st_id = Integer.parseInt(txtID.getText());
        String stID=String.valueOf(st_id);
        if (!isExamModuleExist(ExmId,stID)) {
            try {
            
            String label = COURSELABEL.getSelectedItem().toString();
            String crsid = crsID.getText();

            String batch_name = BATCHNAME.getSelectedItem().toString();
            

            int FullMarks = Integer.parseInt(fmark.getText());
            int written = Integer.parseInt(wmark.getText());
            int evedence = Integer.parseInt(emark.getText());
            int total = Integer.parseInt(tmark.getText());

            try {
                parcentage = Double.parseDouble(parcentageM.getText());
            } catch (NumberFormatException e) {
                e.getMessage();
            }
            String remarks = TXTremark.getText();

            if (verify()) {

                SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
                String ExamDate = sdf.format(jDateChooser2.getDate());

                insertUpdateDeleteScore('i', null, st_id, crsid, label, batch_name, ExmId, ExamDate, FullMarks, written, evedence, total, parcentage, remarks);

            }
            DefaultTableModel model = (DefaultTableModel) jTable_Display_User.getModel();
            model.setRowCount(0);
            show_Score();
            clearfield();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "one or more fields are empty ");
        }

            
        }else {
            JOptionPane.showMessageDialog(null, " Exam data on same module already added");

        }

        

    }//GEN-LAST:event_BTN_addStU1ActionPerformed
    private void clearfield() {
        idx.setText("");
        txtID.setText("");
//        txtFN.setText("");
//        txtLN.setText("");
        fmark.setText("");
        crsID.setText("");
        wmark.setText("");
        emark.setText("");
        tmark.setText("");
        parcentageM.setText("");
        TXTremark.setText("");
        COURSELABEL.setSelectedIndex(0);
        BATCHNAME.setSelectedIndex(0);
        jCombo_EXAM_IDX.setSelectedIndex(0);
        jDateChooser2.setCalendar(null);

    }
    private void searchIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchIDKeyReleased

        if (searchID.getText().isEmpty()) {
//            show_Score();
            clearfield();

        }

        try {
            Connection con = connectionDB.connection_DB();
            String sql = " SELECT * from students WHERE st_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, searchID.getText());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String setid = rs.getString("st_id");
                txtID.setText(setid);
//                String setFname = rs.getString("first_name");
//                txtFN.setText(setFname);
//                String setLname = rs.getString("last_name");
//                txtLN.setText(setLname);
                String crsLabel = rs.getString("label");
                COURSELABEL.setSelectedItem(crsLabel);
                String BatchName = rs.getString("batch_name");
                BATCHNAME.setSelectedItem(BatchName);

//                jDateChooser1.setDate(rs.getDate("dob"));
            }
            if (searchID.getText().equals(null)) {
                clearfield();

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        DefaultTableModel table = (DefaultTableModel) jTable_Display_User.getModel();
        String search = searchID.getText().toLowerCase().toUpperCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        jTable_Display_User.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
//org.apache.commons.lang3.StringUtils.containsIgnoreCase(CharSequence str,CharSequence searchStr);

    }//GEN-LAST:event_searchIDKeyReleased

    private void BATCHNAMEPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_BATCHNAMEPopupMenuWillBecomeInvisible

    }//GEN-LAST:event_BATCHNAMEPopupMenuWillBecomeInvisible

    private void COURSELABELPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_COURSELABELPopupMenuWillBecomeInvisible


    }//GEN-LAST:event_COURSELABELPopupMenuWillBecomeInvisible

    private void txtIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyReleased

        resetMOduleCOMBo();
        if (txtID.getText().isEmpty()) {
//            show_Score();
            clearfield();

        }
        try {
            Connection con = connectionDB.connection_DB();
            String sql = " SELECT * from students WHERE st_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, txtID.getText());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

                String crsLabel = rs.getString("label");
                COURSELABEL.setSelectedItem(crsLabel);
                String BatchName = rs.getString("batch_name");
                BATCHNAME.setSelectedItem(BatchName);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        if (txtID.getText().equals(null)) {
            clearfield();

        }
//        jCombo_EXAM_IDX.setModel(new DefaultComboBoxModel());
//        loadModuleList();


    }//GEN-LAST:event_txtIDKeyReleased

    private void fmarkKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fmarkKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_fmarkKeyTyped

    private void parcentageMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_parcentageMKeyTyped


    }//GEN-LAST:event_parcentageMKeyTyped

    private void tmarkKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tmarkKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_tmarkKeyTyped

    private void emarkKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emarkKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_emarkKeyTyped

    private void wmarkKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_wmarkKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_wmarkKeyTyped

    private void wmarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wmarkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wmarkActionPerformed

    private void wmarkKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_wmarkKeyReleased
        sum();
        parcentageC();

    }//GEN-LAST:event_wmarkKeyReleased

    private void tmarkKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tmarkKeyReleased
        parcentageC();
    }//GEN-LAST:event_tmarkKeyReleased

    private void emarkKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emarkKeyReleased
        sum();
        parcentageC();
        if (rootPaneCheckingEnabled) {

        }


    }//GEN-LAST:event_emarkKeyReleased

    private void tmarkComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tmarkComponentAdded
//        parcentageC();
    }//GEN-LAST:event_tmarkComponentAdded

    private void parcentageMComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_parcentageMComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_parcentageMComponentAdded

    private void fmarkKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fmarkKeyReleased
        parcentageC();
    }//GEN-LAST:event_fmarkKeyReleased

    private void txtIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }

    }//GEN-LAST:event_txtIDKeyTyped

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        student std = new student();
        std.loadComboBatch(BATCHNAME);
//        std.loadModuleList(jCombo_EXAM_IDX);
        std.loadComboLABEL(COURSELABEL);
    }//GEN-LAST:event_formWindowGainedFocus

    private void COURSELABELItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_COURSELABELItemStateChanged

    }//GEN-LAST:event_COURSELABELItemStateChanged
    public void loadcrsId() {

        String batchName = (String) BATCHNAME.getSelectedItem();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pst = null;

        try {
            conn = connectionDB.connection_DB();
            String sql = "select id from course where batch_name='" + batchName + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {

                String crsid = rs.getString("id");
                crsID.setText(crsid);

//                System.out.println("Course ID  " + rs.getString(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                pst.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    private void BATCHNAMEItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_BATCHNAMEItemStateChanged
//        loadModuleList(jCombo_EXAM_IDX);
        loadcrsId();

    }//GEN-LAST:event_BATCHNAMEItemStateChanged

    private void crsIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crsIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_crsIDActionPerformed

    private void crsIDInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_crsIDInputMethodTextChanged


    }//GEN-LAST:event_crsIDInputMethodTextChanged

    private void txtIDPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtIDPropertyChange


    }//GEN-LAST:event_txtIDPropertyChange

    private void CHECKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CHECKActionPerformed
        resetMOduleCOMBo();
        loadModuleList();
    }//GEN-LAST:event_CHECKActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        HomeWindow hw = new HomeWindow();
        this.dispose();
        hw.setVisible(true);

    }//GEN-LAST:event_formWindowClosing

    private void txtIDInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtIDInputMethodTextChanged

    }//GEN-LAST:event_txtIDInputMethodTextChanged

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
            java.util.logging.Logger.getLogger(ScoreManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScoreManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScoreManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScoreManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScoreManagement().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BATCHNAME;
    private javax.swing.JButton BTN_addStU1;
    private javax.swing.JButton CHECK;
    private javax.swing.JComboBox<String> COURSELABEL;
    private javax.swing.JTextArea TXTremark;
    private javax.swing.JButton btnDELETE;
    private javax.swing.JButton btnUPDATE;
    private javax.swing.JLabel btn_backHome;
    private javax.swing.JTextField crsID;
    private javax.swing.JTextField emark;
    private javax.swing.JTextField fmark;
    private javax.swing.JTextField idx;
    private javax.swing.JButton jButton1;
    public static javax.swing.JComboBox<String> jCombo_EXAM_IDX;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTable_Display_User;
    private javax.swing.JTextField parcentageM;
    private javax.swing.JTextField searchID;
    private javax.swing.JTextField tmark;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField wmark;
    // End of variables declaration//GEN-END:variables
}
