<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고 상세 페이지</title>
</head>
<body>
<h2>신고 내역</h2>
	<form:form commandName="notice" method="POST">
	<table border="1">
		<tr>
			<th>신고자</th>
			<td>${reportVo.reporter}</td>
		</tr>
		<tr>
			<th>피신고자</th>
			<td>${reportVo.id}</td>
		</tr>
		<tr>
			<th>신고한 날짜</th>
			<td><fmt:formatDate value="${reportVo.regdate}" pattern="yyyy.MM.dd" /></td>
		</tr>
		<tr>
			<th>신고 사유</th>
			<td>${reportVo.reason}</td>
		</tr>
		<tr>
			<th>리뷰 내용</th>
			<td>${reportVo.content}</td>
		</tr>
	</table>
	<p>
		<form:select path="classifyNum">
			<form:option value="4">피신고자 리뷰 작성 기능 정지</form:option>
			<form:option value="5">신고자 신고 기능 정지</form:option>
		</form:select>
		<input type="button" id="changeClassify" value="신고 처리" />
	</p>
	<script src="https://code.jquery.com/jquery-2.2.4.js"></script> 
	<!-- src 사용하면 script 태그 따로 사용해야 됨 -->
	<script>	
		$("#changeClassify").on('click', function(){
			var classifyDto = {};
			classifyDto.classifyNum = $("#classifyNum option:selected").val();
			if(classifyDto.classifyNum == 4){
				classifyDto.id = '${reportVo.id}';
			} else{
				classifyDto.id = '${reportVo.reporter}';
			}
			$.ajax({
				type:"POST",
				url:"../changeClassify",
				dataType:"json",
				data:JSON.stringify(classifyDto),
				contentType:"application/json; charset=utf-8",
				async: false,
				success:function(){
					if(classifyDto.classifyNum == 4){
						alert("피신고자의 리뷰 작성 기능이 정지 되었습니다.");
					} else{
						alert("신고자의 신고 기능이 정지 되었습니다.");
					}
				}
			})
		})
	</script>
	<form:hidden path="reviewNumByRD" value="${reportVo.reviewNum}" />
	<input type="text" placeholder="아이디를 입력해주세요." name="authorityByRD">에게 &nbsp;&nbsp;<input type="submit" value="공지 올리기" />
	</form:form>
	<br><br>
	<input type="button" value="신고 삭제" onclick="openDelete()" />
	<script type="text/javascript">
		function openDelete(){
			var popWidth = 300;
			var popHeight = 200;
			var winHeight = document.body.clientHeight;
			var winWidth = document.body.clientWidth;
			var winX = window.screenLeft;
			var winY = window.screenTop;
			var popX = winX + (winWidth - popWidth)/2;
			var popY = winY + (winHeight - popHeight)/2;
			url="../deleteWarningProcess/"+${warningNum};
			var openWin = window.open(url, "deleteProcess", "left="+popX+",top="+popY+",width="+popWidth+",height="+popHeight);
		}
	</script>
</body>
</html>