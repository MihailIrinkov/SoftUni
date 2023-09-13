import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class IncreaseMinionsAge_08 {
    private static final String CHANGE_MINION_AGE =
            "UPDATE minions SET age = age + 1 WHERE id = ?;";
    private static final String SET_NAME_LOWER =
            "UPDATE minions SET name = lower(name) WHERE id = ?;";

    private static final String PRINT_MINIONS = "SELECT name, age FROM minions;";

    public static void main(String[] args) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "12345");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/minions_db", properties);
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        PreparedStatement stmtAge = connection.prepareStatement(CHANGE_MINION_AGE);
        PreparedStatement stmtLower = connection.prepareStatement(SET_NAME_LOWER);

        for (int i = 0; i < input.length; i++) {
            stmtAge.setInt(1, Integer.parseInt(input[i]));
            stmtAge.executeUpdate();
            stmtLower.setInt(1, Integer.parseInt(input[i]));
            stmtLower.executeUpdate();
        }

        PreparedStatement stmtPrint = connection.prepareStatement(PRINT_MINIONS);
        ResultSet rs = stmtPrint.executeQuery();

        while (rs.next()) {
            String name = rs.getString("name");
            String age = rs.getString("age");
            System.out.print(name + " " + age + " ");
//            StringBuilder sb = new StringBuilder();
//
//            sb.append(name);
//            sb.append(" ");
//            sb.append(age);
//            sb.append(" ");
//            sb.toString().trim();
//            System.out.print(sb);
        }

    }
}
