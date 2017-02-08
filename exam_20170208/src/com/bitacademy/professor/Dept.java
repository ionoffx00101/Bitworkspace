package com.bitacademy.professor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/* 학과정보를 저장하고 있는 객체
 * 1. TB_DEPARTMENT 테이블과 데이터를 주고 받도록 설정 */

@Entity
@Table(name="TB_DEPARTMENT")
public class Dept {
	
	//2.Primary Key 설정
	@Id
	public Long deptno; //학과번호
	public String dname; //학과명 
	public String loc; //위치

	public Long getDeptno() {
		return deptno;
	}

	public void setDeptno(Long deptno) {
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

	public Dept() {
		super();
	}

	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}


}
