package com.bitacademy.jpa01;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor={Throwable.class})// rollbackFor={Throwable.class} 모든 익셉션시 롤백 
public class AccountDAO {

	// PersistenceContext로 주입 받을때는 레코드 추가 삭제시에 커밋롤백중 한가지를 반드시 (오토ㄴ 수동 ㅇㅇ)실행해야한다 안하면 에러난다. 조회시에는 생략가능하다.
	@PersistenceContext
	EntityManager em;

	public List<Account> findAll() {
		List<Account> accountList = em.createQuery("select a from Account a", Account.class).getResultList();

		return accountList;

	}

	public void save(Account accout) throws Exception {

		em.merge(accout); // 이게 끝임 ㄱㅇㄷ
		Account ac2 = new Account();
		ac2.num = accout.num + 1;
		ac2.owner = accout.owner + "그만..";
		// 롤백 포인트 이 메서드에서 일어난 모든 DB작업이 취소된다
		if (true) {
			throw new Exception("내가 만든 에러인척 하는 에러가 아닌데 에러인척 하는 에러같은 에러인 에러");
		}
		em.merge(ac2);
	}
}
