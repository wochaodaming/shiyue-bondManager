/*
 *  Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */

package com.shiyue.bm.core.exception.base;

/**
 * ClassName: RootRuntimeException <br>
 * Description: TODO <br>
 * Date: 2015年11月24日 下午9:14:51 <br>
 *
 * @author lishenghao01(邮箱)
 */
public abstract class RootRuntimeException extends RuntimeException {
    private final String code;
    private final String errMsg;

    public RootRuntimeException(String code, String errMsg) {
        super();
        this.code = code;
        this.errMsg = errMsg;
    }

    public RootRuntimeException(String code, String errMsg, Throwable t) {
        super(t);
        this.code = code;
        this.errMsg = errMsg;
    }

    public final String getMessage() {
        return this.getAllMessage();
    }

    public final String getAllMessage() {
        return String.format("errCode:%s, errMsg:%s", this.code, this.errMsg);
    }

    public final String getCode() {
        return code;
    }

    public final String getErrMsg() {
        return errMsg;
    }
}
