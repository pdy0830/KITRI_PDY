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
${empVO.employee_id } 사번 사원을 등록했습니다.<br>
<a href="/mvc/mybatis/emplist">여기서 </a> 등록한 사원을 확인하세요.
</body>
</html>