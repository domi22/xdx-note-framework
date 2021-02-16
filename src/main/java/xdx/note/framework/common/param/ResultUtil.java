package xdx.note.framework.common.param;

public class ResultUtil {

    public ResultUtil() {
    }

    public static Info fail(BaseCode code) {
        return new Info(code.getCode(), code.getMsg());
    }

    public static Info fail(String code, String msg) {
        return new Info(code, msg);
    }

    public static Info success(BaseCode code, Object obj) {
        return new Info(code.getCode(), code.getMsg(), obj);
    }


}
