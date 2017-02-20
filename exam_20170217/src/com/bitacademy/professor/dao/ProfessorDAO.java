package com.bitacademy.professor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bitacademy.professor.vo.Professor;

@Transactional(rollbackFor={Throwable.class})
//@Component(value="professorDAO") 어.. 이거 알아서 추가해 주지 않나..
public interface ProfessorDAO extends JpaRepository<Professor,Long>{

}
