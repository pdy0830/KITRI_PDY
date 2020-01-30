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
$(document).ready(function(){
	$("#loginajaxbtn").on('click',function(){
		$.ajax({
			url:'/mvc/ajax/login',
			data:{'id':$("#id").val(),'pw':$("#pw").val()},
			type:'post',
			dataType:'json',
			success:function(data){
				//{result:xxx, logintime: ...}
				$("#loginresultdiv").html(data.result+" : "+data.logintime);
				if(data.result=='ok'){
					$('body').append('<input type=button id="boardajaxbtn" value="게시물주세요">');
					$('body').append('<div id="boardresultdiv"><div>')
				}
				
			},
			error:function(err){
				alert(err);
			}
		});//ajax end
	});//on end
	
	//게시물 리스트 받을것
	$('body').on('click',"#boardajaxbtn",function(){ //ajax로 동적으로 추가되었기 때문에 이 태그의 부모를 먼저 지정하고, 새로생긴 #boardajaxbtn를 클릭하면으로 해줘야해
		$.ajax({
			url:'/mvc/ajax/boardlist',
			type:'get',
			dataType:'json',
			success:function(server){
				//ArrayList<BoardVO> 자바스크립트->배열
				var list='';
				for(var i=0; i<server.length; i++){
					list+="<a href='' id='"+server[i].seq+"'>" +server[i].title+"</a>"+":" + server[i].contents+"<br>";
					//list +="<a href='/mvc/ajax/oneboard' id=''>"+server[i].title +"</a>"+":" + server[i].contents+"<br>";
				}
				$("#boardresultdiv").html(list);
				$('body').append('<div id="oneboarddiv"></div>');
			},
			error:function(err){
				alert(err);
			}
		});//ajax end
	});//on end
	
	
	$('body').on('click',"a",function(e){
		//a 태그 기본 동작 해제
		e.preventDefault();
		// /mvc/ajax/oneboard : ajax 요청
		// 제목클릭시 
		$.ajax({
			url:'/mvc/ajax/oneboard',
			data:{'seq' : $(this).attr("id")},
			type:'get',
			dataType:'json',
			success:function(server){
				for(var i=0; i<server.length; i++){
					$("#oneboarddiv").html(server[i].seq +":"+ server[i].title +":"+ server[i].contents +":"+ server[i].writer);
				}
			},
			error:function(err){
				alert(err);
			}
		});//ajax end
	});//on end
	
	
});
</script>
</head>
<body>
ajax 로그인폼<br>
<form action="/mvc/ajax/login" method=post>
아이디입력:<input type=text name="id" id="id"><br>
암호입력:<input type=password name="pw" id="pw"><br>
<input type=submit value="로그인">
<input id="loginajaxbtn" type=button value="ajax로그인">
</form>
<div id="loginresultdiv"></div>
</body>
</html>