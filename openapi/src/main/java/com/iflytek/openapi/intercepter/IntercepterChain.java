package com.iflytek.openapi.intercepter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Copyright (c) 2017-2018 iFLYTEK Company LTD.
 * All rights reserved.
 *
 * @Description:
 * @Date: Created in 2018 2018/1/20 17:55
 * @Author: pengnian
 */
@Configuration
public class IntercepterChain extends WebMvcConfigurerAdapter {

    @Bean
    public OriginIntercepter originIntercepter() {
        return new OriginIntercepter();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(originIntercepter()).addPathPatterns("/**");
    }
}
