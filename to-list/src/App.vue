<template>
 
  <div id="app">
    <a-locale-provider :locale="locale">
    <router-view></router-view>
  <!-- <testthis></testthis> -->
  </a-locale-provider>
  </div>
  
</template>

<script>

import zhCN from 'ant-design-vue/lib/locale-provider/zh_CN';
export default {
  name: 'app',
  components:{
  
  },
   data() {
    return {
      locale: zhCN,
    }
  }
}
</script>

<style>

</style>
