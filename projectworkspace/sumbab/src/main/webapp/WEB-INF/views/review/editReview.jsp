<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="/sumbab/resources/css/star.css" rel="stylesheet" type="text/css">
<link href="/sumbab/resources/css/hashtag.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>리뷰 수정하기</title>
</head>
<body>

<form action="/sumbab/review/editReview/${Review.reviewNum}" method="post" enctype="multipart/form-data">
<table border="1">
	<tr>
		<th>가게명</th>
		<td>${Review.name}
		</td>
		<td rowspan="7">
			<c:choose>
			<c:when test="${Review.picture != null }">
				<img src="<c:url value="/upload_02review/${Review.picture}"/>" width="250px"/>
			</c:when>
			<c:otherwise>
				리뷰 작성 시, 등록한 사진이 없습니다.
			</c:otherwise>
			</c:choose><br><br>
			<input type="file" name="attached" id="attached">
			<input type="hidden" name="picture" id="picture" value="${Review.picture}">
		</td>
	</tr>
	<tr>
		<th>작성일</th>
		<td>${Review.regdate}
		</td>
	</tr>
	<tr>
		<th>먹은 메뉴</th>
		<td><textarea name="menu" id="menu">${Review.menu}</textarea></td>
	</tr>
	<tr>
		<th>별점</th>
		<td><div class="startRadio">
					<label class="startRadio__box">
					<input type="radio" name="star" id="val10" value="0.5">
					<span class="startRadio__img"></span>
					</label>
					<label class="startRadio__box">
					<input type="radio" name="star" id="val20" value="1.0">
					<span class="startRadio__img"></span>
					</label>
					<label class="startRadio__box">
					<input type="radio" name="star" id="val30" value="1.5">
					<span class="startRadio__img"></span>
					</label>
					<label class="startRadio__box">
					<input type="radio" name="star" id="val40" value="2.0">
					<span class="startRadio__img"></span>
					</label>
					<label class="startRadio__box">
					<input type="radio" name="star" id="val10" value="2.5">
					<span class="startRadio__img"></span>
					</label>
					<label class="startRadio__box">
					<input type="radio" name="star" id="val20" value="3.0">
					<span class="startRadio__img"></span>
					</label>
					<label class="startRadio__box">
					<input type="radio" name="star" id="val30" value="3.5">
					<span class="startRadio__img"></span>
					</label>
					<label class="startRadio__box">
					<input type="radio" name="star" id="val40" value="4.0">
					<span class="startRadio__img"></span>
					</label>
					<label class="startRadio__box">
					<input type="radio" name="star" id="val45" value="4.5">
					<span class="startRadio__img"></span>
					</label>
					<label class="startRadio__box">
					<input type="radio" name="star" id="val50" value="5.0">
					<span class="startRadio__img"></span>
					</label>
				</div></td>
	</tr>
	<tr>
		<th>리뷰 내용</th>
		<td><textarea id="content" name="content">${Review.content}</textarea></td>
	</tr>
	<tr>
		<th>태그</th>
		<td>
		<c:forEach var="tags" items="${tags}">
		#${tags.tagName} 
		</c:forEach>
		</td>
	</tr>
	<tr>
		<th>재방문 유무</th>
		<td><input type="checkbox" name="revisit" id="revisit"
			<c:if test="${Review.revisit eq true}">
			checked = "checked" </c:if>>
			</td>
	</tr>
</table>
<input type="submit" value="수정하기">
<input type="button" value="취소" onclick="history.back()"/>
</form>
<script src="/sumbab/resources/js/hashtags.js"></script>
<script>
$('input:radio[name="star"]:input[value="${Review.star}"]').prop("checked", true);
</script>
</body>
</html>