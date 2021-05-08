<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가게 등록하기-1단계</title>
</head>
<body>

	<h1>가게 등록하기</h1>


	<form:form method="post" action="registerStep1-2" commandName="storeDTO" enctype="multipart/form-data">
		<input type="radio" name="classify" value="음식점">음식점 등록
		<input type="radio" name="classify" value="카페">카페 등록
		<table>
			<tr>
				<th>가게명:</th>
				<td><input type="text" placeholder="가게명을 입력해주세요." name="name" id="name" required></td>
			</tr>
			<tr>
				<th>위치:</th>
				<td>
				<input type="text" id="postcode" placeholder="우편번호">
				<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
				<input type="text" id="fullAddress" name="fullAddress" placeholder="주소"><br>
				<input type="text" id="extrAddress" name="extrAddress" placeholder="상세주소" required>
				</td>
			</tr>
			<tr>
				<th>전화번호:</th>
				<td><input type="text" placeholder="전화번호를 입력해 주세요." name="phone" id="phone" required></td>
			</tr>
			<tr>
				<th>메뉴:</th>
				<td><textarea placeholder="메뉴-가격 순으로 입력해 주세요." name="menu" id="menu" required></textarea></td>
			</tr>
			<tr>
				<th>영업시간:</th>
				<td><input type="text" placeholder="영업시간을 입력해 주세요." name="time" id="time" required></td>
			</tr>
			<tr>
				<th>기타:</th>
				<td><textarea placeholder="주차 가능 여부, 배달 가능 여부, 반려동물 동반 등의 특이사항을 적어주세요." name="etc" id="etc" required></textarea></td>
			</tr>
			<tr>
				<th>대표 이미지:</th>
				<td>
					<input type="file" name="attached" id="attached">
					<input type="hidden" name="picture" id="picture">
				</td>
			</tr>
			<tr>
				<th>비밀번호:</th>
				<td><input type="password" placeholder="등록하신 가게 관리를 위한 비밀번호를 입력하세요. " name="pwd" id="pwd" required></td>
			</tr>
			<tr>
				<td colspan="2"><input type="checkbox" name="reserving" id="reserving">예약 가능</td>
			</tr>
		</table>

		<input type="submit" value="다음">
		</form:form>


<%---카카오 주소 api---%>		
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function execDaumPostcode() {
    	
        new daum.Postcode({
            oncomplete: function(data) {
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수
                if (data.userSelectedType === 'R') { //도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { //지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("fullAddress").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("extrAddress").focus();
            }
        }).open();
    }
</script>

</body>
</html>