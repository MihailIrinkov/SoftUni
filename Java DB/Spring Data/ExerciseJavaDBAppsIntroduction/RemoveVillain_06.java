import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class RemoveVillain_06 {
    private static final String GET_VILLAIN_NAME = "SELECT name FROM villains WHERE id = ?;";
    private static final String GET_MINION_COUNT =
            "SELECT COUNT(*) from minions_villains WHERE villain_id = ?;";
    private static final String DELETE_VILLAIN_MAPPING_TABLE =
            "DELETE mv FROM minions_villains as mv WHERE villain_id = ?;";
    private static final String DELETE_VILLAIN = "DELETE v FROM villains as v WHERE id = ?;";

    private static final String PRINT_WHEN_SUCCESSFUL_DELETED =
            "%s was deleted \n" +
                    "%d minions released \n";
    private static final String PRINT_WHEN_NO_ID_FOUND = "No such villain was found ";

    public static void main(String[] args) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "12345");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/minions_db", properties);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter villain ID:");
        int villainID = Integer.parseInt(scanner.nextLine());

        PreparedStatement stmtVillainName = connection.prepareStatement(GET_VILLAIN_NAME);
        stmtVillainName.setInt(1, villainID);
        ResultSet rsVillainName = stmtVillainName.executeQuery();

        if (!rsVillainName.next()) {
            System.out.println(PRINT_WHEN_NO_ID_FOUND);
            connection.close();
            return;
        }

        final String villainName = rsVillainName.getString("name");

        PreparedStatement stmtMinionCount = connection.prepareStatement(GET_MINION_COUNT);
        stmtMinionCount.setInt(1, villainID);
        ResultSet rsMinionCount = stmtMinionCount.executeQuery();
        rsMinionCount.next();
        final int minionCount = rsMinionCount.getInt(1);

        connection.setAutoCommit(false);

        try (PreparedStatement stmtDeleteFromMapping = connection
                .prepareStatement(DELETE_VILLAIN_MAPPING_TABLE);
             PreparedStatement stmtDeleteVillain = connection.prepareStatement(DELETE_VILLAIN);) {

            stmtDeleteFromMapping.setInt(1, villainID);
            stmtDeleteFromMapping.executeUpdate();

            stmtDeleteVillain.setInt(1, villainID);
            stmtDeleteVillain.executeUpdate();

            connection.commit();
            System.out.printf(PRINT_WHEN_SUCCESSFUL_DELETED, villainName, minionCount);
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            connection.rollback();
        }

    }
}
