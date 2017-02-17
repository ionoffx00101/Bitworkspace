package com.chaitea.resolver;

import java.text.SimpleDateFormat;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

import com.chaitea.vo.Actor;
import com.chaitea.vo.Movie;

public class MovieArgumentResolver implements WebArgumentResolver
{
	// movie 객체에 바로 들어갈수있게 이 리졸버가
	// 그 속성다른 객체가 지나감ㄴ 낚아채서 바꿔서 movie에 넣어준다
	// 매개 변수 타입이 Movie클래스일때만 끼어든다
	// MethodParameter 에는 MovieService의 addMovie의 매개변수 정보가 들어있다
	// NativeWebRequest에는 입력 정보가 들어있다
	@Override
	public Object resolveArgument(MethodParameter parameter, NativeWebRequest request) throws Exception
	{
		// 메소드의 파라미터 타입이 Movie일때만 끼어든다
		if (parameter.getParameterType() == Movie.class)
		{
			// 무비 객체를 만듬
			Movie movie = new Movie();
			// 무비 객체 안에 넣을 배우 객체를 만듬
			Actor actor = new Actor();

			movie.setNum(Long.parseLong(request.getParameter("movienum")));
			movie.setName(request.getParameter("name"));

			// reqest에 있는 date를 String으로 받음
			String requestDate = request.getParameter("odate");
			// 트랜스 포맷 만들어줌
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
			// 트랜스 포맷에 스트링 날짜넣고 돌려버림
			java.util.Date utilDate = transFormat.parse(requestDate);
			// 새 sql.Date는 유틸날짜의 가져온다 시간
			movie.setOpenDate(new java.sql.Date(utilDate.getTime()));

			// actor에 request에 있던 actorname을 넣어주고 데이터 들어간 actor를 movie에 넣음
			actor.setActorname(request.getParameter("actorname"));
			movie.setActor(actor);

			// movie는 movieService(Movie <movie>)로 간다
			return movie;
		}
		// 기본 리턴값 WebArgumentResolver.UNRESOLVED 난 아무것도 안하고 서블렛으로 넘어간다.
		return WebArgumentResolver.UNRESOLVED;
	}
}
