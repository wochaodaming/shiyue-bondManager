/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package com.shiyue.bm.core.mvc.interceptor;


import com.google.common.io.CharStreams;
import com.shiyue.bm.core.log.CoreLog;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用于处理转发的拦截器,如从转发到主,修改操作转到主等
 *
 * @author lishenghao01
 */
public class ForwardInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = CoreLog.getLogger();


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
            Exception {

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // 抛异常不会进入该方法
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }


    public HttpRequestBase build(HttpServletRequest request) throws IOException {
        if (HttpGet.METHOD_NAME.equals(request.getMethod())) {
            return new HttpGet();
        } else if (HttpDelete.METHOD_NAME.equals(request.getMethod())) {
            return new HttpDelete();
        }

        HttpEntityEnclosingRequestBase req = null;
        switch (request.getMethod()) {
            case HttpPost.METHOD_NAME: {
                req = new HttpPost();
                break;
            }
            case HttpPut.METHOD_NAME: {
                req = new HttpPut();
                break;
            }
            case HttpPatch.METHOD_NAME: {
                req = new HttpPatch();
                break;
            }
            default: {
                throw new RuntimeException("不支持的http method。");
            }
        }
        req.setHeader("Accept", "application/json");
        req.setHeader("Content-Type", "application/json");
        String content = CharStreams.toString(request.getReader());
        HttpEntity entity = new StringEntity(content);
        req.setEntity(entity);

        return req;
    }
}
