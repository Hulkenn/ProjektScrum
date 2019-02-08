/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumprojekt;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import oru.inf.InfDB;

/**
 *
 * @author Kasper
 */
public class Validate {
  
  
    /**
     * Method for checking if a JTextField is empty
     *
     * @param windowToCheck
     * @return returns 1 if its empty, 0 if not empty
     */
    public static boolean textWindowIsEmpty(JTextField windowToCheck) {
        boolean result = false;
        //If the JTextField checked is empty - do the following
        if (windowToCheck.getText().isEmpty()) {
            //Change the boolean to false
            result = true;
            JOptionPane.showMessageDialog(windowToCheck, "It is empty.");
            windowToCheck.requestFocus();
        }

        //Return a boolean
        return result;
    }
    
    public static boolean areaWindowIsEmpty(JTextArea areaToCheck) {
        boolean result = false;
        //If the JTextField checked is empty - do the following
        if (areaToCheck.getText().isEmpty()) {
            //Change the boolean to false
            result = true;
            JOptionPane.showMessageDialog(areaToCheck, "Post is empty.");
            areaToCheck.requestFocus();
        }

        //Return a boolean
        return result;
    }
    /**
     * 
     * @param fieldToCheck
     * @return returns 1 if its empty, 0 if not empty
     */
    public static boolean passwordFieldIsEmpty(JPasswordField fieldToCheck) {
        boolean result = false;
        if(fieldToCheck.getPassword().length == 0) {
            result = true;
            JOptionPane.showMessageDialog(fieldToCheck, "Enter a password.");
            fieldToCheck.requestFocus();
        }
        return result;
    }
    
    /**
     * Method for checking if the input in a JTextField is an integer
     *
     * @param windowToCheck
     * @return
     */
    public static boolean isAnInteger(JTextField windowToCheck) {
        boolean result = true;
        try {
            //Fetch the input from the textfield
            String inStrang = windowToCheck.getText();
            //(Try to) convert it to an integer
            Integer.parseInt(inStrang);
        } catch (NumberFormatException e) {
            //If the conversion fails, show the user a message telling it to write a number
            JOptionPane.showMessageDialog(null, "Please enter an even number!");
            //Change the boolean to false
            result = false;
        }
        //Return a boolean
        return result;
    }
    public static boolean StringisString(JTextField str)
            // Metod som kontrollerar att string inte är siffror 
            {
            String str1 = str.getText();
            
            if (!str1.matches("[a-zA-Z_]+")) 
            {
                System.out.println("Only Letters Allowed");
                JOptionPane.showMessageDialog(null, "Only Letters Allowed");
                return false;
            }

  
        
             
        // skriver ut meddelande 
            
            
        
       
        return true;
     }
     public static boolean isValidEmailAddress(JTextField email1) {
           String email = email1.getText();
           String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
           java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
           java.util.regex.Matcher m = p.matcher(email);
           System.out.println(m.matches());
           if(!m.matches()){
               JOptionPane.showMessageDialog(null, "Please enter a valid email adress");
           }
           
           return m.matches();
    }
    public static boolean phoneNumber(JTextField number1)
    {
        String number = number1.getText();
        if(number.length()>0 && number.length()<18 && !number.matches("[a-zA-Z_]+"))
            return true;
        else{
            JOptionPane.showMessageDialog(null, "Please enter a valid phone number");
            System.out.println("Fungerade inte");
            return false;
        }
    }
    
    public static boolean categoryExist(InfDB db, String category){
        ArrayList<HashMap<String,String>> list = DBFetcher.fetchAllCategories(db);
        boolean exist = false;
        for(HashMap<String,String> categories : list){
            if(category.toLowerCase().equals(categories.get("CATEGORY").toLowerCase())){
                exist = true;
            }        
        }
        return exist;
    }
}
