package com.chaitea.mvc;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chaitea.vo.Movie;

@Controller
public class MovieService implements IMovieServie
{
	@RequestMapping("viewMovie") // /viewMovie.do
	@Override
	public ModelAndView viewMovie(Movie movie) // 오는 값이 String이여도 디스팩쳐가 Long파라미터면 변환해서 넣어준다 착한애다..
	{
		// 새 모뷰 객체 생성
		ModelAndView mav = new ModelAndView();
		// 비어 있는 새 모뷰에 데이터 넣기
		mav.addObject("movie", movie);
		// 데이터가 들어간 모뷰객체한테 갈 곳 정해주기
		mav.setViewName("viewMovie.jsp");
		// 모뷰 떠나보냅니다..
		return mav;
	}

	@RequestMapping("addMovie") // /addMovie.do
	@Override
	public ModelAndView addMovie(Movie movie) // 알아서 객체 타입 보고 디스팩쳐가 넣어준다
	{
		// 새 모뷰 객체 생성
		ModelAndView mav = new ModelAndView();
		// 비어 있는 새 모뷰에 데이터 넣기
		mav.addObject("movie", movie);
		// 데이터가 들어간 모뷰객체한테 갈 곳 정해주기
		mav.setViewName("viewMovie"); // .jsp치든 안치든 viewMovie메소드로 넘어가는게 운명이구나
		// mav.setViewName("redirect:/viewMovie");
		// redirect쓸때는 requestMappping 그 값 넣으면 됨
		// redirect쓰니까 안되는골.. ??
		// 모뷰 떠나보냅니다..
		return mav;
	}

	// addMovieForm.jsp로 이동함 
	@RequestMapping("movieaddForm")
	public String addMovieForm()
	{
		// ModelAndView mav = new ModelAndView();
		// mav.setViewName("addMovieForm.jsp");
		// 쉽게 쉽게 삽시다
		return "movieaddForm.jsp"; // 다른 메소드 갈때는 "redirect:/addMovieForm"
	}
}
