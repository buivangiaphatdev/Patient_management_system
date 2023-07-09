package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class DBUtils {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://MSI\\GIAPHAT:1433;databaseName=patientManagement";
            conn = DriverManager.getConnection(url, "sa", "010102");

        } catch (Exception e) {
        }

        return conn;
    }
}
