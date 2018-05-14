package com.shiyue.bm.core.exception.base;

import java.util.TreeMap;

/**
 * Created by lishenghao01 on 16/9/24.
 */
public class ErrKeyCollection {
    private static final TreeMap<String, String> errKeyMap = new TreeMap<>();

    public static synchronized void addErrKey(String errKey, String errMsg) {
        boolean contains = errKeyMap.containsKey(errKey);
        if (contains) {
            throw new Error("重复的ErrKey值: " + errKey);
        }
        errKeyMap.put(errKey, errMsg);
    }

    public static TreeMap<String, String> getErrKeyMap() {
        return errKeyMap;
    }
}
