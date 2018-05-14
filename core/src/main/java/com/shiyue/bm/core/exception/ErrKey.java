package com.shiyue.bm.core.exception;


import com.shiyue.bm.core.exception.base.ErrKeyCollection;

/**
 * Created by lishenghao01 on 16/9/24.
 */
public enum ErrKey {

    JmxAuthenticatorNull(001, "Jmx未配置用户名和密码."),
    HttpGatewayNot200(002, "HTTP not 200"),
    DualRedisError(003, "Redis双读双写失败。"),
    GatewayGroupIsNull(004, "Gateway框架的代理接口的@GatewayGroup不可为空。"),
    DbFailed(005, "DB操作失败"),
    HtmlGeneratorError(006, "生成Html页面异常。"),
    RedisConnError(007, "Redis操作异常。"),
    QuotaError(010, "配额已满");

    private final String code;
    private final String msg;

    ErrKey(int code, String msg) {
        if (code >= 1000) {
            throw new Error("单个模块的异常编码不能超过三位数。");
        }
        this.code = String.valueOf(ExceptionConf.ErrCodePrefix + code);
        this.msg = msg;
        ErrKeyCollection.addErrKey(this.code, msg);
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}