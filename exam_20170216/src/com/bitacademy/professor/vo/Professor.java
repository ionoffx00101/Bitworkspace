package com.bitacademy.professor.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_professor3")
public class Professor
{
	@Id
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
