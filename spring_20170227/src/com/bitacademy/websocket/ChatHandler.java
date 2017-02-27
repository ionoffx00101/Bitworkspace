package com.bitacademy.websocket;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatHandler extends TextWebSocketHandler
{
	@Resource(name = "sessionList")
	private ArrayList<WebSocketSession> sessionList;

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception
	{

		String payload = message.getPayload();
		synchronized (sessionList)
		{
			if (payload.startsWith("start"))
			{
				sessionList.add(session);
			}
			else if (payload.startsWith("end"))
			{
				sessionList.remove(session);
				// session.close();
			}
			else
			{
				for (int i = 0; i < sessionList.size(); i++)
				{
					WebSocketSession socket = sessionList.get(i);
					socket.sendMessage(message);
				} // end for
			} // end else
		} // end synchronized
	}// end method
}// end class
