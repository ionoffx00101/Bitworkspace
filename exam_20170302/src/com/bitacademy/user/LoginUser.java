package com.bitacademy.user;

import org.springframework.web.socket.WebSocketSession;

public class LoginUser
{
	private User user;
	private WebSocketSession socket;
	// websocketsession에서 문제가 있는 듯하다.
	// jar파일을 못 붙이겠다네 왜

	public User getUser()
	{
		return user;
	}
	public void setUser(User user)
	{
		this.user = user;
	}
	public WebSocketSession getSocket()
	{
		return socket;
	}
	public void setSocket(WebSocketSession socket)
	{
		this.socket = socket;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((socket == null) ? 0 : socket.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginUser other = (LoginUser) obj;
		if (socket == null)
		{
			if (other.socket != null)
				return false;
		}
		else if (!socket.equals(other.socket))
			return false;
		return true;
	}

}
