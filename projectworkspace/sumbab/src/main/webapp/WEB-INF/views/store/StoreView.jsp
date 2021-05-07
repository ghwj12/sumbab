<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<<<<<<< HEAD
=======
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
>>>>>>> STORE
<%
	pageContext.setAttribute("br", "<br/>");
	pageContext.setAttribute("cn", "\n");
%>
<<<<<<< HEAD
=======

>>>>>>> STORE
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세화면페이지</title>
<<<<<<< HEAD
<!-- 하단 제이쿼리를 위해.. -->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<%@ include file="/WEB-INF/views/shareHead.jsp"%>
=======

<!-- 하단 제이쿼리를 위해.. -->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<%@ include file="/WEB-INF/views/shareHead.jsp" %>
>>>>>>> STORE


<style type="text/css">
.topcorner {
	position: absolute;
	top: 0;
	right: 0;
}
<<<<<<< HEAD

=======
>>>>>>> STORE
.bottomright {
	position: absolute;
	bottom: 100;
	right: 0;
}
<<<<<<< HEAD

=======
>>>>>>> STORE
table, th, td {
	border-collapse: collapse;
	border: 1px solid black;
}
<<<<<<< HEAD

th, td {
	padding: 5px
}

=======
th, td {
	padding: 5px
}
>>>>>>> STORE
body {
	margin: 0px;
	padding: 0px;
}
</style>
</head>
<body>
<<<<<<< HEAD
	<c:choose>
		<c:when test="${storeVO.picture != null}">
			<img src="<c:url value="/upload_01store/${storeVO.picture}"/>"
			style="width: 70%; height: 250px; float: center;" />
		</c:when>
		<c:otherwise>
			<img src="/sumbab/resources/img/defaultimg.png"/>
		</c:otherwise>
	</c:choose>
=======
<<<<<<< HEAD
	<img src="${storelist.picture}"
		style="width: 70%; height: 250px; float: center;">
>>>>>>> 8c133a8cb351229be9aa7aa6aa50e3f072c20b9c

	<h1>${storelist.name}<br>
	</h1>
	조회수:${storelist.count}
=======
	<c:choose>
		<c:when test="${storeVO.picture != null}">
			<img src="<c:url value="/upload_01store/${storeVO.picture}"/>"
			style="width: 70%; height: 250px; float: center;" />
		</c:when>
		<c:otherwise>
			<img src="/sumbab/resources/img/defaultimg.png"/>
		</c:otherwise>
	</c:choose>
	<h1>${storeVO.name}<br>
	</h1>
	조회수: ${storeVO.count} &nbsp; 
>>>>>>> STORE
	평균별점: <b><fmt:formatNumber value="${avgStar}" type="pattern" pattern="0.00" /></b> &nbsp; 
	재방문의사: <b><fmt:formatNumber value="${avgRevisit}" type="pattern" pattern="0.0%" /></b>
	<br>

	<table id="storeInfo">
		<tr>
			<th>위치:</th>
<<<<<<< HEAD
			<td style="word-break: break-all">&nbsp;${storelist.citycode}
				&nbsp;${storelist.districtcode}&nbsp;${storelist.address}</td>
		</tr>
		<tr>
			<th>전화번호:</th>
			<td style="word-break: break-all">&nbsp;${storelist.phone}</td>
		</tr>
		<tr>
			<th>메뉴:</th>
			<td style="word-break: break-all">&nbsp;${storelist.menu}</td>
		</tr>
		<tr>
			<th>영업시간:</th>
			<td style="word-break: break-all">&nbsp;${storelist.time}</td>
		</tr>
		<tr>
			<th>특이사항:</th>
			<td style="word-break: break-all">&nbsp;${storelist.etc}</td>
=======
			<td style="word-break: break-all">&nbsp;${storeVO.cityCode}
			&nbsp;${storeVO.districtCode}&nbsp;${storeVO.address}</td>
		</tr>
		<tr>
			<th>전화번호:</th>
			<td style="word-break: break-all">&nbsp;${storeVO.phone}</td>
		</tr>
		<tr>
			<th>메뉴:</th>
			<td style="word-break: break-all">&nbsp;${fn:replace(storeVO.menu, cn, br)}</td>
		</tr>
		<tr>
			<th>영업시간:</th>
			<td style="word-break: break-all">&nbsp;${storeVO.time}</td>
		</tr>
		<tr>
			<th>특이사항:</th>
			<td style="word-break: break-all">&nbsp;${storeVO.etc}</td>
>>>>>>> STORE
		</tr>
		
		<tr>
			<th>연관태그:</th>
			<td style="word-break: break-all">&nbsp;
				<c:choose>
				<c:when test="${fn:length(allTags) == 0}">
					아직 작성된 태그가 없어요!
				</c:when>
				<c:otherwise>
					<c:forEach var="hashtag" items="${allTags}">
						<c:if test="${hashtag.count > 0 }">
<<<<<<< HEAD
						#${hashtag.tagName}
=======
						<a href="/sumbab/selectByTag/${hashtag.tagName}">#${hashtag.tagName}</a>
						
>>>>>>> STORE
						</c:if>
					</c:forEach>
				</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>
<<<<<<< HEAD
	<!-- =============================================================================================================================================== -->

	<script type="text/javascript">
	function openPick(storeNum){
		var popWidth = 600;
		var popHeight = 400;
		var winHeight = document.body.clientHeight;
		var winWidth = document.body.clientWidth;
		var winX = window.screenLeft;
		var winY = window.screenTop;
		var popX = winX + (winWidth - popWidth)/2;
		var popY = winY + (winHeight - popHeight)/2;
		url="/sumbab/Pick/PickProcess/" + storeNum;						//merge하면 아마 ../pickProcess/${reviewNum}으로 변경
		var openWin = window.open(url, "openPick", "left="+popX+",top="+popY+",width="+popWidth+",height="+popHeight);
	}
	</script>
	
	
	<input type="button" onclick= "openPick(${storelist.storeNum})" value="보관함에담기">
	<c:set var="reserving" value="${storelist.reserving}" />
	<c:choose>
	<%--reserving 값에 따라 예약하기/예약불가 버튼 출력--%>
	<c:when test="${reserving != null}">
		<input type="button" value="예약하기" onclick="location.href='/sumbab/reserve/reserveForm/${storelist.storeNum}'" >
=======
	<%-- =============================================================================================================================================== 
		추후에 보관함 예약 마무리되서 들어오면 action말고 href로 링크로넘기거나 submit하거나 상황에따라 변경될예정--%>
	<input type="button" onclick="" value="보관함에 담기">
	<c:set var="reserving" value="${storeVO.reserving}" />
	<c:choose>
	<%--reserving 값에 따라 예약하기/예약불가 버튼 출력--%>
	<c:when test="${reserving eq true}">
		<input type="button" value="예약하기" onclick="location.href='/sumbab/reserve/reserveForm/${storeVO.storeNum}'" >
>>>>>>> STORE
	</c:when>
	<c:otherwise>
		<input type="button" value="예약불가">
	</c:otherwise>
	</c:choose>
	<!-- ================================================================================================================================================== -->
	<div id="reviewTitle">
<<<<<<< HEAD
	<h2>리뷰 | ${ReviewtotalCount}</h2>
		<input type="button" value="리뷰 작성" onclick="location.href='/sumbab/review/writeReview/${storelist.storeNum}'">
	</div>
	
=======
	<h2>리뷰 | ${countReview}</h2>
		<input type="button" value="리뷰 작성" onclick="location.href='/sumbab/review/writeReview/${storeVO.storeNum}'">
	</div>
>>>>>>> STORE
	<div id="reviewList">
		<c:forEach items="${Reviewlist}" var="Reviewlist">
			<table class="reviewInfo">
				<tr>
					<th>작성자:</th>
					<td width="500" style="word-break: break-all">&nbsp;${Reviewlist.id}<br>
<<<<<<< HEAD
						<input type="button" value="신고하기" class="warning" />
						<input type="hidden" name="reviewNum" value="${Reviewlist.reviewNum}" /> 
=======
>>>>>>> STORE
					</td>
				</tr>
				<tr>
					<th>별점:</th>
					<td width="500" style="word-break: break-all">&nbsp;${Reviewlist.star}</td>
				</tr>
				<tr>
					<th>작성일:</th>
<<<<<<< HEAD
					<td width="500" style="word-break: break-all">&nbsp;${Reviewlist.regdate}</td>
				</tr>
				<tr>
					<th>리뷰내용:</th>
					<td width="500" style="word-break: break-all"><img
						src="/upload_02review/${Reviewlist.picture}"><br>
						${Reviewlist.content}</td>
=======
					<td width="500" style="word-break: break-all">&nbsp;${Reviewlist.regDate}</td>
				</tr>
				<tr>
					<th>리뷰내용:</th>
					<td width="500" style="word-break: break-all">
					<img width="250px" src="<c:url value="/upload_02review/${Reviewlist.picture}"/>"/>

						${fn:replace(Reviewlist.content, cn, br)}<br>
						<c:forEach items="${tagList}" var="tagList" >
							<c:if test="${Reviewlist.reviewNum eq tagList.key}">
								<c:out value="${tagList.value}"/>
							</c:if>
						</c:forEach>
						</td>
>>>>>>> STORE
				</tr>
			</table>
		</c:forEach>
	</div>

	<c:forEach var="cnt" begin="1" end="${totalCount}" step="1">
<<<<<<< HEAD
		<a href="javascript:goPaging(${storeNum}, ${cnt });">${cnt }</a>
	</c:forEach>

	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>

	<script>
	$(document).on("click", ".warning", function(e){
		var reviewNum = $(this).next(":hidden").val();
		console.log(reviewNum);
		var popWidth = 600;
		var popHeight = 400;
		var winHeight = document.body.clientHeight;
		var winWidth = document.body.clientWidth;
		var winX = window.screenLeft;
		var winY = window.screenTop;
		var popX = winX + (winWidth - popWidth) / 2;
		var popY = winY + (winHeight - popHeight) / 2;
		url = "Warning/warningProcess/" + reviewNum
		var openWin = window.open(url, "openWarning", "left=" + popX
				+ ",top=" + popY + ",width=" + popWidth + ",height="
				+ popHeight);
	});
	function goPaging(storeNum, pageNo) {
		$.ajax({
			url:"/sumbab/store/StoreView2/" + storeNum + "/" + pageNo,
=======
		<a href="javascript:goPaging(${storeNum}, ${cnt});">${cnt}</a>
	</c:forEach>


	<!--  ajax로 데이터를 받고 페이징 처리할것이다 앞서 헀던 컨트롤러에서 responsebody가 붙은 ajax요청전용 컨트롤러를 통해 데이터가 ajax로 전달됨
	아무래도 url이나 type,dataType부분을 ajax선언할때 신경을 많이써야하는것 같다.. 컨트롤러에서도 json은 기본적으로 String형으로 데이터를 받는다는데 컨트롤러에서도 
	object로 때렸다을떄 오류가 난이유도 이런부분때문이지않을까 추측......
	
	위에 jstl foreach에 있는 테이블에 ajax가 데이터를 하나씩 전해주는 느낌? 으로 이해하고있다..존나 어렵다,, 
	위 테이블 형식과 동일한 제이쿼리 테이블을 append() 함수를 이용해서 추가 대가리깨진다.....
	뭔가 ajax로 받은 데이터가 도착할 종착점(위 테이브 부분)에 가지 전 거푸집같은 느낌..??확실히는 나도 잘모르곘다...
	이미지 부분은 추후에 샘플데이터가 더 추가되면 테스트해볼예정.. 신고하기기능도 마찬가지.... 
	...goPaging()함수안에 ajax가 관건,,,-->
	<script>
	function goPaging(storeNum, pageNo) {
		$.ajax({
			url:"/project/StoreView2/" + storeNum + "/" + pageNo,
>>>>>>> STORE
			type:"get",
			dataType:"json",
			success:function(data){
				console.log(data);
<<<<<<< HEAD
				var keys = ["reviewNum","id", "star", "regdate", "content"];
=======
				var keys = ["id", "star", "regDate", "content"];
>>>>>>> STORE
				var datas = ["작성자", "별점", "작성일", "리뷰내용"];
				var table = $("<table>", {"class":"reviewInfo"});
				$(data).each(function(i, elem){
					let img = $("<img>").attr("src", elem.picture != null ? elem.picture : "C:\storeimages\defaultimiage.PNG");
					table
<<<<<<< HEAD
						.append($("<tr>").append($("<th>").text("작성자")).append($("<td>").html(elem.id + "<br />")
								.append($("<input>", {type:"button", value:"신고하기"}).addClass("warning"))
								.append($("<input>", {type:"hidden", value:elem.reviewNum}))))
=======
						.append($("<tr>").append($("<th>").text("작성자")).append($("<td>", {text:elem.id})))
>>>>>>> STORE
						.append($("<tr>").append($("<th>").text("별점")).append($("<td>", {text:elem.star})))
						.append($("<tr>").append($("<th>").text("작성일")).append($("<td>", {text:elem.regdate})))
						.append($("<tr>")
							.append($("<th>").text("리뷰내용")).append($("<td>", {html:"<br />" + elem.content, css:{width:"500px", "word-break":"break-all"}})
									.prepend(img)));
				});
				console.log(table);
				$("#reviewList").children().remove();
				$("#reviewList").append(table);
			},
			error:function(xhr, status, res) {
				console.log("error")
				console.log(xhr);
				console.log(status);
				console.log(res);
			}
		});
	}
<<<<<<< HEAD
	</script>




=======
	
	</script>
<!--  나중에 신고하기 기능이 다나오면 아래에 신고하기 함수 는 주석 풀고 테스트해볼예정,,,, -->
	
	<!-- function warning(storeNum) {
		alert(storeNum);
	}
	const atag = $("<a>");
	atag.on('click', () => warning(1));
	atag.attr("style", "float: right")
	atag.button("신고하기"); -->
	
	
	
>>>>>>> STORE
	<!-- 팀장님과 쇼부친결과 근처지역 맛집추천 및 카페 추천 부분은 페이징없이 화면출력도 가게이름과 위치만나오고 가게이름을 누르면 해당 스토어 상세보기로 넘어가도록
	매우 간결하게 흘러감 -->
	<div id="nbsCafeList" class="bottomright">
		<h2>
<<<<<<< HEAD
			${storelist.name} 주변 카페<br>
=======
			${storeVO.name} 주변 카페<br>
>>>>>>> STORE
		</h2>
		<c:forEach items="${nbsCafe}" var="nbsCafe">
			<table class="nbsInfo">
				<tr>
					<th>가게이름:</th>
<<<<<<< HEAD
					<td style="word-break: break-all"><a
						href="<c:url value = "${nbsCafe.storeNum}" />">&nbsp;${nbsCafe.name}</a></td>
=======
					<td style="word-break: break-all"><a href="<c:url value = "/StoreView/${nbsCafe.store_num}" />">&nbsp;${nbsCafe.name}</a></td>
>>>>>>> STORE
				</tr>
				<tr>
					<th>위치:</th>
					<td style="word-break: break-all">&nbsp;${nbsCafe.citycode}&nbsp;
<<<<<<< HEAD
						${nbsCafe.districtcode}&nbsp;${nbsCafe.address}</td>
=======
					${nbsCafe.districtcode}&nbsp;${nbsCafe.address}</td>
>>>>>>> STORE
				</tr>
				<!-- 
				<tr>
					<th>메뉴:</th>
					<td style="word-break: break-all">&nbsp;${nbsCafe.menu}</td>
				</tr>
				<tr>
					<th>영업시간:</th>
					<td style="word-break: break-all">&nbsp;${nbsCafe.time}</td>
				</tr>
				<tr>
					<th>특이사항:</th>
					<td style="word-break: break-all">&nbsp;${nbsCafe.etc}</td>
				</tr>
				 -->
			</table>
		</c:forEach>
	</div>
<<<<<<< HEAD

	<!-- 주변 맛집 도 위에 주변카페와마찬가지로!!! -->
	<h1>
		${storelist.name} 주변 맛집<br>
=======
	
	<!-- 주변 맛집 도 위에 주변카페와마찬가지로!!! -->
	<h1>
		${storeVO.name} 주변 맛집<br>
>>>>>>> STORE
	</h1>
	<div id="nbsRestaurantList">
		<c:forEach items="${nbsRestaurant}" var="nbsRestaurant">
			<table class="nbsInfo">
				<tr>
					<th>가게이름:</th>
<<<<<<< HEAD
					<td style="word-break: break-all"><a
						href="<c:url value = "${nbsRestaurant.storeNum}" />">&nbsp;${nbsRestaurant.name}</a></td>
				</tr>
				<tr>
					<th>위치:</th>
					<td style="word-break: break-all">&nbsp;${nbsRestaurant.citycode}&nbsp;
						${nbsRestaurant.districtcode}&nbsp;${nbsRestaurant.address}</td>
=======
					<td style="word-break: break-all"><a href="<c:url value = "/StoreView/${nbsRestaurant.storeNum}" />">&nbsp;${nbsRestaurant.name}</a></td>
				</tr>
				<tr>
					<th>위치:</th>
					<td style="word-break: break-all">&nbsp;${nbsRestaurant.cityCode}&nbsp;
					${nbsRestaurant.districtCode}&nbsp;${nbsRestaurant.address}</td>
>>>>>>> STORE
				</tr>
				<!-- 
				<tr>
					<th>메뉴:</th>
					<td style="word-break: break-all">&nbsp;${nbsRestaurant.menu}</td>
				</tr>
				<tr>
					<th>영업시간:</th>
					<td style="word-break: break-all">&nbsp;${nbsRestaurant.time}</td>
				</tr>
				<tr>
					<th>특이사항:</th>
					<td style="word-break: break-all">&nbsp;${nbsRestaurant.etc}</td>
				</tr>
				 -->
			</table>
		</c:forEach>
	</div>
<<<<<<< HEAD


	<div id="map" class="topcorner"
		style="width: 30%; height: 250px; float: left;"></div>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c771ec3c7832fcdda8a8784dd25a4cb4&libraries=services"></script>
	<script>
		var address = "${storelist.address}";

=======
	
	
	<div id="map" class="topcorner"
		style="width: 30%; height: 250px; float: left;"></div>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=07bd206de0b20792cb3f4735d8aeb250&libraries=services"></script>
	<script>
		var address = "${storeVO.address}";
>>>>>>> STORE
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};
<<<<<<< HEAD

		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption);

		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();

=======
		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption);
		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();
>>>>>>> STORE
		// 주소로 좌표를 검색합니다
		geocoder
				.addressSearch(
						address,
						function(result, status) {
<<<<<<< HEAD

							// 정상적으로 검색이 완료됐으면 
							if (status === kakao.maps.services.Status.OK) {

								var coords = new kakao.maps.LatLng(result[0].y,
										result[0].x);

=======
							// 정상적으로 검색이 완료됐으면 
							if (status === kakao.maps.services.Status.OK) {
								var coords = new kakao.maps.LatLng(result[0].y,
										result[0].x);
>>>>>>> STORE
								// 결과값으로 받은 위치를 마커로 표시합니다
								var marker = new kakao.maps.Marker({
									map : map,
									position : coords
								});
<<<<<<< HEAD

								// 인포윈도우로 장소에 대한 설명을 표시합니다
								var infowindow = new kakao.maps.InfoWindow(
										{
											content : '<div style="width:150px;text-align:center;padding:6px 0;">${storelist.name}</div>'
										});
								infowindow.open(map, marker);

=======
								// 인포윈도우로 장소에 대한 설명을 표시합니다
								var infowindow = new kakao.maps.InfoWindow(
										{
											content : '<div style="width:150px;text-align:center;padding:6px 0;">${storeVO.name}</div>'
										});
								infowindow.open(map, marker);
>>>>>>> STORE
								// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
								map.setCenter(coords);
							}
						});
	</script>
</body>
</html>