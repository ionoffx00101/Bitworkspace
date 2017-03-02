package com.bitacademy.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//TB_USER 테이블에 데이터 추가 수정 삭제 조회 클래스
@Transactional(rollbackFor = { Throwable.class })
@Component(value="userDAO")
public interface UserDAO extends JpaRepository<User, String> {

}
