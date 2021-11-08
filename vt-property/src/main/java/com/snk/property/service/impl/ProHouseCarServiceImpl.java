package com.snk.property.service.impl;

import java.util.List;
import java.util.Random;

import com.snk.common.utils.DateUtils;
import com.snk.common.utils.RandomCreateUtil;
import com.snk.framework.util.ShiroUtils;
import com.snk.property.domain.ProHouse;
import com.snk.property.domain.ProHouseMember;
import com.snk.property.domain.ProStopCarAttribute;
import com.snk.property.mapper.ProHouseMapper;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.snk.property.mapper.ProHouseCarMapper;
import com.snk.property.domain.ProHouseCar;
import com.snk.property.service.IProHouseCarService;
import com.snk.common.core.text.Convert;

/**
 * 车辆入库Service业务层处理
 * 
 * @author snk
 * @date 2021-10-29
 */
@EnableScheduling
@Service
public class ProHouseCarServiceImpl implements IProHouseCarService 
{
    @Autowired
    private ProHouseCarMapper proHouseCarMapper;
    @Autowired
    private ProHouseMapper houseMapper;

    /**
     * 查询车辆入库
     * 
     * @param id 车辆入库ID
     * @return 车辆入库
     */
    @Override
    public ProHouseCar selectProHouseCarById(Long id)
    {
        return proHouseCarMapper.selectProHouseCarById(id);
    }

    /**
     * 查询车辆入库列表
     * 
     * @param proHouseCar 车辆入库
     * @return 车辆入库
     */
    @Override
    public List<ProHouseCar> selectProHouseCarList(ProHouseCar proHouseCar)
    {
        return proHouseCarMapper.selectProHouseCarList(proHouseCar);
    }

    /**
     * 新增车辆入库
     * 
     * @param proHouseCar 车辆入库
     * @return 结果
     */
    @Override
    public int insertProHouseCar(ProHouseCar proHouseCar)
    {
        proHouseCar.setCreateTime(DateUtils.getNowDate());
//        proHouseCar.setCreateBy(ShiroUtils.getLoginName());
        return proHouseCarMapper.insertProHouseCar(proHouseCar);
    }

    /**
     * 修改车辆入库
     * 
     * @param proHouseCar 车辆入库
     * @return 结果
     */
    @Override
    public int updateProHouseCar(ProHouseCar proHouseCar)
    {
        return proHouseCarMapper.updateProHouseCar(proHouseCar);
    }

    /**
     * 删除车辆入库对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProHouseCarByIds(String ids)
    {
        return proHouseCarMapper.deleteProHouseCarByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除车辆入库信息
     * 
     * @param id 车辆入库ID
     * @return 结果
     */
    @Override
    public int deleteProHouseCarById(Long id)
    {
        return proHouseCarMapper.deleteProHouseCarById(id);
    }

    /**
     * selectCarListByCommunityName
     * @param communityId
     * @return
     */
    @Override
    public List<ProHouseCar> selectCarListByCommunityId(Long communityId) {
        return proHouseCarMapper.selectCarListByCommunityId(communityId);
    }

    /**
     * 测试(随机生成模拟数据)
     * 车辆随机入库
     */
//    @Scheduled(cron = "30 32 18 * * ?")
    public void VehiclesIntoTreasury(){

        Random random=new Random();
        List<ProHouse> houseList = houseMapper.selectProHouseList(new ProHouse());

        for (ProHouse house:houseList){
            if (!house.getHouseState().equals(0L)){
                ProHouseCar houseCar=new ProHouseCar();
                Long num=new Long(random.nextInt(5));
                houseCar.setCarAttributeId(num);
                houseCar.setCarNum(RandomCreateUtil.getCar());
                houseCar.setHouseId(house.getId());
                houseCar.setCreateBy("admin");
                insertProHouseCar(houseCar);
            }
        }
    }
}