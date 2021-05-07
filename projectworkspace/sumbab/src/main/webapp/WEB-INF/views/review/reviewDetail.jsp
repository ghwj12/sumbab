<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${Review.reviewNum}번 리뷰 상세보기</title>
</head>
<body>
<h1>내가 쓴 리뷰 상세보기</h1>

<form>

<table border="1">
	<tr>
		<th>가게명</th>
		<td>${Review.storeNum}
		</td>
		<td rowspan="6">
			<c:choose>
			<c:when test="${Review.picture != null }">
				<img src="<c:url value="/upload_02review/${Review.picture}"/>" width="250px"/>
			</c:when>
			<c:otherwise>
				리뷰 작성 시, 등록한 사진이 없습니다.
			</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th>작성일</th>
		<td>${Review.regDate}</td>
	</tr>
	<tr>
		<th>별점</th>
		<td>${Review.star}</td>
	</tr>
	<tr>
		<th>리뷰 내용</th>
		<td>${Review.content}</td>
	</tr>
	<tr>
		<th>태그</th>
		<td>${Review.star}</td>
	</tr>
	<tr>
		<th>재방문 유무</th>
		<td>${Review.revisit}</td>
	</tr>
</table>
<br>
	<input type="button" value="리뷰 수정">
	<input type="button" value="리뷰 삭제">
</form>
</body>
</html>