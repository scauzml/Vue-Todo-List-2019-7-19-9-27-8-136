<template>
  <div id="welcome"> 
    <a-row type="flex"  justify="center" :gutter="16" align="middle" >
      <a-col :span="4">
        <div class="components-input-demo-presuffix">
          </div><a-input type="text"  v-model="name">
            <a-icon slot="prefix" type="user" ref="userNameInput" />
      <a-icon v-if="name" slot="suffix" type="close-circle" @click="emitEmpty" />
        </a-input>
      </a-col>
      <a-col :span="4">
      <a-button @click="start">开始</a-button>
     
      </a-col>
     
    </a-row>
     
     
  </div>
</template>

<script>



export default {
  name: 'welcome',
  components: {
   
  },
  data(){
      return{
          name:null
      }
  },
  methods:{
      start(){
         this.$router.push({name:'home',params:{name:this.name}}) ;
      },
      emitEmpty () {
      this.$refs.userNameInput.focus()
      this.name = ''
    },
  }
}
</script>

<style>

</style>
