/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package com.shiyue.bm.core.mvc.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.shiyue.bm.core.basestruct.BaseResponse;
import com.shiyue.bm.core.exception.SysErrKey;
import com.shiyue.bm.core.exception.base.RootException;
import com.shiyue.bm.core.exception.base.RootRuntimeException;
import com.shiyue.bm.core.log.CoreLog;
import com.shiyue.bm.core.util.IpUtils;
import org.slf4j.Logger;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * spring api 异常处理,优先于spring自带的异常处理
 *
 * @author lishenghao01
 */
@Component
public class ExceptionHandler implements HandlerExceptionResolver, PriorityOrdered {

    private static final Logger logger = CoreLog.getLogger();

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        if (ex instanceof AsyncRequestTimeoutException) {
            return new ModelAndView();
        }

        logger.error("客户端Ip:" + request.getRemoteAddr());
        logger.error("客户端Host:" + request.getRemoteHost());
        logger.error("response error...", ex);

        // 设置返回值状态码
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        // FIXME 如何设计requestId呢?
        String requestId = null;
        if (OperatorInterceptor.getOpTL().get() != null) {
            requestId = OperatorInterceptor.getOpTL().get().getRequestId();
        } else {
            String uuid = UUID.randomUUID().toString().replace("-", "");
            requestId = IpUtils.getLocalHostAddress() + ":::" + uuid;
        }


        // 构建异常返回值对象
        BaseResponse exceptionResponse = new BaseResponse();
        exceptionResponse.setRequestId(requestId);
        if (ex instanceof RootException) {
            exceptionResponse.setExitCode(((RootException) ex).getCode());
            exceptionResponse.setErrMsg(ex.getMessage());
        } else if (ex instanceof RootRuntimeException) {
            exceptionResponse.setExitCode(((RootRuntimeException) ex).getCode());
            exceptionResponse.setErrMsg(ex.getMessage());
        } else {
            // 其他异常 500
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            exceptionResponse.setExitCode(SysErrKey.NoDefinedError.getCode());
            exceptionResponse.setErrMsg(ex.getMessage());
        }
        try {
            response.getWriter().print(JSON.toJSONString(exceptionResponse, SerializerFeature
                    .DisableCircularReferenceDetect));
        } catch (IOException e) {
            this.logger.error("Exception Handler error!", e);
        }
        return new ModelAndView();
    }

    /**
     * 保证先进入该方法处理exception
     *
     * @return int
     */
    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE;
    }
}
