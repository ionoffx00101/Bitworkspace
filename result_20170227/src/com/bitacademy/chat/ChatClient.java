package com.bitacademy.chat;

import java.io.Serializable;

import org.springframework.web.socket.WebSocketSession;

import com.bitacademy.user.User;

public class ChatClient implements Serializable {
  private static final long serialVersionUID = -4799853568789502603L;

  private User user;
  private WebSocketSession socket;

  public User getUser() {
    return user;
  }

public WebSocketSession getSocket() {
	return socket;
}

public void setSocket(WebSocketSession socket) {
	this.socket = socket;
}

public void setUser(User user) {
	this.user = user;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((socket == null) ? 0 : socket.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ChatClient other = (ChatClient) obj;
	if (socket == null) {
		if (other.socket != null)
			return false;
	} else if (!socket.equals(other.socket))
		return false;
	return true;
}

@Override
public String toString() {
	return "ChatClient [user=" + user + ", socket=" + socket + "]";
}


}
