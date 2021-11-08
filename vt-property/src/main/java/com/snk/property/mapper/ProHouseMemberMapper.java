package com.snk.property.mapper;

import java.util.List;
import com.snk.property.domain.ProHouseMember;

/**
 * 家庭成员Mapper接口
 *
 * @author snk
 * @date 2021-10-27
 */
public interface ProHouseMemberMapper
{
    /**
     * 查询家庭成员
     *
     * @param id 家庭成员ID
     * @return 家庭成员
     */
    public ProHouseMember selectProHouseMemberById(Long id);

    /**
     * 查询家庭成员列表
     *
     * @param proHouseMember 家庭成员
     * @return 家庭成员集合
     */
    public List<ProHouseMember> selectProHouseMemberList(ProHouseMember proHouseMember);

    /**
     * 新增家庭成员
     *
     * @param proHouseMember 家庭成员
     * @return 结果
     */
    public int insertProHouseMember(ProHouseMember proHouseMember);

    /**
     * 修改家庭成员
     *
     * @param proHouseMember 家庭成员
     * @return 结果
     */
    public int updateProHouseMember(ProHouseMember proHouseMember);

    /**
     * 删除家庭成员
     *
     * @param id 家庭成员ID
     * @return 结果
     */
    public int deleteProHouseMemberById(Long id);

    /**
     * 批量删除家庭成员
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProHouseMemberByIds(String[] ids);
}