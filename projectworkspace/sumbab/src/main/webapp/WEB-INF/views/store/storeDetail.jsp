<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	pageContext.setAttribute("br", "<br/>");
	pageContext.setAttribute("cn", "\n");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 : 가게 상세보기</title>
</head>
<body>

<form:form method="post" action="" commandName="storeVO" enctype="multipart/form-data">
	<h2>"${store.name}" : 가게 상세보기</h2>
	조회수:<b>${store.count}</b>&nbsp;
	평균별점:<b><fmt:formatNumber value="${avgStar}" type="pattern" pattern="0.00" /></b>&nbsp;
	재방문의사:<b><fmt:formatNumber value="${avgRevisit}" type="pattern" pattern="0.0%" /></b>
	<table border="1">
		<tr>
			<th>상호명</th>
			<td>${store.name}</td>
			<td rowspan="7"><c:choose>
					<c:when test="${store.picture != null}">
						<img src="/resources/upload_01store/${store.picture}" />
					</c:when>
					<c:otherwise>
		등록한 사진이 없습니다.
		</c:otherwise>
				</c:choose></td>
		</tr>
		<tr>
			<th>주소</th>
			<td>${store.citycode}${store.districtcode} ${store.address}</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${store.phone}</td>
		</tr>
		<tr>
			<th>메뉴</th>
			<td>${store.menu}</td>
		</tr>
		<tr>
			<th>영업시간</th>
			<td>${store.time}</td>
		</tr>
		<tr>
			<th>특이사항</th>
			<td>${store.etc}</td>
		</tr>
		<tr>
			<th>연관태그</th>
			<td><c:choose>
					<c:when test="${fn:length(allTags) == 0}">
					아직 작성된 태그가 없어요!
				</c:when>
					<c:otherwise>
						<c:forEach var="hashtag" items="${allTags}">
							<c:if test="${hashtag.count > 0 }">
								#${hashtag.tagName}
							</c:if>
						</c:forEach>
					</c:otherwise>
				</c:choose></td>
		</tr>
	</table>
	<input type="submit" value="가게정보 수정하기">
	<input type="button" value="가게 삭제하기" onclick="location.href='/sumbab/store/deleteStoreProc/${store.storeNum}'">
</form:form>
<br>
<hr>
	<h2>"${store.name}"의설정 카테고리</h2>
<c:choose>
	<c:when test="${store.classify eq '음식점'}">
<form:form method="post" action="" commandName="restCatVO" enctype="multipart/form-data">
	<table border="1">
		<tr>
			<th>어떤 상황일 때 가면 좋은가요?</th>
		</tr>
		<tr>
			<td><input type="radio" name="situation1"
				onclick="return(false);"
				<c:if test="${restCatVO.situation1 eq true}"> checked="checked"</c:if>>
				혼밥하고 싶을 때<br> <input type="radio" name="situation2"
				onclick="return(false);"
				<c:if test="${restCatVO.situation2 eq true}"> checked="checked"</c:if>>
				데이트 할 때<br> <input type="radio" name="situation3"
				onclick="return(false);"
				<c:if test="${restCatVO.situation3 eq true}"> checked="checked"</c:if>>
				상견례 할 때<br></td>
		</tr>
		<tr>
			<th>어느 시간대에 먹기 적합한가요?</th>
		</tr>
		<tr>
			<td><input type="radio" name="timeslot1"
				onclick="return(false);"
				<c:if test="${restCatVO.timeslot1 eq true}"> checked="checked"</c:if>>
				아침<br> <input type="radio" name="timeslot2"
				onclick="return(false);"
				<c:if test="${restCatVO.timeslot2 eq true}"> checked="checked"</c:if>>
				점심<br> <input type="radio" name="timeslot3"
				onclick="return(false);"
				<c:if test="${restCatVO.timeslot3 eq true}"> checked="checked"</c:if>>
				저녁<br> <input type="radio" name="timeslot3"
				onclick="return(false);"
				<c:if test="${restCatVO.timeslot4 eq true}"> checked="checked"</c:if>>
				야식<br></td>
		</tr>
		<tr>
			<th>어떤 음식을 먹고 싶을 때 가기 적합한가요?</th>
		</tr>
		<tr>
			<td><input type="radio" name="type1" onclick="return(false);"
				<c:if test="${restCatVO.type1 eq true}"> checked="checked"</c:if>>
				한식<br> <input type="radio" name="type2"
				onclick="return(false);"
				<c:if test="${restCatVO.type2 eq true}"> checked="checked"</c:if>>
				중식<br> <input type="radio" name="type3"
				onclick="return(false);"
				<c:if test="${restCatVO.type3 eq true}"> checked="checked"</c:if>>
				양식<br> <input type="radio" name="type3"
				onclick="return(false);"
				<c:if test="${restCatVO.type4 eq true}"> checked="checked"</c:if>>
				기타<br></td>
		</tr>
	</table>
	<input type="submit" value="카테고리 수정하기">
</form:form>
	</c:when>
	<c:otherwise>
	<form:form method="post" action="" commandName="cafeCatVO" enctype="multipart/form-data">
	<table border="1">
		<tr>
			<th>어떤 상황일 때 가면 좋은가요?</th>
		</tr>
		<tr>
			<td><input type="radio" name="situation1"
				onclick="return(false);"
				<c:if test="${cafeCatVO.situation1 eq true}"> checked="checked"</c:if>>
				데이트 할 때<br> <input type="radio" name="situation2"
				onclick="return(false);"
				<c:if test="${cafeCatVO.situation2 eq true}"> checked="checked"</c:if>>
				업무회의 할 때<br> <input type="radio" name="situation3"
				onclick="return(false);"
				<c:if test="${cafeCatVO.situation3 eq true}"> checked="checked"</c:if>>
				공부할 때<br></td>
		</tr>
		<tr>
			<th>24시간 운영하는 곳인가요? (코로나 2단계 미만 정상 영업 시)</th>
		</tr>
		<tr>
			<td><input type="radio" name="timeslot" onclick="return(false);"
				<c:if test="${cafeCatVO.timeslot eq true}"> checked="checked"</c:if>>
				24시간 운영
			</td>
		</tr>
		<tr>
			<th>어떤 분위기의 카페인가요?</th>
		</tr>
		<tr>
			<td><input type="radio" name="mood1" onclick="return(false);"
				<c:if test="${cafeCatVO.mood1 eq true}"> checked="checked"</c:if>>
				아기자기<br>
				<input type="radio" name="mood2" onclick="return(false);"
				<c:if test="${cafeCatVO.mood2 eq true}"> checked="checked"</c:if>>
				시크/모던<br>
				<input type="radio" name="mood3" onclick="return(false);"
				<c:if test="${cafeCatVO.mood3 eq true}"> checked="checked"</c:if>>
				포토존<br>
			</td>
		</tr>
		<tr>
			<th>공간은 어떻게 구성되어 있나요?</th>
		</tr>
		<tr>
			<td>
				<input type="radio" name="size1" onclick="return(false);"
				<c:if test="${cafeCatVO.size1 eq true}"> checked="checked"</c:if>>
				단층<br>
				<input type="radio" name="size2" onclick="return(false);"
				<c:if test="${cafeCatVO.size2 eq true}"> checked="checked"</c:if>>
				2층 이상<br>
				<input type="radio" name="size3" onclick="return(false);"
				<c:if test="${cafeCatVO.size3 eq true}"> checked="checked"</c:if>>
				루프탑<br>
			</td>
		</tr>
	</table>
	<input type="submit" value="카테고리 수정하기">
</form:form>
	</c:otherwise>
</c:choose>

</body>
</html>