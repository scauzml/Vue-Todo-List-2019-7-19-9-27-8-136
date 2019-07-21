<template>
  <div class="todoitem">
    <li class="todo" v-bind:class="{ active: todo.isEven }">
        <div class="checkbox-item" v-bind:class="{ checkboxdisplay: checkdisplay1}">
            <input class="inputcheckbox" type="checkbox" name="checkbox" @click="check(todo)" v-model="todo.state">
            <label class="checkbox-label" v-bind:class="{ addline: todo.state }" @dblclick="Edit(todo)" >{{todo.title}}</label>
        </div>
 				<input class="edit" v-bind:class="{ editdisplay: editdisplay1}" type="text"  v-model="todo.title"  @blur="doneEdit(todo)" @keydown.enter="doneEdit(todo)" @keydown.esc="cancelEdit(todo)">
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
       edittodotitle:null
      }
  },
  methods:{
     check(item){
         this.$emit("changeState",item);
     },
     Edit(todo){
      this.checkdisplay1=true;
      this.editdisplay1=true;
      this.edittodotitle=this.todo.title;
     },
     doneEdit(todo){
       this.checkdisplay1=false;
      this.editdisplay1=false;
      if (!this.edittodotitle) {
					return;
				}
        this.edittodotitle = null;
        
			//	todo.title = todo.title.trim();
     },
     cancelEdit(todo){
      this.checkdisplay1=false;
      this.editdisplay1=false;
        todo.title=this.edittodotitle;
     }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
