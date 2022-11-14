<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

  <link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">

<!-- title -->
<div class="section-title">
  <h2><b>내 자산 보기</b></h2>
</div>
<!-- End title -->
<br>

  <div class="container">
  	<div class="box" style="display: flex; justify-content: space-between; flex-flow: row nowrap;">
	<div style="border: 3px solid red; width: 50%;"><br>
    <div class="row">
      <div class="col-sm-9 col-md-15 col-lg-5 mx-auto">
        <div class="card border-0 shadow rounded-3 my-5">
          <div class="card-body p-4 p-sm-5" style="background-color:#F5EFFE;">
            <h3 class="card-title text-center mb-5 fw-light fs-5"><b>회원정보수정</b></h3>
            <form>
              <div class="form-floating mb-3">
                <input type="text" class="form-control" id="floatingInput" placeholder="고객번호" readonly>
                <label for="floatingInput">${userInfo.user_seq_no }</label>
              </div>
              <div class="form-floating mb-3">
                <input type="text" class="form-control" id="floatingInput" placeholder="고객이름" readonly>
                <label for="floatingInput">${userInfo.user_name }</label>
              </div>
              <div class="form-floating mb-3">
                <input type="text" class="form-control" id="floatingInput" placeholder="고객등록계좌수" readonly>
                <label for="floatingPassword">${userInfo.res_cnt }</label>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  </div>
  </div>
  
  
  <!-- End login -->
			
		  <div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card border-0 shadow rounded-3 my-5">
          <div class="card-body p-4 p-sm-5" style="background-color:#F5EFFE;">
            <h3 class="card-title text-center mb-5 fw-light fs-5"><b>회원정보수정</b></h3>
            <form>
              <div class="form-floating mb-3">
                <input type="text" class="form-control" id="floatingInput" placeholder="이름" readonly>
                <label for="floatingInput">이름</label>
              </div>
              <div class="form-floating mb-3">
                <input type="text" class="form-control" id="floatingInput" placeholder="아이디" readonly>
                <label for="floatingInput">아이디</label>
              </div>
              <div class="form-floating mb-3">
                <input type="password" class="form-control" id="floatingPassword" placeholder="비밀번호" readonly>
                <label for="floatingPassword">비밀번호</label>
              </div>

            </form>
          </div>
        </div>
      </div>
    </div>
  </div>	
 
			
			
<br><br><br>			



	<form method="get" action="/openbank/accountList">
		<!-- 		필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 -->
		<input type="hidden" name="access_token"
			value="${sessionScope.token }">
		<%-- 		<input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }"> --%>
		<input type="hidden" name="user_seq_no"
			value="${userInfo.user_seq_no }"> <input type="hidden"
			name="include_cancel_yn" value="Y"> <input type="hidden"
			name="sort_order" value="D"> <input type="submit"
			value="오픈뱅킹 등록 전계좌조회">
	</form>
	

	
	<hr><hr><hr>
	여기서부터는 삭제 예정


	<h1>💸계좌💸</h1>
	2.2.3 등록계좌조회 API 마스킹된 출력용 계좌번호, 은행명, 계좌구분(분류코드), 계좌종류(분류코드), 예금주명
	<form method="get" action="/openbank/accountList">
		<!-- 		필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 -->
		<input type="hidden" name="access_token"
			value="${sessionScope.token }">
		<%-- 		<input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }"> --%>
		<input type="hidden" name="user_seq_no"
			value="${userInfo.user_seq_no }"> <input type="hidden"
			name="include_cancel_yn" value="Y"> <input type="hidden"
			name="sort_order" value="D"> <input type="submit"
			value="등록계좌조회">
	</form>
	<hr>


	<!-- 잔액조회1 BORA입출금 -->
	거래일시, 거래일자(참가은행), 은행이름, 계좌잔액(-금액가능), 출금가능금액, 상품명, 계좌개설일, 만기일, 최종거래일
	<form method="get" action="/openbank/accountBalance">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${sessionScope.token }"> 
		<input type="hidden" name="bank_tran_id" value="${accountBalance.bank_tran_id }">
		<input type="hidden" name="fintech_use_num" value="120220217888941294172171"> 
		<input type="hidden" name="tran_dtime" value="20221104134521"> <input
			type="submit" value="BORA입출금 계좌잔액조회">
	</form>
	<hr>

	<!-- 잔액조회2 123통장 -->
	거래일시, 거래일자(참가은행), 은행이름, 계좌잔액(-금액가능), 출금가능금액, 상품명, 계좌개설일, 만기일, 최종거래일
	<form method="get" action="/openbank/accountBalance">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token"
			value="${sessionScope.token }"> <input type="hidden"
			name="bank_tran_id" value="${accountBalance.bank_tran_id }">
		<input type="hidden" name="fintech_use_num"
			value="120220217888941294186856"> <input type="hidden"
			name="tran_dtime" value="20221104134521"> <input
			type="submit" value="123통장 계좌잔액조회">
	</form>
	<hr>


	<!-- 거래내역조회1 BORA입출금 -->
	거래일자, 입출금구분, 거래유형, 거래금액. 거래후잔액
	<form method="get" action="/openbank/accountTran">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token"
			value="${sessionScope.token }"> <input type="hidden"
			name="bank_tran_id" value="${accountTran.bank_tran_id}"> <input
			type="hidden" name="fintech_use_num" value="120220217888941294172171">
		<input type="hidden" name="inquiry_type" value='A'> <input
			type="hidden" name="inquiry_base" value='D'> <input
			type="hidden" name="from_date" value="20100101"> <input
			type="hidden" name="to_date" value="20221104"> <input
			type="hidden" name="sort_order" value="D"> <input
			type="hidden" name="tran_dtime" value="20221104134521"> <input
			type="submit" value="BORA입출금 거래내역조회">
	</form>
	<hr>

	<!-- 거래내역조회2 123통장 -->
	거래일자, 입출금구분, 거래유형, 거래금액. 거래후잔액
	<form method="get" action="/openbank/accountTran">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token"
			value="${sessionScope.token }"> <input type="hidden"
			name="bank_tran_id" value="${accountTran.bank_tran_id}"> <input
			type="hidden" name="fintech_use_num" value="120220217888941294186856">
		<input type="hidden" name="inquiry_type" value='A'> <input
			type="hidden" name="inquiry_base" value='D'> <input
			type="hidden" name="from_date" value="20100101"> <input
			type="hidden" name="to_date" value="20221104"> <input
			type="hidden" name="sort_order" value="D"> <input
			type="hidden" name="tran_dtime" value="20221104134521"> <input
			type="submit" value="123통장 거래내역조회">
	</form>
	<hr>

    <h1>💸카드💸</h1>
    2.2.4 등록카드조회 API
    <!-- 카드목록조회 -->
           카드식별자, 마스킹된 카드번호, 상품명, 본인/가족구분
    <form method="get" action="/openbank/cardList">
        <%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${sessionScope.token }">
		<input type="hidden" name="bank_tran_id" value="${cardList.bank_tran_id }">
			<input type="hidden" name="user_seq_no" value="${userInfo.user_seq_no }">
		<input type="hidden" name="bank_code_std" value="399">
		<input type="hidden" name="member_bank_code" value="399">
        <!-- <input type="hidden" name="befor_inquiry_trace_info" value="V"> -->
		<input type="submit" value="카드목록">
    </form>
     
      <hr>
    
    <!-- 카드기본정보조회 -->
           카드구분, 결제은행대표코드, 마스킹된 출력용 결제계좌번호, 카드발급일자  
    <form action="/openbank/cardInfo" method="post">
		<input type="hidden" name="access_token" value="${sessionScope.token }">
	    <input type="hidden" name="bank_tran_id" value="${cardInfo.bank_tran_id }">
			<input type="hidden" name="user_seq_no" value="${userInfo.user_seq_no }">
		<input type="hidden" name="bank_code_std" value="399">
		<input type="hidden" name="member_bank_code" value="399">
		<input type="hidden" name="card_id" value="9191919112121212">
		<input type="submit" value="카드기본정보조회">
	</form>
	
	 <hr>
	
	<!-- 카드청구기본정보조회 -->
	청구년월, 결제순번, 카드식별자, 청구금액, 결제일, 결제년월일, 신용/체크구분
	<form method="get" action="/openbank/cardBills">
        <%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${sessionScope.token }">
		<input type="hidden" name="bank_tran_id" value="${cardBills.bank_tran_id }">
			<input type="hidden" name="user_seq_no" value="${userInfo.user_seq_no }">
		<input type="hidden" name="bank_code_std" value="399">
		<input type="hidden" name="member_bank_code" value="399">
		<input type="hidden" name="from_month" value="202210">
		<input type="hidden" name="to_month" value="202211">
		<input type="submit" value="카드청구조회">
    </form>
     
      <hr>
     
    <!-- 카드청구상세정보조회 -->
           카드식별값, 사용일자, 사용시간, 이용금액, 가맹점명, 상품구분
    <form method="get" action="/openbank/cardDetailBills">
        <%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${sessionScope.token }">
		<input type="hidden" name="bank_tran_id" value="${cardDetailBills.bank_tran_id }">
			<input type="hidden" name="user_seq_no" value="${userInfo.user_seq_no }">
		<input type="hidden" name="bank_code_std" value="399">
		<input type="hidden" name="member_bank_code" value="399">
		<input type="hidden" name="charge_month" value="202211">
		<input type="hidden" name="settlement_seq_no" value="0001">
		<input type="submit" value="카드상세청구조회">
    </form>
     
    <hr>

<%@ include file="../include/footer.jsp"%>
