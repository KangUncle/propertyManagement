package com.snk.web.controller.property;

import java.util.List;

import com.snk.property.domain.ProCarport;
import com.snk.property.domain.ProStopCarAttribute;
import com.snk.property.service.IProHouseService;
import com.snk.property.service.IProStopCarAttributeService;
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
import com.snk.property.domain.ProHouseCar;
import com.snk.property.service.IProHouseCarService;
import com.snk.common.core.controller.BaseController;
import com.snk.common.core.domain.AjaxResult;
import com.snk.common.utils.poi.ExcelUtil;
import com.snk.common.core.page.TableDataInfo;

/**
 * 车辆入库Controller
 * 
 * @author snk
 * @date 2021-10-29
 */
@Controller
@RequestMapping("property/carIntoTreasury")
public class ProHouseCarController extends BaseController
{
    private String prefix = "property/carIntoTreasury";

    @Autowired
    private IProHouseCarService proHouseCarService;
    @Autowired
    private IProStopCarAttributeService carAttributeService;
    @Autowired
    private IProHouseService houseService;

    @RequiresPermissions("property:carIntoTreasury:view")
    @GetMapping()
    public String carIntoTreasury(ModelMap mmap)
    {
        mmap.addAttribute("attributeList",carAttributeService.selectProStopCarAttributeList(new ProStopCarAttribute()));
        return prefix + "/list";
    }

    /**
     * 查询车辆入库列表
     */
    @ApiOperation("list")
    @RequiresPermissions("property:carIntoTreasury:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProHouseCar proHouseCar)
    {
        startPage();
        List<ProHouseCar> list = proHouseCarService.selectProHouseCarList(proHouseCar);
        return getDataTable(list);
    }

    /**
     * 导出车辆入库列表
     */
    @RequiresPermissions("property:carIntoTreasury:export")
    @Log(title = "车辆入库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProHouseCar proHouseCar)
    {
        List<ProHouseCar> list = proHouseCarService.selectProHouseCarList(proHouseCar);
        ExcelUtil<ProHouseCar> util = new ExcelUtil<ProHouseCar>(ProHouseCar.class);
        return util.exportExcel(list, "carIntoTreasury");
    }

    /**
     * 新增车辆入库
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.addAttribute("carAttributeList",carAttributeService.selectProStopCarAttributeList(new ProStopCarAttribute()));
        return prefix + "/add";
    }

    /**
     * 新增保存车辆入库
     */
    @RequiresPermissions("property:carIntoTreasury:add")
    @Log(title = "车辆入库", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProHouseCar proHouseCar)
    {
        return toAjax(proHouseCarService.insertProHouseCar(proHouseCar));
    }

    /**
     * 修改车辆入库
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ProHouseCar proHouseCar = proHouseCarService.selectProHouseCarById(id);
        mmap.addAttribute("carAttributeList",carAttributeService.selectProStopCarAttributeList(new ProStopCarAttribute()));
        mmap.addAttribute("proHouseCar", proHouseCar);
        mmap.addAttribute("house",houseService.selectProHouseById(proHouseCar.getHouseId()));
        return prefix + "/edit";
    }

    /**
     * 修改保存车辆入库
     */
    @RequiresPermissions("property:carIntoTreasury:edit")
    @Log(title = "车辆入库", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProHouseCar proHouseCar)
    {
        return toAjax(proHouseCarService.updateProHouseCar(proHouseCar));
    }

    /**
     * 删除车辆入库
     */
    @RequiresPermissions("property:carIntoTreasury:remove")
    @Log(title = "车辆入库", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(proHouseCarService.deleteProHouseCarByIds(ids));
    }

//    /**
//     * 根据小区的名称查询所属小区的已入库车辆
//     */
//    @GetMapping("/selectCarListByCommunityId/{id}")
//    public List<ProHouseCar> selectCarListByCommunityId(@PathVariable("id") Long id)
//    {
//        List<ProHouseCar> houseCarList = proHouseCarService.selectCarListByCommunityId(id);
//        return houseCarList;
//    }
    /**
     * 根据小区的名称查询所属小区的已入库车辆
     */
//    @PostMapping("/selectCarListByCommunityId")
//    public List<ProHouseCar> selectCarListByCommunityId(ProCarport proCarport)
//    {
//        List<ProHouseCar> houseCarList = proHouseCarService.selectCarListByCommunityId(proCarport.getCommunityId());
//        return houseCarList;
//    }


}