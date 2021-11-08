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
import com.snk.property.domain.ProRepairProject;
import com.snk.property.service.IProRepairProjectService;
import com.snk.common.core.controller.BaseController;
import com.snk.common.core.domain.AjaxResult;
import com.snk.common.utils.poi.ExcelUtil;
import com.snk.common.core.page.TableDataInfo;

/**
 * 报修项目Controller
 * 
 * @author snk
 * @date 2021-11-05
 */
@Controller
@RequestMapping("/property/repairProject")
public class ProRepairProjectController extends BaseController
{
    private String prefix = "property/repairProject";

    @Autowired
    private IProRepairProjectService proRepairProjectService;

    @RequiresPermissions("property:repairProject:view")
    @GetMapping()
    public String repairProject()
    {
        return prefix + "/list";
    }

    /**
     * 查询报修项目列表
     */
    @RequiresPermissions("property:repairProject:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProRepairProject proRepairProject)
    {
        startPage();
        List<ProRepairProject> list = proRepairProjectService.selectProRepairProjectList(proRepairProject);
        return getDataTable(list);
    }

    /**
     * 导出报修项目列表
     */
    @RequiresPermissions("property:repairProject:export")
    @Log(title = "报修项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProRepairProject proRepairProject)
    {
        List<ProRepairProject> list = proRepairProjectService.selectProRepairProjectList(proRepairProject);
        ExcelUtil<ProRepairProject> util = new ExcelUtil<ProRepairProject>(ProRepairProject.class);
        return util.exportExcel(list, "repairProject");
    }

    /**
     * 新增报修项目
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存报修项目
     */
    @RequiresPermissions("property:repairProject:add")
    @Log(title = "报修项目", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProRepairProject proRepairProject)
    {
        return toAjax(proRepairProjectService.insertProRepairProject(proRepairProject));
    }

    /**
     * 修改报修项目
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ProRepairProject proRepairProject = proRepairProjectService.selectProRepairProjectById(id);
        mmap.put("proRepairProject", proRepairProject);
        return prefix + "/edit";
    }

    /**
     * 修改保存报修项目
     */
    @RequiresPermissions("property:repairProject:edit")
    @Log(title = "报修项目", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProRepairProject proRepairProject)
    {
        return toAjax(proRepairProjectService.updateProRepairProject(proRepairProject));
    }

    /**
     * 删除报修项目
     */
    @RequiresPermissions("property:repairProject:remove")
    @Log(title = "报修项目", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(proRepairProjectService.deleteProRepairProjectByIds(ids));
    }
}