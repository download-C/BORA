<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<!-- title -->
<div class="section-title">
  <h2><b>내 보유 계좌</b></h2>
</div>
<!-- End title -->

<style>
    .tdbtn {
      background-color: #5107B0;
      font-size: 7 px;
      color: #fff;
      padding: 3px 6px 3px 6px;
      border: 1px solid #fff;
      border-radius: 8px;
    }

    .modal {
      --bs-modal-width: 1300px;
      --bs-modal-height: 850px;
    }
    
</style>

<style>
    .tbtn {
      background-color: #5107B0;
      float: center;
      width: 330px;
      height: 70px;
      margin :20px;
      padding: 10px 10px 10px 10px;
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

<!-- 🐧🐧🐧 오픈뱅킹 계좌 리스트 출력 시작 🐧🐧🐧 -->
  <div class="container">
    <h4 style="background: linear-gradient(to top, #c8a7fa 50%, transparent 50%); width: fit-content;">계좌</h4><br>
        <span><b>◼ BORA 오픈뱅킹에서는 금융결제원 테스트베드에 인증이 완료된 계좌에 한하여 아래의 정보를 제공합니다.</b></span><br><br><br>
    <div class="row justify-content-center">
      <div class="col-10" style="padding-right: 0;">
        <div class="table-responsive">
          <table class="table table-hover" style="border-right: none; border-radius: 0; box-shadow: none;">
            <thead>
              <tr style="font-size: 18px; ">
                <th scope="col" style="color:black">계좌번호</th>
                <th scope="col" style="color:black">은행명</th>
                <th scope="col" style="color:black">계좌구분</th>
                <th scope="col" style="color:black">계좌종류</th>
                <th scope="col" style="color:black">예금주명</th>
                <th scope="col" style="color:black">계좌별칭</th>
              </tr>
            </thead>
            <tbody>
       		<c:forEach var="accountList" items="${accountList.res_list }" end="1">
              <tr>
				<td>${accountList.account_num_masked }</td>
				<td>${accountList.bank_name }</td>
				<td>${accountList.account_holder_type } (P:개인)</td>
				<td>${accountList.account_type } (1:입출금)</td>
				<td>${accountList.account_holder_name }</td>
				<td>${accountList.account_alias }</td>
              </tr>
			</c:forEach>
            </tbody>
          </table>
        </div>
      </div>
      
      <div class="col-2" style="padding-left: 0;">
        <div class="table-responsive">
          <table class="table table-hover" style="border-right: none;  border-radius: 0; box-shadow: none;">
            <thead>
              <tr style="font-size: 18px; ">
                <th scope="col" style="color:black">업무 조회</th>
              </tr>
            </thead>
            <tbody>
              <tr>
              <td style="padding-bottom: 6px; padding-top: 6px; ">
                 <div class="box" style="display: flex; justify-content: space-between-center; flex-flow: row nowrap;">
                    <!-- BORA적금 계좌 - 잔액 출력 -->	
                    <form method="get" action="/openbank/accountBalance" target="modelfrm2" id="fr1">
					<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
						<input type="hidden" name="access_token" value="${sessionScope.token }">
<!-- 						<input type="hidden" name="access_token" value="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAxMDE0NzQyIiwic2NvcGUiOlsiY2FyZGluZm8iLCJmaW50ZWNoaW5mbyIsImlucXVpcnkiLCJsb2dpbiIsInRyYW5zZmVyIl0sImlzcyI6Imh0dHBzOi8vd3d3Lm9wZW5iYW5raW5nLm9yLmtyIiwiZXhwIjoxNjc2NTA5MTYwLCJqdGkiOiIwM2IyZDk0OS1iOTBlLTQ2MGEtOTRjMy1iYmZmMThiNjU4YzIifQ.ME9l_AeCxWzrG0afC1T9rsX92QOF8zXMwOm_rwzgGDo"> -->
						<input type="hidden" name="bank_tran_id" value="${accountBalance.bank_tran_id }">
						<input type="hidden" name="fintech_use_num" value="120220217888941294186856">
						<input type="hidden" name="tran_dtime" value="20221104134521">
						<button type="submit" id="fr1btn" class="tdbtn" data-bs-toggle="modal" data-bs-target="#myModal2">잔액</button>
					</form>   
                    <!-- BORA적금 계좌 - 거래내역 출력 -->	                
                	<form method="get" action="/openbank/accountTran" target="modelfrm1">
						<input type="hidden" name="access_token" value="${sessionScope.token }">
						<input type="hidden" name="bank_tran_id" value="${accountTran.bank_tran_id}">
						<input type="hidden" name="fintech_use_num" value="120220217888941294186856">
						<input type="hidden" name="inquiry_type" value='A'>
						<input type="hidden" name="inquiry_base" value='D'>
						<input type="hidden" name="from_date" value="20100101">
						<input type="hidden" name="to_date" value="20221104">
						<input type="hidden" name="sort_order" value="D">
						<input type="hidden" name="tran_dtime" value="20221104134521">
					<button type="submit" class="tdbtn" data-bs-toggle="modal" data-bs-target="#myModal">내역</button>
					</form>
					</div>
                </td>
              </tr>
              <tr>
                <td style="padding-bottom: 6px; padding-top: 6px; ">
                	<div class="box" style="display: flex; justify-content: space-between-center; flex-flow: row nowrap;">
                	<!-- BORA입출금 계좌 - 잔액 출력 -->	
                   	<form method="get" action="/openbank/accountBalance" target="modelfrm2" id="fr2">
						<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
						<input type="hidden" name="access_token" value="${sessionScope.token }">
						<input type="hidden" name="bank_tran_id" value="${accountBalance.bank_tran_id }">
						<input type="hidden" name="fintech_use_num" value="120220217888941294172171">
						<input type="hidden" name="tran_dtime" value="20221104134521">
						<button type="submit"  id="fr2btn" class="tdbtn" data-bs-toggle="modal" data-bs-target="#myModal2">잔액</button>
					</form>   
                    <!-- BORA입출금 계좌 - 거래내역 출력 -->	    
                	<form method="get" action="/openbank/accountTran" target="modelfrm1">
						<input type="hidden" name="access_token" value="${sessionScope.token }">
						<input type="hidden" name="bank_tran_id" value="${accountTran.bank_tran_id}">
						<input type="hidden" name="fintech_use_num" value="120220217888941294172171">
						<input type="hidden" name="inquiry_type" value='A'>
						<input type="hidden" name="inquiry_base" value='D'>
						<input type="hidden" name="from_date" value="20100101">
						<input type="hidden" name="to_date" value="20221104">
						<input type="hidden" name="sort_order" value="D">
						<input type="hidden" name="tran_dtime" value="20221104134521">
						<button type="submit" class="tdbtn" data-bs-toggle="modal" data-bs-target="#myModal">내역 </button>
					</form>
                  </div>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
      <!-- 잔액 조회 버튼 -->
      <div class="col-10" style="padding-left: 0;">
        <div class="table-responsive">
          <table class="table table-hover" style="border-right: none;   border-radius: 0; box-shadow: none;">
            <tbody>
              <tr>
                <th colspan="6" style="text-align: center;">총 잔액</th>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
      <div class="col-2" style="padding-left: 0;">
        <div class="table-responsive">
          <table class="table table-hover" style="border-right: none;  border-radius: 0; box-shadow: none;">
            <tbody>
              <tr>
                <th style="text-align: center;"><span id=""></span></th>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
      <!-- 잔액조회버튼 끝 -->
<!-- 🐧🐧🐧 오픈뱅킹 계좌 리스트 출력 끝 🐧🐧🐧 -->
    </div>
    
	<!-- 목돈 모으기 -->
컨셉을 단순히 통장에 돈을 넣어 모으는 목든 모으기에서 적금을 통해 목돈 모으는 계산 시뮬레이션으로 변경
=> 모든 잔액을 불러서 내가 목표로 하는 금액에 달성해나가는 과정에서
내가 목돈 1억을 모으려면 BORA적금에서 얼마가 모자라고 얼마 만큼의 기한 동안 얼마를 더 저금해야한다는 것으로 변경
		<form method="get" action="/openbank/goal">
			<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
			<input type="hidden" name="access_token" value="${sessionScope.token }"> 
			<input type="hidden" name="bank_tran_id" value="${accountBalance.bank_tran_id }">
			<input type="hidden" name="fintech_use_num" value="120220217888941294172171"> 
			<input type="hidden" name="tran_dtime" value="20221104134521"> 
			<button type="submit" class="tbtn"><b style="color:#e3cffc;">목돈&nbsp;</b>모으기</button>
		</form>
	<!-- 목돈 모으기 -->

 
 </div>


<!-- 🐧🐧🐧 잔액/거래내역 모달창 구역 시작 🐧🐧🐧 -->
  <!-- 거래내역조회 모달 -->
  <!-- The Modal -->
  <div class="modal" id="myModal">
    <div class="modal-dialog modal-dialog-scrollable">
      <div class="modal-content" style="height: 80%;">
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">거래내역조회</h4>
          <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
        </div>
        <!-- Modal body -->
        <div class="modal-body">
          <div class="container">
            <iframe src="./acct_tran.jsp" style="width: 100%;  name="modelfrm1"></iframe>
          </div>
        </div>
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-bs-dismiss="modal">닫기</button>
        </div>
      </div>
    </div>
  </div>
  <!-- 잔액조회 모달 -->
  <!-- The Modal -->
    <div class="modal" id="myModal2">
      <div class="modal-dialog">
        <div class="modal-content" style="height: 30%;">
          <!-- Modal Header -->
          <div class="modal-header">
            <h4 class="modal-title">잔액조회</h4>
            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
          </div>
          <!-- Modal body -->
          <div class="modal-body">
            <div class="container">
              <iframe src="./acct_balance.jsp" style="width: 100%;" name="modelfrm2"></iframe>
            </div>
          </div>
          <!-- Modal footer -->
          <div class="modal-footer">
            <button type="button" class="btn btn-danger" data-bs-dismiss="modal">닫기</button>
          </div>
        </div>
      </div>
    </div>
<!-- 🐧🐧🐧 잔액/거래내역 모달창 구역 끝 🐧🐧🐧 -->
  <br>


<!-- 잔액값 불러오는 ajax -->
	<script type="text/javascript">
	$(document).ready(function() {
		//페이지 시작 시 자동 실행 되도록 설정
		window.onload = function() {
			// 		alert('ajax 확인');

			let info1 = $("#fr1").serialize();
			let info2 = $("#fr2").serialize();
// 			console.log(info1 );
// 			var result = confirm("잔액 조회");
			
				//ajax 자리
				$.ajax({
					url : "/ajax/accountBalanceAjax1",
					type : "GET",
					async : true,
					data : info1, // 전송 데이터
					dataType : "json", // 전송 데이터 형식
					contentType : "application/json;charset=UTF-8",
					success : function(data) { // 성공 시 실행
						if(data.rsp_code == "A0000"){
// 							$('#result_balance_amt').html(res.balance_amt);
							$('#req1_balance_amt').val(data.balance_amt);
							$('#req1_balance_amt').html(balance_amt);
// 							alert("완료"+ data.balance_amt);
						} else {
							alert("전송된 값 없음");
							return false;
						}
					},
					error : function(error) { //실패 시 실행
				    	console.log(error);
						alert('실패 원인 : ' + error);
					}
				});//ajax

				$.ajax({
					url : "/ajax/accountBalanceAjax2",
					type : "GET",
					async : true,
					data : info2, // 전송 데이터
					dataType : "json", // 전송 데이터 형식
					contentType : "application/json;charset=UTF-8",
					success : function(data) { // 성공 시 실행
// 						if (data != null) {
						if(data.rsp_code == "A0000"){
							$('#req2_balance_amt').val(data.balance_amt);
// 							alert("완료"+ data.balance_amt);
						} else {
							alert("전송된 값 없음");
							return false;
						}
					},
					error : function(error) { //실패 시 실행
				    	console.log(error);
						alert('실패 원인 : ' + error);
					}
				});//ajax

		}//window.onlaod

	});//jquery
</script>

<input type="text" id="req1_balance_amt" value="req1_balance_amt">
<input type="hidden" id="req2_balance_amt" value="req2_balance_amt">
<span id="req2_balance_amt"></span>
	

<%@ include file="../include/footer.jsp"%>