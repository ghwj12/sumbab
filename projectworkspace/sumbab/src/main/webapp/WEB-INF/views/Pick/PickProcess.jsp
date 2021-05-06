<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보관함에 담기</title>
</head>
<body>
	<c:choose>
	<c:when test="${identified}">
		<c:if test="${result == 0}">보관함에 담았습니다!</c:if>
		<c:if test="${result == 1}">보관함에 이미 담겨 있는 가게입니다!</c:if><br><br>
	</c:when>
	<c:otherwise>
		<c:if test="${result == 0}">비회원 보관함에 담았습니다!</c:if>
		<c:if test="${result == 1}">비회원 보관함에 이미 담겨 있는 가게입니다!</c:if><br><br>
		<input type="button" value="로그인 하기" onclick="javascript:opener.location.href='/project/로그인 페이지url';self.close()">
	</c:otherwise>
	</c:choose>
	<input type="button" value="보관함으로 이동" onclick="javascript:opener.location.href='/project/보관함 페이지url';self.close()">
	<input type="button" value="확인" onclick="javascript:self.close()">
</body>
</html>