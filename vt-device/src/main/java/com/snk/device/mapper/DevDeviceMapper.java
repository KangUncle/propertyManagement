package com.snk.device.mapper;

import java.util.List;
import com.snk.device.domain.DevDevice;

/**
 * 设备信息Mapper接口
 * 
 * @author snk
 * @date 2021-11-04
 */
public interface DevDeviceMapper 
{
    /**
     * 查询设备信息
     * 
     * @param id 设备信息ID
     * @return 设备信息
     */
    public DevDevice selectDevDeviceById(Long id);

    /**
     * 查询设备信息列表
     * 
     * @param devDevice 设备信息
     * @return 设备信息集合
     */
    public List<DevDevice> selectDevDeviceList(DevDevice devDevice);

    /**
     * 新增设备信息
     * 
     * @param devDevice 设备信息
     * @return 结果
     */
    public int insertDevDevice(DevDevice devDevice);

    /**
     * 修改设备信息
     * 
     * @param devDevice 设备信息
     * @return 结果
     */
    public int updateDevDevice(DevDevice devDevice);

    /**
     * 删除设备信息
     * 
     * @param id 设备信息ID
     * @return 结果
     */
    public int deleteDevDeviceById(Long id);

    /**
     * 批量删除设备信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDevDeviceByIds(String[] ids);
}