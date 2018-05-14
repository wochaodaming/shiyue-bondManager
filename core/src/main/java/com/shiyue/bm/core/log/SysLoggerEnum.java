package com.shiyue.bm.core.log;

/**
 * 系统特定的logger类型,架构专用
 * <p/>
 * Created by lishenghao01 on 16/9/24.
 */
public enum SysLoggerEnum {
    /**
     * 运行时日志
     */
    Running,
    /**
     * 接入日志
     */
    Access,
    /**
     * 审计日志
     */
    Audit,
    /**
     * 上帝之眼的日志
     */
    GodEye
}
