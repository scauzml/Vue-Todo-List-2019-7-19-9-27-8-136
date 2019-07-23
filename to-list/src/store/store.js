import Vue from 'vue'
import Vuex from 'vuex'
// import vuexAlong from 'vuex-along'
import state from './state'
import actions from './actions'
import getters from './getters'
import mutations from './mutations'
Vue.use(Vuex)


export const  store =new Vuex.Store({
  state,
  getters,
  mutations,
  actions

})
