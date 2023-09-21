package com.shi.exception;

public class ParmsException extends RuntimeException{
    private Integer code = 500;
    private String msg ="参数异常";

    public ParmsException() {
    }

    public ParmsException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ParmsException(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
