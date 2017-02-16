package com.coffee.Inter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "movieService4")
public class MovieService4
{

	// 이건 나한테는 없는 항목(movieDAO)을 엮어달라고 하는 멍청한 코드이다
	// 이걸 그냥 실행하면 오류가 난다

	// IMovieDAO는 자식객체가 두개임 (속성값이 한개 초과면)
	// (required = false)을 사용해서 오류를 넘길수 없음
	// @Autowired
	// IMovieDAO movieDAO;

	// IActor 타입은 자식 객체가 한개도 없음
	// (required = false)을 사용해서 오류를 넘길수 있음
	@Autowired(required = false)
	IActor acotr;

	// @Override
	// public String toString()
	// {
	// return "MovieService4 [movieDAO=" + movieDAO + ", acotr=" + acotr + "]";
	// }

}
