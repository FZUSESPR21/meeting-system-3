package fzu.zrf.mtsys.net;

import java.io.Serializable;
import java.util.HashMap;

public class FormsInfo implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 5896454437070152548L;

    public static class Result implements Serializable {
        /**
         * 
         */
        private static final long serialVersionUID = -3481926853097074416L;
        public final HashMap<Integer, String> forms;

        public Result(HashMap<Integer, String> forms) {
            this.forms = forms;
        }

        @Override
        public String toString() {
            return "Result [forms=" + forms + "]";
        }
    }
}
