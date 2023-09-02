package GetVillainsNames_02;

import java.sql.*;
import java.util.Properties;

public class GetVillainsNames {
    private static final String GET_VILLAINS_NAMES = "SELECT \n" +
            "    v.name, COUNT( DISTINCT mv.minion_id) AS count\n" +
            "FROM\n" +
            "    villains AS v\n" +
            "        JOIN\n" +
            "    minions_villains AS mv ON mv.villain_id = v.id\n" +
            "GROUP BY mv.villain_id\n" +
            "HAVING count > ?\n" +
            "ORDER BY count desc;";
    private static final String PRINT_FORMAT = "%s %d";

    public static void main(String[] args) throws SQLException {

        final Connection connection = Utils.getSqlConnection();

        final PreparedStatement statement = connection.prepareStatement(GET_VILLAINS_NAMES);

        statement.setInt(1, 15);

        final ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
//            System.out.printf(PRINT_FORMAT, resultSet.getString(1),
//                    resultSet.getInt("count"));
            final String name = resultSet.getString("name");
            final int count_of_minions = resultSet.getInt("count");
            System.out.printf(PRINT_FORMAT, name, count_of_minions);
        }

        connection.close();
    }
}
