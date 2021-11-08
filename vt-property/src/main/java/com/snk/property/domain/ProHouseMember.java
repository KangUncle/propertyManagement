package com.snk.property.domain;

import java.util.Date;
import com.snk.common.annotation.Excel;
import com.snk.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 家庭成员对象 pro_house_member
 *
 * @author snk
 * @date 2021-10-27
 */
public class ProHouseMember extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标记 */
    private Long id;

    /** 成员姓名 */
    @Excel(name = "成员姓名")
    private String name;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 性别 */
    @Excel(name = "性别")
    private Long sex;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String mobile;

    /** 家庭地址 */
    @Excel(name = "家庭地址")
    private Long houseAddressId;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creatTime;

    /** 状态 */
    @Excel(name = "状态")
    private Long state;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 门禁编号 */
    @Excel(name = "门禁编号")
    private String entranceGuardNum;

    /** 微信的openid */
    @Excel(name = "微信的openid")
    private String openId;

    /** 家庭 */
    @Excel(name = "家庭")
    private Long houseId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setAge(Long age)
    {
        this.age = age;
    }

    public Long getAge()
    {
        return age;
    }
    public void setSex(Long sex)
    {
        this.sex = sex;
    }

    public Long getSex()
    {
        return sex;
    }
    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getMobile()
    {
        return mobile;
    }
    public void setHouseAddressId(Long houseAddressId)
    {
        this.houseAddressId = houseAddressId;
    }

    public Long getHouseAddressId()
    {
        return houseAddressId;
    }
    public void setCreatTime(Date creatTime)
    {
        this.creatTime = creatTime;
    }

    public Date getCreatTime()
    {
        return creatTime;
    }
    public void setState(Long state)
    {
        this.state = state;
    }

    public Long getState()
    {
        return state;
    }
    public void setNote(String note)
    {
        this.note = note;
    }

    public String getNote()
    {
        return note;
    }
    public void setEntranceGuardNum(String entranceGuardNum)
    {
        this.entranceGuardNum = entranceGuardNum;
    }

    public String getEntranceGuardNum()
    {
        return entranceGuardNum;
    }
    public void setOpenId(String openId)
    {
        this.openId = openId;
    }

    public String getOpenId()
    {
        return openId;
    }
    public void setHouseId(Long houseId)
    {
        this.houseId = houseId;
    }

    public Long getHouseId()
    {
        return houseId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("age", getAge())
                .append("sex", getSex())
                .append("mobile", getMobile())
                .append("houseAddressId", getHouseAddressId())
                .append("creatTime", getCreatTime())
                .append("state", getState())
                .append("note", getNote())
                .append("entranceGuardNum", getEntranceGuardNum())
                .append("openId", getOpenId())
                .append("houseId", getHouseId())
                .toString();
    }
}