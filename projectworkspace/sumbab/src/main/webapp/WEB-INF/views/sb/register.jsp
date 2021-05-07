<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 페이지</title>
</head>
<body>
	<form:form commandName="memberVo" method="post">
	<table border="1">
		<tr>
			<th><form:label path="email">이메일</form:label></th>
			<td><form:input path="email"/>
			</td>
		</tr>
		<tr>
			<th><form:label path="id">아이디</form:label></th>
			<td><form:input path="id"/>
			</td>
		</tr>
		<tr>
			<th><form:label path="pwd">비밀번호</form:label></th>
			<td><form:input path="pwd"/>
			</td>
		</tr>
		<tr>
			<th><form:label path="pwd">비밀번호 확인</form:label></th>
			<td><form:input path="pwd"/>
			</td>
		</tr>
		<tr>
			<td><form:radiobuttons path="classify" value="shop" /> 가게</td>
			<td><form:radiobuttons path="classify" value="supervisor"/> 관리자</td>
		</tr>
	
	</table>	
		<div>
			<input type="submit" value="회원가입 처리">
				<a href="<c:url value="/sb/register" />">회원 가입</a>;
		
		</div>
	</form:form>
</body>
</html>