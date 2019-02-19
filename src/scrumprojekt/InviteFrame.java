/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumprojekt;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class InviteFrame extends javax.swing.JFrame {

    private Connection conn;
    private int user_id;
    private ArrayList<Integer> uninvited_user_ids;
    private ArrayList<Integer> invited_user_ids;
    
    /**
     * Creates new form NewJFrame
     */
    public InviteFrame(Connection conn, int user_id) {
        initComponents();
        this.conn = conn;
        this.user_id = user_id;
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        uninvited_user_ids = new ArrayList<Integer>();
        invited_user_ids = new ArrayList<Integer>();
        ResultSet users = DBFetcher.fetchAllUsers(conn);
        try {
            while(users.next()) {
                uninvited_user_ids.add(users.getInt("IDEMPLOYEE"));
                cbxInvite.addItem(users.getString("FIRSTNAME") + " " + users.getString("LASTNAME"));
            }
        } catch(SQLException ex) {
            
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
        jLabel7 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblPlace = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        txtTime = new javax.swing.JTextField();
        txtPlace = new javax.swing.JTextField();
        lblInvite = new javax.swing.JLabel();
        cbxInvite = new javax.swing.JComboBox<>();
        btnInvite = new javax.swing.JButton();
        lblInvited = new javax.swing.JLabel();
        cbxInvited = new javax.swing.JComboBox<>();
        btnRemoveInvite = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textareaEventInfo = new javax.swing.JTextArea();
        lblEventInfo = new javax.swing.JLabel();
        btnPostEvent = new javax.swing.JButton();
        dpEvent = new org.jdesktop.swingx.JXDatePicker();
        lblDate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(250, 249, 246));

        jPanel2.setBackground(new java.awt.Color(50, 121, 184));

        jLabel7.setBackground(new java.awt.Color(250, 249, 246));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(250, 249, 246));
        jLabel7.setText("Create New Event");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel7)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        lblTitle.setText("Title:");

        lblTime.setText("Time:");

        lblPlace.setText("Place:");

        txtTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitleActionPerformed(evt);
            }
        });

        txtPlace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlaceActionPerformed(evt);
            }
        });

        lblInvite.setText("Invite to Event:");

        btnInvite.setBackground(new java.awt.Color(250, 249, 246));
        btnInvite.setText("Invite");
        btnInvite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInviteActionPerformed(evt);
            }
        });

        lblInvited.setText("Invited to Event:");

        btnRemoveInvite.setBackground(new java.awt.Color(250, 246, 249));
        btnRemoveInvite.setText("Remove invite");
        btnRemoveInvite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveInviteActionPerformed(evt);
            }
        });

        textareaEventInfo.setColumns(20);
        textareaEventInfo.setRows(5);
        jScrollPane1.setViewportView(textareaEventInfo);

        lblEventInfo.setText("Event Information:");

        btnPostEvent.setBackground(new java.awt.Color(250, 249, 246));
        btnPostEvent.setText("Post Event");
        btnPostEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostEventActionPerformed(evt);
            }
        });

        dpEvent.setFormats("yyyy-MM-dd");
        dpEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dpEventActionPerformed(evt);
            }
        });

        lblDate.setText("Date:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblTitle)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblTime)
                                        .addComponent(lblPlace))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dpEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 8, Short.MAX_VALUE)))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblInvited)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxInvited, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblInvite)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxInvite, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRemoveInvite)
                            .addComponent(btnInvite)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblEventInfo)
                                        .addGap(353, 353, 353))
                                    .addComponent(btnPostEvent))))))
                .addGap(0, 34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInvite)
                    .addComponent(cbxInvite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblInvited, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxInvited, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnInvite))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPlace)
                            .addComponent(txtPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dpEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDate))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoveInvite))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblEventInfo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPostEvent)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInviteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInviteActionPerformed
        // TODO add your handling code here:
        if(cbxInvite.getItemCount() > 0) {
            invited_user_ids.add(uninvited_user_ids.get(cbxInvite.getSelectedIndex()));
            cbxInvited.addItem(cbxInvite.getSelectedItem().toString());
            
            uninvited_user_ids.remove(uninvited_user_ids.get(cbxInvite.getSelectedIndex()));
            cbxInvite.removeItemAt(cbxInvite.getSelectedIndex());
        }
    }//GEN-LAST:event_btnInviteActionPerformed

    private void btnRemoveInviteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveInviteActionPerformed
        // TODO add your handling code here:
        if(cbxInvited.getItemCount() > 0) {
            uninvited_user_ids.add(invited_user_ids.get(cbxInvited.getSelectedIndex()));
            cbxInvite.addItem(cbxInvited.getSelectedItem().toString());
            
            invited_user_ids.remove(invited_user_ids.get(cbxInvited.getSelectedIndex()));
            cbxInvited.removeItemAt(cbxInvited.getSelectedIndex());
        }
    }//GEN-LAST:event_btnRemoveInviteActionPerformed

    private void txtPlaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlaceActionPerformed

    private void txtTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitleActionPerformed

    private void dpEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dpEventActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_dpEventActionPerformed

    private void btnPostEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostEventActionPerformed
        // TODO add your handling code here:
        if(dpEvent.getDate() != null && !Validate.textWindowIsEmpty(txtTitle) && !Validate.textWindowIsEmpty(txtTime) && !Validate.textWindowIsEmpty(txtPlace)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String chosen_date = sdf.format(dpEvent.getDate());
            int eventId = DBInsert.insertEvent(conn, user_id, chosen_date, textareaEventInfo.getText(), txtTitle.getText(), txtTime.getText(), txtPlace.getText());
            if(cbxInvited.getItemCount() > 0) {
                for(Integer invited_user_id : invited_user_ids) {
                    DBInsert.insertInvitedToEvent(conn, invited_user_id, eventId);
                    
                }
                EmailD.noticeEvent(conn, user_id, invited_user_ids);
            }
            dispose();
        }
    }//GEN-LAST:event_btnPostEventActionPerformed

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
            java.util.logging.Logger.getLogger(InviteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InviteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InviteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InviteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInvite;
    private javax.swing.JButton btnPostEvent;
    private javax.swing.JButton btnRemoveInvite;
    private javax.swing.JComboBox<String> cbxInvite;
    private javax.swing.JComboBox<String> cbxInvited;
    private org.jdesktop.swingx.JXDatePicker dpEvent;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblEventInfo;
    private javax.swing.JLabel lblInvite;
    private javax.swing.JLabel lblInvited;
    private javax.swing.JLabel lblPlace;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextArea textareaEventInfo;
    private javax.swing.JTextField txtPlace;
    private javax.swing.JTextField txtTime;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
