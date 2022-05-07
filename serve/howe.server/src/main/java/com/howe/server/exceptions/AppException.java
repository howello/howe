package com.howe.server.exceptions;

import lombok.Data;

/**
 * <p>@Author lu
 * <p>@Date 2022/5/7 8:58 星期六
 * <p>@Version 1.0
 * <p>@Description
 */
public class AppException extends Exception {
    private static final long serialVersionUID = 1L;
    private int code;

    public AppException() {
    }

    public AppException(int code) {
        this.code = code;
    }

    public AppException(String message) {
        super(message);
    }

    public AppException(int code, String message) {
        super(message);
        this.code = code;
    }

    public AppException(Throwable cause) {
        super(cause);
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
