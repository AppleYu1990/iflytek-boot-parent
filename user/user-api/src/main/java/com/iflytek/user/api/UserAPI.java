package com.iflytek.user.api;

import com.iflytek.common.Response.Response;
import com.iflytek.user.entity.User;

/**
 * Copyright (c) 2017-2018 iFLYTEK Company LTD.
 * All rights reserved.
 *
 * @Description:
 * @Date: Created in 2018 2018/1/20 17:55
 * @Author: pengnian
 */
public interface UserAPI {

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    public Response<User> getUserInfo(Long id);

    /**
     * 插入用户信息
     * @param user
     * @return
     */
    Response<User> insertUser(User user);
}
