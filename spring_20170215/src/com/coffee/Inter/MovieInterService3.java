package com.coffee.Inter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "movieInterService3")
public class MovieInterService3
{
	// 일부러 못 찾는 환경을 만드는 데 못 찾았을 때를 대비해서 방법을 준비해두자
	// 주입을 못 해도 괜찮다 필수가 아니다.. 라고 설정해두는 것 같다
	/*@Autowired(required=false)
	IMovieDAO movieDAO;

	@Override
	public String toString()
	{
		return "MovieInterService3 [movieDAO=" + movieDAO + "]";
	}*/

}
