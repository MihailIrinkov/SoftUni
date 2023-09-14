import java.sql.*;
import java.util.Collection;
import java.util.Properties;
import java.util.Scanner;

public class IncreaseAgeStoredProcedure_09 {
    private static final String MINION_INFO = "SELECT name, age from minions WHERE id = ?;";

    public static void main(String[] args) throws SQLException {

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "12345");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/minions_db", properties);

        Scanner scanner = new Scanner(System.in);

        int minion_id = Integer.parseInt(scanner.nextLine());

        CallableStatement callableStatement =
                connection.prepareCall("CALL usp_get_older(?)");
        callableStatement.setInt(1, minion_id);
        callableStatement.executeUpdate();

        PreparedStatement stmt = connection.prepareStatement(MINION_INFO);
        stmt.setInt(1, minion_id);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            System.out.print(rs.getString("name") + " " +
                    rs.getInt("age"));
        }
    }
}
