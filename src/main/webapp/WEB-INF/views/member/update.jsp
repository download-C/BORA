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
<h1>member/update.jsp </h1>
	<div class="updateMember">
		<div>
			<div><input type="password" value="${vo.password }"></div>
			<div><input type="text" value="${vo.                }"></div>
		</div>
		
	</div>
<%@ include file="../include/footer.jsp"%>