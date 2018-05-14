package com.shiyue.bm.module.dictionary;

import com.shiyue.bm.core.datetime.IopDate;

import java.io.Serializable;

/**
 * 数据字典
 */
public class Dictionary implements Serializable {
    private Long id;
    /**
     * 分组
     */
    private String configGroup;
    /**
     * 值
     */
    private String configValue;
    /**
     * 备注
     */
    private String configComment;
    /**
     * 排位顺序
     */
    private int configOrder = 0;
    /**
     * 更新时间
     */
    private IopDate updatetime;

    public IopDate getUpdatetime() {
        return updatetime;
    }

    public Dictionary setUpdatetime(IopDate updatetime) {
        this.updatetime = updatetime;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Dictionary setId(Long id) {
        this.id = id;
        return this;
    }

    public String getConfigGroup() {
        return configGroup;
    }

    public Dictionary setConfigGroup(String configGroup) {
        this.configGroup = configGroup;
        return this;
    }

    public String getConfigValue() {
        return configValue;
    }

    public Dictionary setConfigValue(String configValue) {
        this.configValue = configValue;
        return this;
    }

    public String getComment() {
        return configComment;
    }

    public Dictionary setComment(String comment) {
        this.configComment = comment;
        return this;
    }

    public int getConfigOrder() {
        return configOrder;
    }

    public Dictionary setConfigOrder(int configOrder) {
        this.configOrder = configOrder;
        return this;
    }
}
