<template>
  <div id="tododisplay">  
      <div class="tolistdiv">
        <headers></headers>
        <tolist></tolist>
        <Footers></Footers>
      </div>   
  </div>
</template>

<script>
import tolist from './todolist'
import headers from './header'
import Footers from './Footer'


export default {
  name: 'tolistdisplay',
  components: {
    tolist,
    headers,
    Footers
  },
  data(){
      return {
       
      }
  }
  
}
</script>

<style>

</style>
