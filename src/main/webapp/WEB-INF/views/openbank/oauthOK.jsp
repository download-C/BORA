<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->


<div class="container">

<h1>openbank/oauthOK.jsp</h1>

<%-- <h2>세션 토큰 : ${sessionScope.token }</h2> --%>
<!-- <hr> -->
<%-- <h4>액세스 토큰 : ${responseToken.access_token }</h4> --%>
<%-- <h4>사용자 번호 : ${responseToken.user_seq_no }</h4> --%>
<%-- <h4>token_type : ${responseToken.token_type }</h4> --%>
<%-- <h4>expires_in : ${responseToken.expires_in }</h4> --%>
<%-- <h4>refresh_token : ${responseToken.refresh_token }</h4> --%>
<%-- <h4>scope : ${responseToken.scope }</h4> --%>


※ 화면 예시
	<table border="3">
		<tr>
			<td>① 본인인증</td>
			<td>②</td>
			<td>③</td>
		</tr>
		<tr>
			<td><img src="${pageContext.request.contextPath}/resources/img/token/token1.png" width="150px;"></td>
			<td>사진</td>
			<td>사진</td>
		</tr>
		<tr>
			<td>④</td>
			<td>⑤</td>
			<td>⑥</td>
		</tr>
		<tr>
			<td>사진</td>
			<td>사진</td>
			<td>사진</td>
		</tr>
	</table>




	<hr><hr><hr>


	<!-- 인증 요청 작업 수행 -->
	<form action="https://testapi.openbanking.or.kr/oauth/2.0/authorize" method="get">
		<input type="hidden" name="response_type" value="code"> 
		<input type="hidden" name="client_id" value="2ce89526-eccf-45b0-a59f-1ca10bc64b30"> 
		<input type="hidden" name="redirect_uri" value="http://localhost:8088/openbank/callback"> 
		<input type="hidden" name="scope" value="login inquiry transfer cardinfo fintechinfo">
		<input type="hidden" name="state" value="12345678123456781234567812345678">
		<input type="hidden" name="auth_type" value="0"> 
		<input type="submit" value="오픈뱅킹 사용자 인증"> (보유계좌정보 입력)
	</form>
   
   
	<hr>
	<h1>😉사용자정보조회😉</h1>
	<!-- 사용자정보조회 -->
	고객번호, 고객이름, 고객등록계좌수
	<form method="get" action="/openbank/userInfo">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${sessionScope.token }">
		<input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }">
		<input type="submit" value="사용자정보조회">
	</form><hr>
	
	
	
</div>

     
<%@ include file="../include/footer.jsp"%>