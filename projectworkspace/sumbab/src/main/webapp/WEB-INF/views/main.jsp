<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<style>
hr {
	width: 1500px;
}

->
width로 수평선 너비 지정
hr {
	height: 500px;
}

->
height로 수평선 높이 지정
hr {
	color: red;
}
->
color
 
로
 
색상
 
선
 
지정
</style>

<%@ include file="/WEB-INF/views/shareHead.jsp"%>
</head>
<body>
<script>
    function Warning_check(){ 
         var id = '<%=(String)session.getAttribute("id")%>';

          if(uid=="null"){ 
             swal("로그인이 필요한 항목입니다.","회원 가입 또는 로그인을 해주세요", "error"); 
          }
          else{
             location.replace("공지담당자분이 좀 url 넣어보세요");
          }
    }   
</script>


	<h6>
		메인페이지 <a href="공지 맞으신분 연결좀 해주셔요 컨트롤러 url도 수정하시고요" onClick="Warning_check();">공지</a>&nbsp; 
				<a href="보관함 맞으신분 연결좀 해주셔요 컨트롤러 url도 수정하시고요" onClick="mypage_check();">보관함</a>&nbsp; 
				<a href="/sumbab/sb/login">로그인</a>&nbsp; 
				<a href="/sumbab/memberjoin">회원가입</a>&nbsp; <br>
	</h6>
	<hr class="one">

	<h2>
		숨밥꼭질<br>
	</h2>
	<hr class="two">
	 <a href="#">식당추천받기</a>&nbsp; 
	  <a href="#">카페추천받기</a>&nbsp; 
	  
	
</body>
</html>
