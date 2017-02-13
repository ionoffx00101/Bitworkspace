package com.bitacademy.good;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


@Transactional(rollbackFor={Throwable.class})
public interface GoodDAO extends JpaRepository<Good, Long>{ // gnum 은 Long 타입

/*	@Override
	public Good getOne(Long id);*/
	
	@Query("select g from Good g where id=?1")
	public Good getonemade(Long id);
}
