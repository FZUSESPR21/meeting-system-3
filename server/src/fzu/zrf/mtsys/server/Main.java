package fzu.zrf.mtsys.server;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import fzu.zrf.mtsys.conf.Configuration;

public class Main {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://blog.tozzger.info:3306/";

    public static void main(String[] args) throws Exception {
        ExecutorService tpe = Executors.newCachedThreadPool();
        Class.forName(JDBC_DRIVER);
        Properties p = new Properties();
        InputStream is = new FileInputStream("psw.properties");
        p.load(is);
        is.close();
        Connection conn = DriverManager.getConnection(DB_URL + p.getProperty("db"), p.getProperty("id"),
                p.getProperty("psw"));

        ServerSocket ss = new ServerSocket(Configuration.PORT);
        while (true) {
            Socket s = ss.accept();
            tpe.execute(() -> {
                try {         
                    ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                    Object obj = ois.readObject();
                    System.out.println(obj);
                    
                    ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                    oos.writeObject(null);// ... 
                    ois.close();
                    oos.close();
                    s.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

}
