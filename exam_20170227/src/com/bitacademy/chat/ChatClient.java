package com.bitacademy.chat;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.web.socket.WebSocketSession;

import com.bitacademy.user.User;

public class ChatClient
{
	User user;
	WebSocketSession socket;
	
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
		ChatClient other = (ChatClient) obj;
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
