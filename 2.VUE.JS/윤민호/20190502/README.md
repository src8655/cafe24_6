
## 부모 자식 간 통신
![enter image description here](https://github.com/src8655/cafe24_6/blob/master/2.VUE.JS/%EC%9C%A4%EB%AF%BC%ED%98%B8/20190502/img/img01.JPG?raw=true)

      <!DOCTYPE html>
      <html>
      
      <head>
          <meta charset="utf-8">
          <title>06-18</title>
          <script src="https://unpkg.com/vue/dist/vue.min.js"></script>
      </head>
      <!-- child Component 시작 -->
      <style>
          .buttonstyle {
              width: 120px;
              height: 30px;
              text-align: center;
          }
      </style>
      <template id="childTemplate">
          <div>
              <button class="buttonstyle" v-on:click="clickEvent" 
                  v-bind:data-lang="buttonInfo.value">{{ buttonInfo.text }}</button>
          </div>
      </template>
      <script type="text/javascript">
          Vue.component('child-component', {
              template: '#childTemplate',
              props: ['buttonInfo'],
              methods: {
                  clickEvent: function(e) {
                      this.$emit('timeclick', e.target.innerText, e.target.dataset.lang);
                  }
              }
          })
      </script>
      <!-- child Component 끝 -->
      <!-- parent Component 시작 -->
      <template id="parent-template">
          <div>
              <child-component v-for="s in buttons" v-bind:button-Info="s" 
                  v-on:timeclick="timeclickEvent">
              </child-component>
              <hr />
              <div>{{ msg }}</div>
          </div>
      </template>
      <script type="text/javascript">
          Vue.component('parent-component', {
              template: '#parent-template',
              props: ['buttons'],
              data: function() {
                  return {
                      msg: ""
                  };
              },
              methods: {
                  timeclickEvent: function(k, v) {
                      this.msg = k + ", " + v;
                  }
              }
          })
      </script>
      <!-- parent Component 끝 -->
      
      <body>
          <div id="app">
              <parent-component v-bind:buttons="buttons"></parent-component>
          </div>
      </body>
      <script type="text/javascript">
          Vue.config.devtools = true;
          var vm = new Vue({
              el: "#app",
              data: {
                  buttons: [{
                      text: "Hello",
                      value: "영어"
                  }, {
                      text: "씬짜오",
                      value: "베트남어"
                  }, {
                      text: "니하오",
                      value: "중국어"
                  }]
              }
          })
      </script>
      
      </html>




## 같은 레벨의 컴포넌트 간 통신

 - Vue는 상위에서 하위로만 데이터를 전달해야 하는 통신 규칙을 따르기 때문에 바로 옆 컴포넌트에 값을 전달하려면 하위에서 공통 상위 컴포넌트로 이벤트를 전달한 후 공통 상위 컴포넌트에서 2개의 하위 컴포넌트에 props를 내려 보내야 합니다. (컴포넌트 고유의 유효 범위 때문)
   
- 이벤트 버스(Event Bus)는 개발자가 지정한 2개의 컴포넌트 간에 데이터를 주고받을 수 있는 방법
   
- 이벤트 버스를 구현하려면 애플리케이션 로직을 담는 인스턴스와는 별개로 **새로운 인스턴스 1개를 생성하고, 새 인스턴스를 이용하여 이벤트를 보내고 받습니다.**

- 보내는 컴포넌트에서는 .$emit()을, 받는 컴포넌트에서는 .$on()
![enter image description here](https://github.com/src8655/cafe24_6/blob/master/2.VUE.JS/%EC%9C%A4%EB%AF%BC%ED%98%B8/20190502/img/img02.JPG?raw=true)

- 

    <!DOCTYPE html>
    <html>
    
    <head>
        <meta charset="utf-8">
        <title>06-24</title>
        <script src="https://unpkg.com/vue/dist/vue.min.js"></script>
    </head>
    <!-- 이벤트 버스 객체 -->
    <script type="text/javascript">
        var eventBus = new Vue();
    </script>
    <!-- 첫번째 자식 컴포넌트 시작-->
    <template id="chidl1Template">
        <div>
            <button v-on:click="clickEvent">child1 button!!</button>
            <div>{{currentTime}}</div>
        </div>
    </template>
    <script type="text/javascript">
        Vue.component('child1-component', {
            template: '#chidl1Template',
            data: function() {
                return {
                    currentTime: ''
                };
            },
            methods: {
                clickEvent: function() {
                    var d = new Date();
                    var t = d.toLocaleTimeString() + " " + d.getMilliseconds() + "ms";
                    eventBus.$emit('click1', t);
                    this.currentTime = t;
                }
            }
        });
    </script>
    <!-- 첫번째 자식 컴포넌트 끝-->
    <!-- 두번째 자식 컴포넌트 시작-->
    <template id="chidl2Template">
        <ul>
            <li v-for="t in timelist">{{t}}</li>
        </ul>
    </template>
    <script type="text/javascript">
        Vue.component('child2-component', {
            template: '#chidl2Template',
            data: function() {
                return {
                    timelist: []
                };
            },
            created: function() {
                eventBus.$on('click1', this.child1Click);
            },
            methods: {
                child1Click: function(time) {
                    this.timelist.push(time);
                }
            }
        });
    </script>
    <!-- 두번째 자식 컴포넌트 끝-->
    
    <body>
        <div id="app">
            <child1-component></child1-component>
            <hr />
            <child2-component></child2-component>
        </div>
    </body>
    <script type="text/javascript">
        Vue.config.devtools = true;
        var vm = new Vue({
            el: "#app"
        })
    </script>
    
    </html>


