package com.snk.web.controller.property;

import java.util.List;

import com.snk.property.domain.ProHouseAddress;
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
import com.snk.property.domain.ProCarportRentInfo;
import com.snk.property.service.IProCarportRentInfoService;
import com.snk.common.core.controller.BaseController;
import com.snk.common.core.domain.AjaxResult;
import com.snk.common.utils.poi.ExcelUtil;
import com.snk.common.core.page.TableDataInfo;

/**
 * 车位出租详情Controller
 * 
 * @author snk
 * @date 2021-11-02
 */
@Controller
@RequestMapping("/property/carRentInfo")
public class ProCarportRentInfoController extends BaseController
{
    private String prefix = "property/carRentInfo";

    @Autowired
    private IProCarportRentInfoService proCarportRentInfoService;
    @Autowired
    private IProHouseAddressService addressService;

    @RequiresPermissions("property:carRentInfo:view")
    @GetMapping()
    public String carRentInfo()
    {
        return prefix + "/list";
    }

    /**
     * 查询车位出租详情列表
     */
    @RequiresPermissions("property:carRentInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProCarportRentInfo proCarportRentInfo)
    {
        startPage();
        List<ProCarportRentInfo> list = proCarportRentInfoService.selectProCarportRentInfoList(proCarportRentInfo);
        return getDataTable(list);
    }

    /**
     * 导出车位出租详情列表
     */
    @RequiresPermissions("property:carRentInfo:export")
    @Log(title = "车位出租详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProCarportRentInfo proCarportRentInfo)
    {
        List<ProCarportRentInfo> list = proCarportRentInfoService.selectProCarportRentInfoList(proCarportRentInfo);
        ExcelUtil<ProCarportRentInfo> util = new ExcelUtil<ProCarportRentInfo>(ProCarportRentInfo.class);
        return util.exportExcel(list, "carRentInfo");
    }

    /**
     * 新增车位出租详情
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        ProHouseAddress address=new ProHouseAddress();
        address.setPid(100L);
        mmap.addAttribute("communityList",addressService.selectProHouseAddressList(address));
        return prefix + "/add";
    }

    /**
     * 新增保存车位出租详情
     */
    @RequiresPermissions("property:carRentInfo:add")
    @Log(title = "车位出租详情", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProCarportRentInfo proCarportRentInfo)
    {
        return toAjax(proCarportRentInfoService.insertProCarportRentInfo(proCarportRentInfo));
    }

    /**
     * 修改车位出租详情
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ProCarportRentInfo proCarportRentInfo = proCarportRentInfoService.selectProCarportRentInfoById(id);
        mmap.put("proCarportRentInfo", proCarportRentInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存车位出租详情
     */
    @RequiresPermissions("property:carRentInfo:edit")
    @Log(title = "车位出租详情", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProCarportRentInfo proCarportRentInfo)
    {
        return toAjax(proCarportRentInfoService.updateProCarportRentInfo(proCarportRentInfo));
    }

    /**
     * 删除车位出租详情
     */
    @RequiresPermissions("property:carRentInfo:remove")
    @Log(title = "车位出租详情", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(proCarportRentInfoService.deleteProCarportRentInfoByIds(ids));
    }
}