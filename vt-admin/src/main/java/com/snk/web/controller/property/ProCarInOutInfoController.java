package com.snk.web.controller.property;

import java.util.List;

import com.snk.device.domain.DevDevice;
import com.snk.device.service.IDevDeviceService;
import com.snk.framework.util.ShiroUtils;
import com.snk.property.domain.ProHouseAddress;
import com.snk.property.domain.ProStopCarAttribute;
import com.snk.property.service.IProHouseAddressService;
import com.snk.property.service.IProStopCarAttributeService;
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
import com.snk.property.domain.ProCarInOutInfo;
import com.snk.property.service.IProCarInOutInfoService;
import com.snk.common.core.controller.BaseController;
import com.snk.common.core.domain.AjaxResult;
import com.snk.common.utils.poi.ExcelUtil;
import com.snk.common.core.page.TableDataInfo;

/**
 * 车辆进出详情Controller
 * 
 * @author snk
 * @date 2021-10-29
 */
@Controller
@RequestMapping("/property/carInOutInfo")
public class ProCarInOutInfoController extends BaseController
{
    private String prefix = "property/carInOutInfo";

    @Autowired
    private IProCarInOutInfoService proCarInOutInfoService;
    @Autowired
    private IDevDeviceService devDeviceService;
    @Autowired
    private IProStopCarAttributeService attributeService;

    @RequiresPermissions("property:carInOutInfo:view")
    @GetMapping()
    public String carInOutInfo(ModelMap mmap)
    {
        mmap.addAttribute("attributeList",attributeService.selectProStopCarAttributeList(new ProStopCarAttribute()));
        return prefix + "/list";
    }

    /**
     * 查询车辆进出详情列表
     */
    @RequiresPermissions("property:carInOutInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProCarInOutInfo proCarInOutInfo)
    {
        startPage();
        List<ProCarInOutInfo> list = proCarInOutInfoService.selectProCarInOutInfoList(proCarInOutInfo);
        return getDataTable(list);
    }

    /**
     * 导出车辆进出详情列表
     */
    @RequiresPermissions("property:carInOutInfo:export")
    @Log(title = "车辆进出详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProCarInOutInfo proCarInOutInfo)
    {
        List<ProCarInOutInfo> list = proCarInOutInfoService.selectProCarInOutInfoList(proCarInOutInfo);
        ExcelUtil<ProCarInOutInfo> util = new ExcelUtil<ProCarInOutInfo>(ProCarInOutInfo.class);
        return util.exportExcel(list, "carInOutInfo");
    }

    /**
     * 新增车辆进出详情
     */
    @GetMapping("/add")
    public String add(ModelMap modelMap)
    {
        modelMap.addAttribute("deviceList",devDeviceService.selectDevDeviceList(new DevDevice()));
        return prefix + "/add";
    }

    /**
     * 新增保存车辆进出详情
     */
    @RequiresPermissions("property:carInOutInfo:add")
    @Log(title = "车辆进出详情", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProCarInOutInfo proCarInOutInfo)
    {
        return toAjax(proCarInOutInfoService.insertProCarInOutInfo(proCarInOutInfo));
    }

    /**
     * 修改车辆进出详情
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ProCarInOutInfo proCarInOutInfo = proCarInOutInfoService.selectProCarInOutInfoById(id);
        mmap.addAttribute("proCarInOutInfo", proCarInOutInfo);
        mmap.addAttribute("deviceList",devDeviceService.selectDevDeviceList(new DevDevice()));
        mmap.addAttribute("attributeList",attributeService.selectProStopCarAttributeList(new ProStopCarAttribute()));
        return prefix + "/edit";
    }

    /**
     * 修改保存车辆进出详情
     */
    @RequiresPermissions("property:carInOutInfo:edit")
    @Log(title = "车辆进出详情", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProCarInOutInfo proCarInOutInfo)
    {
        return toAjax(proCarInOutInfoService.updateProCarInOutInfo(proCarInOutInfo));
    }

    /**
     * 删除车辆进出详情
     */
    @RequiresPermissions("property:carInOutInfo:remove")
    @Log(title = "车辆进出详情", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(proCarInOutInfoService.deleteProCarInOutInfoByIds(ids));
    }

    /**
     * 手动入库
     */
    @RequiresPermissions("property:carInOutInfo:add")
    @PostMapping("/manuallyPutInStorage")
    @ResponseBody
    public AjaxResult manuallyPutInStorage(ProCarInOutInfo proCarInOutInfo)
    {
        return toAjax(proCarInOutInfoService.manuallyPutInStorage(proCarInOutInfo));
    }
    /**
     * 手动出库
     */
    @RequiresPermissions("property:carInOutInfo:edit")
    @PostMapping("/manualOutbound")
    @ResponseBody
    public AjaxResult manualOutbound(ProCarInOutInfo proCarInOutInfo)
    {
        proCarInOutInfo.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(proCarInOutInfoService.manualOutbound(proCarInOutInfo));
    }


}