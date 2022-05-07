package com.howe.server.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.howe.server.annotations.NotResultWrap;
import com.howe.server.exceptions.BlogException;
import com.howe.server.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * <p>@Author lu
 * <p>@Date 2022/5/6 17:08 星期五
 * <p>@Version 1.0
 * <p>@Description
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.howe.server.controller")
public class ResponseControllerAdvice implements ResponseBodyAdvice<Object> {
    /**
     * 该组件是否支持给定的控制器方法返回类型
     * and the selected {@code HttpMessageConverter} type.
     *
     * @param returnType    the return type
     * @param converterType the selected converter type
     * @return {@code true} if {@link #beforeBodyWrite} should be invoked;
     * {@code false} otherwise
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        log.info("判断是否需要进行返回值包装");
        //如果接口方法返回 Result 不需要再次包装
        //如果接口方法使用了 @NotResultWrap 注解，表示不需要包装了
        //只对成功的请求进行返回包装，异常情况统一放在全局异常中进行处理
        return !(returnType.getParameterType().equals(Result.class)
                || returnType.hasMethodAnnotation(NotResultWrap.class));
    }

    /**
     * Invoked after an {@code HttpMessageConverter} is selected and just before
     * its write method is invoked.
     *
     * @param body                  the body to be written
     * @param returnType            the return type of the controller method
     * @param selectedContentType   the content type selected through content negotiation
     * @param selectedConverterType the converter type selected to write to the response
     * @param request               the current request
     * @param response              the current response
     * @return the body that was passed in or a modified (possibly new) instance
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        log.info("进行返回值包装");
        //String 类型不能直接包装，需要进行特殊处理
        if (returnType.getParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                //使用 jackson 将返回数据转换为 json
                return objectMapper.writeValueAsString(Result.success(body));
            } catch (JsonProcessingException e) {
                //这里会走统一异常处理
                throw new RuntimeException("String类型返回值包装异常");
            }
        }
        return Result.success(body);
    }

    @ExceptionHandler(BlogException.class)
    public Result blogExceptionHandler(BlogException e) {
        e.printStackTrace();
        log.info(e.getMessage());
        log.error(e.getMessage(),e);
        log.debug("asdasdadsa");
        return Result.failure(e.getCode(), e.getMessage());

    }

    @ExceptionHandler(Exception.class)
    public Result otherException(Exception e) {
        e.printStackTrace();
        log.error(e.getMessage());
        return Result.failure();
    }
}
