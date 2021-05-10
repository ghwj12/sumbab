<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기 폼</title>
</head>
<body>
	<form:form commandName="memberVo" method="post">
	<table border="1">
		<tr>
			<th><form:label path="email">이메일을 입력하세요 :</form:label></th>
			<th><form:label path="id">아이디를 입력하세요 :</form:label></th>
		</tr>	
		<tr>
			<td><form:input path="email"/></td>
			<td><form:input path="id"/></td>
		</tr>	
			
		
		
		<tr>
			<td colspan="1">
			<input type="submit" value="아이디 찾기" formaction="/sumbab/sb/idFindResult">
			</td> 
			<td colspan="1">
			<input type="submit" value="비밀번호 찾기" formaction="/sumbab/sb/pwdFindResult">
			</td> 
		</tr>
		
	</table>	
		
	</form:form>
	
</body>
</html>