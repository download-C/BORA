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


<style type="text/css">
   div{
       width : 100%;
       height : 100%;
       margin : 0;
       padding : 0;
       border : none;  
       overflow : auto;                    
   }    
</style> 

   <style>
    .tbtn {
      background-color: #5107B0;
      float: center;
/*       width: 330px; */
/*       height: 70px; */
      margin :30px;  
      padding: 20px 50px 20px 50px;
      border: 1px solid #fff;
      border-radius: 8px;
      color: white; 
/*       color: #e3cffc; */
      border-radius: 13px;
      font-size: 20px;
    }
    
    .floatingInput {
    	color: red;
    }
    	
  </style>
  

  <div class="container">
  	<div class="box" style="display: flex; justify-content: space-between; flex-flow: row nowrap;">
<!--   	<div class="box" style="display: flex; justify-content: space-between; flex-flow: row nowrap;"> -->
	
<!--     <div class="row"> -->
      <div class="col-sm-9 col-md-7 col-lg-70 mx-auto">
<!--       <div class="col-sm-9 col-md-7 col-lg-65" > -->
<!--       <div class="col-sm-9 col-md-7 col-lg-5 mx-auto"> -->
        <div class="card border-0 shadow rounded-3 my-5">
          <div class="card-body p-3 p-sm-5" style="background-color:#F5EFFE;">
            <h1 class="card-title text-center mb-5 fw-light fs-13"><b>사용자 인증 결과</b></h1>
            <form>
                <label for="floatingInput">사용자 번호</label>
              <div class="form-floating mb-3">
              	<span class="form-control" id="floatingInput">${userInfo.user_seq_no }</span>
              </div>
                <label for="floatingInput">사용자 이름</label>
              <div class="form-floating mb-3">
              	<span class="form-control" id="floatingInput">${userInfo.user_name }</span>
              </div>
                <label for="floatingInput">등록 계좌수</label>
              <div class="form-floating mb-3">
              	<span class="form-control" id="floatingInput">${userInfo.res_cnt }</span>
              </div>
            </form>
    </div>
    </div>
<!--     	<div class="box" style="display: flex; justify-content: space-between; flex-flow: row nowrap;"> -->
    	<div class="col-sm-19 col-md-17 col-lg-80 mx-auto" style="display: flex; justify-content: space-between;">
  		<form method="get" action="/openbank/accountList">
			<!-- 		필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 -->
			<input type="hidden" name="access_token" value="${sessionScope.token }">
			<%-- 		<input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }"> --%>
			<input type="hidden" name="user_seq_no" value="${userInfo.user_seq_no }"> 
			<input type="hidden" name="include_cancel_yn" value="Y"> 
			<input type="hidden" name="sort_order" value="D"> 
			<button type="submit" class="tbtn"><b style="color:#e3cffc;">내 보유 계좌&nbsp;</b>보러 가기</button>
		</form>
	
<!-- 은재	카드로 바꾸기 -->
			<form method="get" action="/openbank/cardList">
			<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		    <input type="hidden" name="access_token" value="${sessionScope.token }">
		    <input type="hidden" name="bank_tran_id" value="${cardList.bank_tran_id }">
			<input type="hidden" name="user_seq_no" value="${userInfo.user_seq_no }">
		    <input type="hidden" name="bank_code_std" value="399">
		    <input type="hidden" name="member_bank_code" value="399">
        <!-- <input type="hidden" name="befor_inquiry_trace_info" value="V"> -->
			<button type="submit" class="tbtn"><b style="color:#e3cffc;">내 보유 카드&nbsp;</b>보러 가기</button>
		</form>
<!-- 은재	카드로 바꾸기 -->
	</div>
  </div>
  </div>
  </div>
  
			
<br><br><br>			


	
	<hr><hr><hr>
	여기서부터는 삭제 예정


	<!-- 잔액조회1 BORA입출금 -->
	거래일시, 거래일자(참가은행), 은행이름, 계좌잔액(-금액가능), 출금가능금액, 상품명, 계좌개설일, 만기일, 최종거래일
	<form method="get" action="/openbank/accountBalance">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${sessionScope.token }"> 
		<input type="hidden" name="bank_tran_id" value="${accountBalance.bank_tran_id }">
		<input type="hidden" name="fintech_use_num" value="120220217888941294172171"> 
		<input type="hidden" name="tran_dtime" value="20221104134521"> 
		<input type="submit" value="BORA입출금 계좌잔액조회">
	</form>
	<hr>

	<!-- 잔액조회2 123통장 -->
	거래일시, 거래일자(참가은행), 은행이름, 계좌잔액(-금액가능), 출금가능금액, 상품명, 계좌개설일, 만기일, 최종거래일
	<form method="get" action="/openbank/accountBalance">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${sessionScope.token }"> 
		<input type="hidden" name="bank_tran_id" value="${accountBalance.bank_tran_id }">
		<input type="hidden" name="fintech_use_num" value="120220217888941294186856"> 
		<input type="hidden" name="tran_dtime" value="20221104134521"> 
		<input type="submit" value="123통장 계좌잔액조회">
	</form>
	<hr>



<!--     <h1>💸카드💸</h1> -->
<!--     2.2.4 등록카드조회 API -->
<!--     카드목록조회 -->
<!--            카드식별자, 마스킹된 카드번호, 상품명, 본인/가족구분 -->
<!--     <form method="get" action="/openbank/cardList"> -->
<%--         필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
<%-- 		<input type="hidden" name="access_token" value="${sessionScope.token }"> --%>
<%-- 		<input type="hidden" name="bank_tran_id" value="${cardList.bank_tran_id }"> --%>
<%-- 			<input type="hidden" name="user_seq_no" value="${userInfo.user_seq_no }"> --%>
<!-- 		<input type="hidden" name="bank_code_std" value="399"> -->
<!-- 		<input type="hidden" name="member_bank_code" value="399"> -->
<!--         <input type="hidden" name="befor_inquiry_trace_info" value="V"> -->
<!-- 		<input type="submit" value="카드목록"> -->
<!--     </form> -->
     
<!--       <hr> -->
    
<!--     카드기본정보조회 -->
<!--            카드구분, 결제은행대표코드, 마스킹된 출력용 결제계좌번호, 카드발급일자   -->
<!--     <form action="/openbank/cardInfo" method="post"> -->
<%-- 		<input type="hidden" name="access_token" value="${sessionScope.token }"> --%>
<%-- 	    <input type="hidden" name="bank_tran_id" value="${cardInfo.bank_tran_id }"> --%>
<%-- 			<input type="hidden" name="user_seq_no" value="${userInfo.user_seq_no }"> --%>
<!-- 		<input type="hidden" name="bank_code_std" value="399"> -->
<!-- 		<input type="hidden" name="member_bank_code" value="399"> -->
<!-- 		<input type="hidden" name="card_id" value="itwill01"> -->
<!-- 		<input type="submit" value="카드기본정보조회"> -->
<!-- 	</form> -->
	
<!-- 	 <hr> -->
	
<!-- 	<!-- 카드청구기본정보조회 --> -->
<!-- 	청구년월, 결제순번, 카드식별자, 청구금액, 결제일, 결제년월일, 신용/체크구분 -->
<!-- 	<form method="get" action="/openbank/cardBills"> -->
<%--         필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
<%-- 		<input type="hidden" name="access_token" value="${sessionScope.token }"> --%>
<%-- 		<input type="hidden" name="bank_tran_id" value="${cardBills.bank_tran_id }"> --%>
<%-- 			<input type="hidden" name="user_seq_no" value="${userInfo.user_seq_no }"> --%>
<!-- 		<input type="hidden" name="bank_code_std" value="399"> -->
<!-- 		<input type="hidden" name="member_bank_code" value="399"> -->
<!-- 		<input type="hidden" name="from_month" value="202210"> -->
<!-- 		<input type="hidden" name="to_month" value="202211"> -->
<!-- 		<input type="submit" value="카드청구조회"> -->
<!--     </form> -->
     
<!--       <hr> -->
     
<!--     카드청구상세정보조회 -->
<!--            카드식별값, 사용일자, 사용시간, 이용금액, 가맹점명, 상품구분 -->
<!--     <form method="get" action="/openbank/cardDetailBills"> -->
<%--         필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
<%-- 		<input type="hidden" name="access_token" value="${sessionScope.token }"> --%>
<%-- 		<input type="hidden" name="bank_tran_id" value="${cardDetailBills.bank_tran_id }"> --%>
<%-- 			<input type="hidden" name="user_seq_no" value="${userInfo.user_seq_no }"> --%>
<!-- 		<input type="hidden" name="bank_code_std" value="399"> -->
<!-- 		<input type="hidden" name="member_bank_code" value="399"> -->
<!-- 		<input type="hidden" name="charge_month" value="202211"> -->
<!-- 		<input type="hidden" name="settlement_seq_no" value="0001"> -->
<!-- 		<input type="submit" value="카드상세청구조회"> -->
<!--     </form> -->
     
<!--     <hr> -->

<%@ include file="../include/footer.jsp"%>
