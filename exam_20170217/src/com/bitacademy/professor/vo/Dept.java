package com.bitacademy.professor.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_dept04")
public class Dept
{
	@Id
	private Long deptno;
	private String dname;
	private String loc;
	private Long college;

	public Long getDeptno()
	{
		return deptno;
	}
	public void setDeptno(Long deptno)
	{
		this.deptno = deptno;
	}
	public String getDname()
	{
		return dname;
	}
	public void setDname(String dname)
	{
		this.dname = dname;
	}
	public String getLoc()
	{
		return loc;
	}
	public void setLoc(String loc)
	{
		this.loc = loc;
	}
	public Long getCollege()
	{
		return college;
	}
	public void setCollege(Long college)
	{
		this.college = college;
	}

	@Override
	public String toString()
	{
		return "Professor [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + ", college=" + college + "]";
	}
}
