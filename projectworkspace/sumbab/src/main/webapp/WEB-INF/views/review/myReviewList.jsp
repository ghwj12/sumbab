<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 작성한 리뷰 보기</title>
</head>
<body>
<h2>내가 작성한 리뷰 보기</h2>
<table border="1">
	<tr>
		<th>No.</th><th>가게 이름</th><th>별점</th><th>컨텐츠</th><th>작성일</th>
	</tr>
	<c:forEach var="reviewList" items="${reviewList}" varStatus="loop">
	<tr>
		<td>${reviewList.reviewNum}</td>
		<td>
		<c:forEach var="store" items="${storeList}" varStatus="status">
			<c:if test="${store.storeNum eq reviewList.storeNum}">
				${store.name}
			</c:if>
		</c:forEach>
		</td>
		<td>${reviewList.star}</td>
		<td>
		<c:choose>
			<c:when test="${reviewList.content.length()>20}">
				<a href="/sumbab/review/reviewDetail/${reviewList.reviewNum}">
				${reviewList.content.substring(0,20)}...</a>
			</c:when>
			<c:when test="${reviewList.content.length()<20}">
			<a href="/sumbab/review/reviewDetail/${reviewList.reviewNum}">
				${reviewList.content}</a>
			</c:when>
		</c:choose>
		</td>
		<td>${reviewList.regdate.substring(0,10)}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>