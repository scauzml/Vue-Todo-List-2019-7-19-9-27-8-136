<template>
  <div id="home">

      <div class="">
       <a-row type="flex" align="top" class="arow">
       
       <a-col :span="2" offset="1"><a-button type="primary" >back</a-button></a-col>
       <a-col :span="18"></a-col>
       <a-col :span="2" class="spanclass"> <span>{{name}}</span></a-col>
    </a-row>
        
        
      </div>
      <div class="main">
         <a-layout>
        <a-layout-sider width="200" style="background: #fff">
        <a-menu
          mode="inline"
          :defaultSelectedKeys="['1']"
          :defaultOpenKeys="['sub1']"
          :style="{ height: '100%', borderRight: 0 }"
        >
          <a-sub-menu key="sub1">
            <span slot="title"><a-icon type="user" />todo</span>
            <a-menu-item key="1"><router-link  :to="{ name:'todisplay'}">ToList</router-link></a-menu-item>
            <a-menu-item key="2"><router-link  :to="{ name:'name'}">profile</router-link></a-menu-item>
          </a-sub-menu>    
        </a-menu>
      </a-layout-sider>
        <a-layout-content class="homecontent">
          <a-row type="flex" justify="center" align="middle" class="homearow" >
               <router-view></router-view>
          </a-row>
          
        </a-layout-content>
      </a-layout>
      </div>
      
  </div>
</template>

<script>

export default {
  name: 'home',
  props:['name'],
  
  data(){
      return {
        
      }
  },
  created(){
      
  },
  methods:{
      kk(){
          this.$router.push({name:'todisplay'});
      }
  }
}
</script>

<style >
@import "../style/tolist.css"; 
</style>
