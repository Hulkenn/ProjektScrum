/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumprojekt;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
     * @param con
     * @param user_id
     * @param category
     * @param headline
     * @param text
     * @param tag
     * @return
     * @throws SQLException 
     */
    public static int insertPost(Connection con, int user_id, String category, String headline, String text, String tag)
    throws SQLException {
        int post_id = 0;
        Statement stmt = null;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        String currdate = dtf.format(localDate);

        try {
            post_id = 0;
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet uprs = stmt.executeQuery(
                "SELECT * FROM POST");

            uprs.moveToInsertRow();
            uprs.updateString("TEXT", text);
            uprs.updateString("POSTDATE", currdate);
            uprs.updateString("ISDELETED", "0");
            uprs.updateInt("EMPLOYEE_IDEMPLOYEE", user_id);
            uprs.updateString("HEADLINE", headline);
            uprs.updateString("CATEGORY", category);
            uprs.updateString("TAG", tag);

            uprs.insertRow();
            uprs.beforeFirst();
            EmailD.notice(con, user_id);
        } catch (SQLException e ) {
            System.out.println(e);
        }
        return post_id;
    }    
    
    public static void insertComment(Connection con, int user_id, int post_id, String text) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        String curr_date = dtf.format(localDate);
        Statement stmt = null;
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet uprs = stmt.executeQuery(
                "SELECT * FROM COMMENTS");

            uprs.moveToInsertRow();
            uprs.updateString("COMMENT", text);
            uprs.updateString("COMMENT_DATE", curr_date);
            uprs.updateInt("EMPLOYEE_IDEMPLOYEE", user_id);
            uprs.updateInt("POST_IDPOST", post_id);
            uprs.updateInt("ISDELETED", 0);
            
            uprs.insertRow();
            uprs.beforeFirst();
            EmailD.noticeK(con,user_id, post_id);
        }
        catch(SQLException ex) {
            System.out.println("GÅR INTE ATT LÄGGA TILL KOMMENTAR XD");
        }
    }
    
    
    
    
    public static void addUser(Connection con, JTextField first1, JTextField last1, JTextField email1, JComboBox rank2, JTextField phone1, JTextField status1) {

        Statement stmt = null;
        Random r = new Random( System.currentTimeMillis() );
        int randomPass = (1 + r.nextInt(2)) * 10000 + r.nextInt(10000);
        String rank = rank2.getSelectedItem().toString();
        int rank1 = 0;
        
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
        
        
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet uprs = stmt.executeQuery(
                "SELECT * FROM EMPLOYEE");

            uprs.moveToInsertRow();
            uprs.updateString("FIRSTNAME", first1.getText());
            uprs.updateString("LASTNAME", last1.getText());
            uprs.updateString("EMAIL", email1.getText());
            uprs.updateInt("RANK", rank1);
            uprs.updateString("PHONENUMBER", phone1.getText());
            uprs.updateString("ACADEMICSTATUS", status1.getText());
            uprs.updateString("PASSWORD", Integer.toString(randomPass));
            uprs.updateInt("ISDELETED", 0);

            uprs.insertRow();
            uprs.beforeFirst();
            
            stmt.close();
        } 
        catch (SQLException e ) {
            System.out.println(e);
        }
        
    }
    
    public static void addCategory(Connection con, String category)
    throws SQLException {

        Statement stmt = null;
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet uprs = stmt.executeQuery(
                "SELECT * FROM CATEGORY");

            uprs.moveToInsertRow();
            uprs.updateString("CATEGORY", category);

            uprs.insertRow();
            uprs.beforeFirst();
        } catch (SQLException e ) {
            System.out.println(e);
        } finally {
            if (stmt != null) { stmt.close(); }
        }
    }
    
    /**
     *
     * @param db
     * @param date
     * @param description
     */
    public static int insertEvent(Connection con, int user_id, String date, String description, String title, String time, String place){
        int eventId = 0;
        Statement stmt = null;
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
 
            ResultSet uprs = stmt.executeQuery(
                "SELECT * FROM EVENTS");
            
 
            uprs.moveToInsertRow();
            uprs.updateString("EVENTDATE", date);
            uprs.updateString("DESCRIPTION", description);
            uprs.updateInt("ISDELETED", 0);
            uprs.updateInt("ISPRIVATE", 0);
            uprs.updateString("TITLE", title);
            uprs.updateString("TIME", time);
            uprs.updateString("PLACE", place);
            uprs.updateInt("EMPLOYEE_IDEMPLOYEE", user_id);
 
            uprs.insertRow();
            uprs.beforeFirst();
            
            uprs.last();
            
            eventId = uprs.getInt("IDEVENTS");
        }
        catch (SQLException e ) {
            System.out.println(e);
        }
        return eventId;
    }
    
    public static void insertInvitedToEvent(Connection con, int user_id, int event_id) {
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //LocalDate localDate = LocalDate.now();
        //String curr_date = dtf.format(localDate);
        Statement stmt = null;
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet uprs = stmt.executeQuery(
                "SELECT * FROM INVITED_TO_EVENT");

            uprs.moveToInsertRow();
            uprs.updateInt("EMPLOYEE_IDEMPLOYEE", user_id);
            uprs.updateInt("EVENTS_IDEVENTS", event_id);
            uprs.updateInt("ATTENDING", 0);

            uprs.insertRow();
            uprs.beforeFirst();
        }
        catch(SQLException ex) {
            System.out.println(ex);
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
