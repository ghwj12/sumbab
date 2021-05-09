<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가게 삭제 요청</title>
</head>
<body>
<b>${store.name}</b>의 삭제를 원하시면, 가게 등록시 입력했던 비밀번호를 입력해 주세요.<br>
(등록한 카테고리 정보도 함께 삭제됩니다. )<br><br>
<form method="post" action="/sumbab/store/deleteStoreProc/${store.storeNum}">
비밀번호 : <input type="password" name="pwd" id="pwd" placeholder="비밀번호를 입력하세요. " >
<b>${msg}</b>
<br>
<input type="submit" value="삭제하기">
<input type="button" value="취소" onclick="history.back(-1)">
</form>
</body>
</html>