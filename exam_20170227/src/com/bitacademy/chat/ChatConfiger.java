package com.bitacademy.chat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

// 이 클래스는 호출을 받기 위해 만든 클래스 이다.
// Interface WebSocketConfigurer // chat.do(채팅보낸다는 신호) 요청시 WebSocket이 채팅 url이라는 걸 알고 ChatHandler를 실행해달라를 저따 설정함
@Configuration // WebSocket 설정
@EnableWebSocket // WebSocket 사용가능
@EnableWebMvc // WebMvcConfigurerAdapter 동작가능
public class ChatConfiger extends WebMvcConfigurerAdapter implements WebSocketConfigurer
{
	// @Bean // ChatHandler 객체가 기존에 존재하면 그걸 쓰고 없으면 새 객체를 만들어서 리턴.
	@Bean
	public ChatHandler getHandler()
	{
		return new ChatHandler();// 메서드 한번만 실행 bean사용
	}
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry)
	{
		registry.addHandler(getHandler(), "chat.do").withSockJS(); // create socket method
	}
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
	{
		// TODO Auto-generated method stub

		configurer.enable();
	}

}
