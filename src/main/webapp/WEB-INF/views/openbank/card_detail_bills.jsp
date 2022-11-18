<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<!-- title -->
<div class="section-title">  
  <h2>카드청구상세내역</h2>
</div>
<!-- End title -->


<div class="row">
  <div class="col-12">     
   <div class="card-body px-0 py-0" >
    <div class="container">
	 <table  class="table table-hover" style="box-shadow: 7px 14px 90px 3px rgba(163, 174, 184, 0.7);">
		<thead class="bg-gray-100">
		<tr>
			<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">사용일자</th>
			<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">사용시간</th>
			<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">이용금액</th>
			<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">가맹점명</th>
			<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">상품구분</th>
		</tr>
		</thead>
		<tbody>	
		<%-- cardDetailBills 객체에 저장되어 있는 카드 목록(bill_detail_list) 가져와서 반복하여 복수개 계좌 접근 --%>
		<c:forEach var="cardDetailBills" items="${cardDetailBills.bill_detail_list }" end="6">
			<tr>
				<td><span class="text-sm font-weight-normal">${cardDetailBills.paid_date }</span></td>
				<td><span class="text-sm font-weight-normal">${cardDetailBills.paid_time }</span></td>
				<td><span class="text-sm font-weight-normal">${cardDetailBills.paid_amt }</span></td>
				<td><span class="text-sm font-weight-normal">${cardDetailBills.merchant_name_masked }</span></td>
				<td><span class="text-sm font-weight-normal">
				<c:if test="${cardDetailBills.product_type == '01'}">
				일시불</c:if>
				<c:if test="${cardDetailBills.product_type == '02'}">
				신용판매할부</c:if>
				<c:if test="${cardDetailBills.product_type == '03'}">
				현금서비스</c:if>
				</span></td>
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
