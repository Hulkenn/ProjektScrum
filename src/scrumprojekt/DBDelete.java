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
    private static void removeUser(InfDB db, int id){
        try{
            db.update("Update comments set isdeleted = 1  where employee_idemployee = " + id);
            db.update("Update Events set isdeleted = 1 where Employee_idEmployee = " + id);
            db.delete("Delete from Invited where Employee_idemployee = " + id);
            db.update("Update post set isdeleted = 1 where employee_idemployee = " + 1);
            db.update("Update employee set isdeleted = 1 where idemployee = " + 1);
        }
        catch(InfException ie){
            System.out.println(ie);
        }
    }
}
