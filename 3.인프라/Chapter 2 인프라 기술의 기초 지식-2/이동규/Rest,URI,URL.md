
## REST API(***Representational State Transfer***)
- 네트워크 아키텍처 원리의 모음
-- 자원을 정의하고 자원에 대한 주소를 지정하는 방법
-  별도의 전송 계층 없이 전송하기 위한 아주 간단한 인터페이스
- CRUD를 HTTP Method(POST, GET, PUT, DELETE)로 구분
## REST의 구성 요소
- HTTP URI = 자원
- HTTP Method = 행위
- MIME Type = 표현 방식

## REST 의 제한 조건
- 클라이언트/서버 구조: 일관적인 인터페이스로 분리되어야 한다
- 무상태(Stateless): 각 요청 간 클라이언트의 데이터가 서버에 저장되어서는 안 된다
- 캐시 처리 가능(Cacheable): 클라이언트는 응답을 캐싱할 수 있어야 한다. (잘 관리되는 캐싱은 클라이언트-서버 간 상호작용을 부분적으로 또는 완전하게 제거하여 scalability와 성능을 향상시킨다.)
 - 계층화(Layered System): 클라이언트는 보통 대상 서버에 직접 연결되었는지, 또는 중간 서버를 통해 연결되었는지를 알 수 없다. 중간 서버는 로드 밸런싱 기능이나 공유 캐시 기능을 제공함으로써 시스템 규모 확장성을 향상시키는 데 유용하다.
- 인터페이스 일관성: 아키텍처를 단순화시키고 작은 단위로 분리(decouple)함으로써 클라이언트-서버의 각 파트가 독립적으로 개선될 수 있도록 해준다..

## REST 인터페이스의 원칙에 대한 가이드
- 자원의 식별
- 메시지를 통한 리소스의 조작
	- 클라이언트가 어떤 자원을 지칭하는 메시지(URI)와 특정 메타데이터(METHOD)



## URI와 URL의 차이점
URI(Uniform Resource Identifier) 와 URL(Uniform Resource Locator)
- 과거 웹에선 HTML 파일을 주고 받았기 때문에 URL이 위치를 가리키며 곧 유일한 것을 의미
-  다만 현재에 와서는 URL만으로는 유일한 식별자의 의미를 갖기 어려워졌음. 
-  URI는 더 넒은 의미의 identify한 개념. 즉, 식별자의 의미를 가진 여러 자원들도 포함하는 개념


참고
[https://meetup.toast.com/posts/92](https://meetup.toast.com/posts/92)
[https://spoqa.github.io/2012/02/27/rest-introduction.html](https://spoqa.github.io/2012/02/27/rest-introduction.html)