package com.yjw.shirly.model.bean;

public class Response {
    public static final int CODE_USER_NOT_EXIST = 401;
    public static final int CODE_USER_PWD_ERR = 402;
    public static final int CODE_USER_HAS_EXIST = 403;
    public static final int CODE_USER_LOGIN_SUCCESS = 200;
    int code;
    String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
