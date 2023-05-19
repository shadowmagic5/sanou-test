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
import com.ruoyi.system.domain.SCLLDCXD;
import com.ruoyi.system.service.ISCLLDCXDService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 生产领料单查询DController
 *
 * @author ruoyi
 * @date 2023-05-19
 */
@RestController
@RequestMapping("/system/SCLLDCXD")
public class SCLLDCXDController extends BaseController
{
    @Autowired
    private ISCLLDCXDService sCLLDCXDService;

    /**
     * 查询生产领料单查询D列表
     */
    @PreAuthorize("@ss.hasPermi('system:SCLLDCXD:list')")
    @GetMapping("/list")
    public TableDataInfo list(SCLLDCXD sCLLDCXD)
    {
        startPage();
        List<SCLLDCXD> list = sCLLDCXDService.selectSCLLDCXDList(sCLLDCXD);
        return getDataTable(list);
    }

    /**
     * 导出生产领料单查询D列表
     */
    @PreAuthorize("@ss.hasPermi('system:SCLLDCXD:export')")
    @Log(title = "生产领料单查询D", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SCLLDCXD sCLLDCXD)
    {
        List<SCLLDCXD> list = sCLLDCXDService.selectSCLLDCXDList(sCLLDCXD);
        ExcelUtil<SCLLDCXD> util = new ExcelUtil<SCLLDCXD>(SCLLDCXD.class);
        util.exportExcel(response, list, "生产领料单查询D数据");
    }

    /**
     * 获取生产领料单查询D详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:SCLLDCXD:query')")
    @GetMapping(value = "/{name}")
    public AjaxResult getInfo(@PathVariable("name") String name)
    {
        return success(sCLLDCXDService.selectSCLLDCXDByName(name));
    }

}
