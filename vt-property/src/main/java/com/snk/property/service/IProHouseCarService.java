package com.snk.property.service;

import java.util.List;
import com.snk.property.domain.ProHouseCar;

/**
 * 车辆入库Service接口
 * 
 * @author snk
 * @date 2021-10-29
 */
public interface IProHouseCarService 
{
    /**
     * 查询车辆入库
     * 
     * @param id 车辆入库ID
     * @return 车辆入库
     */
    public ProHouseCar selectProHouseCarById(Long id);

    /**
     * 查询车辆入库列表
     * 
     * @param proHouseCar 车辆入库
     * @return 车辆入库集合
     */
    public List<ProHouseCar> selectProHouseCarList(ProHouseCar proHouseCar);

    /**
     * 新增车辆入库
     * 
     * @param proHouseCar 车辆入库
     * @return 结果
     */
    public int insertProHouseCar(ProHouseCar proHouseCar);

    /**
     * 修改车辆入库
     * 
     * @param proHouseCar 车辆入库
     * @return 结果
     */
    public int updateProHouseCar(ProHouseCar proHouseCar);

    /**
     * 批量删除车辆入库
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProHouseCarByIds(String ids);

    /**
     * 删除车辆入库信息
     * 
     * @param id 车辆入库ID
     * @return 结果
     */
    public int deleteProHouseCarById(Long id);

    /**
     * 根据小区的名称查询所属小区的已入库车辆
     * @param communityId
     * @return
     */
    List<ProHouseCar> selectCarListByCommunityId(Long communityId);
}