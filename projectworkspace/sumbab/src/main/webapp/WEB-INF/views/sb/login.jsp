<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 페이지</title>
</head>
<body>
	<form:form commandName="memberVo" method="post" >
	<table border="1">
		<tr>
			<th><form:label path="id">아이디 :</form:label></th>
			<td><form:input path="id"/>
			</td>
		</tr>
		<tr>
			<th><form:label path="pwd">비밀번호 :</form:label></th>
			<td><form:input path="pwd"/>
			</td>
		</tr>
		
	</table>	
		<div>
			<input type="submit" value="로그인하기" formaction="/sumbab/sb/login" >
			<a href="javascript:openMemberFind();">아디/비번 찾기</a>
		</div>
		<div>	
			
			<a href="${kakao_url}">
			<img src="http://papaspick.com/web/upload/2019_web/icon/kakao_login.jpg"
			style="height:30px;width:auto"></a>
		</div>
		
	</form:form>
	
	
	<script type="text/javascript">
		function openMemberFind(){
			var popWidth = 700;
			var popHeight = 200;
			var maxWidth = window.screen.width
			var maxHeight = window.screen.height
			var popX = (maxWidth - popWidth)/2;
			var popY = (maxHeight - popHeight)/2;
			var url="/sumbab/sb/memberFind";
			var openWin = window.open(url,'', 'status=no, height=' + popHeight  + ', width=' + popWidth  + ', left='+ popX + ', top='+ popY);	
		}
	
		
	</script>
	<script type="text/javascript">
		function kakaoLogin(){
			var popWidth = 300;
			var popHeight = 500;
			var maxWidth = window.screen.width
			var maxHeight = window.screen.height
			var popX = (maxWidth - popWidth)/2;
			var popY = (maxHeight - popHeight)/2;
			var url="${kakao_url}";
			var openWin = window.open(url,'', 'status=no, height=' + popHeight  + ', width=' + popWidth  + ', left='+ popX + ', top='+ popY);	
		}
	
		
	</script>
	
</body>
</html>