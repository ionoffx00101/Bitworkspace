package com.bitacademy.ex02.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import com.bitacademy.ex01.ILoginFailManager;
import com.bitacademy.ex01.ILoginService;
import com.bitacademy.ex02.dao.CustomerDAO;
import com.bitacademy.ex02.vo.Customer;

@Service("loginServiceImpl02")
public class LoginServiceImpl02 implements ILoginService // implements ILoginService 인터페이스 연결 안해두고 있었다.. 와
{
	@Inject
	@Named("loginFailManagerImpl")
	ILoginFailManager loginFailManagerImpl; // 로그인실패인터페이스를 통해서 인터페이스를 상속받는 로그인실패매니저클래스1개를 가져와서 loginFailManagerImpl 속성으로 만든다

	@Inject
	@Named("customerDAO")
	CustomerDAO customerDAO; // JpaRepository가 앞글자 소문자로 변환만 시켜서 나도 모르고 등록시켜놓았다 난 쓰기만 하면 된다

	@Override
	public void login(String id, String pw)
	{
		Customer findCId = customerDAO.findOne(id); // 아이디 넣고 고객정보 찾기

		// 돌아온 객체가 비어있는 지 확인해야함
		// !findCId.equals("") && findCId != null
		// findCId.getId()==id.. 허허
		if (findCId != null)
		{
			// 일치하는 아이디가 있을때
			if (pw.equals(findCId.getPw()))
			{
				// 돌아온 객체의 비밀번호와 입력된 비밀번호가 같을때
				System.out.println("로그인 성공 ㅊㅊ");
			} else
			{
				// 돌아온 객체의 비밀번호와 입력된 비밀번호가 다를때
				System.out.println("비밀번호 오류");
				loginFailManagerImpl.loginFail();
			}

		} else
		{
			// 일치하는 아이디가 없을때
			System.out.println("존재하지 않는 아이디");
			loginFailManagerImpl.loginFail();
		}

	}

}
