package com.bitacademy.professor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitacademy.professor.vo.Professor;

public interface ProfessorDAO extends JpaRepository<Professor, Long>
{
	// 내가 만들어야 하는게 아닌 이상 JpaRepository에서 만들어준걸 얻어다가 쓰면 된다.
}
