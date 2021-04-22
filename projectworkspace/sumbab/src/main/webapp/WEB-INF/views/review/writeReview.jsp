<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
	pageContext.setAttribute("br", "<br/>");
	pageContext.setAttribute("cn", "\n");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 작성하기</title>
</head>
<body>
	<h1>리뷰 작성하기</h1>

	<h2>${store.name}</h2>
	<form method="post" action="">
		<table>
			<tr>
				<th>먹은 메뉴는?:</th>
				<td><input type="text"></td>
				<td rowspan="4">이미지 출력되는 자리</td>
			</tr>
			<tr>
				<th>별점</th>
				<td><input type="text"></td>
			</tr>
			<tr>
				<th>리뷰 작성:</th>
				<td><textarea cols="40" rows="10"></textarea></td>
			</tr>
			<tr>
				<th>태그 입력</th>
				<td><input type="text"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="checkbox" name="revisit" id="revisit">재방문 하고싶어요!</td>
				<td><input type="text" placeholder="사진 첨부하기(*.jpg,*.png...)">
				<input type="button" value="+" onclick="window.open('addPhoto.jsp')"></td>
			</tr>
		</table>
		
		<input type="submit" value="작성">
		<input type="button" value="뒤로가기" onclick="history.back();">
	</form>

</body>
</html>