package com.snk.web.controller.property;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.snk.common.annotation.Log;
import com.snk.common.enums.BusinessType;
import com.snk.property.domain.ProHouseMember;
import com.snk.property.service.IProHouseMemberService;
import com.snk.common.core.controller.BaseController;
import com.snk.common.core.domain.AjaxResult;
import com.snk.common.utils.poi.ExcelUtil;
import com.snk.common.core.page.TableDataInfo;

/**
 * 家庭成员Controller
 * 
 * @author snk
 * @date 2021-10-27
 */
@Controller
@RequestMapping("/property/houseMember")
public class ProHouseMemberController extends BaseController
{
    private String prefix = "property/houseMember";

    @Autowired
    private IProHouseMemberService proHouseMemberService;

    @RequiresPermissions("property:houseMember:view")
    @GetMapping()
    public String houseMember()
    {
        return prefix + "/list";
    }

    /**
     * 查询家庭成员列表
     */
    @RequiresPermissions("property:houseMember:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProHouseMember proHouseMember)
    {
        startPage();
        List<ProHouseMember> list = proHouseMemberService.selectProHouseMemberList(proHouseMember);
        return getDataTable(list);
    }

    /**
     * 导出家庭成员列表
     */
    @RequiresPermissions("property:houseMember:export")
    @Log(title = "家庭成员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProHouseMember proHouseMember)
    {
        List<ProHouseMember> list = proHouseMemberService.selectProHouseMemberList(proHouseMember);
        ExcelUtil<ProHouseMember> util = new ExcelUtil<ProHouseMember>(ProHouseMember.class);
        return util.exportExcel(list, "houseMember");
    }

    /**
     * 新增家庭成员
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存家庭成员
     */
    @RequiresPermissions("property:houseMember:add")
    @Log(title = "家庭成员", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProHouseMember proHouseMember)
    {
        return toAjax(proHouseMemberService.insertProHouseMember(proHouseMember));
    }

    /**
     * 修改家庭成员
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ProHouseMember proHouseMember = proHouseMemberService.selectProHouseMemberById(id);
        mmap.put("proHouseMember", proHouseMember);
        return prefix + "/edit";
    }

    /**
     * 修改保存家庭成员
     */
    @RequiresPermissions("property:houseMember:edit")
    @Log(title = "家庭成员", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProHouseMember proHouseMember)
    {
        return toAjax(proHouseMemberService.updateProHouseMember(proHouseMember));
    }

    /**
     * 删除家庭成员
     */
    @RequiresPermissions("property:houseMember:remove")
    @Log(title = "家庭成员", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(proHouseMemberService.deleteProHouseMemberByIds(ids));
    }
}