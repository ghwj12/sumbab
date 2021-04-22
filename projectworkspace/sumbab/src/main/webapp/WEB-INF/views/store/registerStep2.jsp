<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>가게 등록하기-2단계</title>
</head>

<body onload="select()">
	<h1>카테고리 설정</h1>
	<div>숨밥 카테고리 기반 추천에 가게를 추천하려면, 아래 항목을 선택해주세요.<br>
		선택하지 않을 경우, 카테고리 추천에 나타나지 않을 수 있습니다.<br>
	</div>
	
	<form:form action="completeRegister" method="post" commandName="restCatData">
	<!-- value는 1,0으로 모두 값이 들어감 -->
		<div>
			<p>어떤 상황일 때 가면 좋은가요? (중복 선택 가능)</p>
		</div>
		<input type="checkbox" id="situation1" name="situation1" >혼밥하고 싶을 때<br>
		<input type="checkbox" id="situation2" name="situation2" >데이트 할 때<br>
		<input type="checkbox" id="situation3" name="situation3" >상견례 할 때<br>

		<div>
			<p>어느 시간대에 먹기 적합한가요? (중복 선택 가능)</p>
		</div>
		<input type="checkbox" id="timeslot1" name="timeslot1" >아침
		<input type="checkbox" id="timeslot2" name="timeslot2" >점심
		<input type="checkbox" id="timeslot3" name="timeslot3" >저녁
		<input type="checkbox" id="timeslot4" name="timeslot3" >야식
		<br>

		<div>
			<p>어떤 음식을 먹고 싶을 때 가기 적합한가요? (중복 선택 가능)</p>
		</div>
		<input type="checkbox" id="type1" name="type1" >한식<br>
		<input type="checkbox" id="type2" name="type2" >중식<br>
		<input type="checkbox" id="type3" name="type3" >양식<br>
		<input type="checkbox" id="type4" name="type3" >기타<br>
		<br>
		<input type="submit" value="등록하기">
	</form:form>
</body>
</html>