package databse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class createdb {
    public static void main(String[] args) {
        
        try{
            String ur11="jdbc:mysql://localhost:3306/";
            String databasename="dbs";
            String username="root";
            String pass="sheikh123";
            Connection con=DriverManager.getConnection(ur11, username, pass);
            String sql="CREATE DATABASE "+databasename;
            Statement st=con.createStatement();
            st.executeUpdate(sql);
            st.close();
            JOptionPane.showMessageDialog(null, "created");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
