<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가게 상세보기에 합치기</title>
</head>
<body>
	<input type="button" value="신고하기" onclick="openWarning()"/>
	<input type="button" id="pick" value="보관함에 담기"> 
	
	<script type="text/javascript">
		function openWarning(){
			var popWidth = 600;
			var popHeight = 400;
			var winHeight = document.body.clientHeight;
			var winWidth = document.body.clientWidth;
			var winX = window.screenLeft;
			var winY = window.screenTop;
			var popX = winX + (winWidth - popWidth)/2;
			var popY = winY + (winHeight - popHeight)/2;
			url="warningProcess";						//merge하면 아마 ../warningProcess/${reviewNum}으로 변경
			var openWin = window.open(url, "openWarning", "left="+popX+",top="+popY+",width="+popWidth+",height="+popHeight);
		}
	</script>
	
	<script>	
		$("#pick").on('click', function(){
			$.ajax({
				type:"POST",
				url:"../pick/11",		//merge하면 11 -> {store_num}
				async: false,			//동기식 요청
				success:function(data){
					if(data == 1){
						alert("보관함에 이미 있는 가게 입니다.");
					} else{
						alert("보관함에 담겼습니다.");
					}
				}
			})
		})
	</script>
	
</body>
</html>