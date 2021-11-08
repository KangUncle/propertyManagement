package com.snk.property.service.impl;

import java.util.List;
import com.snk.common.utils.DateUtils;
import com.snk.framework.util.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.snk.property.mapper.ProStopCarAttributeMapper;
import com.snk.property.domain.ProStopCarAttribute;
import com.snk.property.service.IProStopCarAttributeService;
import com.snk.common.core.text.Convert;

/**
 * 车辆属性Service业务层处理
 * 
 * @author snk
 * @date 2021-10-29
 */
@Service
public class ProStopCarAttributeServiceImpl implements IProStopCarAttributeService 
{
    @Autowired
    private ProStopCarAttributeMapper proStopCarAttributeMapper;

    /**
     * 查询车辆属性
     * 
     * @param id 车辆属性ID
     * @return 车辆属性
     */
    @Override
    public ProStopCarAttribute selectProStopCarAttributeById(Long id)
    {
        return proStopCarAttributeMapper.selectProStopCarAttributeById(id);
    }

    /**
     * 查询车辆属性列表
     * 
     * @param proStopCarAttribute 车辆属性
     * @return 车辆属性
     */
    @Override
    public List<ProStopCarAttribute> selectProStopCarAttributeList(ProStopCarAttribute proStopCarAttribute)
    {
        return proStopCarAttributeMapper.selectProStopCarAttributeList(proStopCarAttribute);
    }

    /**
     * 新增车辆属性
     * 
     * @param proStopCarAttribute 车辆属性
     * @return 结果
     */
    @Override
    public int insertProStopCarAttribute(ProStopCarAttribute proStopCarAttribute)
    {
        proStopCarAttribute.setCreateTime(DateUtils.getNowDate());
        proStopCarAttribute.setCreateBy(ShiroUtils.getLoginName());
        return proStopCarAttributeMapper.insertProStopCarAttribute(proStopCarAttribute);
    }

    /**
     * 修改车辆属性
     * 
     * @param proStopCarAttribute 车辆属性
     * @return 结果
     */
    @Override
    public int updateProStopCarAttribute(ProStopCarAttribute proStopCarAttribute)
    {
        proStopCarAttribute.setUpdateTime(DateUtils.getNowDate());
        return proStopCarAttributeMapper.updateProStopCarAttribute(proStopCarAttribute);
    }

    /**
     * 删除车辆属性对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProStopCarAttributeByIds(String ids)
    {
        return proStopCarAttributeMapper.deleteProStopCarAttributeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除车辆属性信息
     * 
     * @param id 车辆属性ID
     * @return 结果
     */
    @Override
    public int deleteProStopCarAttributeById(Long id)
    {
        return proStopCarAttributeMapper.deleteProStopCarAttributeById(id);
    }
}