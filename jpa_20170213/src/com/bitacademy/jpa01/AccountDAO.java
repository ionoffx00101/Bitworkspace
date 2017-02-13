package com.bitacademy.jpa01;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor={Throwable.class})// rollbackFor={Throwable.class} 모든 익셉션시 롤백
// JpaRepository<Account, Long> <내가 entity랑 연결한 클래스 이름, pk연결된 변수의 자료형>
public interface AccountDAO extends JpaRepository<Account, Long>{ // 인터페이스끼리 상속받을때는 extends 클래스가 인터페이스를 상속받을때는 implements

	
	// 내가 만드는 쿼리 
	// 얼마 이상인 계좌만 조회 할 것임
	//@Query("select 별칭 from 엔티티연결된클래스이름 별칭 where 조건문>=?1") ?1 첫번째 매개변수?
	@Query("select a from Account a where balance>=?1")
	public List<Account> findAccountBalance(Long amount);
	
	// 조건이 두개가 들어가는 쿼리문을 만들것이다.
	@Query("select a from Account a where balance>=?1 and balance<=?2") // 아진짜 ?1이 첫번째 매개변수(Long start)고 ?2면 두번째 매개변수(Long end)를 뜻하네..ㄷ 아니 ㅜ머 이런
	public List<Account> findAccountBetween(Long start,Long end);
}
