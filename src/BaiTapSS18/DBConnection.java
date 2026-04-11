package BaiTapSS18;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/ProductManagement";
        String user = "postgres";
        String pass = "123456";

        return DriverManager.getConnection(url, user, pass);
    }
}