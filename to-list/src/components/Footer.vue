<template>
  <div class="footer">
   <div class="buttondiv">
    <button class="bt" @click="all">ALL</button>
    <button class="bt" @click="active">Active</button>
     <button class="bt" @click="complete">Complete</button>
   </div>
  </div>
</template>

<script>
export default {
  name: 'footer',
  components: {

  },
  data(){

      return {
      }
  },

  methods:{
      all(){
      this.todos=this.todos1;
       this.todos=this.todos.map((e,index,arr)=>{
           e.isEven=(index+1)%2===0;
           return e;
       });
      },
      active(){
       this.todos=this.todos1.filter(e=>e.state === false)
       this.todos=this.todos.map((e,index)=>{
         
           e.isEven=(index+1)%2===0;
           return e;
       });
     //  this.todos= this.$options.methods.findEven(this.todos);
      },

      complete(){
       this.todos=this.todos1.filter(e=>e.state === true)
        this.todos=this.todos.map((e,index,arr)=>{
        
           e.isEven=(index+1)%2===0;
           return e;
       });
     //  this.todos= this.$options.methods.findEven(this.todos);
      },

      

  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style  scoped>

</style>
