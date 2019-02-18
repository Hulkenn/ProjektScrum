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
import java.util.ArrayList;
import java.util.HashMap;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author admin
 */
public class DBFetcher {
    
    /**
     *
     * @param con
     * @param email
     * @return ID for a user on email input
     *
     */
    public static int fetchId(Connection conn, String email) {
        Statement stmt = null;
        String query = "SELECT idemployee FROM employee WHERE email= '" + email + "'";
        ResultSet rs = null;
        int id = 0;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            rs.next();
            id = rs.getInt("IDEMPLOYEE");
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return id;
    }

    /**
     * 
     * @param conn
     * @param email
     * @return password from user
     */
    public static char[] fetchPassword(Connection conn, String email) {
        Statement stmt = null;
        String query = "SELECT password FROM employee WHERE email= '" + email + "'";
        ResultSet rs = null;
        String password = "";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            rs.next();
            password = rs.getString("password");
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return password.toCharArray();
    }
    
    public static ResultSet fetchUser(Connection con, String email) {
        Statement stmt = null;
        String query = "SELECT * FROM EMPLOYEE WHERE EMAIL = '" + email + "'";
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        } 
        catch(SQLException e) {
            System.out.println("ERROR TO FETCH USER BY EMAIL");
        }
        return rs;
    }
    public static String fetchEmail(Connection con, int user_id){
        Statement stmt = null;
        String query = "SELECT EMAIL FROM EMPLOYEE WHERE IDEMPLOYEE = " + user_id;
        ResultSet rs = null;
        String email = "";
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            rs.next();
            email = rs.getString("EMAIL");
            rs.close();
        } catch(SQLException e){
            System.out.println("ERROR TO FETCH DATE OF EVENT");
        }
        return email;
    }
    
    
    
    public static ResultSet fetchUser(Connection con, int user_id) {
        Statement stmt = null;
        String query = "SELECT * FROM EMPLOYEE WHERE IDEMPLOYEE = " + user_id;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        } 
        catch(SQLException e) {
            System.out.println("ERROR TO FETCH USER");
        }
        return rs;
    }
    
    public static ResultSet fetchPost(Connection con, int post_id) {
        //Returnerar bara en rad
        Statement stmt = null;
        String query = "SELECT * FROM POST WHERE IDPOST = " + post_id;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        }
        catch(SQLException e) {
            System.out.println("EERROR TO FETCH POST");
        }
        return rs;
    }
    
    
    public static int fetchUserIdFromPost(Connection con, int post_id){
        int user_id = 0;
        Statement stmt = null;
        String query = "SELECT EMPLOYEE_IDEMPLOYEE FROM POST WHERE IDPOST = "+ post_id;
        ResultSet rs = null;
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            rs.next();
            user_id = rs.getInt("EMPLOYEE_IDEMPLOYEE");
            rs.close();
        }
        catch(SQLException e){
            System.out.println(e);
        } 
        return user_id;
    }
    
    
    public static ResultSet fetchAllPosts(Connection con, char category) {
        Statement stmt = null;
        String query = "SELECT * FROM POST WHERE ISDELETED = 0 AND CATEGORY = '" + category + "' ORDER BY IDPOST DESC";
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        }
        catch(SQLException e) {
            System.out.println("ERROR TO FETCH ALL POSTS BY CATEGORY ('E', 'R', 'S')");
        }
        return rs;
    }
    
    
    public static ResultSet fetchAllPostsWithCategories(Connection con, ArrayList<String> tags, char category) {
        Statement stmt = null;
        String query = "";
        ResultSet rs = null;
        try {
            if(tags.size() == 1) {
                query = "SELECT * FROM POST WHERE ISDELETED = 0 AND TAG = '" + tags.get(0) + "' AND CATEGORY = '" + category + "' ORDER BY IDPOST DESC";
            }
            else if(tags.size() > 1) {
                query = "SELECT * FROM POST WHERE (TAG = '" + tags.get(0) + "'";
                for(int i = 1; i < tags.size(); i++) {
                    query += " OR TAG = '" + tags.get(i) + "'";
                }
                query += ") AND ISDELETED = 0 AND CATEGORY = '" + category + "' ORDER BY IDPOST DESC";
            }
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        }
        catch(SQLException e) {
            System.out.println("ERROR TO FETCH POSTS WITH CATEGORIES");
        }
        return rs;
    }
    
    
    public static ResultSet fetchAllPostsWithCategoriesAndDate(Connection con, ArrayList<String> tags, String startDate, String endDate, char category) {
        Statement stmt = null;
        String query = "";
        ResultSet rs = null;
        try {
            if(tags.size() == 1) {
                query = "SELECT * FROM POST WHERE ISDELETED = 0 AND TAG = '" + tags.get(0) + "' AND POSTDATE >= '" + startDate + "' AND POSTDATE <= '" + endDate + "' AND CATEGORY = '" + category + "' ORDER BY IDPOST DESC";
            }
            else if(tags.size() > 1) {
                query = "SELECT * FROM POST WHERE (TAG = '" + tags.get(0) + "'";
                for(int i = 1; i < tags.size(); i++) {
                    query += " OR TAG = '" + tags.get(i) + "'";
                }
                query += ") AND ISDELETED = 0 AND POSTDATE >= '" + startDate + "' AND POSTDATE <= '" + endDate + "' AND CATEGORY = '" + category + "' ORDER BY IDPOST DESC";
            }
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        }
        catch(SQLException e) {
            System.out.println("ERROR TO FETCH POSTS WITH CATEGORIES AND DATE");
        }
        return rs;
    }
    
    
    
    public static ResultSet fetchEvents(Connection con, int year, String month) {
        Statement stmt = null;
        String query = "SELECT EVENTDATE FROM EVENTS WHERE EVENTDATE LIKE '" + year + "-" + month + "%'";
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println("ERROR WITH SQL YEAR OR/AND MONTHS");
        }
        return rs;
    }
    
    
    public static ResultSet fetchAllCommentsPost(Connection con, int post_id) {
        Statement stmt = null;
        String query = "SELECT COMMENT, COMMENT_DATE, FIRSTNAME, LASTNAME FROM COMMENTS JOIN EMPLOYEE ON EMPLOYEE_IDEMPLOYEE = IDEMPLOYEE WHERE POST_IDPOST = " + post_id + " ORDER BY COMMENT_ID DESC";
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        }
        catch(SQLException e) {
            System.out.println("ERROR TO FETCH COMMENTS ON A POST");
        }
        return rs;
    }
    
    
    public static int fetchRankFromUser(Connection con, int employee_ID){
        int rank = 0;
        Statement stmt = null;
        String query = "SELECT RANK FROM EMPLOYEE WHERE IDEMPLOYEE = " + employee_ID;
        ResultSet rs = null;
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            rs.next();
            rank = rs.getInt("RANK");
            rs.close();
        }
        catch(SQLException e){
            System.out.println("ERROR TO FETCH RANK");
        }
        return rank;
    }
    
    
    public static ResultSet fetchAllUsers(Connection con){
        Statement stmt = null;
        String query = "SELECT * FROM EMPLOYEE WHERE ISDELETED = 0";
        ResultSet rs = null;
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        }
        catch(SQLException e){
            System.out.println("ERROR TO FETCH ALL EMPLOYEE");
        }
        return rs;
    }
    
    public static ResultSet fetchAllUsersEducation(Connection con){
        Statement stmt = null;
        String query = "SELECT * FROM EMPLOYEE WHERE RANK = 2 AND ISDELETED 0";
        ResultSet rs = null;
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        }
        catch(SQLException e){
            System.out.println("ERROR TO FETCH EDUCATION EMPLOYEE");
        }
        return rs;
    }
    
    public static ResultSet fetchAllUsersResearch(Connection con){
        Statement stmt = null;
        String query = "SELECT * FROM EMPLOYEE WHERE RANK = 1 AND ISDELETED = 0";
        ResultSet rs = null;
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        }
        catch(SQLException e){
            System.out.println("ERROR TO GET RESEARCH EMPLOYEE");
        }
        return rs;
    }
    
    public static ResultSet fetchAllCategories(Connection con) {
        Statement stmt = null;
        String query = "SELECT * FROM CATEGORY";
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        }
        catch(SQLException e) {
            
        }
        return rs;
    }
    
    public static boolean checkIfCreatorOfPost(Connection con, int post_id, int user_id) {
        Statement stmt = null;
        String query = "SELECT EMPLOYEE_IDEMPLOYEE FROM POST WHERE IDPOST = " + post_id;
        ResultSet rs = null;
        boolean result = false;
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            rs.next();
            int id = rs.getInt("EMPLOYEE_IDEMPLOYEE");
            rs.close();
            if(id == user_id) {
                result = true;
            } 
        }
        catch(SQLException e){
            System.out.println("ERROR TO GET ID OF EMPLOYEE OF THE POST");
        }
        return result;
    }
    
    public static String fetchDateofEvent(Connection con, int postID){
        Statement stmt = null;
        String query = "SELECT EVENTDATE FROM EVENTS WHERE IDEVENTS = " + postID;
        ResultSet rs = null;
        String date = "";
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            rs.next();
            date = rs.getDate("EVENTDATE").toString();
            rs.close();
        } catch(SQLException e){
            System.out.println("ERROR TO FETCH DATE OF EVENT");
        }
        return date;
    }
    
    public static ResultSet fetchAllEvents(Connection con, String date) throws SQLException{
        Statement stmt = null;
        String query = "SELECT * FROM EVENTS JOIN EMPLOYEE ON EMPLOYEE_IDEMPLOYEE = IDEMPLOYEE WHERE EVENTDATE = '" + date + "'";
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        } catch(SQLException e) {
            System.out.println("ERROR TO FETCH EVENTS");
        }
        return rs;
    }
    
    //INTE OMVANDLAD FÖR VETTEFAN VAD VI SKA GÖRA MED DENNA XD
    public static String fetchImagePath(InfDB db, int post_id) {
        String path = "";
        try {
            path = db.fetchSingle("SELECT PATHTOIMAGE FROM IMAGE JOIN POST ON POST_IDPOST = IDPOST WHERE IDPOST = " + post_id);
        }
        catch(InfException e) {
            
        }
        return path;
    }
}
