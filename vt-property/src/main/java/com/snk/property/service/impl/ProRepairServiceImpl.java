package com.snk.property.service.impl;

import java.util.Date;
import java.util.List;

import com.snk.common.constant.ProConstants;
import com.snk.common.utils.DateUtils;
import com.snk.framework.util.ShiroUtils;
import com.snk.property.domain.ProHouseAddress;
import com.snk.property.mapper.ProHouseAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.snk.property.mapper.ProRepairMapper;
import com.snk.property.domain.ProRepair;
import com.snk.property.service.IProRepairService;
import com.snk.common.core.text.Convert;

/**
 * 维修Service业务层处理
 * 
 * @author snk
 * @date 2021-11-05
 */
@Service
public class ProRepairServiceImpl implements IProRepairService 
{
    @Autowired
    private ProRepairMapper proRepairMapper;
    @Autowired
    private ProHouseAddressMapper proHouseAddressMapper;

    /**
     * 查询维修
     * 
     * @param id 维修ID
     * @return 维修
     */
    @Override
    public ProRepair selectProRepairById(Long id)
    {
        return proRepairMapper.selectProRepairById(id);
    }

    /**
     * 查询维修列表
     * 
     * @param proRepair 维修
     * @return 维修
     */
    @Override
    public List<ProRepair> selectProRepairList(ProRepair proRepair)
    {
        return proRepairMapper.selectProRepairList(proRepair);
    }

    /**
     * 新增维修
     * 
     * @param proRepair 维修
     * @return 结果
     */
    @Override
    public int insertProRepair(ProRepair proRepair)
    {
        //取出地址
        ProHouseAddress address=proHouseAddressMapper.selectProHouseAddressById(Long.valueOf(proRepair.getRepairAddress()));

        proRepair.setRepairState(ProConstants.REPAIR_STATE_NO);
        proRepair.setCreateBy(ShiroUtils.getLoginName());
        proRepair.setCreateTime(DateUtils.getNowDate());
        proRepair.setRepairAddress(address.getAncestorsName()+","+address.getName());
        return proRepairMapper.insertProRepair(proRepair);
    }

    /**
     * 修改维修
     * 
     * @param proRepair 维修
     * @return 结果
     */
    @Override
    public int updateProRepair(ProRepair proRepair)
    {
        return proRepairMapper.updateProRepair(proRepair);
    }

    /**
     * 删除维修对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProRepairByIds(String ids)
    {
        return proRepairMapper.deleteProRepairByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除维修信息
     * 
     * @param id 维修ID
     * @return 结果
     */
    @Override
    public int deleteProRepairById(Long id)
    {
        return proRepairMapper.deleteProRepairById(id);
    }

    /**
     * 审核项目、保存维修
     * @param proRepair
     * @return
     */
    @Override
    public int auditProRepair(ProRepair proRepair) {
        proRepair.setDealMan(ShiroUtils.getLoginName());
        proRepair.setRepairState(ProConstants.REPAIR_STATE_ING);
        return proRepairMapper.updateProRepair(proRepair);
    }

    /**
     * 完成项目、保存维修
     * @param proRepair
     * @return
     */
    @Override
    public int completeProRepair(ProRepair proRepair) {

        proRepair.setRepairState(ProConstants.REPAIR_STATE_ED);
        proRepair.setServiceTime(new Date());
        return proRepairMapper.updateProRepair(proRepair);
    }
}