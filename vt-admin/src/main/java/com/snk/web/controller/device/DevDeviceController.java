package com.snk.web.controller.device;

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
import com.snk.device.domain.DevDevice;
import com.snk.device.service.IDevDeviceService;
import com.snk.common.core.controller.BaseController;
import com.snk.common.core.domain.AjaxResult;
import com.snk.common.utils.poi.ExcelUtil;
import com.snk.common.core.page.TableDataInfo;

/**
 * 设备信息Controller
 * 
 * @author snk
 * @date 2021-11-04
 */
@Controller
@RequestMapping("/device/device")
public class DevDeviceController extends BaseController
{
    private String prefix = "device/device";

    @Autowired
    private IDevDeviceService devDeviceService;

    @RequiresPermissions("device:device:view")
    @GetMapping()
    public String device()
    {
        return prefix + "/list";
    }

    /**
     * 查询设备信息列表
     */
    @RequiresPermissions("device:device:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DevDevice devDevice)
    {
        startPage();
        List<DevDevice> list = devDeviceService.selectDevDeviceList(devDevice);
        return getDataTable(list);
    }

    /**
     * 导出设备信息列表
     */
    @RequiresPermissions("device:device:export")
    @Log(title = "设备信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DevDevice devDevice)
    {
        List<DevDevice> list = devDeviceService.selectDevDeviceList(devDevice);
        ExcelUtil<DevDevice> util = new ExcelUtil<DevDevice>(DevDevice.class);
        return util.exportExcel(list, "device");
    }

    /**
     * 新增设备信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备信息
     */
    @RequiresPermissions("device:device:add")
    @Log(title = "设备信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DevDevice devDevice)
    {
        devDevice.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(devDeviceService.insertDevDevice(devDevice));
    }

    /**
     * 修改设备信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DevDevice devDevice = devDeviceService.selectDevDeviceById(id);
        mmap.put("devDevice", devDevice);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备信息
     */
    @RequiresPermissions("device:device:edit")
    @Log(title = "设备信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DevDevice devDevice)
    {
        devDevice.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(devDeviceService.updateDevDevice(devDevice));
    }

    /**
     * 删除设备信息
     */
    @RequiresPermissions("device:device:remove")
    @Log(title = "设备信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(devDeviceService.deleteDevDeviceByIds(ids));
    }
}