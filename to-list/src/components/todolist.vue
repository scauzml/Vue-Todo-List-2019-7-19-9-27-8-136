<template>
  <div class="tolist">
   <form v-on:submit.prevent='addNewTodo'>
       <h1>jquery To Do List</h1>
       <p id="title">Simple Todo List with adding and filter by diff status</p>
       <input class="message"
       v-model="newTodoText"
       id="new-todo"
       /> <button class="addbutton">Add</button>
   </form>
   <ol class="myul">
       <li
       is="todoitem"
       v-for="(todo,index) in todos"
       v-bind:key="todo.id"
       v-bind:title="todo.title"
       v-on:remove="todos.splice(index,1)"
       ></li>
   </ol>
   <div class="buttondiv">
    <button class="bt">ALL</button>
    <button class="bt">Active</button>
     <button class="bt">Complete</button>
   </div>

  </div>
</template>

<script>
import todoitem from './todo-item'
export default {
  name: 'todolist',
  props: {
    msg: String
  },
  components: {
    todoitem
  },
  data(){

      return {
          newTodoText:'',
      todos: [
      {
        id: 1,
        title: '123',
        status:''
      },
      {
        id: 2,
        title: '456',
        status:''
      },
      {
        id: 3,
        title: '789',
        status:''
      }
    ],
    nextTodoId: 4
      }
  },
  methods:{
      addNewTodo(){
          this.todos.push({
              id:this.nextTodoId++,
              title:this.newTodoText
          })
      }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style  scoped>

</style>
