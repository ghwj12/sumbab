<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고에 대한 조치</title>
</head>
<body>
	<c:choose>
		<c:when test="${classifyNum == 4}">피신고자의 리뷰 작성 기능이 정지 되었습니다.</c:when>
		<c:otherwise>신고자의 신고 기능이 정지 되었습니다.</c:otherwise>
	</c:choose>
	<br><br>
	<input type="button" value="확인" onclick="javascript:self.close()">
</body>
</html>