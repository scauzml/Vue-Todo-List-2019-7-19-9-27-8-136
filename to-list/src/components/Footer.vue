<template>
  <div class="footer">
   <div class="buttondiv">
    <button class="bt" @click="all">ALL</button>
    <button class="bt" @click="active">Active</button>
     <button class="bt" @click="complete">Complete</button>
   </div>
  </div>
</template>

<script>
export default {
  name: 'footer',
  components: {

  },
  data(){

      return {
      }
  },

  methods:{
      all(){
        this.$store.commit("showState","all");
      },
      active(){
       this.$store.commit("showState","active");
      },
      complete(){
       this.$store.commit("showState","complete");
      },

      

  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style  scoped>

</style>
