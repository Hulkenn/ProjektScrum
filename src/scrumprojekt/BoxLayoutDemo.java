
/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
 
package scrumprojekt;
 
/*
 * BoxLayoutDemo.java requires no other files.
 */
 
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import oru.inf.InfDB;
import oru.inf.InfException;

 
public class BoxLayoutDemo {
    
    
    
    public static void addPostsToPane(Container pane, InfDB db) {
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        
        ArrayList<HashMap<String, String>> posts;
        
        posts = DBFetcher.fetchAllPosts(db, 'E');
        if(posts != null) {
            for (HashMap<String, String> post : posts) 
            {
                int post_id = Integer.parseInt(post.get("IDPOST"));
                addPost(post_id, pane, db);
            } 
        }
    }
    
    public static void addCommentsToPane(Container pane, int post_id, InfDB db) {
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        
        ArrayList<HashMap<String,String>> comments;
        
        
        comments = DBFetcher.fetchAllCommentsPost(db, post_id);
        if(comments != null) {
            for (HashMap<String,String> comment : comments) 
            {
                addComment(comment, pane, db);
            } 
        }
    }
 
    private static void addPost(int post_id, Container container, InfDB db) {
        postPanel post = new postPanel(db, post_id);
        post.setAlignmentX(Component.CENTER_ALIGNMENT);
        post.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(post.getPostId());
                new BlogPostFrame(db, LoginFrame.user_id, post.getPostId()).setVisible(true);
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
    
    private static void addComment(HashMap<String,String> comment, Container container, InfDB db) {
        commentPanel commentPanel = new commentPanel(db, comment);
        commentPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(commentPanel);
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("BoxLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Set up the content pane.
        //addPostsToPane(frame.getContentPane());
        //addCommentsToPane(frame.getContentPane());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}