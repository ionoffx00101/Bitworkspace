package com.bitacademy.dept;

public class Dept {
	
	public String deptno;
	public String dname;
	public String loc;
	public String colno;
	//colno > College college; 
		/*단대 번호만 알고있고 단대이름은 알 수없음 클래스는 조인안됨
		그래서 college안에 단대 번호를 넣는다
		Student 클래스에서 dept객체를 불러서 사용한 것이 그 예
		*/
	
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
