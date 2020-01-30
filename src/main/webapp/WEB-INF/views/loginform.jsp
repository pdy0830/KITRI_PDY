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
로그인화면을 생성합니다.<br>
<form action="/mvc/login" method=post>
아이디생성:<input type=text name="id"><br>
암호입력:<input type=password name="pw"><br>
<input type=submit value="로그인">
</form>
</body>
</html>