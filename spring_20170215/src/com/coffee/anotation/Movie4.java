package com.coffee.anotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.stereotype.Component;

// java.util.Date와 무언가를 한다

@Component(value = "movie4")
public class Movie4
{
	@DateTimeFormat(pattern="yyyy-MM-dd") // 그래서 날짜 형식을 알려주는 어노테이션.. 허허 > 여기까지 해주니까 날짜 잘 나온다
	@Value("2017-02-07") // 이런거 바로 집어넣을 수 없대ㅇㅇ value로 집어넣는 거 자체는 java.lang.String type
	private java.util.Date openday;
	// 날짜 변환해주는 메소드? 
	// 이 메소드는 날짜 형식을 알 수 없어서 내가 알려줘야지 변환을 시켜준다.. 하.. ㄴㄷ
	@Configuration
	static class Config
	{
		@Bean
		public FormattingConversionServiceFactoryBean conversionService()
		{
			return new FormattingConversionServiceFactoryBean();
		}
	}
	
	// 평범한 변수들..
	@Value("100")
	private String id;
	@Value("Arrival") // movie.setTitle("Arrival")
	private String title;
	@Value("5.0") // movie.setRating("5.0")
	private double rating;
	@Value("Amy Adams")
	private String actor;
	@Value("드니 빌뵈르")
	private String director;

	public String getId()
	{
		return id;
	}

	public String getTitle()
	{
		return title;
	}

	public double getRating()
	{
		return rating;
	}

	public String getActor()
	{
		return actor;
	}

	public String getDirector()
	{
		return director;
	}

	@Override
	public String toString()
	{
		return "Movie4 [openday=" + openday + ", id=" + id + ", title=" + title + ", rating=" + rating + ", actor=" + actor + ", director=" + director + "]";
	}

}
