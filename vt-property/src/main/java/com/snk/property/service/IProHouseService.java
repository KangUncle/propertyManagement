package com.snk.property.service;
import java.util.List;
import com.snk.property.domain.ProHouse;

/**
 * 房屋基础信息Service接口
 *
 * @author snk
 * @date 2021-10-27
 */
public interface IProHouseService
{
    /**
     * 查询房屋基础信息
     *
     * @param id 房屋基础信息ID
     * @return 房屋基础信息
     */
    public ProHouse selectProHouseById(Long id);

    /**
     * 查询房屋基础信息列表
     *
     * @param proHouse 房屋基础信息
     * @return 房屋基础信息集合
     */
    public List<ProHouse> selectProHouseList(ProHouse proHouse);

    /**
     * 新增房屋基础信息
     *
     * @param proHouse 房屋基础信息
     * @return 结果
     */
    public int insertProHouse(ProHouse proHouse);

    /**
     * 修改房屋基础信息
     *
     * @param proHouse 房屋基础信息
     * @return 结果
     */
    public int updateProHouse(ProHouse proHouse);

    /**
     * 批量删除房屋基础信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProHouseByIds(String ids);

    /**
     * 删除房屋基础信息信息
     *
     * @param id 房屋基础信息ID
     * @return 结果
     */
    public int deleteProHouseById(Long id);

    /**
     * 条件查询房屋基础信息
     * @param proHouse
     * @return
     */
    ProHouse conditionsTheQuery(ProHouse proHouse);


}