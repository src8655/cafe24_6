
# 3.TDD 잘사용하기

## test class 위치


 

 ***1. 같은 클래스에 위치***
 
 ![enter image description here](https://github.com/src8655/cafe24_6/blob/master/1.TDD/3_TDD%20%EC%A2%80%20%EB%8D%94%20%EC%9E%98%ED%95%98%EA%B8%B0/img/sameClass.PNG?raw=true)
 

 - 장점
	 - 테스트 클래스 찾기가 쉽다

 - 단점
	 - 배포 시 테스트 클래스를 빼줘야 한다

 ***2. 하위 패키지에 위치***
 
![enter image description here](https://github.com/src8655/cafe24_6/blob/master/1.TDD/3_TDD%20%EC%A2%80%20%EB%8D%94%20%EC%9E%98%ED%95%98%EA%B8%B0/img/underPackage.PNG?raw=true)

 - 장점
	 - 테스트 코드가 가까운 곳에 위치한다
 -   단점
	 - 하위 패키지들이 많으면 혼란 스럽다, 테스트 클래스를 분리해서 배포 해야한다
	 

 ***3. 다른 패키지로 분리***
 
![enter image description here](https://github.com/src8655/cafe24_6/blob/master/1.TDD/3_TDD%20%EC%A2%80%20%EB%8D%94%20%EC%9E%98%ED%95%98%EA%B8%B0/img/devicePakage.PNG?raw=true)

 - 장점
	 - 테스트 코드를 분리하기 쉽다
 - 단점
	 - 접근 제어자에 따라 테스트가 제한 된다

  
	
 ***4. 소스 폴더 다르게***

![enter image description here](https://github.com/src8655/cafe24_6/blob/master/1.TDD/3_TDD%20%EC%A2%80%20%EB%8D%94%20%EC%9E%98%ED%95%98%EA%B8%B0/img/deviceFolder.PNG?raw=true)

 - 장점
	 - 배포가 간편하다, 접근제어자와 상관없이 테스트 할 수 있다
 - 단점
	 - 환경구성이 이클립스에 의존적이다

 ***5. 메이븐 스타일***
 
![mvn-dir.gif](http://www.egovframe.go.kr/wiki/lib/exe/fetch.php?cache=&w=900&h=435&media=egovframework:dev:dep:build:mvn-dir.gif)

 - 장점

	 - 리소스를 분리해서 관리하기 편하다
 - 단점
	 - maven 선행학습이 되어야 한다

 ***6. 프로젝트로 분리***
 
 ![enter image description here](https://github.com/src8655/cafe24_6/blob/master/1.TDD/3_TDD%20%EC%A2%80%20%EB%8D%94%20%EC%9E%98%ED%95%98%EA%B8%B0/img/deviceProject.PNG?raw=true)
 

 - 장점

	 - 의존관계가 분리된다. 배포가 편함

 - 단점

	 - 이클립스에 의존적이다

## test 메소드 작성 방식

 ***1. 이름일치***
 
 대상 코드와 테스트 코드의 이름을 일치 시킨다

    public int getBalance( ) { … } // 테스트 대상 코드
    
    @Test 
    public void testGetBalance( ){ … } // 테스트 코드
    
    ///////////////////////추천방법/////////////////////////
    
    public void withdraw(int money) {… } // 테스트 대상 코드
    
    @Test 
    public void testWithdraw_잔고가0원일때( ){ … } // 테스트 코드
   

 ***2. 시나리오 집중***
 
메소드를 대상으로 하기 보다 테스트 시나리오를 가지고 테스트 코드를 만든다

    public class 환승테스트 { 
		   //시간의 흐름을 따라가듯이 테스트
		    @Test 
		    public void 평일_30분이내에_환승_성공한다(){ // 테스트 케이스 } 
		    @Test 
		    public void 평일_30분이후에_환승_실패한다(){ // 테스트 케이스 }
		     @Test 
		    public void 평일_1시간이내에_환승_성공한다(){ // 테스트 케이스 } 
		    @Test 
		    public void 평일_1시간이후에_환승_실패한다(){ // 테스트 케이스 }
	    }
	    
	 

## 테스트 케이스 접근 방식

 1. ***설계자와 개발자가 분리된 경우***
	 * 설계자가 테스트 케이스를 작성해서(시나리오 형태) 개발자에게 넘긴다
	 
 2. ***설계자와 개발자가 같읕 경우***
	 * 개발자가 사용자 스토리를 작성해서 테스트 케이스를 만든다 

* 해피데이 시나리오 : 정상적인 흐름일 때 동작해야하는 결과값 선정
* 블루데이 시나리오 : 예외나 에러 상황에 대한 결과값 선정
* 삼각측량법 : ex) a+ b ,  A x C
* 에지 케이스 : 양수, 음수, 가장 큰 값, 소수점 등
**

> **결함의 종류 참조**

 ![enter image description here](https://github.com/src8655/cafe24_6/blob/master/1.TDD/_%EC%B0%B8%EA%B3%A0%EC%9E%90%EB%A3%8C/1%EC%A3%BC%EC%B0%A8%20%EC%B0%B8%EA%B3%A0%EC%9E%90%EB%A3%8C.jpg?raw=true)

## TDD 한계

 ***1. 동시성 문제***
 
 	동시성이 걸려있는 코드는 테스트 자체를 무결하게 유지하기 어렵다
 
	 ex) 채팅 프로그램
	 
 ***2. 접근제한자***
 
	 private로 되어있는 메소드는 테스트 하기 어렵다. 
	 
 ***3. GUI***
 
	 Front-end 변수가 너무 많음 
	 
	 ex)  게시판에 글을 남기고 다른 글을 수정했는데 같이 수정된다
	 
 ***4. 의존성***
 
	혼자 수행되는 것이 아닌 다른 모듈과 함께 수행되는 경우
	
	ex)	비밀번호를 캐쉬에 저장하는 메소드를 테스트 하고 싶은데 로그인하는 부분에 접근이 어렵다
	
