package com.howe.server.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <p>@Author lu
 * <p>@Date 2022/5/6 17:15 星期五
 * <p>@Version 1.0
 * <p>@Description 不进行返回值包装注解
 */
@Target({METHOD})
@Retention(RUNTIME)
public @interface NotResultWrap {
}
