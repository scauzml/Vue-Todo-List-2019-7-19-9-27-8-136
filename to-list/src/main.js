import Vue from 'vue'
import { store } from "./store/store";
import VueRouter from 'vue-router'
import axios from 'axios'

import Welcome from './components/welcome'
import Home from './components/home'
import todisplay from './components/tolistdisplay'
import name from './components/name'
import App from './App.vue'


Vue.use(VueRouter);
Vue.use(axios);
Vue.prototype.$axios = axios;
Vue.config.productionTip = false
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8';           //配置请求头

const routes = [
  { path: '/', name: "welcome", component: Welcome },
  {
    path: '/home/:name', name: 'home', component: Home, props: true,
    children: [
      { path: 'todolistpaly', name: 'todisplay', component: todisplay },
      { path: 'name', name: 'name', component: name, props: true }
    ]
  }
]

const router = new VueRouter({
  routes,// short for `routes: routes`
  mode: 'history'/*去掉#*/
})

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
