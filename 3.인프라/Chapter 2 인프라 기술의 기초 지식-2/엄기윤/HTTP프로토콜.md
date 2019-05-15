# http 란

 - 인터넷에서 데이터를 주고 받을 수 있는 프로토콜 (데이터 통신을 원활하게 하기 위한 규약)

# request 란

 - 클라이언트가 서버에 하는 요청

# response 란

 - 서버에서 클라이언트에 보내는 응답

### request  구성
 - 시작줄
 
 ex> GET htp://www.zerocho.co HTTP/1.1
 - 헤더
 
	**공통헤더**
	
	  Date : 메시지가 만들어진 시간
	  
	  Connection : 연결상태
	  
	  Cache-Control
	  
	  Content-Length : 본문의 크기
	  
	  Content-Type: 컨텐츠 타입과(ex:text/html) 문자열
	  
	  Content-Language: 사용자 언어
	  
	  Content-Encoding: 컨텐츠 압축 방식(ex:gzip,deflate)
	  
	**요청헤더**
	
	   User-Agent : 어떤 운영체제, 브라우저인지
	   
	   **Accept: 원하는 데이터 타입**
	   
   -   Accept-Charset: utf-8  
   
   -    Accept-Language: ko, en-US  
   
    -   Accept-Encoding: br, gzip, deflate
	

	 Authorization : 인증토큰
	 
	 Origin: 어느 주소에서 요청이 시작되었는지
	 
	 Referer : 어떤페이지를 경유해서 왔는지
	 

- 본문




### response 구성

 - 응답헤더
 

	  Access-Control-Allow-Origin : 보내는 주소와 받는 주소사이가 다르면 발생하는 에러(CORS)
	  
		 Allow : 자신이 원하는 메소드가 무엇인지 알려줌
		 
	 Content-Disposition: 응답본문을 브라우저가 어떻게 표시하는지 알려줌
	 
	Content-Security-Policy:  외부파일을 불러오는 경우(자바스크립트,css 같은) 차단할 소스와 불러올 소스를 명시 
	
ex)Content-Security-Policy: default-src 'self'



메서드 ? 

**GET, POST(입력), PUT(전체수정), PATCH(부분수정), DELETE 등등**

cors? 

XMLHttpRequest는 smae origin 정책을 따르기 때문에 같은 도메인에서만 http 요청이 가능


ex)
어노테이션


    @RequestMapping(value = "/cfm/userAcceptcheckValve/{constNo}/{facNo}", method = RequestMethod.PUT, consumes="application/json")

xml 설정
   

     <!-- Restful 설정 -->
            <!-- Spring MVC를 통해 구현한 RESTful은 리소스에 대한 접근을 URI를 이용하며, --> 
            <!-- HTTP의 PUT, GET, POST, DELETE 등과 같은 메소드의 의미를 그대로 사용하므로, 단순하게 접근 -->    
        	
    
        <servlet-mapping>
            		<servlet-name>action</servlet-name>
            		<url-pattern>/</url-pattern>
            	</servlet-mapping>
                
                <filter>
            		<filter-name>httpMethodFilter</filter-name>
            		<filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
                </filter>
                <filter-mapping>
            		<filter-name>httpMethodFilter</filter-name>
            		<url-pattern>/*</url-pattern>
                </filter-mapping>
                <!-- Restful 설정  (END)-->


cors? 
XMLHttpRequest는 smae origin 정책을 따르기 때문에 같은 도메인에서만 http 요청이 가능