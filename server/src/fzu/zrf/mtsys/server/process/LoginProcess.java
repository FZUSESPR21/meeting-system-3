package fzu.zrf.mtsys.server.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fzu.zrf.mtsys.net.Login;
import fzu.zrf.mtsys.server.ConnectionPool;

public class LoginProcess {
    public static Login.Result process(Object obj)
    {
        Login.Result ret = null;
        try {
            Login l = (Login) obj;
            Connection conn = ConnectionPool.get();
            PreparedStatement s = conn.prepareStatement("SELECT * FROM user WHERE id = ? AND password = MD5(?);");
            s.setString(1, l.id);
            s.setString(2, l.password);
            ResultSet rs = s.executeQuery();
            if(rs.next()) {
                ret = new Login.Result(null, "123456", rs.getString("nickname"));
            }
            s.close();
            conn.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ret;
    }
}
