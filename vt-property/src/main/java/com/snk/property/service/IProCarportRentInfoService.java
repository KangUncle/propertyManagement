package com.snk.property.service;

import java.util.List;
import com.snk.property.domain.ProCarportRentInfo;

/**
 * 车位出租详情Service接口
 * 
 * @author snk
 * @date 2021-11-02
 */
public interface IProCarportRentInfoService 
{
    /**
     * 查询车位出租详情
     * 
     * @param id 车位出租详情ID
     * @return 车位出租详情
     */
    public ProCarportRentInfo selectProCarportRentInfoById(Long id);

    /**
     * 查询车位出租详情列表
     * 
     * @param proCarportRentInfo 车位出租详情
     * @return 车位出租详情集合
     */
    public List<ProCarportRentInfo> selectProCarportRentInfoList(ProCarportRentInfo proCarportRentInfo);

    /**
     * 新增车位出租详情
     * 
     * @param proCarportRentInfo 车位出租详情
     * @return 结果
     */
    public int insertProCarportRentInfo(ProCarportRentInfo proCarportRentInfo);

    /**
     * 修改车位出租详情
     * 
     * @param proCarportRentInfo 车位出租详情
     * @return 结果
     */
    public int updateProCarportRentInfo(ProCarportRentInfo proCarportRentInfo);

    /**
     * 批量删除车位出租详情
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProCarportRentInfoByIds(String ids);

    /**
     * 删除车位出租详情信息
     * 
     * @param id 车位出租详情ID
     * @return 结果
     */
    public int deleteProCarportRentInfoById(Long id);
}