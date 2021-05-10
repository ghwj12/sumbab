
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
	width: 188px;
	height: 132px;
	margin-left: -85px;
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

}

.desc .ellipsis {
	font-size: 12px;
	font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;
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
				DrawCircle(lat, lon)
				DrawHumanMarker(lat, lon);
			
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

			var storeNumArray = [];

			var classifyArray = [];

			var cityArray = [];

			var districtArray = [];

			var addressArray = [];

			var nameArray = [];
			
			var pictureArray = [];

			<c:forEach items="${GPS}" var="GPS">

			storeNumArray.push("${GPS.storeNum}");

			classifyArray.push("${GPS.classify}");

			cityArray.push("${GPS.citycode}");

			districtArray.push("${GPS.districtcode}");

			addressArray.push("${GPS.address}");

			nameArray.push("${GPS.name}");
			
			pictureArray.push("${GPS.picture}");

			</c:forEach>

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

										console.log(content);
										console.log(nameArray[i]);
										// 커스텀 오버레이를 생성합니다
										var customOverlay = new daum.maps.CustomOverlay(
												{
													position : coords,
													content : content
												});

										var content = document
												.createElement('div');
										content.className = 'customOverlay';
										content.innerHTML = '<div class="wrap">'
											+ '    <div class="info">'
											+ '        <div class="title">'
											+ nameArray[i]
											+ '            <div class="" onclick="closeOverlay()" title=""></div>'
											+ '        </div>'
											+ '        <div class="body">'
											+ '            <div class="desc">'
											+ '                <div class="ellipsis">'
											+ classifyArray[i]
											+ '					<br>'
											+ cityArray[i]
											+ districtArray[i]
											+ '					<br>'
											+ addressArray[i]
											+ '				 </div>'
											+ '				<div><a href="http://localhost:8090/sumbab/store/StoreView/' 
									    +storeNumArray[i]+ '" target="_blank" class="link">가게상세보기페이지로이동하기</a></div>'
											+ '           </div>'
											+ '        </div>'
											+ '    </div>' 
											+ '</div>';
										//========================================================================================================================================
										var closeBtn = document
												.createElement('button');
										closeBtn.innerHTML ='<div class="wrap">'
											+ '    <div class="info">'
											+ '        <div class="title">'
											+ nameArray[i]
											+ '            <div class="" onclick="closeOverlay()" title=""></div>'
											+ '        </div>'
											+ '        <div class="body">'
											+ '            <div class="desc">'
											+ '                <div class="ellipsis">'
											+ classifyArray[i]
											+ '					<br>'
											+ cityArray[i]
											+ districtArray[i]
											+ '					<br>'
											+ addressArray[i]
											+ '				 </div>'
											+ '				<div><a href="http://localhost:8090/sumbab/store/StoreView/' 
									    +storeNumArray[i]+ '" target="_blank" class="link">가게상세보기페이지로이동하기</a></div>'
											+ '           </div>'
											+ '        </div>'
											+ '    </div>' 
											+ '</div>';
										closeBtn.onclick = function() {
											customOverlay.setMap(null);
										};
										content.appendChild(closeBtn);

										customOverlay.setContent(content);

										kakao.maps.event.addListener(marker,
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
			var imageSrc = 'https://ifh.cc/g/ltBYAF.png', imageSize = new daum.maps.Size(
					60, 60), // 마커이미지의 크기입니다
			imageOption = {
				offset : new daum.maps.Point(20, 50)
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

</body>
</html>