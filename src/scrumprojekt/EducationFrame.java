/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumprojekt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import oru.inf.InfDB;

/**
 * ygh
 *
 * @author Joakim
 */

/**
 * 
 * @author admin
 * EducationFrame shows all the posts by categories
 * 
 */
public class EducationFrame extends javax.swing.JFrame {
    
    private Connection conn;
    private int user_id;
    private ResultSet categories;
    private ArrayList<JCheckBox> categoryCheckboxes;
    private ResultSet posts;
    private ArrayList<postPanel> postPanels;
    private ArrayList<String> tags;
    private SimpleDateFormat sqlDateFormat;
    
    /**
     * 
     * @param db = currently opened database
     * @param user_id = currently logged in user_id
     * Creates a new form of educationframe.
     */
    public EducationFrame(Connection conn, int user_id) throws SQLException {
        initComponents();
        this.conn = conn;
        this.user_id = user_id;
        this.categoryCheckboxes = new ArrayList<JCheckBox>();
        this.postPanels = new ArrayList<postPanel>();
        this.tags = new ArrayList<String>();
        this.sqlDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.setLocationRelativeTo(null);
        setResizable(false);
        getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.black));
        
        //Makes pnlCategory and educationforumPosts ready to add components with BoxLayout
        pnlCategory.setLayout(new BoxLayout(pnlCategory, BoxLayout.PAGE_AXIS));
        educationforumPosts.setLayout(new BoxLayout(educationforumPosts, BoxLayout.Y_AXIS));
        
        //Add all posts to the educationforumPosts pane
        posts = DBFetcher.fetchAllPosts(conn, 'E');
        addPostsToPane(educationforumPosts, posts);
        
        //Add all the categories
        categories = DBFetcher.fetchAllCategories(conn);
        if(categories != null) {
            //For every category we have, we add a new JCheckBox and add it to the screen and arraylists, etc..
            while(categories.next()) {
                JCheckBox newCategoryBox = new JCheckBox(categories.getString("CATEGORY"), true);
                newCategoryBox.setForeground(new Color(255,255,255));
                newCategoryBox.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //add or remove tags in tagslist
                        if(newCategoryBox.isSelected()) {
                            tags.add(newCategoryBox.getText());
                        } else {
                            tags.remove(newCategoryBox.getText());
                        }
                        //Remove and add (update) posts
                        removePostsFromPane(educationforumPosts);
                        if(pickerFrom.getDate() != null && pickerTo.getDate() != null) {
                            String startDate = sqlDateFormat.format(pickerFrom.getDate());
                            String endDate = sqlDateFormat.format(pickerTo.getDate());
                            posts = DBFetcher.fetchAllPostsWithCategoriesAndDate(conn, tags, startDate, endDate, 'E');
                        } else {
                            posts = DBFetcher.fetchAllPostsWithCategories(conn, tags, 'E');
                        }
                        addPostsToPane(educationforumPosts, posts);
                    }
                    
                });
                pnlCategory.add(newCategoryBox);
                tags.add(newCategoryBox.getText());
                categoryCheckboxes.add(newCategoryBox);
            }
        }
    }

    /**
     * 
     * @param pane
     * @param posts 
     * adds all the posts to the pane
     */
    public void addPostsToPane(Container pane, ResultSet posts) {
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        if(posts != null) {
            try {
                while(posts.next())
                {
                    int post_id = posts.getInt("IDPOST");
                    addPost(post_id, pane, conn); 
                }
            } catch (SQLException ex) {
                Logger.getLogger(EducationFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        pane.revalidate();
        pane.repaint();
    }
    
    /**
     * 
     * @param post_id
     * @param container
     * @param db
     * adds a new post to postPanels arraylist and adds it to the container to show
     */
    public void addPost(int post_id, Container container, Connection conn) {
        postPanel post = new postPanel(conn, post_id);
        postPanels.add(post);
        post.setAlignmentX(Component.CENTER_ALIGNMENT);
        post.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new BlogPostFrame(conn, LoginFrame.user_id, post.getPostId()).setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
        container.add(post);
    }
    
    /**
     * 
     * @param pane represents the pane to remove components from
     */
    public void removePostsFromPane(Container pane) {
        postPanels.clear();
        pane.removeAll();
        pane.revalidate();
        pane.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        educationHeader = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        lblCreateNewPost = new javax.swing.JLabel();
        lblCreateNewPost1 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lblGoBack = new javax.swing.JLabel();
        lblUpdate = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pickerFrom = new org.jdesktop.swingx.JXDatePicker();
        pickerTo = new org.jdesktop.swingx.JXDatePicker();
        jLabel3 = new javax.swing.JLabel();
        panelScrollSide = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlCategory = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelScroll = new javax.swing.JPanel();
        educationforumPosts = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        educationHeader.setBackground(new java.awt.Color(50, 121, 184));
        educationHeader.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        educationHeader.setPreferredSize(new java.awt.Dimension(1170, 100));

        jLabel25.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(250, 249, 246));
        jLabel25.setText("Education forum");

        lblCreateNewPost.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblCreateNewPost.setForeground(new java.awt.Color(250, 249, 246));
        lblCreateNewPost.setText("New Post +");
        lblCreateNewPost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCreateNewPostMouseClicked(evt);
            }
        });

        lblCreateNewPost1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblCreateNewPost1.setForeground(new java.awt.Color(250, 249, 246));
        lblCreateNewPost1.setText("New Post +");

        jLabel26.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(250, 249, 246));
        jLabel26.setText("Education forum");

        lblGoBack.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        lblGoBack.setForeground(new java.awt.Color(250, 249, 246));
        lblGoBack.setText("<");
        lblGoBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGoBackMouseClicked(evt);
            }
        });

        lblUpdate.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblUpdate.setForeground(new java.awt.Color(250, 249, 246));
        lblUpdate.setText("Update");
        lblUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUpdateMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout educationHeaderLayout = new javax.swing.GroupLayout(educationHeader);
        educationHeader.setLayout(educationHeaderLayout);
        educationHeaderLayout.setHorizontalGroup(
            educationHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, educationHeaderLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCreateNewPost)
                .addGroup(educationHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(educationHeaderLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(lblUpdate)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, educationHeaderLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGoBack)
                        .addGap(68, 68, 68))))
        );
        educationHeaderLayout.setVerticalGroup(
            educationHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, educationHeaderLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(lblUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(educationHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(lblCreateNewPost)
                    .addComponent(lblGoBack))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(250, 249, 246));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBackground(new java.awt.Color(50, 121, 184));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(250, 249, 246));
        jLabel5.setText("Filter posts");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(50, 121, 184));

        jLabel4.setBackground(new java.awt.Color(250, 249, 246));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(250, 249, 246));
        jLabel4.setText("Show posts between");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(250, 249, 246));
        jLabel2.setText("From:");

        pickerFrom.setFormats("yyyy-MM-dd");
        pickerFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pickerFromActionPerformed(evt);
            }
        });

        pickerTo.setFormats("yyyy-MM-dd");
        pickerTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pickerToActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(250, 249, 246));
        jLabel3.setText("To:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(pickerTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(pickerFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pickerFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pickerTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        panelScrollSide.setBackground(new java.awt.Color(250, 249, 246));

        pnlCategory.setBackground(new java.awt.Color(50, 121, 184));
        pnlCategory.setPreferredSize(new java.awt.Dimension(300, 262));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(250, 249, 246));
        jLabel1.setText("Category");

        javax.swing.GroupLayout pnlCategoryLayout = new javax.swing.GroupLayout(pnlCategory);
        pnlCategory.setLayout(pnlCategoryLayout);
        pnlCategoryLayout.setHorizontalGroup(
            pnlCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCategoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(214, Short.MAX_VALUE))
        );
        pnlCategoryLayout.setVerticalGroup(
            pnlCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCategoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(234, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(pnlCategory);

        jScrollPane3.setViewportView(jScrollPane1);

        javax.swing.GroupLayout panelScrollSideLayout = new javax.swing.GroupLayout(panelScrollSide);
        panelScrollSide.setLayout(panelScrollSideLayout);
        panelScrollSideLayout.setHorizontalGroup(
            panelScrollSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelScrollSideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        panelScrollSideLayout.setVerticalGroup(
            panelScrollSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelScrollSideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelScrollSide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelScrollSide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        educationforumPosts.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        educationforumPosts.setPreferredSize(new java.awt.Dimension(1170, 540));

        javax.swing.GroupLayout educationforumPostsLayout = new javax.swing.GroupLayout(educationforumPosts);
        educationforumPosts.setLayout(educationforumPostsLayout);
        educationforumPostsLayout.setHorizontalGroup(
            educationforumPostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );
        educationforumPostsLayout.setVerticalGroup(
            educationforumPostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 591, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelScrollLayout = new javax.swing.GroupLayout(panelScroll);
        panelScroll.setLayout(panelScrollLayout);
        panelScrollLayout.setHorizontalGroup(
            panelScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelScrollLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(educationforumPosts, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelScrollLayout.setVerticalGroup(
            panelScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelScrollLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(educationforumPosts, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane2.setViewportView(panelScroll);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(educationHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 1239, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(educationHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCreateNewPostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCreateNewPostMouseClicked
        // TODO add your handling code here:
        new CreateNewPost(conn, user_id, "E").setVisible(true);
    }//GEN-LAST:event_lblCreateNewPostMouseClicked

    private void lblGoBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGoBackMouseClicked
        try {
            new MainWindow(conn, user_id).setVisible(true);
            dispose();
        } catch (SQLException ex) {
            
        }
    }//GEN-LAST:event_lblGoBackMouseClicked

    private void lblUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUpdateMouseClicked
        try {
            new EducationFrame(conn, user_id).setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(EducationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblUpdateMouseClicked

    private void pickerFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pickerFromActionPerformed
        // TODO add your handling code here:
        if(pickerFrom.getDate() != null && pickerTo.getDate() != null) {
            String startDate = sqlDateFormat.format(pickerFrom.getDate());
            String endDate = sqlDateFormat.format(pickerTo.getDate());
            removePostsFromPane(educationforumPosts);
            posts = DBFetcher.fetchAllPostsWithCategoriesAndDate(conn, tags, startDate.toString(), endDate.toString(), 'E');
            addPostsToPane(educationforumPosts, posts);
        }
    }//GEN-LAST:event_pickerFromActionPerformed

    private void pickerToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pickerToActionPerformed
        // TODO add your handling code here:
        if(pickerFrom.getDate() != null && pickerTo.getDate() != null) {
            String startDate = sqlDateFormat.format(pickerFrom.getDate());
            String endDate = sqlDateFormat.format(pickerTo.getDate());
            removePostsFromPane(educationforumPosts);
            posts = DBFetcher.fetchAllPostsWithCategoriesAndDate(conn, tags, startDate.toString(), endDate.toString(), 'E');
            addPostsToPane(educationforumPosts, posts);
        }
    }//GEN-LAST:event_pickerToActionPerformed

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
            java.util.logging.Logger.getLogger(EducationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EducationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EducationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EducationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
 /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EducationFrame().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel educationHeader;
    private javax.swing.JPanel educationforumPosts;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCreateNewPost;
    private javax.swing.JLabel lblCreateNewPost1;
    private javax.swing.JLabel lblGoBack;
    private javax.swing.JLabel lblUpdate;
    private javax.swing.JPanel panelScroll;
    private javax.swing.JPanel panelScrollSide;
    private org.jdesktop.swingx.JXDatePicker pickerFrom;
    private org.jdesktop.swingx.JXDatePicker pickerTo;
    private javax.swing.JPanel pnlCategory;
    // End of variables declaration//GEN-END:variables
}
