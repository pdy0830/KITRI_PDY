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
업로드이미지파일명 : 
${bakeryVO.bakeryimage.originalFilename}
<h1>${model }</h1>

<img src="/mvc/resources/${bakeryVO.bakeryimage.originalFilename}">
</body>
</html>