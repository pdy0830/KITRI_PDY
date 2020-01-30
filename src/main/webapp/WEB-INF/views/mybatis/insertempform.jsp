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
<form action="/mvc/mybatis/insertemp" method=post>
사번 <input type="text" name="employee_id"><br>
성 <input type="text" name="last_name"><br>
이름 <input type="text" name="first_name"><br>
이메일 <input type="text" name="email"><br>
직종코드
<select name="job_id">
	<c:forEach items="${model }" var="job_id">
		<option>${job_id }</option>
	</c:forEach>
</select>
<input type="submit" value="사원등록">
</form>
</body>
</html>