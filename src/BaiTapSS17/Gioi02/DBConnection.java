package BaiTapSS17.Gioi02;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/shop_db",
                    "postgres",
                    "123456"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}