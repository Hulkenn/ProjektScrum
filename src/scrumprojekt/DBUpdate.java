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
 * @author admin
 */
public class DBUpdate {
    
    //Updates a users password
    public static void updatePassword(InfDB db, char[] newPass, int id){
        try{
            String st ="";
            for(char c : newPass){
                st +=c;
            }
            db.update("Update employee set password = " + st + " where idemployee = " + id);
        }
        catch(InfException ie){
            System.out.println(ie);
        }
    }
    
    //Updates a users admin status
    public static void updateAdminStatus(InfDB db, int status, int id){
        try{
            db.update("Update employee set rank = " + status + " where idemployee = " + id);
        }
        catch(InfException ie){
            System.out.println(ie);
        }
    }
    //Reactivates a deactivated employee
    public static void reactivateEmployee(InfDB db, int id){
        try{
            db.update("Update employee set isdeleted = 0 where idemployee = " + id);
            System.out.println("Employee has been activated.");
        }
        catch(InfException ie){
            System.out.println(ie);
        }
    }

}
