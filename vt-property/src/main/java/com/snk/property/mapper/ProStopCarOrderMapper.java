package com.snk.property.mapper;

import java.util.List;
import com.snk.property.domain.ProStopCarOrder;

/**
 * 停车订单Mapper接口
 * 
 * @author snk
 * @date 2021-10-29
 */
public interface ProStopCarOrderMapper 
{
    /**
     * 查询停车订单
     * 
     * @param id 停车订单ID
     * @return 停车订单
     */
    public ProStopCarOrder selectProStopCarOrderById(Long id);

    /**
     * 查询停车订单列表
     * 
     * @param proStopCarOrder 停车订单
     * @return 停车订单集合
     */
    public List<ProStopCarOrder> selectProStopCarOrderList(ProStopCarOrder proStopCarOrder);

    /**
     * 新增停车订单
     * 
     * @param proStopCarOrder 停车订单
     * @return 结果
     */
    public int insertProStopCarOrder(ProStopCarOrder proStopCarOrder);

    /**
     * 修改停车订单
     * 
     * @param proStopCarOrder 停车订单
     * @return 结果
     */
    public int updateProStopCarOrder(ProStopCarOrder proStopCarOrder);

    /**
     * 删除停车订单
     * 
     * @param id 停车订单ID
     * @return 结果
     */
    public int deleteProStopCarOrderById(Long id);

    /**
     * 批量删除停车订单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProStopCarOrderByIds(String[] ids);
}