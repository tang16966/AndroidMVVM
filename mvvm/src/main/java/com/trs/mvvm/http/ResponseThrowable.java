package com.trs.mvvm.http;

/**
 * @author TRS
 * Create time : 2019/11/20
 * Explain : 响应异常
 */

public class ResponseThrowable extends Exception {
    public int code;
    public String message;

    public ResponseThrowable(Throwable throwable, int code) {
        super(throwable);
        this.code = code;
    }
}
