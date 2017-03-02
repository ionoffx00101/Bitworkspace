package com.bitacademy.synchronize.nondeadlock;

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
		
		System.out.println(this.name + " : setParentOnly() -  end");
	}

	public synchronized void addChild(TreeNode child)
	{
		System.out.println(this.name + " : addChild() - start");
		
		this.children.add(child);
		// child.setParentOnly(this); // 문제라고 한다 // 문제가 되지 않았던거 같은데..흠
		child.parent = this;
		
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
		// parent.addChildOnly(this);
		parent.children.add(parent);
		
		System.out.println(this.name + " : setParent() -  end");
	}
	
	public String toString()
	{
		return "TreeNode [ name = " + name + ((parent == null) ? "" : ", parent = " + parent.name) + ", children = " + children + " ] ";
	}
}
