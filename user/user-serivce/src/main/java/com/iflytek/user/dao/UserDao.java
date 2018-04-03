package com.iflytek.user.dao;


import com.iflytek.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Copyright (c) 2017-2018 iFLYTEK Company LTD.
 * All rights reserved.
 *
 * @Description:
 * @Date: Created in 2018 2018/1/20 17:55
 * @Author: pengnian
 */
@Mapper
public interface UserDao {

    User getUserInfo(Long id);

    Integer insertUser(User user);
}
