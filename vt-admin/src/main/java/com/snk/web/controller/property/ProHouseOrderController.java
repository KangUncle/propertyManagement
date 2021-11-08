package com.snk.web.controller.property;

import java.util.List;

import com.snk.property.domain.ProHouseAddress;
import com.snk.property.service.impl.ProHouseAddressServiceImpl;
import com.snk.property.service.impl.ProHouseServiceImpl;
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
import com.snk.property.domain.ProHouseOrder;
import com.snk.property.service.IProHouseOrderService;
import com.snk.common.core.controller.BaseController;
import com.snk.common.core.domain.AjaxResult;
import com.snk.common.utils.poi.ExcelUtil;
import com.snk.common.core.page.TableDataInfo;

/**
 * 物业订单Controller
 * 
 * @author snk
 * @date 2021-10-27
 */
@Controller
@RequestMapping("/property/houseOrder")
public class ProHouseOrderController extends BaseController
{
    private String prefix = "property/houseOrder";

    @Autowired
    private IProHouseOrderService proHouseOrderService;
    @Autowired
    private ProHouseAddressServiceImpl addressService;
    @Autowired
    private ProHouseServiceImpl houseService;
    @Autowired
    private ProHouseTypeServiceImpl typeService;

    @RequiresPermissions("property:houseOrder:view")
    @GetMapping()
    public String houseOrder()
    {
        return prefix + "/list";
    }

    /**
     * 查询物业订单列表
     */
    @RequiresPermissions("property:houseOrder:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProHouseOrder proHouseOrder)
    {
        startPage();
        List<ProHouseOrder> list = proHouseOrderService.selectProHouseOrderList(proHouseOrder);
        return getDataTable(list);
    }

    /**
     * 导出物业订单列表
     */
    @RequiresPermissions("property:houseOrder:export")
    @Log(title = "物业订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProHouseOrder proHouseOrder)
    {
        List<ProHouseOrder> list = proHouseOrderService.selectProHouseOrderList(proHouseOrder);
        ExcelUtil<ProHouseOrder> util = new ExcelUtil<ProHouseOrder>(ProHouseOrder.class);
        return util.exportExcel(list, "houseOrder");
    }

    /**
     * 新增物业订单
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        ProHouseAddress address=new ProHouseAddress();
        address.setPid(100L);
        mmap.addAttribute("addressList",addressService.selectProHouseAddressList(address));
        return prefix + "/add";
    }

    /**
     * 新增保存物业订单
     */
    @RequiresPermissions("property:houseOrder:add")
    @Log(title = "物业订单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProHouseOrder proHouseOrder)
    {

        return toAjax(proHouseOrderService.insertProHouseOrder(proHouseOrder));
    }

    /**
     * 修改物业订单
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ProHouseOrder proHouseOrder = proHouseOrderService.selectProHouseOrderById(id);
        mmap.put("proHouseOrder", proHouseOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存物业订单
     */
    @RequiresPermissions("property:houseOrder:edit")
    @Log(title = "物业订单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProHouseOrder proHouseOrder)
    {
        return toAjax(proHouseOrderService.updateProHouseOrder(proHouseOrder));
    }

    /**
     * 删除物业订单
     */
    @RequiresPermissions("property:houseOrder:remove")
    @Log(title = "物业订单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(proHouseOrderService.deleteProHouseOrderByIds(ids));
    }

    /**
     * 初始物业订单（生成指定时间段的订单）
     */
    @RequiresPermissions("property:houseOrder:add")
    @Log(title = "物业订单", businessType = BusinessType.INSERT)
    @PostMapping("/initializeTheOrder")
    @ResponseBody
    public AjaxResult initializeTheOrder(ProHouseOrder proHouseOrder)
    {

        return toAjax(proHouseOrderService.initializeTheOrder(proHouseOrder));
    }
    /**
     * 修改物业订单的上/下架
     */
    @RequiresPermissions("property:houseOrder:edit")
    @Log(title = "物业订单", businessType = BusinessType.UPDATE)
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(ProHouseOrder proHouseOrder)
    {
        System.out.println(proHouseOrder);
        System.out.println(proHouseOrder.getShelfStatus());
        return toAjax(proHouseOrderService.changeStatusProHouseOrder(proHouseOrder));
    }

}