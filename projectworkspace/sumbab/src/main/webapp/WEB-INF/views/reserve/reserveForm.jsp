<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- datepicker -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- timepicker -->
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
<style>
/*datepicer 버튼 롤오버 시 손가락 모양 표시*/
.ui-datepicker-trigger {
	cursor: pointer;
}
/*datepicer input 롤오버 시 손가락 모양 표시*/
.hasDatepicker {
	cursor: pointer;
}
</style>

<<<<<<< HEAD
<title>${storelist.name} 예약하기</title>
=======
<title>${storeName} 예약하기</title>
>>>>>>> STORE
</head>
<body>
<!-- 가게 상세보기 view에서 storeVO.reserving==false 인 곳은 예약하기 버튼 비활성화 -->

<<<<<<< HEAD
	<h1>${storelist.name} 예약하기</h1>
=======
	<h1>${storeName} 예약하기</h1>
>>>>>>> STORE
	
	<form:form id="reserveDTO" name="reserveDTO" method="POST" action="/sumbab/reserve/completeReserve" commandName="reserveDTO">
		<table border="1">
			<tr>
				<th>이름:</th>
				<td><input type="text" name="reserveName" id="reserveName"
					placeholder="예약하시는 분의 성함을 입력해 주세요. "><br>
					<input type="checkbox" name="usingID" id="usingIDforName"
					onclick='f_check()'>ID 사용</td>
			</tr>
			<tr>
				<th>예약일 선택:</th>
				<td>클릭하여 선택하세요.<br>
					<input type="text" name="datepicker" id="datepicker">
					<input type="text" name="timepicker" id="timepicker">
				</td>
			</tr>
			<tr>
				<th>전화번호:</th>
				<td><input type="text" name="phone"
					placeholder="예약 하시는 분의 전화번호를 입력해 주세요. " required>
					<input type="hidden" id="storeNum" name="storeNum" value="${storeNum}">
					</td>
			</tr>
		</table>
		<input type="submit" value="예약하기">
	</form:form>
		 
	<script>
		function f_check() {
			if (document.reserveDTO.usingID.checked == true) {
				document.reserveDTO.reserveName.value = "deliciousman"; //"${memberVO.id}"
			} else if (document.reserveDTO.usingID.checked == false) {
				document.reserveDTO.reserveName.disabled = false;
			}
		}
	</script>
	
	<script>
		$(function() {
			$.datepicker.setDefaults({
				dateFormat : 'yy-mm-dd', //Input Display Format 변경
				showOtherMonths : true, //빈 공간에 현재월의 앞뒤월의 날짜를 표시
				showMonthAfterYear : true, //년도 먼저 나오고, 뒤에 월 표시
				changeMonth : false,
				yearSuffix : "년",
				monthNamesShort : [ '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12' ],
				monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월' ],
				dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
				dayNames : [ '일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일' ],
				minDate : "0",
				maxDate : "+1M"
			});

			//input을 datepicker로 선언
			$("#datepicker").datepicker();
			$('#datepicker').datepicker('setDate', 'today');

		});
	</script>

	<script>
	$(document).ready(function(){
	    $("#timepicker").timepicker({
	    timeFormat: 'HH:mm',
	    interval: 30,
	    minTime: '12',
	    maxTime: '20',
	    defaultTime: '12',
	    startTime: '12',
	    dynamic: false,
	    dropdown: true,
	    scrollbar: true
		});
	});
	</script>
	<script	src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
</body>

</html>