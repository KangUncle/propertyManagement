package com.snk.property.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.snk.common.constant.ProConstants;
import com.snk.common.utils.DateUtils;
import com.snk.property.domain.ProCarInOutInfo;
import com.snk.property.domain.ProStopCarAttribute;
import com.snk.property.mapper.ProStopCarAttributeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.snk.property.mapper.ProStopCarOrderMapper;
import com.snk.property.domain.ProStopCarOrder;
import com.snk.property.service.IProStopCarOrderService;
import com.snk.common.core.text.Convert;

/**
 * 停车订单Service业务层处理
 * 
 * @author snk
 * @date 2021-10-29
 */
@Service
public class ProStopCarOrderServiceImpl implements IProStopCarOrderService 
{
    @Autowired
    private ProStopCarOrderMapper proStopCarOrderMapper;
    @Autowired
    private ProStopCarAttributeMapper stopCarAttributeMapper;

    /**
     * 查询停车订单
     * 
     * @param id 停车订单ID
     * @return 停车订单
     */
    @Override
    public ProStopCarOrder selectProStopCarOrderById(Long id)
    {
        return proStopCarOrderMapper.selectProStopCarOrderById(id);
    }

    /**
     * 查询停车订单列表
     * 
     * @param proStopCarOrder 停车订单
     * @return 停车订单
     */
    @Override
    public List<ProStopCarOrder> selectProStopCarOrderList(ProStopCarOrder proStopCarOrder)
    {
        return proStopCarOrderMapper.selectProStopCarOrderList(proStopCarOrder);
    }

    /**
     * 新增停车订单
     * 
     * @param proStopCarOrder 停车订单
     * @return 结果
     */
    @Override
    public int insertProStopCarOrder(ProStopCarOrder proStopCarOrder)
    {
        proStopCarOrder.setCreateTime(DateUtils.getNowDate());
        return proStopCarOrderMapper.insertProStopCarOrder(proStopCarOrder);
    }

    /**
     * 修改停车订单
     * 
     * @param proStopCarOrder 停车订单
     * @return 结果
     */
    @Override
    public int updateProStopCarOrder(ProStopCarOrder proStopCarOrder)
    {
        return proStopCarOrderMapper.updateProStopCarOrder(proStopCarOrder);
    }

    /**
     * 删除停车订单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProStopCarOrderByIds(String ids)
    {
        return proStopCarOrderMapper.deleteProStopCarOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除停车订单信息
     * 
     * @param id 停车订单ID
     * @return 结果
     */
    @Override
    public int deleteProStopCarOrderById(Long id)
    {
        return proStopCarOrderMapper.deleteProStopCarOrderById(id);
    }

    /**
     * 生成订单并保持
     * @param proCarInOutInfo
     * @return
     */
    public int createOrderInfo(ProCarInOutInfo proCarInOutInfo){

        //构建订单信息
        ProStopCarAttribute proStopCarAttribute = stopCarAttributeMapper.selectProStopCarAttributeById(proCarInOutInfo.getCarAttributeId());
        ProStopCarOrder stopCarOrder=new ProStopCarOrder();
        stopCarOrder.setCarInOutInfoId(proCarInOutInfo.getId());
        stopCarOrder.setOrderState(0L);
        stopCarOrder.setTotalPrice(stopCarTotalPrice(
                proCarInOutInfo.getOutTime(),
                proCarInOutInfo.getOutTime(),
                proStopCarAttribute.getFreeTime(),
                proStopCarAttribute.getTimOutPrice()
        ).add(proStopCarAttribute.getBasisPrice()));
        stopCarOrder.setCreateTime(new Date());
        return proStopCarOrderMapper.insertProStopCarOrder(stopCarOrder);

    }

    /**
     * 计算停车费
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param freeTime  免费停车的时间（分钟）
     * @param unitPrice  单价（分钟）
     * @return
     */
    public static BigDecimal stopCarTotalPrice(Date startTime, Date endTime, Long freeTime, BigDecimal unitPrice){
        Long differenceBetweenTime=endTime.getTime()-startTime.getTime()-freeTime*60*1000;
        if (differenceBetweenTime<=0){
            return new BigDecimal(0);
        }
        return new BigDecimal(Math.ceil(differenceBetweenTime/ ProConstants.STOP_CAR_TIME)).multiply(unitPrice);

    }


}