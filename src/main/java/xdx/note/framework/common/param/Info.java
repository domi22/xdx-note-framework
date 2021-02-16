package xdx.note.framework.common.param;

import java.io.Serializable;

public class Info<T> implements Serializable {

    private static final long serialVersionUID = 1314306618112648945L;

    private String msg;
    private String code;
    private T data;

    public Info(String code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public Info() {
    }

    public Info(String code, String msg, T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Info{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                ", data=" + data +
                '}';
    }
}