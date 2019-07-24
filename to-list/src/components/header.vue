<template>
 
  <div>
    <div>

      
    </div>
    <form  class="form">
       <h1>jquery To Do List</h1>
       <p id="title">Simple Todo List with adding and filter by diff status</p>
       <a-input class="message"
       v-model="newTodoText"
       id="new-todo"
       /><a-button class="ab" type="primary" icon='plus' @click="showModal"></a-button>
   </form>
    <a-modal
      title="Title"
      :visible="visible"
      @ok="handleOk"
      :confirmLoading="confirmLoading"
      @cancel="handleCancel"
    >
      <p>{{ModalText}}</p>
    </a-modal>
 
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
     ModalText: '确定要输入这个名字吗',
      visible: false,
      confirmLoading: false,
     

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
         showModal() {
      this.visible = true
    },
    handleOk(e) {
      this.ModalText = '确定要输入这个名字吗';
      this.confirmLoading = true;
      setTimeout(() => {
        this.visible = false;
        this.confirmLoading = false;
      }, 2000);
      this.addNewTodo();
    },
    handleCancel(e) {
      this.visible = false
    },
   
  },
 
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
