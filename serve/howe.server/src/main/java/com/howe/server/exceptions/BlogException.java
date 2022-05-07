package com.howe.server.exceptions;

import com.howe.server.enums.ResponseEnum;

/**
 * <p>@Author lu
 * <p>@Date 2022/5/7 9:01 星期六
 * <p>@Version 1.0
 * <p>@Description
 */
public class BlogException extends AppException {
    public BlogException(ResponseEnum responseEnum) {
        super(responseEnum.getCode(), responseEnum.getMessage());
    }
}
