<template>
  <div class="todoitem">
    <li>
        <div class="checkbox-item">
            <input type="checkbox" >
            <label>{{title}}</label>
        </div>

       
    </li>
  </div>
</template>

<script>
export default {
  name: 'todolist',
  props: {
    title: String
  },
  data(){
      return {
       a:"suceess"
      }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
