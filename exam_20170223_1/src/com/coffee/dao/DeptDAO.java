package com.coffee.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.coffee.vo.Dept;

@Transactional(rollbackFor = {Throwable.class})
public interface DeptDAO extends JpaRepository<Dept, Long>
{
	@Query("select d from Dept d where d.college.colno=?1")
	public List<Dept> selectDeptList(Long colno);
}
