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
export default {
  name: 'todolist',
  props: {
    todo: Object
  },
  data(){
      return {
     
      newTodoText:'',
      nextTodoId:0,

      }
  },
 created(){
   this.axios.get("http://localhost:8080/tolistentitys").then(
     res=>{
          console.log(res);   
     }
   ).catch(reason => {
                alert(reason)
              });
 },
  methods:{
      addNewTodo(){
          if(this.newTodoText!=''){
          let item={
              id:this.nextTodoId++,
              title:this.newTodoText,
              isEven:false,
              state:false
          }
          this.$store.commit("addTodos1",item);
          this.axios.post("http://localhost:8080/tolistentitys",item).then(
            res=>{
                console.log(res);
            }
          ).catch(reason => {
                alert(reason)
              });
          this.newTodoText='';   
          }
           
      },
  },
 
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
