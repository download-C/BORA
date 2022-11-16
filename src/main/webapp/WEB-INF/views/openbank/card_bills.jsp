<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
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
      --bs-modal-width: 1300px;
      --bs-modal-height: 850px;
    }
    
</style>

<h1>카드 기본 청구 내역</h1>

<hr>

<form id="searchTxtForm">
<input type="hidden" name="viewCount" id="viewCount" value="0">
<input type="hidden" name="starCount" id="startCount" value="0">
<div class="row">
  <div class="col-12">
   <div class="card-body px-0 py-0" >
    <div class="container">
	 <table class="table table-hover" id="more_list" style="box-shadow: 7px 14px 90px 3px rgba(163, 174, 184, 0.7);">
		<thead class="bg-gray-100">
		<tr>
			<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">청구년월</th>
			<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">결제순번</th>
			<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">카드식별자</th>
			<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">청구금액</th>
			<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">결제일</th>
			<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">결제년월일</th>
			<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">신용체크구분</th>
		</tr>
		</thead>
		<tbody id="listBody">	
		<%-- cardBills 객체에 저장되어 있는 카드 목록(bill_list) 가져와서 반복하여 복수개 계좌 접근 --%>
		<c:forEach var="cardBills" items="${cardBills.bill_list }" varStatus="status" end="4">
			<tr>
				<td><span class="text-sm font-weight-normal">${cardBills.charge_month }</span></td>
				<td><span class="text-sm font-weight-normal">${cardBills.settlement_seq_no }</span></td>
				<td><span class="text-sm font-weight-normal">${cardBills.card_id }</span></td>
				<td><span class="text-sm font-weight-normal">${cardBills.charge_amt }</span></td>
				<td><span class="text-sm font-weight-normal">${cardBills.settlement_day }</span></td>
				<td><span class="text-sm font-weight-normal">${cardBills.settlement_date }</span></td>
				<td><span class="text-sm font-weight-normal">${cardBills.credit_check_type }</span></td>
			</tr>
	   </c:forEach>
	   </tbody>
	</table>
	<br>
	<div id="more_btn_div" align="center">
	<hr>
	  <a id="addBtn" href="javascript:moreContent('more_list', 10);">더보기</a>
	</div>
   </div> <!-- container -->
   <br><br>
  </div>
</div> <!-- col-12 -->
</div> <!-- row -->
</form>

     <div class="col-2" style="padding-left: 0;">
        <div class="table-responsive">
          <table class="table table-hover" style="border-right: none;  border-radius: 0; box-shadow: none;">
            <thead>
              <tr>
                <th scope="col" style="color:black">업무</th>
              </tr>
            </thead>
            <tbody >

             <tr>
              <td style="padding-bottom: 6px; padding-top: 6px;">
             <!-- 카드청구상세정보조회 -->
              <form method="get" action="/openbank/cardDetailBills">
              <%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		      <input type="hidden" name="access_token" value="${sessionScope.token }">
		      <input type="hidden" name="bank_tran_id" value="${sessionScope.bank_tran_id }">
			  <input type="hidden" name="user_seq_no" value="${sessionScope.user_seq_no }">
		      <input type="hidden" name="bank_code_std" value="399">
		      <input type="hidden" name="member_bank_code" value="399">
		      <input type="hidden" name="charge_month" value="202211">
		      <input type="hidden" name="settlement_seq_no" value="0001">
		      <input type="submit" value="카드상세청구조회" class="tdbtn">
              </form>
              </td>
             </tr>
            </tbody>
          </table>
        </div>
      </div>
	
<%@ include file="../include/footer.jsp"%>
