package com.snk.property.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.snk.common.annotation.Excel;
import com.snk.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 车位出租详情对象 pro_carport_rent_info
 *
 * @author snk
 * @date 2021-11-02
 */
public class ProCarportRentInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标记 */
    private Long id;

    /** 车位编号 */
    @Excel(name = "车位编号")
    private String carportNum;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String houseCarNum;

    /** 成员姓名 */
    @Excel(name = "成员姓名")
    private String memberName;

    /** 家庭地址 */
    @Excel(name = "家庭地址")
    private String houseAddress;

    /** 开始时间 */
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal totalPrice;

    /** 租聘状态 */
    @Excel(name = "租聘状态")
    private Long state;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public String getCarportNum() {
        return carportNum;
    }

    public void setCarportNum(String carportNum) {
        this.carportNum = carportNum;
    }

    public String getHouseCarNum() {
        return houseCarNum;
    }

    public void setHouseCarNum(String houseCarNum) {
        this.houseCarNum = houseCarNum;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStartTime()
    {
        return startTime;
    }
    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }
    public void setTotalPrice(BigDecimal totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice()
    {
        return totalPrice;
    }
    public void setState(Long state)
    {
        this.state = state;
    }

    public Long getState()
    {
        return state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("carportNum", getCarportNum())
                .append("houseCarNum", getHouseCarNum())
                .append("memberName", getMemberName())
                .append("houseAddress", getHouseAddress())
                .append("startTime", getStartTime())
                .append("endTime", getEndTime())
                .append("totalPrice", getTotalPrice())
                .append("state", getState())
                .append("createTime", getCreateTime())
                .toString();
    }
}