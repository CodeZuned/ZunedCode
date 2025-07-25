
package databse;
import java.sql.*;

public class Conn {

    Connection c;
    public Statement s;

    public Conn() {
        try {
            // Establishing the connection
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "sheikh123");
            s = c.createStatement();
           
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    
}
