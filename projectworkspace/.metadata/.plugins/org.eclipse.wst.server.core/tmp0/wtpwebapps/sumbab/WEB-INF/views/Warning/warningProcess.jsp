<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고하기</title>
</head>
<body>
	<c:if test="${empty warning}">
		회원님의 신고 기능이 정지 되었습니다.<br>
		공지글을 확인해 주세요.<br><br>
		<input type="button" value="공지 페이지로 이동" onclick="javascript:opener.location.href='/sumbab/mypage/noticePage';self.close()">
		<input type="button" value="확인" onclick="javascript:self.close()">
	</c:if>
	<c:if test="${!empty warning}">
		<form:form commandName="warning" method="POST">
			해당 리뷰를 신고하는 이유를 선택 해주세요.<br>
			(*사이트 운영자의 판단하에 신고 기능이 정지될 수 있습니다.)<br><br>
			<form:select path="reason">
				<form:option value="리뷰를 가장한 홍보글">리뷰를 가장한 홍보글</form:option>
				<form:option value="근거없는 비방글">근거없는 비방글</form:option>
				<form:option value="불쾌한 욕설">불쾌한 욕설</form:option>
				<form:option value="기타">기타</form:option>
			</form:select>
			<input type="submit" value="신고하기">
			<input type="button" value="취소" onclick="javascript:self.close()">
		</form:form>
	</c:if>
</body>
</html>