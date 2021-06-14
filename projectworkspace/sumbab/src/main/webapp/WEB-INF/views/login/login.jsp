<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 페이지</title>
</head>
<body>
	<form:form commandName="memberVo" method="post" name="login" >
	<table border="1">
		<tr>
			<th><form:label path="id">아이디 :</form:label></th>
			<td><form:input path="id" name="id"/>
			</td>
		</tr>
		<tr>
			<th><form:label path="pwd">비밀번호 :</form:label></th>
			<td><form:input path="pwd" name="pwd"/>
			</td>
		</tr>
		
	</table>	
		<div>
			<input type="checkbox" name="idSave">아이디 저장
		</div>
		<div> 
			<input type="submit" value="로그인하기" onclick="javascript:sendit()" >
			<a href="javascript:openMemberFind();">아디/비번 찾기</a>
		</div>
		<div>	
			
			<a href="${kakao_url}">
			<img src="http://papaspick.com/web/upload/2019_web/icon/kakao_login.jpg"
			style="height:30px;width:auto"></a>
		</div>
		
		<div>
			<input type="hidden" name="Val" value="">
		</div>
		
		
	</form:form>
	
	<script type="text/javascript">
		
		window.onload = function(){
			
			if (getCookie("id")) { // getCookie함수로 id라는 이름의 쿠키를 불러와서 있을경우
	            document.login.id.value = getCookie("id"); //input 이름이 id인곳에 getCookie("id")값을 넣어줌
	            document.login.idSave.checked = true; // 체크는 체크됨으로
			
		} 
	}
	
		function setCookie(name, value, expiredays) //쿠키 저장함수
		    {
		     var todayDate = new Date();
		     todayDate.setDate(todayDate.getDate() + expiredays);
		     document.cookie = name + "=" + escape(value) + "; path=/; expires="
		                + todayDate.toGMTString() + ";"
		    }
		
		
		function getCookie(Name) { // 쿠키 불러오는 함수
		        var search = Name + "=";
		        if (document.cookie.length > 0) { // if there are any cookies
		            offset = document.cookie.indexOf(search);
		            if (offset != -1) { // if cookie exists
		                offset += search.length; // set index of beginning of value
		                end = document.cookie.indexOf(";", offset); // set index of end of cookie value
		                if (end == -1)
		                    end = document.cookie.length;
		                return unescape(document.cookie.substring(offset, end));
		            }
		        }
		    }
		
		function sendit() {
		        var frm = document.login;
		        
		        if (!frm.id.value) { //아이디를 입력하지 않으면.
		            alert("아이디를 입력 해주세요!");
		            frm.id.focus();
		        	
		        	
		        	
		          	return 
		        }
		        if (!frm.pwd.value) { //패스워드를 입력하지 않으면.
		            alert("비밀번호를 입력 해주세요!");
		            frm.pwd.focus();
		           	document.getElementId("Val").value = "2";
		            //frm.Val.value == "2";
		          	
		           
		            return 
		        }
		        if (!frm.id.value && !frm.pwd.value) { //둘다 없으면 
		            alert("아이디 비밀번호를 입력하세요!");
		            frm.id.focus();
		          
		            return 
		            
		        }
		       
		        
		        
		        
		        if (document.login.idSave.checked == true) { // 아이디 저장을 체크 하였을때
		            setCookie("id", document.login.id.value, 7); //쿠키이름을 id로 아이디입력필드값을 7일동안 저장
		        } else { // 아이디 저장을 체크 하지 않았을때
		            setCookie("id", document.login.id.value, 0); //날짜를 0으로 저장하여 쿠키삭제
		        }
		 
		        
		        document.login.submit(); //유효성 검사가 통과되면 서버로 전송.
		        
		       
		    
		 
		    }
		
		
		
	
	</script>
	
	
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