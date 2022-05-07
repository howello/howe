package com.howe.server.dto.request;

import lombok.Data;

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
    private String username;

    /**
     * 密码
     */
    private String password;
}
