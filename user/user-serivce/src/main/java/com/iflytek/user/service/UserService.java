package com.iflytek.user.service;

import com.iflytek.user.entity.User;

/**
 * Copyright (c) 2017-2018 iFLYTEK Company LTD.
 * All rights reserved.
 *
 * @Description:
 * @Date: Created in 2018 2018/1/20 17:55
 * @Author: pengnian
 */
public interface UserService {

    User getUserInfo(Long Id);

    User insertUser(User user);

    void handleMessage(String msg);
}
