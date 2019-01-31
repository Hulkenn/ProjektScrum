/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumprojekt;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public static int insertPost(InfDB db, int user_id, char category, String headline, String text) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        String curr_date = dtf.format(localDate);
        int post_id = 0;
        try {
            post_id = Integer.parseInt(db.getAutoIncrement("POST", "IDPOST"));
            db.insert("INSERT INTO POST VALUES(" + post_id + ", '" + text + "', '" + curr_date + "', 0, " + user_id + ", '" + headline + "', '" + category + "')");
        }
        catch(InfException e) {
            
        }
        return post_id;
    }
    
}
