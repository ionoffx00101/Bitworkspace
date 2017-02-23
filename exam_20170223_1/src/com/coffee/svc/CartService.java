package com.coffee.svc;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.coffee.vo.Cart;
import com.coffee.vo.Good;


/*
 * 장바구니 정보를 추가 수정 삭제하는 컨트롤러
	@Controller 설정 필요
 */
@Controller
public class CartService {
	/*
	 * ModelAndView 타입의 속성
		주입받도록 설정
		주입 받는 Scope 은 request 로 각 사용자 별로 실행할때마다 각각의 객체를 주입 받도록 설정할것

	 */
	@Inject
	@Named("mav")	
	private ModelAndView mav;
	
	//Cart를 주입 받음
	@Inject
	@Named("cart")
	private Cart cart;
	/*
	 * /addCart.do 일때 실행되도록 설정 필요
		매개변수 good에 장바구니에 추가하고자 하는 물건의 정보가 저장되 있음

	 */
	@RequestMapping("/addCart.do")
	public ModelAndView addCart(Good good) {
		//1. 속성 cart의 cartList 속성을 리턴받아서 (get메서드) ArrayList<Good> 타입 속성에 저장
		List<Good> cartList = cart.getCartList();
		int searchIndex = 
				cartList.indexOf(good);
//		//3. 0~ 1겍체에 저장된 객체의 수-1 만큼 반복 1객체에 저장된 객체의 수는 1객체.size()
//		for (int i = 0; i < cartList.size(); i++) {
//			//3.1 1객체에서 i번째 객체를 꺼내서 Good 타입 변수에 저장
//			Good searchGood = cartList.get(i);
//			/*
//			 * 3.2 3.1객체의 gnum 과 매개변수 good의 gnum이 일치하는지 확인
//               	이때 gnum이 일치하면         
//
//			 */
//			if (searchGood.getGnum() == good.getGnum()) {
//				//이미 장바구니에 있는 객체를 또 장바구니에 넣은 것이이 때문에 
//				//3.1 객체의 qty 속성을 매개변수 good의 qty만큼 증가
//			      
//				Long newQty = 
//						searchGood.getQty() + good.getQty();
//				
//				searchGood.setQty(newQty);
//				// 하고 1에서 3.1 객체를 갱신  1객체.set(i,3.1객체)
//				cartList.set(i,searchGood);
//				 //searchIndex에 i를 대입
//				searchIndex = i;
//				
//				break;
//			}
//		}
		/*
		 * 4. searchIndex가 -1이면 3.2가 한번도 실행 않된것이기 때문에 매개변수 good을 1객체에 추가
			1객체.add(good)

		 */
		if (searchIndex == -1) {
			cartList.add(good);
		}else{
			Good alreadySaveGood=cartList.get(searchIndex);
			alreadySaveGood.setQty(
				good.getQty()+alreadySaveGood.getQty());
			cartList.set(searchIndex, alreadySaveGood);
		}
		/*
		 * 5. 속성 mav를 이용해서 1객체를 JSP 로 전송하도록 설정
		 */
		mav.addObject("CART_LIST",cartList);
		/*
		 * 6. 속성 mav를 이용해서 viewCartList() 메서드를 호출하도록 설정
  			forward:/viewCartList.do 

		 */
		mav.setViewName("forward:/viewCartList.do");
		return mav;
	}
	/*
	 * /removeCart.do 일때 실행되도록 설정 필요
		매개변수 gnum에 삭제하고자 하는 물건 번호 가 저장

	 */
	@RequestMapping("/removeCart.do")
	public ModelAndView removeCart(Long gnum) {
		/*
		 * 1. 속성 cart의 cartList 속성을 리턴받아서 (get메서드) ArrayList<Good> 타입 속성에 저장
		 */
		List<Good> cartList = cart.getCartList();
		//3. 0~ 1겍체에 저장된 객체의 수-1 만큼 반복 1객체에 저장된 객체의 수는 1객체.size()
//		for (int i = 0; i < cartList.size(); i++) {
//			//  3.1 1객체에서 i번째 객체를 꺼내서 Good 타입 변수에 저장
//			Good searchGood = cartList.get(i);
//			//3.2 3.1객체의 gnum 과 매개변수 good의 gnum이 일치하는지 확인
//			if (searchGood.getGnum() == gnum) {
//				//이때 gnum이 일치하면 i 번째 객체를 1에서 삭제   1객체.remove(i);
//				cartList.remove(i);
//				break;
//			}
//		}
		Good removeGood=new Good();
		removeGood.setGnum(gnum);
		
		cartList.remove(removeGood);
		//5. 속성 mav를 이용해서 1객체를 JSP 로 전송하도록 설정
		mav.addObject("CART_LIST", cartList);
		//6. 속성 mav를 이용해서 viewCartList() 메서드를 호출하도록 설정
		//  forward:/viewCartList.do
		mav.setViewName("forward:/viewCartList.do");
		return mav;
	}
	///viewCartList.do 일때 페이지 이동하도록 설정 필요
	@RequestMapping("/viewCartList.do") 
	public ModelAndView viewCartList() {
		mav.setViewName("/cart/viewCartList.jsp");
		return mav;
	}
}
