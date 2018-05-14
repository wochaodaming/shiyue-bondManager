/*
 *  Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */

package com.shiyue.bm.core.exception.base;

import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 * ClassName: RootException <br>
 * Description: TODO <br>
 * Date: 2015年11月24日 下午9:14:46 <br>
 *
 * @author lishenghao01(邮箱)
 */
public abstract class RootException extends Exception {
    private final String code;
    private final String errMsg;

    public RootException(String code, String errMsg) {
        super();
        this.code = code;
        this.errMsg = errMsg;
    }

    public RootException(String code, String errMsg, Throwable t) {
        super(t);
        this.code = code;
        this.errMsg = errMsg;
    }

    public static String covertExceptionToString(Throwable t) {
        return ExceptionUtils.getStackTrace(t);
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
