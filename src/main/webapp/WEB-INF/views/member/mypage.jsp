<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>

 <!-- Template Main CSS File -->
  <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
  <link id="pagestyle" href="${pageContext.request.contextPath}/resources/css/soft-ui-dashboard.css?v=1.0.6" rel="stylesheet" />
  
  
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
<h1> 마이페이지 </h1>
	<div class="mypage">
		<div><label>이름</label>  <input type="text" value="${vo.name }" readonly="readonly"></div>
		<div><label>닉네임</label>  <input type="text" value="${vo.nick }" readonly="readonly"></div>
		<div><label>연락처</label>  <input type="text" value="${vo.phone }" readonly="readonly"></div>
		<div><label>이메일</label>  <input type="text" value="${vo.email}" readonly="readonly"></div>
		<div>
		<input type="button" value="수정하기" onclick="location.href='/member/update';">
		</div>
		<div><a href="/member/delete">탈퇴하기</a></div>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>
