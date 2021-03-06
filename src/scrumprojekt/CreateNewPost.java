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
    private String category;
    private String categoryPost;
    
    private final JFileChooser openFileChooser;
    private BufferedImage originalBI;
    private BufferedImage newBI;
    private String imagePath;

    /**
     * Creates new form CreateNewPost
     */
    public CreateNewPost(Connection conn, int user_id, String category) {
        initComponents();
        this.conn = conn;
        this.user_id = user_id;
        this.category = category;
        this.setLocationRelativeTo(null);
        setResizable(false);
        getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.black));
        lblExist.setVisible(false);
        
        openFileChooser = new JFileChooser();
        openFileChooser.setCurrentDirectory(new File("C:\temp"));
        openFileChooser.setFileFilter(new FileNameExtensionFilter("PNG images", "png"));
        
        try {
            ResultSet categories = DBFetcher.fetchAllCategories(conn);
            while(categories.next()){
                cbxCategory.addItem(categories.getString("CATEGORY"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateNewPost.class.getName()).log(Level.SEVERE, null, ex);
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

        headerPanel = new javax.swing.JPanel();
        labelGoBack = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textareaPost = new javax.swing.JTextArea();
        textfieldHeadline = new javax.swing.JTextField();
        buttonSubmit = new javax.swing.JButton();
        labelAttatchFile = new javax.swing.JLabel();
        cbxCategory = new javax.swing.JComboBox<>();
        btnAddNewCategory = new javax.swing.JButton();
        txtNewCategory = new javax.swing.JTextField();
        lblExist = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        btnAddNewCategory.setText("Add");
        btnAddNewCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnAddNewCategoryMouseReleased(evt);
            }
        });

        txtNewCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewCategoryActionPerformed(evt);
            }
        });

        jLabel10.setText("Category:");

        jLabel11.setText("Add new category:");

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
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonSubmit))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                        .addComponent(textfieldHeadline))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNewCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddNewCategory)
                        .addGap(38, 38, 38)
                        .addComponent(lblExist, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNewCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAddNewCategory)
                        .addComponent(jLabel10)
                        .addComponent(jLabel11))
                    .addComponent(lblExist, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textfieldHeadline, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSubmit)
                    .addComponent(labelAttatchFile))
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
        categoryPost = cbxCategory.getSelectedItem().toString();
        
        if (!Validate.textWindowIsEmpty(textfieldHeadline) && !Validate.areaWindowIsEmpty(textareaPost)) {

            try {
                DBInsert.insertPost(conn, user_id, category, textfieldHeadline.getText(), textareaPost.getText(), categoryPost);
                EmailD.notice(conn, user_id);
                
                dispose();
                
                if(openFileChooser.getSelectedFile() != null) {
                    imageToArray();
                    //saveImage();
                    //DBInsert.insertImage(db, post_id, imagePath);
                }
                
                //new BlogPostFrame(conn, user_id, post_id).setVisible(true);
                //dispose();
            } catch (SQLException ex) {
                Logger.getLogger(CreateNewPost.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_buttonSubmitMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
      
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnAddNewCategoryMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddNewCategoryMouseReleased
        if(!Validate.categoryExist(conn, txtNewCategory.getText())){
            try {
                DBInsert.addCategory(conn, txtNewCategory.getText());
                cbxCategory.removeAllItems();
                lblExist.setText("Category was added");
                ResultSet categories = DBFetcher.fetchAllCategories(conn);
                while(categories.next()){
                    cbxCategory.addItem(categories.getString("CATEGORY"));
                }
                cbxCategory.setSelectedItem(txtNewCategory.getText());
            } catch (SQLException ex) {
                Logger.getLogger(CreateNewPost.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            lblExist.setVisible(true);
        }
    }//GEN-LAST:event_btnAddNewCategoryMouseReleased

    private void txtNewCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNewCategoryActionPerformed

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
    private javax.swing.JButton buttonSubmit;
    private javax.swing.JComboBox<String> cbxCategory;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAttatchFile;
    private javax.swing.JLabel labelGoBack;
    private javax.swing.JLabel lblExist;
    private javax.swing.JTextArea textareaPost;
    private javax.swing.JTextField textfieldHeadline;
    private javax.swing.JTextField txtNewCategory;
    // End of variables declaration//GEN-END:variables
}
