package com.howe.server.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * <p>@Author lu
 * <p>@Date 2022/5/6 17:20 星期五
 * <p>@Version 1.0
 * <p>@Description
 */
@Getter
@AllArgsConstructor
public enum ResponseEnum {


    //成功提示码
    SUCCESS(0, "成功"),

    //自定义失败信息
    FAILURE(-1, "失败"),

    //通用错误码 50001~50099
    PROGRAM_INSIDE_EXCEPTION(50001, "程序内部异常"),
    REQUEST_PARAM_ERROR(50002, "请求参数错误");


    private final Integer code;
    private final String message;
}
