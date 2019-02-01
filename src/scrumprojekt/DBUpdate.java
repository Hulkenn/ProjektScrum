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
    
}
