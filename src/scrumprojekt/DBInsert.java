/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumprojekt;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author admin
 */
public class DBInsert {
    
    /**
     * 
     * @param db
     * @param user_id
     * @param category
     * @param headline
     * @param text 
     * @return returns 0 if fails, otherwise the id of the new post
     */
    public static int insertPost(InfDB db, int user_id, char category, String headline, String text, String tag) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        String curr_date = dtf.format(localDate);
        int post_id = 0;
        try {
            post_id = Integer.parseInt(db.getAutoIncrement("POST", "IDPOST"));
            db.insert("INSERT INTO POST VALUES(" + post_id + ", '" + text + "', '" + curr_date + "', 0, " + user_id + ", '" + headline + "', '" + category + "', '" + tag + "')");
        }
        catch(InfException e) {
            System.out.println("FAILED TO MAKE POST");
        }
        return post_id;
    }
    
    public static void insertComment(InfDB db, int user_id, int post_id, String text) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        String curr_date = dtf.format(localDate);
        try {
            int comment_id = Integer.parseInt(db.getAutoIncrement("COMMENTS", "COMMENT_ID"));
            db.insert("INSERT INTO COMMENTS VALUES(" + comment_id + ", '" + text + "', 0, '" + curr_date + "', " + user_id + ", " + post_id + ");");
        }
        catch(InfException e) {
            System.out.println("GÅR INTE ATT LÄGGA TILL KOMMENTAR XD");
        }
    }
    
    /**
     *
     * @param db
     * @param date
     * @param description
     */
    public static void insertEvent(InfDB db, String date, String description, int user_id) {
        int id = 0;
        try {
            id = Integer.parseInt(db.getAutoIncrement("EVENTS", "IDEVENTS"));
        } catch (InfException ex) {
            System.out.println("Error");
        }

        try {
            db.insert("INSERT INTO EVENTS VALUES(" + id + ",'" + date + "','" + description + "',0,0," + user_id + ")");
        } catch (InfException e) {
            System.out.println("något gick fel");
        }
    }
    
    public static void addUser(InfDB db, JTextField first1, JTextField last1, JTextField email1, JComboBox rank2, JTextField phone1, JTextField status1)
    {
        
        String id="";
        Random r = new Random( System.currentTimeMillis() );
        int RandomPass = (1 + r.nextInt(2)) * 10000 + r.nextInt(10000);
        int rank1=0;
        try {
            id = db.getAutoIncrement("EMPLOYEE", "IDEMPLOYEE");
            System.out.println("ID Found");
        } catch (InfException ex) {
            Logger.getLogger(DBInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String first = first1.getText();
        String last = last1.getText();
        String email= email1.getText();
        String rank = rank2.getSelectedItem().toString();
        String phone = phone1.getText();
        String status = status1.getText();
        
        //Central Administrator, Education Administrator, Reseach Administrator, Research User, Education User
        if (rank.equals("Central Administrator"))
        {
            rank1=5;
        }
        else if (rank.equals("Education Administrator"))
        {
            rank1=4;
        }
        else if (rank.equals("Research Administrator"))
        {
            rank1=3;
        }
        else if (rank.equals("Education User"))
        {
            rank1=2;
        }
        else if (rank.equals("Research User"))
        {
            rank1=1;
        }
        
        String sql = "INSERT INTO EMPLOYEE (IDEMPLOYEE, FIRSTNAME, LASTNAME, EMAIL, RANK, PHONENUMBER, ACADEMICSTATUS, PASSWORD) VALUES ("+id+",'"+first+"','"+last+"','"+email+"',"+rank1+",'"+phone+"','"+status+"','"+RandomPass+"')";
        
        if((!Validate.textWindowIsEmpty(first1))&&(!Validate.textWindowIsEmpty(last1))&&(!Validate.textWindowIsEmpty(email1))&&(!Validate.textWindowIsEmpty(phone1))&&(!Validate.textWindowIsEmpty(status1))&&(Validate.StringisString(first1))&&(Validate.StringisString(last1))&&(Validate.isValidEmailAddress(email1))&&(Validate.phoneNumber(phone1)))
        {
           
            try
            {
                db.insert(sql);
                JOptionPane.showMessageDialog(null, first+" "+last+" has been added!");
            }
            catch (InfException ex) {
                Logger.getLogger(DBInsert.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Could not add user, check your input");
        }
       
          
    }
    public static void addCategory (InfDB db, String category){
        try{
            db.insert("INSERT INTO CATEGORY VALUES('" + category + "')");
        }
        catch (InfException e){
            System.out.println(e);
        }
    }
    
    public static void insertImage(InfDB db, int post_id, String path) {
        String id = "1";
        try {
            String inc_id = db.getAutoIncrement("IMAGE", "IDIMAGE");
            if(inc_id != null)
                id = inc_id;
            db.insert("INSERT INTO IMAGE VALUES (" + id + ", '" + path + "', " + post_id + ")");
        }
        catch(InfException e) {
            
        }
    }
    
}
