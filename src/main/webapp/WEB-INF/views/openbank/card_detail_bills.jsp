<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<!-- title -->
<div class="section-title">  
  <h2>카드청구상세내역</h2>
</div>
<!-- End title -->
<style>
    .tbtn {
      background-color: #5107B0;
      float: left;
/*       width: 330px; */
/*       height: 70px; */  
      padding: 8px 15px 8px 15px;
      border: 1px solid #fff;
      border-radius: 8px;
      color: white; 
/*       color: #e3cffc; */
      border-radius: 13px;
      font-size: 17px;
      text-align: center;
    }
</style>

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
				<td><span class="text-sm font-weight-normal">
						<fmt:parseDate value="${cardDetailBills.paid_date }"  var="date2" pattern="yyyyMMdd"/>
					  <fmt:formatDate value="${date2 }" pattern="yyyy.MM.dd	"/>
				</span></td>
				<td><span class="text-sm font-weight-normal">
						<fmt:parseDate value="${cardDetailBills.paid_time }" var="time" pattern="HHmmss"/>
						<fmt:formatDate value="${time }" pattern="HH:mm:ss"/>
				</span></td>
				<td><span class="text-sm font-weight-normal">
						<fmt:formatNumber value="${cardDetailBills.paid_amt }" pattern="#,###" /></span></td>
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
<div class="container">
               <form method="get" action="/openbank/cardList">
					<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
					<input type="hidden" name="access_token" value="${sessionScope.token }"> 
					<input type="hidden" name="bank_tran_id" value="${cardList.bank_tran_id }"> 
					<input type="hidden" name="user_seq_no" value="${userInfo.user_seq_no }">
					<input type="hidden" name="bank_code_std" value="399"> 
					<input type="hidden" name="member_bank_code" value="399">
					<!-- <input type="hidden" name="befor_inquiry_trace_info" value="V"> -->
					<input type="submit" class="tbtn" value="카드목록보기">
				</form>
</div>
 <div class="container">
       <div class="col-sm-19 col-md-17 col-lg-80 mx-auto" style="display: flex; justify-content: space-between;">
                <!-- 카드청구기본정보조회 -->
	            <form method="get" action="/openbank/cardBills">
                <%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		        <input type="hidden" name="access_token" value="${sessionScope.token }">
		        <input type="hidden" name="bank_tran_id" value="${sessionScope.bank_tran_id }">
			    <input type="hidden" name="user_seq_no" value="${sessionScope.user_seq_no }">
		        <input type="hidden" name="bank_code_std" value="399">
		        <input type="hidden" name="member_bank_code" value="399">
		        <input type="hidden" name="from_month" value="202210">
		        <input type="hidden" name="to_month" value="202211">
		        <input type="submit" class="tbtn" value="카드기본청구내역">
                </form>   
        </div>         
</div>

<%@ include file="../include/footer.jsp"%>
