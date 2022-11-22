<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
    
    .floatingInput {
    	color: red;
    }
    
</style>

<!-- title -->
<div class="section-title">  
  <h2>카드청구기본내역</h2>
</div>
<!-- End title -->

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
			<!-- <th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">결제일</th> -->
			<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">결제년월일</th>
			<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">신용체크구분</th>
		</tr>
		</thead>
		<tbody id="listBody">
		<%-- cardBills 객체에 저장되어 있는 카드 목록(bill_list) 가져와서 반복하여 복수개 계좌 접근 --%>
		<c:forEach var="cardBills" items="${cardBills.bill_list }" varStatus="status" end="6">
			<tr>
				<td><span class="text-sm font-weight-normal">
						<fmt:parseDate value="${cardBills.charge_month }"  var="date2" pattern="yyyyMM"/>
					  <fmt:formatDate value="${date2 }" pattern="yyyy.MM	"/>
				</span></td>
				<td><span class="text-sm font-weight-normal">${cardBills.settlement_seq_no }</span></td>
				<td><span class="text-sm font-weight-normal">${cardBills.card_id }</span></td>
				<td><span class="text-sm font-weight-normal">
						<fmt:formatNumber value="${cardBills.charge_amt }" pattern="#,###" />
				</span></td>
				<%-- <td><span class="text-sm font-weight-normal">${cardBills.settlement_day }</span></td> --%>
				<td><span class="text-sm font-weight-normal">
					<fmt:parseDate value="${cardBills.settlement_date }"  var="date1" pattern="yyyyMMdd"/>
					<fmt:formatDate value="${date1 }" pattern="yyyy.MM.dd	"/>
				</span></td>
				<td><span class="text-sm font-weight-normal">
				<c:if test="${cardBills.credit_check_type =='01'}">
				신용</c:if>
				<c:if test="${cardBills.credit_check_type =='02'}">
				체크</c:if>
				</span></td>
			</tr>
	   </c:forEach>
	   </tbody>
	</table>
	<br>
<!-- 	<div id="more_btn_div" align="center"> -->
<!-- 	  <a id="addBtn" href="javascript:moreContent('more_list', 5);">더보기</a> -->
<%-- <a id="addBtn" href="/openbank/cardBills?end=${end+4 }">더보기</a> --%>
	<br><br>
  </div>
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
		      <input type="submit" class="tbtn" value="카드상세청구내역">
              </form>
          </div>
</div>

<br>    
	
<%@ include file="../include/footer.jsp"%>
