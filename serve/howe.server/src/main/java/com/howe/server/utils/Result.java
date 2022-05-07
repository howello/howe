package com.howe.server.utils;

import com.howe.server.enums.ResponseEnum;
import lombok.Data;

/**
 * <p>@Author lu
 * <p>@Date 2022/5/6 17:18 星期五
 * <p>@Version 1.0
 * <p>@Description
 */
@Data
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    /**
     * 成功
     */
    public static Result<Void> success() {
        Result<Void> result = new Result<>();
        result.setCode(ResponseEnum.SUCCESS.getCode());
        result.setMessage(ResponseEnum.SUCCESS.getMessage());
        return result;
    }

    /**
     * 成功，有返回数据
     */
    public static <V> Result<V> success(V data) {
        Result<V> result = new Result<>();
        result.code = ResponseEnum.SUCCESS.getCode();
        result.message = ResponseEnum.SUCCESS.getMessage();
        result.data = data;
        return result;
    }

    /**
     * 失败
     */
    public static Result<Void> failure() {
        Result<Void> result = new Result<>();
        result.setCode(ResponseEnum.FAILURE.getCode());
        result.setMessage(ResponseEnum.FAILURE.getMessage());
        return result;
    }

    /**
     * 失败，自定义失败信息
     */
    public static Result<Void> failure(String message) {
        Result<Void> result = new Result<>();
        result.setCode(ResponseEnum.FAILURE.getCode());
        result.setMessage(message);
        return result;
    }

    /**
     * 失败，自定义code和失败信息
     */
    public static Result<Void> failure(int code, String message) {
        Result<Void> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    /**
     * 失败，使用已定义枚举
     */
    public static Result<Void> failure(ResponseEnum responseEnum) {
        Result<Void> result = new Result<>();
        result.setCode(responseEnum.getCode());
        result.setMessage(responseEnum.getMessage());
        return result;
    }
}
