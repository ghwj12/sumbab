<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기 결과</title>
 	
</head>
<body>
<form name="iFr" action="/views/sb/login">
	<table border="1">
		<tr>
			<th>아이디 :</th>
			<td>${idFind}</td>
		</tr>
	</table>
	<div>
		<a href="javascript:popupSubmit();">로그인</a>
		<a href="<c:url value="/views/sb/memberFind"/>">비번 찾기</a>
	</div>
	</form>
	<script type="text/javascript">
	 function popupSubmit() {

    window.opener.name = "parentPage"; // 부모창의 이름 설정

    document.iFr.target = "parentPage"; // 타켓을 부모창으로 설정

    document.iFr.action = "/sumbab/sb/login";  //부모창에 호출될 url 

    document.iFr.submit();

    self.close();

}
	 </script>
</body>
</html>