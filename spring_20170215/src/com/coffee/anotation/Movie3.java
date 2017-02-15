package com.coffee.anotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 생성자를 통해 호출하고 값을 넣음

@Component(value = "movie3")
public class Movie3
{
	private String id;
	private String title;
	private double rating;
	private String actor;
	private String director;
	
	public Movie3(@Value("200") String id,@Value("ToboWorld") String title,@Value("5.0") double rating,@Value("Tobo") String actor,@Value("Nora") String director)
	{
		super();
		this.id = id;
		this.title = title;
		this.rating = rating;
		this.actor = actor;
		this.director = director;
	}

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
		return "Movie3 [id=" + id + ", title=" + title + ", rating=" + rating + ", actor=" + actor + ", director=" + director + "]";
	}

	
}
