package fzu.zrf.mtsys.server;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionPool {
    private static final String DB_URL;
    private static final String DB_USER;
    private static final String DB_PSW;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Properties p = new Properties();
            InputStream is = new FileInputStream("psw.properties");
            p.load(is);
            is.close();
            DB_URL = "jdbc:mysql://blog.tozzger.info:3306/" + p.getProperty("db");
            DB_USER =  p.getProperty("id");
            DB_PSW = p.getProperty("psw");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } 
    }
    public static Connection get()
    {
        try {
            return DriverManager.getConnection(DB_URL,DB_USER,DB_PSW);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
