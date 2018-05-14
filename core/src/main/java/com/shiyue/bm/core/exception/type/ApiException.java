package com.shiyue.bm.core.exception.type;


import com.shiyue.bm.core.exception.base.RootRuntimeException;

/**
 * <br/>
 * Created on 16/12/1.
 *
 * @auther lishenghao01
 */
public class ApiException extends RootRuntimeException {
    private static final String apiCode = "12341234";

    public ApiException(String errMsg) {
        super(apiCode, errMsg);
    }

    public ApiException(String errMsg, Throwable t) {
        super(apiCode, errMsg, t);
    }
}
