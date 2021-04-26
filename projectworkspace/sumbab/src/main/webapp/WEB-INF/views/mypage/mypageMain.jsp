<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${memeber.id}님의 마이페이지</title>
</head>
<body>

	<form>
		<table border="1">
			<tr>
			<!-- 좌측 링크 클릭 시 헤드 이름 어떻게 바꾸지? -->
				<th colspan="2"><p align="right">회원 정보</p></th>
			</tr>
			<tr>
				<th><a href="">회원 정보</a><br> <a href="">내 보관함</a><br>
					<a href="">내가 쓴 리뷰</a><br> <a href="">예약한 음식점</a><br>
				</th>

				<td>
				아이디 : ${member.id}<br>
				이메일 : ${member.email}<br>
				가입날짜 : ${member.regDate}<br></td>
			</tr>
		</table>
		<input type="button" value="비밀번호 변경" onclick="#"><input
			type="button" value="회원 탈퇴" onclick="#">
	</form>

</body>
</html>