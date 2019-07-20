<template>
  <div class="tolist">
     {{a}}
  </div>
</template>

<script>
export default {
  name: 'todolist',
  props: {
    msg: String
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
