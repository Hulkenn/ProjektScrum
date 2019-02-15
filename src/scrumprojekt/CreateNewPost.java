/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumprojekt;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Joakim
 */
public class CreateNewPost extends javax.swing.JFrame {

    private Connection conn;
    private int user_id;
    private char category;
    private String categoryPost;
    
    private final JFileChooser openFileChooser;
    private BufferedImage originalBI;
    private BufferedImage newBI;
    private String imagePath;

    /**
     * Creates new form CreateNewPost
     */
    public CreateNewPost(Connection conn, int user_id, char category) {
        initComponents();
        this.conn = conn;
        this.user_id = user_id;
        this.category = category;
        this.setLocationRelativeTo(null);
        setResizable(false);
        getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.black));
        diaChooseCategory.setLocationRelativeTo(null);
        diaChooseCategory.setResizable(false);
        diaChooseCategoryFile.setLocationRelativeTo(null);
        diaChooseCategoryFile.setResizable(false);
        lblExist.setVisible(false);
        
        openFileChooser = new JFileChooser();
        openFileChooser.setCurrentDirectory(new File("C:\temp"));
        openFileChooser.setFileFilter(new FileNameExtensionFilter("PNG images", "png"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        diaChooseCategory = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cbxCategory = new javax.swing.JComboBox<>();
        txtNewCategory = new javax.swing.JTextField();
        btnAddNewCategory = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnChoose = new javax.swing.JButton();
        lblExist = new javax.swing.JLabel();
        diaChooseCategoryFile = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        cbxCategoryFile = new javax.swing.JComboBox<>();
        txtNewCategoryFile = new javax.swing.JTextField();
        btnAddNewFile = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnChooseFile = new javax.swing.JButton();
        headerPanel = new javax.swing.JPanel();
        labelGoBack = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textareaPost = new javax.swing.JTextArea();
        textfieldHeadline = new javax.swing.JTextField();
        buttonSubmit = new javax.swing.JButton();
        labelAttatchFile = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        diaChooseCategory.setUndecorated(true);
        diaChooseCategory.setResizable(false);
        diaChooseCategory.setSize(new java.awt.Dimension(385, 245));

        jPanel1.setBackground(new java.awt.Color(50, 121, 184));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(250, 249, 246));
        jLabel4.setText("Category");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(250, 249, 246));
        jLabel5.setText("Cancel");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(250, 249, 246));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setFocusTraversalPolicyProvider(true);

        cbxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teaching", "Important", "News", "Math", "Programming" }));

        txtNewCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewCategoryActionPerformed(evt);
            }
        });

        btnAddNewCategory.setText("Add");
        btnAddNewCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnAddNewCategoryMouseReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel1.setText("Choose Existing:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel3.setText("Add New:");

        btnChoose.setText("Choose");
        btnChoose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnChooseMouseReleased(evt);
            }
        });

        lblExist.setText("The category already exists");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxCategory, 0, 100, Short.MAX_VALUE)
                    .addComponent(txtNewCategory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnChoose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddNewCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(118, Short.MAX_VALUE)
                .addComponent(lblExist)
                .addGap(103, 103, 103))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnChoose)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtNewCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddNewCategory))
                .addGap(18, 18, 18)
                .addComponent(lblExist)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout diaChooseCategoryLayout = new javax.swing.GroupLayout(diaChooseCategory.getContentPane());
        diaChooseCategory.getContentPane().setLayout(diaChooseCategoryLayout);
        diaChooseCategoryLayout.setHorizontalGroup(
            diaChooseCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        diaChooseCategoryLayout.setVerticalGroup(
            diaChooseCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diaChooseCategoryLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        diaChooseCategoryFile.setUndecorated(true);
        diaChooseCategoryFile.setResizable(false);
        diaChooseCategoryFile.setSize(new java.awt.Dimension(385, 245));

        jPanel3.setBackground(new java.awt.Color(50, 121, 184));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(250, 249, 246));
        jLabel6.setText("Category");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(250, 249, 246));
        jLabel7.setText("Cancel");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(250, 249, 246));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setFocusTraversalPolicyProvider(true);

        cbxCategoryFile.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAddNewFile.setText("Add");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel8.setText("Choose Existing:");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel9.setText("Add New:");

        btnChooseFile.setText("Choose");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxCategoryFile, 0, 100, Short.MAX_VALUE)
                    .addComponent(txtNewCategoryFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnChooseFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddNewFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxCategoryFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnChooseFile)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtNewCategoryFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddNewFile))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout diaChooseCategoryFileLayout = new javax.swing.GroupLayout(diaChooseCategoryFile.getContentPane());
        diaChooseCategoryFile.getContentPane().setLayout(diaChooseCategoryFileLayout);
        diaChooseCategoryFileLayout.setHorizontalGroup(
            diaChooseCategoryFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        diaChooseCategoryFileLayout.setVerticalGroup(
            diaChooseCategoryFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diaChooseCategoryFileLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        headerPanel.setBackground(new java.awt.Color(50, 121, 184));
        headerPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelGoBack.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        labelGoBack.setForeground(new java.awt.Color(250, 249, 246));
        labelGoBack.setText("<");
        labelGoBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelGoBackMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(250, 249, 246));
        jLabel2.setText("Create a new post");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 409, Short.MAX_VALUE)
                .addComponent(labelGoBack)
                .addGap(44, 44, 44))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelGoBack))
                .addContainerGap())
        );

        textareaPost.setColumns(20);
        textareaPost.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        textareaPost.setRows(5);
        textareaPost.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(textareaPost);

        textfieldHeadline.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        textfieldHeadline.setText("Headline:");
        textfieldHeadline.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        buttonSubmit.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        buttonSubmit.setText("Submit");
        buttonSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSubmitMouseClicked(evt);
            }
        });

        labelAttatchFile.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labelAttatchFile.setText("+ Attatch file");
        labelAttatchFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAttatchFileMouseClicked(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setText("Chose Category");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton2.setText("File Category");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(labelAttatchFile)
                            .addGap(18, 18, 18)
                            .addComponent(jButton2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonSubmit))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                        .addComponent(textfieldHeadline))
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textfieldHeadline, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSubmit)
                    .addComponent(labelAttatchFile)
                    .addComponent(jButton2))
                .addGap(0, 26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelGoBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelGoBackMouseClicked
        // TODO add your handling code here:
        //  new EducationFrame(db, user_id).setVisible(true);
        dispose();
    }//GEN-LAST:event_labelGoBackMouseClicked

    private void buttonSubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSubmitMouseClicked
        // TODO add your handling code here:
        //Lägg till post

        if (!Validate.textWindowIsEmpty(textfieldHeadline) && !Validate.areaWindowIsEmpty(textareaPost)) {

            //int post_id = DBInsert.insertPost(conn, user_id, category, textfieldHeadline.getText(), textareaPost.getText(), categoryPost);

            JOptionPane.showMessageDialog(rootPane, "Post submitted");
            
            if(openFileChooser.getSelectedFile() != null) {
                imageToArray();
                //saveImage();
                //DBInsert.insertImage(db, post_id, imagePath);
            }

            //new BlogPostFrame(conn, user_id, post_id).setVisible(true);
            //dispose();
        }


    }//GEN-LAST:event_buttonSubmitMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        diaChooseCategory.setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            diaChooseCategory.setVisible(true);
            ResultSet categories = DBFetcher.fetchAllCategories(conn);
            while(categories.next()){
                cbxCategory.addItem(categories.getString("CATEGORY"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateNewPost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        diaChooseCategoryFile.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnAddNewCategoryMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddNewCategoryMouseReleased
//        if(!Validate.categoryExist(db, txtNewCategory.getText())){
//            try {
//                DBInsert.addCategory(db, txtNewCategory.getText());
//                lblExist.setText("Category was added");
//                ResultSet categories = DBFetcher.fetchAllCategories(conn);
//                while(categories.next()){
//                    cbxCategory.addItem(categories.getString("CATEGORY"));
//                }
//                cbxCategory.setSelectedItem(txtNewCategory.getText());
//            } catch (SQLException ex) {
//                Logger.getLogger(CreateNewPost.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        else{
//            lblExist.setVisible(true);
//        }
    }//GEN-LAST:event_btnAddNewCategoryMouseReleased

    private void txtNewCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNewCategoryActionPerformed

    private void btnChooseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChooseMouseReleased
        categoryPost = cbxCategory.getSelectedItem().toString();
        diaChooseCategory.setVisible(false);
        
    }//GEN-LAST:event_btnChooseMouseReleased

    private void labelAttatchFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAttatchFileMouseClicked
        // TODO add your handling code here:
        //lägg till kod
        int returnValue = openFileChooser.showOpenDialog(this);

        if(returnValue == JFileChooser.APPROVE_OPTION) {
            try{
            originalBI = ImageIO.read(openFileChooser.getSelectedFile());
            //lblMessage.setText("Image File Succesfully loaded");
            }catch(IOException ex){
                //lblMessage.setText("Failed to load image");
            }
        }
        else{
            //lblMessage.setText("No file Choosen");
        }
    }//GEN-LAST:event_labelAttatchFileMouseClicked

    private void imageToArray(){
        int width = originalBI.getWidth();
        int height = originalBI.getHeight();

        newBI = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newBI.createGraphics();
        g.drawImage(originalBI, 0, 0, width, height, null);
        g.dispose();

    }


//    private void saveImage(){
//        String id = "1";
//        try {
//            String inc_id = db.getAutoIncrement("IMAGE", "IDIMAGE");
//            if(inc_id != null)
//                id = inc_id;
//        }
//        catch(InfException e) {
//            
//        }
//        File ops = new File(System.getProperty("user.dir")+"\\Files\\" + id
//                 + ".png");
//        imagePath = "Files\\" + id + ".png";
//        
//        try{
//            ImageIO.write(newBI, "png",ops);
//            //lblMessage.setText("Image File Succesfully saved"); 
//        }catch(IOException ex){
//            //lblMessage.setText("Failed to save image file");
//        }
//    }
    
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
            java.util.logging.Logger.getLogger(CreateNewPost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateNewPost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateNewPost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateNewPost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
 /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateNewPost().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewCategory;
    private javax.swing.JButton btnAddNewFile;
    private javax.swing.JButton btnChoose;
    private javax.swing.JButton btnChooseFile;
    private javax.swing.JButton buttonSubmit;
    private javax.swing.JComboBox<String> cbxCategory;
    private javax.swing.JComboBox<String> cbxCategoryFile;
    private javax.swing.JDialog diaChooseCategory;
    private javax.swing.JDialog diaChooseCategoryFile;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAttatchFile;
    private javax.swing.JLabel labelGoBack;
    private javax.swing.JLabel lblExist;
    private javax.swing.JTextArea textareaPost;
    private javax.swing.JTextField textfieldHeadline;
    private javax.swing.JTextField txtNewCategory;
    private javax.swing.JTextField txtNewCategoryFile;
    // End of variables declaration//GEN-END:variables
}
