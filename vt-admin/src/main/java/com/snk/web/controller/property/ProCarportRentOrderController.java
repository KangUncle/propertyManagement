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
import com.snk.property.domain.ProCarportRentOrder;
import com.snk.property.service.IProCarportRentOrderService;
import com.snk.common.core.controller.BaseController;
import com.snk.common.core.domain.AjaxResult;
import com.snk.common.utils.poi.ExcelUtil;
import com.snk.common.core.page.TableDataInfo;

/**
 * 车位出租订单Controller
 * 
 * @author snk
 * @date 2021-10-29
 */
@Controller
@RequestMapping("/property/carStopCarOrder")
public class ProCarportRentOrderController extends BaseController
{
    private String prefix = "property/carStopCarOrder";

    @Autowired
    private IProCarportRentOrderService proCarportRentOrderService;

    @RequiresPermissions("property:carStopCarOrder:view")
    @GetMapping()
    public String carStopCarOrder()
    {
        return prefix + "/list";
    }

    /**
     * 查询车位出租订单列表
     */
    @RequiresPermissions("property:carStopCarOrder:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProCarportRentOrder proCarportRentOrder)
    {
        startPage();
        List<ProCarportRentOrder> list = proCarportRentOrderService.selectProCarportRentOrderList(proCarportRentOrder);
        return getDataTable(list);
    }

    /**
     * 导出车位出租订单列表
     */
    @RequiresPermissions("property:carStopCarOrder:export")
    @Log(title = "车位出租订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProCarportRentOrder proCarportRentOrder)
    {
        List<ProCarportRentOrder> list = proCarportRentOrderService.selectProCarportRentOrderList(proCarportRentOrder);
        ExcelUtil<ProCarportRentOrder> util = new ExcelUtil<ProCarportRentOrder>(ProCarportRentOrder.class);
        return util.exportExcel(list, "carStopCarOrder");
    }

    /**
     * 新增车位出租订单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存车位出租订单
     */
    @RequiresPermissions("property:carStopCarOrder:add")
    @Log(title = "车位出租订单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProCarportRentOrder proCarportRentOrder)
    {
        return toAjax(proCarportRentOrderService.insertProCarportRentOrder(proCarportRentOrder));
    }

    /**
     * 修改车位出租订单
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ProCarportRentOrder proCarportRentOrder = proCarportRentOrderService.selectProCarportRentOrderById(id);
        mmap.put("proCarportRentOrder", proCarportRentOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存车位出租订单
     */
    @RequiresPermissions("property:carStopCarOrder:edit")
    @Log(title = "车位出租订单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProCarportRentOrder proCarportRentOrder)
    {
        return toAjax(proCarportRentOrderService.updateProCarportRentOrder(proCarportRentOrder));
    }

    /**
     * 删除车位出租订单
     */
    @RequiresPermissions("property:carStopCarOrder:remove")
    @Log(title = "车位出租订单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(proCarportRentOrderService.deleteProCarportRentOrderByIds(ids));
    }
}