/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumprojekt;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
}
