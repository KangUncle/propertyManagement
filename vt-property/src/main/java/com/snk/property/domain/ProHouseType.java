package com.snk.property.domain;

import java.math.BigDecimal;
import com.snk.common.annotation.Excel;
import com.snk.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 房屋类型对象 pro_house_type
 * 
 * @author snk
 * @date 2021-10-24
 */
public class ProHouseType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标记 */
    private Long id;

    /** 房屋类型名称 */
    @Excel(name = "房屋类型名称")
    private String name;

    /** 面积 */
    @Excel(name = "面积")
    private BigDecimal area;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 单价 */
    @Excel(name = "单价")
    private BigDecimal unitPrice;

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
    public void setArea(BigDecimal area) 
    {
        this.area = area;
    }

    public BigDecimal getArea() 
    {
        return area;
    }
    public void setNote(String note) 
    {
        this.note = note;
    }

    public String getNote() 
    {
        return note;
    }
    public void setUnitPrice(BigDecimal unitPrice) 
    {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getUnitPrice() 
    {
        return unitPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("area", getArea())
            .append("note", getNote())
            .append("createTime", getCreateTime())
            .append("unitPrice", getUnitPrice())
            .toString();
    }
}