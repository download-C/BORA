<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BORA</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>
<%
if(session!=null) {
String loginID = (String)session.getAttribute("loginID");
%>
</head>
<body>

<nav>
	<ul>
	<%
	if(loginID != null){
	%>
		<li><a href="/member/logout">로그아웃</a></li>
		<li><a href="/member/mypage">마이페이지</a></li>
		<li><a href="#"></a></li>
	<%
	} else {
	%>
		<li><a href="/member/login">로그인</a></li>
		<li><a href="/member/join">회원가입</a></li>
		<li><a href="#"></a></li>
	<%
	}

	%>
	</ul>
</nav>

<h3>header.jsp</h3>