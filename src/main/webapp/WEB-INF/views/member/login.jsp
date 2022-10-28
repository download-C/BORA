<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
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
<h1>member/login.jsp </h1>
<div class="login">
	<form action="/member/login" method="post">
	<div><input type="text" name="id" id="id" class="" placeholder="아이디"></div>
	<div><input type="password" name="pw" id="pw" class="" placeholder="비밀번호"></div>
	<div><input type="submit" value="로그인"></div>
	</form>
</div>
<%@ include file="../include/footer.jsp"%>