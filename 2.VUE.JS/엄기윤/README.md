
#  인스턴스 옵션 
## computed Vs method
> 

 - 둘다 함수처럼 사용

  >

 - 화면이 다시 render() 될 때 computed는 변한 값이 없으면 계산 안함, method는 항상 실행

  > 

 - computed는 변수 처럼 사용

  >

 - method는 함수처럼 사용


## computed  Vs watch
>

 - 둘다 값이 변화 되었을 때 반응하는 것은 맞지만 watch는 함수를 지정 할 수 있다.

>

 - computed는 결과값을 반환하기 위해 사용

> 

 - watch는 비동기 작업에 많이 사용

> 

 - watch 보다는 computed를 많이 사용하는 것이 좋다

#  인스턴스  라이프사이클

## beforeCreate
> 가장 처음에 실행 되는 라이프 사이클 data와 methods 속성들이 만들어지기 전
## created  &#128525;
> data와 methods 속성이 정의 됨, 하지만 화면 편집은 불가능. ex) data를 처음 가지고 올 때 많이 사용함. vuex를 쓴다면 DB에서 필요한 내용을 처음에 이곳에서 호출 한다

    var app = new Vue({
					    data: {name:'kiyun'},
					    methods: {
								...
							}
				    )}

## beforeMount
> render() 함수가 호출되기 직전. 화면이 만들어 지기 직전. 컴포넌트는 호출 가능 하나 충돌의 가능성이 있다.
## mount &#128525;
> 화면에 인스턴스가 부착되고 호출(el 사용 가능).
> `var app = new Vue({
	> 		el: '#app'
> })`
> 하지만 외부 라이브러리를 사용한 화면 요소들은 적용 안될 수 있음
## beforeUpdate
> 화면을 다시 그리는 시점에서 다시 그리기 직전. 가상돔이 만들어지는 시점(?). 데이터의 변화를 감지한 시점
## update &#128525;
> 화면이 다시 그려지고난 직후
## beforeDestroy
>> destroyed 직전에 호출
## destroyed
>> 인스턴스가 destroy 되고 난 후 호출
 
ex)

    document.body.removeEventListener('click', funcion);
