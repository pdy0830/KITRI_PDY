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
$(document).ready(function(){
});
</script>
</head>
<body>
<table><tr><th>번호</th><th>제목</th><th>작성자</th><th>조회수</th></tr>
<c:forEach items="${list }" var="list"> 
<tr><td>${list.seq }
</td><td><a href='detail.board?seq=${list.seq }'>${list.title }</a>
</td><td>${list.writer }
</td><td>${list.viewcount }
</td></tr>
</c:forEach>
</table>
</body>
</html>