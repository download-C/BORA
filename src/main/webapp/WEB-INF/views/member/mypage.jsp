<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->

<%
if(loginID==null) {%>
<script>
	alert("세션값이 만료되어 로그인 페이지로 이동합니다.");
	location.href="/member/login";
</script>
<%} %>


<script>
$(document).ready(function() {
    let message = "${msg}";
    if (message != "") {
        alert(message);
    }
})
</script>


<div class="container">
<h1> member/mypage.jsp</h1>
	<div class="mypage">
		<div><label>아이디</label> <input type="text" value="${vo.id }" readonly="readonly"></div> 
		<div><label>비밀번호</label>  <input type="password" value="" readonly="readonly"></div> 
		<div><label>이름</label>  <input type="text" value="${vo.name }" readonly="readonly"></div>
		<div><label>닉네임</label>  <input type="text" value="${vo.nick }" readonly="readonly"></div>
		<div><label>연락처</label>  <input type="text" value="${vo.phone }" readonly="readonly"></div>
		<div><label>이메일</label>  <input type="text" value="${vo.email}" readonly="readonly"></div>
		<div>
		<input type="button" value="수정하기" onclick="location.href='/member/password';">
		</div>
		<div><a href="/member/delete">탈퇴하기</a></div>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>
