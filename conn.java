import java.sql.*;
public class conn {
    Connection c ;
    static Statement  s ;
    
    public conn(){
        try{  
          c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","007123");
        s= c.createStatement();
        } catch(Exception e){
           System.out.println(e);
        }
    }
}
