package com.howe.server.service;

import com.howe.server.dto.request.LoginReqDTO;
import com.howe.server.dto.response.LoginRespDTO;

/**
 * <p>@Author lu
 * <p>@Date 2022/5/7 8:53 星期六
 * <p>@Version 1.0
 * <p>@Description
 */
public interface UserService {

    /**
     * 登录
     * @param loginReqDTO
     * @return
     */
    public LoginRespDTO login(LoginReqDTO loginReqDTO);
}
