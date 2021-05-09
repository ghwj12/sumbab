<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 작성 완료</title>
</head>
<body>
리뷰가 등록되었습니다.<br>
작성한 리뷰는 마이페이지-내가 작성한 리뷰에서 보실 수 있습니다.<br>
<input type="button" value="작성한 리뷰 모아보기" onclick="location.href='/sumbab/review/myReviewList'"> 
&nbsp;
<input type="button" value="가게 페이지로 " onclick="location.href='/sumbab/store/StoreView/${storeNum}'">
</body>
</html>