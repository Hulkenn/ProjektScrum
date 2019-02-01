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
    
    public static void updateUser(InfDB db,int user_id,int rank,String firstname,String lastname,String mail,String number,String academicstatus,String password){
        try{
        db.update("UPDATE EMPLOYEE SET FIRSTNAME = '" + firstname + "',LASTNAME ='"+lastname+"', EMAIL = '"+mail+"',RANK = "+rank+" ,PHONENUMBER = '"+number+"',ACADEMICSTATUS = '"+academicstatus+"', PASSWORD = '"+password+"' WHERE IDEMPLOYEE = "+user_id);
        }
        catch(InfException e){
            
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
