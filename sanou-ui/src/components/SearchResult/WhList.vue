<template>
  <div class="WhList">
    <el-dialog title="新增" :visible.sync="dialogVisible" append-to-body @close="closeDialog()">
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
    </el-dialog>
  </div>
</template>

<script>
import { listWh, getWh, delWh, addWh, updateWh } from "@/api/system/wh";
export default {
    name: "WhList",
    props: { showDialog : false},
    data(){
        return{
            dialogVisible: this.showDialog,
            formLabelWidth: "120psx",
            form: {
                type: "",
                name: "",
                description: ""
            }
        };
    },
    methods:{
        closeDialog(){
                this.$emit("dialogClose");
            }
    },
    watch:{
        showDialog() {
            this.dialogVisible=this.showDialog;
        }
    }

}
</script>

<style>

</style>