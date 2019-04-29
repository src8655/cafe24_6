import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import myHelloWorld from '@/components/myHelloWorld'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'myHelloWorld',
      component: myHelloWorld
    }
  ]
})
