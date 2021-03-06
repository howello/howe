package com.howe.server.controller;

import cn.hutool.core.lang.UUID;
import com.howe.server.dto.request.LoginReqDTO;
import com.howe.server.dto.response.LoginRespDTO;
import com.howe.server.service.UserService;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>@Author lu
 * <p>@Date 2022/5/6 16:44 ζζδΊ
 * <p>@Version 1.0
 * <p>@Description
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public LoginRespDTO login(LoginReqDTO loginReqDTO) {
        return userService.login(loginReqDTO);
    }
}
