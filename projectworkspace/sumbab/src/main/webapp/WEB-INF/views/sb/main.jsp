<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
<form method="get">

<table>
	<tr>
		<td>
		
		<%= session.getAttribute("vo") %> 
			 ${vo.email}
			환영합니다
		</td>
	</tr>
</table>

<c:choose>

<c:when test="${access_Token != null}">
<div>
<a href="${kLogoutUrl}">카카오 로그아웃</a>
</div>
</c:when>
<c:otherwise>
<div>
<input type="submit" value="로그아웃" formaction="/sumbab/sb/logout" >
<input type="submit" value="회원탈퇴" formaction="/sumbab/memberDeleteView" >

</div>
</c:otherwise>




</c:choose>
</form>



</body>
</html>