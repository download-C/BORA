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
   <h1>card_detail_bills.jsp</h1>
      
     <table border="1">
		<tr>
			<th>카드식별값</th>
			<th>사용일자</th>
			<th>사용시간</th>
			<th>이용금액</th>
			<th>가맹점명</th>
			<th>신용판매 수수료</th>
			<th>상품구분</th>
		</tr>
		<%-- cardDetailBills 객체에 저장되어 있는 카드 목록(bill_detail_list) 가져와서 반복하여 복수개 계좌 접근 --%>
		<c:forEach var="cardDetailBills" items="${cardDetailBills.bill_detail_list }">
			<tr>
				<td>${cardDetailBills.card_value }</td>
				<td>${cardDetailBills.paid_date }</td>
				<td>${cardDetailBills.paid_time }</td>
				<td>${cardDetailBills.paid_amt }</td>
				<td>${cardDetailBills.merchant_name_masked }</td>
				<td>${cardDetailBills.credit_free_amt }</td>
				<td>${cardDetailBills.product_type }</td>
			</tr>
	   </c:forEach>
	</table>
	
</body>
</html>