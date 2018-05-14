package com.shiyue.bm.core.monitor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

/**
 * <br/>
 * Created on 16/10/8.
 *
 * @auther lishenghao01
 */
public class GatewayAspect {
    @Pointcut(value = "@annotation(com.baidu.as.sche.core.gateway.HttpGateway)")
    public void gatewayPoint() {

    }

    @Around(value = "gatewayPoint()")
    public void quotaPointAround(ProceedingJoinPoint pjp) {

    }
}
