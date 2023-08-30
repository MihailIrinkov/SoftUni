package DBAppsIntroductionLab;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class WritingYourOwnDataRetrievalApplication_03 {
    private static final String SELECT_USER_GAME_COUNT_BY_USERNAME =
            "SELECT " +
                    "u.first_name, u.last_name, COUNT(*) " +
                    "FROM " +
                    "users_games AS ug " +
                    "JOIN " +
                    "users AS u ON u.id = ug.user_id " +
                    "WHERE " +
                    "user_name = ? " +
                    "GROUP BY u.id;";

    public static void main(String[] args) throws SQLException {
        Connection connection = getSqlConnection();

        String username = getUserName();

        PreparedStatement statement = connection.prepareStatement(
                SELECT_USER_GAME_COUNT_BY_USERNAME);
        statement.setString(1, username);

        ResultSet result = statement.executeQuery();
        boolean hasResult = result.next();

        if(hasResult) {
            System.out.printf("User: %s%n" +
                    "%s %s has played 6 games", username,
                    result.getString("first_name"),
                    result.getString("last_name"), result.getInt(3));
        } else {
            System.out.println("No such user exists");
        }

        connection.close();
    }

    private static String getUserName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        return username;
    }

    private static Connection getSqlConnection() throws SQLException {
        Properties userPass = new Properties();
        userPass.setProperty("user", "root");
        userPass.setProperty("password", "12345");
//        Connection connection = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/diablo", "root", "12345"
//        );
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo",
                userPass);
        return connection;
    }
}
