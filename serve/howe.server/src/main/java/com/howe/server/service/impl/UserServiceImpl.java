package com.howe.server.service.impl;

import cn.hutool.core.lang.UUID;
import com.howe.server.dto.request.LoginReqDTO;
import com.howe.server.dto.response.LoginRespDTO;
import com.howe.server.enums.ResponseEnum;
import com.howe.server.exceptions.BlogException;
import com.howe.server.service.UserService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>@Author lu
 * <p>@Date 2022/5/7 8:53 星期六
 * <p>@Version 1.0
 * <p>@Description
 */
@Service("UserService")
@Slf4j
public class UserServiceImpl implements UserService {
    /**
     * 登录
     *
     * @param loginReqDTO
     * @return
     */
    @SneakyThrows
    @Override
    public LoginRespDTO login(LoginReqDTO loginReqDTO) {
        int i = 1;
        if (i == 1) {
            BlogException blogException = new BlogException(ResponseEnum.PROGRAM_INSIDE_EXCEPTION);
            log.error("UserServiceImpl抛出的", blogException);
            throw blogException;
        }
        String token = UUID.fastUUID().toString(true);
        LoginRespDTO loginRespDTO = new LoginRespDTO();
        loginRespDTO.setToken(token);
        return loginRespDTO;
    }
}
