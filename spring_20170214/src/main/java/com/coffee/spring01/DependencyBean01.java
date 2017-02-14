package com.coffee.spring01;

public class DependencyBean01 {

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

}
