
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<title>내 위치 주변 맛집과 카페</title>
<style>
.wrap {
	position: absolute;
	left: 0;
	bottom: 40px;
	width: 288px;
	height: 132px;
	margin-left: -144px;
	text-align: left;
	overflow: hidden;
	font-size: 12px;
	font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;
	line-height: 1.5;
}

.wrap * {
	padding: 0;
	margin: 0;
}

.wrap .info {
	width: 286px;
	height: 120px;
	border-radius: 5px;
	border-bottom: 2px solid #ccc;
	border-right: 1px solid #ccc;
	overflow: hidden;
	background: #fff;
}

.wrap .info:nth-child(1) {
	border: 0;
	box-shadow: 0px 1px 2px #888;
}

.info .title {
	padding: 5px 0 0 10px;
	height: 30px;
	background: #eee;
	border-bottom: 1px solid #ddd;
	font-size: 18px;
	font-weight: bold;
}

.info .close {
	position: absolute;
	top: 10px;
	right: 10px;
	color: #888;
	width: 17px;
	height: 17px;
	background:
		url('http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png');
}

.info .close:hover {
	cursor: pointer;
}

.info .body {
	position: relative;
	overflow: hidden;
}

.info .desc {
	position: relative;
	margin: 13px 0 0 90px;
	height: 75px;
}

.desc .ellipsis {
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}

.desc .jibun {
	font-size: 11px;
	color: #888;
	margin-top: -2px;
}

.info:after {
	content: '';
	position: absolute;
	margin-left: -12px;
	left: 50%;
	bottom: 0;
	width: 22px;
	height: 12px;
	background:
		url('http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')
}

.info .link {
	color: #5085BB;
}
</style>



<!-- 
1.컨트롤러에서 전달된 모델값을 스크립트에서 받기 
2.마커생성 함수 부분에서 for문돌려 마커여럿생성
3.gps api사용
4.합체
 -->

<!--https://sol-study.tistory.com/3 마커여러개 생성 참고자료
======================================================================================================================================================
https://epthffh.tistory.com/entry/Javascript-%EC%97%90%EC%84%9C-JSTL-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0-%EC%99%80-%EC%A3%BC%EC%9D%98%EC%82%AC%ED%95%AD 
데이터 스트립트에서 받는 방법 참고자료
-->
</head>
<body>
	<h1>내위치근방에 맛집/카페 보기</h1>
	<h4>(*고객님 위치 근방에 마커를 클릭하면 상세보기가 나옵니다!*)</h4>

	<!-- 아래 api를 사용할려면 카카오 개발자 센터에서 키값을 할당받아 등록해야함 -->
	<div id="map" style="width: 70%; height: 500px;"></div>

	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c771ec3c7832fcdda8a8784dd25a4cb4&libraries=services"></script>

	<script>
		var circle;
		var circleList = [];
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 

		mapOption = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			level : 5
		// 지도의 확대 레벨 
		};

		var geocoder = new daum.maps.services.Geocoder();

		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

		// HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
		if (navigator.geolocation) {

			// GeoLocation을 이용해서 접속 위치를 얻어옵니다
			navigator.geolocation.getCurrentPosition(function(position) {

				var lat = position.coords.latitude, // 위도
				lon = position.coords.longitude; // 경도

				var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
				message = '<div style="padding:5px;">현재 내 위치입니다!</div>'; // 인포윈도우에 표시될 내용입니다

				// 마커와 인포윈도우를 표시합니다
				displayMarker(locPosition, message);
				DrawHumanMarker(lat, lon);
				DrawCircle(lat, lon)

			});

		} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다

			var locPosition = new kakao.maps.LatLng(33.450701, 126.570667), message = 'geolocation을 사용할수 없어요..'

			displayMarker(locPosition, message);
		}

		// 지도에 마커와 인포윈도우를 표시하는 함수입니다
		function displayMarker(locPosition, message) {

			// 마커를 생성합니다
			var marker = new kakao.maps.Marker({
				map : map,
				position : locPosition
			});

			var iwContent = message, // 인포윈도우에 표시할 내용
			iwRemoveable = true;

			// 인포윈도우를 생성합니다
			var infowindow = new kakao.maps.InfoWindow({
				content : iwContent,
				removable : iwRemoveable
			});

			// 인포윈도우를 마커위에 표시합니다 
			infowindow.open(map, marker);

			// 지도 중심좌표를 접속위치로 변경합니다
			map.setCenter(locPosition);

			CreateMakers();

		}
		function CreateMakers() {

			var geocoder = new daum.maps.services.Geocoder();

			//========================================================================================================================
			//컨트롤러에서 전달받은 모델값을 이용해 그 데이터를 토대로 아래에서 for문을 돌려 addressSearch하여 나오는 위도 경도 위치에 
			//마커를 생성할텐데 이전에는 항상 고정관념마냥 컨트롤러에서 전달받은 모델값은 스크립트단 외부에 jsp에서 jstl forEach태그를 통해 
			//전달받고 그다음 스크립트단으로 넣을려고했는데 그냥 스크립트단에서 바로 forEach태그를 때려도 스크립트단에 전달이 된더라!
			//그것을 담을 var addressArray[]를 먼저 생성하고 .push()함수를 통해 값을 넣어준다.
			var storeNumArray = [];
			
			var classifyArray = [];
			
			var cityArray = [];

			var districtArray = [];

			var addressArray = [];

			var nameArray = [];

			<c:forEach items="${GPS}" var="GPS">
			
			storeNumArray.push("${GPS.storeNum}")
			
			classifyArray.push("${GPS.classify}")

			cityArray.push("${GPS.citycode}")

			districtArray.push("${GPS.districtcode}")

			addressArray.push("${GPS.address}");

			nameArray.push("${GPS.name}");

			</c:forEach>
			//=========================================================================================================================
			//값이 채워진 addressArray의 length만큼 for문을돌려 addressSearch하여 
			//var marker = new daum.maps.Marker({
			//map : map,
			//position : coords
			//});
			//위와같이 마커생성하여 	marker.setMap(map); 맵에 set하는 부분까지

			for (let i = 0; i < addressArray.length; i++) {
				geocoder
						.addressSearch(
								addressArray[i],
								function(result, status, data) {
									// 정상적으로 검색이 완료됐으면 
									if (status === daum.maps.services.Status.OK) {

										var coords = new daum.maps.LatLng(
												result[0].y, result[0].x);

										// 결과값으로 받은 위치를 마커로 표시합니다
										var marker = new daum.maps.Marker({
											map : map,
											position : coords
										});

										// 마커를 지도에 표시합니다.
										marker.setMap(map);

										//=====================================================================================================================================
										var content = '<div class="wrap">'
												+ '    <div class="info">'
												+ '        <div class="title">'
												+ nameArray[i]
												+ '            <div class="close" onclick="closeOverlay()" title="닫기"></div>'
												+ '        </div>'
												+ '        <div class="body">'
												+ '            <div class="desc">'
												+ '                <div class="ellipsis">'
												+ classifyArray[i]
												+ '					<br>'				
												+ cityArray[i]
												+ districtArray[i]
												+ addressArray[i]
												+ '				 </div>'
											    + '				<div><a href="http://localhost:8090/sumbab/store/StoreView/' 
											    +storeNumArray[i]+ '" target="_blank" class="link">가게상세보기페이지로이동하기</a></div>' 
												+ '           </div>'
												+ '        </div>'
												+ '    </div>' 
												+ '</div>';

										console.log(content);
										console.log(nameArray[i]);
										// 커스텀 오버레이를 생성합니다
										var customOverlay = new daum.maps.CustomOverlay(
												{
													position : coords,
													content : content
												});
										daum.maps.event.addListener(marker,
												'click', function() {
													customOverlay.setMap(map);
												});

										
									}
								});
			}
		}

		//마커를 사람아이콘으로 꾸며봤습니다
		function DrawHumanMarker(lat, lon) {
			console.log("DrawHumanMarker ");
			var imageSrc = 'https://ifh.cc/g/slv1L0.png', imageSize = new daum.maps.Size(
					32, 38), // 마커이미지의 크기입니다
			imageOption = {
				offset : new daum.maps.Point(20, 40)
			}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

			var markerImage = new daum.maps.MarkerImage(imageSrc, imageSize,
					imageOption), markerPosition = new daum.maps.LatLng(lat,
					lon); // 마커가 표시될 위치입니다

			var poiDaumMarker = new daum.maps.Marker({
				position : markerPosition,
				image : markerImage
			// 마커이미지 설정 
			});

			poiDaumMarker.setMap(map);
		}
		//원반경까지 꾸미기는 덤으로다가
		function DrawCircle(lat, lon) {

			console.log("DrawCircle");

			circle = new daum.maps.Circle({
				center : new daum.maps.LatLng(lat, lon), // 원의 중심좌표 입니다 
				radius : 500, // 미터 단위의 원의 반지름입니다 
				strokeWeight : 5, // 선의 두께입니다 
				strokeColor : '#75B8FA', // 선의 색깔입니다
				strokeOpacity : 1, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
				strokeStyle : 'dashed', // 선의 스타일 입니다
				fillColor : '#CFE7FF', // 채우기 색깔입니다
				fillOpacity : 0.3
			// 채우기 불투명도 입니다   
			});

			circle.setMap(map);
		}
	</script>
	<!-- geolocation api(GPS기반, 카카오에서 제공하는) + maker여럿생성하는 api(데이터부분은 맨위 상단에 있는 참고자료를 토대로 컨트롤러에 전달된값을 이용
	해당 api 참고자료는 https://sol-study.tistory.com/3 지도 api응용)  
	========================================================================================================================================================
	<!-- 정리 결론
			응용방법설명
	
			구글링을 통해 알게된 https://blog.naver.com/PostView.nhn?blogId=ivory82&logNo=220558452225 분의 참고자료를 토대로
			위에 자료 같은 경우는 gps기반으로 먼저 내위치를 찾는 맵을 생성하고 내위치기준에서 이미지와 원circle을 띄우는 함수를 따로 만들어 map안에 불러들이는
			원리인다.
		    이걸 응용해서 나도 먼저 gps api를 생성하고 maker를 여러개 만드는 api에서 map부분만 지우고 (맵이 두개 선언되어 맵이 충돌되기에)
			나머지 마커생성 부분만 남긴뒤 그냥 함수처리하여 gps api안에 박아버린다.
			83행의 CreateMakers(); 부분이 마커생성 api부분을 호출하는 부분이다.
	================================================================================================================================================================
	문제점1: 기능을 실행하면 내위치가 먼저 나와야하는데 전체 마커+내위치부분을 포함한 서울전체 지역이 나온다 이부분을 실행하자마자 바로 내위치 먼저 나오게끔 수정하자
	해결함:  지도의 확대 레벨을 10 에서 5로 수정
	
	문제점2: 생성된 마커들에 주소만 나오고 가게이름은 안나온다. 어떻게든 content부분을 수정하여 가게이름 + 주소가 나오게끔 만들자
	해결함: 너무나도 허무하게 for문안에 var i 를 let i로 바꾸고 커스텀오버레이에 들어갈 content부분에 nameArray[i]넣어주니 깔끔히 해결
	
	문제점3: 기능을 실행하면 지도가 흘들리면서 마커와 내위치 가 동시에 생성되는 충돌부분
	해결함:  CreateMakers()의 map.setCenter(coords); 지움 두가지 api의 map.setCenter()함수가 충돌하면서 생기는 부분같은데 결과론적으로 gps api에 maker를 생성하는것을 덧붙이는것이고
	우리가 원하는 기능은 내 위치 기준이니 내위치의 map.setCenter()함수만 남겨둔다
	
	
	 -->
</body>
</html>