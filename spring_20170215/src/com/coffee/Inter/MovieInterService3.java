package com.coffee.Inter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 강사님한테는 movieservice4 인 항목입니다

@Service(value = "movieInterService3")
public class MovieInterService3
{
	// 일부러 못 찾는 환경을 만드는 데 못 찾았을 때를 대비해서 방법을 준비해두자
	// 주입을 못 해도 괜찮다 필수가 아니다.. 라고 설정해두는 것 같다
	// 설정이 부족했는지 한번에 안 되어서 다음날에 이어서 하는 항목이다 > MovieServiceResource
	@Autowired
	IMovieDAO movieDAO2;

	@Override
	public String toString()
	{
		return "MovieInterService3 [movieDAO2=" + movieDAO2 + "]";
	}

}
