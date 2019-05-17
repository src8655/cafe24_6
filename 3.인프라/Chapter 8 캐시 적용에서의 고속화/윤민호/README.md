
### 프록시

    - 컴퓨터 네트워크에서 다른 서버로의 자원 요청을 중계하는 서버
    - 클라이언트로부터 원격에 요청된 자원들이 캐시되어 임시로 저장되어 있다
    - 데이터 전송 시간과 외부 트래픽이 줄어들고 서버 측의 네트워크 병목 현상을 방지할 수 있다. 
### 
    - 무엇을 캐시할 것인가
    - 무엇을 키로 하여 캐시를 이용해도 좋다고 판단할 것인가


### 캐시의 가능성 고려 여부의 예

> (사용자 에이전트 : 사용자를 대신하여 일을 수행하는 소프트웨어 에이전트
> 여기서 '사용자를 대신하여 일을 수행하는 소프트웨어'는 대개 웹 브라우저를 뜻한다. )
> 
![enter image description here](https://raw.githubusercontent.com/src8655/cafe24_6/master/3.%EC%9D%B8%ED%94%84%EB%9D%BC/Chapter%208%20%EC%BA%90%EC%8B%9C%20%EC%A0%81%EC%9A%A9%EC%97%90%EC%84%9C%EC%9D%98%20%EA%B3%A0%EC%86%8D%ED%99%94/%EC%9C%A4%EB%AF%BC%ED%98%B8/img/img01.JPG)

- PC 사이트, 스마트폰 사이트를 동일한 URL, 동일한 소스에서 제공하고, 서버 측에서 사용자 에이전트 등의 판별을 하지 않는 경우
	-> 캐시가능
- PC 사이트, 스마트폰 사이트를 동일한 URL, 동일한 소스에서 제공하고, 서버 측에서 사용자 에이전트에 따라 콘텐츠를 나누고 있는 경우
	-> 캐시는 가능하지만 키에 사용자 에이전트를 추가할 필요가 있음
- 로그인 기능이 있고, 모든 사용자가 '/mypage/profile'에 액세스하면 각자 자신의 프로필 이미지를 얻을 수 있는 경우
	-> 캐시하지 않는 편이 좋다
	-> 사용자를 식별하는 ID를 세션ID로 사용할 경우 URL과 세션을 키로 하여 사용할 수 있지만 세션ID가 재사용 될 경우 다른 사람에게도 프로필이 보여질 위험이 있다.

### 캐시하는 조건들
- URL에 대해 CacheDisable이 아닌 CacheEnable로 캐시가 유효화 되어있다.
- 서버로부터 응답이 200, 203, 300, 301, 410중 하나이다.
- 클라이언트 요청이 GET이다.
- 서버로부터 응답에 'Authorization'헤더를 포함하지 않는다.
- 클라이언트 요청URL에 쿼리 문자열을 포함하지 않는 경우
- 서버로부터 응답이 Cache-Control: private나 no-store이 아닌 경우

### Vary 헤더

![enter image description here](https://raw.githubusercontent.com/src8655/cafe24_6/master/3.%EC%9D%B8%ED%94%84%EB%9D%BC/Chapter%208%20%EC%BA%90%EC%8B%9C%20%EC%A0%81%EC%9A%A9%EC%97%90%EC%84%9C%EC%9D%98%20%EA%B3%A0%EC%86%8D%ED%99%94/%EC%9C%A4%EB%AF%BC%ED%98%B8/img/img01.JPG)

- 하나의 웹컨텐츠를 데스크톱과 모바일에서 서로 다르게 보여줘야 할 경우 Vary 헤더를 사용하게 되면 캐시서버에게 캐싱정책을 가이드 할 수 있다.
- 캐시 키는 기본적으로 URL이지만 응답 vary 헤더에 User-Agent 라고 되어있다면 URL+User-Agent를 캐시키로 한다.

![enter image description here](https://raw.githubusercontent.com/src8655/cafe24_6/master/3.%EC%9D%B8%ED%94%84%EB%9D%BC/Chapter%208%20%EC%BA%90%EC%8B%9C%20%EC%A0%81%EC%9A%A9%EC%97%90%EC%84%9C%EC%9D%98%20%EA%B3%A0%EC%86%8D%ED%99%94/%EC%9C%A4%EB%AF%BC%ED%98%B8/img/img03.JPG)
