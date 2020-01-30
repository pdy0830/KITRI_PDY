package kitri.edu.mvc;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

@Component("chatwebsockethandler")
//각 클라이언트 접속 - 모든 웹소켓핸들러 list 1개 공유
public class ChatWebsocketHandler implements WebSocketHandler {
	
	public static ArrayList<WebSocketSession> list = new ArrayList<WebSocketSession>();
	
	@Override
	//클라이언트 연결
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		list.add(session);
		System.out.println("사용자 추가="+list.size());
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		//session: 웹소켓클라이언트(ip,...)
		//message: 클라이언트가 서버로 보낸 메시지(nick:message)
		//1개 클라이언트가 문자를 보내면 받음 나머지 모든 클라이언트에게 보냄
		 String msg = (String)message.getPayload();//메시지값을 읽어오는 것
		//나머지 모든 클라이언트에게 보냄
		 for(WebSocketSession ss:list) {
			 WebSocketMessage<String> sendmsg = new TextMessage(msg);
			 ss.sendMessage(sendmsg);
		 }
		 System.out.println("사용자 송수신="+list.size());
	}//handleMessage end

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// TODO Auto-generated method stub

	}
	
	@Override
	//클라이언트연결해제
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		list.remove(session);
		System.out.println("사용자 삭제="+list.size());
	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}

}
