<template>
  <div class="app-container">
    <!-- 查询条件 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">

      <el-form-item label="单据日期" prop="businessdate">
        <el-date-picker clearable
          v-model="businessdate"
          type="daterange"
          format="yyyy-MM-dd"
          value-format="yyyyMMdd"
          range-separator="至"
          start-placeholder="开始日期"
          end-placeholder="结束日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="仓库编码" prop="whcode">
        <el-input
          v-model="queryParams.whcode"
          placeholder="仓库编码"
          clearable
          @keyup.enter.native="handleQuery"
        ><i slot="suffix" class="el-input__icon el-icon-search" @click="showDialog()"></i></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          v-hasPermi="['system:SCLLDCXD:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          v-hasPermi="['system:SCLLDCXD:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          v-hasPermi="['system:SCLLDCXD:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:SCLLDCXD:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 查询结果 -->
    <vxe-table v-loading="loading" :data="SCLLDCXDList" @selection-change="handleSelectionChange" 
    :row-config="{isHover: true}" stripe border :column-config="{resizable: true}" height="800">
     <vxe-column type="seq" title="序号" width="60"></vxe-column>
     <vxe-column field="name" title="单据类型" width="120"></vxe-column>
     <vxe-column field="businessdate" title="单据日期" width="140">
      <template slot-scope="scope">
          <span>{{ parseTime(scope.row.businessdate, '{y}-{m}-{d}') }}</span>
        </template>
     </vxe-column>
     <vxe-column field="issuetype" title="领料标识" width="100"></vxe-column>
     <vxe-column field="docno" title="出库单号" width="140"></vxe-column> 
     <vxe-column field="createdby" title="制单人" width="100"></vxe-column>
     <vxe-column field="whcode" title="仓库编码" width="80"></vxe-column>
     <vxe-column field="deptcode" title="部门编码" width="120"></vxe-column>
     <vxe-column field="deptname" title="部门名称" width="120"></vxe-column>
     <vxe-column field="itemcode" title="料号" width="140"></vxe-column>
     <vxe-column field="itemname" title="品名" width="140"></vxe-column>
     <vxe-column field="specs" title="规格" width="140"></vxe-column>
     <vxe-column field="uom" title="单位" width="80"></vxe-column>
     <vxe-column field="issuedqty" title="出库数量" width="100"></vxe-column>
     <vxe-column field="modocno" title="生产订单号" width="140"></vxe-column>
     <vxe-column field="lotmaster" title="批号" width="160"></vxe-column>
     <vxe-column field="lsxh" title="流水线号" width="100"></vxe-column>
     <vxe-column field="projectcode" title="产品编码" width="140"></vxe-column>
     <vxe-column field="docstate" title="状态" width="100"></vxe-column>
     <vxe-column field="approveby" title="审核人" width="100"></vxe-column>
     <vxe-column field="businesscreatedon" title="确认日期" width="140">
      <template slot-scope="scope">
          <span>{{ parseTime(scope.row.businesscreatedon, '{y}-{m}-{d}') }}</span>
        </template>
     </vxe-column>
     <vxe-column field="issueitemon" title="发料确认日期" width="160">
      <template slot-scope="scope">
          <span>{{ parseTime(scope.row.issueitemon, '{y}/{m}/{d} {h}:{i}:{s}') }}</span>
        </template>
     </vxe-column>
     <vxe-column field="actualissuedate" title="行实际发料时间" width="140">
      <template slot-scope="scope">
          <span>{{ parseTime(scope.row.actualissuedate, '{y}-{m}-{d}') }}</span>
        </template>
     </vxe-column>
     <vxe-column field="cwcategory" title="财务分类名称" width="120"></vxe-column>
     <vxe-column field="modoctype" title="生产订单单据类型" width="140"></vxe-column>
    </vxe-table>


    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 弹出窗口 -->
    <whList :showDialog="whSwitch" @dialogClose="whSwitch = false"></whList>

  </div>
</template>

<script>
import { listSCLLDCXD, getSCLLDCXD } from "@/api/system/SCLLDCXD";
import whList from '@/components/SearchResult/WhList.vue';

export default {
  name: "SCLLDCXD",
  components: {whList},
  data() {
    return {
      // 遮罩层
      loading: false,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 生产领料单查询D表格数据
      SCLLDCXDList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 20,
        name: null,
        businessdate: null,
        issuetype: null,
        docno: null,
        createdby: null,
        whcode: null,
        deptcode: null,
        deptname: null,
        itemcode: null,
        itemname: null,
        specs: null,
        uom: null,
        issuedqty: null,
        modocno: null,
        lotmaster: null,
        lsxh: null,
        projectcode: null,
        productcode: null,
        docstate: null,
        approveby: null,
        businesscreatedon: null,
        issueitemon: null,
        actualissuedate: null,
        cwcategory: null,
        modoctype: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      },
      // 查询单据日期
      businessdate: ['20230401','20230402'],
      // 存储地点查询条件显示开关
      whSwitch : false
    };
  },
  created() {
    //this.getList();
  },
  methods: {
    /** 查询生产领料单查询D列表 */
    getList() {
      this.loading = true;
      this.queryParams.businessdatebeg=this.businessdate[0];
      this.queryParams.businessdateend=this.businessdate[1];
      listSCLLDCXD(this.queryParams).then(response => {
        this.SCLLDCXDList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        name: null,
        businessdate: null,
        issuetype: null,
        docno: null,
        createdby: null,
        whcode: null,
        deptcode: null,
        deptname: null,
        itemcode: null,
        itemname: null,
        specs: null,
        uom: null,
        issuedqty: null,
        modocno: null,
        lotmaster: null,
        lsxh: null,
        projectcode: null,
        productcode: null,
        docstate: null,
        approveby: null,
        businesscreatedon: null,
        issueitemon: null,
        actualissuedate: null,
        cwcategory: null,
        modoctype: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.name)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/SCLLDCXD/export', {
        ...this.queryParams
      }, `SCLLDCXD_${new Date().getTime()}.xlsx`)
    },
    //弹出对话框
    showDialog(){
      this.whSwitch=true;
    }
  }
};
</script>
