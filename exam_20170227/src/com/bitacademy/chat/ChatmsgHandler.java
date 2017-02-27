package com.bitacademy.chat;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.bitacademy.user.User;
import com.bitacademy.user.UserDAO;

public class ChatmsgHandler extends TextWebSocketHandler
{
	@Inject
	@Named("userDAO")
	private UserDAO userDAO;
	@Inject
	@Named("chatmsgDAO")
	private ChatmsgDAO chatmsgDAO;
	@Inject
	@Named("clientList")
	private ArrayList<ChatClient> clientList;

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception
	{

		String payload = message.getPayload();
		synchronized (clientList)
		{

			if (payload.startsWith("start"))
			{
				// 2.1 ChatClient 객체 생성
				// 2.2 2.1 객체의 socket 속성에 매개변수 socket 저장
				ChatClient chatclient = new ChatClient();
				chatclient.socket = session;
				StringTokenizer st = new StringTokenizer(payload, ",");
				String clientChild = st.nextToken();
				// 2.6
				User user = userDAO.findOne(clientChild);
				// 2.7
				chatclient.user = user;
				clientList.add(chatclient);
				// 2.10
				List<Chatmsg> currentChat = chatmsgDAO.findAll();
				// xstream 하라는 데 그거 싫다 json으로 하자 하.. 할말을 잃었따.
				//Jsonparser?
				//new TextMessage((TextMessage)currentChat);
				
			}
			else if (payload.startsWith("end"))
			{
				clientList.remove(session);
				// session.close();
			}
			else
			{
				for (int i = 0; i < clientList.size(); i++)
				{
					ChatClient socket = clientList.get(i);
					//socket.sendMessage(message);
				} // end for
			} // end else
		} // end synchronized
	}// end method
}// end class