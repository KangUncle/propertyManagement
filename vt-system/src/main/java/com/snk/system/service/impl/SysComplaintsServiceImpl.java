package com.snk.system.service.impl;

import java.util.Date;
import java.util.List;

import com.snk.common.constant.ShiroConstants;
import com.snk.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.snk.system.mapper.SysComplaintsMapper;
import com.snk.system.domain.SysComplaints;
import com.snk.system.service.ISysComplaintsService;
import com.snk.common.core.text.Convert;

/**
 * 投诉Service业务层处理
 *
 * @author snk
 * @date 2021-11-03
 */
@Service
public class SysComplaintsServiceImpl implements ISysComplaintsService
{
    @Autowired
    private SysComplaintsMapper sysComplaintsMapper;

    /**
     * 查询投诉
     *
     * @param id 投诉ID
     * @return 投诉
     */
    @Override
    public SysComplaints selectSysComplaintsById(Long id)
    {
        return sysComplaintsMapper.selectSysComplaintsById(id);
    }

    /**
     * 查询投诉列表
     *
     * @param sysComplaints 投诉
     * @return 投诉
     */
    @Override
    public List<SysComplaints> selectSysComplaintsList(SysComplaints sysComplaints)
    {
        return sysComplaintsMapper.selectSysComplaintsList(sysComplaints);
    }

    /**
     * 新增投诉
     *
     * @param sysComplaints 投诉
     * @return 结果
     */
    @Override
    public int insertSysComplaints(SysComplaints sysComplaints)
    {
        sysComplaints.setCreateTime(DateUtils.getNowDate());
        return sysComplaintsMapper.insertSysComplaints(sysComplaints);
    }

    /**
     * 修改投诉
     *
     * @param sysComplaints 投诉
     * @return 结果
     */
    @Override
    public int updateSysComplaints(SysComplaints sysComplaints)
    {

        return sysComplaintsMapper.updateSysComplaints(sysComplaints);
    }

    /**
     * 删除投诉对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysComplaintsByIds(String ids)
    {
        return sysComplaintsMapper.deleteSysComplaintsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除投诉信息
     *
     * @param id 投诉ID
     * @return 结果
     */
    @Override
    public int deleteSysComplaintsById(Long id)
    {
        return sysComplaintsMapper.deleteSysComplaintsById(id);
    }
}