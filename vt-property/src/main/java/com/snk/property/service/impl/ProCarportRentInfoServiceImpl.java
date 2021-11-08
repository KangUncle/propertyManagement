package com.snk.property.service.impl;

import java.util.Date;
import java.util.List;

import com.snk.common.constant.ProConstants;
import com.snk.common.utils.DateUtils;
import com.snk.property.domain.*;
import com.snk.property.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.snk.property.service.IProCarportRentInfoService;
import com.snk.common.core.text.Convert;

/**
 * 车位出租详情Service业务层处理
 *
 * @author snk
 * @date 2021-11-02
 */
@Service
public class ProCarportRentInfoServiceImpl implements IProCarportRentInfoService
{
    @Autowired
    private ProCarportRentInfoMapper proCarportRentInfoMapper;
    @Autowired
    private ProCarportMapper carportMapper;
    @Autowired
    private ProHouseCarMapper carMapper;
    @Autowired
    private ProHouseMapper houseMapper;
    @Autowired
    private ProHouseMemberMapper memberMapper;

    /**
     * 查询车位出租详情
     *
     * @param id 车位出租详情ID
     * @return 车位出租详情
     */
    @Override
    public ProCarportRentInfo selectProCarportRentInfoById(Long id)
    {
        return proCarportRentInfoMapper.selectProCarportRentInfoById(id);
    }

    /**
     * 查询车位出租详情列表
     *
     * @param proCarportRentInfo 车位出租详情
     * @return 车位出租详情
     */
    @Override
    public List<ProCarportRentInfo> selectProCarportRentInfoList(ProCarportRentInfo proCarportRentInfo)
    {
        return proCarportRentInfoMapper.selectProCarportRentInfoList(proCarportRentInfo);
    }

    /**
     * 新增车位出租详情
     *
     * @param proCarportRentInfo 车位出租详情
     * @return 结果
     */
    @Override
    public int insertProCarportRentInfo(ProCarportRentInfo proCarportRentInfo)
    {
        //查询家庭详情
        Long houseId=new Long(proCarportRentInfo.getHouseAddress());
        ProHouse house=houseMapper.selectProHouseById(houseId);
        //查询成员详情
        Long memberId=new Long(proCarportRentInfo.getMemberName());
        ProHouseMember member=memberMapper.selectProHouseMemberById(memberId);

        //查询车位，并核实、修改状态
        Long carportId=new Long(proCarportRentInfo.getCarportNum());
        ProCarport carport=carportMapper.selectProCarportById(carportId);
        if (!ProConstants.CARPORT_STATE_RENTED.equals(carport.getState())){
            carport.setState(ProConstants.CARPORT_STATE_RENTED);
            carport.setBuyTime(new Date());
            carport.setMemberId(memberId);
            carport.setHouseId(houseId);
            carportMapper.updateProCarport(carport);
        }
        //查询入库车辆，并核实状态
        Long carId=new Long(proCarportRentInfo.getHouseCarNum());
        ProHouseCar houseCar=carMapper.selectProHouseCarById(carId);
        if (!ProConstants.HOUSE_CAR_HAVE.equals(houseCar.getCarAttributeId())){
            houseCar.setCarAttributeId(ProConstants.HOUSE_CAR_HAVE);
            carMapper.updateProHouseCar(houseCar);
        }

        proCarportRentInfo.setCreateTime(DateUtils.getNowDate());
        proCarportRentInfo.setCarportNum(carport.getCarportNum());
        proCarportRentInfo.setTotalPrice(carport.getPrice());
        proCarportRentInfo.setHouseCarNum(houseCar.getCarNum());
        proCarportRentInfo.setHouseAddress(house.getHouseAddressName());
        proCarportRentInfo.setMemberName(member.getName());
        return proCarportRentInfoMapper.insertProCarportRentInfo(proCarportRentInfo);
    }

    /**
     * 修改车位出租详情
     *
     * @param proCarportRentInfo 车位出租详情
     * @return 结果
     */
    @Override
    public int updateProCarportRentInfo(ProCarportRentInfo proCarportRentInfo)
    {
        return proCarportRentInfoMapper.updateProCarportRentInfo(proCarportRentInfo);
    }

    /**
     * 删除车位出租详情对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProCarportRentInfoByIds(String ids)
    {
        return proCarportRentInfoMapper.deleteProCarportRentInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除车位出租详情信息
     *
     * @param id 车位出租详情ID
     * @return 结果
     */
    @Override
    public int deleteProCarportRentInfoById(Long id)
    {
        return proCarportRentInfoMapper.deleteProCarportRentInfoById(id);
    }
}