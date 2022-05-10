<template>
  <div class="app-wrapper">
    <el-container>
      <el-header class="app-header" height="88px" style="background: #1f2d3d">
        <Header />
      </el-header>
      <el-main>
        <app-main />
      </el-main>
      <el-footer class="app-footer">
        <Footer />
      </el-footer>
    </el-container>
  </div>
</template>

<script>

import AppMain from '@/layout/user/components/AppMain'
import Header from '@/layout/user/components/header/Header'
import Footer from '@/layout/user/components/footer/Footer'

export default {
  name: 'Layout',
  components: {
    Footer,
    Header,
    AppMain
  },
  computed: {},
  methods: {
    handleClickOutside() {
      this.$store.dispatch('app/closeSideBar', { withoutAnimation: false })
    }
  }
}
</script>

<style lang="scss" scoped>
@import "~@/styles/mixin.scss";
@import "~@/styles/variables.scss";

.app-wrapper {
  @include clearfix;
  position: relative;
  height: 100%;
  width: 100%;

  &.mobile.openSidebar {
    position: fixed;
    top: 0;
  }
}

.drawer-bg {
  background: #000;
  opacity: 0.3;
  width: 100%;
  top: 0;
  height: 100%;
  position: absolute;
  z-index: 999;
}

.fixed-header {
  position: fixed;
  top: 0;
  right: 0;
  z-index: 9;
  width: calc(100% - #{$sideBarWidth});
  transition: width 0.28s;
}

.hideSidebar .fixed-header {
  width: calc(100% - 54px)
}

.mobile .fixed-header {
  width: 100%;
}
</style>
