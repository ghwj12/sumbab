<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>가게 정보 수정하기</title>
</head>
<body>
<h2>"${store.name}" 정보 수정하기</h2>
<form:form commandName="store" method="post" action="/sumbab/store/editStore/${storeNum}" enctype="multipart/form-data">
		
		<input type="radio" name="classify" value="음식점"
			<c:if test="${store.classify eq '음식점'}"> checked="checked"</c:if>>음식점 등록
		<input type="radio" name="classify" value="카페"
			<c:if test="${store.classify eq '카페'}"> checked="checked"</c:if>>카페 등록
		<table>
			<tr>
				<th>가게명:</th>
				<td><input type="text" name="name" id="name" value="${store.name}" required></td>
				<td rowspan="7">
					<c:choose>
						<c:when test="${store.picture eq null}">
						등록된 이미지가 없습니다.<br>사진을 등록해보세요!
						</c:when>
						<c:when test="${store.picture != null}">
							<img src="<c:url value="/upload_01store/${store.picture}"/>" width="300px"/>
						</c:when>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th>현재 주소:</th>
				<%--주소 api에서 받아오는 값의 형식을 임의로 쪼갰기 때문에, edit 모드에서 원래의 값 형태로 되돌리는 것은 어렵다.
					그래서 주소 변경이 있을 시 or 없을 시의 case로 접근 --%>
				<td>${store.citycode} ${store.districtcode}<br>
				${store.address}
				<input type="hidden" name="citycode" value="${store.citycode}">
				<input type="hidden" name="districtcode" value="${store.districtcode}">
				<input type="hidden" name="address" value="${store.address}">
				</td>
			</tr>
			<tr>
				<th>주소 변경:</th>
				<td>
				<input type="text" id="postcode" placeholder="우편번호">
				<input type="button" onclick="execDaumPostcode()" value="검색"><br>
				
				<input type="text" placeholder="주소가 변경되었을 시에만  " id="fullAddress" name="fullAddress"><br>
				<input type="text" placeholder="새로 입력하세요. " id="extrAddress" name="extrAddress">
				</td>
			</tr>
			<tr>
				<th>전화번호:</th>
				<td><input type="text" value="${store.phone}" name="phone" id="phone" required></td>
			</tr>
			<tr>
				<th>메뉴:</th>
				<td><textarea name="menu" id="menu" required>${store.menu}</textarea></td>
			</tr>
			<tr>
				<th>영업시간:</th>
				<td><input type="text" value="${store.time}" name="time" id="time" required></td>
			</tr>
			<tr>
				<th>기타:</th>
				<td><textarea name="etc" id="etc" required>${store.etc}</textarea></td>
			</tr>
			<tr>
				<th>대표 이미지:</th>
				<td>
					<input type="file" name="attached" id="attached">
					<input type="hidden" name="picture" id="picture" value="${store.picture}">
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="checkbox" name="reserving" id="reserving"
					<c:if test="${store.reserving eq true}"> checked="checked"</c:if>>예약 가능</td>
			</tr>
		</table>

		<input type="submit" value="수정 완료">
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