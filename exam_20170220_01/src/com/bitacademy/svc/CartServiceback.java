package com.bitacademy.svc;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.web.servlet.ModelAndView;

import com.bitacademy.vo.Cart;
import com.bitacademy.vo.Good;

public class CartServiceback
{
	@Inject
	@Named("mav")
	private ModelAndView mav;

	@Inject
	@Named("cart")
	private Cart cart;

	
	public ModelAndView addCart(Good NewGood)
	{

		ArrayList<Good> currentList = cart.getCartList();
		
		int searchIndex = -1;
		
		searchIndex = currentList.indexOf(NewGood);
		
		if(searchIndex == -1){
			cart.add(NewGood);
		}else {
			Good goodInList = currentList.get(searchIndex);
			goodInList.setQty(goodInList.getQty() + 1);
		}
		
		//boolean searchIndex = false; // 문제에는 -1로 되어서 숫자를 바꾸는 식으로 구분을 함 근데 boolean으로 해도 될 것같아서 불린으로 함
//		for (int i = 0; i < currentList.size(); i++)
//		{
//			Good goodInList = currentList.get(i);
//			if (NewGood.getGnum().equals(goodInList.getGnum())) // 	if (NewGood.getGnum() == goodInList.getGnum())
//			{
//				// 이미 장바구니에 있는 거면 장바구니 숫자만 늘려준다
//				goodInList.setQty(goodInList.getQty() + 1);
//				//searchIndex = true;
//				
//			}
//		}
//		if (!searchIndex)
//		{
//			// 한번도 찾아보지 않은 물건이면 장바구니에 추가한다
//			cart.add(NewGood);
//		}

		// System.out.println("cy"+cart);
		mav.addObject("cartList", cart.getCartList());
		// mav.setViewName("redirect:/viewCartList.do"); // 나만 안 넘어 가는것이 아니였다
		// mav.setViewName("forward:/viewCartList.do"); // forward:/ 라는 명령어를 써야지 mav가 넘어가면서 페이지를 이동시킬수 있는 것같다.
		mav.setViewName("viewCartList.jsp");
		return mav;
	}

	
	public ModelAndView removeCart(Long gnum)
	{
		ArrayList<Good> currentList = cart.getCartList();

		for (int i = 0; i < currentList.size(); i++)
		{
			Good good = currentList.get(i);
			if (good.getGnum() == gnum)
			{
				cart.remove(good);
				// qty가 1이상이면 물건 숫자를 1만 줄이고
				// qty가 1이하면 물건을 삭제
			}
			// gnum 비교하기 전에 gnum이 비어 있는개쳋인지 확인부터 해야하는것같다 gnum!=null
			if (good.getGnum().equals(gnum))
			{

			}
		}
		mav.addObject("cartList", cart.getCartList());
		// mav.setViewName("redirect:/viewCartList.do");
		// mav.setViewName("forward:/viewCartList.do");
		mav.setViewName("viewCartList.jsp");
		return mav;
	}

	
	public String viewCartList()
	{
		// redirect:/ 하면 cart가 안 간다 왜일까
		return "viewCartList.jsp";
	}
}
