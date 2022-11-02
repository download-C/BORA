<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>openbankInsert title here</title>
</head>
<body>
<h1>계좌목록</h1>
 	
<h3>계좌구분(P:개인)</h3>
<h3>계좌종류주3) 1:수시입출금, 2:예적금 6:수익증권, T:종합계좌</h3>
<hr>
	<table>
		<tr>
			<th>마스킹된 출력용 계좌번호</th>
			<th>은행명</th>
			<th>계좌구분</th>
			<th>계좌종류</th>
			<th>예금주명</th>
		</tr>
		<%-- accountList 객체에 저장되어 있는 계좌 목록(res_list) 가져와서 반복하여 복수개 계좌 접근 --%>
		<c:forEach var="accountList" items="${accountList.res_list }">
			<tr>
				<td>${accountList.account_num_masked }</td>
				<td>${accountList.bank_name }</td>
				<td>${accountList.account_holder_type }</td>
				<td>${accountList.account_type }</td>
				<td>${accountList.account_holder_name }</td>
			</tr>
		</c:forEach>
	</table>
	
	
	<hr><hr><h1>테스트</h1><hr><hr>
	
		<!-- 잔액조회  -->
	거래일시, 거래일자(참가은행), 은행이름, 계좌잔액(-금액가능), 
	출금가능금액, 상품명, 계좌개설일, 만기일, 최종거래일
	<form method="get" action="/openbank/accountBalance">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${responseToken.access_token }">
<%-- 		<input type="hidden" name="bank_tran_id" value="${accountBalance.bank_tran_id }"> --%>
		<input type="hidden" name="bank_tran_id" value="Y">
		<input type="hidden" name="fintech_use_num" value="Y">
		<input type="hidden" name="tran_dtime" value="Y">
		<input type="submit" value="계좌잔액조회">
	</form><hr>    
     
     
	<!-- 거래내역조회 -->
	<form method="get" action="/openbank/accountTran">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${responseToken.access_token }">
		<input type="hidden" name="bank_tran_id" value="Y">
		<input type="hidden" name="fintech_use_num" value="Y">
		<input type="hidden" name="inquiry_type" value="Y">
		<input type="hidden" name="inquiry_base" value="Y">
		<input type="hidden" name="from_date" value="Y">
		<input type="hidden" name="to_date" value="Y">
		<input type="hidden" name="sort_order" value="Y">
		<input type="hidden" name="tran_dtime" value="Y">
		<input type="submit" value="거래내역조회">
	</form><hr>    
     
     
	<!-- 출금이체 -->
	<form method="post" action="/openbank/tranWithdraw">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${responseToken.access_token }">
		<input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }">
		<input type="hidden" name="include_cancel_yn" value="Y">
		<input type="hidden" name="sort_order" value="D">
		<input type="submit" value="출금이체">
	</form><hr>    
	
	<!-- 입금이체 -->
	<form method="post" action="/openbank/tranDeposit">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${responseToken.access_token }">
		<input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }">
		<input type="hidden" name="include_cancel_yn" value="Y">
		<input type="hidden" name="sort_order" value="D">
		<input type="submit" value="입금이체">
	</form><hr>   
	
	<!-- 이체내역조회 -->
	<form method="post" action="/openbank/tranResult">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${responseToken.access_token }">
		<input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }">
		<input type="hidden" name="include_cancel_yn" value="Y">
		<input type="hidden" name="sort_order" value="D">
		<input type="submit" value="이체내역조회">
	</form><hr>   
	
	
	
	
	
</body>
</html>













