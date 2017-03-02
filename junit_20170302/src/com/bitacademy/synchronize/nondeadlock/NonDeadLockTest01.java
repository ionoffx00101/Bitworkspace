package com.bitacademy.synchronize.nondeadlock;

public class NonDeadLockTest01
{
	public static void main(String[] args)
	{
		// Exception in thread "main" java.lang.StackOverflowError
		
		Thread01 thread01 = new Thread01();
		Thread02 thread02 = new Thread02();

		TreeNode root = new TreeNode("root");
		TreeNode node1 = new TreeNode("node1");

		thread01.root = root;
		thread01.node1 = node1;

		thread02.root = root;
		thread02.node1 = node1;

		// 시작
		thread01.run();
		thread02.run();
		
		System.out.println(root);
	}
}
