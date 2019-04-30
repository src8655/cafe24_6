
#  인스턴스 옵션 
## computed Vs method

## computed  Vs watch

## 


#  인스턴스  라이프사이클

## beforeCreate
> 가장 처음에 실행 되는 라이프 사이클 data와 methods 속성들이 만들어지기 전
## created  &#128525;
> data와 methods 속성이 정의 됨, 하지만 화면 편집은 불가능. ex) data를 처음 가지고 올 때 많이 사용함. vuex를 쓴다면 DB에서 필요한 내용을 처음에 이곳에서 호출 한다
## beforeMount
> render() 함수가 호출되기 직전. 화면이 만들어 지기 직전. 컴포넌트는 호출 가능 하나 충돌의 가능성이 있다.
## mount &#128525;
> 화면에 인스턴스가 부착되고 호출.
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
