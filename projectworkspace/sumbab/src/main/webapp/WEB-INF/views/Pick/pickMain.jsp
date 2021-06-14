<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보관함 메인</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js" ></script>
</head>
<body>
<c:choose>

<c:when test="pickList eq null">
	<div>
	
		장바구니가 비었습니다.	
	
	</div>
	<div>
		<a href="javascript:window.history.back();">뒤로가기</a>
	</div>

</c:when>
<c:otherwise>
	<div class="allCheck">
   		<input type="checkbox" name="allCheck" id="allCheck" /><label for="allCheck">모두 선택</label> 
  		
  		<script>
		$("#allCheck").click(function(){
			var chk = $("#allCheck").prop("checked");
 			if(chk) {
 				$(".chBox").prop("checked", true);
 			} else {
 				$(".chBox").prop("checked", false);
		 }
		});
		</script>
  	</div>
  	<div  style="padding-bottom:3px;" class="delBtn">
   		<button type="button" class="selectDelete_btn">선택 삭제</button> 
   		<script>
 		$(".selectDelete_btn").click(function(){
  			var confirm_val = confirm("정말 삭제하시겠습니까?");
  
  		if(confirm_val) {
   			var checkArr = new Array();
   
   		$("input[class='chBox']:checked").each(function(){
    		checkArr.push($(this).attr("data-storeNum"));
   		});
    
   		$.ajax({
    		
   			url : "/sumbab/sb/delPick",
    		type : "post",
    		data : { chbox : checkArr },
    		success :function(result){
     			
     			if(result == 1){
     				location.href = "/sumbab/sb/myPick"; 
     			}else{
     				alert("삭제 실패");
     			}
     		} 
     			
     			
    
   });
  } 
 });
</script>
   		
  	</div>





<c:forEach var="pickList" items="${joinPickList}" varStatus="status">
	
	<div style="border-top: 1px solid black;" class="checkBox">
   		<input type="checkbox" name="chBox" class="chBox" data-storeNum ="${pickList.storeNum}" />
   		
   		<script>
 		$(".chBox").click(function(){
  		$("#allCheck").prop("checked", false);
 		});
		</script>
  	</div>
	<div>
		<h3>${status.count}. <a href="<c:url value="#"/>">${pickList.name}</a></h3>
		주소        : ${pickList.citycode} ${pickList.districtcode} ${pickList.address}<br>
		영업시간  : ${pickList.time}<br> 
		메뉴        : ${pickList.menu}<br>
		조회수     : ${pickList.count}
	</div>
	<div style="padding-bottom:3px;" class="delete">
		<button type="button" class="delete${pickList.storeNum}btn" data-storeNum="${pickList.storeNum}">삭제</button>
	<script>
 		$(".delete${pickList.storeNum}btn").click(function(){
  			var confirm_val = confirm("정말 삭제하시겠습니까?");
  
  		if(confirm_val) {
   			var checkArr = new Array();
   
   		
    		checkArr.push($(this).attr("data-storeNum"));
   		
    
   		$.ajax({
    		
   			url : "/sumbab/sb/delPick",
    		type : "post",
    		data : { chbox : checkArr },
    		success : function(result){
     			
     			if(result == 1){
     				location.href = "/sumbab/sb/myPick"; 
     			}else{
     				alert("삭제 실패");
     			}
     		} 
     			
     			
    
   });
  } 
 });
</script>
		
	
	</div>
	
	
	</c:forEach>
	
	
	<div style="padding: 50px 1px 2px 100px;">  
		<a href="javascript:window.history.back();">뒤로가기</a>
	</div>

</c:otherwise>

</c:choose>
</body>
</html>