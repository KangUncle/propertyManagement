package com.snk.web.controller.property;

import java.util.List;

import com.snk.property.domain.ProHouseAddress;
import com.snk.property.domain.ProHouseMember;
import com.snk.property.service.IProHouseAddressService;
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
import com.snk.property.domain.ProCarport;
import com.snk.property.service.IProCarportService;
import com.snk.common.core.controller.BaseController;
import com.snk.common.core.domain.AjaxResult;
import com.snk.common.utils.poi.ExcelUtil;
import com.snk.common.core.page.TableDataInfo;

/**
 * 车位详情Controller
 * 
 * @author snk
 * @date 2021-10-29
 */
@Controller
@RequestMapping("/property/carCarport")
public class ProCarportController extends BaseController
{
    private String prefix = "property/carCarport";

    @Autowired
    private IProCarportService proCarportService;
    @Autowired
    private IProHouseAddressService addressService;

    @RequiresPermissions("property:carCarport:view")
    @GetMapping()
    public String carCarport(ModelMap mmap)
    {
        //获取小区名
        ProHouseAddress address=new ProHouseAddress();
        address.setPid(100L);
        mmap.addAttribute("communityList",addressService.selectProHouseAddressList(address));
        return prefix + "/list";
    }

    /**
     * 查询车位详情列表
     */
    @RequiresPermissions("property:carCarport:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProCarport proCarport)
    {
        startPage();
        List<ProCarport> list = proCarportService.selectProCarportList(proCarport);
        return getDataTable(list);
    }

    /**
     * 导出车位详情列表
     */
    @RequiresPermissions("property:carCarport:export")
    @Log(title = "车位详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProCarport proCarport)
    {
        List<ProCarport> list = proCarportService.selectProCarportList(proCarport);
        ExcelUtil<ProCarport> util = new ExcelUtil<ProCarport>(ProCarport.class);
        return util.exportExcel(list, "carCarport");
    }

    /**
     * 新增车位详情
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        //获取小区名
        ProHouseAddress address=new ProHouseAddress();
        address.setPid(100L);
        mmap.addAttribute("communityList",addressService.selectProHouseAddressList(address));
        return prefix + "/add";
    }

    /**
     * 新增保存车位详情
     */
    @RequiresPermissions("property:carCarport:add")
    @Log(title = "车位详情", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProCarport proCarport)
    {
        return toAjax(proCarportService.insertProCarport(proCarport));
    }

    /**
     * 修改车位详情
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ProCarport proCarport = proCarportService.selectProCarportById(id);
        mmap.put("proCarport", proCarport);
        return prefix + "/edit";
    }

    /**
     * 修改保存车位详情
     */
    @RequiresPermissions("property:carCarport:edit")
    @Log(title = "车位详情", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProCarport proCarport)
    {
        return toAjax(proCarportService.updateProCarport(proCarport));
    }

    /**
     * 删除车位详情
     */
    @RequiresPermissions("property:carCarport:remove")
    @Log(title = "车位详情", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(proCarportService.deleteProCarportByIds(ids));
    }



}