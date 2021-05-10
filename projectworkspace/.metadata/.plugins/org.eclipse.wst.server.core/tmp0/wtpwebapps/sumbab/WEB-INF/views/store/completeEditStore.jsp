<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가게 수정 완료</title>
</head>
<body>
가게 정보가 수정되었습니다.<br>
카테고리도 수정 하시겠습니까?<br>
<input type="button" value="카테고리 수정" onclick="location.href='/sumbab/store/editCat/${store.storeNum}'">
<input type="button" value="마이 페이지로" onclick="location.href='/sumbab/mypage/mypageMain'">
</body>
</html>