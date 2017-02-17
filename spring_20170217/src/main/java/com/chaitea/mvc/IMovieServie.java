package com.chaitea.mvc;

import org.springframework.web.servlet.ModelAndView;

import com.chaitea.vo.Movie;

public interface IMovieServie
{
	public ModelAndView viewMovie(Movie movie);
	public ModelAndView addMovie(Movie movie);
	public String addMovieForm();
}
