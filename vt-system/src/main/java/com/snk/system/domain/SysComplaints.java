package com.snk.system.domain;
import java.util.Date;
import com.snk.common.annotation.Excel;
import com.snk.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 投诉对象 sys_complaints
 *
 * @author snk
 * @date 2021-11-03
 */
public class SysComplaints extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标记 */
    private Long id;

    /** 用户id（用户端预留字段） */
    private Long memberId;

    /** 投诉的部门 */
    @Excel(name = "投诉的部门")
    private Long deptId;

    /** 投诉内容 */
    private String content;

    /** 处理人 */
    @Excel(name = "处理人")
    private String dealMan;

    /** 处理时间 */
    @Excel(name = "处理时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dealTime;

    /** 处理结果 */
    private String dealContent;

    private SysDept dept;

    public SysDept getDept() {
        return dept;
    }

    public void setDept(SysDept dept) {
        this.dept = dept;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setMemberId(Long memberId)
    {
        this.memberId = memberId;
    }

    public Long getMemberId()
    {
        return memberId;
    }
    public void setDeptId(Long deptId)
    {
        this.deptId = deptId;
    }

    public Long getDeptId()
    {
        return deptId;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
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
    public void setDealContent(String dealContent)
    {
        this.dealContent = dealContent;
    }

    public String getDealContent()
    {
        return dealContent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("memberId", getMemberId())
                .append("deptId", getDeptId())
                .append("content", getContent())
                .append("createTime", getCreateTime())
                .append("dealMan", getDealMan())
                .append("dealTime", getDealTime())
                .append("dealContent", getDealContent())
                .append("remark", getRemark())
                .toString();
    }
}