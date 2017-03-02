package com.bitacademy.thread.single;

public class SingleThreadTest1 {

	public static void main(String[] args) {
		ComeCome c=new ComeCome();
		GoGo g=new GoGo();
		c.come();		
		g.go();

	}

}
