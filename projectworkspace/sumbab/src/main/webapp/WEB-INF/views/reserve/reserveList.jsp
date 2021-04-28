<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>마이 페이지-예약 내역 보기</title>
</head>
<body>

	<fmt:formatDate var="currentTime" value="${now}" pattern="yyyy-MM-dd hh:mm" />
		
	<h1>예약 내역 보기</h1>
	<br>
	<h2>예약 내역</h2>
	<table border="1">
	
		<c:forEach var="reserveF" items="${listFuture}" varStatus="status">
			<tr>
				<th>음식점명:</th>
				<td>
					<c:forEach var="store" items="${storeName}"	varStatus="status">
						<c:if test="${store.storeNum eq reserveF.storeNum}">
							<c:out value=" ${store.name}" />
						</c:if>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th>예약자 이름:</th>
				<td>${reserveF.reserveName}</td>
			</tr>
			<tr>
				<th>예약 날짜:</th>
				<td>${reserveF.resDate}</td>
			</tr>
			<tr>
				<th>예약자 연락처:</th>
				<td>${reserveF.phone}</td>
			</tr>
			<tr>
				<td colspan="2">=====</td>
			</tr>
		</c:forEach>
	</table>
	
	<br>
	<h2>과거 예약 내역</h2>
	<table border="1">
	
		<c:forEach var="reserveP" items="${listPast}" varStatus="status">
			<tr>
				<th>음식점명:</th>
				<td>
					<c:forEach var="store" items="${storeName}"	varStatus="status">
						<c:if test="${store.storeNum eq reserveP.storeNum}">
							<c:out value=" ${store.name}" />
						</c:if>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th>예약자 이름:</th>
				<td>${reserveP.reserveName}</td>
			</tr>
			<tr>
				<th>예약 날짜:</th>
				<td>${reserveP.resDate}</td>
			</tr>
			<tr>
				<th>예약자 연락처:</th>
				<td>${reserveP.phone}</td>
			</tr>
			<tr>
				<td colspan="2">=====</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>