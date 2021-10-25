package university.management.system;

import java.sql.*;
import java.lang.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conn {

    Connection c;
    Statement s;

    public Conn() {
           String forName = "com.mysql.cj.jdbc.Driver";
     
    
       try {
            Class.forName(forName);
         /*   c = DriverManager.getConnection("jdbc:mysl:///ums", "root", "");*/
           c= DriverManager.getConnection("jdbc:mysql://localhost:3306/ums","root",""); 
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
}
      /*
    Connection con= 
    */
    

    public static void main(String args[]) {
        new Conn();
    }
}
