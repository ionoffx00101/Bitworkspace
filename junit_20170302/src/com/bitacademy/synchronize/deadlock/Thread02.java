package com.bitacademy.synchronize.deadlock;

public class Thread02
{
	TreeNode root;
	TreeNode node1;

	public void run()
	{
		System.out.println("Thread02 :  run( ) - start");
		// node1의 부모를 root로 설정
		node1.setParent(root);
		System.out.println("Thread02 :  run( ) - end");
	}
}
