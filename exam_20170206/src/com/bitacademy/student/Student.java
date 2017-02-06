package com.bitacademy.student;

import com.bitacademy.dept.Dept;

public class Student {
	public String studno;// 학번
	public String name;// 이름
	public String userid;// 아이디
	public String pw;// 비밀번호
	public Dept dept;// 학생의 학과정보를 저장하고 있는 객체

	@Override
	public String toString() {
		return "Student [studno=" + studno + ", name=" + name + ", userid="
				+ userid + ", pw=" + pw + ", dept=" + dept + "]";
	}

}
