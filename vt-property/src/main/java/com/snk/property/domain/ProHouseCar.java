package com.snk.property.domain;

import com.snk.common.annotation.Excel;
import com.snk.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 车辆入库对象 pro_house_car
 * 
 * @author snk
 * @date 2021-10-29
 */
public class ProHouseCar extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标记 */
    private Long id;

    /** 房屋 */
    @Excel(name = "房屋")
    private Long houseId;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String carNum;

    /** 车辆属性 */
    @Excel(name = "车辆属性")
    private Long carAttributeId;

    /** 车辆照片 */
    @Excel(name = "车辆照片")
    private String image;

    private ProStopCarAttribute carAttribute;

    public ProStopCarAttribute getCarAttribute() {
        return carAttribute;
    }

    public void setCarAttribute(ProStopCarAttribute carAttribute) {
        this.carAttribute = carAttribute;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setHouseId(Long houseId) 
    {
        this.houseId = houseId;
    }

    public Long getHouseId() 
    {
        return houseId;
    }
    public void setCarNum(String carNum) 
    {
        this.carNum = carNum;
    }

    public String getCarNum() 
    {
        return carNum;
    }
    public void setCarAttributeId(Long carAttributeId) 
    {
        this.carAttributeId = carAttributeId;
    }

    public Long getCarAttributeId() 
    {
        return carAttributeId;
    }
    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("houseId", getHouseId())
            .append("carNum", getCarNum())
            .append("carAttributeId", getCarAttributeId())
            .append("image", getImage())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime",getUpdateTime())
            .append("updateBy",getUpdateBy())
//            .append("carAttribute",getCarAttribute())
            .toString();
    }
}