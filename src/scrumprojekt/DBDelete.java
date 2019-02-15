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
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Kasper
 */
public class DBDelete {
    
    //Removes a user from the database
    public static void removeUser(Connection con, int employeeID) {
 
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                   ResultSet.CONCUR_UPDATABLE);
            ResultSet uprs = stmt.executeQuery(
                "SELECT * FROM EMPLOYEE where IDEMPLOYEE = " + employeeID);
 
            while (uprs.next()) {
                uprs.updateString("ISDELETED", "1");
                uprs.updateRow();
            }
 
            if (stmt != null) {
                stmt.close();
            }
        }    
        catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    /**
     * Remove user hard. GDPR
     *
     * @param con
     * @param id
     * @throws SQLException
     */
    public static void removeUserHard(Connection con, int id) {
        Statement stmt = null;
        String queryComments = "DELETE from COMMENTS where EMPLOYEE_IDEMPLOYEE= " + id;
        String queryPost = "DELETE from POST where EMPLOYEE_IDEMPLOYEE= " + id;
        String queryEvent = "DELETE from EVENT where EMPLOYEE_IDEMPLOYEE= " + id;
        String queryInvited = "DELETE from INVITED where EMPLOYE_IDEMPLOYEE= " + id;
        String queryEmployee = "DELETE from EMPLOYEE where IDEMPLOYEE= " + id;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(queryComments);
            stmt.executeUpdate(queryPost);
            stmt.executeUpdate(queryEvent);
            stmt.executeUpdate(queryInvited);
            stmt.executeUpdate(queryEmployee);
            System.out.println("Hard delete complete");
            
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            System.out.println("Hard delete failed" + e);
        }
    }
    
    //Removes a post from the database
    public static void removePost(Connection con, int postID) {
 
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                   ResultSet.CONCUR_UPDATABLE);
            ResultSet uprs = stmt.executeQuery(
                "SELECT * FROM POST where IDPOST = " + postID);
 
            while (uprs.next()) {
                uprs.updateString("ISDELETED", "1");
                uprs.updateRow();
            }
 
            if (stmt != null) {
                stmt.close();
            }
        }    
        catch (SQLException e) {
            System.out.println(e);
        }
    }
    //Removes a comment from the database
    public static void removeComment(Connection con, int commentID) {
 
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                   ResultSet.CONCUR_UPDATABLE);
            ResultSet uprs = stmt.executeQuery(
                "SELECT * FROM COMMENTS where COMMENT_ID = " + commentID);
 
            while (uprs.next()) {
                uprs.updateString("ISDELETED", "1");
                uprs.updateRow();
            }
 
            if (stmt != null) {
                stmt.close();
            }
        }    
        catch (SQLException e ) {
            System.out.println(e);
        }
    }
    //Removes an event from the database
    public static void removeEvent(Connection con, int eventID)  {
 
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                   ResultSet.CONCUR_UPDATABLE);
            ResultSet uprs = stmt.executeQuery(
                "SELECT * FROM EVENT where EVENTID = '" + eventID + "'");
 
            while (uprs.next()) {
           
                uprs.updateString("ISDELETED", "1");
                uprs.updateRow();
            }
            
            if (stmt != null) {
                stmt.close();
            }
 
        }    
        catch (SQLException e ) {
            System.out.println(e);
        }
    }  
  
    
}
