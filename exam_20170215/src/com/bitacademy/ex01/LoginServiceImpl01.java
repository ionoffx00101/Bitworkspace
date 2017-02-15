package com.bitacademy.ex01;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

@Service("loginServiceImpl01")
public class LoginServiceImpl01 implements ILoginService
{
	@Inject
	@Named("loginFailManagerImpl")
	ILoginFailManager loginFailManagerImpl;

	@Override
	public void login(String id, String pw)
	{
		if ("guest".equals(id) && "1234".equals(pw))
		{
			System.out.println("로그인 됨");
		} else
		{
			loginFailManagerImpl.loginFail(); // 실패했으니 loginFail 호출
		}
	}

}
