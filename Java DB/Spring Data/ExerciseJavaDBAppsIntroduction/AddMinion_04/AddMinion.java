package AddMinion_04;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class AddMinion {
    private static final String NEW_VILLAIN_ADDED = "Villain %s was added to the database.\n";
    private static final String PRINT_MINION_ADDED_TO_VILLAIN = "Successfully added %s to be minion of %s.\n";
    private static final String PRINT_TOWN_FORMAT = "Town %s was added to the database.\n";
    private static final String EVILNESS_FACTOR = "evil";
    private static final String ADD_NEW_TOWN = "INSERT INTO towns(name) VALUE(?);";

    private static final String PREPARED_STATEMENT_GET_TOWN = "SELECT * FROM towns WHERE name = ?;";
    private static final String PREPARED_STATEMENT_GET_VILLAIN = "SELECT * FROM villains WHERE name = ?;";
    private static final String ADD_NEW_VILLAIN = "INSERT INTO villains(name, evilness_factor) VALUES(?, 'evil');";
    private static final String ADD_NEW_MINION = "INSERT INTO minions(name, age, town_id) VALUE(?, ?, ?);";
    private static final String GET_TOWN_ID = "SELECT id from towns WHERE name = ?;";
    private static final String ADD_TO_MINION_VILLAINS_TABLE =
            "INSERT INTO minions_villains(minion_id, villain_id) VALUES(?, ?);";
    private static final String GET_MINION_ID = "SELECT id from minions WHERE name = ?;";
    private static final String GET_VILLAIN_ID = "SELECT id from villains WHERE name = ?;";

    public static void main(String[] args) throws SQLException {

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "12345");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/minions_db", properties);

        final Scanner scanner = new Scanner(System.in);

        final String[] minionData = scanner.nextLine().split(" ");
        final String minionName = minionData[1];
        final int minionAge = Integer.parseInt(minionData[2]);
        final String minionTown = minionData[3];

        String villainName = minionData[5];

        //      final String villainName = scanner.nextLine().split(" ")[1];

        PreparedStatement preparedStatement = connection.prepareStatement(PREPARED_STATEMENT_GET_TOWN);
        preparedStatement.setString(1, minionTown);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (!resultSet.next()) {
            PreparedStatement preparedStatementT = connection
                    .prepareStatement(ADD_NEW_TOWN);
            preparedStatementT.setString(1, minionTown);
            preparedStatementT.executeUpdate();

            System.out.printf(PRINT_TOWN_FORMAT, minionTown);

            PreparedStatement preparedStatementAddV = connection.
                    prepareStatement(ADD_NEW_VILLAIN);
            preparedStatementAddV.setString(1, villainName);
            preparedStatementAddV.executeUpdate();
            System.out.printf(NEW_VILLAIN_ADDED, villainName);

            PreparedStatement preparedStatementAddM = connection
                    .prepareStatement(ADD_NEW_MINION);
            preparedStatementAddM.setString(1, minionName);
            preparedStatementAddM.setInt(2, minionAge);
            PreparedStatement stmtGetTownId = connection
                    .prepareStatement(GET_TOWN_ID);
            stmtGetTownId.setString(1, minionTown);
            ResultSet rsGetTownId = stmtGetTownId.executeQuery();
            rsGetTownId.next();
            int townId = rsGetTownId.getInt(1);
            preparedStatementAddM.setInt(3, townId);
            preparedStatementAddM.executeUpdate();

            ResultSet rsGetMinionId = getResultSet(connection, minionName, GET_MINION_ID, minionName);
            int minionId = rsGetMinionId.getInt("id");

            ResultSet rsGetVillainId = getResultSet(connection, villainName, GET_VILLAIN_ID, villainName);
            int villainId = rsGetVillainId.getInt("id");

            PreparedStatement stmtAddMinionToVillain = connection.prepareStatement(ADD_TO_MINION_VILLAINS_TABLE);
            stmtAddMinionToVillain.setInt(1, minionId);
            stmtAddMinionToVillain.setInt(2, villainId);
            stmtAddMinionToVillain.executeUpdate();

            System.out.printf(PRINT_MINION_ADDED_TO_VILLAIN, minionName, villainName);

        } else {
            PreparedStatement preparedStatementV = connection
                    .prepareStatement(PREPARED_STATEMENT_GET_VILLAIN);
            preparedStatementV.setString(1, villainName);
            ResultSet resultSetV = preparedStatementV.executeQuery();

            if (!resultSetV.next()) {
                PreparedStatement preparedStatementAddV = connection.
                        prepareStatement(ADD_NEW_VILLAIN);
                preparedStatementAddV.setString(1, villainName);
                preparedStatementAddV.executeUpdate();
                System.out.printf(NEW_VILLAIN_ADDED, villainName);

                PreparedStatement preparedStatementAddM = connection
                        .prepareStatement(ADD_NEW_MINION);
                preparedStatementAddM.setString(1, minionName);
                preparedStatementAddM.setInt(2, minionAge);
                PreparedStatement stmtGetTownId = connection
                        .prepareStatement(GET_TOWN_ID);
                stmtGetTownId.setString(1, minionTown);
                ResultSet rsGetTownId = stmtGetTownId.executeQuery();
                rsGetTownId.next();
                int townId = rsGetTownId.getInt(1);
                preparedStatementAddM.setInt(3, townId);
                preparedStatementAddM.executeUpdate();

                ResultSet rsGetMinionId = getResultSet(connection, minionName, GET_MINION_ID, minionName);
                int minionId = rsGetMinionId.getInt("id");

                ResultSet rsGetVillainId = getResultSet(connection, villainName, GET_VILLAIN_ID, villainName);
                int villainId = rsGetVillainId.getInt("id");

                PreparedStatement stmtAddMinionToVillain = connection.prepareStatement(ADD_TO_MINION_VILLAINS_TABLE);
                stmtAddMinionToVillain.setInt(1, minionId);
                stmtAddMinionToVillain.setInt(2, villainId);
                stmtAddMinionToVillain.executeUpdate();

                System.out.printf(PRINT_MINION_ADDED_TO_VILLAIN, minionName, villainName);

            }
        }
        connection.close();
    }

    private static ResultSet getResultSet(Connection connection, String minionName, String stmt, String name) throws SQLException {
        PreparedStatement stmtGetMinionId = connection
                .prepareStatement(stmt);
        stmtGetMinionId.setString(1, name);
        ResultSet rsGetMinionId = stmtGetMinionId.executeQuery();
        rsGetMinionId.next();
        return rsGetMinionId;
    }
}
