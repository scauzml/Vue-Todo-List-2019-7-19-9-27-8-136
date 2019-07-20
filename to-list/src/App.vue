<template>
  <div id="app">
    <!-- <img alt="Vue logo" src="./assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/> -->
      <div class="tolistdiv">
        <tolist></tolist>
      </div>
    
  </div>
</template>

<script>
import tolist from './components/todolist'

export default {
  name: 'app',
  components: {
    tolist
  }
}
</script>

<style>

</style>
