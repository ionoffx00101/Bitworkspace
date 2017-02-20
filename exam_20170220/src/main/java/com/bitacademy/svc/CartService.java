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
		boolean searchIndex = false;
		for (int i = 0; i < currentList.size(); i++)
		{
			Good goodInList = currentList.get(i);
			if (NewGood.getGnum() == goodInList.getGnum())
			{
				// 이미 장바구니에 있는 거면 장바구니 숫자만 늘려준다
				goodInList.setQty(goodInList.getQty()+1);
				searchIndex = true;
			}
		}
		if (!searchIndex)
		{
			// 한번도 찾아보지 않은 물건이면 장바구니에 추가한다
			currentList.add(NewGood);
		}

		mav.setViewName("redirect:/viewCartList.do");
		return mav;
	}

	@RequestMapping("removeCart")
	public ModelAndView removeCart(Long gnum)
	{
		ArrayList<Good> currentList = cart.getCartList();

		for (int i = 0; i < currentList.size(); i++)
		{
			Good good = currentList.get(i);
			if (good.getGnum() == gnum)
			{
				currentList.remove(gnum);
			}
		}

		mav.setViewName("redirect:/viewCartList.do");
		return mav;
	}

	@RequestMapping("/viewCartList.do")
	public String viewCartList()
	{
		return "viewCartList";
	}
}
