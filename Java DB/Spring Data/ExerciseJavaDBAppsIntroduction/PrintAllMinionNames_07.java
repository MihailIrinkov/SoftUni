import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PrintAllMinionNames_07 {
    private static final String GET_MINIONS = "SELECT name FROM minions;";

    public static void main(String[] args) throws SQLException {

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "12345");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/minions_db", properties);

        PreparedStatement stmt = connection.prepareStatement(GET_MINIONS);
        ResultSet rs = stmt.executeQuery();

        List<String> allMinions = new ArrayList<>();

        while (rs.next()) {
            allMinions.add(rs.getString(1));
        }

        int start = 0;
        int end = allMinions.size() - 1;

        for (int i = 0; i < allMinions.size(); i++) {
//            if (i % 2 == 0) {
//                System.out.println(allMinions.get(start++));
//            } else {
//                System.out.println(allMinions.get(end--));
//            }
            System.out.println(i % 2 == 0
            ? allMinions.get(start++)
                    :allMinions.get(end--));
        }
    }
}
