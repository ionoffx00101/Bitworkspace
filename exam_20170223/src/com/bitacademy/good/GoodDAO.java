package com.bitacademy.good;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
/*
 * TB_GOOD20170220 테이블의 레코드를 추가 수정 삭제 조회를 처리하는 클래스
	GoodService에서 주입 받을수 있도록 설정할것
 */
@Transactional(rollbackFor = { Throwable.class })
@Component(value="goodDAO")
public interface GoodDAO extends JpaRepository<Good, Long> {

}
