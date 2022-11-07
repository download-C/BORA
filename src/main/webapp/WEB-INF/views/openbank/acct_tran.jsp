<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>거래내역</h1>

<h3>입출금구분 입출금구분주4) (입금, 출금, 지급, 기타)_입출금구분이 ‘기타’인 경우에는 ‘거래금액’이 0원으로 세팅됨</h3>
<h3>거래유형 현금, 대체, 급여, 타행환, F/B출금 등 (참가은행에서 직접 세팅)</h3>

	<table>
		<tr>
			<th>거래일자</th>
			<th>입출금구분</th>
			<th>거래타입</th>
			<th>통장인자내용</th>
			<th>거래금액</th>
			<th>거래후잔액</th>
			<th>거래점명</th>
		</tr>
		<%-- accountList 객체에 저장되어 있는 계좌 목록(res_list) 가져와서 반복하여 복수개 계좌 접근 --%>
		<c:forEach var="accountTran" items="${accountTran.res_list }">
			<tr>
				<td>${accountTran.tran_date }</td>
				<td>${accountTran.inout_type }</td>
				<td>${accountTran.tran_type }</td>
				<td>${accountTran.print_content }</td>
				<td>${accountTran.tran_amt }</td>
				<td>${accountTran.after_balance_amt }</td>
				<td>${accountTran.branch_name }</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>