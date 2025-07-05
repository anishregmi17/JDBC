import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionTest {

    public static void main(String[] args) {

        String jdbcURL = "jdbc:mysql://localhost:3306/java"; // replace `java` if your DB name is different
        String username = "root";
        String password = "root"; // replace with your actual MySQL password

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("✅ Connection to MySQL successful!");
            connection.close();
        } catch (SQLException e) {
            System.out.println("❌ Failed to connect to MySQL.");
            e.printStackTrace();
        }
    }
}
