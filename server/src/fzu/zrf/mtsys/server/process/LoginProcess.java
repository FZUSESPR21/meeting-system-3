package fzu.zrf.mtsys.server.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.stream.Stream;

import fzu.zrf.mtsys.net.Login;
import fzu.zrf.mtsys.net.Login.Result.Type;
import fzu.zrf.mtsys.server.ConnectionPool;

public class LoginProcess {
    public static Login.Result process(Object obj) {
        Login.Result ret = null;
        try {
            Login l = (Login) obj;
            Connection conn = ConnectionPool.get();
            PreparedStatement s = conn.prepareStatement("SELECT * FROM user WHERE id = ? AND password = MD5(?);");
            s.setString(1, l.id);
            s.setString(2, l.password);
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
                Login.Result.Type type = null;
                switch (rs.getInt("type")) {
                case 1:
                    type = Type.SUCCESS_MEMBER;
                    break;
                case 2:
                    type = Type.SUCCESS_CHAIRMAN;
                    break;
                case 3:
                    type = Type.SUCCESS_PRESIDENT;
                    break;
                case 4:
                    type = Type.SUCCESS_SECRETARY;
                    break;
                }
                String following = rs.getString("following");
                int[] forms = following == null ? null
                        : Stream.of(following.split(", ")).mapToInt(Integer::parseInt).toArray();
                ret = new Login.Result(type, rs.getString("nickname"), forms, false);
            } else {
                ret = new Login.Result(Type.WRONG_ARGS, null, null, false);
            }
            s.close();
            conn.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ret;
    }
}
