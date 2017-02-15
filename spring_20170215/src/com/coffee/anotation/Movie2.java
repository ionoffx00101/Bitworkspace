package com.coffee.anotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 속성들이 private고 set메소드가 없다

// 클래스 위 : 객체 생성해주세요
// @Component(value="movie") == Movie movie = new Movie()
// 공유영역에 movie2라는 이름으로 객체가 생성되어있어서 application영역에서 movie2라는 이름으로 이 클래스를 꺼내서 쓸 수 있다..
// 사실 공유영역에 들어가는 건 component가 만들어주는 비밀자식 MovieImpl이였다..
@Component(value = "movie2")
public class Movie2
{
	// 속성 위 @Value : id의 set 메서드 호출 @Value("100") = movie.setId("100")
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
		return "Movie2 [id=" + id + ", title=" + title + ", rating=" + rating + ", actor=" + actor + ", director=" + director + "]";
	}

	

}
