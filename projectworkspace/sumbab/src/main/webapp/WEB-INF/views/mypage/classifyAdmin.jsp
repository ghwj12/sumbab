<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>정지 계정 관리</title>
</head>
<body>
<h2>정지 계정 관리</h2>
	<table border="1">
		<tr>
			<th>No.</th>
			<th>아이디</th>
			<th>정지 유형</th>
			<th>정지된 날짜</th>
			<th>선택</th>
		</tr>
		<c:if test="${empty memberList}">
			<tr>
				<td colspan="5">정지된 계정이 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${!empty memberList}">
		<c:forEach var="member" items="${memberList}" varStatus="loop">
			<tr>
				<td>${loop.count}</td>
				<td>${member.id}</td>
				<td>
				<c:choose>
					<c:when test="${member.classify == 4}">리뷰 정지 </c:when>
					<c:otherwise>리뷰 신고 정지</c:otherwise>
				</c:choose>
				</td>
				<td><fmt:formatDate value="${member.regdate}" pattern="yyyy.MM.dd" /></td>
				<td><input type="button" value="정지 해제" onclick="returnClassify('${member.id}', '${member.classify}')"></td>
			</tr>
		</c:forEach>
		</c:if>
	</table>
	<script type="text/javascript">
		function returnClassify(id, classify){
			var popWidth = 300;
			var popHeight = 200;
			var winHeight = document.body.clientHeight;
			var winWidth = document.body.clientWidth;
			var winX = window.screenLeft;
			var winY = window.screenTop;
			var popX = winX + (winWidth - popWidth)/2;
			var popY = winY + (winHeight - popHeight)/2;
			url="returnClassifyProcess/"+id+"/"+classify;
			var openWin = window.open(url, "returnClassify", "left="+popX+",top="+popY+",width="+popWidth+",height="+popHeight);
		}
	</script>
</body>
</html>