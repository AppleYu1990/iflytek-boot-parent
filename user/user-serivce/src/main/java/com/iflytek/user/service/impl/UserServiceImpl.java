package com.iflytek.user.service.impl;

import com.iflytek.user.dao.UserDao;
import com.iflytek.user.entity.User;
import com.iflytek.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright (c) 2017-2018 iFLYTEK Company LTD.
 * All rights reserved.
 *
 * @Description:
 * @Date: Created in 2018 2018/1/20 17:55
 * @Author: pengnian
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserInfo(Long id) {
        return userDao.getUserInfo(id);
    }
}
