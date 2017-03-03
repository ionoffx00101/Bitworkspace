package com.bitacademy.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.bitacademy.chat.ChatClient;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;

public class LoginUserListHandler extends TextWebSocketHandler // handler 들은 handler를 상속한다
{
	@Inject
	@Named("loginUserList")
	private ArrayList<LoginUser> loginUserList;

	@Inject
	@Named("userDAO")
	private UserDAO userDAO;

	@Override
	protected void handleTextMessage(WebSocketSession socket, TextMessage message) throws Exception
	{

		synchronized (loginUserList) // 동기화 되어있음
		{
			String msgFromClient = message.getPayload(); // 이게 맞는 지 잘 기억안난다.
			if (msgFromClient.startsWith("start"))
			{
				// 새 로그인유저 객체 생성
				LoginUser loginUser = new LoginUser();
				// 로그인 유저에 소켓 집어넣기
				loginUser.setSocket(socket);

				// ? 뭐하라고 만드는 지 잘 모르겠는 StringTokenizer
				StringTokenizer st = new StringTokenizer(msgFromClient, ",");
				st.nextToken();
				// 2.5 st.nextToken() 호출한 값을 변수에 저장 - 이값은 클라이언트의 아이디
				String clientID = st.nextToken();
				// 사용자 정보 가져와서 로그인 유저에 넣기
				loginUser.setUser(userDAO.findOne(clientID));

				loginUserList.add(loginUser); // 추가

				// json으로 변환 / 근데 왜 xstream으로 시키지 ㅠ
				XStream xStream = new XStream(new JsonHierarchicalStreamDriver());
				// 이건 어떻게 하는 건지.. / 2.10 이때 socket 속성은 json으로 변환하지 않는다
				xStream.omitField(WebSocketSession.class, "socket");
				// 이때 User 객체의 태그 이름은 “user” 로 설정한다
				xStream.alias("user", User.class);

				// 2.11 ArrayList를 생성해서 변수에 저장
				// 변수형은..? String에서 아래 풀다가 User로 바꿈
				ArrayList<User> what = new ArrayList<User>(); // userList

				for (int i = 0; i < loginUserList.size(); i++) // LoginUser otherUser : loginUser?
				{
					// 2.12.1 loginUserList에서 LoginUser객체를 하나 꺼내서 변수에 저장
					LoginUser whatloginuser = loginUserList.get(i);

					// 2.12.2 2.12.1 에서 User속성을 변수에 저장
					User whatuser = whatloginuser.getUser();

					// 2.12.3 2.12.2 변수를 2.11 에 추가
					what.add(whatuser);
				}
				// String jsonString = xStream.toXML(2.11변수);
				String jsonString = xStream.toXML(what);

				// 2.14 2.13 을 TextMessage 객체로 변환 new TextMessage(2.13변수) 해서 변수 저장
				TextMessage tm = new TextMessage(jsonString);

				// 2.14 loginUserList에서 LoginUser 객체하나를 리턴받고
				// LoginUser 의 socket 속성을 리턴받아서 socket을 이용해서
				// 전체 클라이언트에게 2.14 변수 전송
				// 뭘 리턴 받으라는 건지 감도 안잡힌다
				// 나는 무슨 문제를 풀고 있는 걸까
				// 이클립스야 너는 아느냐
				// ???

				// 전송
				for (int i = 0; i < loginUserList.size(); i++)
				{
					LoginUser oneUserstateLogin = loginUserList.get(i);
					oneUserstateLogin.getSocket();
					// 소켓을 이용해서 보내라는게 뭔 말인지 아시는분?
					// 나만 모르는 듯 하다
					// 호호
					// 이거 쓰면 되는 건지 잘 모르겠네.. 흠
					broadCast(jsonString);
				}
			}
		}
	}
	private void broadCast(String xmlMsg) throws IOException
	{
		for (LoginUser client : loginUserList)
		{
			WebSocketSession clientSession = client.getSocket();
			clientSession.sendMessage(new TextMessage(xmlMsg));
		}
	}
}
