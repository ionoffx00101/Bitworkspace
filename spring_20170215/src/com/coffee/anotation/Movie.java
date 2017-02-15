package com.coffee.anotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 클래스 위 : 객체 생성해주세요
// @Component(value="movie") == Movie movie = new Movie()
@Component(value = "movie")
public class Movie
{
	// 속성 위 @Value : id의 set 메서드 호출 @Value("100") = movie.setId("100")
	@Value("100")
	String id;
	@Value("Arrival") // movie.setTitle("Arrival")
	String title;
	@Value("5.0") // movie.setRating("5.0")
	double rating;
	String actor;
	String director;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public double getRating()
	{
		return rating;
	}

	public void setRating(double rating)
	{
		this.rating = rating;
	}

	public String getActor()
	{
		return actor;
	}

	public void setActor(String actor)
	{
		this.actor = actor;
	}

	public String getDirector()
	{
		return director;
	}

	public void setDirector(String director)
	{
		this.director = director;
	}

	@Override
	public String toString()
	{
		return "Movie [id=" + id + ", title=" + title + ", rating=" + rating
				+ ", actor=" + actor + ", director=" + director + "]";
	}

}
