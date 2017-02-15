package com.coffee.Inter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "movieInterService2")
public class MovieInterService2
{
	@Autowired
	IMovieDAO movieDAO2;

	@Override
	public String toString()
	{
		return "MovieInterService2 [movieDAO2=" + movieDAO2 + "]";
	}

}
