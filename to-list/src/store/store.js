import Vue from 'vue'
import Vuex from 'vuex'
// import vuexAlong from 'vuex-along'
Vue.use(Vuex)

export const  store =new Vuex.Store({
  state:{
    //设置属性状态
    sum:0,
    todos1:[],
    todos:[],
  },
  getters:{
    //获取属性状态
    getSum:state => state.sum,
  },
  
    mutations: {
        increment (state) {
          // 变更状态
          state.sum++
        },
        uncrement (state) {
            // 变更状态
            state.sum--
          }
      
 
  },
//   actions:{
//     //应用mutations
//     //patch
//     setUser({commit}, user) {
//       commit("userStatus",user)
//     },
//     setImage({commit}, image) {
//       commit("updateImage",image)
//     },
//     setTypeUser({commit},typeUser){
//       commit("typeStatus",typeUser)
//     }
//   },
//   plugins: [vuexAlong]
})
