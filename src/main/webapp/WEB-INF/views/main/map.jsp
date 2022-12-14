<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<h1> </h1>


<!-- π§π§π§  μΉ΄μΉ΄μ€μ§λ API μμ π§π§π§ -->
<style>
.label {
/* μ΄λ¦ν μμΉ */
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
}S
</style>
<div class="container">

<!-- μ§λ ν¬κΈ° μ‘°μ  -->
<div id="map" style="width:100%;height:250px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=35509f6b1a38859c7c7486bf14f0ae5c"></script>
<p id="result"></p>

</div>
<script>
var mapContainer = document.getElementById('map'), // μ§λλ₯Ό νμν  div  
    mapOption = { 
    center: new kakao.maps.LatLng(35.214902, 129.124643), // μ§λμ μ€μ¬μ’ν
    level: 8 // μ§λμ νλ λ λ²¨
};
var imageSrc = "${pageContext.request.contextPath}/resources/img/marker.png",   
imageSize = new kakao.maps.Size(40, 40), // λ§μ»€μ΄λ―Έμ§μ ν¬κΈ°
imageOption = {offset: new kakao.maps.Point(30, 55)}; // λ§μ»€μ΄λ―Έμ§μ μ΅μ, λ§μ»€μ μ’νμ μΌμΉμν¬ μ΄λ―Έμ§ μμμμ μ’νλ₯Ό μ€μ 
var map = new kakao.maps.Map(mapContainer, mapOption); // μ§λ μμ±
//μ§λνμ μ»¨νΈλ‘€λ¬ μμ± λ° μΆκ°
var mapTypeControl = new kakao.maps.MapTypeControl();
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
//μ€ μ»¨νΈλ‘€λ¬ μμ± λ° μΆκ°
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
//λ§μ»€μ μ΄λ―Έμ§μ λ³΄λ₯Ό κ°μ§κ³  μλ λ§μ»€μ΄λ―Έμ§λ₯Ό μμ±
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption)
// λ§μ»€λ₯Ό νμν  μμΉμ λ΄μ©μ κ°μ§κ³  μλ κ°μ²΄ λ°°μ΄ 
var positions = [
    {
        content: '<div class ="label"><span class="left"></span><span class="center">κ°κ³λΆCDU</span><span class="right"></span></div>',
        latlng: new kakao.maps.LatLng(35.222516, 129.158446)
    },
    {
        content: '<div class ="label"><span class="left"></span><span class="center">μ€νλ±νΉKHJ</span><span class="right"></span></div>',
        latlng: new kakao.maps.LatLng(35.213763, 129.089177)
    },
    {
        content: '<div class ="label"><span class="left"></span><span class="center">μ€νλ±νΉLEJ</span><span class="right"></span></div>',
        latlng: new kakao.maps.LatLng(35.18980, 129.069979)
    },
    {
        content: '<div class ="label"><span class="left"></span><span class="center">λ¦¬ν¬νΈLDS</span><span class="right"></span></div>',
        latlng: new kakao.maps.LatLng(35.197195, 129.047740)
    },
    {
        content: '<div class ="label"><span class="left"></span><span class="center">λ¦¬ν¬νΈJHW</span><span class="right"></span></div>',
        latlng: new kakao.maps.LatLng(35.202118, 129.121884)
    },
    {
        content: '<div class ="label"><span class="left"></span><span class="center">κ³ κ°μΌν°UGH</span><span class="right"></span></div>',
        latlng: new kakao.maps.LatLng(35.230167, 129.025196)
    },
    {
        content: '<div class ="label"><span class="left"></span><span class="center">UI&UX_KNE</span><span class="right"></span></div>',
        latlng: new kakao.maps.LatLng(35.220219, 129.242771)
    }
];
//λ§μ»€ μμ±
for (var i = 0; i < positions.length; i ++) {
    var marker = new kakao.maps.Marker({
        map: map, // λ§μ»€λ₯Ό νμν  μ§λ
        position: positions[i].latlng, // λ§μ»€μ μμΉ
        content: positions[i].content,
        image: markerImage
    });
    marker.setMap(map);
    
    // λ§μ»€μ νμν  μ»€μ€ν μΈν¬μλμ°λ₯Ό μμ± 
    var customOverlay = new kakao.maps.CustomOverlay({
        position: positions[i].latlng, // λ§μ»€μ μμΉ
        content: positions[i].content // μΈν¬μλμ°μ νμν  λ΄μ©
    });
customOverlay.setMap(map, marker);
}
</script>
<!-- π§π§π§  μΉ΄μΉ΄μ€μ§λ API λ π§π§π§ -->


