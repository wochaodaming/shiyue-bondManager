package com.shiyue.bm.core.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <br/>
 * Created on 16/11/3.
 *
 * @auther lishenghao01
 */
public class AuditLogger {
    private static final Logger logger = LoggerFactory.getLogger(SysLoggerEnum.Audit.toString());

    public static final Logger getLogger() {
        return logger;
    }
}
