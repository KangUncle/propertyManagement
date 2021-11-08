package com.snk.web.controller.property;

import java.util.List;

import com.snk.property.domain.ProRepairProject;
import com.snk.property.service.IProRepairProjectService;
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
import com.snk.property.domain.ProRepair;
import com.snk.property.service.IProRepairService;
import com.snk.common.core.controller.BaseController;
import com.snk.common.core.domain.AjaxResult;
import com.snk.common.utils.poi.ExcelUtil;
import com.snk.common.core.page.TableDataInfo;

/**
 * 维修Controller
 * 
 * @author snk
 * @date 2021-11-05
 */
@Controller
@RequestMapping("/property/repair")
public class ProRepairController extends BaseController
{
    private String prefix = "property/repair";

    @Autowired
    private IProRepairService proRepairService;
    @Autowired
    private IProRepairProjectService repairProjectService;

    @RequiresPermissions("property:repair:view")
    @GetMapping()
    public String repair(ModelMap modelMap)
    {
        modelMap.addAttribute("projectList",repairProjectService.selectProRepairProjectList(new ProRepairProject()));
        return prefix + "/list";
    }

    /**
     * 查询维修列表
     */
    @RequiresPermissions("property:repair:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProRepair proRepair)
    {
        startPage();
        List<ProRepair> list = proRepairService.selectProRepairList(proRepair);
        return getDataTable(list);
    }

    /**
     * 导出维修列表
     */
    @RequiresPermissions("property:repair:export")
    @Log(title = "维修", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProRepair proRepair)
    {
        List<ProRepair> list = proRepairService.selectProRepairList(proRepair);
        ExcelUtil<ProRepair> util = new ExcelUtil<ProRepair>(ProRepair.class);
        return util.exportExcel(list, "repair");
    }

    /**
     * 新增维修
     */
    @GetMapping("/add")
    public String add(ModelMap modelMap)
    {
        modelMap.addAttribute("projectList",repairProjectService.selectProRepairProjectList(new ProRepairProject()));
        return prefix + "/add";
    }

    /**
     * 新增保存维修
     */
    @RequiresPermissions("property:repair:add")
    @Log(title = "维修", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProRepair proRepair)
    {
        return toAjax(proRepairService.insertProRepair(proRepair));
    }

    /**
     * 修改维修
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ProRepair proRepair = proRepairService.selectProRepairById(id);
        mmap.addAttribute("proRepair", proRepair);
        mmap.addAttribute("projectList",repairProjectService.selectProRepairProjectList(new ProRepairProject()));
        return prefix + "/edit";
    }

    /**
     * 修改保存维修
     */
    @RequiresPermissions("property:repair:edit")
    @Log(title = "维修", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProRepair proRepair)
    {
        System.out.println(proRepair);
        return toAjax(proRepairService.updateProRepair(proRepair));
    }

    /**
     * 删除维修
     */
    @RequiresPermissions("property:repair:remove")
    @Log(title = "维修", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(proRepairService.deleteProRepairByIds(ids));
    }

    /**
     * 审核项目
     */
    @GetMapping("/audit/{id}")
    public String audit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ProRepair proRepair = proRepairService.selectProRepairById(id);
        mmap.addAttribute("proRepair", proRepair);
        mmap.addAttribute("projectList",repairProjectService.selectProRepairProjectList(new ProRepairProject()));
        return prefix + "/audit";
    }

    /**
     * 审核项目、保存维修
     */
    @RequiresPermissions("property:repair:edit")
    @Log(title = "维修", businessType = BusinessType.UPDATE)
    @PostMapping("/audit")
    @ResponseBody
    public AjaxResult auditSave(ProRepair proRepair)
    {
        return toAjax(proRepairService.auditProRepair(proRepair));
    }

    /**
     * 完成项目
     */
    @GetMapping("/complete/{id}")
    public String complete(@PathVariable("id") Long id, ModelMap mmap)
    {
        ProRepair proRepair = proRepairService.selectProRepairById(id);
        mmap.addAttribute("proRepair", proRepair);
        mmap.addAttribute("projectList",repairProjectService.selectProRepairProjectList(new ProRepairProject()));
        return prefix + "/complete";
    }

    /**
     * 完成项目、保存维修
     */
    @RequiresPermissions("property:repair:edit")
    @Log(title = "维修", businessType = BusinessType.UPDATE)
    @PostMapping("/complete")
    @ResponseBody
    public AjaxResult completeSave(ProRepair proRepair)
    {
        return toAjax(proRepairService.completeProRepair(proRepair));
    }

}