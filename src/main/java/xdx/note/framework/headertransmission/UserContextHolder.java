package xdx.note.framework.headertransmission;


public class UserContextHolder {

    private static final ThreadLocal<UserInfo> CONTEXT = new ThreadLocal<>();

    public static UserInfo get() {
        return CONTEXT.get();
    }

    public static void set(UserInfo user) {
        CONTEXT.set(user);
    }

    public static void remove() {
        CONTEXT.remove();
    }
}