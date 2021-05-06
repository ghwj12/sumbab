<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정지 해제</title>
</head>
<body>
	<form:form method="POST">
	${id}님의 
	<c:choose>
		<c:when test="${classify == 4}">리뷰</c:when>
		<c:otherwise>리뷰 신고</c:otherwise>
	</c:choose>
	정지를 해제 하시겠습니까?<br><br>
	<input type="submit" value="해제">
	<input type="button" value="취소" onclick="javascript:self.close()">
	</form:form>
</body>
</html>