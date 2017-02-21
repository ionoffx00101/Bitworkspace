package com.bitacademy.svc;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bitacademy.vo.Cart;
import com.bitacademy.vo.Good;

@Controller
public class CartService
{
	@Inject
	@Named("mav")
	private ModelAndView mav;

	@Inject
	@Named("cart")
	private Cart cart;

	@RequestMapping("/addCart.do")
	public ModelAndView addCart(Good NewGood)
	{

		ArrayList<Good> currentList = cart.getCartList();

		int searchIndex = -1;

		searchIndex = currentList.indexOf(NewGood);

		if (searchIndex == -1)
		{
			cart.add(NewGood);
		} else
		{
			Good goodInList = currentList.get(searchIndex);
			goodInList.setQty(goodInList.getQty() + NewGood.getQty());
		}

		mav.addObject("cartList", cart.getCartList());

		mav.setViewName("forward:/viewCartList.do"); // forward:/ 라는 명령어를 써야지 mav가 넘어가면서 페이지를 이동시킬수 있는 것같다.

		return mav;
	}

	@RequestMapping("/removeCart.do")
	public ModelAndView removeCart(Long gnum)
	{
		ArrayList<Good> currentList = cart.getCartList();

		Good removeGood = new Good();
		removeGood.setGnum(gnum);
		
		int searchIndex = currentList.indexOf(removeGood);
		
		Good changeGood = new Good();
		changeGood = currentList.get(searchIndex);
		
		if(currentList.get(searchIndex).getQty()>1){
			
			changeGood.setQty(changeGood.getQty()-1);
			
			currentList.set(searchIndex, changeGood);
			
			cart.setCartList(currentList);
			
		}else if(currentList.get(searchIndex).getQty()==1){
			cart.remove(changeGood);
		}
		
	
		mav.addObject("cartList", cart.getCartList());
		mav.setViewName("forward:/viewCartList.do");
		return mav;
	}

	@RequestMapping("/viewCartList.do")
	public String viewCartList()
	{
		return "viewCartList.jsp";
	}
}
