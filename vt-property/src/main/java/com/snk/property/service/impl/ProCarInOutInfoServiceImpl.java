package com.snk.property.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.snk.common.constant.ProConstants;
import com.snk.device.domain.DevDevice;
import com.snk.device.mapper.DevDeviceMapper;
import com.snk.framework.util.ShiroUtils;
import com.snk.property.domain.ProHouseCar;
import com.snk.property.domain.ProStopCarAttribute;
import com.snk.property.domain.ProStopCarOrder;
import com.snk.property.mapper.ProHouseCarMapper;
import com.snk.property.mapper.ProStopCarAttributeMapper;
import com.snk.property.mapper.ProStopCarOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.snk.property.mapper.ProCarInOutInfoMapper;
import com.snk.property.domain.ProCarInOutInfo;
import com.snk.property.service.IProCarInOutInfoService;
import com.snk.common.core.text.Convert;
import org.springframework.util.ObjectUtils;

/**
 * 车辆进出详情Service业务层处理
 * 
 * @author snk
 * @date 2021-10-29
 */
@Service
public class ProCarInOutInfoServiceImpl implements IProCarInOutInfoService 
{
    @Autowired
    private ProCarInOutInfoMapper proCarInOutInfoMapper;
    @Autowired
    private ProHouseCarMapper houseCarMapper;
    @Autowired
    private ProStopCarOrderServiceImpl stopCarOrderService;
    @Autowired
    private ProStopCarAttributeMapper attributeMapper;
    @Autowired
    private DevDeviceMapper deviceMapper;


    /**
     * 查询车辆进出详情
     * 
     * @param id 车辆进出详情ID
     * @return 车辆进出详情
     */
    @Override
    public ProCarInOutInfo selectProCarInOutInfoById(Long id)
    {
        return proCarInOutInfoMapper.selectProCarInOutInfoById(id);
    }

    /**
     * 查询车辆进出详情列表
     * 
     * @param proCarInOutInfo 车辆进出详情
     * @return 车辆进出详情
     */
    @Override
    public List<ProCarInOutInfo> selectProCarInOutInfoList(ProCarInOutInfo proCarInOutInfo)
    {
        List<DevDevice> deviceList=deviceMapper.selectDevDeviceList(new DevDevice());
        List<ProStopCarAttribute> attributeList=attributeMapper.selectProStopCarAttributeList(new ProStopCarAttribute());
        List<ProCarInOutInfo> carInOutInfoList=proCarInOutInfoMapper.selectProCarInOutInfoList(proCarInOutInfo);
        for (ProCarInOutInfo carInOutInfo:carInOutInfoList){
            //添加入库设备名称
            if (!ObjectUtils.isEmpty(carInOutInfo.getIntoDeviceId())){
                String name = deviceList.stream().filter(d -> !carInOutInfo.getIntoDeviceId().equals(d.getId())).findAny().orElse(null).getName();
                carInOutInfo.setIntoDeviceName(name);
            }
            //添加出库设备名称
            if (!ObjectUtils.isEmpty(carInOutInfo.getOutDeviceId())){
                String name = deviceList.stream().filter(d -> !carInOutInfo.getOutDeviceId().equals(d.getId())).findAny().orElse(null).getName();
                carInOutInfo.setOutDeviceName(name);
            }
            //添加属性名称
            if (!ObjectUtils.isEmpty(carInOutInfo.getCarAttributeId())){
                String title = attributeList.stream().filter(a -> !carInOutInfo.getCarAttributeId().equals(a.getId())).findAny().orElse(null).getTitle();
                carInOutInfo.setCarAttributeTitle(title);
            }
        }
        return carInOutInfoList;
    }

    /**
     * 新增车辆进出详情
     * 
     * @param proCarInOutInfo 车辆进出详情
     * @return 结果
     */
    @Override
    public int insertProCarInOutInfo(ProCarInOutInfo proCarInOutInfo)
    {
        proCarInOutInfo.setIntoTime(new Date());
        return proCarInOutInfoMapper.insertProCarInOutInfo(proCarInOutInfo);
    }

    /**
     * 修改车辆进出详情
     * 
     * @param proCarInOutInfo 车辆进出详情
     * @return 结果
     */
    @Override
    public int updateProCarInOutInfo(ProCarInOutInfo proCarInOutInfo)
    {
        proCarInOutInfo.setUpdateTime(new Date());
        return proCarInOutInfoMapper.updateProCarInOutInfo(proCarInOutInfo);
    }

    /**
     * 删除车辆进出详情对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProCarInOutInfoByIds(String ids)
    {
        return proCarInOutInfoMapper.deleteProCarInOutInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除车辆进出详情信息
     * 
     * @param id 车辆进出详情ID
     * @return 结果
     */
    @Override
    public int deleteProCarInOutInfoById(Long id)
    {
        return proCarInOutInfoMapper.deleteProCarInOutInfoById(id);
    }

    /**
     * 手动入库
     * @param proCarInOutInfo
     * @return
     */
    @Override
    public int manuallyPutInStorage(ProCarInOutInfo proCarInOutInfo) {

        List<ProHouseCar> houseCarList = houseCarMapper.selectProHouseCarList(new ProHouseCar()); //项目上线可以存在redis中（调用比较频繁）
        ProHouseCar houseCar = houseCarList.stream().filter(h -> proCarInOutInfo.getCarNum().equals(h.getCarNum())).findAny().orElse(null);
        proCarInOutInfo.setCarAttributeId(ObjectUtils.isEmpty(houseCar)? ProConstants.PRO_STOP_CAR_ATTRIBUTE_ID :houseCar.getCarAttributeId());

        proCarInOutInfo.setCreateTime(new Date());
        proCarInOutInfo.setIntoTime(new Date());
        return proCarInOutInfoMapper.insertProCarInOutInfo(proCarInOutInfo);
    }

    /**
     * 手动出库
     * @param proCarInOutInfo
     * @return
     */
    @Override
    public int manualOutbound(ProCarInOutInfo proCarInOutInfo) {
        proCarInOutInfo.setUpdateTime(new Date());
        proCarInOutInfo.setOutTime(new Date());
        //生成停车订单
        stopCarOrderService.createOrderInfo(proCarInOutInfo);
        return proCarInOutInfoMapper.updateProCarInOutInfo(proCarInOutInfo);
    }


    /**
     * 自动入库
     * @param carNum
     * @param deviceId
     * @param img
     */
    public void automaticWarehous(String carNum,Long deviceId,String img){
        ProCarInOutInfo carInOutInfo=new ProCarInOutInfo();
        carInOutInfo.setIntoTime(new Date());
        carInOutInfo.setCreateTime(new Date());
        carInOutInfo.setIntoCarImage(img);
        carInOutInfo.setCarNum(carNum);
        carInOutInfo.setCreateBy("系统自动操作");
        carInOutInfo.setIntoDeviceId(deviceId);
        List<ProHouseCar> houseCarList = houseCarMapper.selectProHouseCarList(new ProHouseCar()); //项目上线可以存在redis中（调用比较频繁）
        ProHouseCar houseCar = houseCarList.stream().filter(h -> carNum.equals(h.getCarNum())).findAny().orElse(null);
        carInOutInfo.setCarAttributeId(ObjectUtils.isEmpty(houseCar)? ProConstants.PRO_STOP_CAR_ATTRIBUTE_ID :houseCar.getCarAttributeId());
        proCarInOutInfoMapper.insertProCarInOutInfo(carInOutInfo);
    }

    /**
     * 自动出库
     * @param carNum
     * @param deviceId
     * @param img
     */
    public void automatedOutbound(String carNum,Long deviceId,String img){
        ProCarInOutInfo proCarInOutInfo=proCarInOutInfoMapper.getOutboundCarByCarNum(carNum);

        proCarInOutInfo.setUpdateTime(new Date());
        proCarInOutInfo.setOutTime(new Date());
        proCarInOutInfo.setUpdateBy("系统自动操作");
        proCarInOutInfo.setIntoDeviceId(deviceId);
        proCarInOutInfo.setIntoCarImage(img);

        //生成停车订单
        stopCarOrderService.createOrderInfo(proCarInOutInfo);
        proCarInOutInfoMapper.updateProCarInOutInfo(proCarInOutInfo);

    }


}