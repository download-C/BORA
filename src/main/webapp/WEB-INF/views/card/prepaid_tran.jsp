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
   
     <table>
		<tr>
			<th>거래유형코드</th>
			<th>거래번호</th>
			<th>거래금액</th>
			<th>거래후잔액</th>
			<th>거래대상 금융기관 공동코드</th>
			<th>거래 상대 식별값</th>
			<th>거래 부가 정보</th>
			<th>결제 또는 결제취소 가맹점명</th>
			<th>구매내역명</th>
			<th>상품 또는 서비스 구분</th>
			<th>온라인, 오프라인 결제 구분</th>
		</tr>
		<%-- prePaidTran 객체에 저장되어 있는 카드 목록(trans_list) 가져와서 반복하여 복수개 계좌 접근 --%>
		<c:forEach var="prePaid" items="${prePaidTran.trans_list }">
			<tr>
				<td>${prePaidTranResponse.trans_type }</td>
				<td>${prePaidTranResponse.trans_dtime }</td>
				<td>${prePaidTranResponse.trans_no }</td>
				<td>${prePaidTranResponse.trans_amt }</td>
				<td>${prePaidTranResponse.after_balance_amt }</td>
				<td>${prePaidTranResponse.trans_org_code }</td>
				<td>${prePaidTranResponse.trans_key }</td>
				<td>${prePaidTranResponse.merchant_name }</td>
				<td>${prePaidTranResponse.trans_title }</td>
				<td>${prePaidTranResponse.trans_category }</td>
				<td>${prePaidTranResponse.pay_method }</td>
			</tr>
	   </c:forEach>
	</table>
	
</body>
</html>