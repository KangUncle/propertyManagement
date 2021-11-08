package com.snk.device.service.impl;

import java.util.List;
import com.snk.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.snk.device.mapper.DevDeviceMapper;
import com.snk.device.domain.DevDevice;
import com.snk.device.service.IDevDeviceService;
import com.snk.common.core.text.Convert;

/**
 * 设备信息Service业务层处理
 * 
 * @author snk
 * @date 2021-11-04
 */
@Service
public class DevDeviceServiceImpl implements IDevDeviceService 
{
    @Autowired
    private DevDeviceMapper devDeviceMapper;

    /**
     * 查询设备信息
     * 
     * @param id 设备信息ID
     * @return 设备信息
     */
    @Override
    public DevDevice selectDevDeviceById(Long id)
    {
        return devDeviceMapper.selectDevDeviceById(id);
    }

    /**
     * 查询设备信息列表
     * 
     * @param devDevice 设备信息
     * @return 设备信息
     */
    @Override
    public List<DevDevice> selectDevDeviceList(DevDevice devDevice)
    {
        return devDeviceMapper.selectDevDeviceList(devDevice);
    }

    /**
     * 新增设备信息
     * 
     * @param devDevice 设备信息
     * @return 结果
     */
    @Override
    public int insertDevDevice(DevDevice devDevice)
    {
        devDevice.setCreateTime(DateUtils.getNowDate());
        return devDeviceMapper.insertDevDevice(devDevice);
    }

    /**
     * 修改设备信息
     * 
     * @param devDevice 设备信息
     * @return 结果
     */
    @Override
    public int updateDevDevice(DevDevice devDevice)
    {
        devDevice.setUpdateTime(DateUtils.getNowDate());
        return devDeviceMapper.updateDevDevice(devDevice);
    }

    /**
     * 删除设备信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDevDeviceByIds(String ids)
    {
        return devDeviceMapper.deleteDevDeviceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备信息信息
     * 
     * @param id 设备信息ID
     * @return 结果
     */
    @Override
    public int deleteDevDeviceById(Long id)
    {
        return devDeviceMapper.deleteDevDeviceById(id);
    }
}