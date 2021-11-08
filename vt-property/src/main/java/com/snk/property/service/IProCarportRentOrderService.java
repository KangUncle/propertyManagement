package com.snk.property.service;

import java.util.List;
import com.snk.property.domain.ProCarportRentOrder;

/**
 * 车位出租订单Service接口
 * 
 * @author snk
 * @date 2021-10-29
 */
public interface IProCarportRentOrderService 
{
    /**
     * 查询车位出租订单
     * 
     * @param id 车位出租订单ID
     * @return 车位出租订单
     */
    public ProCarportRentOrder selectProCarportRentOrderById(Long id);

    /**
     * 查询车位出租订单列表
     * 
     * @param proCarportRentOrder 车位出租订单
     * @return 车位出租订单集合
     */
    public List<ProCarportRentOrder> selectProCarportRentOrderList(ProCarportRentOrder proCarportRentOrder);

    /**
     * 新增车位出租订单
     * 
     * @param proCarportRentOrder 车位出租订单
     * @return 结果
     */
    public int insertProCarportRentOrder(ProCarportRentOrder proCarportRentOrder);

    /**
     * 修改车位出租订单
     * 
     * @param proCarportRentOrder 车位出租订单
     * @return 结果
     */
    public int updateProCarportRentOrder(ProCarportRentOrder proCarportRentOrder);

    /**
     * 批量删除车位出租订单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProCarportRentOrderByIds(String ids);

    /**
     * 删除车位出租订单信息
     * 
     * @param id 车位出租订单ID
     * @return 结果
     */
    public int deleteProCarportRentOrderById(Long id);
}