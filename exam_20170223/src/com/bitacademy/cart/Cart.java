package com.bitacademy.cart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.bitacademy.good.Good;
/*
 * CartService에서 주입 받을수 있도록 설정 필요
      주입시 Scope는 세션스코프로 설정해서 사용자 별로 각각의 장바구니를 사용 가능하도록 설정할것
 */
@SessionScope
@Component("cart")
public class Cart {
	//장바구니 리스트 속성
	List<Good> cartList;

	public Cart() {
		/*
		 * Cart의 생성자
		ArrayList<Good>객체를 생성해서 속성 cartList에 저장
		 */
		cartList = new ArrayList<Good>();
	}

	public List<Good> getCartList() {
		return cartList;
	}

	public void setCartList(List<Good> cartList) {
		this.cartList = cartList;
	}

	@Override
	public String toString() {
		return "Cart [cartList=" + cartList + "]";
	}

}
