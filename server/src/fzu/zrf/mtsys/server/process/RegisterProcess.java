package fzu.zrf.mtsys.server.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.StringJoiner;

import fzu.zrf.mtsys.net.Register;
import fzu.zrf.mtsys.net.Register.Result;
import fzu.zrf.mtsys.server.ConnectionPool;

public class RegisterProcess {
    public static Register.Result process(Object obj) {
        try {
            Register r = (Register) obj;
            Connection conn = ConnectionPool.get();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO user "
                    + "(id, nickname, password, type, following) " + "VALUES (?,?,MD5(?),?,?);");
            ps.setString(1, r.id);
            ps.setString(2, r.nickname);
            ps.setString(3, r.password);
            ps.setInt(4, 1);
            StringJoiner sj = new StringJoiner(",");
            for (int i : r.subforms) {
                sj.add(Integer.toString(i));
            }
            ps.setString(5, sj.toString());
            boolean ret = ps.executeUpdate() != 0;
            ps.close();
            conn.close();
            return ret ? Result.DONE : Result.OTHER_WRONG;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
