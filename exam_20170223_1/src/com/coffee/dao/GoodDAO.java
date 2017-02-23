package com.coffee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.coffee.vo.Good;

@Transactional(rollbackFor = {Throwable.class})
public interface GoodDAO extends JpaRepository<Good, Long>
{

}
