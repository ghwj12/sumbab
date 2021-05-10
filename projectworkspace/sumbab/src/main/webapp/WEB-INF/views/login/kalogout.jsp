<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
<table>
<c:choose>
	<c:when test="${not empty SessionScope.access_Token}">
		<li> 오류 발생</li>
	
	
	</c:when>
	<c:otherwise>
		<form >
		토큰 :<%= session.getAttribute("access_Token") %> 
		로그 아웃 되었습니다.
		
		<a href="/sumbab/sb/login">로그인</a>
		
		</form>
	
	</c:otherwise>
	


</c:choose>


</table>

</body>
</html>