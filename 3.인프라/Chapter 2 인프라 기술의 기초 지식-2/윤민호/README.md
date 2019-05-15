### 프로토콜
**Request Messages**

	- 요청라인 Get(요청방식) /view.html HTTP/1.0
	- 요청헤더 user-agent : 컴퓨터 사양
	- Accept : 의미가없다
    - Cookie:name = value
    - Referer : 경유지, 클릭을 할때 현재 있는 위치의 값이 들어간다
    - Host : 어떤 서버??
    - 공백라인 ,, 공백라인 항상 들어간다 /r/n
    - 메시지 본문


**Method**

**요청라인에서 요청방식의 종류**

**GET** : **요청라인을 통해**서 자원요청,

    -> 쉽게 엽서라고 생각하면 된다. 엽서는 내용이 다보이기 때문
    또한 4096바이트만 전달이 가능하므로 데이터에 제한이 있다.

**POST** : **메시지 본문을 통해** 자원요청

    -> 우편봉투라고 생각하면 된다. 어디로 가는지는 알지만 내용은 볼수 없기 때문이다
    또한 POST방식은 데이터에 제한이 없다

   ![enter image description here](https://raw.githubusercontent.com/src8655/cafe24_6/master/3.%EC%9D%B8%ED%94%84%EB%9D%BC/Chapter%202%20%EC%9D%B8%ED%94%84%EB%9D%BC%20%EA%B8%B0%EC%88%A0%EC%9D%98%20%EA%B8%B0%EC%B4%88%20%EC%A7%80%EC%8B%9D-2/%EC%9C%A4%EB%AF%BC%ED%98%B8/img/img03.JPG)


![enter image description here](https://raw.githubusercontent.com/src8655/cafe24_6/master/3.%EC%9D%B8%ED%94%84%EB%9D%BC/Chapter%202%20%EC%9D%B8%ED%94%84%EB%9D%BC%20%EA%B8%B0%EC%88%A0%EC%9D%98%20%EA%B8%B0%EC%B4%88%20%EC%A7%80%EC%8B%9D-2/%EC%9C%A4%EB%AF%BC%ED%98%B8/img/img04.JPG)
![enter image description here](https://raw.githubusercontent.com/src8655/cafe24_6/master/3.%EC%9D%B8%ED%94%84%EB%9D%BC/Chapter%202%20%EC%9D%B8%ED%94%84%EB%9D%BC%20%EA%B8%B0%EC%88%A0%EC%9D%98%20%EA%B8%B0%EC%B4%88%20%EC%A7%80%EC%8B%9D-2/%EC%9C%A4%EB%AF%BC%ED%98%B8/img/img05.JPG)

### 성능과 데이터에 관한 기초 지식

> - ACID
> - Atomicity 원자성
> - Consistency 일관성
> - Isolation 독립성
> - Durability 지속성

> 를 지키기 위한 기술

> 　　　↓

### 락과 배타처리
	=> 어떤 처리가 자원을 사용하고 있으면 다른 처리가 그 자원을 사용하지 못하게 하는 것
	=> I/O나 DB조작에 사용되고 있음
	=> 데이터의 정합성에는 좋으나 병렬성이 높아지지 않아 성능향상이 어렵다


### 버퍼, 캐시, 큐잉 => 병목현상을 완화하는 기술

### 버퍼

> - 다음 단계의 처리를 효율화하기 위해 데이터를 일시적으로 모아두는 곳
> - 	=> 주로 디스크나 네트워크의 입출력에 사용

### 캐시

> 계산된 결과를 일시적으로 보관하는 곳으로 계산식이 같으면 보관된 결과를 재사용할 수 있다.

### 큐잉

> CPU에게 처리해야할 일을 주고 결과를 기다리지 않고 처리 큐로 보내놓고 다음 처리로 넘어가는 비동기 방식

### 다중화의 구조

> - 다중화한 경우 같은 데이터가 여러 개 존재한다 라는 것 
> => 다중화의 주의할 점 : 어떤 데이터가 가장 최신이고 올바른 것인지 관리해야 한다.


### Shared Disk방식과 Shared Nothing방식

- Shared Disk방식 : 복수의 컴퓨터가 한 개의 저장소를 사용
- Shared Nothing방식 : 문자 그대로 ‘아무것도 공유하지 않는다’로 모든 자원을 분리
- 　　　　　　　　　　　　=> 스토리지 간 통신(리플리케이션)을 하여 데이터 정합성을 확보한다.



### Shared Nothing방식의 동기식과 비동기식 리플리케이션
- 동기식 : Master와 Slave 가 일관성 있게 최신 데이터를 가지는 것을 보장하는 것

    - 장점 : Master가 작동하지 않아도 데이터는 Slave에서 계속 사용할 수 있음.
    
    - 단점 : Slave가 응답이 없으면 쓰기가 처리되지 않는다. Master는 모든 쓰기를 차단(block)하고, 복제 서버를 다시 사용할 수 있을 때까지 기다려야 한다.

- 비동기식 : 정해진 매 시간마다 일괄 복제한다.

	- 장점 : 성능 저하의 정도가 낮다
	
	- 단점 : Master가 작동하지 않으면 복제 주기의 시간만큼 데이터 손실이 발생될 수 있다.



> ![enter image description here](https://raw.githubusercontent.com/src8655/cafe24_6/master/3.%EC%9D%B8%ED%94%84%EB%9D%BC/Chapter%202%20%EC%9D%B8%ED%94%84%EB%9D%BC%20%EA%B8%B0%EC%88%A0%EC%9D%98%20%EA%B8%B0%EC%B4%88%20%EC%A7%80%EC%8B%9D-2/%EC%9C%A4%EB%AF%BC%ED%98%B8/img/img01.JPG)


> ![enter image description here](https://raw.githubusercontent.com/src8655/cafe24_6/master/3.%EC%9D%B8%ED%94%84%EB%9D%BC/Chapter%202%20%EC%9D%B8%ED%94%84%EB%9D%BC%20%EA%B8%B0%EC%88%A0%EC%9D%98%20%EA%B8%B0%EC%B4%88%20%EC%A7%80%EC%8B%9D-2/%EC%9C%A4%EB%AF%BC%ED%98%B8/img/img02.JPG)



### 암호화와 해시화

### 암호화 : 복호화할 수 있다 = 원래대로 되돌릴 수 있다.
	- 공통키 방식 : 패스워드를 거는 방식
	- 공개키 방식 : 암호화에 필요한 키와 복호화에 필요한 키를 다르게 하는  방식

### 해시화 : 복호화할 수 없다 = 원래대로 되돌릴 수 없다.
	해시화를 하면 해시화 이전의 상태를 유추할 수 없다
		=> 똑같은 데이터는 해시화를 해도 똑같다는 점을 이용하여 사용
			=> 해시화의 방식에 따라서 충돌이 일어날 가능성이 없지 않다.
