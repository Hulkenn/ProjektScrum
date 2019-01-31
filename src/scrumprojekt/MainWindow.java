/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumprojekt;

import java.awt.Color;
import oru.inf.InfDB;

/**
 *
 * @author Joakim
 */
public class MainWindow extends javax.swing.JFrame {

    private InfDB db;
    private int user_id;
    /**
     * Creates new form MainWindow
     */
    public MainWindow(InfDB db, int user_id) {
        initComponents();
        this.db = db;
        this.user_id = user_id;
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHeader = new javax.swing.JPanel();
        panelOpenEducation = new javax.swing.JPanel();
        labelOpenEducation = new javax.swing.JLabel();
        panelOpenSocial = new javax.swing.JPanel();
        labelOpenSocial = new javax.swing.JLabel();
        panelOpenResearch = new javax.swing.JPanel();
        labelOpenResearch = new javax.swing.JLabel();
        labelHome = new javax.swing.JLabel();
        panelHome = new javax.swing.JPanel();
        labelWelcome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(250, 249, 246));
        setPreferredSize(new java.awt.Dimension(1170, 700));
        setResizable(false);
        setSize(new java.awt.Dimension(1170, 700));

        panelHeader.setBackground(new java.awt.Color(50, 121, 184));
        panelHeader.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        panelOpenEducation.setBackground(new java.awt.Color(50, 121, 184));
        panelOpenEducation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelOpenEducationMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelOpenEducationMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelOpenEducationMouseExited(evt);
            }
        });

        labelOpenEducation.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        labelOpenEducation.setForeground(new java.awt.Color(250, 249, 246));
        labelOpenEducation.setText("Education");
        labelOpenEducation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelOpenEducationMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelOpenEducationLayout = new javax.swing.GroupLayout(panelOpenEducation);
        panelOpenEducation.setLayout(panelOpenEducationLayout);
        panelOpenEducationLayout.setHorizontalGroup(
            panelOpenEducationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpenEducationLayout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(labelOpenEducation)
                .addGap(55, 55, 55))
        );
        panelOpenEducationLayout.setVerticalGroup(
            panelOpenEducationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpenEducationLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(labelOpenEducation)
                .addContainerGap())
        );

        panelOpenSocial.setBackground(new java.awt.Color(50, 121, 184));
        panelOpenSocial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelOpenSocialMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelOpenSocialMouseExited(evt);
            }
        });

        labelOpenSocial.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        labelOpenSocial.setForeground(new java.awt.Color(250, 249, 246));
        labelOpenSocial.setText("Social");

        javax.swing.GroupLayout panelOpenSocialLayout = new javax.swing.GroupLayout(panelOpenSocial);
        panelOpenSocial.setLayout(panelOpenSocialLayout);
        panelOpenSocialLayout.setHorizontalGroup(
            panelOpenSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpenSocialLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(labelOpenSocial)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        panelOpenSocialLayout.setVerticalGroup(
            panelOpenSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpenSocialLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(labelOpenSocial)
                .addContainerGap())
        );

        panelOpenResearch.setBackground(new java.awt.Color(50, 121, 184));
        panelOpenResearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelOpenResearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelOpenResearchMouseExited(evt);
            }
        });

        labelOpenResearch.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        labelOpenResearch.setForeground(new java.awt.Color(250, 249, 246));
        labelOpenResearch.setText("Research");

        javax.swing.GroupLayout panelOpenResearchLayout = new javax.swing.GroupLayout(panelOpenResearch);
        panelOpenResearch.setLayout(panelOpenResearchLayout);
        panelOpenResearchLayout.setHorizontalGroup(
            panelOpenResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpenResearchLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(labelOpenResearch)
                .addGap(58, 58, 58))
        );
        panelOpenResearchLayout.setVerticalGroup(
            panelOpenResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpenResearchLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(labelOpenResearch)
                .addContainerGap())
        );

        labelHome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labelHome.setForeground(new java.awt.Color(250, 249, 246));
        labelHome.setText("Home");
        labelHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelHomeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelOpenEducation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(panelOpenResearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(panelOpenSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138)
                .addComponent(labelHome)
                .addGap(32, 32, 32))
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addComponent(labelHome)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelOpenEducation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelOpenResearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelOpenSocial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        panelHome.setBackground(new java.awt.Color(250, 249, 246));
        panelHome.setPreferredSize(new java.awt.Dimension(1170, 650));

        labelWelcome.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        labelWelcome.setText("Welcome to Örebro University Informatics Portal");

        javax.swing.GroupLayout panelHomeLayout = new javax.swing.GroupLayout(panelHome);
        panelHome.setLayout(panelHomeLayout);
        panelHomeLayout.setHorizontalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(labelWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelHomeLayout.setVerticalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(labelWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelHome, javax.swing.GroupLayout.DEFAULT_SIZE, 1194, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelHome, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelHomeMouseClicked
       // panelEducationBlog.hide();
    }//GEN-LAST:event_labelHomeMouseClicked

    private void panelOpenResearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelOpenResearchMouseExited
        panelOpenResearch.setBackground(new Color(50, 121, 184));
    }//GEN-LAST:event_panelOpenResearchMouseExited

    private void panelOpenResearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelOpenResearchMouseEntered
        panelOpenResearch.setBackground(new Color(77, 146, 208));
    }//GEN-LAST:event_panelOpenResearchMouseEntered

    private void panelOpenSocialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelOpenSocialMouseExited
        panelOpenSocial.setBackground(new Color(50, 121, 184));
    }//GEN-LAST:event_panelOpenSocialMouseExited

    private void panelOpenSocialMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelOpenSocialMouseEntered
        panelOpenSocial.setBackground(new Color(77, 146, 208));
    }//GEN-LAST:event_panelOpenSocialMouseEntered

    private void panelOpenEducationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelOpenEducationMouseExited
        panelOpenEducation.setBackground(new Color(50, 121, 184));
    }//GEN-LAST:event_panelOpenEducationMouseExited

    private void panelOpenEducationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelOpenEducationMouseEntered
        panelOpenEducation.setBackground(new Color(77, 146, 208));
    }//GEN-LAST:event_panelOpenEducationMouseEntered

    private void labelOpenEducationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelOpenEducationMouseClicked
        //panelEducationBlog.show();
    }//GEN-LAST:event_labelOpenEducationMouseClicked

    private void panelOpenEducationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelOpenEducationMouseClicked
        // TODO add your handling code here:
        new EducationFrame(db, user_id).setVisible(true);
        dispose();
    }//GEN-LAST:event_panelOpenEducationMouseClicked

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow(db).setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelHome;
    private javax.swing.JLabel labelOpenEducation;
    private javax.swing.JLabel labelOpenResearch;
    private javax.swing.JLabel labelOpenSocial;
    private javax.swing.JLabel labelWelcome;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelOpenEducation;
    private javax.swing.JPanel panelOpenResearch;
    private javax.swing.JPanel panelOpenSocial;
    // End of variables declaration//GEN-END:variables
}
