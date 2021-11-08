package com.snk.web.controller.property;
import java.util.List;

import com.snk.property.service.impl.IProHouseTypeService;
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
import com.snk.property.domain.ProHouseType;
import com.snk.common.core.controller.BaseController;
import com.snk.common.core.domain.AjaxResult;
import com.snk.common.utils.poi.ExcelUtil;
import com.snk.common.core.page.TableDataInfo;

/**
 * 房屋类型Controller
 * 
 * @author snk
 * @date 2021-10-27
 */
@Controller
@RequestMapping("/property/houseType")
public class ProHouseTypeController extends BaseController
{
    private String prefix = "property/houseType";

    @Autowired
    private IProHouseTypeService proHouseTypeService;

    @RequiresPermissions("property:houseType:view")
    @GetMapping()
    public String houseType()
    {
        return prefix + "/houseType";
    }

    /**
     * 查询房屋类型列表
     */
    @RequiresPermissions("property:houseType:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProHouseType proHouseType)
    {
        startPage();
        List<ProHouseType> list = proHouseTypeService.selectProHouseTypeList(proHouseType);
        return getDataTable(list);
    }

    /**
     * 导出房屋类型列表
     */
    @RequiresPermissions("property:houseType:export")
    @Log(title = "房屋类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProHouseType proHouseType)
    {
        List<ProHouseType> list = proHouseTypeService.selectProHouseTypeList(proHouseType);
        ExcelUtil<ProHouseType> util = new ExcelUtil<ProHouseType>(ProHouseType.class);
        return util.exportExcel(list, "houseType");
    }

    /**
     * 新增房屋类型
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存房屋类型
     */
    @RequiresPermissions("property:houseType:add")
    @Log(title = "房屋类型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProHouseType proHouseType)
    {
        return toAjax(proHouseTypeService.insertProHouseType(proHouseType));
    }

    /**
     * 修改房屋类型
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ProHouseType proHouseType = proHouseTypeService.selectProHouseTypeById(id);
        mmap.put("proHouseType", proHouseType);
        return prefix + "/edit";
    }

    /**
     * 修改保存房屋类型
     */
    @RequiresPermissions("property:houseType:edit")
    @Log(title = "房屋类型", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProHouseType proHouseType)
    {
        return toAjax(proHouseTypeService.updateProHouseType(proHouseType));
    }

    /**
     * 删除房屋类型
     */
    @RequiresPermissions("property:houseType:remove")
    @Log(title = "房屋类型", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(proHouseTypeService.deleteProHouseTypeByIds(ids));
    }
}