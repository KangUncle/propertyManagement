package com.snk.system.service;

import java.util.List;
import com.snk.system.domain.SysComplaints;

/**
 * 投诉Service接口
 *
 * @author snk
 * @date 2021-11-03
 */
public interface ISysComplaintsService
{
    /**
     * 查询投诉
     *
     * @param id 投诉ID
     * @return 投诉
     */
    public SysComplaints selectSysComplaintsById(Long id);

    /**
     * 查询投诉列表
     *
     * @param sysComplaints 投诉
     * @return 投诉集合
     */
    public List<SysComplaints> selectSysComplaintsList(SysComplaints sysComplaints);

    /**
     * 新增投诉
     *
     * @param sysComplaints 投诉
     * @return 结果
     */
    public int insertSysComplaints(SysComplaints sysComplaints);

    /**
     * 修改投诉
     *
     * @param sysComplaints 投诉
     * @return 结果
     */
    public int updateSysComplaints(SysComplaints sysComplaints);

    /**
     * 批量删除投诉
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysComplaintsByIds(String ids);

    /**
     * 删除投诉信息
     *
     * @param id 投诉ID
     * @return 结果
     */
    public int deleteSysComplaintsById(Long id);
}