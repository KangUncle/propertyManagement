package com.snk.property.domain;

import com.snk.common.annotation.Excel;
import com.snk.common.core.domain.TreeEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 楼栋地址对象 pro_house_address
 *
 * @author snk
 * @date 2021-10-27
 */
public class ProHouseAddress extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 标记 */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 父ID */
    @Excel(name = "父ID")
    private Long pid;

    /** 祖辈名称 */
    @Excel(name = "祖辈名称")
    private String ancestorsName;

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
    public void setPid(Long pid)
    {
        this.pid = pid;
    }

    public Long getPid()
    {
        return pid;
    }
    public void setAncestorsName(String ancestorsName)
    {
        this.ancestorsName = ancestorsName;
    }

    public String getAncestorsName()
    {
        return ancestorsName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("pid", getPid())
                .append("ancestors", getAncestors())
                .append("ancestorsName", getAncestorsName())
                .toString();
    }
}