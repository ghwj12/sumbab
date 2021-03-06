<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지 사항</title>
</head>
<body>
<h2>공지 사항</h2>
	<table border="1">
		<tr>
			<th>No.</th>
			<th>공지 제목</th>
			<th>날짜</th>
		</tr>
		<c:forEach var="notice" items="${noticeList}" varStatus="loop">
			<tr>
				<td>${loop.count}</td>
				<td><a href="<c:url value="/mypage/noticeDetail/${notice.noticeNum}" />">${notice.title}</a></td>
				<td><fmt:formatDate value="${notice.regdate}" pattern="yyyy.MM.dd" /></td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${classify == 3}">
		<input type="button" value="공지 올리기" onclick="location.href='writeNotice'"/>
	</c:if>
</body>
</html>