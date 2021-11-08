package com.snk.property.domain;

import java.util.Date;
import com.snk.common.annotation.Excel;
import com.snk.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 车辆进出详情对象 pro_car_in_out_info
 * 
 * @author snk
 * @date 2021-10-29
 */
public class ProCarInOutInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标记 */
    private Long id;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String carNum;

    /** 进入时间 */
    @Excel(name = "进入时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date intoTime;

    /** 出去时间 */
    @Excel(name = "出去时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date outTime;

    /** 进入时的设备 */
    @Excel(name = "进入时的设备")
    private Long intoDeviceId;
    private String intoDeviceName;

    /** 出去时的设备 */
    @Excel(name = "出去时的设备")
    private Long outDeviceId;
    private String outDeviceName;

    /** 进入时的照片 */
    private String intoCarImage;

    /** 出入时的照片 */
    private String outCarImage;

    /** 车辆属性 */
    @Excel(name = "车辆属性")
    private Long carAttributeId;

    /** 属性名称 */
    private String carAttributeTitle;

    public String getCarAttributeTitle() {
        return carAttributeTitle;
    }

    public void setCarAttributeTitle(String carAttributeTitle) {
        this.carAttributeTitle = carAttributeTitle;
    }

    public String getIntoDeviceName() {
        return intoDeviceName;
    }

    public void setIntoDeviceName(String intoDeviceName) {
        this.intoDeviceName = intoDeviceName;
    }

    public String getOutDeviceName() {
        return outDeviceName;
    }

    public void setOutDeviceName(String outDeviceName) {
        this.outDeviceName = outDeviceName;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCarNum(String carNum) 
    {
        this.carNum = carNum;
    }

    public String getCarNum() 
    {
        return carNum;
    }
    public void setIntoTime(Date intoTime) 
    {
        this.intoTime = intoTime;
    }

    public Date getIntoTime() 
    {
        return intoTime;
    }
    public void setOutTime(Date outTime) 
    {
        this.outTime = outTime;
    }

    public Date getOutTime() 
    {
        return outTime;
    }
    public void setIntoDeviceId(Long intoDeviceId) 
    {
        this.intoDeviceId = intoDeviceId;
    }

    public Long getIntoDeviceId() 
    {
        return intoDeviceId;
    }
    public void setOutDeviceId(Long outDeviceId) 
    {
        this.outDeviceId = outDeviceId;
    }

    public Long getOutDeviceId() 
    {
        return outDeviceId;
    }
    public void setIntoCarImage(String intoCarImage) 
    {
        this.intoCarImage = intoCarImage;
    }

    public String getIntoCarImage() 
    {
        return intoCarImage;
    }
    public void setOutCarImage(String outCarImage) 
    {
        this.outCarImage = outCarImage;
    }

    public String getOutCarImage() 
    {
        return outCarImage;
    }
    public void setCarAttributeId(Long carAttributeId) 
    {
        this.carAttributeId = carAttributeId;
    }

    public Long getCarAttributeId() 
    {
        return carAttributeId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("carNum", getCarNum())
            .append("intoTime", getIntoTime())
            .append("outTime", getOutTime())
            .append("intoDeviceId", getIntoDeviceId())
            .append("outDeviceId", getOutDeviceId())
            .append("intoCarImage", getIntoCarImage())
            .append("outCarImage", getOutCarImage())
            .append("carAttributeId", getCarAttributeId())
            .append("outDeviceName",getOutDeviceName())
            .append("intoDeviceName",getIntoDeviceName())
            .append("carAttributeTitle",getCarAttributeTitle())
            .toString();
    }
}