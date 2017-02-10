package com.bitacademy.jpa01;

public class Dept {

	private int deptno;
	private String dname;
	
	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}

	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + "]";
	}
	
	
}
