package com.snk.property.domain;

import com.snk.common.annotation.Excel;
import com.snk.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 车位出租订单对象 pro_carport_rent_order
 * 
 * @author snk
 * @date 2021-10-29
 */
public class ProCarportRentOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标记 */
    private Long id;

    /** 车位出租信息 */
    @Excel(name = "车位出租信息")
    private Long carportRentInfoId;

    /** 价格 */
    @Excel(name = "价格")
    private Long totalPrice;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private Long state;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCarportRentInfoId(Long carportRentInfoId) 
    {
        this.carportRentInfoId = carportRentInfoId;
    }

    public Long getCarportRentInfoId() 
    {
        return carportRentInfoId;
    }
    public void setTotalPrice(Long totalPrice) 
    {
        this.totalPrice = totalPrice;
    }

    public Long getTotalPrice() 
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
            .append("carportRentInfoId", getCarportRentInfoId())
            .append("totalPrice", getTotalPrice())
            .append("createTime", getCreateTime())
            .append("state", getState())
            .toString();
    }
}