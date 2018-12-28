package com.imooc.entity;

import java.util.Date;

/**
 * Desciption:
 *
 * @author yxl
 * @date 2018/12/27 15:42
 */
public class WechatAuth {
    private Long wecharAuthId;
    private String openId;
    private Date createTime;
    private PersonInfo personInfo;

    public Long getWecharAuthId() {
        return wecharAuthId;
    }

    public void setWecharAuthId(Long wecharAuthId) {
        this.wecharAuthId = wecharAuthId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }
}
