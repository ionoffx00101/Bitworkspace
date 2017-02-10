package com.bitacademy.jpa01;

/* 스프링 프레임 워크가 객체를 만들어 줄것이다
 * 프레임워크가 알아서 객체를 생성해 준다
 * - 기본 매개변수 없는 생성자
 * 속성 대입 - get/set */
public class Student {

	private long studno;
	private String name;
	private int age;
	
	private Dept dept;
	
	public Student() {
		super();
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public long getStudno() {
		return studno;
	}

	public void setStudno(long studno) {
		this.studno = studno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [studno=" + studno + ", name=" + name + ", age=" + age + ", dept=" + dept + "]";
	}

	

}
