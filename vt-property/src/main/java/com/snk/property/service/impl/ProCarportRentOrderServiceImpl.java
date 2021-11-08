package com.snk.property.service.impl;

import java.util.List;
import com.snk.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.snk.property.mapper.ProCarportRentOrderMapper;
import com.snk.property.domain.ProCarportRentOrder;
import com.snk.property.service.IProCarportRentOrderService;
import com.snk.common.core.text.Convert;

/**
 * 车位出租订单Service业务层处理
 * 
 * @author snk
 * @date 2021-10-29
 */
@Service
public class ProCarportRentOrderServiceImpl implements IProCarportRentOrderService 
{
    @Autowired
    private ProCarportRentOrderMapper proCarportRentOrderMapper;

    /**
     * 查询车位出租订单
     * 
     * @param id 车位出租订单ID
     * @return 车位出租订单
     */
    @Override
    public ProCarportRentOrder selectProCarportRentOrderById(Long id)
    {
        return proCarportRentOrderMapper.selectProCarportRentOrderById(id);
    }

    /**
     * 查询车位出租订单列表
     * 
     * @param proCarportRentOrder 车位出租订单
     * @return 车位出租订单
     */
    @Override
    public List<ProCarportRentOrder> selectProCarportRentOrderList(ProCarportRentOrder proCarportRentOrder)
    {
        return proCarportRentOrderMapper.selectProCarportRentOrderList(proCarportRentOrder);
    }

    /**
     * 新增车位出租订单
     * 
     * @param proCarportRentOrder 车位出租订单
     * @return 结果
     */
    @Override
    public int insertProCarportRentOrder(ProCarportRentOrder proCarportRentOrder)
    {
        proCarportRentOrder.setCreateTime(DateUtils.getNowDate());
        return proCarportRentOrderMapper.insertProCarportRentOrder(proCarportRentOrder);
    }

    /**
     * 修改车位出租订单
     * 
     * @param proCarportRentOrder 车位出租订单
     * @return 结果
     */
    @Override
    public int updateProCarportRentOrder(ProCarportRentOrder proCarportRentOrder)
    {
        return proCarportRentOrderMapper.updateProCarportRentOrder(proCarportRentOrder);
    }

    /**
     * 删除车位出租订单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProCarportRentOrderByIds(String ids)
    {
        return proCarportRentOrderMapper.deleteProCarportRentOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除车位出租订单信息
     * 
     * @param id 车位出租订单ID
     * @return 结果
     */
    @Override
    public int deleteProCarportRentOrderById(Long id)
    {
        return proCarportRentOrderMapper.deleteProCarportRentOrderById(id);
    }
}