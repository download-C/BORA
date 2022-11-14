<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>


<!-- title -->
<div class="section-title">
  <h2><b>내 자산 보기</b></h2>
</div>
<!-- End title -->

  <style>
    .tdbtn {
      background-color: #5107B0;
      font-size: 12 px;
      color: #fff;
      padding: 2;
      margin: 0;
      border: 1px solid #fff;
      border-radius: 8px;
    }

    .modal {
      --bs-modal-width: 1000px;
      --bs-modal-height: 750px;
    }
  </style>

<!-- account -->
  <div class="container">
    <h4 style="background: linear-gradient(to top, #c8a7fa 50%, transparent 50%); width: fit-content;">계좌</h4><br>
    <div class="row justify-content-center">
      <div class="col-10" style="padding-right: 0;">
        <div class="table-responsive">
          <table class="table table-hover" style="border-right: none; border-radius: 0; box-shadow: none;">
            <thead>
              <tr style="font-size: 16px; ">
                <th scope="col" style="color:black">계좌번호</th>
                <th scope="col" style="color:black">은행명</th>
                <th scope="col" style="color:black">계좌구분</th>
                <th scope="col" style="color:black">계좌종류</th>
                <th scope="col" style="color:black">예금주명</th>
                <th scope="col" style="color:black">계좌별칭</th>
              </tr>
            </thead>
            <tbody>
       		<c:forEach var="accountList" items="${accountList.res_list }">
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
              <tr>
                <th scope="col" style="color:black">업무</th>
              </tr>
            </thead>
            <tbody>

              <tr>
                <td style="padding-bottom: 6px; padding-top: 6px;">
                
                	<form method="get" action="/openbank/accountTran" target="frm1">
					<input type="hidden" name="access_token" value="${sessionScope.token }">
					<input type="hidden" name="bank_tran_id" value="${accountTran.bank_tran_id}">
					<input type="hidden" name="fintech_use_num" value="120220217888941294186856">
					<input type="hidden" name="inquiry_type" value='A'>
					<input type="hidden" name="inquiry_base" value='D'>
					<input type="hidden" name="from_date" value="20100101">
					<input type="hidden" name="to_date" value="20221104">
					<input type="hidden" name="sort_order" value="D">
					<input type="hidden" name="tran_dtime" value="20221104134521">
					<input type="submit" value="내역조회" class="tdbtn" data-bs-toggle="modal" data-bs-target="#myModal">
					</form>
<!--                   <button type="button" class="tdbtn" data-bs-toggle="modal" data-bs-target="#myModal">내역조회</button> -->
                	
                	<form method="get" action="/openbank/accountBalance" target="frm2">
					<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
					<input type="hidden" name="access_token" value="${sessionScope.token }">
					<input type="hidden" name="bank_tran_id" value="${accountBalance.bank_tran_id }">
					<input type="hidden" name="fintech_use_num" value="120220217888941294186856">
					<input type="hidden" name="tran_dtime" value="20221104134521">
					<input type="submit" value="잔액조회" class="tdbtn" data-bs-toggle="modal" data-bs-target="#myModal2">
					</form>   
<!--                   <button class="tdbtn" class="tdbtn" data-bs-toggle="modal" data-bs-target="#myModal2">잔액조회</button> -->

                </td>
              </tr>
              <tr>
                <td style="padding-bottom: 6px; padding-top: 6px;">
                
                	<form method="get" action="/openbank/accountTran" target="frm1">
					<input type="hidden" name="access_token" value="${sessionScope.token }">
					<input type="hidden" name="bank_tran_id" value="${accountTran.bank_tran_id}">
					<input type="hidden" name="fintech_use_num" value="120220217888941294172171">
					<input type="hidden" name="inquiry_type" value='A'>
					<input type="hidden" name="inquiry_base" value='D'>
					<input type="hidden" name="from_date" value="20100101">
					<input type="hidden" name="to_date" value="20221104">
					<input type="hidden" name="sort_order" value="D">
					<input type="hidden" name="tran_dtime" value="20221104134521">
					<input type="submit" value="내역조회" class="tdbtn" data-bs-toggle="modal" data-bs-target="#myModal">
					</form>
<!--                   <button class="tdbtn" data-bs-toggle="modal" data-bs-target="#myModal">내역조회</button> -->
                  
                	<form method="get" action="/openbank/accountBalance" target="frm2">
					<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
					<input type="hidden" name="access_token" value="${sessionScope.token }">
					<input type="hidden" name="bank_tran_id" value="${accountBalance.bank_tran_id }">
					<input type="hidden" name="fintech_use_num" value="120220217888941294172171">
					<input type="hidden" name="tran_dtime" value="20221104134521">
					<input type="submit" value="잔액조회" class="tdbtn" data-bs-toggle="modal" data-bs-target="#myModal2">
					</form>   
<!--                   <button class="tdbtn" class="tdbtn" data-bs-toggle="modal" data-bs-target="#myModal2">잔액조회</button> -->                  
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
      <!-- 잔액조회버튼 -->
      <div class="col-10" style="padding-left: 0;">
        <div class="table-responsive">
          <table class="table table-hover" style="border-right: none;  border-radius: 0; box-shadow: none;">
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
                <th style="text-align: center;">00원</th>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
      <!-- 잔액조회버튼 끝 -->
      <!-- End account -->
    </div>
  </div>


 
   <!-- 모달창 -->
   <!--   	거래내역조회 -->
  <!-- The Modal -->
  <div class="modal" id="myModal">
    <div class="modal-dialog modal-dialog-scrollable">
      <div class="modal-content">

        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">거래내역조회</h4>
          <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
        </div>

        <!-- Modal body -->
        <div class="modal-body">
          <div class="container">
<!--             <iframe src="modaltable.html" style="width: 100%;"></iframe> -->
            <iframe src="./acct_tran.jsp" style="width: 100%;" name="frm1"></iframe>

            <!-- End table -->

          </div>
        </div>

        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-bs-dismiss="modal">닫기</button>
        </div>
      </div>
    </div>
  </div>
<!--  BORA입출금 잔액조회 -->
    <!-- The Modal -->
    <div class="modal" id="myModal2">
      <div class="modal-dialog modal-dialog-scrollable">
        <div class="modal-content">
  
          <!-- Modal Header -->
          <div class="modal-header">
            <h4 class="modal-title">잔액조회</h4>
            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
          </div>
  
          <!-- Modal body -->
          <div class="modal-body">
            <div class="container">
<!--               <iframe src="modaltable.html" style="width: 100%;"></iframe> -->
              <iframe src="./acct_balance.jsp" style="width: 100%;" name="frm2"></iframe>
  
              <!-- End table -->
  
            </div>
          </div>
  
          <!-- Modal footer -->
          <div class="modal-footer">
            <button type="button" class="btn btn-danger" data-bs-dismiss="modal">닫기</button>
          </div>
        </div>
      </div>
    </div>
  <!-- 모달창 끝 -->
  <br>


	
<%@ include file="../include/footer.jsp"%>
