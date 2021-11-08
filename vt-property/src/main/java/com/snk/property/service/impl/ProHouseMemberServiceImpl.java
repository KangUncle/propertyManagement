package com.snk.property.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.snk.property.mapper.ProHouseMemberMapper;
import com.snk.property.domain.ProHouseMember;
import com.snk.property.service.IProHouseMemberService;
import com.snk.common.core.text.Convert;

/**
 * 家庭成员Service业务层处理
 *
 * @author snk
 * @date 2021-10-27
 */
@Service
public class ProHouseMemberServiceImpl implements IProHouseMemberService
{
    @Autowired
    private ProHouseMemberMapper proHouseMemberMapper;

    /**
     * 查询家庭成员
     *
     * @param id 家庭成员ID
     * @return 家庭成员
     */
    @Override
    public ProHouseMember selectProHouseMemberById(Long id)
    {
        return proHouseMemberMapper.selectProHouseMemberById(id);
    }

    /**
     * 查询家庭成员列表
     *
     * @param proHouseMember 家庭成员
     * @return 家庭成员
     */
    @Override
    public List<ProHouseMember> selectProHouseMemberList(ProHouseMember proHouseMember)
    {
        return proHouseMemberMapper.selectProHouseMemberList(proHouseMember);
    }

    /**
     * 新增家庭成员
     *
     * @param proHouseMember 家庭成员
     * @return 结果
     */
    @Override
    public int insertProHouseMember(ProHouseMember proHouseMember)
    {
        return proHouseMemberMapper.insertProHouseMember(proHouseMember);
    }

    /**
     * 修改家庭成员
     *
     * @param proHouseMember 家庭成员
     * @return 结果
     */
    @Override
    public int updateProHouseMember(ProHouseMember proHouseMember)
    {
        return proHouseMemberMapper.updateProHouseMember(proHouseMember);
    }

    /**
     * 删除家庭成员对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProHouseMemberByIds(String ids)
    {
        return proHouseMemberMapper.deleteProHouseMemberByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除家庭成员信息
     *
     * @param id 家庭成员ID
     * @return 结果
     */
    @Override
    public int deleteProHouseMemberById(Long id)
    {
        return proHouseMemberMapper.deleteProHouseMemberById(id);
    }
}