package com.iflytek.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.iflytek.common.cache.RedisTemplateBuilder;
import com.iflytek.common.mongodb.Page;
import com.iflytek.user.dao.UserDao;
import com.iflytek.user.entity.User;
import com.iflytek.user.mongo.UserMongo;
import com.iflytek.user.mq.MessageSender;
import com.iflytek.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

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

    @Autowired
    private RedisTemplateBuilder redisTemplateBuilder;

    @Autowired
    private MessageSender messageSender;

    @Autowired
    private UserMongo userMongo;

    @Value("${redis.host}")
    private String redisHost;

    @Value("${redis.port}")
    private String redisPort;

    private static final String USER_ID = "user:id:";

    @Override
    public User getUserInfo(Long id) {
        RedisTemplate<String, User> redisTemplate = redisTemplateBuilder.build(User.class);
        User user = redisTemplate.opsForValue().get(USER_ID + id);
        if (user != null) {
            return user;
        }
        User userInfo = userDao.getUserInfo(id);
        Assert.notNull(userInfo, "无法根据当期id查询到用户信息");
        redisTemplate.opsForValue().set(USER_ID + id, userInfo);
        
        System.out.println(redisHost + "===" + redisPort);
        
        return userInfo;
    }

    @Override
    @Transactional
    public User insertUser(User user) {
        Integer count = userDao.insertUser(user);
        if (count > 0) {
            RedisTemplate<String, User> redisTemplate = redisTemplateBuilder.build(User.class);
            redisTemplate.opsForValue().set(USER_ID + user.getId(), user);
        }
        messageSender.sendMessage(JSON.toJSONString(user));
        return user;
    }

    @Override
    public void handleMessage(String msg) {
        User user = JSON.parseObject(msg, User.class);
        userMongo.insert(user);
    }
}
