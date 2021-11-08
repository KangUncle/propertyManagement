package com.snk.property.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.snk.common.annotation.Excel;
import com.snk.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 车位详情对象 pro_carport
 * 
 * @author snk
 * @date 2021-10-29
 */
public class ProCarport extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标记 */
    private Long id;

    /** 车位编号 */
    @Excel(name = "车位编号")
    private String carportNum;

    /** 家庭 */
    @Excel(name = "家庭")
    private Long houseId;

    /** 车位图片 */
    @Excel(name = "车位图片")
    private String image;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 用户 */
    @Excel(name = "用户")
    private Long memberId;

    /** 车位状态 */
    @Excel(name = "车位状态")
    private Long state;

    /** 出售时间 */
    @Excel(name = "出售时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date buyTime;

    /** 小区id  */
    @Excel(name = "小区")
    private Long communityId;
    /**
     * 房屋信息
     */
    private ProHouse proHouse;
    /**
     * 小区
     */
    private ProHouseAddress proHouseAddress;

    /**
     * 家庭成员
     */
    private ProHouseMember proHouseMember;

    public ProHouseAddress getProHouseAddress() {
        return proHouseAddress;
    }

    public void setProHouseAddress(ProHouseAddress proHouseAddress) {
        this.proHouseAddress = proHouseAddress;
    }

    public ProHouseMember getProHouseMember() {
        return proHouseMember;
    }

    public void setProHouseMember(ProHouseMember proHouseMember) {
        this.proHouseMember = proHouseMember;
    }

    public ProHouse getProHouse() {
        return proHouse;
    }
    public void setProHouse(ProHouse proHouse) {
        this.proHouse = proHouse;
    }


    public Long getCommunityId() {
        return communityId;
    }
    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCarportNum(String carportNum) 
    {
        this.carportNum = carportNum;
    }

    public String getCarportNum() 
    {
        return carportNum;
    }
    public void setHouseId(Long houseId) 
    {
        this.houseId = houseId;
    }

    public Long getHouseId() 
    {
        return houseId;
    }
    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setMemberId(Long memberId) 
    {
        this.memberId = memberId;
    }

    public Long getMemberId() 
    {
        return memberId;
    }
    public void setState(Long state) 
    {
        this.state = state;
    }

    public Long getState() 
    {
        return state;
    }
    public void setBuyTime(Date buyTime) 
    {
        this.buyTime = buyTime;
    }

    public Date getBuyTime() 
    {
        return buyTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("carportNum", getCarportNum())
            .append("houseId", getHouseId())
            .append("image", getImage())
            .append("price", getPrice())
            .append("memberId", getMemberId())
            .append("state", getState())
            .append("buyTime", getBuyTime())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("communityId",getCommunityId())
            .append("house",getProHouse())
            .append("address",getProHouseAddress())
            .toString();
    }
}