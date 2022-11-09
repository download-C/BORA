<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<%
	if (loginID == null) {
%>
<script>
	alert("세션값이 만료되어 로그인 페이지로 이동합니다.");
	location.href = "/member/login";
</script>
<%
	}
%>

<div class="container">
<h1>bank_main.jsp</h1>
<h3>인증완료</h3>
<h2>액세스 토큰 : ${cardResponseToken.access_token }</h2>
<h2>사용자 번호 : ${cardResponseToken.user_seq_no }</h2>
<h2>token_type : ${cardResponseToken.token_type }</h2>
<h2>expires_in : ${cardResponseToken.expires_in }</h2>
<h2>refresh_token : ${cardResponseToken.refresh_token }</h2>
<h2>scope : ${cardResponseToken.scope }</h2>
     
    <hr>
	<form method="get" action="/card/userInfo">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${cardResponseToken.access_token }">
		<input type="hidden" name="user_seq_no" value="${cardResponseToken.user_seq_no }">
		<input type="submit" value="사용자정보조회">
	</form>
	
     
     <hr>
     
     <form method="get" action="/card/cardList">
        <%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${cardResponseToken.access_token }">
		<input type="hidden" name="bank_tran_id" value="M202202056U000000001">
		<input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }">
		<input type="hidden" name="bank_code_std" value="399">
		<input type="hidden" name="member_bank_code" value="399">
		<input type="hidden" name="befor_inquiry_trace_info" value="V">
		<input type="submit" value="카드목록">
     </form>
</div>
     
<%@ include file="../include/footer.jsp"%>


