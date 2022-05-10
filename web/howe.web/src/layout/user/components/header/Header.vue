<template>
  <div>
    <el-row type="flex" justify="center">
      <el-col :span="3">
        <sidebar-logo
          :collapse="true"
        />
      </el-col>
      <el-col :span="14">
        <top-menu />
      </el-col>
      <el-col :span="7">
        <div class="navbar">
          <TopRightSideBar />
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import SidebarLogo from '@/layout/common/Sidebar/Logo'
import TopMenu from '@/layout/user/components/common/topMenu'
import TopRightSideBar from '@/layout/common/TopRightSideBar'

export default {
  name: 'Header',
  components: { TopRightSideBar, TopMenu, SidebarLogo },
  data() {
    return {}
  },
  created() {
  },
  mounted() {

  },
  methods: {}
}
</script>

<style scoped>

</style>
