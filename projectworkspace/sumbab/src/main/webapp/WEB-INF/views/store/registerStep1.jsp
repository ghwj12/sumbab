<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가게 등록하기-1단계</title>
</head>
<body>
	<h1>가게 등록 및 가게 정보 수정</h1>


	<form:form method="post" action="store/registerStep2" commandName="storeDao">
		<input type="radio" name="classify" value="rest">음식점 등록
		<input type="radio" name="classify" value="cafe">카페 등록
		<table>
			<tr>
				<td>가게명:</td>
				<td><input type="text" placeholder="가게명을 입력해주세요." name="name" id="name" required></td>
			</tr>
			<tr>
				<td>위치:</td>
				<td><input type="text" placeholder="시/군/구 도로명 주소로 입력해주세요." name="address" id="address" required></td>
			</tr>
			<tr>
				<td>전화번호:</td>
				<td><input type="text" placeholder="전화번호를 입력해 주세요." name="phone" id="phone" required></td>
			</tr>
			<tr>
				<td>메뉴:</td>
				<td><textarea placeholder="메뉴-가격 순으로 입력해 주세요." name="menu" id="menu" required></textarea></td>
			</tr>
			<tr>
				<td>영업시간:</td>
				<td><input type="text" placeholder="영업시간을 입력해 주세요." name="time" id="time" required></td>
			</tr>
			<tr>
				<td>기타:</td>
				<td><textarea placeholder="주차 가능 여부, 배달 가능 여부, 반려동물 동반 등의 특이사항을 적어주세요." name="etc" id="etc" required></textarea></td>
			</tr>
			<tr>
				<td>비밀번호:</td>
				<td><input type="password" placeholder="등록하신 가게 관리를 위한 비밀번호를 입력하세요. " name="pwd" id="pwd" required></td>
			</tr>
			<tr>
				<td colspan="2"><input type="checkbox" name="reserving" id="reserving">예약
					가능</td>
			</tr>
		</table>

		<input type="submit" value="다음">
		</form:form>
</body>
</html>