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
<%
if(session!=null) {
	String loginID = (String)session.getAttribute("loginID");
%>
</head>
<body>

<!-- ======= Top Bar ======= -->
  <section id="topbar" class="d-flex align-items-center">
    <div class="container d-flex justify-content-center justify-content-md-between">
      <div class="contact-info d-flex align-items-center">
      </div>
      <div class="social-links nav justify-content-end">
    <%
	    if(loginID != null){
    %>
    		<a href="/member/mypage"  class="twitter">마이페이지</a>
        <a href="/member/logout" class="twitter">로그아웃</a>
    <%
      	} else {
    %>
        <a href="/main/login" class="twitter">로그인</a>
        <a href="/main/join" class="facebook">회원가입</a>
    <%
      	}
    %>
      </div>
    </div>
  </section>

  <!-- ======= Header ======= -->
  <header id="header" class="d-flex align-items-center">
    <div class="container d-flex align-items-center justify-content-between">

      <h1 class="logo"><a href="/main/main">BORA<span></span></a></h1>
      <!-- Uncomment below if you prefer to use an image logo -->
      <!-- <a href="index.html" class="logo"><img src="${pageContext.request.contextPath}/resources/img/logo.png" alt=""></a>-->
		
			<%	
			  Calendar cal = Calendar.getInstance();
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH)+1;
				int day = cal.get(Calendar.DATE);
			%>
		
      <nav id="navbar" class="navbar">
        <ul>
          <li><a class="nav-link scrollto" href="/book/list?year=<%=year%>&month=<%=month%>">가계부(나중에 리포트로 합칠 예정)</a></li>
          <li><a class="nav-link scrollto" href="/main/about">About</a></li>
          <li><a class="nav-link scrollto" href="/main/noticeList?page=1">공지사항</a></li>
          <li><a class="nav-link scrollto" href="/board/list?page=1">커뮤니티</a></li>
          <li><a class="nav-link scrollto" href="/report/report?year=<%=year%>&month=<%=month%>">리포트</a></li>
          <li><a class="nav-link scrollto " href="/openbank/oauth">오픈뱅킹</a></li>
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->

    </div>
  </header><!-- End Header -->