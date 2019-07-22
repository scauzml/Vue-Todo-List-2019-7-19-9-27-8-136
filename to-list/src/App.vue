<template>
  <div id="app">
      <div class="tolistdiv">
        <headers></headers>
        <tolist></tolist>
        <Footers></Footers>
      </div>
  </div>
</template>

<script>
import tolist from './components/todolist'
import headers from './components/header'
import Footers from './components/Footer'


export default {
  name: 'app',
  components: {
    tolist,
    headers,
    Footers
  }
}
</script>

<style>

</style>
