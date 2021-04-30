<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가게 등록하기-1단계</title>
</head>
<body>
	<h1>가게 등록 및 가게 정보 수정</h1>
	<c:set var="classify" value="${storeDTO.classify}" />
	<c:choose>
		<c:when test="${storeDTO.classify eq '음식점'}">
			<form:form method="post" action="registerStep2_res">
			</form:form>
		</c:when>
		
		<c:when test="${storeDTO.classify eq '카페'}">
			<form:form method="post" action="registerStep2_cafe">
			</form:form>
		</c:when>
	</c:choose>
</body>
</html>