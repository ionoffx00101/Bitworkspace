package com.coffee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.coffee.vo.College;

@Transactional(rollbackFor = {Throwable.class})
public interface CollegeDAO extends JpaRepository<College, Long>
{

}
