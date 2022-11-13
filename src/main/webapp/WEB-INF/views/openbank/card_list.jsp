<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
     
<!-- title -->
<div class="section-title">  
  <h2>보유 카드 목록</h2>

</div>
<!-- End title -->
 
<h1>카드목록</h1>

<h3>카드회원구분</h3>
<h3>본인/가족 구분) "1":본인, "2":가족</h3>
<h3>본인의 카드 내역만 설정</h3>
<h3>(가족카드는 카드 명의자*가 아닌 본인이 조회 요청시 설정)</h3>
<hr>

<div class="row">
  <div class="col-12">
   <div class="card-body px-0 py-0" >
    <div class="container">
     <table class="table table-hover" style="box-shadow: 7px 14px 90px 3px rgba(163, 174, 184, 0.7);">
		<thead class="bg-gray-100">
		<tr>
			<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">카드식별자</th>
			<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">카드번호</th>
			<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">상품명</th>
			<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">카드회원구분</th>
		</tr>
		</thead>
		<tbody>	
		<%-- card 객체에 저장되어 있는 카드 목록(card_list) 가져와서 반복하여 복수개 계좌 접근 --%>
		<c:forEach var="cardList" items="${cardList.card_list }">
			<tr>
			    <td><span class="text-sm font-weight-normal">${cardList.card_id }</span></td>
			    <td><span class="text-sm font-weight-normal">${cardList.card_num_masked }</span></td>
				<td><span class="text-sm font-weight-normal">${cardList.card_name }</span></td>
				<td><span class="text-sm font-weight-normal">${cardList.card_member_type }</span></td>
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

