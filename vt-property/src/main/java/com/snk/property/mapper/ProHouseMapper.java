package com.snk.property.mapper;

import java.util.List;
import com.snk.property.domain.ProHouse;
import com.snk.property.domain.ProHouseMember;

/**
 * 房屋基础信息Mapper接口
 *
 * @author snk
 * @date 2021-10-27
 */
public interface ProHouseMapper
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
     * 删除房屋基础信息
     *
     * @param id 房屋基础信息ID
     * @return 结果
     */
    public int deleteProHouseById(Long id);

    /**
     * 批量删除房屋基础信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProHouseByIds(String[] ids);

    /**
     * 批量删除家庭成员
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProHouseMemberByHouseIds(String[] ids);

    /**
     * 批量新增家庭成员
     *
     * @param proHouseMemberList 家庭成员列表
     * @return 结果
     */
    public int batchProHouseMember(List<ProHouseMember> proHouseMemberList);


    /**
     * 通过房屋基础信息ID删除家庭成员信息
     *
     * @param id 角色ID
     * @return 结果
     */
    public int deleteProHouseMemberByHouseId(Long id);

    /**
     * 条件查询房屋基础信息
     * @param proHouse
     * @return
     */
    ProHouse conditionsTheQuery(ProHouse proHouse);
}