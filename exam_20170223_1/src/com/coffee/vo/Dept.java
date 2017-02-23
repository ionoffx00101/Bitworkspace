package com.coffee.vo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_DEPT20170220")
public class Dept
{
	@Id
	private Long deptno;
	private String dname;
	private String loc;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="colno",referencedColumnName="colno") // (name="내 컬럼",referencedColumnName="니 컬럼")
	private College college;
	
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
	public College getCollege()
	{
		return college;
	}
	public void setCollege(College college)
	{
		this.college = college;
	}
	
	@Override
	public String toString()
	{
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + ", college=" + college + "]";
	}
}
