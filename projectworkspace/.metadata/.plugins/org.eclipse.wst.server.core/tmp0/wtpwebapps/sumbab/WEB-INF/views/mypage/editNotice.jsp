<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 수정</title>
</head>
<body>
<h2>공지 수정</h2>
	<form:form commandName="notice" method="POST">
	<table border="1">
		<tr>
			<th>제목</th>
			<td><form:input path="title" /></td>
		</tr>
		<tr>
			<th>볼 권한이 있는 아이디</th>
			<td><form:input path="authority" /></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><form:textarea path="content" /></td>
		</tr>
	</table>
	<input type="submit" value="수정">
	</form:form>
</body>
</html>