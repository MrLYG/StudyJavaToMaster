<template>
  <el-card class="form-container" shadow="never">
    <el-tree
      :data="menuTreeList"
      show-checkbox
      default-expand-all
      node-key="id"
      ref="tree"
      highlight-current
      :props="defaultProps"
    ></el-tree>
    <div style="margin-top: 20px" align="center">
      <el-button type="primary" @click="handleSave()">保存</el-button>
      <el-button @click="handleClear()">清空</el-button>
    </div>
  </el-card>
</template>

<script>
import { axios } from "../../utils";

export default {
  name: "allocMenu",
  title: "角色菜单管理",
  data() {
    return {
      menuTreeList: [], //菜单数据
      checkedMenuId: [], //被选中的菜单ID

      //树形结构子节点设置
      defaultProps: {
        children: "subMenuList",
        label: "name"
      },
      roleId: null
    };
  },
  //钩子函数
  created() {
    //获取路由携带的id
    this.roleId = this.$route.query.roleId;

    //获取菜单列表
    this.treeList();

    //获取角色所拥有的菜单信息
    this.getRoleMenu(this.roleId);
  },
  methods: {
    //方法1: 获取菜单列表,使用树形控件展示
    treeList() {
      axios.get("/role/findAllMenu").then(res => {
        console.log(res.data.content);
        //获取树形控件所需的数据
        this.menuTreeList = res.data.content.parentMenuList;
      });
    },

    //方法2: 获取当前角色所拥有菜单列表id
    getRoleMenu(roleId) {
      axios.get("/role/findMenuByRoleId?roleId=" + roleId).then(res => {
        console.log(res.data.content);
        //将角色已有的菜单权限进行勾选
        this.$refs.tree.setCheckedKeys(res.data.content);
      });
    },

    //方法3: 修改角色所拥有的菜单权限
    handleSave() {
      //1.获取所有被选中的节点
      const checkedNodes = this.$refs.tree.getCheckedNodes();

      //2.定义数组 保存菜单id
      const checkedMenuIds = [];

      //3.遍历获取菜单id
      if (checkedNodes != null && checkedNodes.length > 0) {
        for (let i = 0; i < checkedNodes.length; i++) {
          const checkedNode = checkedNodes[i];

          //保存菜单id
          checkedMenuIds.push(checkedNode.id);

          //判断 如果当前节点是子节点 && 该子节点的父节点id 没有被保存
          if (
            checkedNode.parentId !== -1 &&
            checkedMenuIds.filter(item => checkedNode.parentId).length === 0
          ) {
            checkedMenuIds.push(checkedNode.parentId);
          }
        }
      }

      console.log(checkedMenuIds);

      //请求后台 保存最新的角色拥有的菜单权限
      this.$confirm("是否分配菜单?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          //准备参数
          const params = {
            roleId: this.roleId,
            menuIdList: checkedMenuIds
          };

          axios
            .post("/role/RoleContextMenu", params)
            .then(res => {
              this.$router.back();
            })
            .catch(error => {
              this.$message("权限分配失败! ! !");
            });
        })
        .catch(() => {});
    },

    //清空选择
    handleClear() {
      this.$refs.tree.setCheckedKeys([]);
    }
  }
};
</script>

<style scoped>
</style>
