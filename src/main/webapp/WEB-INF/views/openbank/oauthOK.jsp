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

<h1>openbank/oauthOK.jsp</h1>

<h2>세션 토큰 : ${sessionScope.token }</h2>
<hr>
<h4>액세스 토큰 : ${responseToken.access_token }</h4>
<h4>사용자 번호 : ${responseToken.user_seq_no }</h4>
<h4>token_type : ${responseToken.token_type }</h4>
<h4>expires_in : ${responseToken.expires_in }</h4>
<h4>refresh_token : ${responseToken.refresh_token }</h4>
<h4>scope : ${responseToken.scope }</h4>

   
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
	
	
	<h1>💸계좌💸</h1>
	<!-- 2.2.3 등록계좌조회 API -->
	마스킹된 출력용 계좌번호, 은행명, 계좌구분(분류코드), 계좌종류(분류코드),	예금주명
	<form method="get" action="/openbank/accountList">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${sessionScope.token }">
<%-- 		<input type="hidden" name="access_token" value="${responseToken.access_token }"> --%>
		<input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }">
		<input type="hidden" name="include_cancel_yn" value="Y">
		<input type="hidden" name="sort_order" value="D">
		<input type="submit" value="등록계좌조회">
	</form><hr>    


	<!-- 잔액조회  -->
	거래일시, 거래일자(참가은행), 은행이름, 계좌잔액(-금액가능), 
	출금가능금액, 상품명, 계좌개설일, 만기일, 최종거래일
	<form method="get" action="/openbank/accountBalance">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${sessionScope.token }">
<%-- 		<input type="hidden" name="access_token" value="${responseToken.access_token }"> --%>
		<input type="hidden" name="bank_tran_id" value="${accountBalance.bank_tran_id }">
		<input type="hidden" name="fintech_use_num" value="120220209288941286327192">
		<input type="hidden" name="tran_dtime" value="20221104134521">
		<input type="submit" value="계좌잔액조회">
	</form><hr>    
     
     
	<!-- 거래내역조회 -->
	거래일자, 입출금구분, 거래유형, 거래금액. 거래후잔액
	<form method="get" action="/openbank/accountTran">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${sessionScope.token }">
<%-- 		<input type="hidden" name="access_token" value="${responseToken.access_token }"> --%>
		<input type="hidden" name="bank_tran_id" value="${accountTran.bank_tran_id}">
		<input type="hidden" name="fintech_use_num" value="120220209288941286327192">
		<input type="hidden" name="inquiry_type" value='A'>
		<input type="hidden" name="inquiry_base" value='D'>
		<input type="hidden" name="from_date" value="20100101">
		<input type="hidden" name="to_date" value="20221104">
		<input type="hidden" name="sort_order" value="D">
		<input type="hidden" name="tran_dtime" value="20221104134521">
		<input type="submit" value="거래내역조회">
	</form><hr>    
     
	
</div>

     
<%@ include file="../include/footer.jsp"%>