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
uploadresult_spring.jsp
<h4>${uploadVO.file1.originalFilename }</h4>
<h4>${uploadVO.file2.originalFilename }</h4>
<h1>업로드완료</h1>
</body>
</html>