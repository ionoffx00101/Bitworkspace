package com.coffee.MVC;

import org.springframework.stereotype.Repository;

// @Component(value="movieDAO")
@Repository(value = "movieDAO") // 웹서버 시작할때 한번에 다 객체생성되고 공유영역에 저장된다.
public class MovieDAO
{

}
