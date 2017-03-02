package com.bitacademy.chat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.bitacademy.user.LoginUserListHandler;

@Configuration
@EnableWebSocket
@EnableWebMvc
public class ChatmsgConfig 
   extends WebMvcConfigurerAdapter implements WebSocketConfigurer{
	@Bean
	public ChatmsgHandler getHandler(){
		return new ChatmsgHandler();
	}
         @Bean
	public LoginUserListHandler getLoginUserListHandler (){
		return new LoginUserListHandler();
	}
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(getHandler(), "chatmsg.do").withSockJS();
                      registry.addHandler(getLoginUserListHandler(), "loginUserList.do").withSockJS();
	}
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		 configurer.enable();
	}
}
