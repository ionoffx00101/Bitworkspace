package com.bitacademy.professor.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // 엔티티를 이용해 테이블과 연결된 클래스이다
@Table(name = "tb_professor3") // 이 테이블과 연결되어 있다
public class Professor
{
	@Id // 밑에 있는 속성이 연결된 테이블에서 기본키를 담당하는 컬럼과 같은 친구이다.
	private Long profno;
	private String name;
	private Long sal;
	private Long comm;
	
	public Long getProfno()
	{
		return profno;
	}
	public void setProfno(Long profno)
	{
		this.profno = profno;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Long getSal()
	{
		return sal;
	}
	public void setSal(Long sal)
	{
		this.sal = sal;
	}
	public Long getComm()
	{
		return comm;
	}
	public void setComm(Long comm)
	{
		this.comm = comm;
	}
	@Override
	public String toString()
	{
		return "Professor [profno=" + profno + ", name=" + name + ", sal=" + sal + ", comm=" + comm + "]";
	}

}
