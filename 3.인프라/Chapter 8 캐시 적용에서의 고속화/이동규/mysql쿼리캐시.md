## MySQL 성능 향상과 쿼리 캐시
 - 쿼리 캐시란?
 -- SQL 결과를 캐시해두어 같은 요청이 오면 캐시에 있는 데이터를 재사용하는 기능
 - 쿼리 캐시를 이용할 수 있는 조건
 -- SQL이 완전히 일치
 -- 캐시할 수 없는 함수 이용 불가(NOW(),SYSDATE() 등 시간 관련 함수)
 -- Prepared Statement 사용 불가
 --- Prepared Statement의 경우 쿼리 문장 자체에 변수가 사용되기 때문에 쿼리 문장 자체로 쿼리 캐시를 찾을 수 없다. 
  

### 쿼리 캐시 동작 방식
1. 쿼리를 저장할 Free List를 확인하고 영역을 할당 받는다.
2. 쿼리 캐시의 동작은 Single Thread로 구현되어 있다.
3. 싱글 스레드이므로 두개 이상일 경우 대기상태에 빠진다.
4. 데이터가 변경되는 시 쿼리 캐시에서 해당 테이블과 연관된 모든 아이템을 삭제 한다.

### 쿼리 캐시 주의 사항
 - 동시 트랜잭션이 많거나, 쿼리 캐시(Query Cache)의 Hit Ratio가 높지 않은 경우 오히려  쿼리 캐시는 성능에 악영향을 미친다.
쿼리 캐시 히트율(%) = Qcache_hits / (Qcache_hits + Com_select)*100  
**Qcache_hits:** 쿼리 캐시로 처리된 SELECT 쿼리의 수

**Com_sleect:** 쿼리 캐시에서 결과를 찾지 못해서 MySQL 서버가 쿼리를 실행한 횟수

  
  
출처: [https://12bme.tistory.com/73](https://12bme.tistory.com/73) [길은 가면, 뒤에 있다.]

- 쿼리 캐시는 쿼리의 바이트 크기로 동일함을 판단하여 아래 SQL구문은 다르게 해석된다.
```cmd
SELECT * FROM tbl_member;
select * from tbl_member;
```
- DDL(ALTER,TRUNCATE ...)과 DML(INSERT, UPDATE ...) 등 변경이 발생되면 모든 쿼리 캐시는 캐시에서 제거된다.
- Select 쿼리가 고정적이지 않다면, Query Cache 영역을 할당받기 위해 매번 대기상태에 빠진다.
- 여기서 적절한 크기는 일반적으로 32MB~64MB 정도입니다.  

참고 
- [http://channy.creation.net/project/dev.kthcorp.com/2011/08/02/query-cache-use-at-your-own-risk/](http://channy.creation.net/project/dev.kthcorp.com/2011/08/02/query-cache-use-at-your-own-risk/)
 - [https://12bme.tistory.com/73](https://12bme.tistory.com/73)
설정 참고 
 - [https://blog.cafe24.com/1402](https://blog.cafe24.com/1402)
 - [https://blog.pages.kr/30](https://blog.pages.kr/30)