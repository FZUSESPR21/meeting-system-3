package fzu.zrf.mtsys.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import fzu.zrf.mtsys.conf.Configuration;
import fzu.zrf.mtsys.net.Login;

public class Main {

    public static void main(String[] args) throws Exception {
        ExecutorService tpe = Executors.newCachedThreadPool();


        Connection conn = ConnectionPool.get();

        ServerSocket ss = new ServerSocket(Configuration.PORT);
        while (true) {
            System.err.println("Try get socket.");
            Socket s = ss.accept();
            tpe.execute(() -> {
                try {         
                    ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                    Object obj = ois.readObject();
                    
                    // here
                    if(obj instanceof Login) {
                        System.out.println(obj);
                    }
                    
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
