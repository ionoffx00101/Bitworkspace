package com.coffee.spring01;

public class MyObject {

	// set으로 해는게 기본이다 
	// 하지만 값을 안 넣으면 컴파일 오류가 나는 경우에는 생성자를 호출해서 무조건 넣어야 생성자가 호출되게끔 만들어야 한다.

	private int count;
	private int zipcode;
	private int roomNumber;
	
	// 세개 다 무조건 받게 하기 위해서 만든 생성자
	// 그러면 xml에도 세개 다 넣어줘야한다
	// 빈 클래스에 꼭 등록을 해야만 하는일 일까
	public MyObject(int count, int zipcode, int roomNumber) {
		super();
		this.count = count;
		this.zipcode = zipcode;
		this.roomNumber = roomNumber;
	}

	@Override
	public String toString() {
		return "MyObject [count=" + count + ", zipcode=" + zipcode + ", roomNumber=" + roomNumber + "]";
	}

	// 무조건 count를 받게 해야하기 때문에 만든 생성자 ㅇㅇ
	/* public MyObject(int count) {
	 * super();
	 * this.count = count;
	 * } */



}
