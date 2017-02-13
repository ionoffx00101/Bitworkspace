package com.bitacademy.buy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor={Throwable.class})
public interface BuyDAO extends JpaRepository<Buy, Long> { // buy의 pk이인 bnum은 Long 타입

	@Query("select b from Buy b where b.customer.id like %?1%") // id가 첫번째 변수랑 같은것의 리스트를 내놓아라
	public List<Buy> selectCustomerBuyList(String name);
}
