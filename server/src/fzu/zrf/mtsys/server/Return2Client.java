package fzu.zrf.mtsys.server;

import java.util.HashMap;
import java.util.function.Function;

import fzu.zrf.mtsys.net.FormsInfo;
import fzu.zrf.mtsys.net.GetMemberCount;
import fzu.zrf.mtsys.net.Login;
import fzu.zrf.mtsys.net.Register;
import fzu.zrf.mtsys.server.process.FormInfoProcess;
import fzu.zrf.mtsys.server.process.GetMemberCountProcess;
import fzu.zrf.mtsys.server.process.LoginProcess;
import fzu.zrf.mtsys.server.process.RegisterProcess;

public class Return2Client {
    private static final HashMap<Class<?>, Function<Object, Object>> map = new HashMap<>();

    static {
        // fill map here
        map.put(Login.class, LoginProcess::process);
        map.put(FormsInfo.class, FormInfoProcess::process);
        map.put(Register.class, RegisterProcess::process);
        map.put(GetMemberCount.class, GetMemberCountProcess::process);
    }

    public static Object process(Object in) {
        return map.get(in.getClass()).apply(in);
    }
}
