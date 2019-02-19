/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumprojekt;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

/**
 *
 * @author Joakim
 */
public class Event extends javax.swing.JPanel {

    private Button removeButton;
    
    private Connection conn;
    /**
     * Creates new form Event
     */
    public Event(ResultSet event, Connection conn) {
        initComponents();
        this.conn = conn;
        try {
            jTextArea1.setText(event.getString("DESCRIPTION"));
            txtCreator.setText(txtCreator.getText() + event.getString("FIRSTNAME") + " " + event.getString("LASTNAME"));
            lblTitle.setText(event.getString("TITLE"));
            lblPlace.setText(event.getString("PLACE"));
            lblTime.setText(event.getString("TIME"));
            ResultSet attended = DBFetcher.fetchUsersAttended(this.conn, event.getInt("IDEVENTS"));
            boolean attended_empty = true;
            JComboBox attended_users = new JComboBox();
            while(attended.next()) {
                if(attended_empty) {
                    attended_empty = false;
                    attendingPanel.setLayout(new BoxLayout(attendingPanel, BoxLayout.Y_AXIS));
                    attendingPanel.add(attended_users);
                    attendingPanel.revalidate();
                    attendingPanel.repaint();
                }
                attended_users.addItem(attended.getString("FIRSTNAME") + " " + attended.getString("LASTNAME"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Event(ResultSet event, Connection conn, String attending) {
        initComponents();
        
        try {
            final int event_id = event.getInt("IDEVENTS");
            final int user_id =  event.getInt("IDEMPLOYEE");
            jTextArea1.setText(event.getString("DESCRIPTION"));
            txtCreator.setText(txtCreator.getText() + event.getString("FIRSTNAME") + " " + event.getString("LASTNAME"));
            lblTitle.setText(event.getString("TITLE"));
            lblPlace.setText(event.getString("PLACE"));
            lblTime.setText(event.getString("TIME"));
            attendingPanel.setLayout(new BoxLayout(attendingPanel, BoxLayout.Y_AXIS));
            JCheckBox attendingBox = new JCheckBox("Attending");
            attendingBox.setForeground(new Color(255, 255, 255));
            if(event.getInt("ATTENDING") == 1)
                attendingBox.setSelected(true);
            else
                attendingBox.setSelected(false);
            attendingBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Update attending blablabla
                    if(attendingBox.isSelected()) {
                        DBUpdate.updateAttending(conn, event_id, user_id, 1);
                    }
                    else
                        DBUpdate.updateAttending(conn, event_id, user_id, 0);
                }
            });
            attendingPanel.add(attendingBox);
        } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Event(Connection conn, ResultSet event) {
        initComponents();
        
        try {
            final int eventId = event.getInt("IDEVENTS");
            jTextArea1.setText(event.getString("DESCRIPTION"));
            txtCreator.setText(txtCreator.getText() + event.getString("FIRSTNAME") + " " + event.getString("LASTNAME"));
            lblTitle.setText(event.getString("TITLE"));
            lblPlace.setText(event.getString("PLACE"));
            lblTime.setText(event.getString("TIME"));
            attendingPanel.setLayout(new BoxLayout(attendingPanel, BoxLayout.Y_AXIS));
            removeButton = new Button("Remove");
            removeButton.setBackground(Color.red);
            attendingPanel.add(removeButton);
        } catch(SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public Button getButton() {
        return removeButton;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        txtCreator = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblPlace = new javax.swing.JLabel();
        attendingPanel = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(696, 123));

        jPanel1.setBackground(new java.awt.Color(250, 249, 246));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        txtCreator.setEditable(false);
        txtCreator.setText("Creator: ");

        jLabel2.setText("Title:");

        jLabel3.setText("Time:");

        jLabel4.setText("Place:");

        lblTitle.setText("jLabel5");

        lblTime.setText("jLabel6");

        lblPlace.setText("jLabel7");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTitle))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                        .addComponent(lblPlace))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTime)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblPlace))
                .addGap(0, 21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout attendingPanelLayout = new javax.swing.GroupLayout(attendingPanel);
        attendingPanel.setLayout(attendingPanelLayout);
        attendingPanelLayout.setHorizontalGroup(
            attendingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        attendingPanelLayout.setVerticalGroup(
            attendingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                    .addComponent(txtCreator))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(attendingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCreator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(attendingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel attendingPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblPlace;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtCreator;
    // End of variables declaration//GEN-END:variables
}
