<template>
  <div id="welcome"> 
      <div>
           <input type="text" v-model="name">
      <button @click="start">开始</button></div> 
     
  </div>
</template>

<script>



export default {
  name: 'welcome',
  components: {
   
  },
  data(){
      return{
          name:null
      }
  },
  methods:{
      start(){
         this.$router.push({name:'home',params:{name:this.name}}) ;
      }
  }
}
</script>

<style>

</style>
