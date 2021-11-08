package com.snk.property.service;

import java.util.List;
import com.snk.property.domain.ProRepairProject;

/**
 * 报修项目Service接口
 * 
 * @author snk
 * @date 2021-11-05
 */
public interface IProRepairProjectService 
{
    /**
     * 查询报修项目
     * 
     * @param id 报修项目ID
     * @return 报修项目
     */
    public ProRepairProject selectProRepairProjectById(Long id);

    /**
     * 查询报修项目列表
     * 
     * @param proRepairProject 报修项目
     * @return 报修项目集合
     */
    public List<ProRepairProject> selectProRepairProjectList(ProRepairProject proRepairProject);

    /**
     * 新增报修项目
     * 
     * @param proRepairProject 报修项目
     * @return 结果
     */
    public int insertProRepairProject(ProRepairProject proRepairProject);

    /**
     * 修改报修项目
     * 
     * @param proRepairProject 报修项目
     * @return 结果
     */
    public int updateProRepairProject(ProRepairProject proRepairProject);

    /**
     * 批量删除报修项目
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProRepairProjectByIds(String ids);

    /**
     * 删除报修项目信息
     * 
     * @param id 报修项目ID
     * @return 结果
     */
    public int deleteProRepairProjectById(Long id);
}