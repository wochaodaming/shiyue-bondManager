package com.shiyue.bm.module.dictionary;

import java.io.Serializable;

/**
 * 数据字典
 */
public class Dictionary implements Serializable {
    private Long id;
    /**
     * 分组
     */
    private String group;
    /**
     * 值
     */
    private String value;
    /**
     * 备注
     */
    private String comment;
    /**
     * 排位顺序
     */
    private int order;

    public Long getId() {
        return id;
    }

    public Dictionary setId(Long id) {
        this.id = id;
        return this;
    }

    public String getGroup() {
        return group;
    }

    public Dictionary setGroup(String group) {
        this.group = group;
        return this;
    }

    public String getValue() {
        return value;
    }

    public Dictionary setValue(String value) {
        this.value = value;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Dictionary setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public int getOrder() {
        return order;
    }

    public Dictionary setOrder(int order) {
        this.order = order;
        return this;
    }
}
