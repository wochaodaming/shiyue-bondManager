package com.shiyue.bm.core.mvc.interceptor;


import com.shiyue.bm.core.basestruct.Operator;
import com.shiyue.bm.core.log.LogConf;
import com.shiyue.bm.core.log.SysLoggerEnum;
import com.shiyue.bm.core.util.IpUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * <br/>
 * Created on 16/11/6.
 *
 * @auther lishenghao01
 */
public class OperatorInterceptor extends HandlerInterceptorAdapter {
    private static final ThreadLocal<Operator> opTL = new ThreadLocal<>();

    public static ThreadLocal<Operator> getOpTL() {
        return opTL;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
            Exception {
        Operator operator = new Operator();
        operator.setName(request.getParameter("userName"));
        operator.setRequestId(request.getParameter("logId"));
        operator.setCredential(request.getParameter("credential"));
        operator.setToken(request.getParameter("token"));
        operator.setRemoteIp(request.getRemoteAddr());
        if (StringUtils.isBlank(operator.getRequestId())) {
            String uuid = UUID.randomUUID().toString().replace("-", "");
            operator.setRequestId(IpUtils.getLocalHostAddress() + ":" + uuid);
        }
        LoggerFactory.getLogger(SysLoggerEnum.Access.toString()).info("access ip is: " + request.getRemoteAddr());
        opTL.set(operator);
        MDC.put(LogConf.getRequestIdKey(), operator.getRequestId());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView
            modelAndView) throws Exception {
        LoggerFactory.getLogger(SysLoggerEnum.Access.toString()).info("response time for {} is {}", request
                .getRequestURI(), System.currentTimeMillis() - opTL.get().getCreateDateTime().getTime());
        MDC.remove(LogConf.getRequestIdKey());
        opTL.remove();
    }
}

