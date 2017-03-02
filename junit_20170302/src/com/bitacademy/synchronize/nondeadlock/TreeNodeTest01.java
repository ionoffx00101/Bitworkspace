package com.bitacademy.synchronize.nondeadlock;

public class TreeNodeTest01
{

	public static void main(String[] args)
	{
		TreeNode root = new TreeNode("root");
		TreeNode node1 = new TreeNode("node1");
		TreeNode node2 = new TreeNode("node2");
		
		// 엮
		root.addChild(node1);
		node2.setParent(root);
		
		System.out.println(root);
		
	}

}
