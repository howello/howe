package com.howe.server.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * <p>@Author lu
 * <p>@Date 2022/5/6 17:48 星期五
 * <p>@Version 1.0
 * <p>@Description
 */
@Data
public class LoginReqDTO {

    /**
     * 用户名
     */
    @NotNull(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @NotNull(message = "密码不能为空")
    private String password;
}
