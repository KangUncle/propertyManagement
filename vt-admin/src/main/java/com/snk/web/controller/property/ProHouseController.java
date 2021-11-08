package com.snk.web.controller.property;
import java.util.List;

import com.snk.property.service.impl.ProHouseAddressServiceImpl;
import com.snk.property.service.impl.ProHouseTypeServiceImpl;
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
import com.snk.property.domain.ProHouse;
import com.snk.property.service.IProHouseService;
import com.snk.common.core.controller.BaseController;
import com.snk.common.core.domain.AjaxResult;
import com.snk.common.utils.poi.ExcelUtil;
import com.snk.common.core.page.TableDataInfo;

/**
 * 房屋基础信息Controller
 *
 * @author snk
 * @date 2021-10-27
 */
@Controller
@RequestMapping("/property/house")
public class ProHouseController extends BaseController
{
    private String prefix = "property/house";

    @Autowired
    private IProHouseService proHouseService;
    @Autowired
    private ProHouseAddressServiceImpl addressService;
    @Autowired
    private ProHouseTypeServiceImpl typeService;

    @RequiresPermissions("property:house:view")
    @GetMapping()
    public String house(ModelMap modelMap)
    {
        modelMap.addAttribute("typeList",typeService.selectProHouseTypeList(null));
        modelMap.addAttribute("addressList",addressService.selectProHouseAddressList(null));
        return prefix + "/list";
    }

    /**
     * 查询房屋基础信息列表
     */
    @RequiresPermissions("property:house:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProHouse proHouse)
    {
        startPage();
        List<ProHouse> list = proHouseService.selectProHouseList(proHouse);
        return getDataTable(list);
    }

    /**
     * 导出房屋基础信息列表
     */
    @RequiresPermissions("property:house:export")
    @Log(title = "房屋基础信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProHouse proHouse)
    {
        List<ProHouse> list = proHouseService.selectProHouseList(proHouse);
        ExcelUtil<ProHouse> util = new ExcelUtil<ProHouse>(ProHouse.class);
        return util.exportExcel(list, "house");
    }

    /**
     * 新增房屋基础信息
     */
    @GetMapping("/add")
    public String add(ModelMap modelMap)
    {
        modelMap.put("typeList",typeService.selectProHouseTypeList(null));
        return prefix + "/add";
    }

    /**
     * 新增保存房屋基础信息
     */
    @RequiresPermissions("property:house:add")
    @Log(title = "房屋基础信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProHouse proHouse)
    {
        return toAjax(proHouseService.insertProHouse(proHouse));
    }

    /**
     * 修改房屋基础信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ProHouse proHouse = proHouseService.selectProHouseById(id);
        mmap.addAttribute("proHouse", proHouse);
        mmap.addAttribute("typeList",typeService.selectProHouseTypeList(null));
        return prefix + "/edit";
    }

    /**
     * 修改保存房屋基础信息
     */
    @RequiresPermissions("property:house:edit")
    @Log(title = "房屋基础信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProHouse proHouse)
    {
        return toAjax(proHouseService.updateProHouse(proHouse));
    }

    /**
     * 删除房屋基础信息
     */
    @RequiresPermissions("property:house:remove")
    @Log(title = "房屋基础信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(proHouseService.deleteProHouseByIds(ids));
    }

    /**
     * 条件查询房屋基础信息
     */
    @RequiresPermissions("property:house:list")
    @PostMapping( "/conditionsTheQuery")
    @ResponseBody
    public ProHouse conditionsTheQuery(ProHouse proHouse)
    {
        return proHouseService.conditionsTheQuery(proHouse);
    }

}