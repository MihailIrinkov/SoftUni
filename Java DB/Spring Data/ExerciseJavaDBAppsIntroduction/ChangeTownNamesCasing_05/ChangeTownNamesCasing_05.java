package ChangeTownNamesCasing_05;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class ChangeTownNamesCasing_05 {
    public static void main(String[] args) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "12345");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/minions_db", properties);

        System.out.println("Enter country name");
        Scanner scanner = new Scanner(System.in);

        String countryName = scanner.nextLine();

        PreparedStatement stmt = connection.prepareStatement(
                "UPDATE towns SET name = upper(name) WHERE country = ?;");
        stmt.setString(1, countryName);

        int countChangedTowns = stmt.executeUpdate();

        System.out.printf("%d town names were affected.%n", countChangedTowns);

        PreparedStatement stmtGetTowns = connection.prepareStatement(
                "SELECT name FROM towns WHERE country = ?;");
        stmtGetTowns.setString(1, countryName);
        ResultSet rs = stmtGetTowns.executeQuery();
        System.out.print("[");
        int i = 0;
        while (rs.next()) {
            if (i != 0) {
                System.out.print(", ");
            }

            System.out.print(rs.getString("name"));
            i++;
        }
        System.out.print("]");
        connection.close();
    }
}
