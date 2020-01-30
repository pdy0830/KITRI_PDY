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
<h1>제품등록화면</h1>
<form action="<%=request.getContextPath()%>/store.bakery" method=post enctype="multipart/form-data">
이름<input type="text" name="bakeryname"><br>
가격<input type="number" name="price"><br>
수량<input type="text" name="balance"><br>
이미지파일<input type="file" name="bakeryimage"><br>
<input type=submit value="등록" >
</form>
</body>
</html>