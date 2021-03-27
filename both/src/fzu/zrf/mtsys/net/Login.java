package fzu.zrf.mtsys.net;

import java.io.Serializable;
import java.util.Arrays;

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

    public static class Result implements Serializable {

        /**
         * 
         */
        private static final long serialVersionUID = -572207127962147612L;

        public enum Type {
            SUCCESS_CHAIRMAN, SUCCESS_PRESIDENT, SUCCESS_SECRETARY, SUCCESS_MEMBER, ILLEAGLE_STATE, WRONG_ARGS
        }

        public final Type type;
        public final String name;
        public final int[] forms;

        public Result(Type type, String name, int[] forms, boolean cloneArr) {
            this.type = type;
            this.name = name;
            this.forms = cloneArr ? forms.clone() : forms;
        }

        @Override
        public String toString() {
            return "Result [type=" + type + ", name=" + name + ", forms=" + Arrays.toString(forms) + "]";
        }

    }
}
