<template>
  <div class="app-container">
    <el-card class="operate-container" shadow="never">
      <el-button size="mini" class="btn-add" @click="handleAdd()">添加广告</el-button>
    </el-card>
    <div class="table-container">
      <el-table
        ref="homeAdvertiseTable"
        :data="list"
        style="width: 100%;"
        v-loading="listLoading"
        border
      >
        <el-table-column label="id" width="120" align="center">
          <template slot-scope="scope">{{scope.row.id}}</template>
        </el-table-column>
        <el-table-column label="广告名称" align="center">
          <template slot-scope="scope">{{scope.row.name}}</template>
        </el-table-column>

        <!-- 获取广告位置信息  spaceId 外键id-->
        <el-table-column label="广告位置" width="200" align="center">
          <template slot-scope="scope">{{getSpaceName(scope.row.spaceId)}}</template>
        </el-table-column>

        <el-table-column label="广告图片" width="120" align="center">
          <template slot-scope="scope">
            <img style="height: 80px" :src="scope.row.img" />
          </template>
        </el-table-column>
        <el-table-column label="时间" width="250" align="center">
          <template slot-scope="scope">
            <p>开始时间：{{scope.row.startTime | formatTime}}</p>
            <p>到期时间：{{scope.row.endTime | formatTime}}</p>
          </template>
        </el-table-column>

        <!-- 上线与下线 -->
        <el-table-column label="上线/下线" width="120" align="center">
          <template slot-scope="scope">
            <el-switch
              @change="handleUpdateStatus(scope.row)"
              :active-value="1"
              :inactive-value="0"
              v-model="scope.row.status"
            ></el-switch>
          </template>
        </el-table-column>

        <!-- 编辑按钮 -->
        <el-table-column label="操作" width="120" align="center">
          <template slot-scope="scope">
            <el-button size="mini" type="text" @click="handleUpdate(scope.row)">编辑</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <!-- 分页 -->
    <div class="pagination-container">
      <el-pagination
        background
        @size-change="handlePageSizeChange"
        @current-change="handleCurrentPageChange"
        layout="total, sizes,prev, pager, next,jumper"
        :current-page="page"
        :page-sizes="[5,10, 20]"
        :page-size="size"
        :total="total"
      ></el-pagination>
    </div>
  </div>
</template>

<script>
import { axios } from "../../utils";

import moment from "moment";

export default {
  name: "homeAdvertiseList",
  title: "广告管理",
  inject: ["reload"],
  //数据部分
  data() {
    return {
      typeMap: {}, //保存广告位对象信息
      total: 0, //总条数
      size: 5, //每页显示条数
      page: 1, //当前页
      list: [], //广告数据
      listLoading: false
    };
  },

  //钩子函数
  created() {
    //获取广告列表数据
    this.loadPromotionAd();

    //获取广告位数据
    this.loadPromotionSpace();

    //打印typeMap
    console.log(this.typeMap);
  },
  methods: {
    //方法1; 获取广告列表数据
    loadPromotionAd() {
      this.listLoading = true;

      return axios
        .get("/PromotionAd/findAllPromotionAd", {
          params: {
            currentPage: this.page,
            pageSize: this.size
          }
        })
        .then(res => {
          this.list = res.data.content.list;
          this.total = res.data.content.total;
          this.listLoading = false;
        })
        .catch(err => {});
    },

    //方法2: 获取广告位置数据
    loadPromotionSpace() {
      this.listLoading = true;

      return axios.get("/PromotionSpace/findAllPromotionSpace").then(res => {
        //使用map进行遍历
        res.data.content.map(item => {
          //将数据保存到 typeMap  key就是id,value就是 广告位对象
          this.typeMap[item.id] = item;
        });
        this.listLoading = false;
      });
    },

    //方法3: 获取广告位置名称
    getSpaceName(spaceId) {
      if (!spaceId) {
        return "";
      }
      return this.typeMap[spaceId] && this.typeMap[spaceId].name;
    },

    //方法4: 修改状态
    handleUpdateStatus(row) {
      this.$confirm("是否要修改上线/下线状态?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        //请求后台
        axios
          .get("/PromotionAd/updatePromotionAdStatus", {
            params: {
              id: row.id,
              status: row.status
            }
          })
          .then(res => {
            this.loadPromotionAd();
          })
          .catch(err => {
            this.$message("修改状态失败! ! !");
          });
      });
    },

    //跳转到新增
    handleAdd() {
      this.$router.push({ path: "/addAdvertise" });
    },

    //跳转到修改
    handleUpdate(row) {
      this.$router.push({ path: "/updateAdvertise", query: { id: row.id } });
    },

    //页码变化触发的函数
    handleCurrentPageChange(page) {
      this.page = page;
      this.loadPromotionAd();
    },

    //每页显示条数变化触发的函数
    handlePageSizeChange(size) {
      this.size = size;
      this.loadPromotionAd();
    }
  },
  filters: {
    formatTime(time) {
      return moment(time).format("YYYY-MM-DD HH:mm:ss");
    }
  }
};
</script>
<style scoped>
.input-width {
  width: 203px;
}
</style>
