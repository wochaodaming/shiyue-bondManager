package com.shiyue.bm.core.exception;


import com.shiyue.bm.core.exception.base.ErrKeyCollection;

/**
 * <br/>
 * Created on 16/11/6.
 *
 * @auther lishenghao01
 */
public enum SysErrKey {
    NoDefinedError("12345678", "未定义的错误.");

    private final String code;
    private final String msg;

    SysErrKey(String code, String msg) {
        this.code = code;
        this.msg = msg;
        ErrKeyCollection.addErrKey(code, msg);
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
