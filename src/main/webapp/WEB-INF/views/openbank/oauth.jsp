<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>



<h1>인증 요청 작업</h1>

	<!-- 인증 요청 작업 수행 -->
	<form action="https://testapi.openbanking.or.kr/oauth/2.0/authorize" method="get">
		<input type="hidden" name="response_type" value="code"> 
		<input type="hidden" name="client_id" value="2ce89526-eccf-45b0-a59f-1ca10bc64b30"> 
		<input type="hidden" name="redirect_uri" value="http://localhost:8088/openbank/callback"> 
		<input type="hidden" name="scope" value="login inquiry transfer"> 
		<input type="hidden" name="state" value="12345678123456781234567812345678">
		<input type="hidden" name="auth_type" value="0"> 
		<input type="submit" value="오픈뱅킹 사용자 인증">
	</form>


<%@ include file="../include/footer.jsp"%>
