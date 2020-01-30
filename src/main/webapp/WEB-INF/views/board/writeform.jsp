<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=path %>/resources/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
});
</script>
</head>
<body>
게시물작성<br>
<form action="/mvc/write.board" method="post">
제목: <input type=text name='title'><br>
작성자: <input type=text name='writer'><br>
내용: <textarea rows='5' cols='50' name='contents'></textarea><br>
암호:<input type=password name="pw"><br>
<input type=submit value="글쓰기">
</form>
</body>
</html>