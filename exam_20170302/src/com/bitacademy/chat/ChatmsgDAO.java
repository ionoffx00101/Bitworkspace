package com.bitacademy.chat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//TB_CHATMSG 테이블에 데이터 추가 수정 삭제 조회
@Transactional(rollbackFor = { Throwable.class })
@Component(value="chatmsgDAO")
public interface ChatmsgDAO extends JpaRepository<Chatmsg,Long> {
	
}
