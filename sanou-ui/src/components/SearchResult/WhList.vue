<template>
  <div class="WhList">
    <el-dialog title="新增" :visible.sync="dialogVisable" append-to-body>
        <el-form :model="form">
            <el-form-item label="类型" :label-width="formLabelWidth">
            <el-input v-model="form.type" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="名称" :label-width="formLabelWidth">
            <el-input v-model="form.name" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="描述" :label-width="formLabelWidth">
            <el-input v-model="form.description" autocomplete="off"></el-input>
            </el-form-item>
        </el-form>
       <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="(dialogFormVisible = false), save()"
          >确 定</el-button
        >
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listWh, getWh, delWh, addWh, updateWh } from "@/api/system/wh";
export default {
    name: "WhList",
    props: { showDialog : false },
    data(){
        return{
            dialogVisable: this.showDialog,
            formLabelWidth: "120psx",
            form: {
                type: "",
                name: "",
                description: ""
            }
        };
    },
    watch:{
        dialogVisable : {
            handler() {
                if (this.dialogVisable==false){
                    this.$emit("dialogClose");
                    console.log("dddd");
                }
            }
        }
    }

}
</script>

<style>

</style>