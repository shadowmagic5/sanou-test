package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 生产领料单查询D对象 SCLLDCXD
 *
 * @author ruoyi
 * @date 2023-05-19
 */
@Data
public class SCLLDCXD extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "单据类型")
    private String name;

    /** $column.columnComment */
    @Excel(name = "单据日期")
    private Date businessdate;

    private String businessdatebeg;

    private String businessdateend;

    /** $column.columnComment */
    @Excel(name = "领料标识")
    private String issuetype;

    /** $column.columnComment */
    @Excel(name = "出库单号")
    private String docno;

    /** $column.columnComment */
    @Excel(name = "制单人")
    private String createdby;

    /** $column.columnComment */
    @Excel(name = "仓库编码")
    private String whcode;

    /** $column.columnComment */
    @Excel(name = "部门编码")
    private String deptcode;

    /** $column.columnComment */
    @Excel(name = "部门名称")
    private String deptname;

    /** $column.columnComment */
    @Excel(name = "料号")
    private String itemcode;

    /** $column.columnComment */
    @Excel(name = "品名")
    private String itemname;

    /** $column.columnComment */
    @Excel(name = "规格")
    private String specs;

    /** $column.columnComment */
    @Excel(name = "单位")
    private String uom;

    /** $column.columnComment */
    @Excel(name = "出库数量")
    private String issuedqty;

    /** $column.columnComment */
    @Excel(name = "生产订单号")
    private String modocno;

    /** $column.columnComment */
    @Excel(name = "批号")
    private Long lotmaster;

    /** $column.columnComment */
    @Excel(name = "流水线号")
    private String lsxh;

    /** $column.columnComment */
    @Excel(name = "项目号")
    private String projectcode;

    /** $column.columnComment */
    @Excel(name = "产品编码")
    private String productcode;

    /** $column.columnComment */
    @Excel(name = "状态")
    private String docstate;

    /** $column.columnComment */
    @Excel(name = "审核人")
    private String approveby;

    /** $column.columnComment */
    @Excel(name = "确认日期")
    private Date businesscreatedon;

    /** $column.columnComment */
    @Excel(name = "发料确认日期")
    private Date issueitemon;

    /** $column.columnComment */
    @Excel(name = "行实际发料时间")
    private Date actualissuedate;

    /** $column.columnComment */
    @Excel(name = "财务分类名称")
    private String cwcategory;

    /** $column.columnComment */
    @Excel(name = "生产订单单据类型")
    private String modoctype;

}
