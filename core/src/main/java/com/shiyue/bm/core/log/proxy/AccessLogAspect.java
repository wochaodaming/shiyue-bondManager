package com.shiyue.bm.core.log.proxy;

import com.alibaba.fastjson.JSON;
import com.shiyue.bm.core.log.SysLoggerEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * <br/>
 * Created on 16/11/16.
 *
 * @auther lishenghao01
 */
@Aspect
@Component
public class AccessLogAspect {
    @Pointcut(value = "within(@com.shiyue.bm.core.log.proxy.AccessLog *) "
            + "|| @annotation(com.shiyue.bm.core.log.proxy.AccessLog)")
    public void accessLogPoint() {
    }

    @Around(value = "accessLogPoint()")
    public Object accessLogPointAround(ProceedingJoinPoint pjp) throws Throwable {
        try {
            LoggerFactory.getLogger(SysLoggerEnum.Access.toString()).info(JSON.toJSONString(pjp.getArgs()));
        } finally {
            Object ret = pjp.proceed();
            try {
                LoggerFactory.getLogger(SysLoggerEnum.Access.toString()).info(JSON.toJSONString(ret));
            } finally {
                return ret;
            }
        }

    }
}
