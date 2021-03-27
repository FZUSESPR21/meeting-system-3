package fzu.zrf.mtsys.net;

import java.util.Arrays;

public class Register {
    public final String id;
    public final String nickname;
    public final String password;
    public final int[] subforms;

    public Register(String id, String nickname, String password, int[] subforms, boolean arrClone) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.subforms = arrClone ? subforms.clone() : subforms;
    }

    @Override
    public String toString() {
        return "Register [id=" + id + ", nickname=" + nickname + ", password=" + password + ", subforms="
                + Arrays.toString(subforms) + "]";
    }
    
}
