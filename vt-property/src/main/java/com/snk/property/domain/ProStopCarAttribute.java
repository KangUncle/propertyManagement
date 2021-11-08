package com.snk.property.domain;

import java.math.BigDecimal;
import com.snk.common.annotation.Excel;
import com.snk.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 车辆属性对象 pro_stop_car_attribute
 * 
 * @author snk
 * @date 2021-10-29
 */
public class ProStopCarAttribute extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标记 */
    private Long id;

    /** 属性标题 */
    @Excel(name = "属性标题")
    private String title;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal basisPrice;

    /** 超时价 */
    @Excel(name = "超时价")
    private BigDecimal timOutPrice;

    /** 免费停车时间（单位：分） */
    @Excel(name = "免费停车时间", readConverterExp = "单=位：分")
    private Long freeTime;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 创建人 */
    @Excel(name = "创建人")
    private Long creater;

    /** 更新人 */
    @Excel(name = "更新人")
    private String updator;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setBasisPrice(BigDecimal basisPrice) 
    {
        this.basisPrice = basisPrice;
    }

    public BigDecimal getBasisPrice() 
    {
        return basisPrice;
    }
    public void setTimOutPrice(BigDecimal timOutPrice) 
    {
        this.timOutPrice = timOutPrice;
    }

    public BigDecimal getTimOutPrice() 
    {
        return timOutPrice;
    }
    public void setFreeTime(Long freeTime) 
    {
        this.freeTime = freeTime;
    }

    public Long getFreeTime() 
    {
        return freeTime;
    }
    public void setNote(String note) 
    {
        this.note = note;
    }

    public String getNote() 
    {
        return note;
    }
    public void setCreater(Long creater) 
    {
        this.creater = creater;
    }

    public Long getCreater() 
    {
        return creater;
    }
    public void setUpdator(String updator) 
    {
        this.updator = updator;
    }

    public String getUpdator() 
    {
        return updator;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("basisPrice", getBasisPrice())
            .append("timOutPrice", getTimOutPrice())
            .append("freeTime", getFreeTime())
            .append("note", getNote())
            .append("createTime", getCreateTime())
            .append("creater", getCreater())
            .append("updateTime", getUpdateTime())
            .append("updator", getUpdator())
            .toString();
    }
}