package com.snk.property.domain;

import java.util.List;
import java.util.Date;
import com.snk.common.annotation.Excel;
import com.snk.common.core.domain.BaseEntity;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 房屋基础信息对象 pro_house
 *
 * @author snk
 * @date 2021-10-27
 */
@Accessors
public class ProHouse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标记 */
    private Long id;

    /** 业主姓名 */
    @Excel(name = "业主姓名")
    private String owerName;

    /** 业主联系电话 */
    @Excel(name = "业主联系电话")
    private String owerMobile;

    /** 房屋类型 */
    @Excel(name = "房屋类型")
    private Long houseTypeId;

    /** 房屋地址 */
    private Long houseAddressId;

    /** 房屋地址名称 */
    @Excel(name = "房屋地址名称")
    private String houseAddressName;

    /** 房屋购买时间 */
    @Excel(name = "房屋购买时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date buyTime;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createrTime;

    /** 状态 */
    @Excel(name = "状态")
    private Long houseState;

    /** 业主照片 */
    @Excel(name = "业主照片")
    private String owerImage;

    /** 家庭成员信息 */
    private List<ProHouseMember> proHouseMemberList;
    private ProHouseAddress houseAddress;
    private ProHouseType houseType;

    public ProHouseAddress getHouseAddress() {
        if (houseAddress==null){
            houseAddress=new ProHouseAddress();
        }
        return houseAddress;
    }

    public void setHouseAddress(ProHouseAddress houseAddress) {
        this.houseAddress = houseAddress;
    }

    public ProHouseType getHouseType() {
        if (houseType==null){
            houseType=new ProHouseType();
        }
        return houseType;
    }

    public void setHouseType(ProHouseType houseType) {
        this.houseType = houseType;
    }


    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setOwerName(String owerName)
    {
        this.owerName = owerName;
    }

    public String getOwerName()
    {
        return owerName;
    }
    public void setOwerMobile(String owerMobile)
    {
        this.owerMobile = owerMobile;
    }

    public String getOwerMobile()
    {
        return owerMobile;
    }
    public void setHouseTypeId(Long houseTypeId)
    {
        this.houseTypeId = houseTypeId;
    }

    public Long getHouseTypeId()
    {
        return houseTypeId;
    }
    public void setHouseAddressId(Long houseAddressId)
    {
        this.houseAddressId = houseAddressId;
    }

    public Long getHouseAddressId()
    {
        return houseAddressId;
    }
    public void setHouseAddressName(String houseAddressName)
    {
        this.houseAddressName = houseAddressName;
    }

    public String getHouseAddressName()
    {
        return houseAddressName;
    }
    public void setBuyTime(Date buyTime)
    {
        this.buyTime = buyTime;
    }

    public Date getBuyTime()
    {
        return buyTime;
    }
    public void setCreaterTime(Date createrTime)
    {
        this.createrTime = createrTime;
    }

    public Date getCreaterTime()
    {
        return createrTime;
    }
    public void setHouseState(Long houseState)
    {
        this.houseState = houseState;
    }

    public Long getHouseState()
    {
        return houseState;
    }
    public void setOwerImage(String owerImage)
    {
        this.owerImage = owerImage;
    }

    public String getOwerImage()
    {
        return owerImage;
    }

    public List<ProHouseMember> getProHouseMemberList()
    {
        return proHouseMemberList;
    }

    public void setProHouseMemberList(List<ProHouseMember> proHouseMemberList)
    {
        this.proHouseMemberList = proHouseMemberList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("owerName", getOwerName())
                .append("owerMobile", getOwerMobile())
                .append("houseTypeId", getHouseTypeId())
                .append("houseAddressId", getHouseAddressId())
                .append("houseAddressName", getHouseAddressName())
                .append("buyTime", getBuyTime())
                .append("createrTime", getCreaterTime())
                .append("createBy", getCreateBy())
                .append("updateTime", getUpdateTime())
                .append("updateBy", getUpdateBy())
                .append("houseState", getHouseState())
                .append("owerImage", getOwerImage())
                .append("remark", getRemark())
                .append("proHouseMemberList", getProHouseMemberList())
                .toString();
    }
}