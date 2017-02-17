package com.bitacademy.professor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bitacademy.professor.vo.Dept;

@Transactional(rollbackFor={Throwable.class})
public interface DeptDAO extends JpaRepository<Dept, Long>
{

}
