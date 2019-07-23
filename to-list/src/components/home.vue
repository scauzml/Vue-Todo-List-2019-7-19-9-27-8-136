<template>
  <div id="home">
      
      <div class="headers">
        <button class="bt">back</button>
         <p class="namep">{{name}}</p>
      </div>
      <div class="main">

       <div class="left">
        

        <div class="todisplay"> <router-link  :to="{ name:'todisplay'}">ToList</router-link></div>

        <div class="todisplay1"> <router-link  :to="{ name:'name'}">profile</router-link></div>

       </div>

        <div class="right">

       <router-view></router-view>

        </div>
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

<style>
@import "../style/tolist.css"; 
</style>
