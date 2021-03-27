package fzu.zrf.mtsys.server;

import java.util.HashMap;
import java.util.function.Function;

import fzu.zrf.mtsys.net.Login;
import fzu.zrf.mtsys.server.process.LoginProcess;

public class Return2Client {
    private static final HashMap<Class<?>, Function<Object, Object>> map = new HashMap<>();

    static {
        // fill map here
        map.put(Login.class, LoginProcess::process);
    }

    public static Object process(Object in) {
        return map.get(in.getClass()).apply(in);
    }
}
