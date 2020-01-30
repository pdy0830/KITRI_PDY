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
<!-- id검색/이름검색 선택 : ja 입력/김 입력 : 검색요청버튼 클릭하면
	컨트롤러 내부 메소드 추가정의 : public ? searchlist(?){
		id에 ja 포함 회원 리스트만 출력 뷰
		name에 김 포함 회원 리스트만 출력 뷰} -->
<!-- http://ip:port/mvc/member/searchlist?searchitem=id검색&searchword=ja -->
<form action="/mvc/member/searchlist">
<select name="searchitem">
 <c:forEach items="${searchmodel }" var="searchcondition">
  <option>${searchcondition }</option> 
 </c:forEach>
</select>
<input type="text" name="searchword">
<input type="submit" value="검색요청">
</form>
<h1>검색가능한 회원 정보를 출력합니다.</h1>
<c:forEach items="${listmodel }" var="member">
${member.id } 회원님 ${member.name }<br>
</c:forEach>

</body>
</html>