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
 * @author admin
 */
public class DBUpdate {
    
    public static void updateUser(Connection con, int user_id, int rank, String firstname, String lastname, String mail, String number, String academicstatus, String password) {
        Statement stmt = null;
       
        try {
            stmt = con.createStatement();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet uprs = stmt.executeQuery("SELECT * FROM employee WHERE idemployee=" + user_id);
            while(uprs.next()) {
                uprs.updateInt("RANK", rank);
                uprs.updateString("FIRSTNAME", firstname);
                uprs.updateString("LASTNAME", lastname);
                uprs.updateString("EMAIL", mail);
                uprs.updateString("PHONENUMBER", number);
                uprs.updateString("ACADEMICSTATUS", academicstatus);
                uprs.updateString("PASSWORD", password);
                uprs.updateRow();
            }
            
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
 
    /**
     *
     * @param db
     * @param user_id
     * @param rank
     * @param firstname
     * @param lastname
     * @param mail
     * @param number
     * @param academicstatus
     * @param password
     */
    public static void updateAsUser(Connection con, int user_id, String firstname, String lastname, String mail, String number, String academicstatus, String password,int notis) {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet uprs = stmt.executeQuery("SELECT * FROM employee where idemployee=" + user_id);
            while (uprs.next()){
                uprs.updateString("FIRSTNAME", firstname);
                uprs.updateString("LASTNAME", lastname);
                uprs.updateString("EMAIL", mail);
                uprs.updateString("PHONENUMBER", number);
                uprs.updateString("ACADEMICSTATUS", academicstatus);
                uprs.updateString("PASSWORD", password);
                uprs.updateInt("NOTISERPOST", notis);
                uprs.updateRow();
            }
            
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ie) {
            System.out.println(ie);
        }
    }
 
    /**
     *
     * @param con
     * @param status
     * @param id Updates a users admin status
     */
    public static void updateAdminStatus(Connection con, int status, int id) {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet uprs = stmt.executeQuery(
                    "SELECT * FROM employee where idemployee=" + id);
 
            while (uprs.next()) {
                uprs.getInt("rank");
                uprs.updateInt("rank", status);
                uprs.updateRow();
            }
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ie) {
            System.out.println(ie);
        }
    }
 
    /**
     *
     * @param con
     * @param id Reactivates a deactivated employee
     */
    public static void reactivateEmployee(Connection con, int id) {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet uprs = stmt.executeQuery(
                    "SELECT * FROM employee where idemployee=" + id);
 
            while (uprs.next()) {
                uprs.getInt("isdeleted");
                uprs.updateInt("isdeleted", 0);
                uprs.updateRow();
            }
            
            if (stmt != null) {
                stmt.close();
            }
            System.out.println("Employee has been activated.");
        } catch (SQLException ie) {
            System.out.println(ie);
        }
    }
    
}
