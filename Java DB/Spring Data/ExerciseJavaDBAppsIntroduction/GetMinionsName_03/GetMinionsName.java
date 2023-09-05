package GetMinionsName_03;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class GetMinionsName {
    private static final String MINION_PRINT_FORMAT = "%d. %s %d\n";
    private static final String VILLAIN_PRINT_FORMAT = "Villain: %s\n";

    public static void main(String[] args) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "12345");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/minions_db", properties);

        PreparedStatement statementMinions = connection.prepareStatement("SELECT \n" +
                "    m.name, m.age\n" +
                "FROM\n" +
                "    minions AS m\n" +
                "        JOIN\n" +
                "    minions_villains AS mv ON mv.minion_id = m.id\n" +
                "WHERE\n" +
                "    mv.villain_id = ?;");

        PreparedStatement statementVillain = connection.prepareStatement("SELECT \n" +
                "    name\n" +
                "FROM\n" +
                "    villains\n" +
                "WHERE\n" +
                "    id = ?;");

        System.out.print("Enter Villain ID: ");
        Scanner scanner = new Scanner(System.in);
        int villainId = scanner.nextInt();


        statementMinions.setInt(1, villainId);
        ResultSet resultSetMinion = statementMinions.executeQuery();
        statementVillain.setInt(1, villainId);
        ResultSet resultSetVillain = statementVillain.executeQuery();


        if (!resultSetVillain.next()) {
            System.out.printf("No villain with ID %d exists in the database.", villainId);
            connection.close();
            return;
        } else {
            System.out.printf(VILLAIN_PRINT_FORMAT, resultSetVillain.getString("name"));
        }

        for (int minionNumber = 1; resultSetMinion.next(); minionNumber++) {
            System.out.printf(MINION_PRINT_FORMAT, minionNumber,
                    resultSetMinion.getString("name"), resultSetMinion.getInt("age"));
        }

        connection.close();
    }
}
