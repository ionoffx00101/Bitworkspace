package com.bitacademy.chat;

import java.io.IOException;
import java.sql.Date;
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

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ChatmsgHandler extends TextWebSocketHandler {

	@Inject
    @Named("userDAO")
    private UserDAO userDAO;
    @Inject
    @Named("chatmsgDAO")
     private ChatmsgDAO chatmsgDAO;
     @Inject
     @Named("socketList")
     private ArrayList<ChatClient>clientList;


  @Override
  protected void handleTextMessage(WebSocketSession socket, TextMessage message) throws Exception {
    synchronized (clientList) {
    	//1.클라이언트가 전송한 메시지 리턴 
      String payload = message.getPayload();
      //2.클라이언트가 전송한 메시지가 start로 시작하면
      if (payload.startsWith("start")) {
    	//2.1 ChatClient 객체 생성
        ChatClient chatClient = new ChatClient();
        //2.2 2.1 객체의 socket 속성에 매개변수 socket 저장
        chatClient.setSocket(socket);
        //2.3 StringTokenizer st=new StringTokenizer(1변수,",");
        StringTokenizer st = new StringTokenizer(
        		 payload, ",");
        //2.4 st.nextToken();
        st.nextToken();
        //2.5 st.nextToken() 호출한 값을 변수에 저장 - 이값은 클라이언트의 아이디
        String id = st.nextToken();
        //2.6 userDAO.findOne(2.5변수) 호출해서 사용자 정보를 변수에 저장
        User user = userDAO.findOne(id);
        ////2.7 2.1의 ChatClient객체에 2.6 저장
        chatClient.setUser(user);
        //2.8 2.1을 clientList 에 저장
        clientList.add(chatClient);
    //  2.9 chatmsgDAO.findAll() 호출해서 지금까지 채팅메시지를 변수에 저장
        List<Chatmsg> chatmsgList = 
        		chatmsgDAO.findAll();
    //  2.10 2.9의 변수를 xml로 변환시키는 XStream 객체 생성
        XStream xStream = new XStream(new DomDriver("UTF-8"));
     // Chatmsg 객체의 태그이름은 chatmsg로 설정한다
        xStream.alias("chatmsg", Chatmsg.class);
        xStream.setMode(XStream.NO_REFERENCES);
    //  2.11 2.9변수를 xml로 변환해서 변수 저장
        String chatmsgListXml = xStream.toXML(chatmsgList);
     // 2.12 2.11 변수를 TextMessage 객체로 변환 new TextMessage(2.11변수) 해서 변수 저장
        TextMessage chatmsgListXmlMsg = 
        		new TextMessage(chatmsgListXml);
        // 2.13 2.12 변수를 매개변수 socket 에게 전송
        socket.sendMessage(chatmsgListXmlMsg);
        //2.14  Chatmsg 객체 생성
        Chatmsg chatmsg = new Chatmsg();
      //2.15 2.14 객체의 user속성에  2.6 저장
        chatmsg.setUser(user);
      //2.16 2.14 객체의 msg 속성에 "님이 접속하셨습니다" 저장
        chatmsg.setMsg("님이 접속하셨습니다");

        xStream.alias("chatmsg", Chatmsg.class);
      //2.17 2.14 객체를 xml 로 변환해서 변수에 저장
        String chatmsgXml = xStream.toXML(chatmsg);
        //2.18  2.17 변수를 TextMessage 객체로 변환 new TextMessage(2.17변수) 해서 변수 저장
       // 2.7.9 clientList에서 ChatClient 객체하나를 리턴받고 ChatClient의 socket 속성을 리턴받아서 socket을 이용해서 전체 클라이언트에게 2.18 변수 전송
        broadCast(chatmsgXml);

      } 
      //2.클라이언트가 전송한 메시지가 msg로 시작하면
      else if (payload.startsWith("msg")) {
    	//2.1 ChatClient 객체 생성
        ChatClient chatClient = new ChatClient();
      //2.2 2.1 객체의 socket 속성에 매개변수 socket 저장
        chatClient.setSocket(socket);
      //2.3 StringTokenizer st=new StringTokenizer(클라이언트가 보낸 메시지,",");
        StringTokenizer st = new StringTokenizer(payload, ",");
      //2.4 st.nextToken(); --"msg"
        st.nextToken();
        //2.5 st.nextToken() 호출한 값을 변수에 저장 - 이값은 클라이언트의 채팅메시지
        String msg = st.nextToken();
      //2.6  clientList.indexOf(2.1객체) 을 호출해서 해당 소켓의 인덱스는 변수에 저장
        int index = clientList.indexOf(chatClient);
        if (index > -1) {
        	// 2.7.1  해당 인덱스의 ChatClient 객체 리턴받아서 변수에 저장 clientList.get(2.6변수)
          ChatClient msgClient = clientList.get(index);
          //2.7.2  2. 7.1 변수의 User속성 변수에 저장
          User msgUser = msgClient.getUser();
          // 2.7.3 ChatMsg 객체 생성하고 msg 속성에 클라이언트가 보낸 메시지 저장
          Chatmsg chatmsg = new Chatmsg();
       // 2.7.4 2.7.3 객체의 User 속성에 2.7.2 변수 저장
          chatmsg.setMsg(msg);
          chatmsg.setUser(msgUser);
          java.sql.Date now=
        		  new java.sql.Date(
        				  new java.util.Date().getTime());
          chatmsg.setMsgdate(now);
          //chatmsgDAO.save(chatmsg);
        //2.7.6  ChatMsg객체를 xml로변환시킬 Xstream 생성
          XStream xStream = new XStream(
        		  new DomDriver("UTF-8"));
          xStream.setMode(XStream.NO_REFERENCES);
          xStream.alias("chatmsg", Chatmsg.class);
          //2.7.7 2.7.3 객체를 xml로 변환 (ChatMsg 객체의 태그 이름은 chatmsg)

          String chatmsgXml = xStream.toXML(chatmsg);
          //2.7.8 2.7.7을  TextMessage로 변환 new TextMessage(2.7.7변수)
        //2.7.9 clientList에서 ChatClient 객체하나를 리턴받고 ChatClient의 socket 속성을 리턴받아서 socket을 이용해서 전체 클라이언트에게 2.7.7 변수 전송
          broadCast(chatmsgXml);

        }
      }
 //2.클라이언트가 전송한 메시지가 end로 시작하면
      
       









     
      else if (payload.startsWith("end")) {
    	    //2.1 ChatClient 객체 생성
        ChatClient chatClient = new ChatClient();
      //2.2 2.1 객체의 socket 속성에 매개변수 socket 저장
        chatClient.setSocket(socket);
      //2.6  clientList.indexOf(2.1객체) 을 호출해서 해당 소켓의 인덱스는 변수에 저장
        int index = clientList.indexOf(chatClient);
      //2.7 2.6이 0이상이면 
        if (index > -1) {
        	// 2.7.1  해당 인덱스의 ChatClient 객체 리턴받아서 변수에 저장 clientList.get(2.6변수)
          ChatClient msgClient = clientList.get(index);
        //2.7.2  2. 7.1 변수의 User속성 변수에 저장
          User removeUser = msgClient.getUser();
       // 2.7.3 ChatMsg 객체 생성하고 msg 속성에 "님이 나가셨습니다" 저장
          Chatmsg chatmsg = new Chatmsg();
          chatmsg.setMsg("님이 나가셨습니다");
       // 2.7.4 2.7.3 객체의 User 속성에 2.7.2 변수 저장
          chatmsg.setUser(removeUser);
        //2.7.5 clientList.remove(2.6변수);
          clientList.remove(chatClient);
        //2.7.6  ChatMsg객체를 xml로변환시킬 Xstream 생성 -2월 22일 실습 CarService 에서 XStream 부분 참조
          XStream xStream = new XStream(new DomDriver("UTF-8"));
          xStream.setMode(XStream.NO_REFERENCES);
        //2.7.7 2.7.3 객체를 xml로 변환 (ChatMsg 객체의 태그 이름은 chatmsg)
          xStream.alias("chatmsg", Chatmsg.class);
        //2.7.8 2.7.7을  TextMessage로 변환시킴 new TextMessage(2.7.7변수)
          String chatmsgXml = xStream.toXML(chatmsg);
        //2.7.9 clientList에서 ChatClient 객체하나를 리턴받고 ChatClient의 socket 속성을 리턴받아서 socket을 이용해서 전체 클라이언트에게 2.7.7 변수 전송
          broadCast(chatmsgXml);
        }
      }

    }
  }

  private void broadCast(String xmlMsg) throws IOException {
    for (ChatClient client : clientList) {
      WebSocketSession clientSession = client.getSocket();
      clientSession.sendMessage(new TextMessage(xmlMsg));
    }
  }
}
