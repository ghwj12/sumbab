<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<style>
@import url('https://fonts.googleapis.com/css?family=Work+Sans:300,400');

body {
  align-items: center;
  justify-content: center;
  overflow: hidden;
}

.wrapper {
  padding: 1px 5px;
  background-color: #273c75;
  display: flex;
  align-items: center;
  flex-flow: row wrap;
}

input {
  color: #666;
  outline: none;
}

.tag-container {
  display: flex;
  flex-flow: row wrap;
}

.tag{
  pointer-events: none;
  background-color: #242424;
  color: white;
  padding: 6px;
  margin: 5px;
}

.tag::before {
  pointer-events: all;
  display: inline-block;
  content: 'x';  
  height: 20px;
  width: 20px;
  text-align: center;
  color: #ccc;
  background-color: #111;
  cursor: pointer;
}

</style>
<meta charset="UTF-8">
<title>리뷰 작성하기</title>


</head>
<body>
	<h1>리뷰 작성하기</h1>

	<h2>${store.name}가게이름자리</h2>
	<form method="post" action="#" id="regitReview" name="regitReview">
		<table border="1">
			<tr>
				<th>먹은 메뉴</th>
				<td><input type="text"></td>
			</tr>
			<tr>
				<th>별점</th>
				<td></td>
			</tr>
			<tr>
				<th>리뷰 작성:</th>
				<td><textarea cols="40" rows="10"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="checkbox" name="revisit"
					id="revisit">재방문 하고싶어요!</td>
			</tr>
			<tr>
				<td colspan="2"><input type="text" placeholder="사진 첨부하기(*.jpg,*.png...)">
					<input type="button" value="+" name="addPhoto" id="addPhoto"
					onclick="popup();" /></td>
			</tr>
			<tr>
				<td colspan="2">사진 들어가는 곳</td>
			</tr>
		</table>
	</form>
	
	<!-- 해시태그 테이블 -->
		<table border="1" id="hashtag">
			<tr>
				<th>태그 입력</th>
				<td><div class="wrapper">
						<input type="text" id="hashtags">
					</div> <br>
					<div class="tag-container"></div></td>
			</tr>
		</table>
			<input type="submit" value="작성" form="regitReview">
			<input type="button" value="뒤로가기" onclick="history.back();">



	<script src="<%=request.getContextPath()%>/resources/js/hashtags.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/popup.js"> </script>
</body>

</html>