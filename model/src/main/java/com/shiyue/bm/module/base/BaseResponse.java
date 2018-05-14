package com.shiyue.bm.module.base;

import com.shiyue.bm.core.mvc.interceptor.OperatorInterceptor;

import java.io.Serializable;

public class BaseResponse<T> implements Serializable {
    private String requestId = OperatorInterceptor.getOpTL().get().getRequestId();
    private String exitCode = "0";
    private String errMsg;
    private T result;

    public BaseResponse() {
    }

    public BaseResponse(T result) {
        this.result = result;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getExitCode() {
        return exitCode;
    }

    public void setExitCode(String exitCode) {
        this.exitCode = exitCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}