<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<h1>카드 기본 청구 내역</h1>

<h3>카드구분</h3>
<h3>신용/체크 구분3) "01":신용, "02":체크, "03":신용/체크 혼용 </h3>
<hr>

<div class="row">
  <div class="col-12">
   <div class="card-body px-0 py-0" >
    <div class="container">
	 <table  class="table table-hover" style="box-shadow: 7px 14px 90px 3px rgba(163, 174, 184, 0.7);">
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
		<tbody>	
		<%-- cardBills 객체에 저장되어 있는 카드 목록(bill_list) 가져와서 반복하여 복수개 계좌 접근 --%>
		<c:forEach var="cardBills" items="${cardBills.bill_list }">
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
   </div> <!-- container -->
   <br><br>
  </div>
</div> <!-- col-12 -->
</div> <!-- row -->
	
<%@ include file="../include/footer.jsp"%>