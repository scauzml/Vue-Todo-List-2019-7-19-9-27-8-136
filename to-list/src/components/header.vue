<template>
  <div class="header">
    <form v-on:submit.prevent='addNewTodo'>
       <h1>jquery To Do List</h1>
       <p id="title">Simple Todo List with adding and filter by diff status</p>
       <input class="message"
       v-model="newTodoText"
       id="new-todo"
       /> <button class="addbutton">Add</button>
   </form>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
import { mapGetters } from 'vuex'
export default {
  name: 'todolist',
  props: {
    todo: Object
  },
  data(){
      return {
     
      newTodoText:'',
     

      }
  },
 created(){
   
   this.getAllItem()

 },
  methods:{
  ...mapActions([
      'getAllItem', // map `this.getAllItem()` to `this.$store.dispatch('getAllItem')`
      'addItem',
    ]),
      addNewTodo(){
          if(this.newTodoText!=''&&this.newTodoText!=null){
          let item={
              title:this.newTodoText.trim(),
              isEven:false,
              state:false
          }
          this.addItem(item);
          this.newTodoText='';   
          }
           
      },
  },
 
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
