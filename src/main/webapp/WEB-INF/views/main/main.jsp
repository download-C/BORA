<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<h1> main.jsp</h1>

<%@ include file="../include/footer.jsp"%>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
$(document).ready(function() {
    let message = "${msg}";
    if (message != "") {
        alert(message);
    }else {
    }
})
</script>


<!-- @@@@@@@@@@@@@@@@@@@@@@@지도 테스트 1 @@@@@@@@@@@@@@@@@@@@@@@-->
<div id="map" style="width:800px;height:450px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=35509f6b1a38859c7c7486bf14f0ae5c"></script>

<!-- /////result///// -->
<p id="result"></p>
<!-- /////result///// -->

<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
    mapOption = { 
    center: new kakao.maps.LatLng(35.214902, 129.094643), // 지도의 중심좌표
    level: 8 // 지도의 확대 레벨
};

var imageSrc = '../img/marker.png', // 마커이미지의 주소입니다    
imageSize = new kakao.maps.Size(40, 40), // 마커이미지의 크기입니다
imageOption = {offset: new kakao.maps.Point(30, 55)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다
var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다


//마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption)



// 마커를 표시할 위치와 내용을 가지고 있는 객체 배열입니다 
var positions = [
    {
        content: '<div>회원관리</div>', 
        latlng: new kakao.maps.LatLng(35.172516, 129.108446)
    },
    {
        content: '<div>자산관리1팀</div>', 
        latlng: new kakao.maps.LatLng(35.223563, 129.095177)
    },
    {
        content: '<div>자산관리2팀</div>', 
        latlng: new kakao.maps.LatLng(35.538437, 129.300674)
    },
    {
        content: '<div>리포트1팀</div>',
        latlng: new kakao.maps.LatLng(35.152195, 129.087740)
    },
    {
        content: '<div>리포트2팀</div>',
        latlng: new kakao.maps.LatLng(35.202118, 129.121884)
    },
    {
        content: '<div>고객센터팀</div>',
        latlng: new kakao.maps.LatLng(35.260167, 129.085196)
    },
    {
        content: '<div>UI팀</div>',
        latlng: new kakao.maps.LatLng(35.221219, 129.105571)
    }
];


for (var i = 0; i < positions.length; i ++) {
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: positions[i].latlng, // 마커의 위치
        image: markerImage
    });

    marker.setMap(map);


    
//     // 마커에 표시할 인포윈도우를 생성합니다 
//     var infowindow = new kakao.maps.InfoWindow({
//         content: positions[i].content // 인포윈도우에 표시할 내용
//     });

//     // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
//     // 이벤트 리스너로는 클로저를 만들어 등록합니다 
//     // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
//     kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
//     kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));


}

// // 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
// function makeOverListener(map, marker, infowindow) {
//     return function() {
//         infowindow.open(map, marker);
//     };
// }

// // 인포윈도우를 닫는 클로저를 만드는 함수입니다 
// function makeOutListener(infowindow) {
//     return function() {
//         infowindow.close();
//     };
// }



</script>

<!-- @@@@@@@@@@@@@@@@@@@@@@@지도 테스트 2 @@@@@@@@@@@@@@@@@@@@@@@-->




<div id="staticMap" style="width:600px;height:450px;"></div>    
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=35509f6b1a38859c7c7486bf14f0ae5c"></script>

<script>    
// 이미지 지도에 표시할 마커입니다
// 이미지 지도에 표시할 마커를 아래와 같이 배열로 넣어주면 여러개의 마커를 표시할 수 있습니다 
var markers = [
    {
        position: new kakao.maps.LatLng(35.172516, 129.108446),
        text: 'BORA회원관리' 
    },
    {
        position: new kakao.maps.LatLng(35.223563, 129.095177), 
        text: 'BORA자산관리1' 
    },
    {
        position: new kakao.maps.LatLng(35.538437, 129.300674),
        text: 'BORA자산관리2' 
    },
    {
        position: new kakao.maps.LatLng(35.152195, 129.087740),
        text: 'BORA리포트1' 
    },
    {
        position: new kakao.maps.LatLng(35.202118, 129.121884),
        text: 'BORA리포트2' 
    },
    {
        position: new kakao.maps.LatLng(35.260167, 129.085196),
        text: 'BORA고객센터' 
    },
    {
        position: new kakao.maps.LatLng(35.221219, 129.105571),
        text: 'BORA_UI' 
    },
    
    
];

var staticMapContainer  = document.getElementById('staticMap'), // 이미지 지도를 표시할 div  
    staticMapOption = { 
        center: new kakao.maps.LatLng(35.214902, 129.094643), // 이미지 지도의 중심좌표
        level: 8, // 이미지 지도의 확대 레벨
        marker: markers // 이미지 지도에 표시할 마커 
    };    

// 이미지 지도를 생성합니다
var staticMap = new kakao.maps.StaticMap(staticMapContainer, staticMapOption);


var imageSrc = '../img/marker.png', // 마커이미지의 주소입니다    
imageSize = new kakao.maps.Size(40, 40), // 마커이미지의 크기입니다
imageOption = {offset: new kakao.maps.Point(30, 55)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다
var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다


//마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption)



// var imageSrc = 'marker.jpg', // 마커이미지의 주소입니다    
// imageSize = new kakao.maps.Size(40, 40), // 마커이미지의 크기입니다
// imageOption = {offset: new kakao.maps.Point(30, 55)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다
// var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다


// //마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
// var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption)





</script>

