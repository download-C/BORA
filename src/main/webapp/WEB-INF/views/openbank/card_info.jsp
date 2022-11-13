<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<!-- title -->
<div class="section-title">
   <h1>카드 기본 정보 조회</h1>

</div>
<!-- End title -->

<hr>  
   <div class="card-body px-0 py-0" >
    <div class="container"> 
     <table class="table table-hover" style="box-shadow: 7px 14px 90px 3px rgba(163, 174, 184, 0.7);">
		<thead class="bg-gray-100">
		 <tr>
			<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">카드구분</th>
		    <th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">은행코드</th>
			<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">계좌번호</th>
			<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">카드발급일자</th>
		 </tr>
		</thead>
		<tbody>
			<tr>
				<td><span class="text-sm font-weight-normal">${cardInfo.card_type }</span></td>
				<td><span class="text-sm font-weight-normal">${cardInfo.settlement_bank_code }</span></td>
				<td><span class="text-sm font-weight-normal">${cardInfo.settlement_account_num_masked }</span></td>
				<td><span class="text-sm font-weight-normal">${cardInfo.issue_date }</span></td>
			</tr>	
		</tbody>
	</table>
   </div> <!-- container -->
   <br><br>
  </div>
	
<%@ include file="../include/footer.jsp"%>