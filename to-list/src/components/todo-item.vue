<template>
  <div class="todoitem">
    <li class="todo" v-bind:class="{ active: todo.isEven }">
        <div class="checkbox-item" v-bind:class="{ checkboxdisplay: checkdisplay1}" @mouseenter="enterm" @mouseleave="leavem">
            <input class="inputcheckbox" type="checkbox" name="checkbox"  v-model="todo.state">
            <label class="checkbox-label" v-bind:class="{ addline: todo.state }" @dblclick="Edit(todo)" >{{todo.title}}</label>
            <button class="display" v-bind:class="{display1:display1}" @click="remove(todo)">&times;</button>
        </div>
 				<input class="edit" v-bind:class="{ editdisplay: editdisplay1}" type="text" v-todo-focus="todo == editedTodo" v-model="todo.title"  @blur="doneEdit" @keydown.enter="doneEdit" @keydown.esc="cancelEdit">
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
       checkdisplay1:false,
       editdisplay1:false,
       edittodotitle:null,
       display1:false,
       editedTodo:null,
      }
  },
  methods:{
     Edit(todo){
      this.checkdisplay1=true;
      this.editdisplay1=true;
      this.edittodotitle=this.todo.title;
      this.editedTodo=todo;
     },
     doneEdit(){
       this.checkdisplay1=false;
      this.editdisplay1=false;
      if (!this.edittodotitle) {
					return;
				}
        this.edittodotitle = null;
        
			//	todo.title = todo.title.trim();
     },
     cancelEdit(){
      this.checkdisplay1=false;
      this.editdisplay1=false;
        todo.title=this.edittodotitle;
     },
     remove(todo){
        this.$store.commit("remove",todo);
     },
     enterm(){
      this.display1=true;
     },
     leavem(){
       this.display1=false;
     }
  },
  directives: {
			'todo-focus': function (el, binding) {
				if (binding.value) {
					el.focus();
				}
			}
		}
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
