<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록한 가게 모아보기</title>
</head>
<body>
	<h1>등록한 가게</h1>
	가게명을 클릭하시면 수정/삭제 하실 수 있습니다.<br>
	<input type="button" value="마이페이지로" onclick="location.href='/sumbab/mypage/mypageMain'">
	
	<table border="1">
		<tr>
			<th>No.</th><th>가게명</th><th>주소</th>
		</tr>
		<tr>
		<c:forEach var="myStore" items="${myStoreList}" varStatus="loop">
			<td>${myStore.storeNum}</td>
			<td><a href="/sumbab/store/storeDetail/${myStore.storeNum}">${myStore.name}</a></td>
			<td>${myStore.citycode} ${myStore.districtcode} ${myStore.address}</td>
		<tr>
			</c:forEach>
	</table>
</body>
</html>