package com.shiyue.bm.module.cunsumer;

import java.util.Date;

/**
 * 客户信息
 */
public class ConsumerInfo {
    private Long id;
    private String name;
    /**
     * 机构
     */
    private String organization;
    /**
     * 职位
     */
    private String placeOfWork;
    /**
     * 手机号
     */
    private String cellPhone;
    private String telephone;
    private String email;
    /**
     * 主QQ
     */
    private InstantMessage primaryQQ;
    /**
     * 备用QQ
     */
    private InstantMessage standbyQQ;
    /**
     * 主微信号
     */
    private InstantMessage primaryWeChat;
    /**
     * 备用微信号
     */
    private InstantMessage standbyWeChat;
    private String address;
    private Date birthday;
    /**
     * 生日提醒
     */
    private String birthdayRemind;
    /**
     * 拜访日
     */
    private Date visitDay;
    /**
     * 拜访提醒
     */
    private String visitDayRemind;

    public Long getId() {
        return id;
    }

    public ConsumerInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ConsumerInfo setName(String name) {
        this.name = name;
        return this;
    }

    public String getOrganization() {
        return organization;
    }

    public ConsumerInfo setOrganization(String organization) {
        this.organization = organization;
        return this;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public ConsumerInfo setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
        return this;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public ConsumerInfo setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
        return this;
    }

    public String getTelephone() {
        return telephone;
    }

    public ConsumerInfo setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ConsumerInfo setEmail(String email) {
        this.email = email;
        return this;
    }

    public InstantMessage getPrimaryQQ() {
        return primaryQQ;
    }

    public ConsumerInfo setPrimaryQQ(InstantMessage primaryQQ) {
        this.primaryQQ = primaryQQ;
        return this;
    }

    public InstantMessage getStandbyQQ() {
        return standbyQQ;
    }

    public ConsumerInfo setStandbyQQ(InstantMessage standbyQQ) {
        this.standbyQQ = standbyQQ;
        return this;
    }

    public InstantMessage getPrimaryWeChat() {
        return primaryWeChat;
    }

    public ConsumerInfo setPrimaryWeChat(InstantMessage primaryWeChat) {
        this.primaryWeChat = primaryWeChat;
        return this;
    }

    public InstantMessage getStandbyWeChat() {
        return standbyWeChat;
    }

    public ConsumerInfo setStandbyWeChat(InstantMessage standbyWeChat) {
        this.standbyWeChat = standbyWeChat;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ConsumerInfo setAddress(String address) {
        this.address = address;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public ConsumerInfo setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getBirthdayRemind() {
        return birthdayRemind;
    }

    public ConsumerInfo setBirthdayRemind(String birthdayRemind) {
        this.birthdayRemind = birthdayRemind;
        return this;
    }

    public Date getVisitDay() {
        return visitDay;
    }

    public ConsumerInfo setVisitDay(Date visitDay) {
        this.visitDay = visitDay;
        return this;
    }

    public String getVisitDayRemind() {
        return visitDayRemind;
    }

    public ConsumerInfo setVisitDayRemind(String visitDayRemind) {
        this.visitDayRemind = visitDayRemind;
        return this;
    }
}
