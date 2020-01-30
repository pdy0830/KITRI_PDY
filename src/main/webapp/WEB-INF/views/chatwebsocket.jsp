<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/mvc/resources/jquery-3.2.1.min.js"></script>
<script>
var websocket;
$(document).ready(function() {
	$("#enterbtn").on('click',function(){
		websocket = new WebSocket("ws://localhost:8081/mvc/chatws");//서버연결해라
		//http://192.168.15.200:8082/mvc/
		//서버가 응답결과(메시지) 전송받았을 때 자동 처리내용
		websocket.onmessage = function(server){
			
			var who = server.data.split(":")[0];//메시지를 보낸 사람
			var me = $("#nickname").val();
			if(me==who){
				$("#chatmessagearea").append($("<div>"+server.data+"</div>")
							.css("background-color","yellow")
							.css("text-align",'right')
							.css('line-height', "200%")
				); /* //css여기만 입혀야함 */
			}
			else{
				$("#chatmessagearea").append(server.data+"<br>");
			}

		}
		//서버와 연결되었을 때 자동 처리내용
		websocket.onopen=function(){
			console.log("웹소켓 연결 성공");	
		}
		//서버와 연결해제되었을 때 자동 처리내용
		websocket.onclose=function(){
			console.log("웹소켓 연결해제 성공");	
		}
	});//on end
	$("#exitbtn").on('click',function(){
		websocket.close();
	});
	//현재 클라이언트가 서버로 '닉네임:문자'형식으로 보냄
	$("#sendbtn").on('click',function(){
		var nick=$("#nickname").val();
		var msg = $("#message").val();
		websocket.send(nick+":"+msg); //서버로 전송
	});
});
</script>
</head>
<body>
   아이디 :
   <input type=text id="nickname" value="${param.id }">
   <input type=button id="enterbtn" value="채팅방입장">
   <input type=button id="exitbtn" value="채팅방퇴장">

   <h1>채팅방</h1>
   <div id="chatarea">
      <div id="chatmessagearea"></div>
   </div>
   
   전송할 메세지 : <input type="text" id="message">
   <input type=button id="sendbtn" value="메시지전송">
</body>
</html>