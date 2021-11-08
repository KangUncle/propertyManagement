package com.snk.property.service;

import java.util.List;
import com.snk.property.domain.ProCarport;

/**
 * 车位详情Service接口
 * 
 * @author snk
 * @date 2021-10-29
 */
public interface IProCarportService 
{
    /**
     * 查询车位详情
     * 
     * @param id 车位详情ID
     * @return 车位详情
     */
    public ProCarport selectProCarportById(Long id);

    /**
     * 查询车位详情列表
     * 
     * @param proCarport 车位详情
     * @return 车位详情集合
     */
    public List<ProCarport> selectProCarportList(ProCarport proCarport);

    /**
     * 新增车位详情
     * 
     * @param proCarport 车位详情
     * @return 结果
     */
    public int insertProCarport(ProCarport proCarport);

    /**
     * 修改车位详情
     * 
     * @param proCarport 车位详情
     * @return 结果
     */
    public int updateProCarport(ProCarport proCarport);

    /**
     * 批量删除车位详情
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProCarportByIds(String ids);

    /**
     * 删除车位详情信息
     * 
     * @param id 车位详情ID
     * @return 结果
     */
    public int deleteProCarportById(Long id);
}