package com.bitacademy.vo;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component("cart")
public class Cart
{
	private ArrayList<Good> cartList;

	public Cart()
	{
		this.cartList = new ArrayList<Good>();
	}

	public ArrayList<Good> getCartList()
	{
		return cartList;
	}

	public void setCartList(ArrayList<Good> cartList)
	{
		this.cartList = cartList;
	}

	@Override
	public String toString()
	{
		return "Cart [cartList=" + cartList + "]";
	}

	public void add(Good newGood)
	{
		cartList.add(newGood);
	}

	public void remove(Long gnum)
	{
		cartList.remove(gnum);
	}

}
