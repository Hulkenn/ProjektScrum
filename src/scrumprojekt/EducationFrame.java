/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumprojekt;

/**
 *ygh
 * @author Joakim
 */
public class EducationFrame extends javax.swing.JFrame {

    /**
     * Creates new form EducationFrame
     */
    public EducationFrame() {
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        educationforumPosts = new javax.swing.JPanel();
        postOne = new javax.swing.JPanel();
        headlinePostOne = new javax.swing.JLabel();
        imagePostOne = new javax.swing.JLabel();
        authorPostOne = new javax.swing.JLabel();
        datePostOne = new javax.swing.JLabel();
        lastReplyPostOne = new javax.swing.JLabel();
        dateLastReplyPostOne = new javax.swing.JLabel();
        postTwo = new javax.swing.JPanel();
        headlinePostTwo = new javax.swing.JLabel();
        imagePostTwo = new javax.swing.JLabel();
        authorPostTwo = new javax.swing.JLabel();
        datePostTwo = new javax.swing.JLabel();
        lastReplyPostTwo = new javax.swing.JLabel();
        dateLastReplyPostTwo = new javax.swing.JLabel();
        postThree = new javax.swing.JPanel();
        headlinePostThree = new javax.swing.JLabel();
        imagePostThree = new javax.swing.JLabel();
        authorPostThree = new javax.swing.JLabel();
        datePostThree = new javax.swing.JLabel();
        lastReplyPostThree = new javax.swing.JLabel();
        dateLastReplyPostThree = new javax.swing.JLabel();
        postFour = new javax.swing.JPanel();
        headlinePostFour = new javax.swing.JLabel();
        imagePostFour = new javax.swing.JLabel();
        authorPostFour = new javax.swing.JLabel();
        datePostFour = new javax.swing.JLabel();
        lastReplyPostFour = new javax.swing.JLabel();
        dateLastReplyPostFour = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        educationHeader.setBackground(new java.awt.Color(50, 121, 184));
        educationHeader.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        educationHeader.setPreferredSize(new java.awt.Dimension(1170, 100));

        jLabel25.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(250, 249, 246));
        jLabel25.setText("Education forum");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(250, 249, 246));
        jLabel1.setText("New Post +");

        javax.swing.GroupLayout educationHeaderLayout = new javax.swing.GroupLayout(educationHeader);
        educationHeader.setLayout(educationHeaderLayout);
        educationHeaderLayout.setHorizontalGroup(
            educationHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(educationHeaderLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 662, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(66, 66, 66))
        );
        educationHeaderLayout.setVerticalGroup(
            educationHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(educationHeaderLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(educationHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel1))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        educationforumPosts.setPreferredSize(new java.awt.Dimension(1170, 540));

        postOne.setBackground(new java.awt.Color(250, 249, 246));
        postOne.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        headlinePostOne.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        headlinePostOne.setText("Headline:");

        imagePostOne.setText("IMAGE");

        authorPostOne.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        authorPostOne.setText("Author");

        datePostOne.setText("Date and time");

        lastReplyPostOne.setText("Last reply");

        dateLastReplyPostOne.setText("Date and time ");

        javax.swing.GroupLayout postOneLayout = new javax.swing.GroupLayout(postOne);
        postOne.setLayout(postOneLayout);
        postOneLayout.setHorizontalGroup(
            postOneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(postOneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagePostOne)
                .addGap(17, 17, 17)
                .addGroup(postOneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headlinePostOne)
                    .addGroup(postOneLayout.createSequentialGroup()
                        .addComponent(authorPostOne)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(datePostOne)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(postOneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastReplyPostOne)
                    .addComponent(dateLastReplyPostOne))
                .addGap(127, 127, 127))
        );
        postOneLayout.setVerticalGroup(
            postOneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(postOneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(postOneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(headlinePostOne)
                    .addComponent(imagePostOne)
                    .addComponent(lastReplyPostOne))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(postOneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(postOneLayout.createSequentialGroup()
                        .addGap(0, 7, Short.MAX_VALUE)
                        .addGroup(postOneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(datePostOne)
                            .addComponent(authorPostOne)))
                    .addGroup(postOneLayout.createSequentialGroup()
                        .addComponent(dateLastReplyPostOne)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        postTwo.setBackground(new java.awt.Color(250, 249, 246));
        postTwo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        headlinePostTwo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        headlinePostTwo.setText("Headline:");

        imagePostTwo.setText("IMAGE");

        authorPostTwo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        authorPostTwo.setText("Author");

        datePostTwo.setText("Date and time");

        lastReplyPostTwo.setText("Last reply");

        dateLastReplyPostTwo.setText("Date and time ");

        javax.swing.GroupLayout postTwoLayout = new javax.swing.GroupLayout(postTwo);
        postTwo.setLayout(postTwoLayout);
        postTwoLayout.setHorizontalGroup(
            postTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(postTwoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagePostTwo)
                .addGap(17, 17, 17)
                .addGroup(postTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headlinePostTwo)
                    .addGroup(postTwoLayout.createSequentialGroup()
                        .addComponent(authorPostTwo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(datePostTwo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 745, Short.MAX_VALUE)
                .addGroup(postTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastReplyPostTwo)
                    .addComponent(dateLastReplyPostTwo))
                .addGap(127, 127, 127))
        );
        postTwoLayout.setVerticalGroup(
            postTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(postTwoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(postTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(headlinePostTwo)
                    .addComponent(imagePostTwo)
                    .addComponent(lastReplyPostTwo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(postTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(postTwoLayout.createSequentialGroup()
                        .addGap(0, 7, Short.MAX_VALUE)
                        .addGroup(postTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(datePostTwo)
                            .addComponent(authorPostTwo)))
                    .addGroup(postTwoLayout.createSequentialGroup()
                        .addComponent(dateLastReplyPostTwo)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        postThree.setBackground(new java.awt.Color(250, 249, 246));
        postThree.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        headlinePostThree.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        headlinePostThree.setText("Headline:");

        imagePostThree.setText("IMAGE");

        authorPostThree.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        authorPostThree.setText("Author");

        datePostThree.setText("Date and time");

        lastReplyPostThree.setText("Last reply");

        dateLastReplyPostThree.setText("Date and time ");

        javax.swing.GroupLayout postThreeLayout = new javax.swing.GroupLayout(postThree);
        postThree.setLayout(postThreeLayout);
        postThreeLayout.setHorizontalGroup(
            postThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(postThreeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagePostThree)
                .addGap(17, 17, 17)
                .addGroup(postThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headlinePostThree)
                    .addGroup(postThreeLayout.createSequentialGroup()
                        .addComponent(authorPostThree)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(datePostThree)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 745, Short.MAX_VALUE)
                .addGroup(postThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastReplyPostThree)
                    .addComponent(dateLastReplyPostThree))
                .addGap(127, 127, 127))
        );
        postThreeLayout.setVerticalGroup(
            postThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(postThreeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(postThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(headlinePostThree)
                    .addComponent(imagePostThree)
                    .addComponent(lastReplyPostThree))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(postThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(postThreeLayout.createSequentialGroup()
                        .addGap(0, 7, Short.MAX_VALUE)
                        .addGroup(postThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(datePostThree)
                            .addComponent(authorPostThree)))
                    .addGroup(postThreeLayout.createSequentialGroup()
                        .addComponent(dateLastReplyPostThree)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        postFour.setBackground(new java.awt.Color(250, 249, 246));
        postFour.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        headlinePostFour.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        headlinePostFour.setText("Headline:");

        imagePostFour.setText("IMAGE");

        authorPostFour.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        authorPostFour.setText("Author");

        datePostFour.setText("Date and time");

        lastReplyPostFour.setText("Last reply");

        dateLastReplyPostFour.setText("Date and time ");

        javax.swing.GroupLayout postFourLayout = new javax.swing.GroupLayout(postFour);
        postFour.setLayout(postFourLayout);
        postFourLayout.setHorizontalGroup(
            postFourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(postFourLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagePostFour)
                .addGap(17, 17, 17)
                .addGroup(postFourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headlinePostFour)
                    .addGroup(postFourLayout.createSequentialGroup()
                        .addComponent(authorPostFour)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(datePostFour)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 745, Short.MAX_VALUE)
                .addGroup(postFourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastReplyPostFour)
                    .addComponent(dateLastReplyPostFour))
                .addGap(127, 127, 127))
        );
        postFourLayout.setVerticalGroup(
            postFourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(postFourLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(postFourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(headlinePostFour)
                    .addComponent(imagePostFour)
                    .addComponent(lastReplyPostFour))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(postFourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(postFourLayout.createSequentialGroup()
                        .addGap(0, 7, Short.MAX_VALUE)
                        .addGroup(postFourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(datePostFour)
                            .addComponent(authorPostFour)))
                    .addGroup(postFourLayout.createSequentialGroup()
                        .addComponent(dateLastReplyPostFour)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout educationforumPostsLayout = new javax.swing.GroupLayout(educationforumPosts);
        educationforumPosts.setLayout(educationforumPostsLayout);
        educationforumPostsLayout.setHorizontalGroup(
            educationforumPostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(postTwo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(postThree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(postFour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(postOne, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        educationforumPostsLayout.setVerticalGroup(
            educationforumPostsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(educationforumPostsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(postOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(postTwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(postThree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(postFour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(201, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(educationHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(educationforumPosts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(educationHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(educationforumPosts, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EducationFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorPostFour;
    private javax.swing.JLabel authorPostOne;
    private javax.swing.JLabel authorPostThree;
    private javax.swing.JLabel authorPostTwo;
    private javax.swing.JLabel dateLastReplyPostFour;
    private javax.swing.JLabel dateLastReplyPostOne;
    private javax.swing.JLabel dateLastReplyPostThree;
    private javax.swing.JLabel dateLastReplyPostTwo;
    private javax.swing.JLabel datePostFour;
    private javax.swing.JLabel datePostOne;
    private javax.swing.JLabel datePostThree;
    private javax.swing.JLabel datePostTwo;
    private javax.swing.JPanel educationHeader;
    private javax.swing.JPanel educationforumPosts;
    private javax.swing.JLabel headlinePostFour;
    private javax.swing.JLabel headlinePostOne;
    private javax.swing.JLabel headlinePostThree;
    private javax.swing.JLabel headlinePostTwo;
    private javax.swing.JLabel imagePostFour;
    private javax.swing.JLabel imagePostOne;
    private javax.swing.JLabel imagePostThree;
    private javax.swing.JLabel imagePostTwo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel lastReplyPostFour;
    private javax.swing.JLabel lastReplyPostOne;
    private javax.swing.JLabel lastReplyPostThree;
    private javax.swing.JLabel lastReplyPostTwo;
    private javax.swing.JPanel postFour;
    private javax.swing.JPanel postOne;
    private javax.swing.JPanel postThree;
    private javax.swing.JPanel postTwo;
    // End of variables declaration//GEN-END:variables
}
