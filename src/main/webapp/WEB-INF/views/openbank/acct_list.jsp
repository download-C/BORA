<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>


<!-- title -->
<div class="section-title">
  <h2><b>보유 계좌 목록</b></h2>
  
</div>
<!-- End title -->

<div>

<h1>계좌목록</h1>
 	
<h3>계좌구분(P:개인)</h3>
<h3>계좌종류주3) 1:수시입출금, 2:예적금 6:수익증권, T:종합계좌</h3>
<hr>

<!-- 	<table> -->
<!-- 		<tr> -->
<!-- 			<th>마스킹된 출력용 계좌번호</th> -->
<!-- 			<th>은행명</th> -->
<!-- 			<th>계좌구분</th> -->
<!-- 			<th>계좌종류</th> -->
<!-- 			<th>예금주명</th> -->
<!-- 			<th>계좌별명</th> -->
<!-- 		</tr> -->
<%-- 		<%-- accountList 객체에 저장되어 있는 계좌 목록(res_list) 가져와서 반복하여 복수개 계좌 접근 --%> --%>
<%-- 		<c:forEach var="accountList" items="${accountList.res_list }"> --%>
<!-- 			<tr> -->
<%-- 				<td>${accountList.account_num_masked }</td> --%>
<%-- 				<td>${accountList.bank_name }</td> --%>
<%-- 				<td>${accountList.account_holder_type }</td> --%>
<%-- 				<td>${accountList.account_type }</td> --%>
<%-- 				<td>${accountList.account_holder_name }</td> --%>
<%-- 				<td>${accountList.account_alias }</td> --%>
<!-- 			</tr> -->
<%-- 		</c:forEach> --%>
<!-- 	</table> -->
	
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
					<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">계좌번호</th>
					<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2S">은행명</th>
					<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">계좌구분</th>
					<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">계좌종류</th>
					<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">예금주명</th>
					<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">계좌별칭</th>
				</tr>
			</thead>
			<tbody>	
					<%-- accountList 객체에 저장되어 있는 계좌 목록(res_list) 가져와서 반복하여 복수개 계좌 접근 --%>
		<c:forEach var="accountList" items="${accountList.res_list }">
			<tr>
				<td><span class="text-sm font-weight-normal">${accountList.account_num_masked }</span></td>
				<td><span class="text-sm font-weight-normal">${accountList.bank_name }</span></td>
				<td><span class="text-sm font-weight-normal">${accountList.account_holder_type } (P:개인)</span></td>
				<td><span class="text-sm font-weight-normal">${accountList.account_type } (1:입출금)</span></td>
				<td><span class="text-sm font-weight-normal">${accountList.account_holder_name }</span></td>
				<td><span class="text-sm font-weight-normal">${accountList.account_alias }</span></td>
			</tr>
		</c:forEach>
			</tbody>
		</table>
	</div> <!-- container -->
	<br><br>
	<!-- ===================== 페이징 처리 구간 ========================== -->
	<div>
		<nav aria-label="Page navigation example">
		<ul type="none" id="pageUl"  class="pagination justify-content-center">
			
			<!-- 이전 버턴================ -->
			
			<c:if test="${pm.prev }"> 
					<!--      ㄴboolean 타입이니까 false면 걍 패스되는거~ 음 편하군  -->
				<li><a href="listPage?page=${pm.pageStart - 1 }" class="page-item" aria-label="Previous" style="color:#621fb7;">
						<span aria-hidden="true">&laquo;</span></a>
				</li>
			</c:if>
			
			<!-- 1 2 3 4 .... ================ -->
			<c:forEach var="index" begin="${pm.pageStart }" end="${pm.endPage }"> 
						<!-- 페이지 블럭에서 내가 선택한 현재 페이지만! active되도록 -->
				<%-- 
				<li <c:out value="${pm.vo.page == index? 'class=active' : '' }" />>   2.3버전 이하는 c:out 써야 함~ --%>
				<li ${pm.vo.page == index? 'class=active' : '' }  style="float: left;"  class="page-item">
					<a href="listPage?page=${index }" style="color:#621fb7;"  class="page-link" > ${index} </a>
				</li>
			</c:forEach>
			
			<!-- 다음 버턴================ -->
			<c:if test="${pm.next }">
				<li class="page-item"><a href="listPage?page=${pm.endPage + 1 }" class="page-link"  aria-label="Next" style="color:#621fb7;">
					<span aria-hidden="true">&raquo;</span></a></li>
			</c:if>
		</ul>
		</nav>
	</div>
	<!-- ===================== 페이징 처리 구간 끝 ========================== -->
</div>
</div> <!-- col-12 -->
</div> <!-- row -->



	
<%@ include file="../include/footer.jsp"%>
