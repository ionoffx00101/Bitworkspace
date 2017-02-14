package com.coffee.spring02;

public class DependencyBean02_01 implements IDependencyBean{

	//인자없는 생성자

	private int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "DependencyBean01 [num=" + num + "]";
	}

	@Override
	public void helloBean() {
		System.out.println("depen02_01");
	}

}
