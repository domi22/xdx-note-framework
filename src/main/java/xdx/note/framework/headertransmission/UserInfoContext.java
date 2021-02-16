package xdx.note.framework.headertransmission;


public class UserInfoContext {

    public static final String USERINFO_KEY = "X-USER";

    public static final String USERINFO_DECODER = "UTF-8";

    private static final ThreadLocal<UserInfo> USER_INFO = new ThreadLocal<>();

    public static UserInfo getUser() {
        return USER_INFO.get();
    }

    public static void setUser(UserInfo user) {
        USER_INFO.set(user);
    }
}
