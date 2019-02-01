/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumprojekt;

import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Kasper
 */
public class DBDelete {
    
    //Removes a user from the database
    public static void removeUser(InfDB db, int id){
        try{
            db.update("Update comments set isdeleted = 1  where employee_idemployee = " + id);
            db.update("Update Events set isdeleted = 1 where Employee_idEmployee = " + id);
            db.delete("Delete from Invited where Employee_idemployee = " + id);
            db.update("Update post set isdeleted = 1 where employee_idemployee = " + id);
            db.update("Update employee set isdeleted = 1 where idemployee = " + id);
        }
        catch(InfException ie){
            System.out.println(ie);
        }
    }
    //Removes a post from the database
    public static void removePost(InfDB db, int postID){
        try{
            db.update("Update post set isdeleted = 1 where idpost = " + postID);
            System.out.println("Post has been removed");
        }
        catch (InfException ie){
            System.out.println(ie);
        }
    }
    //Removes a comment from the database
    public static void removeComment(InfDB db, int commentID){
        try{
            db.update("Update comments set isdeleted = 1 where comment_id = " + commentID);
            System.out.println("Comment has been removed");
        }
        catch(InfException ie){
            System.out.println(ie);
        }
    }
    //Removes an event from the database
    public static void removeEvent(InfDB db, int eventID){
        try{
            db.update("Update events set isdeleted = 1 where idevents = " + eventID);
            System.out.println("Event has been removed");
        }
        catch(InfException ie){
            System.out.println(ie);
        }
    }
    
    
}
