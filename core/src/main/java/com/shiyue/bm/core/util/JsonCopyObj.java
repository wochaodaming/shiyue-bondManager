package com.shiyue.bm.core.util;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * <br/>
 * Created on 16/11/10.
 *
 * @auther lishenghao01
 */
public class JsonCopyObj {
    public static <T> T copyObj(Class<T> descClazz, Object src) {
        T obj = JSON.parseObject(JSON.toJSONString(src), descClazz);
        return obj;
    }

    public static <T> List<T> copyList(Class<T> descClazz, Object src) {
        List<T> obj = JSON.parseArray(JSON.toJSONString(src), descClazz);
        return obj;
    }
}
