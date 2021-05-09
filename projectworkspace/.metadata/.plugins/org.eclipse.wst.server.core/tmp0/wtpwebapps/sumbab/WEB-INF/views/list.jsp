<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테스트용페이지!</title>
<style>
.topcorner {
	position: absolute;
	top: 0;
	right: 0;
}
</style>
<%@ include file="/WEB-INF/views/shareHead.jsp"%>
</head>
<body>
	<form id="addlist">
		<c:forEach var="list" items="${list}">
		
		${list.storeNum} <a
				href="<c:url value = "store/StoreView/${list.storeNum}" />">${list.name}<br></a>

		</c:forEach>

	</form>

	<a href="<c:url value = "Gps/GPSlocation"/>" class="topcorner">현재 내위치에서
		근방 맛집보기</a>
</body>
</html>
