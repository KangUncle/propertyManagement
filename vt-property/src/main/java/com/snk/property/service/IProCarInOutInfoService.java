package com.snk.property.service;

import java.util.List;
import com.snk.property.domain.ProCarInOutInfo;

/**
 * 车辆进出详情Service接口
 * 
 * @author snk
 * @date 2021-10-29
 */
public interface IProCarInOutInfoService 
{
    /**
     * 查询车辆进出详情
     * 
     * @param id 车辆进出详情ID
     * @return 车辆进出详情
     */
    public ProCarInOutInfo selectProCarInOutInfoById(Long id);

    /**
     * 查询车辆进出详情列表
     * 
     * @param proCarInOutInfo 车辆进出详情
     * @return 车辆进出详情集合
     */
    public List<ProCarInOutInfo> selectProCarInOutInfoList(ProCarInOutInfo proCarInOutInfo);

    /**
     * 新增车辆进出详情
     * 
     * @param proCarInOutInfo 车辆进出详情
     * @return 结果
     */
    public int insertProCarInOutInfo(ProCarInOutInfo proCarInOutInfo);

    /**
     * 修改车辆进出详情
     * 
     * @param proCarInOutInfo 车辆进出详情
     * @return 结果
     */
    public int updateProCarInOutInfo(ProCarInOutInfo proCarInOutInfo);

    /**
     * 批量删除车辆进出详情
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProCarInOutInfoByIds(String ids);

    /**
     * 删除车辆进出详情信息
     * 
     * @param id 车辆进出详情ID
     * @return 结果
     */
    public int deleteProCarInOutInfoById(Long id);

    /**
     * 手动入库
     * @param proCarInOutInfo
     * @return
     */
    public int manuallyPutInStorage(ProCarInOutInfo proCarInOutInfo);

    /**
     * 手动出库
     * @param proCarInOutInfo
     * @return
     */
    public int manualOutbound(ProCarInOutInfo proCarInOutInfo);
}