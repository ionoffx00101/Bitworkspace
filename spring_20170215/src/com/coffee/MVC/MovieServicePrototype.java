package com.coffee.MVC;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

// 객체를 그때 그때 재생성 해달라
// 클래스 위에 @Scope("prototype")

@Scope("prototype")
@Service(value="movieServicePrototype")
public class MovieServicePrototype
{
	@Inject // 공유 영역에서 
	@Named("movieDAO") // 이 이름을 찾아서
	MovieDAO movieDAO; // 여기에 넣어주는게 inject이 하는 일

	@Override
	public String toString()
	{
		return "MovieService [movieDAO = " + movieDAO +", MovieService의 객체 주소 = "+this.hashCode()+ "]";
	}
	
	
}
