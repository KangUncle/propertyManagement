package com.snk.property.mapper;

import java.util.List;
import com.snk.property.domain.ProStopCarAttribute;

/**
 * 车辆属性Mapper接口
 * 
 * @author snk
 * @date 2021-10-29
 */
public interface ProStopCarAttributeMapper 
{
    /**
     * 查询车辆属性
     * 
     * @param id 车辆属性ID
     * @return 车辆属性
     */
    public ProStopCarAttribute selectProStopCarAttributeById(Long id);

    /**
     * 查询车辆属性列表
     * 
     * @param proStopCarAttribute 车辆属性
     * @return 车辆属性集合
     */
    public List<ProStopCarAttribute> selectProStopCarAttributeList(ProStopCarAttribute proStopCarAttribute);

    /**
     * 新增车辆属性
     * 
     * @param proStopCarAttribute 车辆属性
     * @return 结果
     */
    public int insertProStopCarAttribute(ProStopCarAttribute proStopCarAttribute);

    /**
     * 修改车辆属性
     * 
     * @param proStopCarAttribute 车辆属性
     * @return 结果
     */
    public int updateProStopCarAttribute(ProStopCarAttribute proStopCarAttribute);

    /**
     * 删除车辆属性
     * 
     * @param id 车辆属性ID
     * @return 结果
     */
    public int deleteProStopCarAttributeById(Long id);

    /**
     * 批量删除车辆属性
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProStopCarAttributeByIds(String[] ids);
}