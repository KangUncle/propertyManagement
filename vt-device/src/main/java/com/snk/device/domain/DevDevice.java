package com.snk.device.domain;

import com.snk.common.annotation.Excel;
import com.snk.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 设备信息对象 dev_device
 * 
 * @author snk
 * @date 2021-11-04
 */
public class DevDevice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标记 */
    private Long id;

    /** mac */
    @Excel(name = "mac")
    private String mac;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String name;

    /** 安装位置 */
    @Excel(name = "安装位置")
    private String position;

    /** 开门时长（秒） */
    @Excel(name = "开门时长", readConverterExp = "秒=")
    private Long keepTime;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private Long type;

    /** 0:关闭 1：打开 */
    @Excel(name = "0:关闭 1：打开")
    private Long state;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMac(String mac) 
    {
        this.mac = mac;
    }

    public String getMac() 
    {
        return mac;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPosition(String position) 
    {
        this.position = position;
    }

    public String getPosition() 
    {
        return position;
    }
    public void setKeepTime(Long keepTime) 
    {
        this.keepTime = keepTime;
    }

    public Long getKeepTime() 
    {
        return keepTime;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
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
            .append("mac", getMac())
            .append("name", getName())
            .append("position", getPosition())
            .append("keepTime", getKeepTime())
            .append("type", getType())
            .append("state", getState())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}