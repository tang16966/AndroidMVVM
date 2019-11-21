package com.trs.mvvm.http;

/**
 * @author TRS
 * Create time : 2019/11/20
 * Explain : 该类仅供参考，实际业务返回的固定字段, 根据需求来定义，
 */
public class BaseResponse<T> {
    private int status;
    private String msg;
    private T data;

    public int getCode() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isOk() {
        return status == 200;
    }
}
