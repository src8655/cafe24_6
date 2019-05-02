

## 같은 레벨의 컴포넌트 간 통신

 - Vue는 상위에서 하위로만 데이터를 전달해야 하는 통신 규칙을 따르기 때문에 바로 옆 컴포넌트에 값을 전달하려면 하위에서 공통 상위 컴포넌트로 이벤트를 전달한 후 공통 상위 컴포넌트에서 2개의 하위 컴포넌트에 props를 내려 보내야 합니다. (컴포넌트 고유의 유효 범위 때문)
   
- 이벤트 버스(Event Bus)는 개발자가 지정한 2개의 컴포넌트 간에 데이터를 주고받을 수 있는 방법
   
- 이벤트 버스를 구현하려면 애플리케이션 로직을 담는 인스턴스와는 별개로 **새로운 인스턴스 1개를 생성하고, 새 인스턴스를 이용하여 이벤트를 보내고 받습니다.**

- 보내는 컴포넌트에서는 .$emit()을, 받는 컴포넌트에서는 .$on()
- 

	<!DOCTYPE  html>
	<html>
	<head>
		<meta  charset="utf-8">
		<title>06-14~15</title>
		<script  src="https://unpkg.com/vue/dist/vue.min.js"></script>
	</head>
	<body>
	<div  id="app">
		<child-component></child-component>
	</div>
	</body>

	<script  type="text/javascript">
		// 이벤트 버스를 위한 추가 인스턴스 1개 생성
		var  eventBus = new  Vue();
		
		// 이벤트를 보내는 컴포넌트 .$emit

		Vue.component('child-component', {
			template:  '<div>하위 컴포넌트 영역입니다. <button v-on:click="showLog">show</button></div>',
			methods: {
				showLog:  function() {
				eventBus.$emit('triggerEventBus', 100);
				}
			}
		});

		// 이벤트를 받는 컴포넌트 .$on
		var  app = new  Vue({
			el:  '#app',
			created:  function() {
				eventBus.$on('triggerEventBus', function(value) {
					console.log("이벤트를 전달받음. 전달받은 값: ", value);
				});
			}
		});
	</script>
	</html>
