package com.snk.web.controller.property;

import java.util.List;

import io.swagger.annotations.ApiOperation;
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
import com.snk.property.domain.ProHouseAddress;
import com.snk.property.service.IProHouseAddressService;
import com.snk.common.core.controller.BaseController;
import com.snk.common.core.domain.AjaxResult;
import com.snk.common.utils.poi.ExcelUtil;
import com.snk.common.utils.StringUtils;
import com.snk.common.core.domain.Ztree;
/**
 * 楼栋地址Controller
         *
         * @author snk
        * @date 2021-10-27
        */
@Controller
@RequestMapping("/property/houseaddress")
public class ProHouseAddressController extends BaseController
{
    private String prefix = "property/houseaddress";

    @Autowired
    private IProHouseAddressService proHouseAddressService;

    @RequiresPermissions("property:houseaddress:view")
    @GetMapping()
    public String houseaddress()
    {
        return prefix + "/list";
    }

    /**
     * 查询楼栋地址树列表
     */
    @RequiresPermissions("property:houseaddress:list")
    @PostMapping("/list")
    @ResponseBody
    public List<ProHouseAddress> list(ProHouseAddress proHouseAddress)
    {
        List<ProHouseAddress> list = proHouseAddressService.selectProHouseAddressList(proHouseAddress);
        return list;
    }

    /**
     * 导出楼栋地址列表
     */
    @RequiresPermissions("property:houseaddress:export")
    @Log(title = "楼栋地址", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProHouseAddress proHouseAddress)
    {
        List<ProHouseAddress> list = proHouseAddressService.selectProHouseAddressList(proHouseAddress);
        ExcelUtil<ProHouseAddress> util = new ExcelUtil<ProHouseAddress>(ProHouseAddress.class);
        return util.exportExcel(list, "houseaddress");
    }

    /**
     * 新增楼栋地址
     */
    @GetMapping(value = { "/add/{id}", "/add/" })
    public String add(@PathVariable(value = "id", required = false) Long id, ModelMap mmap)
    {
        if (StringUtils.isNotNull(id))
        {
            mmap.put("proHouseAddress", proHouseAddressService.selectProHouseAddressById(id));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存楼栋地址
     */
    @RequiresPermissions("property:houseaddress:add")
    @Log(title = "楼栋地址", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProHouseAddress proHouseAddress)
    {
        return toAjax(proHouseAddressService.insertProHouseAddress(proHouseAddress));
    }

    /**
     * 修改楼栋地址
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ProHouseAddress proHouseAddress = proHouseAddressService.selectProHouseAddressById(id);
        mmap.put("proHouseAddress", proHouseAddress);
        return prefix + "/edit";
    }

    /**
     * 修改保存楼栋地址
     */
    @RequiresPermissions("property:houseaddress:edit")
    @Log(title = "楼栋地址", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProHouseAddress proHouseAddress)
    {
        return toAjax(proHouseAddressService.updateProHouseAddress(proHouseAddress));
    }

    /**
     * 删除
     */
    @RequiresPermissions("property:houseaddress:remove")
    @Log(title = "楼栋地址", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{id}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("id") Long id)
    {
        return toAjax(proHouseAddressService.deleteProHouseAddressById(id));
    }

    /**
     * 选择楼栋地址树
     */
    @GetMapping(value = { "/selectHouseaddressTree/{id}", "/selectHouseaddressTree/" })
    public String selectHouseaddressTree(@PathVariable(value = "id", required = false) Long id, ModelMap mmap)
    {
        if (StringUtils.isNotNull(id))
        {
            mmap.put("houseAddress", proHouseAddressService.selectProHouseAddressById(id));
        }
        return prefix + "/tree";
    }

    /**
     * 加载楼栋地址树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = proHouseAddressService.selectProHouseAddressTree();
        return ztrees;
    }
}