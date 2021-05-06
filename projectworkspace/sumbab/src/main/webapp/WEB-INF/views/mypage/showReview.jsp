<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>해당 리뷰</title>
</head>
<body>
<h2>해당 리뷰</h2>
	<table border="1">
		<tr>
			<th>가게명</th>
			<td>${reviewVo.name}</td>
		</tr>
		<tr>
			<th>먹은 메뉴</th>
			<td>${reviewVo.menu}</td>
		</tr>
		<tr>
			<th>별점</th>
			<td>${reviewVo.star}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${reviewVo.content}</td>
		</tr>
		<tr>
			<th>재방문 유무</th>
			<td>
				<c:choose>
					<c:when test="${reviewVo.revisit}">있음</c:when>
					<c:otherwise>없음</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><fmt:formatDate value="${reviewVo.regdate}" pattern="yyyy.MM.dd" /></td>
		</tr>
		<c:if test="${reviewVo.picture != ''}">
			<tr>
				<th>사진</th>
				<td><img src="<c:url value="/upload_02review/${reviewVo.picture}"/>" style="width:250px; height:250px;"/>
				</td>
			</tr>
		</c:if>
	</table>
	<input type="button" value="확인" onclick="javascript:self.close()">
</body>
</html>