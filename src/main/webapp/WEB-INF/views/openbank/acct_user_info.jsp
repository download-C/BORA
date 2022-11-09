<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>


	<h1>사용자 정보조회 결과</h1>
	<h3>고객번호 : ${userInfo.user_seq_no }</h3>
<%-- 	<h3>고객CI값 : ${userInfo.user_ci }</h3> --%>
	<h3>고객이름 : ${userInfo.user_name }</h3>
	<h3>고객등록계좌수 : ${userInfo.res_cnt }</h3> 
<%-- 	<h3>고객생년월일 : ${userInfo.user_info }</h3> 필요없음 --%>
<%-- 	<h3>고객성별 : ${userInfo.user_gender }</h3> 필요없음 --%>
<%-- 	<h3>고객휴대폰번호 : ${userInfo.user_cell_no }</h3> 필요없음 --%>
<%-- 	<h3>고객이메일주소 : ${userInfo.user_email }</h3> 필요없음 --%>

	<hr>
	
	
	
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


	<!-- 잔액조회1 BORA입출금 -->
	거래일시, 거래일자(참가은행), 은행이름, 계좌잔액(-금액가능), 
	출금가능금액, 상품명, 계좌개설일, 만기일, 최종거래일
	<form method="get" action="/openbank/accountBalance">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${sessionScope.token }">
<%-- 		<input type="hidden" name="access_token" value="${responseToken.access_token }"> --%>
		<input type="hidden" name="bank_tran_id" value="${accountBalance.bank_tran_id }">
		<input type="hidden" name="fintech_use_num" value="120220217888941294172171">
		<input type="hidden" name="tran_dtime" value="20221104134521">
		<input type="submit" value="BORA입출금 계좌잔액조회">
	</form><hr>    

	<!-- 잔액조회2 123통장 -->
	거래일시, 거래일자(참가은행), 은행이름, 계좌잔액(-금액가능), 
	출금가능금액, 상품명, 계좌개설일, 만기일, 최종거래일
	<form method="get" action="/openbank/accountBalance">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${sessionScope.token }">
<%-- 		<input type="hidden" name="access_token" value="${responseToken.access_token }"> --%>
		<input type="hidden" name="bank_tran_id" value="${accountBalance.bank_tran_id }">
		<input type="hidden" name="fintech_use_num" value="120220217888941294186856">
		<input type="hidden" name="tran_dtime" value="20221104134521">
		<input type="submit" value="123통장 계좌잔액조회">
	</form><hr>    
     
     
	<!-- 거래내역조회1 BORA입출금 -->
	거래일자, 입출금구분, 거래유형, 거래금액. 거래후잔액
	<form method="get" action="/openbank/accountTran">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${sessionScope.token }">
<%-- 		<input type="hidden" name="access_token" value="${responseToken.access_token }"> --%>
		<input type="hidden" name="bank_tran_id" value="${accountTran.bank_tran_id}">
		<input type="hidden" name="fintech_use_num" value="120220217888941294172171">
		<input type="hidden" name="inquiry_type" value='A'>
		<input type="hidden" name="inquiry_base" value='D'>
		<input type="hidden" name="from_date" value="20100101">
		<input type="hidden" name="to_date" value="20221104">
		<input type="hidden" name="sort_order" value="D">
		<input type="hidden" name="tran_dtime" value="20221104134521">
		<input type="submit" value="BORA입출금 거래내역조회">
	</form><hr>    
     
		<!-- 거래내역조회2 123통장 -->
	거래일자, 입출금구분, 거래유형, 거래금액. 거래후잔액
	<form method="get" action="/openbank/accountTran">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${sessionScope.token }">
<%-- 		<input type="hidden" name="access_token" value="${responseToken.access_token }"> --%>
		<input type="hidden" name="bank_tran_id" value="${accountTran.bank_tran_id}">
		<input type="hidden" name="fintech_use_num" value="120220217888941294186856">
		<input type="hidden" name="inquiry_type" value='A'>
		<input type="hidden" name="inquiry_base" value='D'>
		<input type="hidden" name="from_date" value="20100101">
		<input type="hidden" name="to_date" value="20221104">
		<input type="hidden" name="sort_order" value="D">
		<input type="hidden" name="tran_dtime" value="20221104134521">
		<input type="submit" value="123통장 거래내역조회">
	</form><hr>    
	
</div>


<%@ include file="../include/footer.jsp"%>
