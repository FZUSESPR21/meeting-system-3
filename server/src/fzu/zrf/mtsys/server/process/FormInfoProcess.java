package fzu.zrf.mtsys.server.process;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import fzu.zrf.mtsys.net.FormsInfo;
import fzu.zrf.mtsys.net.FormsInfo.Result;
import fzu.zrf.mtsys.server.ConnectionPool;

public class FormInfoProcess {
    public static FormsInfo.Result process(Object obj) {
        try {
            Connection conn = ConnectionPool.get();
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM forms;");
            HashMap<Integer, String> map = new HashMap<Integer, String>();
            FormsInfo.Result ret = new Result(map);
            while (rs.next()) {
                map.put(rs.getInt("id"), rs.getString("name"));
            }
            return ret;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
