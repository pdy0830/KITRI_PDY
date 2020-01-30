<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="jquery-3.2.1.min.js"></script>
<script>
	$(document).ready(function() {
	});
</script>
</head>
<body>
	<h1>detail.jsp</h1>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성자</th>
			<th>작성시간</th>
			<th>조회수</th>
		</tr>
		<tr>
			<td>${detail.seq }</td>
			<td>${detail.title }</td>
			<td>${detail.contents }</td>
			<td>${detail.writer }</td>
			<td>${detail.time }</td>
			<td>${detail.viewcount }</td>
		</tr>
		</table>
</body>
</html>