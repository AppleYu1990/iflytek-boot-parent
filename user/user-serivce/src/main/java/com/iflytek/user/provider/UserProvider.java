package com.iflytek.user.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.iflytek.common.Response.Response;
import com.iflytek.common.Response.ResponseUtils;
import com.iflytek.user.api.UserAPI;
import com.iflytek.user.entity.User;
import com.iflytek.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Copyright (c) 2017-2018 iFLYTEK Company LTD.
 * All rights reserved.
 *
 * @Description:
 * @Date: Created in 2018 2018/1/20 17:55
 * @Author: pengnian
 */
@Service(interfaceClass = UserAPI.class)
public class UserProvider implements UserAPI {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserProvider.class);

    @Autowired
    private UserService userService;

    @Override
    public Response<User> getUserInfo(Long id) {
        try {
            return ResponseUtils.returnObjectSuccess(userService.getUserInfo(id));
        } catch (Exception e) {
            LOGGER.error("获取用户信息失败！id = {}", id, e);
            return ResponseUtils.returnException(e);
        }
    }

    @Override
    public Response<User> insertUser(User user) {
        try {
            return ResponseUtils.returnObjectSuccess(userService.insertUser(user));
        } catch (Exception e) {
            LOGGER.error("新增用户信息失败！{}", JSON.toJSONString(user), e);
            return ResponseUtils.returnException(e);
        }
    }
}
