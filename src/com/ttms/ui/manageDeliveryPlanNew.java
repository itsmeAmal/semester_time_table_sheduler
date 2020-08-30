/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttms.ui;

import com.ttms.controller.commonController;
import com.ttms.controller.deliveryPlanController;
import com.ttms.controller.deliveryPlanDetailsController;
import com.ttms.controller.lecturerController;
import com.ttms.controller.roomController;
import com.ttms.controller.subjectController;
import com.ttms.daoimpl.deliveryPlanDaoImpl;
import com.ttms.model.DataObject;
import com.ttms.model.lecturer;
import com.ttms.model.subject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Amal
 */
public class manageDeliveryPlanNew extends javax.swing.JFrame {

    subject subject = null;
    lecturer lecturer = null;
    int subjectId = 0;
    int lecturerId = 0;
    int nextId = 0;

    private String date = "";
    private String timePeriod = "";
    private String day = "";
    private String day4 = "";
    private String day5 = "";

    private String dayOfWeek = "";

    /**
     * Creates new form addStudent
     */
    public manageDeliveryPlanNew() {
        initComponents();
        loadRoomDataObjectsToCombo();
        setInitials();
        loadDataToTable();
    }

    private void loadRoomDataObjectsToCombo() {
        try {
            ResultSet rset = roomController.getAllRoomDetails();
            String[] columnList = {"room_id", "room_name", "room_code", "room_detail", "room_status"};
            commonController.loadDataObjectsIntoComboBox(comboLocation, rset, columnList, "room_name");
        } catch (SQLException ex) {
            Logger.getLogger(manageDeliveryPlanNew.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addPreferenceDateToTable() {
        if (calTimeTableDate.getDate() == null
                || calTimeTableDate.getDate().toString().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Select date !", "Error !", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            String timeAndPeriod = "";
            if (rdoBtn1.isSelected()) {
                timeAndPeriod = "Start Time : 09.00 - " + "Period :" + comboHours.getSelectedItem().toString() + " hours";
            } else if (rdoBtn2.isSelected()) {
                timeAndPeriod = "Start Time : 11.00 - " + "Period :" + comboHours.getSelectedItem().toString() + " hours";
            } else if (rdoBtn3.isSelected()) {
                timeAndPeriod = "Start Time : 01.00 - " + "Period :" + comboHours.getSelectedItem().toString() + " hours";
            }

            boolean status = false;
            DefaultTableModel dtm = (DefaultTableModel) tblPreferenceDay.getModel();

            //Date, Level, time, module name, module code, type, lecturer, room, course, group
            Object[] obj = {commonController.getMysqlDateFromJDateChooser(calTimeTableDate).toString(),
                comboLevel.getSelectedItem().toString(),
                timeAndPeriod,
                txtModuleName.getText().trim(),
                comboModuleCode.getSelectedItem().toString(),
                comboType.getSelectedItem().toString(),
                comboLecturer.getSelectedItem().toString(),
                comboLocation.getSelectedItem().toString(),
                "Course Name",
                "Group Name"};

            for (int i = 0; i < dtm.getRowCount(); i++) {

                if (tblPreferenceDay.getValueAt(i, 0).toString() == commonController.getMysqlDateFromJDateChooser(calTimeTableDate).toString()) {
                    status = true;
                    break;
                }
            }
            if (!status) {
                dtm.addRow(obj);
            } else {
                JOptionPane.showMessageDialog(this, "Selected day already in the table !", "Error !", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void removeSelectedPreferenceDate() {
        int selectedRaw = tblPreferenceDay.getSelectedRow();
        if (selectedRaw != -1) {
            DefaultTableModel dtm = (DefaultTableModel) tblPreferenceDay.getModel();
            dtm.removeRow(selectedRaw);
        } else {
            JOptionPane.showMessageDialog(this, "Select a day to remove from tble !", "Error !", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setInitials() {
        comboLevel.setSelectedItem(null);
        comboModuleCode.setSelectedItem(null);
        subjectId = 0;
        checkBoxRepeatStudents.setSelected(false);
        calWeekBeginningDate.setDate(null);
        comboCalenderWeek.setSelectedItem(null);
        calContactWeek.setSelectedItem(null);
        comboYear.setSelectedItem(null);
        comboLecturer.setSelectedItem(null);
        lecturerId = 0;
        comboHours.setSelectedItem(null);
        comboCalenderWeek.removeAllItems();
        comboLecturer.removeAllItems();
        comboModuleCode.removeAllItems();
    }

    private boolean preferenceDates() {
        boolean status = false;
        int rawCount = tblPreferenceDay.getRowCount();
        if (rawCount > 0) {
            for (int i = 0; i < tblPreferenceDay.getRowCount(); i++) {
                date = tblPreferenceDay.getValueAt(i, 0).toString();
                timePeriod = tblPreferenceDay.getValueAt(i, 1).toString();
                day = tblPreferenceDay.getValueAt(i, 2).toString();

                //                day4 = tblPreferenceDay.getValueAt(3, 1).toString();
//                day5 = tblPreferenceDay.getValueAt(4, 1).toString();
//                    deliveryPlanDetailsController.addDeliveryPlanDetailRecord(day, lecturerId, date, ERROR, timeTableDate, date, date, date, date, date, date, date, date, date)
//                    deliveryPlanDetailsController.addDeliveryPlanDetailRecord("", nextId, timePeriod,
//                            deliveryPlanDetailsController.getNextTimeOrderNo(
//                                    commonController.getMysqlDateFromJDateChooser(calTimeTableDate)),
//                            commonController.getMysqlDateFromJDateChooser(calTimeTableDate), comboHours.getSelectedItem().toString());
            }
            status = true;
        } else {
            JOptionPane.showMessageDialog(this, "Please select preference dates !", "Error !", JOptionPane.ERROR_MESSAGE);
        }
        return status;
    }

    private void addDeliveryPlan() {
        try {
            nextId = new deliveryPlanDaoImpl().getNextDeliveryPlanId();
        } catch (SQLException ex) {
            Logger.getLogger(manageDeliveryPlanNew.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (comboLevel.getSelectedItem() == null || comboLevel.getSelectedItem().toString().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Please select level !", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (comboModuleCode.getSelectedItem() == null || comboModuleCode.getSelectedItem().toString().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Please select module !", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (comboCalenderWeek.getSelectedItem() == null || comboCalenderWeek.getSelectedItem().toString().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Please select calender week !", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (calWeekBeginningDate.getDate() == null || calWeekBeginningDate.getDate().toString().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Please select week beginning date !", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (comboLecturer.getSelectedItem() == null || comboLecturer.getSelectedItem().toString().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Please select lecturer !", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (comboHours.getSelectedItem() == null || comboHours.getSelectedItem().toString().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Please select lecture hour !", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (comboYear.getSelectedItem() == null || comboYear.getSelectedItem().toString().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Please select year !", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (comboType.getSelectedItem() == null || comboType.getSelectedItem().toString().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Please select type !", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (comboLocation.getSelectedItem() == null || comboLocation.getSelectedItem().toString().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Please select location !", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (preferenceDates()) {
                DataObject dataObj = (DataObject) comboLocation.getSelectedItem();

                deliveryPlanController.addDeliveryPlan(nextId, comboLevel.getSelectedItem().toString(), subjectId,
                        checkBoxRepeatStudents.isSelected(), commonController.getMysqlDateFromJDateChooser(calWeekBeginningDate),
                        comboCalenderWeek.getSelectedItem().toString(), calContactWeek.getSelectedItem().toString(),
                        commonController.getIntOrZeroFromString(comboYear.getSelectedItem().toString()), comboType.getSelectedItem().toString(),
                        lecturerId, commonController.getBigDecimalOrZeroFromString(comboHours.getSelectedItem().toString()),
                        commonController.getIntOrZeroFromString(dataObj.get("room_id")), txtRemark.getText().trim(), date, timePeriod, day, day4, day5);

                int option = JOptionPane.showConfirmDialog(this, "Want to clear data ?", "Confirm", JOptionPane.INFORMATION_MESSAGE);
                if (option == JOptionPane.YES_OPTION) {
                    clearData();
                    setInitials();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(manageDeliveryPlanNew.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void clearData() {
        calContactWeek.setSelectedIndex(0);
        comboCalenderWeek.setSelectedItem(null);
        calWeekBeginningDate.setDate(null);
        txtRemark.setText(null);
        comboLevel.setSelectedIndex(0);
        comboModuleCode.setSelectedItem(null);
        comboModuleCode.removeAllItems();
        comboType.setSelectedIndex(0);
        comboLocation.setSelectedIndex(0);
        comboHours.setSelectedIndex(0);
        comboLecturer.setSelectedItem(null);
        comboLecturer.removeAllItems();
        comboYear.setSelectedIndex(0);
        checkBoxRepeatStudents.setSelected(false);
        DefaultTableModel dtm = (DefaultTableModel) tblPreferenceDay.getModel();
        dtm.setRowCount(0);
        nextId = 0;
    }

    private void setDateRelatedComponentData() {
        if (calWeekBeginningDate.getDate() != null) {
//            try {
            String selectedDateString = new SimpleDateFormat("w").format(calWeekBeginningDate.getDate()).toString();
            String selectedYearSring = new SimpleDateFormat("y").format(calWeekBeginningDate.getDate()).toString();
            comboCalenderWeek.removeAllItems();
            comboYear.removeAllItems();
            comboCalenderWeek.addItem("CW " + selectedDateString);
            comboYear.addItem(selectedYearSring);
            //-----------------------------------
//                String input_date = "calWeekBeginningDate.getDate()";
////            String input_date = "01/08/2012";
//                SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
//                Date dt1 = (Date) format1.parse(input_date);
//                DateFormat format2 = new SimpleDateFormat("EEEE");
//                String finalDay = format2.format(dt1);
//                System.out.println(finalDay);
//            } catch (ParseException ex) {
//                Logger.getLogger(manageDeliveryPlanNew.class.getName()).log(Level.SEVERE, null, ex);
//            }

        }
    }

    private void loadDataToTable() {
        try {

            ResultSet rset = deliveryPlanDetailsController.getAllOrderedDeliveryPlanDetails();
            String[] columnList = {"delivery_plan_details_date", "delivery_plan_details_time",
                "delivery_plan_details_remark", "delivery_plan_details_day"};

            commonController.loadDataToTable(tblDeliveryReportData, rset, columnList);

        } catch (SQLException ex) {
            Logger.getLogger(manageDeliveryPlanNew.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void AutoGenerateTimeTableData() {
        if (chkAutoGenarateLecTime.isSelected()) {
            rdoBtn1.setEnabled(false);
            rdoBtn2.setEnabled(false);
            rdoBtn3.setEnabled(false);
            rdoBtn4.setEnabled(false);
        } else {
            rdoBtn1.setEnabled(true);
            rdoBtn2.setEnabled(true);
            rdoBtn3.setEnabled(true);
            rdoBtn4.setEnabled(true);
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

        jCalendarBeanInfo1 = new com.toedter.calendar.JCalendarBeanInfo();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDeliveryReportData = new javax.swing.JTable();
        btPreviewFullDetails = new javax.swing.JButton();
        btRemoveDataFromMainTable = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        comboLevel = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        comboModuleCode = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        txtModuleName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btSearchModule = new javax.swing.JButton();
        calContactWeek = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        calWeekBeginningDate = new com.toedter.calendar.JDateChooser();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        comboType = new javax.swing.JComboBox<>();
        btSearchLecturer = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        comboLecturer = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btAddDataToMainTble = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        comboLocation = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        comboHours = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        checkBoxRepeatStudents = new javax.swing.JCheckBox();
        comboYear = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPreferenceDay = new javax.swing.JTable();
        btRemoveFromPrefTable = new javax.swing.JButton();
        btAddToPreferenceTable = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtRemark = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        comboCalenderWeek = new javax.swing.JComboBox<>();
        calTimeTableDate = new com.toedter.calendar.JDateChooser();
        rdoBtn1 = new javax.swing.JRadioButton();
        rdoBtn2 = new javax.swing.JRadioButton();
        rdoBtn3 = new javax.swing.JRadioButton();
        chkAutoGenarateLecTime = new javax.swing.JCheckBox();
        rdoBtn4 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Delivery Plan Management");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        tblDeliveryReportData.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        tblDeliveryReportData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Time", "Remark", "Day"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDeliveryReportData.setRowHeight(20);
        tblDeliveryReportData.setRowMargin(2);
        tblDeliveryReportData.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblDeliveryReportData);
        if (tblDeliveryReportData.getColumnModel().getColumnCount() > 0) {
            tblDeliveryReportData.getColumnModel().getColumn(0).setMinWidth(200);
            tblDeliveryReportData.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblDeliveryReportData.getColumnModel().getColumn(0).setMaxWidth(200);
            tblDeliveryReportData.getColumnModel().getColumn(1).setMinWidth(150);
            tblDeliveryReportData.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblDeliveryReportData.getColumnModel().getColumn(1).setMaxWidth(150);
            tblDeliveryReportData.getColumnModel().getColumn(3).setMinWidth(150);
            tblDeliveryReportData.getColumnModel().getColumn(3).setPreferredWidth(150);
            tblDeliveryReportData.getColumnModel().getColumn(3).setMaxWidth(150);
        }

        btPreviewFullDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/labelIcons2/viewButton.png"))); // NOI18N
        btPreviewFullDetails.setToolTipText("Show Delivery Plan Details");
        btPreviewFullDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPreviewFullDetailsActionPerformed(evt);
            }
        });

        btRemoveDataFromMainTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/labelIcons2/deleteIcon.png"))); // NOI18N
        btRemoveDataFromMainTable.setToolTipText("Delete Dilivery Plan Details");
        btRemoveDataFromMainTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoveDataFromMainTableActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 0, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Level");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 12, 183, -1));

        comboLevel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        comboLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Level 4", "Level 5", "Level 6" }));
        comboLevel.setToolTipText("Level");
        comboLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboLevelActionPerformed(evt);
            }
        });
        jPanel3.add(comboLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 29, 183, 44));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Module Code");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 79, 180, -1));

        comboModuleCode.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        comboModuleCode.setToolTipText("Module Code");
        comboModuleCode.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.add(comboModuleCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 98, 134, 44));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Module Name");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 149, 142, -1));

        txtModuleName.setEditable(false);
        txtModuleName.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        txtModuleName.setText("Module Name");
        txtModuleName.setToolTipText("Module Name");
        txtModuleName.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtModuleName.setSelectionColor(new java.awt.Color(255, 255, 0));
        jPanel3.add(txtModuleName, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 166, 180, 44));

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/lableIcons/Course_Type.png"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 166, -1, -1));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/lableIcons/Module_Code.png"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 98, -1, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/lableIcons/Level.png"))); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 29, -1, -1));

        btSearchModule.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/labelIcons2/searchIcon.png"))); // NOI18N
        btSearchModule.setToolTipText("Search");
        btSearchModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchModuleActionPerformed(evt);
            }
        });
        jPanel3.add(btSearchModule, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 98, 40, 40));

        calContactWeek.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        calContactWeek.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Week 0", "Week 1", "Week 2", "Week 3", "Week 4", "Week 5", "Week 6", "Week 7", "Week 8", "Week 9", "Week 10", "Week 11", "Week 12", "Week 13", "Week 14", "Week 15", "Week 16", "Week 17", "Week 18", "Week 19", "Week 20" }));
        calContactWeek.setToolTipText("Class Contact Week");
        jPanel3.add(calContactWeek, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 166, 155, 44));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/lableIcons/Date.png"))); // NOI18N
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 166, -1, -1));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/lableIcons/Date.png"))); // NOI18N
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 29, -1, -1));

        calWeekBeginningDate.setToolTipText("Week Begining Date");
        calWeekBeginningDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                calWeekBeginningDateFocusLost(evt);
            }
        });
        calWeekBeginningDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                calWeekBeginningDateMouseExited(evt);
            }
        });
        calWeekBeginningDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                calWeekBeginningDatePropertyChange(evt);
            }
        });
        calWeekBeginningDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                calWeekBeginningDateKeyReleased(evt);
            }
        });
        jPanel3.add(calWeekBeginningDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 29, 153, 44));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Week Beginning Date");
        jPanel3.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 11, 153, 12));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Class Contact Week");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 147, 155, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Calender Week");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 79, 153, -1));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/lableIcons/Date.png"))); // NOI18N
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 98, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Lecturer");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 143, -1));

        comboType.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        comboType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lecture", "Tutorial", "Lab", "Holiday", "Examination", "Revision", "Induction Week", "ICA" }));
        comboType.setToolTipText("Type ");
        jPanel3.add(comboType, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 180, 44));

        btSearchLecturer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/labelIcons2/searchIcon.png"))); // NOI18N
        btSearchLecturer.setToolTipText("Search");
        btSearchLecturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchLecturerActionPerformed(evt);
            }
        });
        jPanel3.add(btSearchLecturer, new org.netbeans.lib.awtextra.AbsoluteConstraints(647, 98, 40, 40));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/lableIcons/Type.png"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, -1));

        comboLecturer.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        comboLecturer.setToolTipText("Lecturer");
        jPanel3.add(comboLecturer, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 98, 130, 44));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/lableIcons/Lecturer.png"))); // NOI18N
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 102, -1, -1));

        btAddDataToMainTble.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btAddDataToMainTble.setForeground(new java.awt.Color(255, 255, 255));
        btAddDataToMainTble.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/labelIcons2/addIncome.png"))); // NOI18N
        btAddDataToMainTble.setToolTipText("Add Delivery Plan");
        btAddDataToMainTble.setBorder(null);
        btAddDataToMainTble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddDataToMainTbleActionPerformed(evt);
            }
        });
        jPanel3.add(btAddDataToMainTble, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 237, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Type");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 170, -1));

        comboLocation.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        comboLocation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "room" }));
        comboLocation.setToolTipText("Location");
        jPanel3.add(comboLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 166, 180, 44));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/lableIcons/Room.png"))); // NOI18N
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 166, -1, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Location");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 148, 180, -1));

        comboHours.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        comboHours.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00.30", "01.00", "01.30", "02.00", "02.30", "03.00", "03.30", "04.00", "04.30", "05.00" }));
        comboHours.setToolTipText("Lecture Hours");
        jPanel3.add(comboHours, new org.netbeans.lib.awtextra.AbsoluteConstraints(991, 28, 213, 44));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Lecture Hours");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(991, 11, 147, -1));

        checkBoxRepeatStudents.setBackground(new java.awt.Color(0, 0, 102));
        checkBoxRepeatStudents.setForeground(new java.awt.Color(255, 255, 255));
        checkBoxRepeatStudents.setText("Repeat Students Available");
        checkBoxRepeatStudents.setToolTipText("Repeat Students Available");
        jPanel3.add(checkBoxRepeatStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 228, 230, -1));

        comboYear.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        comboYear.setToolTipText("Year");
        jPanel3.add(comboYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 233, 155, 44));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/lableIcons/Year.png"))); // NOI18N
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 228, -1, -1));

        tblPreferenceDay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Level", "Time", "Module Name", "Module Code", "Type", "Lecturer", "Room", "Course", "Group"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPreferenceDay.setToolTipText("Priority Level");
        tblPreferenceDay.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblPreferenceDay);
        if (tblPreferenceDay.getColumnModel().getColumnCount() > 0) {
            tblPreferenceDay.getColumnModel().getColumn(0).setMinWidth(120);
            tblPreferenceDay.getColumnModel().getColumn(0).setPreferredWidth(120);
            tblPreferenceDay.getColumnModel().getColumn(0).setMaxWidth(120);
            tblPreferenceDay.getColumnModel().getColumn(1).setMinWidth(220);
            tblPreferenceDay.getColumnModel().getColumn(1).setPreferredWidth(220);
            tblPreferenceDay.getColumnModel().getColumn(1).setMaxWidth(220);
            tblPreferenceDay.getColumnModel().getColumn(2).setResizable(false);
            tblPreferenceDay.getColumnModel().getColumn(3).setMinWidth(0);
            tblPreferenceDay.getColumnModel().getColumn(3).setPreferredWidth(0);
            tblPreferenceDay.getColumnModel().getColumn(3).setMaxWidth(0);
            tblPreferenceDay.getColumnModel().getColumn(4).setMinWidth(0);
            tblPreferenceDay.getColumnModel().getColumn(4).setPreferredWidth(0);
            tblPreferenceDay.getColumnModel().getColumn(4).setMaxWidth(0);
            tblPreferenceDay.getColumnModel().getColumn(5).setMinWidth(0);
            tblPreferenceDay.getColumnModel().getColumn(5).setPreferredWidth(0);
            tblPreferenceDay.getColumnModel().getColumn(5).setMaxWidth(0);
            tblPreferenceDay.getColumnModel().getColumn(6).setMinWidth(0);
            tblPreferenceDay.getColumnModel().getColumn(6).setPreferredWidth(0);
            tblPreferenceDay.getColumnModel().getColumn(6).setMaxWidth(0);
            tblPreferenceDay.getColumnModel().getColumn(7).setMinWidth(0);
            tblPreferenceDay.getColumnModel().getColumn(7).setPreferredWidth(0);
            tblPreferenceDay.getColumnModel().getColumn(7).setMaxWidth(0);
            tblPreferenceDay.getColumnModel().getColumn(8).setMinWidth(0);
            tblPreferenceDay.getColumnModel().getColumn(8).setPreferredWidth(0);
            tblPreferenceDay.getColumnModel().getColumn(8).setMaxWidth(0);
            tblPreferenceDay.getColumnModel().getColumn(9).setMinWidth(0);
            tblPreferenceDay.getColumnModel().getColumn(9).setPreferredWidth(0);
            tblPreferenceDay.getColumnModel().getColumn(9).setMaxWidth(0);
        }

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(703, 120, 501, 157));

        btRemoveFromPrefTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/labelIcons2/deleteIcon.png"))); // NOI18N
        btRemoveFromPrefTable.setToolTipText("Delete Preference Date");
        btRemoveFromPrefTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoveFromPrefTableActionPerformed(evt);
            }
        });
        jPanel3.add(btRemoveFromPrefTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 118, 40, 40));

        btAddToPreferenceTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/labelIcons2/addToTableSmall.png"))); // NOI18N
        btAddToPreferenceTable.setToolTipText("Add Preference Date");
        btAddToPreferenceTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddToPreferenceTableActionPerformed(evt);
            }
        });
        jPanel3.add(btAddToPreferenceTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 28, 40, 40));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Time Table Date");
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 143, -1));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Year");
        jPanel3.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 216, 118, -1));

        txtRemark.setToolTipText("Remarks");
        jPanel3.add(txtRemark, new org.netbeans.lib.awtextra.AbsoluteConstraints(513, 233, 178, 44));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Remark");
        jPanel3.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 216, 143, -1));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/lableIcons/Remarks.png"))); // NOI18N
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 233, -1, -1));

        comboCalenderWeek.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        comboCalenderWeek.setToolTipText("Calender Week");
        jPanel3.add(comboCalenderWeek, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 97, 153, 44));

        calTimeTableDate.setToolTipText("Week Begining Date");
        calTimeTableDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                calTimeTableDateFocusLost(evt);
            }
        });
        calTimeTableDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                calTimeTableDateMouseExited(evt);
            }
        });
        calTimeTableDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                calTimeTableDatePropertyChange(evt);
            }
        });
        calTimeTableDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                calTimeTableDateKeyReleased(evt);
            }
        });
        jPanel3.add(calTimeTableDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(702, 29, 277, 44));

        rdoBtn1.setBackground(new java.awt.Color(0, 0, 102));
        buttonGroup1.add(rdoBtn1);
        rdoBtn1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rdoBtn1.setForeground(new java.awt.Color(255, 255, 255));
        rdoBtn1.setSelected(true);
        rdoBtn1.setText("09.00");
        jPanel3.add(rdoBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 80, -1, -1));

        rdoBtn2.setBackground(new java.awt.Color(0, 0, 102));
        buttonGroup1.add(rdoBtn2);
        rdoBtn2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rdoBtn2.setForeground(new java.awt.Color(255, 255, 255));
        rdoBtn2.setText("11.00");
        jPanel3.add(rdoBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 80, -1, -1));

        rdoBtn3.setBackground(new java.awt.Color(0, 0, 102));
        buttonGroup1.add(rdoBtn3);
        rdoBtn3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rdoBtn3.setForeground(new java.awt.Color(255, 255, 255));
        rdoBtn3.setText("01.00");
        jPanel3.add(rdoBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 80, -1, -1));

        chkAutoGenarateLecTime.setBackground(new java.awt.Color(0, 0, 102));
        chkAutoGenarateLecTime.setForeground(new java.awt.Color(255, 255, 255));
        chkAutoGenarateLecTime.setText("Auto generate lecture time");
        chkAutoGenarateLecTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAutoGenarateLecTimeActionPerformed(evt);
            }
        });
        jPanel3.add(chkAutoGenarateLecTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, 180, -1));

        rdoBtn4.setBackground(new java.awt.Color(0, 0, 102));
        buttonGroup1.add(rdoBtn4);
        rdoBtn4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rdoBtn4.setForeground(new java.awt.Color(255, 255, 255));
        rdoBtn4.setText("03.00");
        rdoBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoBtn4ActionPerformed(evt);
            }
        });
        jPanel3.add(rdoBtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 80, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btPreviewFullDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btRemoveDataFromMainTable, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btPreviewFullDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRemoveDataFromMainTable, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 640));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btAddDataToMainTbleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddDataToMainTbleActionPerformed
        int option = JOptionPane.showConfirmDialog(this, "All the details you entered are correct ? ", "Confirm !", JOptionPane.INFORMATION_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
            addDeliveryPlan();
            setDateRelatedComponentData();
            loadDataToTable();
        }
    }//GEN-LAST:event_btAddDataToMainTbleActionPerformed

    private void btSearchModuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchModuleActionPerformed
        try {
            searchSubject searchSub = new searchSubject(this, true);
            searchSub.setVisible(true);
            subjectId = searchSub.getSelectedSubjectId();
            if (subjectId != 0) {
                subject = subjectController.getSubjectBySubjectId(subjectId);
                comboModuleCode.removeAllItems();
                comboModuleCode.addItem(subject.getModuleCode());
                txtModuleName.setText(subject.getName());
            }
        } catch (SQLException ex) {
            Logger.getLogger(manageDeliveryPlanNew.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btSearchModuleActionPerformed

    private void btSearchLecturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchLecturerActionPerformed
        searchLecturer searchLec = new searchLecturer(this, true);
        searchLec.setVisible(true);
        lecturerId = searchLec.getSelectedLecturerId();
        if (lecturerId != 0) {
            try {
                lecturer = lecturerController.getLecturerByLecturerId(lecturerId);
                comboLecturer.removeAllItems();
                comboLecturer.addItem(lecturer.getName());
            } catch (SQLException ex) {
                Logger.getLogger(manageDeliveryPlanNew.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btSearchLecturerActionPerformed

    private void comboLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboLevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboLevelActionPerformed

    private void btRemoveFromPrefTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoveFromPrefTableActionPerformed
        removeSelectedPreferenceDate();
    }//GEN-LAST:event_btRemoveFromPrefTableActionPerformed

    private void btAddToPreferenceTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddToPreferenceTableActionPerformed
        addPreferenceDateToTable();
    }//GEN-LAST:event_btAddToPreferenceTableActionPerformed

    private void btPreviewFullDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPreviewFullDetailsActionPerformed
        new viewDeliveryPlanTableInfo(this, true, 1).setVisible(true);
    }//GEN-LAST:event_btPreviewFullDetailsActionPerformed

    private void btRemoveDataFromMainTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoveDataFromMainTableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btRemoveDataFromMainTableActionPerformed

    private void calWeekBeginningDateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_calWeekBeginningDateKeyReleased

    }//GEN-LAST:event_calWeekBeginningDateKeyReleased

    private void calWeekBeginningDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_calWeekBeginningDateFocusLost

    }//GEN-LAST:event_calWeekBeginningDateFocusLost

    private void calWeekBeginningDateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calWeekBeginningDateMouseExited

    }//GEN-LAST:event_calWeekBeginningDateMouseExited

    private void calWeekBeginningDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calWeekBeginningDatePropertyChange
        setDateRelatedComponentData();
    }//GEN-LAST:event_calWeekBeginningDatePropertyChange

    private void calTimeTableDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_calTimeTableDateFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_calTimeTableDateFocusLost

    private void calTimeTableDateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calTimeTableDateMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_calTimeTableDateMouseExited

    private void calTimeTableDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calTimeTableDatePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_calTimeTableDatePropertyChange

    private void calTimeTableDateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_calTimeTableDateKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_calTimeTableDateKeyReleased

    private void chkAutoGenarateLecTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAutoGenarateLecTimeActionPerformed
        AutoGenerateTimeTableData();
    }//GEN-LAST:event_chkAutoGenarateLecTimeActionPerformed

    private void rdoBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoBtn4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoBtn4ActionPerformed

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
            java.util.logging.Logger.getLogger(manageDeliveryPlanNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manageDeliveryPlanNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manageDeliveryPlanNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manageDeliveryPlanNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new manageDeliveryPlanNew().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddDataToMainTble;
    private javax.swing.JButton btAddToPreferenceTable;
    private javax.swing.JButton btPreviewFullDetails;
    private javax.swing.JButton btRemoveDataFromMainTable;
    private javax.swing.JButton btRemoveFromPrefTable;
    private javax.swing.JButton btSearchLecturer;
    private javax.swing.JButton btSearchModule;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> calContactWeek;
    private com.toedter.calendar.JDateChooser calTimeTableDate;
    private com.toedter.calendar.JDateChooser calWeekBeginningDate;
    private javax.swing.JCheckBox checkBoxRepeatStudents;
    private javax.swing.JCheckBox chkAutoGenarateLecTime;
    private javax.swing.JComboBox<String> comboCalenderWeek;
    private javax.swing.JComboBox<String> comboHours;
    private javax.swing.JComboBox<String> comboLecturer;
    private javax.swing.JComboBox<String> comboLevel;
    private javax.swing.JComboBox<String> comboLocation;
    private javax.swing.JComboBox<String> comboModuleCode;
    private javax.swing.JComboBox<String> comboType;
    private javax.swing.JComboBox<String> comboYear;
    private com.toedter.calendar.JCalendarBeanInfo jCalendarBeanInfo1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdoBtn1;
    private javax.swing.JRadioButton rdoBtn2;
    private javax.swing.JRadioButton rdoBtn3;
    private javax.swing.JRadioButton rdoBtn4;
    private javax.swing.JTable tblDeliveryReportData;
    private javax.swing.JTable tblPreferenceDay;
    private javax.swing.JTextField txtModuleName;
    private javax.swing.JTextField txtRemark;
    // End of variables declaration//GEN-END:variables
}
