package com.shiyue.bm.core.controller;

/**
 * <br/>
 * Created on 17/6/9.
 *
 * @auther lishenghao01
 */
public class UserSession {
    private String username;
    private long loginTimestamp = System.currentTimeMillis();

    public long getLoginTimestamp() {
        return loginTimestamp;
    }

    public void setLoginTimestamp(long loginTimestamp) {
        this.loginTimestamp = loginTimestamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
