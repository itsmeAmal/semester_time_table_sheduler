/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttms.ui;

import com.ttms.controller.commonConstants;
import com.ttms.controller.commonController;
import com.ttms.controller.subjectController;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author personal
 */
public class searchSubject extends javax.swing.JDialog {

    int subjectId = 0;

    /**
     * Creates new form editBatch
     *
     * @param parent
     * @param modal
     * @param subjectPrimaryKey
     */
    public searchSubject(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadSubjectsToTable(txtSearchBySubNameOrCode.getText().trim());
    }

    private void loadSubjectsToTable(String subjNameOrCode) {
        try {
            ArrayList<String[]> attributeConditionValueList = new ArrayList<>();

            String[] arr1 = {"subject_name", commonConstants.Sql.LIKE, "%" + subjNameOrCode + "%"};
            attributeConditionValueList.add(arr1);

            String[] arr2 = {"subject_module_code", commonConstants.Sql.LIKE, "%" + subjNameOrCode + "%"};
            attributeConditionValueList.add(arr2);

            ResultSet rset = subjectController.getSubjectByMoreAttributes(attributeConditionValueList, commonConstants.Sql.OR);
            String[] columnList = {"subject_id", "subject_name", "subject_module_code",
                "subject_semester", "subject_course_level", "subject_detail"};
            commonController.loadDataToTable(tblSubjectDetails, rset, columnList);
        } catch (SQLException ex) {
            Logger.getLogger(searchSubject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getSelectedSubjectId() {
        return subjectId;
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
        jPanel4 = new javax.swing.JPanel();
        btOkButton = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        txtSearchBySubNameOrCode = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSubjectDetails = new javax.swing.JTable();
        btSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Search Subject");

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jPanel4.setBackground(new java.awt.Color(0, 0, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btOkButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btOkButton.setForeground(new java.awt.Color(255, 255, 255));
        btOkButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/labelIcons2/okButton.png"))); // NOI18N
        btOkButton.setToolTipText("Add Subject");
        btOkButton.setBorder(null);
        btOkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOkButtonActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Search by Module name or code");

        txtSearchBySubNameOrCode.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        txtSearchBySubNameOrCode.setToolTipText("Search by Module Name / Module Code");
        txtSearchBySubNameOrCode.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtSearchBySubNameOrCode.setSelectionColor(new java.awt.Color(255, 255, 0));
        txtSearchBySubNameOrCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchBySubNameOrCodeKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/lableIcons/Subject.png"))); // NOI18N
        jLabel2.setToolTipText("Subject Name");

        tblSubjectDetails.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        tblSubjectDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "subjectId", "Subject Name", "Module Code", "Semester", "Level", "Detail / Remark"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSubjectDetails.setRowHeight(20);
        tblSubjectDetails.setRowMargin(2);
        tblSubjectDetails.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblSubjectDetails);
        if (tblSubjectDetails.getColumnModel().getColumnCount() > 0) {
            tblSubjectDetails.getColumnModel().getColumn(0).setMinWidth(0);
            tblSubjectDetails.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblSubjectDetails.getColumnModel().getColumn(0).setMaxWidth(0);
            tblSubjectDetails.getColumnModel().getColumn(2).setMinWidth(200);
            tblSubjectDetails.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblSubjectDetails.getColumnModel().getColumn(2).setMaxWidth(200);
            tblSubjectDetails.getColumnModel().getColumn(3).setMinWidth(0);
            tblSubjectDetails.getColumnModel().getColumn(3).setPreferredWidth(0);
            tblSubjectDetails.getColumnModel().getColumn(3).setMaxWidth(0);
            tblSubjectDetails.getColumnModel().getColumn(4).setMinWidth(0);
            tblSubjectDetails.getColumnModel().getColumn(4).setPreferredWidth(0);
            tblSubjectDetails.getColumnModel().getColumn(4).setMaxWidth(0);
            tblSubjectDetails.getColumnModel().getColumn(5).setMinWidth(200);
            tblSubjectDetails.getColumnModel().getColumn(5).setPreferredWidth(200);
            tblSubjectDetails.getColumnModel().getColumn(5).setMaxWidth(200);
        }

        btSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ttms/labelIcons2/searchIcon.png"))); // NOI18N
        btSearch.setToolTipText("Search");
        btSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSearchBySubNameOrCode))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btOkButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtSearchBySubNameOrCode, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btOkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btOkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOkButtonActionPerformed
        int selectedRaw = tblSubjectDetails.getSelectedRow();
        if (selectedRaw != -1) {
            DefaultTableModel dtm = (DefaultTableModel) tblSubjectDetails.getModel();
            subjectId = commonController.getIntOrZeroFromString(dtm.getValueAt(selectedRaw, 0).toString());
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Please select subject !", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btOkButtonActionPerformed

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSearchActionPerformed

    private void txtSearchBySubNameOrCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchBySubNameOrCodeKeyReleased
        loadSubjectsToTable(txtSearchBySubNameOrCode.getText().trim());
    }//GEN-LAST:event_txtSearchBySubNameOrCodeKeyReleased

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
            java.util.logging.Logger.getLogger(searchSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(searchSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(searchSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(searchSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                searchSubject dialog = new searchSubject(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btOkButton;
    private javax.swing.JButton btSearch;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSubjectDetails;
    private javax.swing.JTextField txtSearchBySubNameOrCode;
    // End of variables declaration//GEN-END:variables
}
