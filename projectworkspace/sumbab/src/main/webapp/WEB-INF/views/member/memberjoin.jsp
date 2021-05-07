<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html>
<head> 
<title>SUMBAB 회원가입</title> 
<script type="text/javascript" src="resources/js/jquery-3.6.0.min.js"></script>
</head> 
<body>
 <article class="container"> 


 <form action="memberjoin" method="POST" role="form" id="signFrm" name="signFrm"> 
 <table>
 	<tbody>
			<tr>
				<td colspan="4" height="100" align="center">회원가입</td>
			</tr>
			<tr>
					<td>아이디</td>
					<td><input type="text" id="id" name="id" ></td>
					<td><input type="button" id="idCheck" name="idCheck" value="중복체크"><span id="result_txt"></span></td>
				</tr>
			<tr>
					<td>패스워드</td>
					<td colspan="2"><input id="pwd" name="pwd" type="password"></td>
				</tr>
			
			<tr>
				<td>회원분류</td>
				<td>
				<select name="classify"> 
				<option value="">분류</option>
				<option value="1">일반회원</option>
				<option value="2">가게관리회원</option>
				</select>
				</td>
			</tr>
			<tr>
				<td >E-mail</td>
				<td>
				<input type="text" name="email" id="email" placeholder="E-mail">
				</td>
			</tr>
			<tr>
				<td><input type = "submit" value="가입하기"></td>
			</tr>
			</tbody>
		</table>
		</form>
	</article> 
</body>
<script type="text/javascript">
	$(document).ready(function(){
		
		var idx = false;
		
		$('#idCheck').click(function(){
			$.ajax({
				url: "${pageContext.request.contextPath}/idCheck",
				type: "POST",
				data:{
					"id":$('#id').val()
				},
				success: function(data){
					var result_txt = '';
					if(data == 0 && $.trim($('#id').val()) != '' ){
						idx=true;
						$('#id').attr("readonly",true);
						result_txt="<tr><td colspan='3' style='color: green'>사용가능</td></tr>";
						//$('#idCheck').empty();
						$('#result_txt').html(result_txt);
					}else{

						result_txt="<tr><td colspan='3' style='color: red'>사용불가능한 아이디 입니다.</td></tr>";
						//$('#idCheck').empty();
						$('#result_txt').html(result_txt);
					}
				},
				error: function(){
					alert("서버에러");
				}
			});
			

		});
		
	});
</script>
</html>
