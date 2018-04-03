package com.iflytek.openapi.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.iflytek.common.Response.Response;
import com.iflytek.user.api.UserAPI;
import com.iflytek.user.entity.User;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (c) 2017-2018 iFLYTEK Company LTD.
 * All rights reserved.
 *
 * @Description:
 * @Date: Created in 2018 2018/1/20 17:55
 * @Author: pengnian
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Reference(check = false, timeout = 10000)
    private UserAPI userAPI;

    @RequestMapping("info/{id}")
    public Response<User> getUserInfo(@PathVariable Long id) {
        Assert.notNull(id, "用户id不能为空！");
        return userAPI.getUserInfo(id);
    }
}
