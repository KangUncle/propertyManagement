package com.snk.property.mapper;

import java.util.List;
import com.snk.property.domain.ProCarportRentInfo;
import com.snk.property.domain.ProHouseCar;

/**
 * 车位出租详情Mapper接口
 * 
 * @author snk
 * @date 2021-10-29
 */
public interface ProCarportRentInfoMapper 
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
     * 删除车位出租详情
     * 
     * @param id 车位出租详情ID
     * @return 结果
     */
    public int deleteProCarportRentInfoById(Long id);

    /**
     * 批量删除车位出租详情
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProCarportRentInfoByIds(String[] ids);

    /**
     * 批量删除车辆入库
     * 
     * @param customerIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteProHouseCarByIds(String[] ids);
    
    /**
     * 批量新增车辆入库
     * 
     * @param proHouseCarList 车辆入库列表
     * @return 结果
     */
    public int batchProHouseCar(List<ProHouseCar> proHouseCarList);
    

    /**
     * 通过车位出租详情ID删除车辆入库信息
     * 
     * @param roleId 角色ID
     * @return 结果
     */
    public int deleteProHouseCarById(Long id);
}