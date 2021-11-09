package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public void connect()  {
        try {
            String url = "jdbc:mysql://localhost/test"; //connection string here test is the name of the database
            Connection con = DriverManager.getConnection(url, "root", "root"); // pass the connection string, username and password
            System.out.println(con);
        } catch (SQLException e ){
            System.out.println(e);
        }

    }
}
