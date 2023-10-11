package cochinginstitutemanagementsystem;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    Conn(){
        
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///coachinginstitutemanagementsystem","root","Adarsh@Pratap@6602");
            s = c.createStatement();
            
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
   
    
}
