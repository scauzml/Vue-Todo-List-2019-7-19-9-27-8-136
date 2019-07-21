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
       v-bind:key="index"
       v-bind:todo="todo"
       @changeState="updateState" ></li>
   </ol>
   <div class="buttondiv">
    <button class="bt" @click="all">ALL</button>
    <button class="bt" @click="active">Active</button>
     <button class="bt" @click="complete">Complete</button>
   </div>

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
      newTodoText:'',
      todos: [],
      todos1:[],
      nextTodoId: 0
      }
  },

  methods:{
      addNewTodo(){
          let item={
              id:this.nextTodoId++,
              title:this.newTodoText,
              state:false,
              bianji:false
          }
          item.isEven=this.nextTodoId%2===0;
          this.todos1.push(item);
          this.todos.push(item);
      },

      findEven(array){
        return array.map((e,index,arr)=>{
           e.isEven=index%2===0;
       });
      },

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
         console.log(index)
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
      updateState(item){
           let array=this.todos1.filter(e=>e.id===item.id)
           if(array.length>0){
             let item1=array[0];
             item1.state=true;
           }
      }

      

  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style  scoped>

</style>
