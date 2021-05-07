<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 취소 팝업</title>
</head>
<body>

<form:form method="POST">
예약을 취소하시겠습니까?
<input type="submit" value="예약 취소하기">
<input type="button" value="아니오" onclick="javascript:self.close()">
</form:form>

</body>
</html>