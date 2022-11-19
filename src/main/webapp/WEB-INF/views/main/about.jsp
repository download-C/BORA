<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<!-- alert 모달 필수  --> 
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script src="https://cdn.jsdelivr.net/npm/promise-polyfill@7.1.0/dist/promise.min.js"></script>

<!-- 🐧🐧🐧  카카오지도 API 시작 🐧🐧🐧 -->
<style>
.label {
/* 이름표 위치 */
	margin-bottom: 120px;
	margin-right: 20px;
	font-weight: bold;
	color: white;
}

.label * {
	display: inline-block;
	vertical-align: top;
}

.label .left {
	background: #5f07b0;
		url("https://t1.daumcdn.net/localimg/localimages/07/2011/map/storeview/tip_l.png")
		no-repeat;
	display: inline-block;
	height: 24px;
	overflow: hidden;
	vertical-align: top;
	width: 7px;
	border-bottom-left-radius: 20px;
	border-top-left-radius: 20px;
}

.label .center {
	background: #5f07b0;
		url(https://t1.daumcdn.net/localimg/localimages/07/2011/map/storeview/tip_bg.png)
		repeat-x;
	display: inline-block;
	height: 24px;
	font-size: 12px;
	line-height: 24px;
}

.label .right {
	background: #5f07b0;
		url("https://t1.daumcdn.net/localimg/localimages/07/2011/map/storeview/tip_r.png")
		-1px 0 no-repeat;
	display: inline-block;
	height: 24px;
	overflow: hidden;
	width: 6px;
	border-bottom-right-radius: 20px;
	border-top-right-radius: 20px;
}
</style>
<div class="container">

<!-- 지도 크기 조절 -->
<div id="map" style="width:500px;height:450px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=35509f6b1a38859c7c7486bf14f0ae5c"></script>
<p id="result"></p>

</div>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
    mapOption = { 
    center: new kakao.maps.LatLng(35.214902, 129.094643), // 지도의 중심좌표
    level: 8 // 지도의 확대 레벨
};

var imageSrc = "${pageContext.request.contextPath}/resources/img/marker.png",   
imageSize = new kakao.maps.Size(40, 40), // 마커이미지의 크기
imageOption = {offset: new kakao.maps.Point(30, 55)}; // 마커이미지의 옵션, 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정
var map = new kakao.maps.Map(mapContainer, mapOption); // 지도 생성

//지도타입 컨트롤러 생성 및 추가
var mapTypeControl = new kakao.maps.MapTypeControl();
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

//줌 컨트롤러 생성 및 추가
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

//마커의 이미지정보를 가지고 있는 마커이미지를 생성
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption)

// 마커를 표시할 위치와 내용을 가지고 있는 객체 배열 
var positions = [
    {
        content: '<div class ="label"><span class="left"></span><span class="center">가계부CDU</span><span class="right"></span></div>',
        latlng: new kakao.maps.LatLng(35.172516, 129.108446)
    },
    {
        content: '<div class ="label"><span class="left"></span><span class="center">오픈뱅킹KHJ</span><span class="right"></span></div>',
        latlng: new kakao.maps.LatLng(35.213763, 129.089177)
    },
    {
        content: '<div class ="label"><span class="left"></span><span class="center">오픈뱅킹LEJ</span><span class="right"></span></div>',
        latlng: new kakao.maps.LatLng(35.18980, 129.069979)
    },
    {
        content: '<div class ="label"><span class="left"></span><span class="center">리포트LDS</span><span class="right"></span></div>',
        latlng: new kakao.maps.LatLng(35.157195, 129.087740)
    },
    {
        content: '<div class ="label"><span class="left"></span><span class="center">리포트JHW</span><span class="right"></span></div>',
        latlng: new kakao.maps.LatLng(35.202118, 129.121884)
    },
    {
        content: '<div class ="label"><span class="left"></span><span class="center">고객센터UGH</span><span class="right"></span></div>',
        latlng: new kakao.maps.LatLng(35.250167, 129.085196)
    },
    {
        content: '<div class ="label"><span class="left"></span><span class="center">UI&UX_KNE</span><span class="right"></span></div>',
        latlng: new kakao.maps.LatLng(35.220219, 129.112771)
    }
];

//마커 생성
for (var i = 0; i < positions.length; i ++) {
    var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: positions[i].latlng, // 마커의 위치
        content: positions[i].content,
        image: markerImage
    });

    marker.setMap(map);
    
    // 마커에 표시할 커스텀 인포윈도우를 생성 
    var customOverlay = new kakao.maps.CustomOverlay({
        position: positions[i].latlng, // 마커의 위치
        content: positions[i].content // 인포윈도우에 표시할 내용
    });
customOverlay.setMap(map, marker);
}
</script>
<!-- 🐧🐧🐧  카카오지도 API 끝 🐧🐧🐧 -->


<!-- 본문 작성하는 곳 -->








<!-- 본문 작성하는 곳 -->

<%@ include file="../include/footer.jsp"%>