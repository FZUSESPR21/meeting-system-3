package fzu.zrf.mtsys.server;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Main {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://blog.tozzger.info:3306/";
    
    public static void main(String[] args) throws Exception {
        Class.forName(JDBC_DRIVER);
        Properties p = new Properties();
        InputStream is = new FileInputStream("psw.properties");
        p.load(is);
        is.close();
        Connection conn = DriverManager.getConnection(DB_URL + p.getProperty("db"),p.getProperty("id"),p.getProperty("psw"));
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM user_type");
        while(rs.next()){
            System.out.println(rs.getInt("id"));
        }
    }

}
