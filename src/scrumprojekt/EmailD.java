package scrumprojekt;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        
        ResultSet rs = DBFetcher.fetchUser(conn,id);
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
    
    public static void noticeEvent(Connection conn, int user_id, ArrayList<Integer> ids) {
        
        ResultSet rs = DBFetcher.fetchUser(conn, user_id);
        String email="";
        String sender = "";
        String[] to = new String[ids.size()];
        
        try {
                while(rs.next())
                {
                    sender = rs.getString("FIRSTNAME") + " " + rs.getString("LASTNAME");
                    email = rs.getString("EMAIL");
                }
            } catch (SQLException ex) {
                Logger.getLogger(EducationFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            int index = 0;
            for(Integer id : ids) {
                try {
                    ResultSet receiver = DBFetcher.fetchUser(conn, id);
                    receiver.next();
                    to[index] = receiver.getString("EMAIL");
                    index++;
                } catch (SQLException ex) {
                    Logger.getLogger(EmailD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(EmailS.sendMail("scrumeXtremeP@gmail.com", "SCRUM123", sender + " has invited you to their event. Check the event on the system.", to)) 
            {
                System.out.println("email sent successfully");
            }
            else {
                System.out.println("some error occured");
            }
       
        }
    
      public static void noticeK(Connection conn,int id, int post) {
        
        ResultSet rsPoster = DBFetcher.fetchUser(conn, id);
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
    
   

