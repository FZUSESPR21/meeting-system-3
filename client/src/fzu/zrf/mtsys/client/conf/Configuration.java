package fzu.zrf.mtsys.client.conf;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class Configuration {
    public static final ResourceBundle BUNDLE = ResourceBundle.getBundle("fzu.zrf.mtsys.client.lang.Bundle");
    public static final String IP_ADDRESS;
    static {
        try {
            Properties p = new Properties();
            InputStream is = new FileInputStream("server.properties");
            p.load(is);
            IP_ADDRESS = p.getProperty("ip");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
