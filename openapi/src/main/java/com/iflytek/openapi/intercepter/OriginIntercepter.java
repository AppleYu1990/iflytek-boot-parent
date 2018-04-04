package com.iflytek.openapi.intercepter;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Copyright (c) 2017-2018 iFLYTEK Company LTD.
 * All rights reserved.
 *
 * @Description:跨域拦截器
 * @Date: Created in 2018 2018/1/20 17:55
 * @Author: pengnian
 */
public class OriginIntercepter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        return true;
    }
}
