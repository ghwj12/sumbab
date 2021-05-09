<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리 수정</title>
</head>
<body>
<c:choose>
	<c:when test="${cafeCatVO.name == null && restCatVO.name == null }">
		<h2>카테고리 등록을 하지 않으셨네요!</h2>
	</c:when>
	<c:when test="${restCatVO == null}">
		<h2>${cafeCatVO.name} 카테고리 수정</h2>
	</c:when>
	<c:when test="${cafeCatVO == null }">
		<h2>${restCatVO.name} 카테고리 수정</h2>
	</c:when>
</c:choose>

	<div>숨밥 카테고리 기반 추천에 가게를 노출 하려면, 아래 항목을 선택해주세요.<br>
		선택하지 않을 경우, 카테고리 추천에 나타나지 않을 수 있습니다.<br>
	</div>
	
<c:choose>
	<c:when test="${cafeCatVO == null}">
<%--restaurant category================================ --%>
	<form:form action="/sumbab/store/editCat/${storeVO.storeNum}" method="post" commandName="restCatVO">
		<div>
			<p>어떤 상황일 때 가면 좋은가요? (중복 선택 가능)</p>
		</div>
		<input type="checkbox" id="situation1" name="situation1"
		<c:if test="${restCatVO.situation1 eq true}"> checked="checked"</c:if>>
		혼밥하고 싶을 때<br>
		<input type="checkbox" id="situation2" name="situation2"
		<c:if test="${restCatVO.situation2 eq true}"> checked="checked"</c:if>>
		데이트 할 때<br>
		<input type="checkbox" id="situation3" name="situation3"
		<c:if test="${restCatVO.situation3 eq true}"> checked="checked"</c:if>>
		상견례 할 때<br>

		<div>
			<p>어느 시간대에 먹기 적합한가요? (중복 선택 가능)</p>
		</div>
		<input type="checkbox" id="timeslot1" name="timeslot1"
		<c:if test="${restCatVO.timeslot1 eq true}"> checked="checked"</c:if>>
		아침
		<input type="checkbox" id="timeslot2" name="timeslot2"
		<c:if test="${restCatVO.timeslot2 eq true}"> checked="checked"</c:if>>
		점심
		<input type="checkbox" id="timeslot3" name="timeslot3"
		<c:if test="${restCatVO.timeslot3 eq true}"> checked="checked"</c:if>>
		저녁
		<input type="checkbox" id="timeslot4" name="timeslot4"
		<c:if test="${restCatVO.timeslot4 eq true}"> checked="checked"</c:if>>
		야식
		<br>

		<div>
			<p>어떤 음식을 먹고 싶을 때 가기 적합한가요? (중복 선택 가능)</p>
		</div>
		<input type="checkbox" id="type1" name="type1"
		<c:if test="${restCatVO.type1 eq true}"> checked="checked"</c:if>>
		한식<br>
		<input type="checkbox" id="type2" name="type2"
		<c:if test="${restCatVO.type2 eq true}"> checked="checked"</c:if>>
		중식<br>
		<input type="checkbox" id="type3" name="type3"
		<c:if test="${restCatVO.type3 eq true}"> checked="checked"</c:if>>
		양식<br>
		<input type="checkbox" id="type4" name="type4"
		<c:if test="${restCatVO.type4 eq true}"> checked="checked"</c:if>>
		기타<br>
		<br>
		<input type="submit" value="수정하기">
		<input type="button" value="취소" onclick="history.back(-1)">
	</form:form>
	</c:when>
<%--cafe category ============================= --%>
	<c:otherwise>
		<form:form action="/sumbab/editCat/${storeVO.storeNum}" method="post" commandName="cafeCatVO">
		<div>
			<p>어떤 상황일 때 가면 좋은가요? (중복 선택 가능)</p>
		</div>
		<input type="checkbox" id="situation1" name="situation1"
		<c:if test="${cafeCatVO.situation1 eq true}"> checked="checked"</c:if>>
		데이트 할 때<br>
		<input type="checkbox" id="situation2" name="situation2"
		<c:if test="${cafeCatVO.situation2 eq true}"> checked="checked"</c:if>>
		업무회의 할 때<br>
		<input type="checkbox" id="situation3" name="situation3"
		<c:if test="${cafeCatVO.situation3 eq true}"> checked="checked"</c:if>>
		공부할 때<br>

		<div>
			<p>24시간 운영하는 곳인가요?(코로나 2단계 미만 정상 영업 시))</p>
		</div>
		<input type="checkbox" id="timeslot" name="timeslot"
		<c:if test="${cafeCatVO.timeslot eq true}"> checked="checked"</c:if>>
		24시간 운영
		<br>

		<div>
			<p>어떤 분위기의 카페인가요? (중복 선택 가능)</p>
		</div>
		<input type="checkbox" id="mood1" name="mood1"
		<c:if test="${cafeCatVO.mood1 eq true}"> checked="checked"</c:if>>
		아기자기<br>
		<input type="checkbox" id="mood2" name="mood2"
		<c:if test="${cafeCatVO.mood2 eq true}"> checked="checked"</c:if>>
		시크/모던<br>
		<input type="checkbox" id="mood3" name="mood3"
		<c:if test="${cafeCatVO.mood3 eq true}"> checked="checked"</c:if>>
		포토존<br>
		<br>
		<div>
			<p>공간은 어떻게 구성되어 있나요? (중복 선택 가능)</p>
		</div>
		<input type="checkbox" id="size1" name="size1"
		<c:if test="${cafeCatVO.size1 eq true}"> checked="checked"</c:if>>
		단층<br>
		<input type="checkbox" id="size2" name="size2"
		<c:if test="${cafeCatVO.size2 eq true}"> checked="checked"</c:if>>
		2층 이상<br>
		<input type="checkbox" id="size3" name="size3"
		<c:if test="${cafeCatVO.size3 eq true}"> checked="checked"</c:if>>
		루프탑<br>
		<br>
		<input type="submit" value="등록하기">
	</form:form>
	</c:otherwise>
</c:choose>
</body>
</html>