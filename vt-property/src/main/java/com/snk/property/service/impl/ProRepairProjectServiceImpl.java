package com.snk.property.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.snk.property.mapper.ProRepairProjectMapper;
import com.snk.property.domain.ProRepairProject;
import com.snk.property.service.IProRepairProjectService;
import com.snk.common.core.text.Convert;

/**
 * 报修项目Service业务层处理
 * 
 * @author snk
 * @date 2021-11-05
 */
@Service
public class ProRepairProjectServiceImpl implements IProRepairProjectService 
{
    @Autowired
    private ProRepairProjectMapper proRepairProjectMapper;

    /**
     * 查询报修项目
     * 
     * @param id 报修项目ID
     * @return 报修项目
     */
    @Override
    public ProRepairProject selectProRepairProjectById(Long id)
    {
        return proRepairProjectMapper.selectProRepairProjectById(id);
    }

    /**
     * 查询报修项目列表
     * 
     * @param proRepairProject 报修项目
     * @return 报修项目
     */
    @Override
    public List<ProRepairProject> selectProRepairProjectList(ProRepairProject proRepairProject)
    {
        return proRepairProjectMapper.selectProRepairProjectList(proRepairProject);
    }

    /**
     * 新增报修项目
     * 
     * @param proRepairProject 报修项目
     * @return 结果
     */
    @Override
    public int insertProRepairProject(ProRepairProject proRepairProject)
    {
        return proRepairProjectMapper.insertProRepairProject(proRepairProject);
    }

    /**
     * 修改报修项目
     * 
     * @param proRepairProject 报修项目
     * @return 结果
     */
    @Override
    public int updateProRepairProject(ProRepairProject proRepairProject)
    {
        return proRepairProjectMapper.updateProRepairProject(proRepairProject);
    }

    /**
     * 删除报修项目对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProRepairProjectByIds(String ids)
    {
        return proRepairProjectMapper.deleteProRepairProjectByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除报修项目信息
     * 
     * @param id 报修项目ID
     * @return 结果
     */
    @Override
    public int deleteProRepairProjectById(Long id)
    {
        return proRepairProjectMapper.deleteProRepairProjectById(id);
    }
}