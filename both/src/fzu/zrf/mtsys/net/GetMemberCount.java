package fzu.zrf.mtsys.net;

import java.io.Serializable;

public class GetMemberCount implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = -5265002937633791309L;

    public static class Result implements Serializable{
        /**
         * 
         */
        private static final long serialVersionUID = -4667423182607730728L;
        public final int num;

        public Result(int num) {
            this.num = num;
        }

        @Override
        public String toString() {
            return "Result [num=" + num + "]";
        }
    }
}
