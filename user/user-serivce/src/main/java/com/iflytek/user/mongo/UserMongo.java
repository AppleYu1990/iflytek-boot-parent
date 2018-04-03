package com.iflytek.user.mongo;

import com.iflytek.common.mongodb.AbsBaseMongo;
import com.iflytek.user.entity.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * Copyright (c) 2017-2018 iFLYTEK Company LTD.
 * All rights reserved.
 *
 * @Description:
 * @Date: Created in 2018 2018/1/20 17:55
 * @Author: pengnian
 */
@Repository
public class UserMongo extends AbsBaseMongo<User> {

    @Override
    protected void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


}
