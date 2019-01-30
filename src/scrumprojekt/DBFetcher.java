/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumprojekt;

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
    
}
