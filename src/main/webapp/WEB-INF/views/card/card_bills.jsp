<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>card_bills.jsp</h1>

     <table>
		<tr>
			<th>청구년월</th>
			<th>결제순번</th>
			<th>카드식별자</th>
			<th>청구금액</th>
			<th>결제년월일</th>
			<th>신용체크구분</th>
		</tr>
		<%-- cardBills 객체에 저장되어 있는 카드 목록(bill_list) 가져와서 반복하여 복수개 계좌 접근 --%>
		<c:forEach var="cardBills" items="${cardBills.bill_list }">
			<tr>
				<td>${cardBillsResponse.card_type }</td>
				<td>${cardBillsResponse.settlement_account_num }</td>
				<td>${cardBillsResponse.card_id }</td>
				<td>${cardBillsResponse.charge_amt }</td>
				<td>${cardBillsResponse.settlement_day }</td>
				<td>${cardBillsResponse.issue_date }</td>
			</tr>
	   </c:forEach>
	</table>
	
</body>
</html>