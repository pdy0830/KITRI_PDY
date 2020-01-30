<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=path %>/resourcesjquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
});
</script>
</head>
<body>
로그인결과는 다음과 같습니다<br>
<%-- <%=request.getParameter("id1") %> 아이디는 ${result }
request.getParameter("xxx") xxx을 매번 바꿔줘야함 --%>

<!-- mav.addObject("loginid",id); //Param value가 뭐가 됐든 loginid에 담김 -->
<%-- ${loginid } 아이디는 ${result } --%>
${model.id } 아이디는 ${result }
</body>
</html>