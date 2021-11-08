package com.snk.property.service.impl;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import com.snk.common.core.domain.Ztree;
import com.snk.property.domain.ProHouse;
import com.snk.property.domain.ProHouseMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.snk.property.mapper.ProHouseAddressMapper;
import com.snk.property.domain.ProHouseAddress;
import com.snk.property.service.IProHouseAddressService;
import com.snk.common.core.text.Convert;
import org.springframework.util.ObjectUtils;

/**
 * 楼栋地址Service业务层处理
 *
 * @author snk
 * @date 2021-10-27
 */
@Service
public class ProHouseAddressServiceImpl implements IProHouseAddressService
{
    @Autowired
    private ProHouseAddressMapper proHouseAddressMapper;


    /**
     * 查询楼栋地址
     *
     * @param id 楼栋地址ID
     * @return 楼栋地址
     */
    @Override
    public ProHouseAddress selectProHouseAddressById(Long id)
    {
        return proHouseAddressMapper.selectProHouseAddressById(id);
    }

    /**
     * 查询楼栋地址列表
     *
     * @param proHouseAddress 楼栋地址
     * @return 楼栋地址
     */
    @Override
    public List<ProHouseAddress> selectProHouseAddressList(ProHouseAddress proHouseAddress)
    {
        return proHouseAddressMapper.selectProHouseAddressList(proHouseAddress);
    }

    /**
     * 新增楼栋地址
     *
     * @param proHouseAddress 楼栋地址
     * @return 结果
     */
    @Override
    public int insertProHouseAddress(ProHouseAddress proHouseAddress)
    {
        ProHouseAddress address=proHouseAddressMapper.selectProHouseAddressById(proHouseAddress.getPid());
        if (address.getPid()==0){
            proHouseAddress.setAncestors(address.getPid()+","+address.getId());
            proHouseAddress.setAncestorsName(address.getName());
        }else {
            proHouseAddress.setAncestors(address.getAncestors()+","+proHouseAddress.getPid());
            proHouseAddress.setAncestorsName(address.getAncestorsName()+","+address.getName());
        }
        return proHouseAddressMapper.insertProHouseAddress(proHouseAddress);
    }

    /**
     * 修改楼栋地址
     *
     * @param proHouseAddress 楼栋地址
     * @return 结果
     */
    @Override
    public int updateProHouseAddress(ProHouseAddress proHouseAddress)
    {
        ProHouseAddress address=proHouseAddressMapper.selectProHouseAddressById(proHouseAddress.getPid());
        if (address.getPid()==0){
            proHouseAddress.setAncestors(address.getPid()+","+address.getId());
            proHouseAddress.setAncestorsName(address.getName());
        }else {
            proHouseAddress.setAncestors(address.getAncestors()+","+proHouseAddress.getPid());
            proHouseAddress.setAncestorsName(address.getAncestorsName()+","+address.getName());
        }
        return proHouseAddressMapper.updateProHouseAddress(proHouseAddress);
    }

    /**
     * 删除楼栋地址对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProHouseAddressByIds(String ids)
    {
        return proHouseAddressMapper.deleteProHouseAddressByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除楼栋地址信息
     *
     * @param id 楼栋地址ID
     * @return 结果
     */
    @Override
    public int deleteProHouseAddressById(Long id)
    {
        return proHouseAddressMapper.deleteProHouseAddressById(id);
    }

    /**
     * 查询楼栋地址树列表
     *
     * @return 所有楼栋地址信息
     */
    @Override
    public List<Ztree> selectProHouseAddressTree()
    {
        List<ProHouseAddress> proHouseAddressList = proHouseAddressMapper.selectProHouseAddressList(new ProHouseAddress());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (ProHouseAddress proHouseAddress : proHouseAddressList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(proHouseAddress.getId());
            ztree.setpId(proHouseAddress.getPid());
            ztree.setName(proHouseAddress.getName());
            ztree.setTitle(proHouseAddress.getName());
            ztrees.add(ztree);
        }
        return ztrees;
    }

}