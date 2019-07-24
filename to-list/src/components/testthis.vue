<template>
  <div id="myname">  
      <p>=> {{getName}}</p>
      <p>() {{getName1}}</p>
  </div>
</template>

<script>



export default {
  name: 'testthis',

  data(){
      return{
         name:"hello",
         name1:"hello1"
      }
  },
  computed:{
      getName:()=>{
             return this.name;
      },
      getName1(){
          return this.name1;
      }
  },
      
}
</script>

<style>

</style>
