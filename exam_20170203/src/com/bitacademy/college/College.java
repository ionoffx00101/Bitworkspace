package com.bitacademy.college;

public class College {
	public String colno;
	public String colname;
	public String getColno() {
		return colno;
	}
	public void setColno(String colno) {
		this.colno = colno;
	}
	public String getColname() {
		return colname;
	}
	public void setColname(String colname) {
		this.colname = colname;
	}
	@Override
	public String toString() {
		return "College [colno=" + colno + ", colname=" + colname + "]";
	}
	
}
