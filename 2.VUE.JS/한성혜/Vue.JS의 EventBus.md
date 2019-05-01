# Vue.JS의 EventBus

Vue에서 이벤트를 쉽게 다루기 위한 방법.

```javascript
//이벤트버스 생성
let EventBus = new Vue();

//이벤트 발행
EventBus.$emit('message', 'hello World');

//이벤트 구독
EventBus.$on('message', function(text) {
    console.log(text);
});
```



### 컴포넌트간 이벤트 주고 받기

