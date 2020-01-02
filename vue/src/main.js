import Vue from 'vue'
import App from './components/Home.vue'
import router from './router'
import vuex_promise from 'es6-promise'
import axios from 'axios'
import vuex from 'vuex'
import {store} from './store'

//import 'babel-polyfill'
Vue.config.productionTip = false
Vue.prototype.$http = axios

new Vue({
  render: h => h(App),
  router,
  vuex_promise,
  axios,
  vuex,
  store
}).$mount('#app')
