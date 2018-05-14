package com.shiyue.bm.core.log.proxy;

import com.alibaba.fastjson.JSON;
import com.shiyue.bm.core.log.SysLoggerEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * <br/>
 * Created on 16/11/16.
 *
 * @auther lishenghao01
 */
@Aspect
public class GodEyeLogAspect {
    @Pointcut(value = "within(@com.shiyue.bm.core.log.proxy.GodEyeLog *) "
            + "|| @annotation(com.shiyue.bm.core.log.proxy.GodEyeLog)")
    public void godEyeLogPoint() {
    }

    @Around(value = "godEyeLogPoint()")
    public Object godEyeLogPointAround(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        String className = pjp.getTarget().getClass().getSimpleName();
        try {
            LoggerFactory.getLogger(SysLoggerEnum.GodEye.toString()).info(className + "-" + method.getName()
                    + ", input--> " + JSON.toJSONString(pjp.getArgs()));
        } finally {
            Object ret = pjp.proceed();
            try {
                LoggerFactory.getLogger(SysLoggerEnum.GodEye.toString()).info(className + "-" + method.getName()
                        + ", output==> " + JSON.toJSONString(ret));
            } finally {
                return ret;
            }
        }

    }
}
