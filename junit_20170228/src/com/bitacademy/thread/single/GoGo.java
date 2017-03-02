package com.bitacademy.thread.single;

public class GoGo {
	private int i;
	
	public void go(){
		for(i=0;i<1000;i++){
			System.out.println("go:i="+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
