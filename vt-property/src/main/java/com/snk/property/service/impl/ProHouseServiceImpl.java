package com.snk.property.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.snk.common.utils.DateUtils;
import com.snk.common.utils.RandomCreateUtil;
import com.snk.framework.util.ShiroUtils;
import com.snk.property.domain.ProHouseAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.snk.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.snk.property.domain.ProHouseMember;
import com.snk.property.mapper.ProHouseMapper;
import com.snk.property.domain.ProHouse;
import com.snk.property.service.IProHouseService;
import com.snk.common.core.text.Convert;

/**
 * 房屋基础信息Service业务层处理
 *
 * @author snk
 * @date 2021-10-27
 */
@EnableScheduling
@Service
public class ProHouseServiceImpl implements IProHouseService
{
    @Autowired
    private ProHouseMapper proHouseMapper;
    @Autowired
    private ProHouseAddressServiceImpl addressService;

    /**
     * 查询房屋基础信息
     *
     * @param id 房屋基础信息ID
     * @return 房屋基础信息
     */
    @Override
    public ProHouse selectProHouseById(Long id)
    {
        return proHouseMapper.selectProHouseById(id);
    }

    /**
     * 查询房屋基础信息列表
     *
     * @param proHouse 房屋基础信息
     * @return 房屋基础信息
     */
    @Override
    public List<ProHouse> selectProHouseList(ProHouse proHouse)
    {
        return proHouseMapper.selectProHouseList(proHouse);
    }

    /**
     * 新增房屋基础信息
     *
     * @param proHouse 房屋基础信息
     * @return 结果
     */
    @Transactional
    @Override
    public int insertProHouse(ProHouse proHouse)
    {
//        proHouse.setCreateBy(ShiroUtils.getLoginName());
        proHouse.setCreaterTime(new Date());
        ProHouseAddress address=addressService.selectProHouseAddressById(proHouse.getHouseAddressId());
        proHouse.setHouseAddressName(address.getAncestorsName()+","+address.getName());
        int rows = proHouseMapper.insertProHouse(proHouse);
        insertProHouseMember(proHouse);
        return rows;
    }

    /**
     * 修改房屋基础信息
     *
     * @param proHouse 房屋基础信息
     * @return 结果
     */
    @Transactional
    @Override
    public int updateProHouse(ProHouse proHouse)
    {
        proHouse.setUpdateBy(ShiroUtils.getLoginName());
        ProHouseAddress address=addressService.selectProHouseAddressById(proHouse.getHouseAddressId());
        proHouse.setHouseAddressName(address.getAncestorsName()+","+address.getName());
        proHouse.setUpdateTime(DateUtils.getNowDate());
        proHouseMapper.deleteProHouseMemberByHouseId(proHouse.getId());
        insertProHouseMember(proHouse);
        return proHouseMapper.updateProHouse(proHouse);
    }

    /**
     * 删除房屋基础信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteProHouseByIds(String ids)
    {
        proHouseMapper.deleteProHouseMemberByHouseIds(Convert.toStrArray(ids));
        return proHouseMapper.deleteProHouseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除房屋基础信息信息
     *
     * @param id 房屋基础信息ID
     * @return 结果
     */
    @Override
    public int deleteProHouseById(Long id)
    {
        proHouseMapper.deleteProHouseMemberByHouseId(id);
        return proHouseMapper.deleteProHouseById(id);
    }

    /**
     * 条件查询房屋基础信息
     * @param proHouse
     * @return
     */
    @Override
    public ProHouse conditionsTheQuery(ProHouse proHouse) {

        return proHouseMapper.conditionsTheQuery(proHouse);
    }

    /**
     * 新增家庭成员信息
     *
     * @param proHouse 房屋基础信息对象
     */
    public void insertProHouseMember(ProHouse proHouse)
    {
        List<ProHouseMember> proHouseMemberList = proHouse.getProHouseMemberList();
        Long id = proHouse.getId();
        if (StringUtils.isNotNull(proHouseMemberList))
        {
            List<ProHouseMember> list = new ArrayList<ProHouseMember>();
            for (ProHouseMember proHouseMember : proHouseMemberList)
            {
                proHouseMember.setHouseAddressId(proHouse.getHouseAddressId());
                proHouseMember.setCreatTime(new Date());
                proHouseMember.setHouseId(id);
                list.add(proHouseMember);
            }
            if (list.size() > 0)
            {
                proHouseMapper.batchProHouseMember(list);
            }
        }
    }

    /**
     * 随机生成房屋数据
     */
//    @Scheduled(cron = "30 18 18 * * *")
    public void aa(){
        Random random=new Random();
        List<ProHouseAddress> addressList=addressService.selectProHouseAddressList(new ProHouseAddress());
        List<ProHouseAddress> proHouseAddressList = addressList.stream().filter(a -> a.getId() > 129).collect(Collectors.toList());
        for (ProHouseAddress address:proHouseAddressList) {
            ProHouse house=new ProHouse();
            house.setHouseAddressId(address.getId());
            if (address.getId()>141){
                house.setHouseTypeId(random.nextInt(4)+4L);
            }else {
                house.setHouseTypeId(random.nextInt(3)+1L);
            }
            Long sate=new Long(random.nextInt(3));
            if (sate.equals(0L)){
                house.setHouseState(sate);
                insertProHouse(house);
            }else {
                house.setHouseState(sate);
                house.setBuyTime(new Date());
                house.setOwerMobile(RandomCreateUtil.getTel());//随机生成电话
                house.setOwerName(RandomCreateUtil.getName(true,3));//随机生成姓名
                insertProHouse(house);
            }
        }
    }


 }