/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumprojekt;

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
     * @param db
     * @param email
     * @return returns all information about a user with a specified email
     */
    public static HashMap<String,String> fetchUser(InfDB db, String email) {
        HashMap<String,String> user = null;
        try {
            user = db.fetchRow("SELECT * FROM EMPLOYEE WHERE EMAIL = '" + email + "'");
        } 
        catch(InfException e) {
            
        }
        return user;
    }
    
    /**
     * 
     * @param db
     * @param user_id
     * @return returns all info about a user
     */
    public static HashMap<String,String> fetchUser(InfDB db, int user_id) {
        HashMap<String,String> user = null;
        try {
            user = db.fetchRow("SELECT * FROM EMPLOYEE WHERE IDEMPLOYEE = " + user_id);
        } 
        catch(InfException e) {
            
        }
        return user;
    }
    
    /**
     * 
     * @param db
     * @param post_id
     * @return return all info about a post
     */
    public static HashMap<String,String> fetchPost(InfDB db, int post_id) {
        HashMap<String,String> post = null;
        try {
            post = db.fetchRow("SELECT * FROM POST WHERE IDPOST = " + post_id);
        }
        catch(InfException e) {
            
        }
        return post;
    }
    
    /**
     * 
     * @param db
     * @param post_id
     * @return author of post 
     */
    public static int fetchUserIdFromPost(InfDB db, int post_id){
        int user_id = 0;
        try{
             String string = db.fetchSingle("SELECT EMPLOYEE_IDEMPLOYEE FROM POST WHERE IDPOST = "+ post_id); 
             user_id = Integer.parseInt(string);
           }
        catch(InfException e){
            System.out.println(e);
        } 
        return user_id;
    }
    /**
     * 
     * @param db
     * @return returns all posts
     */
    public static ArrayList<HashMap<String,String>> fetchAllPosts(InfDB db) {
        ArrayList<HashMap<String,String>> posts = null;
        try {
            posts = db.fetchRows("SELECT * FROM POST WHERE ISDELETED = 0 ORDER BY IDPOST DESC");
        }
        catch(InfException e) {
            
        }
        return posts;
    }
    
    /**
     * 
     * @param db
     * @param tags
     * @return returns list of posts where the post has one of the tags from @param tags
     */
    public static ArrayList<HashMap<String,String>> fetchAllPostsWithCategories(InfDB db, ArrayList<String> tags) {
        ArrayList<HashMap<String,String>> posts = null;
        try {
            if(tags.size() == 1) {
                posts = db.fetchRows("SELECT * FROM POST WHERE ISDELETED = 0 AND TAG = '" + tags.get(0) + "' ORDER BY IDPOST DESC");
            }
            else if(tags.size() > 1) {
                String query = "SELECT * FROM POST WHERE (TAG = '" + tags.get(0) + "'";
                for(int i = 1; i < tags.size(); i++) {
                    query += " OR TAG = '" + tags.get(i) + "'";
                }
                query += ") AND ISDELETED = 0 ORDER BY IDPOST DESC";
                posts = db.fetchRows(query);
            }
        }
        catch(InfException e) {
            
        }
        return posts;
    }
    
    /**
     * 
     * @param db
     * @param post_id
     * @return returns all comments in a certain post
     */
    public static ArrayList<HashMap<String,String>> fetchAllCommentsPost(InfDB db, int post_id) {
        ArrayList<HashMap<String,String>> comments = null;
        try {
            comments = db.fetchRows("SELECT COMMENT, COMMENT_DATE, FIRSTNAME, LASTNAME FROM COMMENTS JOIN EMPLOYEE ON EMPLOYEE_IDEMPLOYEE = IDEMPLOYEE WHERE POST_IDPOST = " + post_id + "ORDER BY COMMENT_ID DESC;");
        }
        catch(InfException e) {
            
        }
        return comments;
    }
    
    public static int fetchRankFromUser(InfDB db,int employee_ID){
        int rank = 0;
        try{
            String string = db.fetchSingle("SELECT RANK FROM EMPLOYEE WHERE IDEMPLOYEE = " + employee_ID);
            rank = Integer.parseInt(string);
        }
        catch(InfException e){
            System.out.println("fail att hämta rank");
        }
        return rank;
    }
    
    public static ArrayList<HashMap<String,String>> fetchAllUsers(InfDB db){
        ArrayList<HashMap<String,String>> users = null;
        try{
        users = db.fetchRows("SELECT * FROM EMPLOYEE WHERE ISDELETED = 0");
        }
        catch(InfException e){
            
        }
        return users;
    }
    public static ArrayList<HashMap<String,String>> fetchAllUsersEducation(InfDB db){
        ArrayList<HashMap<String,String>> users = null;
        try{
        users = db.fetchRows("SELCET * FROM EMPLOYEE WHERE RANK = 2 AND ISDELETED = 0");
        }
        catch(InfException e){
            
        }
        return users;
    }
    public static ArrayList<HashMap<String,String>> fetchAllUsersResearch(InfDB db){
        ArrayList<HashMap<String,String>> users = null;
        try{
            users = db.fetchRows("SELCET * FROM EMPLOYEE WHERE RANK = 1 AND ISDELETED = 0");
        }
        catch(InfException e){
            
        }
        return users;
    }
    
    public static ArrayList<HashMap<String,String>> fetchAllCategories(InfDB db) {
        ArrayList<HashMap<String,String>> categories = null;
        try {
            categories = db.fetchRows("SELECT * FROM CATEGORY");
        }
        catch(InfException e) {
            
        }
        return categories;
    }
    
     public static boolean checkIfCreatorOfPost(InfDB db, int post_id, String user_id) {
       boolean result = false;
       try{
            String id = db.fetchSingle("SELECT employee_idemployee FROM post WHERE idpost = " + post_id);
            if ( id.equals(user_id)) {
                result = true;
            } 
        }
        catch(InfException ie){
            System.out.println(ie);
        }
        return result;
   }
     
     
}
