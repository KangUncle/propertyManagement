package com.snk.property.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.snk.common.annotation.Excel;
import com.snk.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 停车订单对象 pro_stop_car_order
 * 
 * @author snk
 * @date 2021-10-29
 */
public class ProStopCarOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标记 */
    private Long id;

    /** 车辆进出详情 */
    @Excel(name = "车辆进出详情")
    private Long carInOutInfoId;

    /** 总价 */
    @Excel(name = "总价")
    private BigDecimal totalPrice;

    /** 支付状态 */
    @Excel(name = "支付状态")
    private Long orderState;

    /** 支付时间 */
    @Excel(name = "支付时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date realPayTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCarInOutInfoId(Long carInOutInfoId) 
    {
        this.carInOutInfoId = carInOutInfoId;
    }

    public Long getCarInOutInfoId() 
    {
        return carInOutInfoId;
    }
    public void setTotalPrice(BigDecimal totalPrice) 
    {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice() 
    {
        return totalPrice;
    }
    public void setOrderState(Long orderState) 
    {
        this.orderState = orderState;
    }

    public Long getOrderState() 
    {
        return orderState;
    }
    public void setRealPayTime(Date realPayTime) 
    {
        this.realPayTime = realPayTime;
    }

    public Date getRealPayTime() 
    {
        return realPayTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("carInOutInfoId", getCarInOutInfoId())
            .append("totalPrice", getTotalPrice())
            .append("orderState", getOrderState())
            .append("createTime", getCreateTime())
            .append("realPayTime", getRealPayTime())
            .toString();
    }
}