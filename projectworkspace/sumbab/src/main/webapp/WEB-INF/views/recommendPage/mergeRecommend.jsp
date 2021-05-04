<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추천 페이지에 합치기</title>
</head>
<body>
<h3>숨밥꼭질 시작하기</h3>
카테고리를 선택하여 추천 받으세요!<br><br>
<form:form id="selected" commandName="selectedCategory" method="POST">
<c:if test="${reClassify == '음식점'}">
	<form:select path="category1" onchange="categoryChange(this)">
		<form:option value="x">카테고리 선택</form:option>
		<form:option value="situation">상황별</form:option>
		<form:option value="timeslot">시간별</form:option>
		<form:option value="type">종류별</form:option>
	</form:select>
	
	<form:select path="category2">
		<form:option value="x">카테고리를 먼저 선택해주세요</form:option>
	</form:select>
</c:if>
<c:if test="${reClassify == '카페'}">
	<form:select path="category1" onchange="categoryChange(this)">
		<form:option value="x">카테고리 선택</form:option>
		<form:option value="situation">상황별</form:option>
		<form:option value="timeslot">영업 시간별</form:option>
		<form:option value="mood">분위기별</form:option>
		<form:option value="size">크기별</form:option>
	</form:select>
	
	<form:select path="category2">
		<form:option value="x">카테고리를 먼저 선택해주세요</form:option>
	</form:select>
</c:if>
<input type="button" id="recommend" value="추천 받기" />
</form:form>

<script>
	function categoryChange(select){
		var category2_situation = [1, 2, 3];
		var rest_timeslot = [1, 2, 3, 4];
		var rest_type = [1, 2, 3, 4];
		var cafe_timeslot = [1, 0];
		var cafe_mood = [1, 2, 3];
		var cafe_size = [1, 2, 3];
		var rest_situation_text = ["혼밥", "데이트", "상견례"];
		var rest_timeslot_text = ["아침", "점심", "저녁", "야식"];
		var rest_type_text = ["한식", "양식", "중식", "기타"];
		var cafe_situation_text = ["데이트", "업무회의", "공부"];
		var cafe_timeslot_text = ["24시 영업", "영업 시간 있음"];
		var cafe_mood_text = ["아기자기", "모던함", "포토존"];
		var cafe_size_text = ["단층", "다층", "루프탑"];
		var target = document.getElementById("category2");
		var val, text;
		
		if(${reClassify == "음식점"}){
			if(select.value == "situation"){
				val = category2_situation;
				text = rest_situation_text;
			}
			else if(select.value == "timeslot"){
				val = rest_timeslot;
				text = rest_timeslot_text;
			}
			else{
				val = rest_type;
				text = rest_type_text;
			}
		}else{
			if(select.value == "situation"){
				val = category2_situation;
				text = cafe_situation_text;
			}
			else if(select.value == "timeslot"){
				val = cafe_timeslot;
				text = cafe_timeslot_text;
			}
			else if(select.value == "mood"){
				val = cafe_mood;
				text = cafe_mood_text;
			}
			else{
				val = cafe_size;
				text = cafe_size_text;
			}
		}
		
		target.options.length = 0;		//카테고리 선택 후 변경 시 다음 select의 option이 누적되어 나오는 것을 방지함
		
		for (x in val){
			var opt = document.createElement("option");
			opt.value = val[x];
			opt.innerHTML = text[x];
			target.appendChild(opt);
		}	
	}
</script>

<script src="https://code.jquery.com/jquery-2.2.4.js"></script> 
<!-- src 사용하면 script 태그 따로 사용해야 됨 -->
<script>	
	$("#recommend").on('click', function(){
		console.log("?????");
		var selectedCategory = {};
		selectedCategory.category1 = $("#category1 option:selected").val();
		selectedCategory.category2 = $("#category2 option:selected").val();
		if(selectedCategory.category1 == "x" || selectedCategory.category2 == "x"){
			alert("항목을 골라주세요.");
			history.go(0);
		}else{
			$("#selected").attr({
				"method" : "post",
				"action" : "../recommend/${reClassify}"
			})
			$("#selected").submit();
		}
	})
</script>

</body>
</html>