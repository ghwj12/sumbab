<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리 추천</title>
</head>
<body>
<h2>카테고리 추천</h2>
	<c:forEach var="recommend" items="${recommend}" varStatus="loop">
	<div>
		<h3>${loop.count}.<a href="<c:url value="#"/>">${recommend.name}</a>&nbsp;조회수${recommend.count}<br></h3>
		${recommend.citycode} ${recommend.districtcode} ${address}<br><br>
		${recommend.time}<br>
		${recommend.menu}<br>
	</div>
	</c:forEach>
	
</body>
</html>