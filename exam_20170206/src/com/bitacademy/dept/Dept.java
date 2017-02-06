package com.bitacademy.dept;

public class Dept {
	public String deptno;
	public String dname;
	public String loc;
	public String colno;
	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getColno() {
		return colno;
	}
	public void setColno(String colno) {
		this.colno = colno;
	}
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc
				+ ", colno=" + colno + "]";
	}
	
}	
