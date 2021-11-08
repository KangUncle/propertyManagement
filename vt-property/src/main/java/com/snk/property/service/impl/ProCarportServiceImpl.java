package com.snk.property.service.impl;

import java.util.List;
import com.snk.common.utils.DateUtils;
import com.snk.property.domain.ProHouse;
import com.snk.property.domain.ProHouseMember;
import com.snk.property.mapper.ProHouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.snk.property.mapper.ProCarportMapper;
import com.snk.property.domain.ProCarport;
import com.snk.property.service.IProCarportService;
import com.snk.common.core.text.Convert;

/**
 * 车位详情Service业务层处理
 * 
 * @author snk
 * @date 2021-10-29
 */
@Service
public class ProCarportServiceImpl implements IProCarportService 
{
    @Autowired
    private ProCarportMapper proCarportMapper;
    @Autowired
    private ProHouseMapper proHouseMapper;

    /**
     * 查询车位详情
     * 
     * @param id 车位详情ID
     * @return 车位详情
     */
    @Override
    public ProCarport selectProCarportById(Long id)
    {
        ProCarport carport=proCarportMapper.selectProCarportById(id);
        carport.setProHouse(proHouseMapper.selectProHouseById(carport.getHouseId()));
        return carport;
    }

    /**
     * 查询车位详情列表
     * 
     * @param proCarport 车位详情
     * @return 车位详情
     */
    @Override
    public List<ProCarport> selectProCarportList(ProCarport proCarport)
    {
        return proCarportMapper.selectProCarportList(proCarport);
    }

    /**
     * 新增车位详情
     * 
     * @param proCarport 车位详情
     * @return 结果
     */
    @Override
    public int insertProCarport(ProCarport proCarport)
    {
        proCarport.setCreateTime(DateUtils.getNowDate());
        return proCarportMapper.insertProCarport(proCarport);
    }

    /**
     * 修改车位详情
     * 
     * @param proCarport 车位详情
     * @return 结果
     */
    @Override
    public int updateProCarport(ProCarport proCarport)
    {
        proCarport.setUpdateTime(DateUtils.getNowDate());
        proCarport.setBuyTime(DateUtils.getNowDate());
        return proCarportMapper.updateProCarport(proCarport);
    }

    /**
     * 删除车位详情对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProCarportByIds(String ids)
    {
        return proCarportMapper.deleteProCarportByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除车位详情信息
     * 
     * @param id 车位详情ID
     * @return 结果
     */
    @Override
    public int deleteProCarportById(Long id)
    {
        return proCarportMapper.deleteProCarportById(id);
    }
}