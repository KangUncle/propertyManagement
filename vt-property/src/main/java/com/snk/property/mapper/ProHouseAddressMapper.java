package com.snk.property.mapper;

import java.util.List;
import com.snk.property.domain.ProHouseAddress;

/**
 * 楼栋地址Mapper接口
 *
 * @author snk
 * @date 2021-10-27
 */
public interface ProHouseAddressMapper
{
    /**
     * 查询楼栋地址
     *
     * @param id 楼栋地址ID
     * @return 楼栋地址
     */
    public ProHouseAddress selectProHouseAddressById(Long id);

    /**
     * 查询楼栋地址列表
     *
     * @param proHouseAddress 楼栋地址
     * @return 楼栋地址集合
     */
    public List<ProHouseAddress> selectProHouseAddressList(ProHouseAddress proHouseAddress);

    /**
     * 新增楼栋地址
     *
     * @param proHouseAddress 楼栋地址
     * @return 结果
     */
    public int insertProHouseAddress(ProHouseAddress proHouseAddress);

    /**
     * 修改楼栋地址
     *
     * @param proHouseAddress 楼栋地址
     * @return 结果
     */
    public int updateProHouseAddress(ProHouseAddress proHouseAddress);

    /**
     * 删除楼栋地址
     *
     * @param id 楼栋地址ID
     * @return 结果
     */
    public int deleteProHouseAddressById(Long id);

    /**
     * 批量删除楼栋地址
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProHouseAddressByIds(String[] ids);

    /**
     * 通过地址id查询他的子孙
     * @param houseAddressId
     * @return
     */
    List<ProHouseAddress> selectProHouseAddressListById(Long houseAddressId);
}