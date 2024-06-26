package GetVillainsNames_02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

enum Utils {
    ;
    static Connection getSqlConnection() throws SQLException {
        final Properties properties = new Properties();
        properties.setProperty(Constants.USER_KEY, Constants.USER_VALUE);
        properties.setProperty(Constants.PASSWORD_KEY, Constants.PASSWORD_VALUE);

        return DriverManager
                .getConnection(Constants.JBDC_MYSQL_URL, properties);
    }

}
