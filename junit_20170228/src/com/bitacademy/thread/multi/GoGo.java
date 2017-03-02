package com.bitacademy.thread.multi;

public class GoGo extends Thread{
	private int i;
	
	public void run(){
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
