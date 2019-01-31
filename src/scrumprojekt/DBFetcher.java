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
    
    //Returns all information about a user with a specified email
    public static HashMap<String,String> fetchUser(InfDB db, String email) {
        HashMap<String,String> user = null;
        try {
            user = db.fetchRow("SELECT * FROM EMPLOYEE WHERE EMAIL = '" + email + "'");
        } 
        catch(InfException e) {
            
        }
        return user;
    }
    
    public static HashMap<String,String> fetchUser(InfDB db, int user_id) {
        HashMap<String,String> user = null;
        try {
            user = db.fetchRow("SELECT * FROM EMPLOYEE WHERE IDEMPLOYEE = " + user_id);
        } 
        catch(InfException e) {
            
        }
        return user;
    }
    
    public static HashMap<String,String> fetchPost(InfDB db, int post_id) {
        HashMap<String,String> post = null;
        try {
            post = db.fetchRow("SELECT * FROM POST WHERE IDPOST = " + post_id);
        }
        catch(InfException e) {
            
        }
        return post;
    }
    
    public static ArrayList<HashMap<String,String>> fetchAllPosts(InfDB db) {
        ArrayList<HashMap<String,String>> posts = null;
        try {
            posts = db.fetchRows("SELECT * FROM POST WHERE ISDELETED = 0 ORDER BY IDPOST DESC");
        }
        catch(InfException e) {
            
        }
        return posts;
    }
    
}
