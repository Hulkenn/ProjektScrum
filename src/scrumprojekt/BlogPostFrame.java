/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumprojekt;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import oru.inf.InfDB;

/**
 *
 * @author Joakim
 */
public class BlogPostFrame extends javax.swing.JFrame {
    
    private Connection conn;
    private int user_id;
    private int post_id;
    private ResultSet post;
    private ResultSet user;
    /**
     * Creates new form BlogPostFrame
     */
    public BlogPostFrame(Connection conn, int user_id, int post_id) {
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.conn = conn;
        this.user_id = user_id;
        this.post_id = post_id;
        this.setLocationRelativeTo(null);
        setResizable(false);
        lblRemove.setVisible(false);
        getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.black));
        
        if (DBFetcher.checkIfCreatorOfPost(conn, post_id, user_id) || DBFetcher.fetchRankFromUser(conn,user_id) == 5 || DBFetcher.fetchRankFromUser(conn,user_id) == 3) {
            lblRemove.setVisible(true);
        }
        
        //Adds image if exists
//        String pathImage = DBFetcher.fetchImagePath(conn, post_id);
//        if(pathImage != null)
//            lblImage.setIcon(new ImageIcon(pathImage));
        try {
            post = DBFetcher.fetchPost(conn, post_id);
            int userID = DBFetcher.fetchUserIdFromPost(conn, post_id);
            user = DBFetcher.fetchUser(conn, userID);

            post.next();
            user.next();

            //Update the post with info
            btnAdd.setText(post.getString("HEADLINE"));
            taText.setText(post.getString("TEXT"));


            lblAuthor.setText("Author: " + user.getString("FIRSTNAME") + " " + user.getString("LASTNAME"));
            lblDate.setText("Date: " + post.getString("POSTDATE"));
            lblCategory.setText("Category: " + post.getString("TAG"));
            BoxLayoutDemo.addCommentsToPane(jpContainer, post_id, conn);
        } catch (SQLException ex) {
            
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
        jPanel8 = new javax.swing.JPanel();
        bg = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pnlBack = new javax.swing.JPanel();
        lblBack = new javax.swing.JLabel();
        pnlEducation = new javax.swing.JPanel();
        lblEducation = new javax.swing.JLabel();
        pnlResearch = new javax.swing.JPanel();
        lblResearch = new javax.swing.JLabel();
        lblRemove = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblAuthor = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblDate = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lblCategory = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taText = new javax.swing.JTextArea();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taComment = new javax.swing.JTextArea();
        lblPostComment = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JLabel();
        jpContainer2 = new javax.swing.JScrollPane();
        jpContainer = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1185, 900));

        bg.setBackground(new java.awt.Color(250, 249, 246));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(50, 121, 184));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBack.setBackground(new java.awt.Color(50, 121, 184));

        lblBack.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblBack.setForeground(new java.awt.Color(255, 255, 255));
        lblBack.setText("Back");
        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBackMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlBackLayout = new javax.swing.GroupLayout(pnlBack);
        pnlBack.setLayout(pnlBackLayout);
        pnlBackLayout.setHorizontalGroup(
            pnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblBack)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        pnlBackLayout.setVerticalGroup(
            pnlBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBack, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel2.add(pnlBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 0, 110, 60));

        pnlEducation.setBackground(new java.awt.Color(50, 121, 184));

        lblEducation.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblEducation.setForeground(new java.awt.Color(255, 255, 255));
        lblEducation.setText("Education");
        lblEducation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblEducationMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblEducationMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlEducationLayout = new javax.swing.GroupLayout(pnlEducation);
        pnlEducation.setLayout(pnlEducationLayout);
        pnlEducationLayout.setHorizontalGroup(
            pnlEducationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEducationLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblEducation)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pnlEducationLayout.setVerticalGroup(
            pnlEducationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEducation, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel2.add(pnlEducation, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 130, 60));

        pnlResearch.setBackground(new java.awt.Color(50, 121, 184));

        lblResearch.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblResearch.setForeground(new java.awt.Color(255, 255, 255));
        lblResearch.setText("Research");
        lblResearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblResearchMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblResearchMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout pnlResearchLayout = new javax.swing.GroupLayout(pnlResearch);
        pnlResearch.setLayout(pnlResearchLayout);
        pnlResearchLayout.setHorizontalGroup(
            pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlResearchLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(lblResearch, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlResearchLayout.setVerticalGroup(
            pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblResearch, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel2.add(pnlResearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 130, 60));

        lblRemove.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblRemove.setForeground(new java.awt.Color(250, 249, 246));
        lblRemove.setText("Remove");
        lblRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRemoveMouseClicked(evt);
            }
        });
        jPanel2.add(lblRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 20, -1, -1));

        bg.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1240, 60));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("Blog Post");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jPanel5.setBackground(new java.awt.Color(50, 121, 184));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Post Information");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        bg.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 40));

        jPanel6.setBackground(new java.awt.Color(230, 230, 230));

        lblAuthor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblAuthor.setText("Author:ExempelText");
        lblAuthor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAuthorMouseClicked(evt);
            }
        });

        jLabel2.setText(".....");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAuthor)
                .addGap(52, 52, 52)
                .addComponent(jLabel2)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        bg.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 280, -1));

        jPanel7.setBackground(new java.awt.Color(230, 230, 230));

        lblDate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDate.setText("DATE:ExempelTExt");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        bg.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 280, -1));

        jPanel9.setBackground(new java.awt.Color(230, 230, 230));

        lblCategory.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCategory.setText("CATEGORY");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCategory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        bg.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 280, -1));

        taText.setEditable(false);
        taText.setColumns(20);
        taText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        taText.setRows(5);
        taText.setBorder(null);
        jScrollPane1.setViewportView(taText);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 720, 260));

        jPanel10.setBackground(new java.awt.Color(250, 249, 246));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Comment:");

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        taComment.setColumns(20);
        taComment.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        taComment.setRows(5);
        jScrollPane2.setViewportView(taComment);

        lblPostComment.setBackground(new java.awt.Color(230, 230, 230));
        lblPostComment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPostCommentMouseClicked(evt);
            }
        });

        jLabel10.setText("Post");

        javax.swing.GroupLayout lblPostCommentLayout = new javax.swing.GroupLayout(lblPostComment);
        lblPostComment.setLayout(lblPostCommentLayout);
        lblPostCommentLayout.setHorizontalGroup(
            lblPostCommentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblPostCommentLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18))
        );
        lblPostCommentLayout.setVerticalGroup(
            lblPostCommentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblPostCommentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPostComment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPostComment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bg.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 940, 120));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Latest Comments:");
        bg.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 610, -1, -1));

        jPanel14.setBackground(new java.awt.Color(247, 247, 247));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        bg.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 280, -1));

        btnAdd.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnAdd.setText("Headline:ExempelTExt");
        bg.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 810, 40));

        jpContainer2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jpContainer.setBackground(new java.awt.Color(247, 247, 247));

        javax.swing.GroupLayout jpContainerLayout = new javax.swing.GroupLayout(jpContainer);
        jpContainer.setLayout(jpContainerLayout);
        jpContainerLayout.setHorizontalGroup(
            jpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1027, Short.MAX_VALUE)
        );
        jpContainerLayout.setVerticalGroup(
            jpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 187, Short.MAX_VALUE)
        );

        jpContainer2.setViewportView(jpContainer);

        bg.add(jpContainer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 640, 710, 130));

        lblImage.setText("BILD?");
        bg.add(lblImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 60, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("image link..");
        bg.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 148, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblPostCommentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPostCommentMouseClicked
        // TODO add your handling code here:
        //Add post
        if(!Validate.areaWindowIsEmpty(taComment)) {
            DBInsert.insertComment(conn, user_id, post_id, taComment.getText());
            taComment.setText("");
            jpContainer.removeAll();
            BoxLayoutDemo.addCommentsToPane(jpContainer, post_id, conn);
        }
    }//GEN-LAST:event_lblPostCommentMouseClicked

    private void lblResearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResearchMouseEntered
     pnlResearch.setBackground(new Color(77, 146, 208));
    }//GEN-LAST:event_lblResearchMouseEntered

    private void lblResearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResearchMouseExited
     pnlResearch.setBackground(new Color(50, 121, 184));
    }//GEN-LAST:event_lblResearchMouseExited

    private void lblEducationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEducationMouseEntered
     pnlEducation.setBackground(new Color(77, 146, 208));
    }//GEN-LAST:event_lblEducationMouseEntered

    private void lblEducationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEducationMouseExited
    pnlEducation.setBackground(new Color(50, 121, 184));
    }//GEN-LAST:event_lblEducationMouseExited

    private void lblBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseEntered
    pnlBack.setBackground(new Color(77, 146, 208));
    }//GEN-LAST:event_lblBackMouseEntered

    private void lblBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseExited
    pnlBack.setBackground(new Color(50, 121, 184));
    }//GEN-LAST:event_lblBackMouseExited

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
        
        try {
            new EducationFrame(conn, user_id).setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(BlogPostFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblBackMouseClicked

    private void lblRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRemoveMouseClicked
        DBDelete.removePost(conn, this.post_id);
        dispose();
        try {
            new EducationFrame(conn, user_id);
        } catch (SQLException ex) {
            Logger.getLogger(BlogPostFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblRemoveMouseClicked

    private void lblAuthorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAuthorMouseClicked
        try {
            new ProfilePage(conn, user.getInt("IDEMPLOYEE")).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(BlogPostFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblAuthorMouseClicked

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(BlogPostFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(BlogPostFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(BlogPostFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(BlogPostFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        /*java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new BlogPostFrame().setVisible(true);
//            }
//        });*/
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JLabel btnAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpContainer;
    private javax.swing.JScrollPane jpContainer2;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblEducation;
    private javax.swing.JLabel lblImage;
    private javax.swing.JPanel lblPostComment;
    private javax.swing.JLabel lblRemove;
    private javax.swing.JLabel lblResearch;
    private javax.swing.JPanel pnlBack;
    private javax.swing.JPanel pnlEducation;
    private javax.swing.JPanel pnlResearch;
    private javax.swing.JTextArea taComment;
    private javax.swing.JTextArea taText;
    // End of variables declaration//GEN-END:variables
}
