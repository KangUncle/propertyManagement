package com.snk.property.domain;

import java.util.Date;
import com.snk.common.annotation.Excel;
import com.snk.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 维修对象 pro_repair
 * 
 * @author snk
 * @date 2021-11-05
 */
public class ProRepair extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标记 */
    private Long id;

    /** 报修人姓名 */
    @Excel(name = "报修人姓名")
    private String repairManName;

    /** 具体内容 */
    @Excel(name = "具体内容")
    private String repairContent;

    /** 报修项目 */
    @Excel(name = "报修项目")
    private String repairProject;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String repairArea;

    /** 报修地址 */
    @Excel(name = "报修地址")
    private String repairAddress;

    /** 报修人电话 */
    @Excel(name = "报修人电话")
    private String repairManPhone;

    /** 报修照片 */
    @Excel(name = "报修照片")
    private String repairImage;

    /** 服务人员 */
    @Excel(name = "服务人员")
    private Long serviceManId;

    /** 报修人 */
    private Long memberId;

    /** 处理人 */
    @Excel(name = "处理人")
    private String dealMan;

    /** 处理时间 */
    @Excel(name = "处理时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dealTime;

    /** 服务时间 */
    @Excel(name = "服务时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date serviceTime;

    /** 状态 */
    @Excel(name = "状态")
    private Long repairState;

    /** 凭证图片 */
    @Excel(name = "凭证图片")
    private String credentialImg;

    public String getCredentialImg() {
        return credentialImg;
    }

    public void setCredentialImg(String credentialImg) {
        this.credentialImg = credentialImg;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRepairManName(String repairManName) 
    {
        this.repairManName = repairManName;
    }

    public String getRepairManName() 
    {
        return repairManName;
    }
    public void setRepairContent(String repairContent) 
    {
        this.repairContent = repairContent;
    }

    public String getRepairContent() 
    {
        return repairContent;
    }
    public void setRepairProject(String repairProject) 
    {
        this.repairProject = repairProject;
    }

    public String getRepairProject() 
    {
        return repairProject;
    }
    public void setRepairArea(String repairArea) 
    {
        this.repairArea = repairArea;
    }

    public String getRepairArea() 
    {
        return repairArea;
    }
    public void setRepairAddress(String repairAddress) 
    {
        this.repairAddress = repairAddress;
    }

    public String getRepairAddress() 
    {
        return repairAddress;
    }
    public void setRepairManPhone(String repairManPhone) 
    {
        this.repairManPhone = repairManPhone;
    }

    public String getRepairManPhone() 
    {
        return repairManPhone;
    }
    public void setRepairImage(String repairImage) 
    {
        this.repairImage = repairImage;
    }

    public String getRepairImage() 
    {
        return repairImage;
    }
    public void setServiceManId(Long serviceManId) 
    {
        this.serviceManId = serviceManId;
    }

    public Long getServiceManId() 
    {
        return serviceManId;
    }
    public void setMemberId(Long memberId) 
    {
        this.memberId = memberId;
    }

    public Long getMemberId() 
    {
        return memberId;
    }
    public void setDealMan(String dealMan)
    {
        this.dealMan = dealMan;
    }

    public String getDealMan()
    {
        return dealMan;
    }
    public void setDealTime(Date dealTime) 
    {
        this.dealTime = dealTime;
    }

    public Date getDealTime() 
    {
        return dealTime;
    }
    public void setServiceTime(Date serviceTime) 
    {
        this.serviceTime = serviceTime;
    }

    public Date getServiceTime() 
    {
        return serviceTime;
    }
    public void setRepairState(Long repairState) 
    {
        this.repairState = repairState;
    }

    public Long getRepairState() 
    {
        return repairState;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("repairManName", getRepairManName())
            .append("repairContent", getRepairContent())
            .append("repairProject", getRepairProject())
            .append("repairArea", getRepairArea())
            .append("repairAddress", getRepairAddress())
            .append("repairManPhone", getRepairManPhone())
            .append("repairImage", getRepairImage())
            .append("serviceManId", getServiceManId())
            .append("memberId", getMemberId())
            .append("dealMan", getDealMan())
            .append("createTime", getCreateTime())
            .append("dealTime", getDealTime())
            .append("serviceTime", getServiceTime())
            .append("repairState", getRepairState())
            .append("credentialImg",getCredentialImg())
            .toString();
    }
}