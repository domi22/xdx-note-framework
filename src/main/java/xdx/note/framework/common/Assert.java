package xdx.note.framework.common;

public class Assert {

    private Assert() {
    }

    public static void isTrue(boolean var,RuntimeException ex) {
        if (!var) {
            throw ex;
        }
    }

    public static void isFalse(boolean var,RuntimeException ex) {
        if (var) {
            throw ex;
        }
    }

    public static void isEmpty(String var,RuntimeException ex) {
        if (var != null || !var.isEmpty()) {
            throw ex;
        }
    }

    public static void notEmpty(String var,RuntimeException ex) {
        if (var == null || var.isEmpty()) {
            throw ex;
        }
    }

    public static void notEmpty(String[] var,RuntimeException ex) {
        if (var == null || var.length == 0) {
            throw ex;
        }
    }

    public static void isEmpty(String[] var,RuntimeException ex) {
        if (var != null || var.length > 0) {
            throw ex;
        }
    }


}
