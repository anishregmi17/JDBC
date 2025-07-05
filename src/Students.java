/* Java program using JDBC that connects to a MySQL database and retrieves the names of students
   who live in the "Kathmandu" district. */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Students {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/java";
        String user = "root";
        String password = "root";

        String query = "SELECT name FROM student WHERE district = ?";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "Kathmandu");

            ResultSet rs = stmt.executeQuery();

            System.out.println("Students from Kathmandu:");
            while (rs.next()) {
                System.out.println("- " + rs.getString("name"));
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
