<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
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
<h1>/member/password.jsp</h1>

<form action="/member/password" method="post">
<div>
<input type="password" placeholder="비밀번호를 입력하세요" name="pw">
</div>
<div> 
<button>확인</button>
</div>
</form>
<%@ include file="../include/footer.jsp"%>