<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 올리기</title>
</head>
<body>
<h2>공지 올리기</h2>
	<form:form commandName="notice" method="POST" action="writeNotice">
	<table border="1">
		<tr>
			<th>제목</th>
			<td><form:input path="title" /></td>
		</tr>
		<tr>
			<th>볼 권한이 있는 아이디</th>
			<td>
			<c:choose>
				<c:when test="${!empty receiveNotice}">${receiveNotice.authorityByRD}
					<form:hidden path="authority" value="${receiveNotice.authorityByRD}" />
				</c:when>
				<c:otherwise><form:input path="authority" /></c:otherwise>
			</c:choose>
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><form:textarea path="content" /></td>
		</tr>
	</table>
	<c:if test="${receiveNotice.classifyNum == 4}"><form:hidden path="reviewNum" value="${receiveNotice.reviewNumByRD}" /></c:if>
	<input type="submit" value="올리기">
	</form:form>
</body>
</html>