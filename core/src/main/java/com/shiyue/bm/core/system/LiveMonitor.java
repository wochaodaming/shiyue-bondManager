package com.shiyue.bm.core.system;

import com.shiyue.bm.core.log.SysLoggerEnum;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * <br/>
 * Created on 16/11/28.
 *
 * @auther lishenghao01
 */
public class LiveMonitor {

    public LiveMonitor() {
        LoggerFactory.getLogger(SysLoggerEnum.Running.toString()).info("系统启动成功-----------------------");
    }

    @Scheduled(fixedRate = 120 * 1000)
    public void iAmLeader() {
        LoggerFactory.getLogger(SysLoggerEnum.Running.toString()).info("I am Master, and is Live.");
    }
}
