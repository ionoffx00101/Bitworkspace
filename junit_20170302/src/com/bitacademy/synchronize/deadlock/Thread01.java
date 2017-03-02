package com.bitacademy.synchronize.deadlock;

public class Thread01
{
	TreeNode root;
	TreeNode node1;

	public void run()
	{
		System.out.println("Thread01 :  run( ) - start");
		// root의 자식으로 node1을 설정
		root.addChild(node1);
		System.out.println("Thread01 :  run( ) - end");
	}
}
