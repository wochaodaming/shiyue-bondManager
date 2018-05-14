package com.shiyue.bm.core.log;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lishenghao01 on 16/9/24.
 */
public class CoreLog {
    private static final Logger logger = LoggerFactory.getLogger("Core");

    public static final Logger getLogger() {
        return logger;
    }
}
