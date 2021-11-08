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
import com.snk.property.domain.ProStopCarAttribute;
import com.snk.property.service.IProStopCarAttributeService;
import com.snk.common.core.controller.BaseController;
import com.snk.common.core.domain.AjaxResult;
import com.snk.common.utils.poi.ExcelUtil;
import com.snk.common.core.page.TableDataInfo;

/**
 * 车辆属性Controller
 * 
 * @author snk
 * @date 2021-10-29
 */
@Controller
@RequestMapping("/property/carAttribute")
public class ProStopCarAttributeController extends BaseController
{
    private String prefix = "property/carAttribute";

    @Autowired
    private IProStopCarAttributeService proStopCarAttributeService;

    @RequiresPermissions("property:carAttribute:view")
    @GetMapping()
    public String carAttribute()
    {
        return prefix + "/list";
    }

    /**
     * 查询车辆属性列表
     */
    @RequiresPermissions("property:carAttribute:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProStopCarAttribute proStopCarAttribute)
    {
        startPage();
        List<ProStopCarAttribute> list = proStopCarAttributeService.selectProStopCarAttributeList(proStopCarAttribute);
        return getDataTable(list);
    }

    /**
     * 导出车辆属性列表
     */
    @RequiresPermissions("property:carAttribute:export")
    @Log(title = "车辆属性", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProStopCarAttribute proStopCarAttribute)
    {
        List<ProStopCarAttribute> list = proStopCarAttributeService.selectProStopCarAttributeList(proStopCarAttribute);
        ExcelUtil<ProStopCarAttribute> util = new ExcelUtil<ProStopCarAttribute>(ProStopCarAttribute.class);
        return util.exportExcel(list, "carAttribute");
    }

    /**
     * 新增车辆属性
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存车辆属性
     */
    @RequiresPermissions("property:carAttribute:add")
    @Log(title = "车辆属性", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProStopCarAttribute proStopCarAttribute)
    {
        return toAjax(proStopCarAttributeService.insertProStopCarAttribute(proStopCarAttribute));
    }

    /**
     * 修改车辆属性
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ProStopCarAttribute proStopCarAttribute = proStopCarAttributeService.selectProStopCarAttributeById(id);
        mmap.put("proStopCarAttribute", proStopCarAttribute);
        return prefix + "/edit";
    }

    /**
     * 修改保存车辆属性
     */
    @RequiresPermissions("property:carAttribute:edit")
    @Log(title = "车辆属性", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProStopCarAttribute proStopCarAttribute)
    {
        return toAjax(proStopCarAttributeService.updateProStopCarAttribute(proStopCarAttribute));
    }

    /**
     * 删除车辆属性
     */
    @RequiresPermissions("property:carAttribute:remove")
    @Log(title = "车辆属性", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(proStopCarAttributeService.deleteProStopCarAttributeByIds(ids));
    }
}