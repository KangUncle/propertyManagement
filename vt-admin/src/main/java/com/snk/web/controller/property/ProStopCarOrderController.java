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
import com.snk.property.domain.ProStopCarOrder;
import com.snk.property.service.IProStopCarOrderService;
import com.snk.common.core.controller.BaseController;
import com.snk.common.core.domain.AjaxResult;
import com.snk.common.utils.poi.ExcelUtil;
import com.snk.common.core.page.TableDataInfo;

/**
 * 停车订单Controller
 * 
 * @author snk
 * @date 2021-10-29
 */
@Controller
@RequestMapping("/property/carInOutOrder")
public class ProStopCarOrderController extends BaseController
{
    private String prefix = "property/carInOutOrder";

    @Autowired
    private IProStopCarOrderService proStopCarOrderService;

    @RequiresPermissions("property:carInOutOrder:view")
    @GetMapping()
    public String carInOutOrder()
    {
        return prefix + "/list ";
    }

    /**
     * 查询停车订单列表
     */
    @RequiresPermissions("property:carInOutOrder:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProStopCarOrder proStopCarOrder)
    {
        startPage();
        List<ProStopCarOrder> list = proStopCarOrderService.selectProStopCarOrderList(proStopCarOrder);
        return getDataTable(list);
    }

    /**
     * 导出停车订单列表
     */
    @RequiresPermissions("property:carInOutOrder:export")
    @Log(title = "停车订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProStopCarOrder proStopCarOrder)
    {
        List<ProStopCarOrder> list = proStopCarOrderService.selectProStopCarOrderList(proStopCarOrder);
        ExcelUtil<ProStopCarOrder> util = new ExcelUtil<ProStopCarOrder>(ProStopCarOrder.class);
        return util.exportExcel(list, "carInOutOrder");
    }

    /**
     * 新增停车订单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存停车订单
     */
    @RequiresPermissions("property:carInOutOrder:add")
    @Log(title = "停车订单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProStopCarOrder proStopCarOrder)
    {
        return toAjax(proStopCarOrderService.insertProStopCarOrder(proStopCarOrder));
    }

    /**
     * 修改停车订单
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ProStopCarOrder proStopCarOrder = proStopCarOrderService.selectProStopCarOrderById(id);
        mmap.put("proStopCarOrder", proStopCarOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存停车订单
     */
    @RequiresPermissions("property:carInOutOrder:edit")
    @Log(title = "停车订单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProStopCarOrder proStopCarOrder)
    {
        return toAjax(proStopCarOrderService.updateProStopCarOrder(proStopCarOrder));
    }

    /**
     * 删除停车订单
     */
    @RequiresPermissions("property:carInOutOrder:remove")
    @Log(title = "停车订单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(proStopCarOrderService.deleteProStopCarOrderByIds(ids));
    }
}