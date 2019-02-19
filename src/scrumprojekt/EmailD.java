package scrumprojekt;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import scrumprojekt.EmailS;

/**
 *
 * @author Filip Mood
 */
public class EmailD {
 
    public Connection conn;
    /**
     * @param args the command line arguments
     */
      
    public static void notice(Connection conn, int id) {
        
        ResultSet rs = DBFetcher.fetchUserNotiser(conn,id);
        String email="";
        
        try {
                while(rs.next())
                {
                    email = rs.getString("EMAIL");
                    
                     
                }
            } catch (SQLException ex) {
                Logger.getLogger(EducationFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            String[] to = {"scrumeXtremeP@gmail.com"};
       
       
            if(EmailS.sendMail("scrumeXtremeP@gmail.com", "SCRUM123", email + " has made a post", to)) 
            {
                System.out.println("email sent successfully");
            }
       
            else 
            {
                System.out.println("Some error occured");
            }
       
        }
    
      public static void noticeK(Connection conn,int id, int post) {
        
        ResultSet rsPoster = DBFetcher.fetchUserNotiser(conn, id);
        String email="";
        String email2="";
        String email3="";
        String msg=""; 
        
        try {
                while(rsPoster.next())
                {
                    email = rsPoster.getString("EMAIL");
                    
                     
                }
            } catch (SQLException ex) {
                Logger.getLogger(EducationFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        ResultSet rsComments = DBFetcher.fetchAllCommentorsOnPost(conn, post);
        
        
        try {
                while(rsComments.next())
                {
                    email2 = rsComments.getString("EMAIL") + "\n";
                    email3 = email3 + email2;
                    
                    
                     
                }
            } catch (SQLException ex) {
                Logger.getLogger(EducationFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            msg = email3 +" har kommenterar på "+email+" post";
            
        
            String[] to = {"scrumeXtremeP@gmail.com"};
       
       
            if(EmailS.sendMail("scrumeXtremeP@gmail.com", "SCRUM123", msg, to)) 
            {
                System.out.println("email sent successfully");
            }
       
            else 
            {
                System.out.println("Some error occured");
            }
       
        }
       
       
       
       
    }
    
   

