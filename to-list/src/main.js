import Vue from 'vue'
import { store } from "./store/store";
import axios from 'axios'

import App from './App.vue'
Vue.use(axios)
Vue.config.productionTip = false

new Vue({
  store,
  render: h => h(App),
}).$mount('#app')
