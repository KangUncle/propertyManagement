package com.snk.property.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.snk.common.annotation.Excel;
import com.snk.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 物业订单对象 pro_house_order
 *
 * @author snk
 * @date 2021-10-27
 */
public class ProHouseOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标记 */
    private Long id;

    /** 开始时间 */
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal realPrice;

    /** 折扣（%） */
    @Excel(name = "折扣", readConverterExp = "%=")
    private BigDecimal discount;

    /** 总价 */
    @Excel(name = "总价")
    private BigDecimal totalPrice;

    /** 房屋地址 */
    @Excel(name = "房屋地址")
    private Long houseAddressId;

    /** 上/下架 */
    @Excel(name = "上/下架")
    private Long shelfStatus;

    /** 房屋 */
    @Excel(name = "房屋")
    private Long houseId;

    /** 审核 */
    @Excel(name = "审核")
    private Long reviewStatus;

    /** 审核时间 */
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date reviewTime;

    /** 审核人 */
    @Excel(name = "审核人")
    private String reviewMan;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createTime;
    /** 审核人 */
    @Excel(name = "创建人")
    private String createBy;

    /** 备注 */
    @Excel(name = "备注")
    private String note;


    private ProHouse house;
    private ProHouseType type;
    private ProHouseAddress address;

    public ProHouse getHouse() {
        return house;
    }

    public void setHouse(ProHouse house) {
        this.house = house;
    }

    public ProHouseType getType() {
        return type;
    }

    public void setType(ProHouseType type) {
        this.type = type;
    }

    public ProHouseAddress getAddress() {
        return address;
    }

    public void setAddress(ProHouseAddress address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setStartTime(Date startTime)
    {
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
    public void setRealPrice(BigDecimal realPrice)
    {
        this.realPrice = realPrice;
    }

    public BigDecimal getRealPrice()
    {
        return realPrice;
    }
    public void setDiscount(BigDecimal discount)
    {
        this.discount = discount;
    }

    public BigDecimal getDiscount()
    {
        return discount;
    }
    public void setTotalPrice(BigDecimal totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice()
    {
        return totalPrice;
    }
    public void setHouseAddressId(Long houseAddressId)
    {
        this.houseAddressId = houseAddressId;
    }

    public Long getHouseAddressId()
    {
        return houseAddressId;
    }
    public void setShelfStatus(Long shelfStatus)
    {
        this.shelfStatus = shelfStatus;
    }

    public Long getShelfStatus()
    {
        return shelfStatus;
    }
    public void setHouseId(Long houseId)
    {
        this.houseId = houseId;
    }

    public Long getHouseId()
    {
        return houseId;
    }
    public void setReviewStatus(Long reviewStatus)
    {
        this.reviewStatus = reviewStatus;
    }

    public Long getReviewStatus()
    {
        return reviewStatus;
    }
    public void setReviewTime(Date reviewTime)
    {
        this.reviewTime = reviewTime;
    }

    public Date getReviewTime()
    {
        return reviewTime;
    }
    public void setReviewMan(String reviewMan)
    {
        this.reviewMan = reviewMan;
    }

    public String getReviewMan()
    {
        return reviewMan;
    }
    public void setNote(String note)
    {
        this.note = note;
    }

    public String getNote()
    {
        return note;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("startTime", getStartTime())
                .append("endTime", getEndTime())
                .append("realPrice", getRealPrice())
                .append("discount", getDiscount())
                .append("totalPrice", getTotalPrice())
                .append("houseAddressId", getHouseAddressId())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("shelfStatus", getShelfStatus())
                .append("houseId", getHouseId())
                .append("reviewStatus", getReviewStatus())
                .append("reviewTime", getReviewTime())
                .append("reviewMan", getReviewMan())
                .append("note", getNote())
                .append("address",getAddress())
                .append("type",getType())
                .append("house",getHouse())
                .toString();
    }
}