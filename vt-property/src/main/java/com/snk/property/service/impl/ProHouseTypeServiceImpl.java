package com.snk.property.service.impl;

import java.util.List;
import com.snk.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.snk.property.mapper.ProHouseTypeMapper;
import com.snk.property.domain.ProHouseType;
import com.snk.common.core.text.Convert;

/**
 * 房屋类型Service业务层处理
 * 
 * @author snk
 * @date 2021-10-24
 */
@Service
public class ProHouseTypeServiceImpl implements com.snk.property.service.impl.IProHouseTypeService
{
    @Autowired
    private ProHouseTypeMapper proHouseTypeMapper;

    /**
     * 查询房屋类型
     * 
     * @param id 房屋类型ID
     * @return 房屋类型
     */
    @Override
    public ProHouseType selectProHouseTypeById(Long id)
    {
        return proHouseTypeMapper.selectProHouseTypeById(id);
    }

    /**
     * 查询房屋类型列表
     * 
     * @param proHouseType 房屋类型
     * @return 房屋类型
     */
    @Override
    public List<ProHouseType> selectProHouseTypeList(ProHouseType proHouseType)
    {
        return proHouseTypeMapper.selectProHouseTypeList(proHouseType);
    }

    /**
     * 新增房屋类型
     * 
     * @param proHouseType 房屋类型
     * @return 结果
     */
    @Override
    public int insertProHouseType(ProHouseType proHouseType)
    {
        proHouseType.setCreateTime(DateUtils.getNowDate());
        return proHouseTypeMapper.insertProHouseType(proHouseType);
    }

    /**
     * 修改房屋类型
     * 
     * @param proHouseType 房屋类型
     * @return 结果
     */
    @Override
    public int updateProHouseType(ProHouseType proHouseType)
    {
        return proHouseTypeMapper.updateProHouseType(proHouseType);
    }

    /**
     * 删除房屋类型对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProHouseTypeByIds(String ids)
    {
        return proHouseTypeMapper.deleteProHouseTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除房屋类型信息
     * 
     * @param id 房屋类型ID
     * @return 结果
     */
    @Override
    public int deleteProHouseTypeById(Long id)
    {
        return proHouseTypeMapper.deleteProHouseTypeById(id);
    }
}