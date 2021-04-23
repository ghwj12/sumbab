<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지-예약 내역 보기</title>
</head>
<body>

	<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" />
	<c:set var="reserve" scope="session" value="${now}" />
	<h1>예약 내역 보기</h1>
	<br>
	<table>
		<c:choose>
			<c:when test="${now} < ${reserve.resDate}">
				<c:forEach var="reserve" items="${reserveList}" varStatus="loop">

					<tr>
						<th>음식점명:</th>
						<td>${reserve.storeNum}</td>
					</tr>
					<tr>
						<th>예약자 이름:</th>
						<td>${reserve.reserveName}</td>
					</tr>
					<tr>
						<th>예약 날짜:</th>
						<td>${reserve.resDate}</td>
					</tr>
					<tr>
						<th>예약자 연락처:</th>
						<td>${reserve.phone}</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
            예약 내역이 없습니다.
         </c:otherwise>
		</c:choose>
	</table>

	<h1>지난 예약 내역</h1>
	<table>
		<c:choose>
			<c:when test="${now} > ${reserve.resDate}">
				<c:forEach var="reserve" items="${reserveList}" varStatus="loop">

					<tr>
						<th>음식점명:</th>
						<td>${reserve.storeNum}</td>
					</tr>
					<tr>
						<th>예약자 이름:</th>
						<td>${reserve.reserveName}</td>
					</tr>
					<tr>
						<th>예약 날짜:</th>
						<td>${reserve.resDate}</td>
					</tr>
					<tr>
						<th>예약자 연락처:</th>
						<td>${reserve.phone}</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
            과거 예약 내역이 없습니다.
         </c:otherwise>
		</c:choose>
	</table>
	<br>


</body>
</html>