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
모든 회원 정보를 출력합니다.<br>
<c:forEach items="${listmodel }" var="member">
${member.id } 회원님 ${member.name }<br>
</c:forEach>
${listmodel } <!-- toString() -->
</body>
</html>