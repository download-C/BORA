<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<h1>openbank/oauthOK.jsp</h1>

<h2>세션 토큰 : ${sessionScope.token }</h2>
<hr>
<h4>액세스 토큰 : ${responseToken.access_token }</h4>
<h4>사용자 번호 : ${responseToken.user_seq_no }</h4>
<h4>token_type : ${responseToken.token_type }</h4>
<h4>expires_in : ${responseToken.expires_in }</h4>
<h4>refresh_token : ${responseToken.refresh_token }</h4>
<h4>scope : ${responseToken.scope }</h4>
<h4>bank_tran_id : ${AccountTranResponse.bank_tran_id }</h4>

   
	<hr>
	<!-- 사용자정보조회 -->
	<form method="get" action="/openbank/userInfo">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${responseToken.access_token }">
		<input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }">
		<input type="submit" value="사용자정보조회">
	</form><hr>
	
	<h1>💸계좌💸</h1>
	<!-- 2.2.3 등록계좌조회 API -->
	<form method="get" action="/openbank/accountList">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${responseToken.access_token }">
		<input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }">
		<input type="hidden" name="include_cancel_yn" value="Y">
		<input type="hidden" name="sort_order" value="D">
		<input type="submit" value="등록계좌조회">
	</form><hr>    


	<!-- 등록계좌 해지 -->
	<form method="post" action="/openbank/accountCancel">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${responseToken.access_token }">
		<input type="hidden" name="bank_tran_id" value="Y">
		<input type="hidden" name="scope" value="Y">
		<input type="hidden" name="fintech_use_num" value="Y">
		<input type="submit" value="등록계좌해지">
	</form><hr>    
    
    
	<!-- 잔액조회  -->
	<form method="get" action="/openbank/accountBalance">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${responseToken.access_token }">
		<input type="hidden" name="bank_tran_id" value="${accountTranResponse.bank_tran_id }">
		<input type="hidden" name="fintech_use_num" value="Y">
		<input type="hidden" name="tran_dtime" value="Y">
		<input type="submit" value="계좌잔액조회">
	</form><hr>    
     
     
	<!-- 거래내역조회 -->
	<form method="get" action="/openbank/accountTran">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${responseToken.access_token }">
		<input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }">
		<input type="hidden" name="bank_tran_id" value="${AccountTranResponse.bank_tran_id }">
		<input type="hidden" name="fintech_use_num" value="D">
		<input type="hidden" name="inquiry_type" value="Y">
		<input type="hidden" name="inquiry_base" value="D">
		<input type="hidden" name="from_date" value="D">
		<input type="hidden" name="to_date" value="D">
		<input type="hidden" name="sort_order" value="D">
		<input type="hidden" name="tran_dtime" value="D">
		<input type="submit" value="거래내역조회">
	</form><hr>    
     
     
	<!-- 출금이체 -->
	<form method="post" action="/openbank/tranWithdraw">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${responseToken.access_token }">
		<input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }">
		<input type="hidden" name="include_cancel_yn" value="Y">
		<input type="hidden" name="sort_order" value="D">
		<input type="submit" value="출금이체">
	</form><hr>    
	
	<!-- 입금이체 -->
	<form method="post" action="/openbank/tranDeposit">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${responseToken.access_token }">
		<input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }">
		<input type="hidden" name="include_cancel_yn" value="Y">
		<input type="hidden" name="sort_order" value="D">
		<input type="submit" value="입금이체">
	</form><hr>   
	
	<!-- 이체내역조회 -->
	<form method="post" action="/openbank/tranResult">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${responseToken.access_token }">
		<input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }">
		<input type="hidden" name="include_cancel_yn" value="Y">
		<input type="hidden" name="sort_order" value="D">
		<input type="submit" value="이체내역조회">
	</form><hr>   
	
	
	<h1>💳카드💳<h1>
	
	<hr>
     <form method="post" action="/openbank/card/registCard">
        <%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${responseToken.access_token }">
		<input type="hidden" name="member_bank_code" value="D">
		<input type="hidden" name="Info_prvd_agmt_yn" value="V">
		<input type="submit" value="카드등록">
     </form>
     
     <hr>
     <form method="get" action="/openbank/card/cardList">
        <%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${responseToken.access_token }">
		<input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }">
		<input type="hidden" name="member_bank_code" value="D">
		<input type="hidden" name="befor_inquiry_trace_info" value="V">
		<input type="submit" value="카드목록">
     </form><hr>
     
     
<%@ include file="../include/footer.jsp"%>