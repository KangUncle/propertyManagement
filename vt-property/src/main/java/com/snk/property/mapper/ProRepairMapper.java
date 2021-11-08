package com.snk.property.mapper;

import java.util.List;
import com.snk.property.domain.ProRepair;

/**
 * 维修Mapper接口
 * 
 * @author snk
 * @date 2021-11-05
 */
public interface ProRepairMapper 
{
    /**
     * 查询维修
     * 
     * @param id 维修ID
     * @return 维修
     */
    public ProRepair selectProRepairById(Long id);

    /**
     * 查询维修列表
     * 
     * @param proRepair 维修
     * @return 维修集合
     */
    public List<ProRepair> selectProRepairList(ProRepair proRepair);

    /**
     * 新增维修
     * 
     * @param proRepair 维修
     * @return 结果
     */
    public int insertProRepair(ProRepair proRepair);

    /**
     * 修改维修
     * 
     * @param proRepair 维修
     * @return 结果
     */
    public int updateProRepair(ProRepair proRepair);

    /**
     * 删除维修
     * 
     * @param id 维修ID
     * @return 结果
     */
    public int deleteProRepairById(Long id);

    /**
     * 批量删除维修
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProRepairByIds(String[] ids);
}