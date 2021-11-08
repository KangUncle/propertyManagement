package com.snk.web.controller.system;

import java.util.Date;
import java.util.List;

import com.snk.framework.util.ShiroUtils;
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
import com.snk.system.domain.SysComplaints;
import com.snk.system.service.ISysComplaintsService;
import com.snk.common.core.controller.BaseController;
import com.snk.common.core.domain.AjaxResult;
import com.snk.common.utils.poi.ExcelUtil;
import com.snk.common.core.page.TableDataInfo;

/**
 * 投诉Controller
 *
 * @author snk
 * @date 2021-11-03
 */
@Controller
@RequestMapping("/system/complaints")
public class SysComplaintsController extends BaseController
{
    private String prefix = "system/complaints";

    @Autowired
    private ISysComplaintsService sysComplaintsService;

    @RequiresPermissions("system:complaints:view")
    @GetMapping()
    public String complaints()
    {
        return prefix + "/list";
    }

    /**
     * 查询投诉列表
     */
    @RequiresPermissions("system:complaints:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysComplaints sysComplaints)
    {
        startPage();
        List<SysComplaints> list = sysComplaintsService.selectSysComplaintsList(sysComplaints);
        return getDataTable(list);
    }

    /**
     * 导出投诉列表
     */
    @RequiresPermissions("system:complaints:export")
    @Log(title = "投诉", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysComplaints sysComplaints)
    {
        List<SysComplaints> list = sysComplaintsService.selectSysComplaintsList(sysComplaints);
        ExcelUtil<SysComplaints> util = new ExcelUtil<SysComplaints>(SysComplaints.class);
        return util.exportExcel(list, "complaints");
    }

    /**
     * 新增投诉
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存投诉
     */
    @RequiresPermissions("system:complaints:add")
    @Log(title = "投诉", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysComplaints sysComplaints)
    {
        return toAjax(sysComplaintsService.insertSysComplaints(sysComplaints));
    }

    /**
     * 修改投诉
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SysComplaints sysComplaints = sysComplaintsService.selectSysComplaintsById(id);
        mmap.put("sysComplaints", sysComplaints);
        return prefix + "/edit";
    }

    /**
     * 修改保存投诉
     */
    @RequiresPermissions("system:complaints:edit")
    @Log(title = "投诉", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysComplaints sysComplaints)
    {
        sysComplaints.setDealTime(new Date());
        sysComplaints.setDealMan(ShiroUtils.getLoginName());
        return toAjax(sysComplaintsService.updateSysComplaints(sysComplaints));
    }

    /**
     * 删除投诉
     */
    @RequiresPermissions("system:complaints:remove")
    @Log(title = "投诉", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysComplaintsService.deleteSysComplaintsByIds(ids));
    }
}