package fzu.zrf.mtsys.server.process;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fzu.zrf.mtsys.net.GetMemberCount.Result;
import fzu.zrf.mtsys.server.ConnectionPool;

public class GetMemberCountProcess {
    public static Result process(Object obj) {
        try {
            Connection conn = ConnectionPool.get();
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT count(*) FROM user WHERE type = 1;");
            int num = 0;
            if (rs.next()) {
                num = rs.getInt(1);
            }
            Result ret = new Result(num);
            s.close();
            conn.close();
            return ret;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
