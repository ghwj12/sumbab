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
<form name="pFr" action="/sb/login">
	<table border="1">
		<tr>
			<th>비밀번호 :</th>
			<td>${pwdFind}</td>
		</tr>
	</table>
	<div>
		<a href="javascript:popupSubmit2();">로그인</a>
	</div>
	</form>
	<script type="text/javascript">
	 function popupSubmit2() {

    window.opener.name = "parentPage"; // 부모창의 이름 설정

    document.pFr.target = "parentPage"; // 타켓을 부모창으로 설정

    document.pFr.action = "/sumbab/sb/login";  //부모창에 호출될 url 

    document.pFr.submit();

    self.close();

}
	 </script>
</body>
</html>