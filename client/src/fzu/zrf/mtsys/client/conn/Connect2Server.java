package fzu.zrf.mtsys.client.conn;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.function.Supplier;

import fzu.zrf.mtsys.client.conf.Configuration;
import javafx.concurrent.Task;

public abstract class Connect2Server<Out, In> implements Callable<In>, Supplier<Out> {

    @Override
    public In call() throws Exception {
        Socket s = new Socket(Configuration.IP_ADDRESS, fzu.zrf.mtsys.conf.Configuration.PORT);
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        oos.writeObject(get());
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        Object ret = ois.readObject();
        oos.close();
        ois.close();
        s.close();
        return (In) ret;
    }
}
