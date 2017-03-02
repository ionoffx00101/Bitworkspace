package com.bitacademy.synchronize.deadlock;

import java.util.ArrayList;
import java.util.List;

public class TreeNode
{
	private String name;
	private TreeNode parent;
	private List<TreeNode> children = new ArrayList<TreeNode>();
	// <> 안에 넣는 것과 안 넣는 것은 어떤 차이일까 / 나중에 무슨 일이 일어나느 걸까

	public TreeNode(String name)
	{
		this.name = name;
	}

	public synchronized void setParentOnly(TreeNode parent)
	{
		System.out.println(this.name + " : setParentOnly() - start");
		
		this.parent = parent;
		// 데드락을 일부러 걸리게 하기 위해서
		// Thread.sleep을 사용했지만
		// 시간이 걸릴뿐 완료되긴 한다
		// 컴퓨터가 너무 좋은 것같다.
		
		System.out.println(this.name + " : setParentOnly() -  end");
	}

	public synchronized void addChild(TreeNode child)
	{
		System.out.println(this.name + " : addChild() - start");
		
		this.children.add(child);
		child.setParentOnly(this);
	
		System.out.println(this.name + " : addChild() -  end");
	}

	public synchronized void addChildOnly(TreeNode child)
	{
		System.out.println(this.name + " : addChildOnly() - start");
		
		this.children.add(child);
	
		System.out.println(this.name + " : addChildOnly() -  end");
	}

	public synchronized void setParent(TreeNode parent)
	{
		System.out.println(this.name + " : setParent() - start");
		
		this.parent = parent;
		parent.addChildOnly(this);
		
		System.out.println(this.name + " : setParent() -  end");
	}
	
	public String toString()
	{
		return "TreeNode [ name = " + name + ((parent == null) ? "" : ", parent = " + parent.name) + ", children = " + children + " ] ";
	}
}
