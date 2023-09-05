package GetMinionsName_03;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class TestGetMinionsName {
    private static final String MINION_PRINT_FORMAT = "%d. %s %d\n";
    private static final String VILLAIN_PRINT_FORMAT = "Villain: %s\n";
    private static final String COLUMN_LABEL_NAME = "name";
    private static final String COLUMN_LABEL_AGE = "age";
    private static final String GET_MINION_NAMES_BY_VILLAIN_ID = "SELECT \n" +
            "    m.name, m.age\n" +
            "FROM\n" +
            "    minions AS m\n" +
            "        JOIN\n" +
            "    minions_villains AS mv ON mv.minion_id = m.id\n" +
            "WHERE\n" +
            "    mv.villain_id = ?;";
    private static final String GET_VILLAIN_NAME_BY_ID = "SELECT \n" +
            "    name\n" +
            "FROM\n" +
            "    villains\n" +
            "WHERE\n" +
            "    id = ?;";
    private static final String PRINT_NO_VILLAIN_FORMAT = "No villain with ID %d exists in the database.";

    public static void main(String[] args) throws SQLException {
        final Connection sqlConnection = Utils.getSqlConnection();

        final PreparedStatement statementMinions = sqlConnection.prepareStatement(GET_MINION_NAMES_BY_VILLAIN_ID);

        final PreparedStatement statementVillain = sqlConnection.prepareStatement(GET_VILLAIN_NAME_BY_ID);

        System.out.print("Enter Villain ID: ");
        Scanner scanner = new Scanner(System.in);
        final int villainId = scanner.nextInt();

        statementVillain.setInt(1, villainId);
        final ResultSet resultSetVillain = statementVillain.executeQuery();

        statementMinions.setInt(1, villainId);
        final ResultSet resultSetMinion = statementMinions.executeQuery();

//        while (resultSetVillain.next()) {
//            System.out.printf(VILLAIN_PRINT_FORMAT, resultSetVillain.getString("name"));
//        }

        if (!resultSetVillain.next()) {
            System.out.printf(PRINT_NO_VILLAIN_FORMAT, villainId);
            sqlConnection.close();
            sqlConnection.close();
            return;
        }

//        final String villainName = resultSetVillain.getString(COLUMN_LABEL_NAME);
//
//        System.out.printf(VILLAIN_PRINT_FORMAT, villainName);


//        for (int minionNumber = 1; resultSetMinion.next(); minionNumber++) {
//            final String minionName = resultSetMinion.getString(COLUMN_LABEL_NAME);
//            final int minionAge = resultSetMinion.getInt(COLUMN_LABEL_AGE);
//            System.out.printf(MINION_PRINT_FORMAT, minionNumber, minionName, minionAge);
//        }

        print(resultSetMinion, resultSetVillain);
        sqlConnection.close();
    }

    private static void print(ResultSet minion, ResultSet villain) throws SQLException {

        final String villainName = villain.getString(COLUMN_LABEL_NAME);
        System.out.printf(VILLAIN_PRINT_FORMAT, villainName);

        for (int minionNumber = 1; minion.next(); minionNumber++) {
            final String minionName = minion.getString(COLUMN_LABEL_NAME);
            final int minionAge = minion.getInt(COLUMN_LABEL_AGE);
            System.out.printf(MINION_PRINT_FORMAT, minionNumber, minionName, minionAge);
        }
    }
}
