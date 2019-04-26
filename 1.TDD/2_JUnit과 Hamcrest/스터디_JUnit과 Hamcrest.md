# 2.JUnit과 Hamcrest (이동규)  

*Hamcrest를 쓰는 이유*
- 객체 안의 값 찾기, 문자열 안의 특정 값 찾기 등의 좀 더 다양한 판단조건이 필요한 경우 혼란함을 줄여주기 위해 사용.
- 이해하기 쉬운 문장을 만들 수 있다.


## 2.1 JUnit  
- 에릭 감마와 켄트 벡이 만든 Java 단위 테스트 프레임워크다. 
- TDD의 근간이 되는 프레임워크이며,  xUnit 시리즈 1 라고 불리는 다양한 단위 테스트 프레임워크들의 기원이 되는 프레임워크다

JUnit  기본기능
-  **단정문(assertions)** - 판별
-- assertEquals, assertTrue, assertFalse
-- assertNull, assertNotNull, fail
- **테스트 픽스처(test fixture)*** - 동일한 환경 
 -- setup,tearDown
- **테스트 러너(test runner)** - 테스트 작업의 수행

assertEquals() 메소드 구현소스(**생각해보기**)
```java
static public void assertEquals(String message, Object expected, Object actual) {
		if (expected == null && actual == null)
			return;
		if (expected != null && expected.equals(actual))
			return;
		failNotEquals(message, expected, actual);
	}
```
assertSame이 쓰이는 경우
- 동일 객체임을 증명( 객체의 주소 비교)
- 싱글톤으로 만들어진 객체 비교

등호비교(assertTrue, assertFalse)보다 assertEquals 사용권장
- 예) assertTrue(account. getBalance() == 0)
- 실패 시 account.getBalance()의 값을 바로 알 수 없다. 

fail() 메소드는 언제 사용하는가?
- 테스트 케이스를 작성 중 완료하지 못한 채 구현을 중단해야 하는 경우 끝 부분에 fail()을 추가
- 특정 조건에서 예외가 발생해야 정상인 경우
- ```java 
		Account account = new Account(10000);
		try {
		account.withdraw(20000); 
		fail();
		} catch (OverWithdrawRequestException e){
			assertTrue(true); 
		}
> ***'검증코드를 먼저 만들어 둔다 '*** 는 정책과 반대로 ***기존에 작성되어 있는 코드**일 경우
해당 클래스를 지정하여 선언되어 있는 메소드의 테스트를 자동으로 만드는 경우도 있다.


JUnit 3 과 JUnit 4의 차이
- JUnit 3는 TestCase를 상속하여 메소드를 오버라이딩하는 방식
- JUnit 4는 어노테이션을 통한 방식
- JUnit 4 버전대 중반 이후 Hamcrest도입(비교 표현 쉽게)

JUnit 3 기본 골격
```java 
public class NetworkTest extends TestCase {
		private Connection connection;

		public void setUp() throws Exception {
			connection = new Connection("127.0.0.1");
		}

		public void testSendMessage() throws Exception {
		}
		
		public void tearDown() throws Exception {
			connection.close();
		}
	}
```
JUnit4 기본 골격
```java
public class TerminalTest {
	private static Terminal term;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		term = new Terminal();
		term.netConnect(); 
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		term.netDisconnect(); 
	}

	@Before
	public void setUp() throws Exception {
		term.logon("guest", "guest"); 
	}

	@After
	public void tearDown() throws Exception {
		term.logoff(); 
	}

	@Test 
	public void testTerminalConnected() throws Exception {
		assertTrue(term.isLogon());
		System.out.println("== logon test");
	}
}
```

JUnit 4의 특징(***생각해보기***)
1. Java 5 애노테이션 지원 
2. test라는 글자로 method 이름을 시작해야 한다는 제약 해소 
3. 좀 더 유연한 픽스처 - @Before, @After, @BeforeClass,  @AfterClass 등)
4. 예외 테스트 - @Test(expected=NumberFormatException.class) 
5. 시간 제한 테스트 - @Test(timeout=1000) 
6. 테스트 무시 - @Ignore("this method isn't working yet") 
7. 배열 지원 - assertArrayEquals([message], expected, actual); 
8. @RunWith(클래스이름.class) - 러너(Runner)를 명시적으로 지정
9. @SuiteClasses(Class[]) - 여러 개의 테스트 클래스를 수행
10. 파라미터를 이용한 테스트

@BeforeClass, @AfterClass 이 @Before, @After과 다른점
> -- @BeforeClass, @AfterClass  테스트 클래스 내에서 한 번만 실행하는 메소드
-- @Before, @After는 테스트케이스 개수만큼 실행하는 메소드

배열 지원 시 주의 사항
-- 배열 원소의 자리 순서 기준으로 equals 비교가 이뤄지기 때문에 비록 배열 안의 값 집합 은 동일하더라도 순서가 다르면 테스트가 실패

여러 개의 테스트 클래스를 일괄적으로 수행할 때 JUnit 버전별 차이

```java
	// JUnit 4
	@RunWith(Suite.class)
	@SuiteClasses(ATest.class, BTest.class, CTest.class)
	public class ABCSuite {
	}
```
```java
	// JUnit 3
	public class ABCSuite extends TestCase {
		public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(ATest.class);
		suite.addTestSuite(BTest.class);
		suite.addTestSuite(CTest.class);
		}
	}
```

JUnit 4의 불편한점 
-- TestCase 상속 대신에 애노테이션을 사용하기 때문에 모든 기본 메소드 static import로 지정하지 않으면 쓸 수가 없다. Matcher lib까지 쓰면 2줄은 의무적으로 명시.
```java 
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
```

## 2.2 비교표현의 확장: Hamcrest
 - Hamcrest(햄크레스트)는 jMock이라는 Mock 라이브러리 저자들이 참여해 만들고 있 는 Matcher 라이브러리
 - JUnit 버전 4.4부터는 JUnit 배포 라이브러리 안에 포함

***assertEquals 대신에 assertThat이라는 구문 사 용을 권장한다***

> ```java 
> assertEquals( "YoungJim", customer.getName() );
> assertThat( customer.getName(), is("YoungJim") );


