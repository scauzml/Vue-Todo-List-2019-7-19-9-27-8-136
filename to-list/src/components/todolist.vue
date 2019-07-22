<template>
  <div class="tolist">
   <ol class="myul">
       <li
       is="todoitem"
       v-for="(todo,index) in todos"
       v-bind:key="index"
       v-bind:todo="todo" 
    >
       </li>
   </ol>
  </div>
</template>

<script>
import todoitem from './todo-item'
export default {
  name: 'todolist',
  components: {
    todoitem
  },
  data(){

      return {
      }
  },
 computed:{
   todos(){
     return  this.$store.getters.getTodos;
   }
 }
 ,
  methods:{
    

  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style  scoped>

</style>
