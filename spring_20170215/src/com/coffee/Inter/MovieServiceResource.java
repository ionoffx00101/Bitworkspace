package com.coffee.Inter;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;


@Service(value="movieServiceResource")
public class MovieServiceResource
{
	@Resource(name="movieDAO1")
	IMovieDAO movieDAO1;

	@Resource // 아무것도 없으면 속성명과 같은 이름의 객체를 찾아서 대입해준다
	IMovieDAO movieDAO2;

	@Override
	public String toString()
	{
		return "MovieServiceResource [movieDAO1=" + movieDAO1 + ", movieDAO2=" + movieDAO2 + "]";
	}
	
}
