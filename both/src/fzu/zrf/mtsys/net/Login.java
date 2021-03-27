package fzu.zrf.mtsys.net;

import java.io.Serializable;

public class Login implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4062183154393481871L;
    
    public final String id;
    public final String password;
    public Login(String id, String password) {
        this.id = id;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login [id=" + id + ", password=" + password + "]";
    }
    
    public static class Result implements Serializable
    {
        
    }
}
