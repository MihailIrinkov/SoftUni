package GetMinionsName_03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

enum Utils {
    ;
    static Connection getSqlConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty(Constants.USER_KEY, Constants.USER_VALUE);
        properties.setProperty(Constants.PASSWORD_KEY, Constants.PASSWORD_VALUE);

        return DriverManager.getConnection(Constants.JDBC_URL, properties);
    }
}
