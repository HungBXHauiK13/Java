package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class MyConnection {
    private static final String DB_USER = "root";
    private static final String DB_PASS = "root";
    private static final String DB_HOST = "jdbc:mysql://localhost:3306/employees";

    public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(DB_HOST, DB_USER, DB_PASS);
        }
}
