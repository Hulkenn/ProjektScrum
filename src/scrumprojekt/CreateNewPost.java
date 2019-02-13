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
import java.util.ArrayList;
import java.util.HashMap;
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

    private InfDB db;
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
    public CreateNewPost(InfDB db, int user_id, char category) {
        initComponents();
        this.db = db;
        this.user_id = user_id;
        this.category = category;
        this.setLocationRelativeTo(null);
        setResizable(false);
        getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.black));
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
        btnChoose = new javax.swing.JButton();
        txtNewCategory = new javax.swing.JTextField();
        lblExist = new javax.swing.JLabel();

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

        cbxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teaching", "Important", "News", "Math", "Programming" }));
        cbxCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoryActionPerformed(evt);
            }
        });

        btnAddNewCategory.setText("Add");
        btnAddNewCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnAddNewCategoryMouseReleased(evt);
            }
        });
        btnAddNewCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewCategoryActionPerformed(evt);
            }
        });

        btnChoose.setText("Choose");
        btnChoose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnChooseMouseReleased(evt);
            }
        });
        btnChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseActionPerformed(evt);
            }
        });

        txtNewCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewCategoryActionPerformed(evt);
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
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonSubmit))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                        .addComponent(textfieldHeadline))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChoose)
                        .addGap(59, 59, 59)
                        .addComponent(txtNewCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddNewCategory)
                        .addGap(18, 18, 18)
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
                        .addComponent(btnAddNewCategory)
                        .addComponent(btnChoose)
                        .addComponent(txtNewCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        if (!Validate.textWindowIsEmpty(textfieldHeadline) && !Validate.areaWindowIsEmpty(textareaPost)) {

            int post_id = DBInsert.insertPost(db, user_id, category, textfieldHeadline.getText(), textareaPost.getText(), categoryPost);

            
            
            if(openFileChooser.getSelectedFile() != null) {
                imageToArray();
                saveImage();
                DBInsert.insertImage(db, post_id, imagePath);
            }

            new BlogPostFrame(db, user_id, post_id).setVisible(true);
            dispose();
        }


    }//GEN-LAST:event_buttonSubmitMouseClicked

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

    private void cbxCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCategoryActionPerformed

    private void btnAddNewCategoryMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddNewCategoryMouseReleased
       if(!Validate.categoryExist(db, txtNewCategory.getText())){
            DBInsert.addCategory(db, txtNewCategory.getText());
            lblExist.setText("Category was added");
            ArrayList<HashMap<String, String>> list = DBFetcher.fetchAllCategories(db);
            for(HashMap<String, String> category : list){
                cbxCategory.addItem(category.get("CATEGORY"));
            }
            cbxCategory.setSelectedItem(txtNewCategory.getText());
        }
        else{
            lblExist.setVisible(true);
        }
    }//GEN-LAST:event_btnAddNewCategoryMouseReleased

    private void btnAddNewCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddNewCategoryActionPerformed

    private void btnChooseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChooseMouseReleased
        categoryPost = cbxCategory.getSelectedItem().toString();
    }//GEN-LAST:event_btnChooseMouseReleased

    private void btnChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChooseActionPerformed

    private void txtNewCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNewCategoryActionPerformed

    private void imageToArray(){
        int width = originalBI.getWidth();
        int height = originalBI.getHeight();

        newBI = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newBI.createGraphics();
        g.drawImage(originalBI, 0, 0, width, height, null);
        g.dispose();

    }


    private void saveImage(){
        String id = "1";
        try {
            String inc_id = db.getAutoIncrement("IMAGE", "IDIMAGE");
            if(inc_id != null)
                id = inc_id;
        }
        catch(InfException e) {
            
        }
        File ops = new File(System.getProperty("user.dir")+"\\Files\\" + id
                 + ".png");
        imagePath = "Files\\" + id + ".png";
        
        try{
            ImageIO.write(newBI, "png",ops);
            //lblMessage.setText("Image File Succesfully saved"); 
        }catch(IOException ex){
            //lblMessage.setText("Failed to save image file");
        }
    }
    
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
    private javax.swing.JButton btnChoose;
    private javax.swing.JButton buttonSubmit;
    private javax.swing.JComboBox<String> cbxCategory;
    private javax.swing.JPanel headerPanel;
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
