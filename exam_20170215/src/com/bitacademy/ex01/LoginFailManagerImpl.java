package com.bitacademy.ex01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("loginFailManagerImpl")
// @Component(value = "loginFailManagerImpl") // 난 value= 없이 사용했는데 잘 적용이 되었다. 없어도 되는건가..
public class LoginFailManagerImpl implements ILoginFailManager
{
	private int retryCount;

	public LoginFailManagerImpl(@Value("0") int retryCount)
	{	
		// 주입받아서 사용하라는게 @value("들어가는 생성자 빈?") 근데 여기 값들어갈게 뭐..있지 처음 호출당해서 생성할때 초기화 시켜주는 값 말하는건가
		super();
		this.retryCount = retryCount;
	}

	@Override
	public void loginFail()
	{
		retryCount++;
		System.out.println(retryCount + "번째 로그인 실패");
		if (retryCount >= 6)
		{
			System.out.println("24시간 이내에 로그인이 불가합니다");
		}
	}


}
