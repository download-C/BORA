<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp"%>
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
    
    .tbtn {
      background-color: #5107B0;
      float: center;
      width: 70%;
      height: 70px;
      padding: 10px 10px 10px 10px; 
      border: 1px solid #fff;
      border-radius: 8px;
      color: white; 
/*       color: #e3cffc; */
      border-radius: 13px;
      font-size: 20px;
      text-align: center;
    }
    
    .floatingInput {
    	color: red;
    }
    
    .goaltitle {
    	margin: 70px 0px 30px 0px;
    }
    
    .backbtn {
      background-color: #5107B0;
      font-size: 17px;
      color: #fff;
      padding: 8px 15px 8px 15px;
      border: 1px solid #fff;
      border-radius: 8px;
    }
    
     tr { 
     	text-align: center;
     }
</style>

<!-- 🐧🐧🐧 오픈뱅킹 계좌 리스트 출력 시작 🐧🐧🐧 -->
  <div class="container">
    <h4 style="background: linear-gradient(to top, #c8a7fa 50%, transparent 50%); width: fit-content;">계좌</h4><br>
        <span><b>◼ BORA 오픈뱅킹에서는 금융결제원 테스트베드에 인증이 완료된 계좌에 한하여 아래의 정보를 제공합니다.</b></span><br><br><br>
    <div class="row justify-content-center">
      <div class="col-8" style="padding-right: 0;">
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
				<td>${accountList.account_holder_type } (개인)</td>
				<td>${accountList.account_type } (일반)</td>
				<td>${accountList.account_holder_name }</td>
				<td>${accountList.account_alias }</td>
              </tr>
			</c:forEach>
            </tbody>
          </table>
        </div>
      </div>
      <div class="col-4" style="padding-left: 0;">
        <div class="table-responsive">
          <table class="table table-hover" style="border-right: none;  border-radius: 0; box-shadow: none;">
            <thead>
              <tr style="font-size: 18px; ">
                <th scope="col" style="color:black">잔액</th>
                <th scope="col" style="color:black">업무 조회</th>
              </tr>
            </thead>
            <tbody>
              <tr>
              <!-- 잔액1 -->     
              <td><span id="req1_balance_amt" value="req1_balance_amt"></span>원</td>
              <td style="padding-bottom: 2px; padding-top: 2px; text-align: center; ">
                 <div class="box justify-content-center" style="display: flex; justify-content: space-between-center; flex-flow: row nowrap;">
                    <!-- BORA적금 계좌 - 잔액 출력 -->	
                    <form method="get" action="/openbank/accountBalance" target="modelfrm2" id="fr1">
					<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
						<input type="hidden" name="access_token" value="${sessionScope.token }">
<!-- 						<input type="hidden" name="access_token" value="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAxMDE0NzQyIiwic2NvcGUiOlsiY2FyZGluZm8iLCJmaW50ZWNoaW5mbyIsImlucXVpcnkiLCJsb2dpbiIsInRyYW5zZmVyIl0sImlzcyI6Imh0dHBzOi8vd3d3Lm9wZW5iYW5raW5nLm9yLmtyIiwiZXhwIjoxNjc2NTA5MTYwLCJqdGkiOiIwM2IyZDk0OS1iOTBlLTQ2MGEtOTRjMy1iYmZmMThiNjU4YzIifQ.ME9l_AeCxWzrG0afC1T9rsX92QOF8zXMwOm_rwzgGDo"> -->
						<input type="hidden" name="bank_tran_id" value="${accountBalance.bank_tran_id }">
						<input type="hidden" name="fintech_use_num" value="120220231688941219476440">
						<input type="hidden" name="tran_dtime" value="20221104134521">
						<button type="submit" class="tdbtn" data-bs-toggle="modal" data-bs-target="#myModal2">세부잔액</button>
					</form>   
                    <!-- BORA적금 계좌 - 거래내역 출력 -->	                
                	<form method="get" action="/openbank/accountTran" target="modelfrm1">
						<input type="hidden" name="access_token" value="${sessionScope.token }">
						<input type="hidden" name="bank_tran_id" value="${accountTran.bank_tran_id}">
						<input type="hidden" name="fintech_use_num" value="120220231688941219476440">
						<input type="hidden" name="inquiry_type" value='A'>
						<input type="hidden" name="inquiry_base" value='D'>
						<input type="hidden" name="from_date" value="20100101">
						<input type="hidden" name="to_date" value="20221104">
						<input type="hidden" name="sort_order" value="D">
						<input type="hidden" name="tran_dtime" value="20221104134521">
					<button type="submit" class="tdbtn" data-bs-toggle="modal" data-bs-target="#myModal">거래내역</button>
					</form>
					</div>
                </td>
              </tr>
              <tr>
              <!-- 잔액2 -->
              <td><span id="req2_balance_amt" value="req2_balance_amt"></span>원</td>
                <td style="padding-bottom: 6px; padding-top: 6px; text-align: center; ">
                	<div class="box justify-content-center" style="display: flex; justify-content: space-between-center; flex-flow: row nowrap;">
                	<!-- BORA입출금 계좌 - 잔액 출력 -->	
                   	<form method="get" action="/openbank/accountBalance" target="modelfrm2" id="fr2">
						<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
						<input type="hidden" name="access_token" value="${sessionScope.token }">
						<input type="hidden" name="bank_tran_id" value="${accountBalance.bank_tran_id }">
						<input type="hidden" name="fintech_use_num" value="120220231688941219476440">
						<input type="hidden" name="tran_dtime" value="20221104134521">
						<button type="submit" class="tdbtn" data-bs-toggle="modal" data-bs-target="#myModal2">세부잔액</button>
					</form>   
                    <!-- BORA입출금 계좌 - 거래내역 출력 -->	    
                	<form method="get" action="/openbank/accountTran" target="modelfrm1">
						<input type="hidden" name="access_token" value="${sessionScope.token }">
						<input type="hidden" name="bank_tran_id" value="${accountTran.bank_tran_id}">
						<input type="hidden" name="fintech_use_num" value="120220231688941219476440">
						<input type="hidden" name="inquiry_type" value='A'>
						<input type="hidden" name="inquiry_base" value='D'>
						<input type="hidden" name="from_date" value="20100101">
						<input type="hidden" name="to_date" value="20221104">
						<input type="hidden" name="sort_order" value="D">
						<input type="hidden" name="tran_dtime" value="20221104134521">
						<button type="submit" class="tdbtn" data-bs-toggle="modal" data-bs-target="#myModal">거래내역</button>
					</form>
                  </div>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
       <!-- 잔액 조회 버튼 -->
      <div class="col-7" style="padding-left: 0;">
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
      <div class="col-5" style="padding-left: 0;">
        <div class="table-responsive">
          <table class="table table-hover" style="border-right: none;  border-radius: 0; box-shadow: none;">
            <tbody>
              <tr>
                <th style="text-align: center;"><span id="total1"></span>원</th>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
      <!-- 잔액조회버튼 끝 -->
<!-- 🐧🐧🐧 오픈뱅킹 계좌 리스트 출력 끝 🐧🐧🐧 -->
	</div>
  </div>


<!-- 내 자산으로 돌아가기  --> 
<div class="container">
   	<div class="col-md-16 col-16">
	        <!-- 자산 조회를 위한 인증 요청 작업 수행 -->
 	        <form method="get" action="/openbank/userInfo">
               <input type="hidden" name="access_token" value="${sessionScope.token }">
               <input type="hidden" name="user_seq_no" value="1101014738">
			   <button type="submit" class="backbtn acct_user">내 자산 조회로 돌아가기</button>
            </form>
    </div>
</div>  
<br>

<!-- title -->
<div class="section-title">
  <h2><b>목돈 모으기</b></h2>
</div>
<!-- End title -->

	<!-- 목돈 모으기 -->
<div class="container">
	<div class="row row-cols-md-14 g-4 justify-content-center">
    	<!-- 1 목돈 안내 배너  -->
		<div class="col-md-7 col-10">
    		<picture>
				<source media="(min-width: 1024px)" srcset="${pageContext.request.contextPath}/resources/img/goal1.png" >
	  	 		<img src="${pageContext.request.contextPath}/resources/img/goal1.png"" class="img-fluid">
			</picture>
		</div>
    	<!-- 2 목돈 모으기 버튼  -->
		<div class="col-md-4 col-10">
			<div class="container" style="text-align: center;">
<!-- 			<div class="goaltitle" style="margin: 70px 0px 30px 0px;"> -->
			<div class="goaltitle">
            	<h3><span style="background: linear-gradient(to top, #c8a7fa 50%, transparent 50%);">BORA</span>와 함께
            	<span style="background: linear-gradient(to top, #c8a7fa 50%, transparent 50%);">목돈</span>&nbsp;모으기</h3>
            </div>
<!--             <br><br> -->
			<form method="get" action="/openbank/goal">
				<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
				<input type="hidden" name="access_token" value="${sessionScope.token }"> 
				<input type="hidden" name="bank_tran_id" value="${accountBalance.bank_tran_id }">
				<input type="hidden" name="fintech_use_num" value="120220231688941219476440"> 
				<input type="hidden" name="tran_dtime" value="20221104134521"> 
				<!-- 목돈 모으기에 보낼 잔액값 - 히든12 -->
				<input type="hidden" id="hidden1" value="">
				<input type="hidden" id="hidden2" value="">
				<button type="submit" class="tbtn"><b style="color:#e3cffc;">목돈 모으기 </b>확인</button>
			</form>
			</div>
			<!-- 각 계좌별 잔액, 총 잔액 출력 - 히든34  -->
			<input type="hidden" id="hidden3" value="">
			<input type="hidden" id="hidden4" value="">
 		</div>
	</div>
</div>
<br>

<!-- 🐧🐧🐧 잔액/거래내역 모달창 구역 시작 🐧🐧🐧 -->
  <!-- 거래내역조회 모달 -->
  <!-- The Modal -->
  <div class="modal" id="myModal">
<!--     <div class="modal-dialog modal-dialog-scrollable"> -->
    <div class="modal-dialog">
      <div class="modal-content" style="height: 90%;">
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">거래내역조회</h4>
          <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
        </div>
        <!-- Modal body -->
        <div class="modal-body">
          <div class="container">
            <iframe src="./acct_tran.jsp" style="width: 100%; height: 300px;" name="modelfrm1"></iframe>
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
// 							$('#req1_balance_amt').val(data.balance_amt);
							$('#req1_balance_amt').html(data.balance_amt);
							$('#hidden1').val(data.balance_amt);
							$('#hidden3').val(data.balance_amt);
// 							alert("완료"+ data.balance_amt);
							
							
							$.ajax({
								url : "/ajax/accountBalanceAjax2",
								type : "GET",
								async : true,
								data : info2, // 전송 데이터
								dataType : "json", // 전송 데이터 형식
								contentType : "application/json;charset=UTF-8",
								success : function(data) { // 성공 시 실행
									if(data.rsp_code == "A0000"){
			 							// $('#req2_balance_amt').val(data.balance_amt);
										$('#req2_balance_amt').html(data.balance_amt);
										
										$('#hidden2').val(data.balance_amt);
										$('#hidden4').val(data.balance_amt);
										
									//잔액 합치기 - 총 잔액
										//String 잔액값을 integer 타입으로 변환
										var num1 = parseInt($('#hidden3').val());
										var num2 = parseInt($('#hidden4').val());
										var result = num1+num2;
										
										//총 잔액에 콤마 넣기 
										const cn1 = result.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
										$('#total1').html(cn1);
										
										sessionStorage.setItem('total', result);
										
										//잔액1에 콤마 넣기 
										const cn3 = num1.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
										$('#req1_balance_amt').html(cn3);							
										
										//잔액2에 콤마 넣기 
										const cn4 = num2.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
										$('#req2_balance_amt').html(cn4);							
			
										
									} else {
										alert("전송된 값 없음");
										return false;
									}
								},
								error : function(error) { //실패 시 실행
							    	console.log(error);
									alert('실패 원인 : ' + error);
								}
								
							});//ajax2
							
							
							
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
	
	function getTotal(){ }
	
</script>

<span style="font-size: xx-large;" id="req2_balance_amt"></span>

<%@ include file="../include/footer.jsp"%>