package com.snk.property.mapper;

import java.util.List;
import com.snk.property.domain.ProHouseType;

/**
 * 房屋类型Mapper接口
 * 
 * @author snk
 * @date 2021-10-24
 */
public interface ProHouseTypeMapper 
{
    /**
     * 查询房屋类型
     * 
     * @param id 房屋类型ID
     * @return 房屋类型
     */
    public ProHouseType selectProHouseTypeById(Long id);

    /**
     * 查询房屋类型列表
     * 
     * @param proHouseType 房屋类型
     * @return 房屋类型集合
     */
    public List<ProHouseType> selectProHouseTypeList(ProHouseType proHouseType);

    /**
     * 新增房屋类型
     * 
     * @param proHouseType 房屋类型
     * @return 结果
     */
    public int insertProHouseType(ProHouseType proHouseType);

    /**
     * 修改房屋类型
     * 
     * @param proHouseType 房屋类型
     * @return 结果
     */
    public int updateProHouseType(ProHouseType proHouseType);

    /**
     * 删除房屋类型
     * 
     * @param id 房屋类型ID
     * @return 结果
     */
    public int deleteProHouseTypeById(Long id);

    /**
     * 批量删除房屋类型
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProHouseTypeByIds(String[] ids);
}