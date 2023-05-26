package com.ruoyi.web.controller.chart;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.CboWh;
import com.ruoyi.system.service.ICboWhService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 存储地点查询Controller
 *
 * @author ruoyi
 * @date 2023-05-26
 */
@RestController
@RequestMapping("/system/wh")
public class CboWhController extends BaseController
{
    @Autowired
    private ICboWhService cboWhService;

    /**
     * 查询存储地点查询列表
     */
    @PreAuthorize("@ss.hasPermi('system:wh:list')")
    @GetMapping("/list")
    public TableDataInfo list(CboWh cboWh)
    {
        startPage();
        List<CboWh> list = cboWhService.selectCboWhList(cboWh);
        return getDataTable(list);
    }

    /**
     * 导出存储地点查询列表
     */
    @PreAuthorize("@ss.hasPermi('system:wh:export')")
    @Log(title = "存储地点查询", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CboWh cboWh)
    {
        List<CboWh> list = cboWhService.selectCboWhList(cboWh);
        ExcelUtil<CboWh> util = new ExcelUtil<CboWh>(CboWh.class);
        util.exportExcel(response, list, "存储地点查询数据");
    }

    /**
     * 获取存储地点查询详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:wh:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cboWhService.selectCboWhById(id));
    }


}
