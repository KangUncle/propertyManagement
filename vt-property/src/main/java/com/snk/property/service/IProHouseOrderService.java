package com.snk.property.service;

import java.util.List;
import com.snk.property.domain.ProHouseOrder;

/**
 * 物业订单Service接口
 *
 * @author snk
 * @date 2021-10-27
 */
public interface IProHouseOrderService
{
    /**
     * 查询物业订单
     *
     * @param id 物业订单ID
     * @return 物业订单
     */
    public ProHouseOrder selectProHouseOrderById(Long id);

    /**
     * 查询物业订单列表
     *
     * @param proHouseOrder 物业订单
     * @return 物业订单集合
     */
    public List<ProHouseOrder> selectProHouseOrderList(ProHouseOrder proHouseOrder);

    /**
     * 新增物业订单
     *
     * @param proHouseOrder 物业订单
     * @return 结果
     */
    public int insertProHouseOrder(ProHouseOrder proHouseOrder);

    /**
     * 修改物业订单
     *
     * @param proHouseOrder 物业订单
     * @return 结果
     */
    public int updateProHouseOrder(ProHouseOrder proHouseOrder);

    /**
     * 批量删除物业订单
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProHouseOrderByIds(String ids);

    /**
     * 删除物业订单信息
     *
     * @param id 物业订单ID
     * @return 结果
     */
    public int deleteProHouseOrderById(Long id);

    /**
     *初始物业订单（生成指定时间段的订单）
     * @param proHouseOrder
     * @return
     */
    int initializeTheOrder(ProHouseOrder proHouseOrder);

    /**
     * 修改物业订单的上/下架
     * @param proHouseOrder
     * @return
     */
     public int changeStatusProHouseOrder(ProHouseOrder proHouseOrder);
}