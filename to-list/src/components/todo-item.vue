<template>
  <div class="todoitem">
    <li class="todo" v-bind:class="{ active: todo.isEven }">
        <div class="checkbox-item">
            <input type="checkbox" name="checkbox" @click="check(todo)" v-model="todo.state">
            <label class="checkbox-label" >{{todo.title}}</label>
        </div>
 
    </li>
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
       
      }
  },
  methods:{
     check(item){
         this.$emit("changeState",item);
     }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
