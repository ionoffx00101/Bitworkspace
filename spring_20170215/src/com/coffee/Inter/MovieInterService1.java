package com.coffee.Inter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "movieInterService1")
public class MovieInterService1
{
	@Autowired // 아래 변수이름이랑 같은 이름을 공유영역에서 찾아서 넣어준다
	IMovieDAO movieDAO1;

	@Override
	public String toString()
	{
		return "MovieInterService1 [movieDAO1=" + movieDAO1 +"]";
	}

}
