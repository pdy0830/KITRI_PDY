<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- <%=request.getContextPath()+"/resources/jquery-3.2.1.min.js" %>
 --%>
<script src=<%=request.getContextPath()+"/resources/jquery-3.2.1.min.js"%>></script>
</head>
<body>
<img src='<%=request.getContextPath()+"/resources/images/google.png"%>'><br>
<table><tr><th>사번</th><th>이름</th><th>급여</th><th>입사일</th></tr>
<c:forEach items="${emp }" var="empvo"> 
<tr><td>${empvo.id }
</td><td>${empvo.name}
</td><td>${empvo.salary }
</td><td>${empvo.hiredate}
</td></tr>
<%-- ${empvo }<br> --%>
</c:forEach>
</table>
</body>
</html>