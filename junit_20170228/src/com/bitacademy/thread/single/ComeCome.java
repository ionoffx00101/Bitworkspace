package com.bitacademy.thread.single;

public class ComeCome {
	private int i;
	
	public void come(){
		for(i=0;i<1000;i++){
			System.out.println("come:i="+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
