**8.1 TDD가 주는 설계상의 이점**

 - TDD로 개발을 하는데 다른 모듈에 의존성이 많아지면 적절한 테스트 케이스를 작성하기가 점점 어려워지기 때문에 개발자가
   스스로 모듈의 의존성을 줄이려는 노력을 초반부터 해나가게 된다.

**TDD와 객체 지향 프로그래밍(OOP)**

> ![enter image description
> here](https://github.com/src8655/cafe24_6/blob/master/1.TDD/%EC%9C%A4%EB%AF%BC%ED%98%B8/img/img_01.JPG?raw=true)

 - TDD로 작성을 하게 되면 이런 식으로 기능과 객체의 관계를 스스로 먼저 고민하게 되는데getTotalMeasure 메소드는 기능이 Stock 클래스에 의존하고 있음을 알게 된다. 의존관계를 없애기 위해 해당 기능을 Stock 클래스를 테스트하는 것으로 변경해야겠다는 생각을 하게 되고 **낮은 결합도를 가진 모듈화가 강조되는 OOP의 기본 원칙에 충실해진다.**

**계약에 의한 설계 :　고객 요구사항에 의해 설계**

> ‘**선언적인 형태로 프로그램의 상태를 구분해놓고**, 이를 통해 작성된 로직의 간결성을 유지하면서도 **작성자의 의도를 명확히 전달한다**‘
> 
> 업무규칙상 계좌를 생성할 때 잔고가마이너스인 상태로 계좌를 생성 하는 것은 허용하지 않는다.

라는 요구사항에 대해서

> ![enter image description
> here](https://github.com/src8655/cafe24_6/blob/master/1.TDD/%EC%9C%A4%EB%AF%BC%ED%98%B8/img/img_02.JPG?raw=true)

 - 위와 같은 테스트 케이스를 작성하고 이를 해결하는 로직을 작성하면 되지만, 업무규칙을 설명해줄 뿐 어느 부분을 어떻게 수정해야 하는지 **디자인 가이드를 개발자에게 명확히 전달해주고 있지 않다.**

> ![enter image description
> here](https://github.com/src8655/cafe24_6/blob/master/1.TDD/%EC%9C%A4%EB%AF%BC%ED%98%B8/img/img_03.JPG?raw=true)

 - 이 테스트 케이스는 업무규칙을 설명해줄 뿐만 아니라 Account 생성자를 수정해야 한다는 디자인 가이드도 있어 앞의 경우보다 낫다.

> ![enter image description
> here](https://github.com/src8655/cafe24_6/blob/master/1.TDD/%EC%9C%A4%EB%AF%BC%ED%98%B8/img/img_04.JPG?raw=true)


**8.2TDD 유의사항**
- 테스트 케이스는 이름이 중요하다
- 더 이상 제대로 동작하지 않는 테스트 케이스는 제거한다
- TDD는 자동화된 테스트를 만드는 것이 최종 목표가 아니다
  =>소프트웨어의 현재 상태의 정상 여부 판단이 목표이다.
- 모든 상황에 대한 테스트 케이스를 만들 필요는 없다
- 여러 개의 실패하는 테스트 케이스를 한 번에 만들지 않는다
- 하나의 테스트 케이스는 하나만 테스트하도록 작성한다
- 전통적인 테스트 기법을 배워두자
  =>기초 정도는 배워놓으면 TDD를 잘하는 데에 좀 더 도움이 된다.
- 테스트 케이스는 최대한 고립시킨다
  =>다른 모듈이나 시스템에 최대한 독립적이고 고립된 형태로 작성
- 될수록 단단한 테스트 케이스가 될 수 있다


**8.3TDD와 리팩토링**

 - **리팩토링 :　이해하기 쉽고, 수정하기 쉬운 코드로 만들자**
 - 자동화된 테스트 케이스는 소스가 작성된 다음에 작성하려면 심리적으로 쉽지가 않다 TDD를 하면 코드가 작성됨과 동시에 자동화된 테스트 케이스가 나오고 그 때마다 리팩토링을　하면 대상
   코드뿐 아니라 자동화된 테스트 케이스 자체도 사용하기 좋은 코드가 된다.


**8.4TDD와 짝 프로그래밍**

 - **짝프로그래밍 : 한사람은 키보드와 마우스로 코딩을 하고 나머지 한사람은 작성된 코드가 논리적인지 확인하고 서로 역할을 바꿔서 반복하는 방법** 
 - 한 사람보다는 두 사람의 머리가 더 나은 답을 찾을 확률이 높아서 TDD와 짝 프로그래밍은 잘
   어울린다.

**8.5 TDD와 심리학**

> 어떻게 팀원들과 TDD를 할 것인가?

> ![enter image description
> here](https://github.com/src8655/cafe24_6/blob/master/1.TDD/%EC%9C%A4%EB%AF%BC%ED%98%B8/img/img_05.JPG?raw=true)

=> 가장 취하기 쉬운 방법, 개발에 부담을 주는 위험이 있다.

> ![enter image description
> here](https://github.com/src8655/cafe24_6/blob/master/1.TDD/%EC%9C%A4%EB%AF%BC%ED%98%B8/img/img_06.JPG?raw=true)

=> 흐지부지해지기 쉽다

> ![enter image description
> here](https://github.com/src8655/cafe24_6/blob/master/1.TDD/%EC%9C%A4%EB%AF%BC%ED%98%B8/img/img_07.JPG?raw=true)

=> 테스트 커버리지 : 프로그램의 검사나 어떤 종류의 완전성에 관한 지표, 지표가 너무 높으면 좌절하거나 속이려는 시도가 발생하고 너무 낮으면 대충 짠다.
	
	
**8.6 TDD를 어렵게 만드는 요인**

 - **환경적 요인** 
 - 아침 스탠드업 미팅, TDD, 일일 빌드, 지속적인 통합 서버 운영, 짝 프로그래밍, 번 다운 차트, 회고 등 같은 애자일 실천 기법을 프로젝트에 풀 스펙(Full Spec)에 가까운 형태로 적용해본 이야기 이다. 대단히 성공했어야 할 프로젝트였어야 하지만 평이하게 마감되었는데, 원인은 가이드를 착실히 따를 만한 여유가 없었기 때문이다.

 - **산만한 아키텍처**

 - 객체 지향 언어는 클래스들로 구성되지만 TDD에서 집중하는 건 메소드라는 점에서 미묘한 괴리가 발생된다. TDD를 통해 만들어진 자동화된 단위 테스트는 클래스 영역을 커버하지 못해 설계구조가 산만해질 수 있다. TDD가 지나치게 강조되었을 때 발생하는 현상으로 고수준설계 정도는 마친 후 TDD를 적용하면 이런 문제를 막을 수 있다.

**의존성 전파로 인한 연쇄적인 테스트 실패들**

> ![enter image description
> here](https://github.com/src8655/cafe24_6/blob/master/1.TDD/%EC%9C%A4%EB%AF%BC%ED%98%B8/img/img_08.JPG?raw=true)

 - testAddAcount()가 실패하면 testUpdateAccount()와 testLoadAccount()도 함께 실패하게 되어 있다. 보통 testAddAccount부터 작성해서 테스트 케이스를 성공시킨 다음 진행하기 때문에 작성 당시에는 별 영향이 없었을 것이다. 하지만 나중에 프로그램을 수정 했을 때 테스트 케이스들이 동시에 실패해버리는 경우가 발생한다.

**BDD**

 - BDD는 TDD와 유사하지만 비즈니스 로직을 검증하여 개발하는 방식으로 개발 결과의 검증에 중점을 두는 방식이다.

**차이점**

 - TDD는 “짧은 싸이클의 요구사항을 테스트하며 개발코드를 완성시키는 것이 목표”
 - BDD는 “비즈니스 로직(고수준의 기능영역)을 테스트하며 개발코드를 완성시키는 방식”

> ![enter image description
> here](https://github.com/src8655/cafe24_6/blob/master/1.TDD/%EC%9C%A4%EB%AF%BC%ED%98%B8/img/img_09.JPG?raw=true)

테스트 메소드 작성에 집중할 수 있는 문장적인 템플릿을 제공한다.

> ![enter image description
> here](https://github.com/src8655/cafe24_6/blob/master/1.TDD/%EC%9C%A4%EB%AF%BC%ED%98%B8/img/img_20.JPG?raw=true)
> 
> 
> ![enter image description
> here](https://github.com/src8655/cafe24_6/blob/master/1.TDD/%EC%9C%A4%EB%AF%BC%ED%98%B8/img/img_21.JPG?raw=true)
> 
> 
> ![enter image description
> here](https://github.com/src8655/cafe24_6/blob/master/1.TDD/%EC%9C%A4%EB%AF%BC%ED%98%B8/img/img_22.JPG?raw=true)
