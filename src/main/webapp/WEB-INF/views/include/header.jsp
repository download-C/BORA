<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}
</style>
<title>BORA</title>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>BizLand Bootstrap Template - Index</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="${pageContext.request.contextPath}/resources/img/favicon.png" rel="icon">
  <link href="${pageContext.request.contextPath}/resources/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Roboto:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="${pageContext.request.contextPath}/resources/vendor/aos/aos.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <%--   <link href="${pageContext.request.contextPath}/resources/vendor/swiper/swiper-bundle.min.css" rel="stylesheet"> --%>


  <!-- Template Main CSS File -->
  <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">

  <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <!-- alert 대신 사용할 모달 버튼 script 소스 (필수) -->
  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>	
  <script src="https://cdn.jsdelivr.net/npm/promise-polyfill@7.1.0/dist/promise.min.js"></script>
  
  
<%
if(session!=null) {
	String loginID = (String)session.getAttribute("loginID");
	System.out.println(loginID);
	if(loginID!=null){ %>
	<script>
	// 채널톡 챗봇
	  (function() {
	    var w = window;
	    if (w.ChannelIO) {
	      return (window.console.error || window.console.log || function(){})('ChannelIO script included twice.');
	    }
	    var ch = function() {
	      ch.c(arguments);
	    };
	    ch.q = [];
	    ch.c = function(args) {
	      ch.q.push(args);
	    };
	    w.ChannelIO = ch;
	    function l() {
	      if (w.ChannelIOInitialized) {
	        return;
	      }
	      w.ChannelIOInitialized = true;
	      var s = document.createElement('script');
	      s.type = 'text/javascript';
	      s.async = true;
	      s.src = 'https://cdn.channel.io/plugin/ch-plugin-web.js';
	      s.charset = 'UTF-8';
	      var x = document.getElementsByTagName('script')[0];
	      x.parentNode.insertBefore(s, x);
	    }
	    
	    if (document.readyState === 'complete') {
	      l();
	    } else if (window.attachEvent) {
	      window.attachEvent('onload', l);
	    } else {
	      window.addEventListener('DOMContentLoaded', l, false);
	      window.addEventListener('load', l, false);
	    }
	    
	  })();
	  
	  ChannelIO('boot', {
	    "pluginKey": "036d1555-e40f-407f-aa20-80436bd75264", //please fill with your plugin key
	    "memberId": "4717f1cc2d57b03f0b5a93e42ba4d43e", //fill with user id
	    "profile": {
	      "name": "", //fill with user name
	      "mobileNumber": "", //fill with user phone number
	      "email": "", //any other custom meta data
	      "CUSTOM_VALUE_2": "VALUE_2"
	    }
	  });
	</script>
<%  } %>
</head>
<body>



<!-- ======= Top Bar ======= -->
  <section id="topbar" class="d-flex align-items-center">
    <div class="container d-flex justify-content-center justify-content-md-between">
      <div class="contact-info d-flex align-items-center">
      </div>
      <div class="social-links nav justify-content-end">
    <%if(loginID != null){%>
    		<a>♡${nick }님♡</a> 
    		<a href="/member/mypage"  class="twitter">마이페이지</a>
        <a href="/member/logout" class="twitter">로그아웃</a>
    <%} else {%>
        <a href="/main/login" class="twitter">로그인</a>
        <a href="/main/join" class="facebook">회원가입</a>
    <%}%>
      </div>
    </div>
  </section>

  <!-- ======= Header ======= -->
  <header id="header" class="d-flex align-items-center">
    <div class="container d-flex align-items-center justify-content-between">
      <h1 class="logo"><a href="/main/main">BORA<span></span></a></h1>
      <!-- <a href="index.html" class="logo"><img src="${pageContext.request.contextPath}/resources/img/logo.png" alt=""></a>-->
			<%	
			  Calendar cal = Calendar.getInstance();
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH)+1;
				int day = cal.get(Calendar.DATE);
			%>
      <nav id="navbar" class="navbar">
        <ul>
          <li><a class="nav-link scrollto" href="/main/about">About</a></li>
          <li><a class="nav-link scrollto" href="/main/noticeList?page=1">공지사항</a></li>
          <li><a class="nav-link scrollto" href="/board/list?page=1">커뮤니티</a></li>
          <li><a class="nav-link scrollto" href="/report/categoryList?year=<%=year%>&month=<%=month%>&day=<%=day%>">리포트</a></li>
          <li><a class="nav-link scrollto" href="/book/list?year=<%=year%>&month=<%=month %>&day=<%=day%>">가계부</a>
          <li><a class="nav-link scrollto " href="/openbank/oauthOK">오픈뱅킹</a></li>
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->
    </div>
  </header><!-- End Header -->