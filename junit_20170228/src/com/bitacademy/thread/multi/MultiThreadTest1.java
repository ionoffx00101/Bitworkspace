package com.bitacademy.thread.multi;

public class MultiThreadTest1 {

	public static void main(String[] args) {
		ComeCome c=new ComeCome();
		GoGo g=new GoGo();
		c.start();		
		g.start();
	}
}
