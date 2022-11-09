<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>


<!-- title -->
<div class="section-title">
  <h2><b>계좌 거래 내역</b></h2>
  
</div>
<!-- End title -->

<h3>입출금구분 입출금구분주4) (입금, 출금, 지급, 기타)_입출금구분이 ‘기타’인 경우에는 ‘거래금액’이 0원으로 세팅됨</h3>
<h3>거래유형 현금, 대체, 급여, 타행환, F/B출금 등 (참가은행에서 직접 세팅)</h3>

<!-- 	<table> -->
<!-- 		<tr> -->
<!-- 			<th>거래일자</th> -->
<!-- 			<th>입출금구분</th> -->
<!-- 			<th>거래타입</th> -->
<!-- 			<th>통장인자내용</th> -->
<!-- 			<th>거래금액</th> -->
<!-- 			<th>거래후잔액</th> -->
<!-- 			<th>거래점명</th> -->
<!-- 		</tr> -->
<%-- 		<%-- accountTran 객체에 저장되어 있는 거래 내역 목록(res_list) 가져와서 반복하여 복수개 계좌 접근 --%> --%>
<%-- 		<c:forEach var="accountTran" items="${accountTran.res_list }"> --%>
<!-- 			<tr> -->
<%-- 				<td>${accountTran.tran_date }</td> --%>
<%-- 				<td>${accountTran.inout_type }</td> --%>
<%-- 				<td>${accountTran.tran_type }</td> --%>
<%-- 				<td>${accountTran.print_content }</td> --%>
<%-- 				<td>${accountTran.tran_amt }</td> --%>
<%-- 				<td>${accountTran.after_balance_amt }</td> --%>
<%-- 				<td>${accountTran.branch_name }</td> --%>
<!-- 			</tr> -->
<%-- 		</c:forEach> --%>
<!-- 	</table> -->



<hr>

<div class="row">
  <div class="col-12">
   <div class="d-sm-flex align-items-center mb-3">
	<div class="container">
		<button type="button" value="모두다BORA" class="ctgr_btn btn" id="btn_all"  style="background-color: #e3cffc; float: left; width: 160px; margin: 0px 10px 10px 0px; border-radius: 25px;"><span class="btn-inner--text" style="color: black;">모두다<b style="color:#5107B0;">BORA</b></span></button>
		<button type="button" value="글쓰기" onclick="location.href='/board/insert';" class="btn" id="" style="background-color: #5107B0; float: right; width: 120px; margin: 0px 10px 10px 0px;"><span class="btn-inner--text" style="color: white;">글쓰기</span></button>
	</div>
	</div>
   <div class="card-body px-0 py-0" >
    <div class="container">
		<table  class="table table-hover" style="box-shadow: 7px 14px 90px 3px rgba(163, 174, 184, 0.7);">
			<thead class="bg-gray-100">
				<tr>
					<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">거래일자</th>
					<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">입출금구분</th>
					<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">거래타입</th>
					<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">통장인자내용</th>
					<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">거래금액</th>
					<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">거래후잔액</th>
					<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">거래점명</th>
				</tr>
			</thead>
			<tbody>	
					<%-- accounTran 객체에 저장되어 있는 계좌 목록(res_list) 가져와서 반복하여 복수개 계좌 접근 --%>
		<c:forEach var="accountTran" items="${accountTran.res_list }">
			<tr>
				<td><span class="text-sm font-weight-normal">${accountTran.tran_date }</span></td>
				<td><span class="text-sm font-weight-normal">${accountTran.inout_type }</span></td>
				<td><span class="text-sm font-weight-normal">${accountTran.tran_type }</span></td>
				<td><span class="text-sm font-weight-normal">${accountTran.print_content }</span></td>
				<td><span class="text-sm font-weight-normal">${accountTran.tran_amt }</span></td>
				<td><span class="text-sm font-weight-normal">${accountTran.after_balance_amt }</span></td>
				<td><span class="text-sm font-weight-normal">${accountTran.branch_name }</span></td>
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