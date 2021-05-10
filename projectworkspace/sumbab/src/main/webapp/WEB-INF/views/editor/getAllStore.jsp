<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>운영자 : 새로운 리스트 만들기</title>
</head>
<body>
<h1>운영자 모드 : 새로운 Editor 추천 만들기</h1>
1. 리스트를 불러온다<br>
2. 생성하기 버튼 클릭(checkbox 선택 모드)<br>
3. 원하는 가게를 선택 후 create (제목, storeNum list 담기)<br>
4. Editor editor('제목', storeNumList); 생성 완료<br><br>

	<table border="1">
		<tr>
		<th>No.</th><th>Classify</th><th>상호명</th><th>지역</th>
		</tr>
		<c:forEach var="storeList" items="${storeList}" varStatus="loop">
		<tr>
			<td>${storeList.storeNum}</td><td>${storeList.classify}</td><td>${storeList.name}</td>		
		
		<td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>