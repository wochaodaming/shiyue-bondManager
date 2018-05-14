package com.shiyue.bm.core.basestruct;

import java.util.Date;

/**
 * 接入层判定的操作者
 * <p/>
 * Created by lishenghao01 on 16/9/24.
 */
public class Operator {
    /**
     * 事务编号 或 LogId
     * 该字段会集成到日志头中去
     */
    private String requestId;
    /**
     * MatrixControl可能需要
     */
    private String name;
    /**
     * MatrixControl可能需要
     */
    private String token;
    private String type;
    private String credential;
    private Date createDateTime = new Date();
    private Date finishDateTime;
    private String remoteIp;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Date getFinishDateTime() {
        return finishDateTime;
    }

    public void setFinishDateTime(Date finishDateTime) {
        this.finishDateTime = finishDateTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }
}
