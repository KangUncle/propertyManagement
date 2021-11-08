package com.snk.property.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.snk.common.constant.ProConstants;
import com.snk.common.utils.DateUtils;
import com.snk.framework.util.ShiroUtils;
import com.snk.property.domain.ProHouse;
import com.snk.property.domain.ProHouseAddress;
import com.snk.property.mapper.ProHouseAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.snk.property.mapper.ProHouseOrderMapper;
import com.snk.property.domain.ProHouseOrder;
import com.snk.property.service.IProHouseOrderService;
import com.snk.common.core.text.Convert;

/**
 * 物业订单Service业务层处理
 * 
 * @author snk
 * @date 2021-10-27
 */
@Service
public class ProHouseOrderServiceImpl implements IProHouseOrderService
{
    @Autowired
    private ProHouseOrderMapper proHouseOrderMapper;
    @Autowired
    private ProHouseAddressMapper addressMapper;
    @Autowired
    private ProHouseServiceImpl houseService;


    /**
     * 查询物业订单
     * 
     * @param id 物业订单ID
     * @return 物业订单
     */
    @Override
    public ProHouseOrder selectProHouseOrderById(Long id)
    {
        return proHouseOrderMapper.selectProHouseOrderById(id);
    }

    /**
     * 查询物业订单列表
     * 
     * @param proHouseOrder 物业订单
     * @return 物业订单
     */
    @Override
    public List<ProHouseOrder> selectProHouseOrderList(ProHouseOrder proHouseOrder)
    {
        return proHouseOrderMapper.selectProHouseOrderList(proHouseOrder);
    }

    /**
     * 新增物业订单
     * 
     * @param proHouseOrder 物业订单
     * @return 结果
     */
    @Override
    public int insertProHouseOrder(ProHouseOrder proHouseOrder)
    {
        proHouseOrder.setCreateTime(DateUtils.getNowDate());
        return proHouseOrderMapper.insertProHouseOrder(proHouseOrder);
    }

    /**
     * 修改物业订单
     * 
     * @param proHouseOrder 物业订单
     * @return 结果
     */
    @Override
    public int updateProHouseOrder(ProHouseOrder proHouseOrder)
    {
        proHouseOrder.setReviewMan(ShiroUtils.getLoginName());
        proHouseOrder.setReviewTime(new Date());
        proHouseOrder.setShelfStatus(proHouseOrder.getReviewStatus().equals(ProConstants.HOUSE_ORDER_REVIEW_YES)?ProConstants.HOUSE_ORDER_SHELF_YES:ProConstants.HOUSE_ORDER_SHELF_NO);
        proHouseOrder.setTotalPrice(proHouseOrder.getRealPrice().multiply(proHouseOrder.getDiscount()).divide(new BigDecimal(100)));
        return proHouseOrderMapper.updateProHouseOrder(proHouseOrder);
    }

    /**
     * 删除物业订单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProHouseOrderByIds(String ids)
    {
        return proHouseOrderMapper.deleteProHouseOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除物业订单信息
     * 
     * @param id 物业订单ID
     * @return 结果
     */
    @Override
    public int deleteProHouseOrderById(Long id)
    {
        return proHouseOrderMapper.deleteProHouseOrderById(id);
    }

    /**
     * 初始物业订单（生成指定时间段的订单）
     * @param proHouseOrder
     * @return
     */
    @Override
    public int initializeTheOrder(ProHouseOrder proHouseOrder) {

        ProHouseAddress address=addressMapper.selectProHouseAddressById(proHouseOrder.getHouseAddressId());
        ProHouse proHouse=new ProHouse();
        proHouse.setHouseAddressId(address.getId());
        List<ProHouse> proHouseList=houseService.selectProHouseList(proHouse);
        List<ProHouse> houseList = proHouseList.stream().filter(h -> !h.getHouseState().equals(ProConstants.HOUSE_SALEING) ).collect(Collectors.toList());

        List<ProHouseOrder> orders=new ArrayList<>();
        for (ProHouse house:houseList){
            ProHouseOrder houseOrder = new ProHouseOrder();
            houseOrder.setDiscount(new BigDecimal(100));
            houseOrder.setEndTime(proHouseOrder.getEndTime());
            houseOrder.setHouseAddressId(house.getHouseAddressId());
            houseOrder.setRealPrice(house.getHouseType().getUnitPrice().multiply(house.getHouseType().getArea()));
            houseOrder.setReviewStatus(0L);
            houseOrder.setShelfStatus(0L);
            houseOrder.setStartTime(proHouseOrder.getStartTime());
            houseOrder.setTotalPrice(houseOrder.getRealPrice());
            houseOrder.setCreateTime(DateUtils.getNowDate());
            houseOrder.setCreateBy(ShiroUtils.getLoginName());
            houseOrder.setHouseId(house.getId());
            orders.add(houseOrder);
        }
        proHouseOrderMapper.insertProHouseOrderByList(orders);
//        for (ProHouseOrder houseOrder: orders) {
//            proHouseOrderMapper.insertProHouseOrder(houseOrder);
//        }
        return 200;
    }

    /**
     * 修改物业订单的上/下架
     * @param proHouseOrder
     * @return
     */
    @Override
    public int changeStatusProHouseOrder(ProHouseOrder proHouseOrder) {
        return proHouseOrderMapper.updateProHouseOrder(proHouseOrder);
    }
}