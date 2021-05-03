<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<link href="/sumbab/resources/css/star.css" rel="stylesheet" type="text/css">
<link href="/sumbab/resources/css/hashtag.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>리뷰 작성하기</title>

</head>
<body>
	<h1>리뷰 작성하기</h1>

	<h2>${storeVO.name}에대한 리뷰를 남겨주세요!</h2>
	<form method="post" id="reviewDTO" name="reviewDTO" action="/sumbab/review/completeWrReview">
		<table border="1">
			<tr>
				<th>먹은 메뉴</th>
				<td><textarea id="menu" name="menu"
						placeholder="먹은 메뉴를 입력해 주세요." cols="50" required></textarea></td>
			</tr>
			<tr>
				<th>별점</th>
				<td>
				<div class="startRadio">
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
					<input type="radio" name="star" id="val40" value="4.5">
					<span class="startRadio__img"></span>
					</label>
					<label class="startRadio__box">
					<input type="radio" name="star" id="val50" value="5.0">
					<span class="startRadio__img"></span>
					</label>
				</div>
				</td>
			</tr>
			<tr>
				<th>리뷰 작성</th>
				<td><textarea id="content" name="content" cols="50" rows="10"
						required></textarea></td>
			</tr>
			<tr>
			<!-- 해시태그 입력 form -->
				<th>태그 입력<br>(선택사항)</th>
				<td>
				<div class="tagForm">
		            <input type="hidden" value="" name="tag" id="rdTag" />
	      		<div>
            		<input type="text" id="tag" placeholder="태그입력 (최대 5개)" />
       			</div>
		       		<ul id="tag-list">
		      		<!-- 입력받은 tag 들어오는 자리 -->
		      		</ul>
		   	 </div>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="checkbox" name="revisit"
					id="revisit">재방문 하고싶어요!</td>
			</tr>
			<tr>
				<td colspan="2"><input type="text" placeholder="(*.jpg,*.png...)">
				<input type="button" value="사진 첨부하기" name="addPhoto" id="addPhoto" onclick="popup();" />
				<input type="hidden" id="storeNum" name="storeNum" value="${storeVO.storeNum}">
				</td>
			</tr>
			<tr>
				<c:choose>
					<c:when test="${reviewDTO.picture == null}">
					</c:when>
					<c:otherwise>
						<td colspan="2">
							사진 들어가는 곳<img src="/사진저장경로/${reviewDTO.picture} 이름 가져오기">
						</td>
					</c:otherwise>
				</c:choose>
			</tr>
		</table>
	<input type="submit" value="작성">
	<input type="button" value="뒤로가기" onclick="history.back();">
	</form>

	<script src="/sumbab/resources/js/hashtags.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/popup.js"></script>

</body>
</html>